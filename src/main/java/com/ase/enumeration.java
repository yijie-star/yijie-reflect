/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: enumeration.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;
interface IMe{
    public String getMe();
}
//枚举类
enum Clor implements IMe{
    //实例化对象  必须写在第一行
    RED("红色"),GREEN("绿色"),BLUE("蓝色");
    private String title;
    //构造方法私有化
    private Clor(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }

    @Override
    public String getMe() {
        return this.title;
    }
}

public class enumeration {
    public static void main(String[] args) {
        /*
        枚举的主要作用是定义有限个数对象的一种结构（多例设计），枚举就属于多例设计，并且结构要比多例设计更加的简单
        基本定义：(可以判断所使用的的实例化对象是否存在)
            enum关键字实现枚举的定义

            还可以利用values方法获取所有的枚举对象进行输出
            枚举可以与switch直接连接
         */
//        Clor clor = Clor.RED;
//        System.out.println(clor);
//        for (Clor clor : Clor.values()){
//            System.out.println(clor);
//        }
        /*
        enum类：
            枚举并不属于一个新的结构，继承enum 类
            enum类的定义：
                javase doc 中详细了解
                在枚举之中每一个对象的序号都是根据枚举对象额定义顺序来决定的
         */
        /*
        面试题：请解释enum与Enum的区别？
                enum是从jdk1.5之后提供的一个关键字，用来定义枚举结构
                Enum是一个抽象类，所有使用enum关键系定义的类默认继承此类
         */

        /*
        定义枚举结构：
            注意：枚举之中构造方法不能采用非私有化定义（public无法使用）
            也可以实现接口的继承
            可以直接定义抽象方法并且要求每一个枚举对象都要覆写此抽象方法
         */
        IMe me = Clor.RED;
        System.out.println(me.getMe());
    }
}
