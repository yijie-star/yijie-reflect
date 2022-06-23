/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: StringBuffer_classlibrary.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

public class StringBuffer_classlibrary {
    public static void main(String[] args) {
        /*
        定义一个stringbuffer（特点：内容允许修改）类对象，然后通过append方法向对象中添加26个消息字母，要求每次只添加一次
        共添加26次，后按照逆序的方式输出，并且可以删除前5个字符
         */
        StringBuffer suff = new StringBuffer();
        for (int i = 'a'; i < 'z'; i++) {
            suff.append((char) i);
        }
        suff.reverse().delete(0, 5);//反转处理,并删除前5个字符
        System.out.println(suff);

        /*
        stringBuffer的内容是允许被修改的，而string内容不允许修改，
         */
    }
}
