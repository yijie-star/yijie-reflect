/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: inherit.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

class Po{
    private String name;

    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }


}
//没必要再写一个学生类
//现 su 是子类
class su extends Po{
    //子类扩充的属性
    private String school;

    public void setSchool(String school) {
        this.school = school;
    }
    public String getSchool() {
        return this.school;
    }


}
public class inherit {
//    面向对象的第二大特征-继承，特点在于可以扩充已有类的功能
    //在java开发中要实现继承关系，就必须使用到extends关键字来完成，语法如下：class 子类  extends 父类{}
    //注意的是：会把子类成为派生类，把父类成为超累（SuperClass）
//    基本实现
    public static void main(String[] args) {
        su su = new su();
//        方法是Po类定义的，即父类定义 子类实例化要求：子类实例化时（会自动实例化父类），一定要首先实例化父类对象
        //super() ：表示子类 构造方法调用父类构造方法，写与不写一样，写了就必须放在子类构造方法的首行，并且只会调用无参构造方法
        //所以必须提供无参构造方法

        //super()和this都可以调用构造方法，super用于调用父类构造，this调用子类，但super优先于this，都放在首行，但不能同时出现
        su.setName("林正英");
        su.setAge(46);
        su.setSchool("玉溪师范学院");
        System.out.println("姓名：" + su.getName() + " 年龄：" + su.getAge() + " 学校：" + su.getSchool());

//
//        要求：
//        1、java之中不允许多重继承，只允许多层继承
                //错误继承
//                class A{}
//                class B{}
//                class C extends A,B{}
//                2、在进行继承关系定义的时候，实际上子类可以继承父类中的所有的操作结构，但是对于私有操作
//                属于隐式继承，非私有为显示继承




    }


}
