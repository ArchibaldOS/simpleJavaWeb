package com.archibald.chapter3.helper;

import com.archibald.chapter3.ConfigConstant;
import com.archibald.chapter3.util.PropsUtil;

import java.util.Properties;

/**
 * 属性文件助手类
 * @author Archibald
 * @version:
 * @time: 9/2/2017.
 */
public final class ConfigHelper {
    public static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    public static String getJdbcDriver(){
        /**
        * @Author: Caihongyang
        * @Date: 3:28 PM 9/2/2017
        *
        * @Description: 获取JDBC驱动
        * @Param: []
        * @Return: java.lang.String
        */
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_DRIVER);
    }

    public static String getJdbcUrl(){
        /**
        * @Author: Caihongyang
        * @Date: 3:32 PM 9/2/2017
        *
        * @Description: 获取JDBC URL
        * @Param: []
        * @Return: java.lang.String
        */
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_URL);
    }

    public static String getJdbcUsername(){
        /**
        * @Author: Caihongyang
        * @Date: 3:33 PM 9/2/2017
        *
        * @Description: 获取JDBC 用户名
        * @Param: []
        * @Return: java.lang.String
        */
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_USERNAME);
    }

    public static String getJdbcPassword(){
        /**
        * @Author: Caihongyang
        * @Date: 3:34 PM 9/2/2017
        *
        * @Description: 获取JDBC 密码
        * @Param: []
        * @Return: java.lang.String
        */
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_PASSWORD);
    }

    public static String getappBasePackage(){
        /**
        * @Author: Caihongyang
        * @Date: 3:36 PM 9/2/2017
        *
        * @Description: 获取基础包名
        * @Param: []
        * @Return: java.lang.String
        */
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_BASE_PACKAGE);
    }

    public static String getAppJspPath(){
        /**
        * @Author: Caihongyang
        * @Date: 3:37 PM 9/2/2017
        *
        * @Description: 获取JSP路径
        * @Param: []
        * @Return: java.lang.String
        */
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_JSP_PATH);
    }

    public static String getAssetPath(){
        /**
        * @Author: Caihongyang
        * @Date: 3:38 PM 9/2/2017
        *
        * @Description: 获取静态资源路径
        * @Param: []
        * @Return: java.lang.String
        */
        return PropsUtil.getString(CONFIG_PROPS,ConfigConstant.APP_ASSET_PATH);
    }
}
