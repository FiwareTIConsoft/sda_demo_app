package com.tilab.ca.sda.sda_demo_app.utils;


public class StringUtils {
    
    public static boolean isBlank(String str){
        return str==null || str.isEmpty();
    }
    
    public static boolean isNotBlank(String str){
        return !isBlank(str);
    }
}
