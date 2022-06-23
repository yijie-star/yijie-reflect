/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: stringMethod.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

public class stringMethod {
    public static void main(String[] args) {
//        javaDoc简介：
//        字符创与字符
//        字符创与字节数组之间也可以实现转换操作，当进行转换时，目的是进行二进制的传输或者进行编码转换
//        String str = "Hello Word";
//        将字符串变为字节数组
//        byte data[] = str.getBytes(StandardCharsets.UTF_8);
//        for (int i = 10 ; i < data.length ; i++){
//            data[i] -= 32;
//
//        }
//        System.out.println(new String(data));
//        System.out.println(new String(data,0,5));
        //字节本身是有长度限制的一个字节最多可以保存的范围是 -128~127 之间

//        字符串比较
//        主要用的方法是equals()方法，主要的是有大小写之分的,另外的比较方法：
//        compareTo():进行字符串大小写比较，会返回一个int类型的的数据：取值 大于（>0）,小于（<0）,等于（=0）
        //compareToIgnoreCase(strB)：忽略大小写的比较

//        String strA = "m";
//        String strB = "M";
//        System.out.println(strA.equals(strB));
        //不区分大小写比较
//        System.out.println(strA.equalsIgnoreCase(strB));
//        System.out.println(strA.compareTo(strB));
//        System.out.println(strA.compareToIgnoreCase(strB));

//        字符串查找
//        如下的几个查找方法
        //public public boolean contains(String s): 判断子字符创是否存在
        //public int indexOf(String str): 从头查找指定字符串的位置，找不到返回-1
        //javadocs 上有


        //字符串替换的方法：
        //public String replaceAll(String regex,String replacement):全部替换
        //public String replaceFirst(String regex,String replacement):替换首个

        //字符串拆分

        //字符串截取

        //字符串格式化

        //String类里还提供了很多的方法

    }
}
