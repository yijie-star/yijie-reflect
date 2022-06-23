/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: pro_con_model_1.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

public class pro_con_model_1 {
    public static boolean flag = true;
    public static void main(String[] args) {
        /*
        优雅的停止线程
            Thread中提供有start方法启动线程，也提供有stop方法停止线程（过期）也不建议使用---有可能会导致线程的死锁
            线程柔和的停止：
         */

        new Thread(()->{
            long num = 0;

            while (flag){
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "正在运行 num = " + num ++);
            }
        },"执行线程").start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        flag = false;
        /*
        后台守护线程：
            Thread类之中提供有如下守护线程的方法：
                设置为守护线程：public final void setDaemon(boolean on)
                判断是否为守护线程：public final boolean isDaemon()
                程序执行完毕了，守护线程也就消失了
         */
        /*
        volatile关键字主要是在属性定义上使用的。表示此属性为直接数据操作，不进行副本的拷贝处理
        在进行变量处理的时候会经历一下步骤：
            1、获取变量原有的数据内容副本
            2、为变量进行数学计算
            3、将计算后的变量保存到原始空间之中
         */
        /*
        面试题：请解释volatile与synchronized的区别？
            1、volatile主要在属性上使用，synchronized在代码块与方法上使用
            2、volatile无法描述同步的处理 ，它只是一种直接内存的处理，避免副本的操作。synchronized实现同步
         */
    }
}
