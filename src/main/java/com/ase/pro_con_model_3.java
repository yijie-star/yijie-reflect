/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: pro_con_model_3.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

class Copter{
    //表示生产个数
    private static int count = 0;
    private String name;
    private double price;
    public Copter(String name,double price){
        this.setName(name);
        this.setPrice(price);
        count++;
    }
    public String toString(){
      return  "第【" + count + "】台电脑" + "电脑名字：" + this.name + " 价格：" + this.price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
class Recos{
    //标记
    private boolean flag = true;
    private Copter copter;
    public synchronized void make() throws InterruptedException {
        if (this.copter != null){
            //已经生产过了
            super.wait();
        }
        this.copter = new Copter("戴尔", 300);
        //this.copter.toString();
        this.flag = false;
        super.notifyAll();
    }
    public synchronized void get() throws InterruptedException {
        if (this.copter == null){
            //没有生产过
            super.wait();
        }
        //取走
        this.copter = null;
        super.notifyAll();
    }
}
class Prod implements Runnable{
    private Recos recos;
    public Prod (Recos recos){
        this.recos = recos;
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                this.recos.make();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
class Cosn implements Runnable{
    private Recos recos;
    public Cosn (Recos recos){
        this.recos = recos;
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                this.recos.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class pro_con_model_3 {
    public static void main(String[] args) {
        /*
        设计一个生产电脑和搬运电脑类，要求生产出一台电脑就搬走一台电脑，如果没有新的电脑出来则需要等待新电脑生产出来，
        如果生产的电脑没有搬走，需要等待搬走在进行生产，并统计 生产电脑的数量
         */
        Recos rs = new Recos();
        new Thread(new Prod(rs)).start();
        new Thread(new Cosn(rs)).start();
    }
}
