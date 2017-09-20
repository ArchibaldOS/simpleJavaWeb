package com.archibald.chapter3.helper;

import com.archibald.chapter3.annotation.Inject;
import com.archibald.chapter3.util.ArrayUtil;
import com.archibald.chapter3.util.CollectionUtil;
import com.archibald.chapter3.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author: Archibald.
 * @Description: 依赖注入助手类
 * @version:
 * @time: 9/14/2017.
 */
public final class IocHelper {
    static {
        //获取所有的Bean类与Bean实例之间的映射关系
        Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)){
            //遍历Bean Map
            for (Map.Entry<Class<?>,Object> beanEntry:beanMap.entrySet()){
                //从BeanMap中获取Bean类与Bean实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                //获取Bean类定义的所有成员变量（Bean Field）
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)){
                    //遍历Bean Field
                    for (Field beanFiled:beanFields){
                        //判断当前Bean Field 是否带有Inject注解
                        if (beanFiled.isAnnotationPresent((Inject.class))){
                            //在BeanMap中获取Bean Field对应的实例
                            Class<?> beanFieldClass = beanFiled.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null){
                                //通过反射初始化BeanField的值
                                ReflectionUtil.setField(beanInstance,beanFiled,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}

