/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_devlo.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

import java.util.Timer;
import java.util.TimerTask;

class sge{
    //要发送的消息
    private String info;

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
class Cnel{
    //消息发送通道
    private static sge sge;
    private Cnel(){}
    public static void setSge(sge s){
        sge = s;
    }
    public static void send(){
        System.out.println("消息" + Thread.currentThread().getName() + "发送：" + sge.getInfo());
    }
}

class MyTask extends TimerTask{

    @Override
    public void run() {
        //多线程的处理方法
        System.out.println(Thread.currentThread().getName() + " 定时任务执行，当前时间：" + System.currentTimeMillis());
    }
}
public class java_devlo {
    public static void main(String[] args) {
        /*
        UUID类：是一种生成无重复字符串的一种程序类
            获取UUID对象：public static UUID randomUUID()
            根据字符串获取UUID内容：public static UUID fromString(String name)
            在对一些文件进行自动命名的时候，非常好用
         */
        /*
        Optional类：进行空的处理
        传统往往都是进行被动的判断，
        处理空，常用
         */
        /*
        ThreadLocal类：每个线程通过ThreadLocal只允许保存一个数据
            定义一个结构：可以 解决线程同步问题

         */
//        for (int i = 0; i < 3; i++) {
//
//        }
//        sge sge = new sge();
//        sge.setInfo("xiaobing");
//        Cnel.setSge(sge);
//        Cnel.send(); //当前程序单线程

        /*
        定时调度：进行定时任务的处理，只是实现一种间隔触发的操作
            java.util.TimerTask类：实现定时任务处理
            java.util.Timer类：
            实现定时任务处理
         */
//        Timer timer = new Timer();
//        timer.schedule(new MyTask(), 0);//立即启动，可以设置间隔触发

        /*
        Base64加密与解密
            Base64.Encoder：进行加密处理
                加密处理：public byte[] encode(byte[] src)
            Base64.Decoder：进行解密处理
                解密处理：public byte[] decode(byte[] src)
                是一个公版的算法操作，为了安全，使用盐值操作，也不是很安全，多次加密
         */
    }
}
