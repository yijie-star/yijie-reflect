/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: OverRide.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

class Channel{
    public void connect(){
        System.out.println("一个父类");

    }
}
class DatabaseChannel extends Channel{
    public void connect(){
        System.out.println("子类连接");
    }
}
//此类不会有子类
final class Chan{}
//class da extends Chan{}
public class OverRide {
//    子类和父类一旦产生关系之后，会继承父类的全部定义，但里面也有可能出现不合适的场景
//    方法的覆写：当子类定义了与父类方法名称相同，参数类型及个数完全相同时，就成为方法的覆写


//覆写的限制:
//    被覆写的方法不能够拥有比父类方法更为严格的访问控制权限
//    已经接触过的访问权限: public > default > private


    public static void main(String[] args) {
        //由于实例化的是子类对象，此时调用的方法一定h是被子类覆写过的方法，如果该方法没有被覆写过，那么会调用父类的方法
        //覆写的意义在于优化父类功能 如果要想调用父类中的方法，必须使用  super.方法()
        DatabaseChannel channel = new DatabaseChannel();
        channel.connect();
    }
    //请解释Override 与 Overloading 的区别？
    //Override：覆写（方法名称、参数个数相同；被覆写方法不能拥有更严格的控制权限；发生在继承关系之中）
    //Overloading：重载（方法名称相同，参数个数不同；没有权限；发生在一个类中）

//    属性覆盖：子类与父类定义了相同名称的属性时  若父类进行了属性封装，实际上就和父类定义的属性不相关，


    //请解释super 与this 的区别？
    //1、在程序类中使用this表示先从本类中查找所需要的属性和方法，如果本类不存在则查找父类 ，
    //如果使用的是super表示不查找子类，直接查找父类
    //2、this和super都可以进行构造方法的调用，this调用的是本类构造，super是由子类调用父类，并且都必须放在首行，不能同时出现
    //3、this可以表示当前对象


//    final关键字：在程序中描述额是终结器的概念 功能：
    //定义不能够被继承的类，定义不能够覆写的方法，常量
//public final void connext(){}


//    全局常量(每一个字母必须大写)：public static final int X = 10;
}
