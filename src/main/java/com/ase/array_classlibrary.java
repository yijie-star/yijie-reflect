/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: array_classlibrary.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

import java.util.Arrays;
import java.util.Random;

class NumberFactory{
    private static Random random = new Random();//static不需要实例化就可以使用类名直接调用
    /**
     * 通过随机数来生成一个数组的内容，该内容不包括有0
     * @param length 要开辟的数组大小
     * @return 包含有自己数字的内容
     */
    public static int [] create(int length){
        int data [] = new int[length];//开辟新的数组
        int footer = 0;
        while (footer < data.length){
            int number = random.nextInt(30);
            if (number != 0){
                data[footer ++ ] = number;//保存数据
            }
        }
        return data;
    }
}
public class array_classlibrary {
    public static void main(String[] args) {
        /*
        利用Random类产生5个1~30（包括1和30）的随机整数

         */
        int resultnumber [] = NumberFactory.create(5);
        System.out.println(Arrays.toString(resultnumber));
    }
}
