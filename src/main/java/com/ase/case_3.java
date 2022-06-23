/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: case_3.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

class Dog{
    private String name ;
    private String color ;
    private int age ;

    public Dog(){}
    public Dog(String name,String color,int age){
        this.name = name ;
        this.color = color ;
        this.age = age ;
    }

   public String getInfo(){
     return "狗的名字："+ this.name + "、狗的颜色：" + this.color + "、狗的年龄：" + this.age;
   }

}


public class case_3 {
    public static void main(String[] args) {
//        设计一个Dog类，有名字、颜色、年龄等属性，定义构造方法来初始化类的这些属性，
        Dog dog = new Dog("小额昂","白色",12) ;
        System.out.println(dog.getInfo());
    }
}
