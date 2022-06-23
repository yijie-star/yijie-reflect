/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: object_oriented.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

class Person{
    private String name;
    private int age;
    public void tell(){
        System.out.println("姓名：" + name +"\n" + "年龄：" + age);
    }
    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
    public void setAge(int n){
        if (n>=0){
            age = n;
        }
    }
    public int getAge(){
        return age;
    }
//    定义构造方法
    public Person(String n,int a){
        name = n;
        age = a;
    }
}

public class object_oriented {
    public static void main(String[] args) {
//        面向对象：标准模块化设计并且可以重用配置
//        封装性：内部的操作对外部不可见，安全
//                继承性：在已有结构的基础上继续进行功能的扩充
//                    多态性：在继承性的基础上扩充而来的额概念，指的是类型的转换处理
//        OOA:面向对象分析
//                OOD：面向对象设计
//                OOP：面向对象编程
//        类和对象：类是对一类事物的共性的抽象概念，而对象描述的是一个具体的产物  类是模板，对象是实例
//        类：两个部分组成
//                成员属性（Field）：年龄，姓名，性别
//                成员行为（操作方法Method）：定义对象处理的行为
//                可以唱歌，游泳等
//        在Java中，类是一个独立体，需使用class来定义
//        要使用类，那必须使用对象来完成，如果要产生对象，那必须使用如下的两个方法来完成
//
//        1、声明并实例化对象
//                类名称 对象名称 = new 类名称();
//        2、分步骤完成
//                声明对象：类名称 对象名称 = null;
//                实例化对象：对象名称 = new 类名称();
        //声明并实例化对象
        Person per = new Person("覃义",22);

//        当获取了实例化对象之后，那么就需要通过对象进行类中的操作调用，有两种调用方式
//        1、调用类中的属性：实例化对象.成员属性;（要么赋值要么输出）
//        2、调用类中的方法：实例化对象.方法名();
//
//
//        封装后对外部不可见
//        per.name = "覃义";
//        per.age = 22;
//
//        进行方法的调用
        per.setName("覃义");
        per.setAge(20);
        per.tell();

//        内存分析：最常用的内存空间
//                堆内存：保存的是对象的具体信息，在程序之中，堆内存的开辟是通过new完成的
//                栈内存：保存的是一块堆内存的地址

//        成员属性的封装（方法不需封装）：private关键字对属性进行封装处理
//        外部不可直接访问：即不可见
//        使外部可以访问封装的属性，在java开发标准中有一下要求：
//            set,get 设置和取得可以使用setXxx(),getXxx()方法
//                以 private String name 为例:
//                    设置属性的方法：public void setName(String n){}
//                    获取属性的方法：public void getName(){}
//        类中的所有属性都必须使用 private 封装


//        构造方法与匿名对象：通过构造方法实现实例化对象的初始化处理，在关键字new时使用
//        要求：(一个类至少存在有一个构造方法，永恒存在) 能重载：只需考虑参数的类型及个数即可 多个构造方法重载时，建议按照参数的个数降序排列
//        自定义的构造方法不用void来进行定义，目的是区分普通方法和构造方法
//        构造方法名必须与类方法名保持一致
//                构造方法不允许设置任何的返回值类型，即：没有返回值定义
//                构造方法是在使用关键字new实例化对象的时候自动调用的



    }

}
