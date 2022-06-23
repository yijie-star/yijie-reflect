/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: multithreading_op.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;



class MyT implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
public class multithreading_op {
    public static void main(String[] args) {
        /*
        多线程常用的操作方法：都在Thread中
        1、线程的命名与取得：
            多线程的运行状态是不确定的，为了能够获取到某一些线程，只能通过名字来进行操作
            线程名称的处理：
                构造方法：public Thread(Runnable target, String name)
                取得名字：public final String getName()
                设置名字（修改）：public final void setName(String name)

                获取当前线程：public static Thread currentThread()
                当开发者为线程设置名字的时候，就使用设置的名字，若没有，则会自动生成一个不重复的名字
         */
        MyT mt = new MyT();
        new Thread(mt,"线程A").start();
//        new Thread(mt).start();
//        new Thread(mt,"线程C").start();
        /*
        对象直接调用run方法  说明主方法也是一个线程
        在任何的开发之中，主线程可以创建若干个子线程：将一些复杂逻辑或耗时的程序交由子线程处理
        每当使用java命令的时候，就表示启动了一个JVM进程 可以启动若干个JVM进程

        主线程负责处理整体流程，而子线程负责处理耗时操作
         */
//        mt.run();
        /*
        线程的休眠：
            在Thread中定义的休眠方法如下：
                1、休眠：（毫秒）public static void sleep(long millis) throws InterruptedException
                2、休眠：（毫秒、纳秒）：public static void sleep(long millis,int nanos) throws InterruptedException
            在进行休眠的时候，有可能会产生休眠的异常“InterruptedException”属于Exception的子类--必须进行处理

            主要特点：可以自动实现线程的唤醒，以继续进行后续的处理  需要注意：如果有多个线程对象休眠也是有先后顺序的
         */
        /*
        线程中断：
            中断的方法：public void interrupt()
         */
        /*
        先获得主线程，才可以通过其他线程强制执行
        线程强制执行：public final void join() throws InterruptedException
         */
        /*
        线程的礼让：public static void yield()

         */
        /*
        线程的优先级：
            优先级的处理方法：
                设置优先级：public final void setPriority(int newPriority)
                获取优先级：public final int getPriority()
            在   进行优先级定义的时候都是通过int型的数字来完成的，而对于此数字的选择Thread类就定义有三个方法（常量）：
                public static final int MAX_PRIORITY 10
                public static final int MIN_PRIORITY  1
                public static final int NORM_PRIORITY  5

                但不是绝对性的先执行，主线程属于中等优先级，默认创建的线程也是中等优先级
         */
        /*
        线程同步与死锁：
            线程同步处理：关键是锁--当某一个线程执行操作的时候，其他线程外面等待；
            实现锁的功能：使用synchronized关键字来实现，可以定义同步方法或代码块
            synchronized（同步对象）{
                同步代码操作
            }
            采用当前对象进行处理：this
            同步会造成性能的降低
                解决：在方法定义上使用synchronized关键字即可--同步方法（大多）

                死锁：
                    有可能会造成死锁的情况
         */
    }
}
