/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: inner_class.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

import javax.sound.midi.Soundbank;

class Outer{
    //私有属性成员
    private String msg = "http://www.jd.com";
    public void fun(){
        //实例化内部类对象
        Inner inner = new Inner();
        inner.print();
        //访问内部类的私有属性
        System.out.println(inner.info);
    }
    class Inner{
        private String info = "今天天气不错哦！";
        public void print(){
            System.out.println(Outer.this.msg);
        }
    }
}
public class inner_class {
    public static void main(String[] args) {
        /*
        在一个类的内部，可以定义一个其他的类---内部类
            基本定义：独立其完善的类结构在一个类的内部，除了有属性及方法外，可以使用class定义类
         */
        //实例化外部内对象
        Outer outer = new Outer();
        outer.fun();
        /*
        为什么会提供有内部类这样的结构呢？
            内部类的绝对优势：轻松的访问外部类的私有属性
            相关说明：：
                使用了内部类之后，内部类和外部类之间的私有操作的访问就不再需要通过setter，getter方法
                内部类实例化对象的格式如下：
                    外部类.内部类 内部类对象 = new 外部类().new 内部类() ;

        在java之中，类作为最基本的结构体。实际还有与之类似的抽象类或者是接口，抽象类或接口中都可以定义内部结构
         */
        /*
        如果现在内部类使用了static定义，那么这个内部类就变为了“外部类”，那么static定义的结构就相当于独立的程序类
        此时实例化对象格式：外部类.内部类 内部类对象 = new 外部类.内部类();
        static 定义内部类不常用，但是定义内部接口很常用
         */
        /*
        在方法中定义内部类：
            常见


            匿名内部类是一种简化的内部类处理形式，主要是在抽象类和接口的子类上使用的
            与内部类相比，匿名内部类只是一个没有名字的只能够使用一次的，并且结构固定的一个子类
         */
    }
}
