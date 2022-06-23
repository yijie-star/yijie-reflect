/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_reflex.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;
import java.util.Date;//1、导入程序所在的包 类 知道对象的出处
public class java_reflex {
    public static void main(String[] args) {
        /*
        反射机制：--java精髓
        正向操作：

        Date date = new Date();//2、通过类产生实例化对象
        System.out.println(date.getTime());//3、根据对象调用类中的方法

         */
        /*
        反向操作：通过object中的所提供的方法
            获取class对象：getclass方法
         */
        /*
        class是反射操作的根源，此类通过实例化对象，采用三种方法完成，在java.lang包中
        1、object支持：public final Class<?> getClass();
            缺点：如果只是想获得Class类对象，则必须产生指定类对象才可以获得
        2、JVM支持：采用“类.class”的形式实例化
            如果采用此模式，必须导入程序所对应的开发包
        3、Class类支持：提供有一个可操作性的static方法：
            可以直接使用字符串的形式定义要使用的类型。并且不需要编写人任何的import语句
         */
    }
}
