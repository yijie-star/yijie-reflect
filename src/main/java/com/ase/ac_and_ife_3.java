/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: ac_and_ife_3.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

abstract  class ASape{
    public abstract double area();
    public abstract double perimeter();
}
class Ciular extends ASape{
    private double radius;
    private static final double PI = 3.14;
    public Ciular (){}
    public Ciular (Double radius){
        this.setRadius(radius);
    }

    @Override
    public double area() {
        return PI * this.radius * this.radius;
    }

    @Override
    public double perimeter() {
        return PI * this.radius * 2;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
class Rectgle extends ASape{
    private double lenth;
    private double width;
    public Rectgle(){}
    public Rectgle(Double lenth,Double width){
        this.setLenth(lenth);
        this.setWidth(width);
    }

    @Override
    public double area() {
        return this.lenth * this.width;
    }

    @Override
    public double perimeter() {
        return (this.lenth + this.width) * 2;
    }

    public void setLenth(double lenth) {
        this.lenth = lenth;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public Double getLenth() {
        return lenth;
    }

    public Double getWidth() {
        return width;
    }
}
//使用工厂设计模式，完全隐藏实现子类
class Foy{
    public static ASape getInstance(String ClassName,double... args){
        if ("Ciular".equalsIgnoreCase(ClassName)){
            return new Ciular(args[0]);
        }else if ("Rectgle".equalsIgnoreCase(ClassName)){
            return new Rectgle(args[0],args[1]);

        }else {
            return null;
        }
    }
}
public class ac_and_ife_3 {
    /*
    定义类Shape,用来表示一般二位图形，具有抽象方法area和perimeter,分别用来计算形状的面积和周长，
    试定义二位形状类（如矩形，三角形，椭圆形等），这些类均为Shape的子类
     */
    public static void main(String[] args) {
        ASape sapeA = Foy.getInstance("Ciular",1.1);

        ASape sapeB = Foy.getInstance("Rectgle",5,6);
    }

}

