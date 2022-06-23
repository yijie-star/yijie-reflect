/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: multithreading.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;
//实现了线程的主体类
//class MyThread implements Runnable{
//    private int ticket = 5;
////    private String title;
////    public MyThread(){}
////    public MyThread(String title){
////        this.setTitle(title);
////    }
//    @Override
//    public void run() {
//        for (int i = 0; i < 100; i++) {
//            if (this.ticket > 0){
//                System.out.println(" 运行，卖票： " + this.ticket--);
//            }
//
//        }
//    }

//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//}

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class MyThea implements Callable<String>{
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("******线程执行： " + i);
        }
        return "线程执行完毕";
    }
}
public class multithreading {
    public static void main(String[] args) throws Exception{
        /*
        进程与线程：（最大的特点就是支持多线程开发）
            进程：单进程（在同一个时间段上只允许一个程序执行）
                一个程序执行的状态
            线程：是在进程基础上划分的更小的程序单元，线程是在进程基础之上创建并使用的，所以线程依赖于进程的支持
                但是线程的启动速度比进程的快很多，
            java是多线程的编程语言，所以java在进行并发访问处理的时候可以得到更高的处理性能
         */
        //如果在java之中，实现多线程的定义，那么久需要有一个专门的线程主体类进行线程的执行任务的定义
        //要求：必须实现特定的接口或者继承特定的父类才可以完成

        /*
        继承Thread类实现多线程：
            必须要覆写其中提供的run()方法，它属于线程的主方法：public void run()
            多线程要执行的功能应该在run()中进行定义，run()方法不能够直接被调用牵扯到操作系统资源的调度问题，
            要想启动多线程，必须使用start()方法完成 虽然调用的是start方法，但执行的是run方法，并且线程对象都是交替执行
         */
//        new MyThread("线程a").start();
//        new MyThread("线程b").start();
//        new MyThread("线程c").start();
        /*
        基于Runnable接口实现多线程:
            java之中继承是单局限性的，因此提供有接口实现多线程
            //从jdk1.8引入了Lambda  表达式之后就变成了函数式接口
            @FunctionalInterface
            public interface Runnable{
                public void run();
             }
             此时启动多线程：不支持(start方法的使用)
                使用Thread中提供的构造方法
                public Thread(Runnable target);
                优先考虑，并且都是通过Thread类对象启动

         */

        /*
        两者的区别：
            从代码本身来讲，使用Runnable是最为方便的，因为其可以避免单继承的局限，同时也可以更好的进行功能的扩充
            但是结构是也需要观察两者的联系：
                Thread类的定义：public class Thread extends Object implements Runnable
            可以发现Thread是Runnable的子类
            1、多线程的设计之中，使用了代理设计模式的结构，用户自定义的线程主体只是负责项目核心功能的实现，而
            辅助试下全部交由Thread类来处理
            2、在进行Thread启动多线程的时候调用的是start方法，而后找到的是run方法，当通过Thread构造方法传递
            Runnable接口对象的时候，改接口对象将被Thread中的target多保存
            3、多线程开发的本质在于多个线程可以进行同一资源的抢占。Thread主要描述的是线程，Runnable描述资源

            利用卖票程序实现多个线程额资源并发访问：
         */
//        MyThread mt = new MyThread();
//        //多个线程启动
//        new Thread(mt).start();
//        new Thread(mt).start();
//        new Thread(mt).start();
//        new Thread(mt).start();
        /*
        Callable实现多线程
        定义：
            @FunctionalInterface
            public interface Callable<V>
            public V call() throws Exception;

        可以发现Callable定义的时候可以设置一个泛型，此泛型的类型就是数据返回的类型，可以避免向下转型所带来的
        安全隐患
        案例：
         */
        FutureTask<String> task = new FutureTask<>(new MyThea());
        new Thread(task).start();
        //这个地方有异常
        System.out.println("获得线程返回数据" + task.get());
        /*
        面试题：请解释Callable与Runnable的区别
            1、Runnable是在jdk1.0的时候提出的多线程实现接口，而Callable是在jdk1.5之后提出来的
            2、java.lang.Runnable之中只提供有一个run方法，并且没有返回值
            3、java.util.concurrent.Callable提供有call方法，可以有返回值
         */

        /*
        线程的运行状态：
            1、任何一个线程的对象都应该使用Thread类进封装，所以线程的启动使用的是start方法，但是
            启动的时候实际上若干个线程都将进入到一种就绪状态，即并没有执行
            2、之后就需要等待进行资源的调度，当某一个线程调度成功之后则进入到运行状态（run方法），但是所有的线程不可能一直
            持续执行下去，中间需要产生一些暂停的状态。例如某一个线程执行一段时间后就需要让出资源进入到阻塞状态，而后进入到
            就绪状态
            3、当run方法执行完毕之后，实际上该线程的任务也就结束了，此时直接进入到停止状态
         */
    }
}
