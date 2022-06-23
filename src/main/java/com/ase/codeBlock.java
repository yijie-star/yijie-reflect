/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: codeBlock.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

public class codeBlock {
    public static void main(String[] args) {
//        在程序这种使用“{}”定义的结构就称为代码块,根据代码块出现的位置以及定义的关键字的不同  代码块可以分为：
//        普通代码块:定义在一个方法中的代码

//        相同名称的变量不能在同一个方法中出现,但是如果有界限可以出现
    {
//        局部变量
        int x = 10 ;
        System.out.println("x = " +x);
    }
//    全局变量:相对的概念，位置有可能不同
    int x = 100 ;
    System.out.println("x = "+x);


//        构造块:定义在一个类中的
//        构造块会优先于构造方法执行,并且每一次实例化对象的时候都会调用构造块中的代码吗



//        静态块：使用static定义的代码块
//        静态代码块最先执行且只执行一次
//        在主类中定义的形式：优先于主方法执行



//        同步代码块：多线程时讲解
    }
}
