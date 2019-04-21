package com.mgt.clothes.store.utils;

/**
 * @ClassName StringUtils
 * @Description TODO
 * @Author Administrator
 * @Data 2019/2/18 3:38
 * @Version 1.0
 **/
public class StringUtils extends org.apache.commons.lang3.StringUtils {
    /**
     * 转换首字母为小写
     * @param s
     * @return
     */
    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    /**
     * 转换首字母为大写
     * @param s
     * @return
     */
    public static String toUpperCaseFirstOne(String s){
        if(Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }
}
