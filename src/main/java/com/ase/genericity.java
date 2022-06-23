/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: genericity.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

//T是type的简写，可以定义多个泛型  将所有的object都换成T
//此时x,y的属性类型并不确定，而是由外部来决定
class Pt <T> {
    private T x;
    private T y;
    public Pt(){}
    public Pt(T x,T y){
        this.setX(x);
        this.setY(y);
    }

    public void setX(T x) {
        this.x = x;
    }

    public void setY(T y) {
        this.y = y;
    }

    public T getX() {
        return this.x;
    }

    public T getY() {
        return this.y;
    }
}
class Mg <T>{
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }
}

public class genericity {
    public static void main(String[] args) {
        /*
        主要目的：是为了解决ClassCastException的问题，在进行对象的向下转型时永远都可能存在有安全隐患
        而java希望通过泛型慢慢解决此类问题

        假设：定义一个描述x与y坐标的处理类允许开发者保留有三类数据
            1、整型数据
            2、浮点型数据
            3、字符串型数据
            因此在设计时就需要考虑属性的类型，最为原始的是使用object来定义，因为有以下转型关系：
                 1、整型数据：包装为Integer类对象-向上转型为object
                 2、浮点型：包装为double类对象-向上转型为object
                 3、字符串型数据：string类对象-向上转型为object
         */
        //进行内容的设置
        /*
        由于实例化设置了泛型类型，所有对应此泛型的属性、变量、方法返回值将全部变为设置的类型（只局限与对象之中）
         */
//        Pt<Integer> pt = new Pt<Integer>();
//        pt.setX(10);
//        pt.setY(20);
//        int x = pt.getX();
//        int y = pt.getX();
//        System.out.println("x坐标：" + x + " y坐标：" + y);
        /*
        pt.setY("北纬20度");编译不会出问题，执行会异常
         */
        /*
        泛型的的本质：类中的属性或方法的参数与返回值的类型可以由对象实例化的时候动态决定
            此时需要在类定义的时候明确定义占位符（泛型标记）
        注意：泛型之中只允许设置引用类型，如果要操作基本类型必须使用包装类
            从jdk1.7开始，泛型对象实例化可简化为Pt<Integer> pt = new Pt<>();
         */



        /*
        新的问题：引用传递
        泛型通配符：
         */
        Mg<String> mg =  new Mg<>();
        mg.setContent("https://baidu.com");
        fun(mg);
    }
    /*
    fun方法应该可以接收任意种泛型，但是只能单一接收 使用通配符 “？” 号解决
    在其基础上还提供两类小的通配符：
        ？ extends 类：设置泛型的上限
            例如定义“？ extends Number” :表示该泛型类型只允许设置Number和它的子类
        ？ super 类：设置泛型的下限
            例如：定义“？ super String” :只能够使用string及其父类
     */
    public static void  fun(Mg<?> temp){
        System.out.println(temp.getContent());

    }


    /*
    泛型在接口中的使用：
        原则：



     */
}
