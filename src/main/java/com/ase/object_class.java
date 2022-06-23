/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: object_class.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

public class object_class {
    public static void main(String[] args) {

        /**
         * 主要特点：解决参数的统一问题   也就是使用object可以接收所有的数据类型
         * 在java之中，只有object类是不存在继承关系的，也就是所有的类都是object的子类
         * 提供有无参构造方法，object是所有类的父类，就可以用其接收所有子类对象
         *
         * 如果一个程序的方法要求可以接收所有类对象的时候就可以使用object实现处理，但是需要注意：在程序设计之中对于所有引用的数据类型
         * 实际上都可以使用object类进行接收，包括数组也可以
         *
         * 是一份万能的数据类型
         */



        /*
        本身是一个类，也提供有很多的处理方法
         */


        /*
          对象比较：equals()
          Object作为所有类的父类，提供了对象比较操作的支持，即
                对象比较：public boolean equals(Object obj)可以接收所有类型
                默认情况只是进行两个对象的地址判断，如果要实现此方法，必须覆写此方法
                string也覆写了此方法
         */


    }
}
