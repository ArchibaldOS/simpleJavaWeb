package com.archibald.chapter3.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Archibald
 * @version:
 * @time: 6/4/2017.
 *
 * 这是一个属性文件工具类，用于读取config.properties
 */
public final class PropsUtil {
    //需要导入一个jar包 slf4j-api.jar
    //记录日志的，封装好的一个包，通过配置文件配置，在程序中直接调用，记录需要记录的日志
    // 一般日志保存在文件中
    //使用指定类初始化日志对象
    public static final Logger LOGGER = (Logger) LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载属性文件
     */
    public static Properties loadProps(String fileName){
        Properties props = null;
        InputStream is =null;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is == null) {
                throw new FileNotFoundException(fileName + "file is not found");
            }
            props = new Properties();
            props.load(is);
        } catch (IOException e) {
            LOGGER.error("load properties file failure",e);
        }finally {
            if (is != null){
                try {
                    is.close();
                }
                catch (IOException e){
                    LOGGER.error("close input stream failure",e);
                }
            }
        }
        return props;
    }

    /**
     * 获取字符型属性（默认值为空字符串）
     */
    public static String getString(Properties props,String key){
        return getString(props,key,"");
    }

    /**
     * 获取字符型属性（可指定默认值）
     */
    private static String getString(Properties props, String key, String defaultValue) {
        String value = defaultValue;
        if (props.containsKey(key)){
            value = props.getProperty(key);
        }
        return value;
    }
    /**
     *  获取数值型属性（默认值为0）
     */
    public static int getInt(Properties props,String key){
        return getInt(props,key,0);
    }

    /**
     *  获取数值型属性（可指定默认值）
     */
    private static int getInt(Properties props, String key, int defaultValue) {
        int value = defaultValue;
        if (props.containsKey(key)){
            value = CastUtil.castInt(props.getProperty(key));
        }
        return value;
    }

    /**
     * 获取布尔型属性（默认值为false）
     */
    public static boolean getBoolean(Properties props,String key){
        return getBoolean(props,key,false);
    }

    /**
     *  获取布尔型属性（可指定默认值）
     */
    private static boolean getBoolean(Properties props, String key, boolean defaultValue) {
        boolean value = defaultValue;
        if (props.containsKey(key)){
            value = CastUtil.castBoolean(props.getProperty(key));
        }
        return value;
    }

}
