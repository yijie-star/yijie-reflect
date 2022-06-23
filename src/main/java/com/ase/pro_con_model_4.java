/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: pro_con_model_4.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MThred implements Callable<String>{
    private boolean flag = false;
    @Override
    public String call() throws Exception {
        //数据同步
        synchronized (this){
            if (this.flag == false){
                this.flag = true;
                //抢答成功
                return Thread.currentThread().getName() + "抢答成功";
            }else {
                return Thread.currentThread().getName() + "抢答失败";
            }
        }
    }
}
public class pro_con_model_4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        实现一个竞拍抢答程序：要求设置三个抢答者（三个线程），而后同时发布命令，抢答成功给出成功提示
        未抢答成功者给出失败提示
        多线程由于牵扯到数据的 返回问题，那么最好Callable是比较方便的处理形式,有返回值
         */
        MThred md = new MThred();
        FutureTask<String> task = new FutureTask<>(md);
        new Thread(task,"竞赛者A").start();
        new Thread(task,"竞赛者B").start();
        new Thread(task,"竞赛者C").start();
        System.out.println(task.get());

    }
}
