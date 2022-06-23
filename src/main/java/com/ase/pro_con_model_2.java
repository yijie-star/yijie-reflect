/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: pro_con_model_2.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;
//定义一个可操作的资源
class Resourse{
    private int num = 0;
    //加减的切换
    private boolean flag = true;
    /*
    flag = true 表示 可以进行加法操作，但是无法进行减法操作
    反之则相反
     */
    public synchronized void add() throws InterruptedException {
        if (flag == false){
            //现在需要执行减法操作，加法需要等待
            super.wait();
        }
        Thread.sleep(100);
        this.num ++ ;
        System.out.println("加法操作：" + Thread.currentThread().getName() + "num = " + this.num );
        //加法操作执行完毕，需要执行减法
        //唤醒全部线程
        this.flag = false;
        super.notifyAll();
    }
    public synchronized void sub() throws InterruptedException {
        if (flag == true){
            //减法需要等待
            super.wait();
        }
        Thread.sleep(200);
        this.num -- ;
        System.out.println("减法操作：" + Thread.currentThread().getName() + "num = " + this.num );
        this.flag = true;
        super.notifyAll();
    }
}
class AddThread implements Runnable{
    private Resourse resourse;
    public AddThread (Resourse resourse){
        this.resourse = resourse;
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                this.resourse.add();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class SubThread implements Runnable{
    private Resourse resourse;
    public SubThread (Resourse resourse){
        this.resourse = resourse;
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                this.resourse.sub();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class pro_con_model_2 {
    public static void main(String[] args) {
        /*
        多线程案例一：
            设计4个线程对象，两个线程执行减操作，两个线程执行加操作
         */
        Resourse resourse = new Resourse();
        AddThread at = new AddThread(resourse);
        SubThread st = new SubThread(resourse);
        new Thread(at,"加法线程-A").start();
        new Thread(at,"加法线程-B").start();
        new Thread(st,"减法线程-A").start();
        new Thread(st,"减法线程-B").start();
        /*
        核心在于：加一个减一个
         */
    }
}
