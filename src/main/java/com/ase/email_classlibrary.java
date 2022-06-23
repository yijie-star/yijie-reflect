/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: email_classlibrary.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

import java.awt.event.FocusEvent;

class Validator{//定义一个验证处理类
    private Validator(){};
    public static boolean isEmail(String email){
        if (email == null || "".equals(email)){//数据为空
            return false;
        }
        String regex = "\\w+@\\w+\\.\\w+";//正则
        return email.matches(regex);
    }
    //Ip_classlibrary的验证处理
    public static boolean validateIP(String ip){
        if (ip ==null || "".equals(ip)){
            return false;
        }
        String regex = "([12]?[0-9]?[0-9]\\.){3}[12]?[0-9]?[0-9]";
        if (ip.matches(regex)){//验证通过，对IP进行拆分处理
            String result [] = ip.split("\\.");
            for (int i = 0; i < result.length; i++) {
                int temp = Integer.parseInt(result[i]);
                if (temp > 255){
                    return false;
                }else {
                    return true;
                }
            }
        }else {
            return false;
        }
        return true;
    }
}

public class email_classlibrary {
    public static void main(String[] args) {
        /*
        输入一个email地址，然后使用正则表达式验证该email地址是否正确
         */
        if (args.length != 1){//输入有一个参数
            System.out.println("程序执行错误，没有输入初始化的参数，正确格式为：java email_classlibrary EMAIL地址");
            System.exit(1);//系统退出
        }
        String email = args[0];//获取初始化参数
        if (Validator.isEmail(email)){
            System.out.println("输入的email的地址正确！");
        }else {
            System.out.println("输入的email的地址错误！");
        }
    }
}
