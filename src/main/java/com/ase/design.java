/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: design.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

//实现多例设计模式
class Cor{
    //多个实例化对象
    private static final Cor RED = new Cor("红色");
    private static final Cor GREEN = new Cor("绿色");
    private static final Cor BLUE = new Cor("蓝色");
    private String title;
    //构造方法私有化
    private Cor(String title){
        this.setTitle(title);
    }
    public static Cor getInstance(String color){
        switch (color){
            case "red": return RED;
            case "green": return GREEN;
            case "blue": return BLUE;
            default: return null ;
        }
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
public class design {
    public static void main(String[] args) {
        /*
        单例设计模式（多例设计模式）是一种控制实例化对象产生个数的设计操作

        单例设计模式：
            1、private访问权限的主要特点在于：不能在类外部访问，但是可以在类本身掉调用
            2、static可以实现在没有实例化对象后访问

            最终定义形式（在类的内部）：private static final 类名 大学 = new 类名()

            保证不管怎么操作只有一个实例化对象
         */

        /*
        多例设计模式（保留多个实例化对象）：

         */
        Cor cor = Cor.getInstance("green");
        System.out.println(cor.getTitle());
    }
}
