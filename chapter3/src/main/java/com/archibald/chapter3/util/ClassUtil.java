package com.archibald.chapter3.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author: Archibald.
 * @Description: 类操作类
 *
 * @version:
 * @time: 9/2/2017.
 */
public final class ClassUtil {
    public static final Logger LOGGER = LoggerFactory.getLogger(ClassUtil.class);

    public static ClassLoader getClassLoader(){
        /**
        * @Author: Archibald
        * @Date: 3:48 PM 9/2/2017
        *
        * @Description: 获取类加载器
        * @Param: []
        * @Return: java.lang.ClassLoader
        */
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class<?>loadClass(String className,boolean isInitialized){
        /**
        * @Author: Archibald
        * @Date: 3:49 PM 9/2/2017
        *
        * @Description: 加载类
        * @Param: [className, isInitialized]
        * @Return: java.lang.Class<?>
        */
        Class<?> cls;
        try {
            cls = Class.forName(className,isInitialized,getClassLoader());
        } catch (ClassNotFoundException e) {
            LOGGER.error("load class failure",e);
            throw new RuntimeException(e);
        }
        return cls;
    }

    public static Set<Class<?>>getClassSet(String packageName){
        /**
        * @Author: Archibald
        * @Date: 3:50 PM 9/2/2017
        *
        * @Description: 获取指定包名下的所有类
         * 需要根据包名并将其转换为文件路径
         * 读取class文件或jar包
         *
        * @Param: [packageName]
        * @Return: java.util.Set<java.lang.Class<?>>
        */
        Set<Class<?>>classSet = new HashSet<Class<?>>();
        try {
            Enumeration<URL>urls = getClassLoader().getResources(packageName.replace(".","/"));
            while (urls.hasMoreElements()){
                URL url = urls.nextElement();
                if (url != null){
                    String protocol = url.getProtocol();
                    if (protocol.equals("file")){
                        String packagePath = url.getPath().replaceAll("%20"," ");
                        addClass(classSet,packagePath,packageName);
                    }else if (protocol.equals("jar")){
                        JarURLConnection jarURLConnection = (JarURLConnection)url.openConnection();
                        if (jarURLConnection != null){
                            JarFile jarFile = jarURLConnection.getJarFile();
                            if (jarFile != null){
                                Enumeration<JarEntry>jarEntries = jarFile.entries();
                                while (jarEntries.hasMoreElements()){
                                    JarEntry jarEntry = jarEntries.nextElement();
                                    String jarEntryName = jarEntry.getName();
                                    if (jarEntryName.endsWith(".class")){
                                        String className = jarEntryName.substring(0,jarEntryName.lastIndexOf(".")).replaceAll("/",".");
                                        doAddClass(classSet,className);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("get class set failure",e);
            throw new RuntimeException(e);
        }
        return classSet;

    }
    public static void addClass(Set<Class<?>>classSet,String packagePath,String packageName){
        final File[] files = new File(packagePath).listFiles(new FileFilter() {
            public boolean accept(File file) {
                return (file.isFile() && file.getName().endsWith(".class")) || file.isDirectory();
            }
        });
        for (File file : files){
            String filename = file.getName();
            if (file.isFile()){
                String className = filename.substring(0,filename.lastIndexOf("."));
                if (StringUtil.isNotEmpty(packageName)){
                    className = packageName + "." + className;
                }
                doAddClass(classSet,className);
            }else {
                String subPackagePath = filename;
                if (StringUtil.isNotEmpty(packagePath)){
                    subPackagePath=packagePath + "/" + subPackagePath;
                }
                String subPackageName = filename;
                if (StringUtil.isNotEmpty(packageName)){
                    subPackageName = packageName + "." + subPackageName;
                }
                addClass(classSet,subPackagePath,subPackageName);
            }
        }
    }

    public static void doAddClass(Set<Class<?>>classSet,String className){
        Class<?>cls = loadClass(className,false);
        classSet.add(cls);
    }

}
