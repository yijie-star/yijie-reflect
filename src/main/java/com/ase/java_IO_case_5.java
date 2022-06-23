/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_IO_case_5.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

import java.util.Arrays;

public class java_IO_case_5 {
    public static void main(String[] args) {
        /*
        编写程序，当运行后，根据屏幕提示输入一个数字字符串，输入后统计有多少个偶数和奇数
         */
        System.out.println(Arrays.toString(NumberIOFactory.getInstance().stat()));
    }
}
//1、定义四INumberService接口，进行数字的处理服务
interface INumberServiceIO{
    public int[] stat();
}
//2、实现子类
class NumberSeiviceIOImpl implements INumberServiceIO{

    @Override
    public int[] stat() {
        int stat[] = new int[]{0,0};//第一个为偶数，第二个为奇数
        String str = InputUtil.getString("请输入数据：");//接收数据
        String result [] = str.split("");//空值按照每个字符拆分
        for (int i = 0; i < result.length; i++) {
            if ((Integer.parseInt(result[i]) % 2 == 0)){//将字符串转为整型后求余
                stat[0] ++;
            }else {
                stat[1] ++;
            }
        }
        return stat;
    }
}
//3、建立工程类
class NumberIOFactory{
    public static INumberServiceIO getInstance(){
        return new NumberSeiviceIOImpl();
    }
}