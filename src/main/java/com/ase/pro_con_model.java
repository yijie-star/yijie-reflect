/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: pro_con_model.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;
class Producer implements Runnable{
    private Messages msg;

    public Producer(Messages msg){
        this.msg = msg;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                this.msg.set("王建","大帅哥");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //this.msg.setContent("大帅哥");
            } else {
                this.msg.set("小高","猥琐第一人");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                //this.msg.setContent("猥琐第一人");
            }

        }
    }
}
class Consumer implements Runnable{
    private Messages msg;
    public Consumer (Messages msg){
        this.msg = msg;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(this.msg.get());
        }
    }
}
class Messages{
    private String title;
    private String content;

    //表示生产或消费的形式  ture 允许生产  不允许消费
            //           false 允许消费  不允许生产
    private boolean flag = true;
    //解决数据同步
    public synchronized void set(String title,String content){
        if (this.flag == false){
            //无法进行生产，应等待被消费
            try {
                super.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.title = title;
        this.content = content;
        //已经生产过了
        this.flag = false;
        //唤醒等待的线程
        super.notify();
    }
    public synchronized String get(){
        if (this.flag == true){
            //还未生产，需要等待
            try {
                super.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            return this.title + " - " + this.content;
        }finally {
            //无论如何都要执行  继续生产
            this.flag = true;
            //唤醒线程
            super.notify();

        }

    }

//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getContent() {
//        return content;
//    }
}
public class pro_con_model {
    public static void main(String[] args) {
        /*
        生产者与消费者案例：
            流程：
                1、生产者负责信息内容的生产
                2、每当生产者完成一项完整的信息之后消费者要从这里面取走信息
                3、如果生产者没有生产完则消费者要等待它生产完成，如果消费者没有对信息进行消费则生产者应该等待先锋者处理完成后
                再继续生产
                基本实现：
                    定义为两个独立的线程对象对于现在的生产数据有以下的操作：
                        数据一：title = 我望见，content =
                        数据二：
                    数据保存的集中点：Message
         */
        Messages msg = new Messages();
        //启动生产者线程
        new Thread(new Producer(msg)).start();
        //启动消费者线程
        new Thread(new Consumer(msg)).start();
        /*
        执行后两个问题：
            1、数据不同步；
            2、生产一个取走一个，但是有重复正产重负取出的问题
         */
        /*
        解决数据同步：（在Message中完成）
            在进行同步处理的时候肯需要有一个同步的处理对象，此时肯定要将同步操作交由Message类处理是最近合适的
         */
        /*
        解决重复操作问题：（通过Message类完成）
            解决方案就是使用等待与唤醒机制
                主要依赖的是Object类中提供的方法处理：
                等待机制
                       死等：public final void wait() throws InterruptedException
                       设置等待时间：public final void wait(long timeoutMillis, int nanos) throws InterruptedException
                       设置等待时间：public final void wait(long timeoutMillis,nanos) throws InterruptedException
                唤醒（第一个等待线程）：public final void notify()
                唤醒所有线程：public final void notifyAll()
         */
        /*
        此代码吗就是多线程开发最原始的处理方法，整个等待、同步、唤醒机制都有开发者自行控制
         */
    }
}
