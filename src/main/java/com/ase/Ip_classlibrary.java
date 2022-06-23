/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: Ip_classlibrary.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;


public class Ip_classlibrary {
    public static void main(String[] args) {
        /*
        编写一个正则表达式，判断给定的是否是一个合法的IP地址
         */
        String str = "192.168.45.555";
        System.out.println(Validator.validateIP(str));
    }
}
