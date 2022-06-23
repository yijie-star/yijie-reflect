/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: polymorphic.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

class Message{
    public void print(){
        System.out.println("www.mldn.cn");

    }
}

class DatabaseMessage extends Message{
    public void print(){
        System.out.println("连接信息！");

    }
}
public class polymorphic {
    public static void main(String[] args) {
        /**
         * 是面向对象的第三大特性，可以实现父子类之间的转换处理
         * 基本概念：两种实现模式
         *      第一：方法的多态性-
         *          方法的重载：同一个方法名称可以根据传入的参数的类型或个数的不同，实现不同功能的执行
         *          方法的覆写：同一个方法可能根据使用子类的不同有不同的实现
         *      第二：对象的多态性-父子实例之间的转换处理
         *           对象的向上转型： 父类 父类实例 = 子类实例; 自动完成转换
         *           对象的向下转型： 子类 子类实例 = (子类)父类实例; 强制完成转换
         *
         *           从转型处理来讲：大部分考虑最多的一定是对象的向上转型（90%）
         *           String类不会考虑转型
         */



        /*
        对象转型处理了属于多态性，而这一特性是在继承性的基础上实现的
         */
        //Message msg = new DatabaseMessage();  向上转型    主要看new
        /*
        主要的用处：可以对参数进行统一的设计，传入不同的参数，调用不同的重写的方法
        接受和返回参数的统一性
         */

        DatabaseMessage msg = new DatabaseMessage();
        msg.print();


        //向上描述的是一些公共的特征，向下描述的的子类自己特殊的定义环境（并不是安全的事情）
        /*
        向下转型：为了保证向下转型的正确性，在转型之前进行判断，判断某个实例是否是某个类的对象
        需要通过instanceo关键字实现

        对象 instanceo 类
        该判断将会返回boolean类型，true - 表示实例是指定类对象 false  - 表示
         */


    }
}
