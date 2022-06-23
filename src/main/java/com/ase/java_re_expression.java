/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_re_expression.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;



public class java_re_expression {
    public static void main(String[] args) {
        /*
          正则表达式：提供有java.util.Regex开发包 ，并对string类进行了修改，使其可以有方法直接支持正则处理
            特点：方便进行验证处理以及方便进行复杂字符串的修改处理

          String万能的功能，新项目开发之中，只要是用户输入的信息，基本上都用string表示，
          保证转换的正确性，需要进行一些复杂的验证处理，单纯依靠string类中的方法是非常麻烦的
           String string = "123";
            if (isNumber(string)){
                int number = Integer.parseInt(string);
                System.out.println(number * 2);
            }
            使用正则表达式：
            String string = "123";
        if (string.matches("\\d+")){
            int number = Integer.parseInt(string);
            System.out.println(number * 2);
        }
         */
//        String string = "123";
//        if (string.matches("\\d+")){
//            int number = Integer.parseInt(string);
//            System.out.println(number * 2);
//        }
        /*
        常用的正则标记：
            提供有java.util.Regex开发包，包里提供Patten程序类，定义有所有支持的正则标记

            【数量单个】字符匹配：
                x任意字符：表示有任意字符组成；
                \\：匹配“\”；

         */
        /*
        string类对正则的支持：
            public boolean matches(String regex)：将指定字符串进行正则判断
            public String replaceAll(String regex,String replacement)：替换全部
            public String replaceFirst(String regex,String replacement)：替换首个
            public String[] split(String regex)：正则拆分
            public String[] split(String regex, int limit)：正则拆分
            案例：实现email地址格式的验证
            jetbrains://idea/navigate/reference?project=Java Project&path=Itellyou/正则验证.png
                email的用户名可以由字母、数字、_(不能使用在开头)、所组成
                email的域名可以由字母、数字、_、- 组成
                域名的后缀必须是：.cn , .com , .net , .com.cn , .gov ,
            正则表达式无法对里面的内容进行判断，只能够对格式进行判断处理
         */
        /*
        java.util.Regex开发包的使用：
            定义有两个类：Pattern（正则表达式编译）、Matcher(匹配类)实例化依靠Pattern类完成，分组的功能string不具备
         */
    }
    public static boolean isNumber(String str){
        char data []= str.toCharArray();
        for (int i = 0; i < data.length; i++) {
            if (data[i] > '9' || data[i] < '0'){
                return false;
            }
        }
        return true;
    }
}
