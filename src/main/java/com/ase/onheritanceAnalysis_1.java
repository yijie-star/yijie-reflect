/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: onheritanceAnalysis_1.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

class Persons{
    private String name;
    private String addr;
    private String sex;
    private int age;

    public Persons(){}

    public Persons(String name,String addr){
        this(name,addr,"男",10);
    }
    public Persons(String name,String addr,String sex,int age){
        this.setName(name);
        this.setAddr(addr);
        this.setSex(sex);
        this.setAge(age);
    }




    public String getInfo(){
      return "姓名：" + this.name + " 地址：" + this.addr + " 性别：" + this.sex + " 年龄：" + this.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public String getAddr() {
        return this.addr;
    }

    public String getSex() {
        return this.sex;
    }

    public int getAge() {
        return this.age;
    }
}

class Students extends Persons{
    private double math;
    private double english;

    public Students(){}
    public Students(String name,String addr){
        super(name,addr);
    }
    public Students(String name,String addr,String sex,int age,double math,double english){
        super(name,addr,sex,age);
        this.setMath(math);
        this.setEnglish(english);
    }

    public String getInfo(){
      return super.getInfo() + " 数学成绩：" + this.math + " 英语成绩：" + this.english;
    }

    public void setMath(Double math) {
        this.math = math;
    }

    public void setEnglish(Double english) {
        this.english = english;
    }

    public Double getMath() {
        return this.math;
    }

    public Double getEnglish() {
        return this.english;
    }
}
public class onheritanceAnalysis_1 {
    /*
    * 建立一个Persons 和学生类 Student 功能要求如下：
    *1、Persons中包含4个私有属性成员name,addr , sex,age,分别为字符串型、字符串型、字符型、整型，一个4参
    *构造方法，一个两参构造、一个无参构造，一个输出方法显示4个属性
    * 2、Students 类继承Persons 类，并增加成员math，english存放数学和英语成绩，一个六参构造、两参，一个无参
    * 重写输出方法用于显示六中属性
    * */
    public static void main(String[] args) {
//        进行程序类开发时，不需要考虑子类
        Students students = new Students("覃义","玉溪","男",23,80.2,90.6);
        System.out.println(students.getInfo());
    }





}
