package com.archibald.chapter3.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author: Archibald.
 * @Description: 数组工具类
 * @version:
 * @time: 9/14/2017.
 */
public final class ArrayUtil {

    /**
     * 判断数组是否非空
     */
    public static boolean isNotEmpty(Object[] array){
        return !ArrayUtils.isEmpty(array);
    }

    /**
     * 判断数组是否为空
     */
    public static boolean isEmpty(Object[] array){
        return ArrayUtils.isEmpty((array));
    }
}