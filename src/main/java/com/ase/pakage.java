/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: pakage.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

public class pakage {
    public static void main(String[] args) {
        /*
        在实际开发之中，都必须有包的概念：
            所有的类都放在包里面，实现类的包装
            定义：（同一个目录下不允许存放相同的程序类文件）为了进行类的管理。即把程序类放在不同的目录下--包
            完整的类名称：包.类名称
         */



        /*
        包的导入：import 包名

        特别注意：关于pvblic class 与 class 的区别？
            public calss:类名称必须与文件名称保持一致
            calss:类名称可以不同，但是只能被本包所访问，外部不能访问
            在实际的开发之中往往一个*.java源代码文件里面只会提供一个程序类

        包名称必须采用小写


        包的静态导入：
            原始方式：导入包后，使用包名调用静态（static）方法

            现：import static 包名.*



         */


        /*
        java不同的开发包：
            java.lang ：像string，number，object等类都在里面在jdk1.0后自动导入
            java.lang.reflect：反射机制处理包所有的而设计从此开始
            java.util ：工具类的定义包括数据结构的定义
            java.io ：进行输入与输出流操作的程序包
            java.net： 网络程序开发程序包
            java.sql ：进行数据库编程的开发包
            java.applet：java的最原始的使用形式直接嵌套在网页上执行的程序类
                现在的程序已经以application 为主（有主方法的程序）
            java.awt、java.swing：java的图形界面开发包（GUI），其中awt 是属于重量级额组件，而swing是轻量级组件

         */

        /*
        权限：四种（private,default(不写),protected,public）

        封装选择方案：
            只要是进行属性的定义全部使用private
            只要是进行方法的定义
         */
    }
}
