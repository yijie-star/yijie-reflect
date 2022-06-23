/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: static_Key.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

class Pe{
    private String name ;
    private int age ;
//    暂时不封装
//    String country  = "中华有为" ;
//    重复保存 数据 不利于修改
//    解决办法：将其修改为公共属性 用static关键字
//    重写
    private static  String country  = "中华有为" ;
    public Pe(String name,int age){
        this.name = name ;
        this.age = age ;
    }
    public String    getInfo(){
        return "\n名字：" + this.name +
                "\n年龄：" + this.age +
                "\n国家：" + Pe.country ;
    }
    public static void setCountry(String c){
        country = c ;
    }

}

class Book{
    private String title ;
    private static int count = 0 ;
    public Book(){
        this("NOtitle - " + count++) ;
    }
    public Book(String title){
        this.title = title ;
//        count++ ;
//        System.out.println("第"+ count + "图书" ) ;

    }
    public String getTitle(){
       return this.title ;
    }

}


public class static_Key {
    public static void main(String[] args) {
//        static是一个关键字 主要用来定义属性和方法
//                分析：
//        static定义属性：(全局属性类似于全局变量)      static可以由类名称直接调用
//            static 虽然定义在类之中，但是不受到类实例化对象的控制 即static 属性可以在没有实例化对象的时候进行调用
//        Pe peA = new Pe("张三",20) ;
//        Pe peB = new Pe("李四",50) ;
//        Pe peC = new Pe("王五",10) ;
//        System.out.println(peA.getInfo());
//        System.out.println(peB.getInfo());
//        System.out.println(peC.getInfo());

//        类设计的时候，首选的一定是非static属性，而考虑到公共属性的时候才用static

//        static定义方法：其可以直接在没有实例化对象的情况下进行调用

//        Pe.setCountry("中国");
//        Pe peA = new Pe("张三",20) ;
//        System.out.println(peA.getInfo());

//        对程序而言方法就有两种：static 方法和非static方法
//                static方法只允许调用static属性或static方法
//                 非static方法允许调用static属性或static方法
//        static应用
        System.out.println(new Book("java").getTitle());
        System.out.println(new Book().getTitle());
        System.out.println(new Book().getTitle());
        System.out.println(new Book().getTitle());
        System.out.println(new Book().getTitle());
        System.out.println(new Book("python").getTitle());


    }
}
