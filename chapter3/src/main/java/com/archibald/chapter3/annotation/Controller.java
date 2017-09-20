package com.archibald.chapter3.annotation;

import java.lang.annotation.*;

/**
 * @author: Archibald.
 * @Description: 控制器注解
 * @version:
 * @time: 9/9/2017.
 */
@Target(ElementType.TYPE)//注解适用的作用域
@Retention(RetentionPolicy.RUNTIME)//注解的生命周期，SOURCE只在源码显示，编译时会丢掉；CLASS在编译时会记录到Class中，运行时忽略；RUNTIME在运行时存在，可以通过反射读取
//@Inherited //允许子注解继承
//@Documented //生成javadoc时会包含注解
public @interface Controller {
}
