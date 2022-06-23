/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: Functional_prog.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;
//函数式接口
@FunctionalInterface
interface IMa{
    public void send(String str);
}
@FunctionalInterface
//泛型，P描述的是参数   R描述的是返回值
interface IFunction<P,R>{
    public R chenge(P p);
}
public class Functional_prog {
    public static void main(String[] args) {
        /*
        从jdk1.8开始，为了简化使用者进行代码的开发，专门提供了Lambda表达式的支持实现函数式的编程
        比较著名的语言：haskell,Scala,可以避免面向对象中一些繁琐的处理问题
        实现
         */
//        IMa isg = (str) -> {
//            System.out.println("发送消息：" + str);
//        };
//        isg.send("https://www.jd.com");
        /*
        要求：SAM--只有一个抽象方法-提供一个方法-函数式接口
        表法式有如下几种格式：
            方法没有参数：()->{};
            方法有参数：(参数，参数)->{};
            如果只有一行语句返回：(参数，参数)->语句；
         */
        /*
        方法引用：
            四种形式：
                1、引用静态方法：类名称 :: static 方法名称;
                2、引用某个实例对象的方法：实例化对象 :: 普通方法
                3、引用特定类型的方法：特定类 :: 普通方法
                4、引用构造方法：类名称 :: new
         */
        IFunction<Integer,String> function = String :: valueOf;
        String str = function.chenge(100);
        System.out.println(str.length());
        /*
        利用方法引用这一概念可以为一个方法定义多个名字，但是要求必须是函数式接口
        弥补对于引用的支持
         */

    }
}
