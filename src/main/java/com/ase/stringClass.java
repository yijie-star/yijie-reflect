/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: stringClass.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

public class stringClass {
//    在开发项目中，没有一个项目不去使用string类，其至关重要的组成类，
//    在java中所有的字符串都要求使用""进行定义 + 实现字符串的链接处理
//    string类的特点：
//        字符串并不是一个基本数据类型
//    string类对象实例化
    public static void main(String[] args) {
        //直接赋值：只会开辟出一块堆内存空间，还可以实现同一个字符串的共享操作 可以实现池数据的自动保存，
        // 如果再有相同定义是减少对象的产生，以提升操作性能

        // 也可以利用构造方法进行实例化处理 public String(String str); 或产生一定的垃圾空间

        //面试题：请解释string两种实例化方式的区别？
        //      直接赋值：只会产生一个实例化对象，并且可以自动保存在在对象池中，以实现改字符串的重用
        //      构造方法：会产生两个实例化对象并且不回自动入池，无法实现对象重用，但是可以利用intern（）方法手工入池处理
        //
        //


//        String str = "https://www.baidu.com";
//        System.out.println(str);
//        注意 ：
//        之所以能保存字符串，是因为其定义了一个数组，因此字符串是保存在数组中
//        利用构造方法进行实例化
//        String str = new String("https://www.baidu.com");
//        字符串比较
//        String strA = "mldn";
//        String strB = new String("mldn");
        //false
//        System.out.println(strA==strB);
//        此时的比较并没有成功 虽然两字符串内容相等，但无法准确判断
//        准确判断：使用string类中提供的一个比较方法
//        字符串比较（有变形）：public boolen equals(String str);
//        System.out.println(strA.equals(strB));
//        面试题：请解释“String”比较中“==”与“equals”的区别？
//            “==”：比较的是数值，如果用于对象比较上比较的是两个内存的地址数值
//                “equals“：比较的是类提供的一个比较方法，可以直接进行字符串内容的判断
//        字符串常量  任何一个“""”定义的字符串常量实际上描述的是String类的匿名对象

//        关于对象相等判断的小技巧：
//            如果某些数据是由用户输入，并且要求这些数据为一个指定内容的情况下建议将字符串常量写在前面
//        String input = null;
//        System.out.println("mldy".equals(input));
//        eqals()方法里面提供一个 可以回避null的判断


//        string对象常量池
//        对象池的主要目的是实现数据的共享处理
//        静态常量池：指的程序（*.Class）在加载的时候会自动将此程序之中保存的字符串、普通的常量、类等全部进行分配
//               动态常量池：当一个程序（.class）加载之后，可能有一些变量，提供的常量池


//        字符串(是匿名对象，会产生一个空间地址)修改
//        当定义了一串字符之后，会开辟一个数组空间，而且长度是固定的

//        String str = "www.";
//        str += "mldn.";
//        str = str + "cn";
//        System.out.println(str);
        //在整个的处理过程中，字符串常量并没有发生改变，
        // 改变的只是一个string类对象的引用。并且将有可能带来大量的垃圾空间
//        String str = "www.";
//        for (int i = 0; i < 1000;i++ ){
//            str += i;
//        }
//        System.out.println(str);
        //如果本程序出现在代码之中，将会产生无数垃圾空间

//        java中的主方法分析
//        public:描述的是一种访问权限，主方法是一切的开始点，一定是公共的
//        static：程序的执行是通过类名称来完成的所以表示此方法由类名称直接调用
//        void：主方法是一切的起点，一旦开始就没有返回的可能
//        main：是一个系统定义好的名称
//        (String[] args)：字符串的数组可以实现程序启动参数的而接收



    }

//    public static void main(String[] args) {
//
//    }
}
