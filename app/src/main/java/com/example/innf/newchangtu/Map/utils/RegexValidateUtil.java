package com.example.innf.newchangtu.Map.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author: Inno Fang
 * Time: 2016/8/8 21:52
 * Description:用正则表达式验证邮箱和电话号码
 */

public class RegexValidateUtil {

    /**
     * 验证邮箱
     * @param email
     * @return
     */
    public static boolean checkEmail(String email){
        boolean flag = false;
        try{
            String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    /**
     * 验证手机号码
     * @param
     * @return
     */
    public static boolean checkMobileNumber(String phoneNumber){
        boolean flag = false;
        try{
            Pattern regex = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,2,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
            Matcher matcher = regex.matcher(phoneNumber);
            flag = matcher.matches();
        }catch(Exception e){
            flag = false;
        }
        return flag;
    }

    /*提取字符串中的中文*/
    public static String getChineseInString(String str){
        String regex="([\u4e00-\u9fa5]+)";
        Matcher matcher = Pattern.compile(regex).matcher(str);
        if(matcher.find()){
           return matcher.group(0);
        }
        return null;
    }
}
