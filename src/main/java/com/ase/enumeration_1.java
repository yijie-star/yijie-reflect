/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: enumeration_1.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

enum Sex{
    MALE("男"),FEMALE("女");
    private String title;
    private Sex(String title){
        this.setTitle(title);
    }
    public String toString(){
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
class Pn{
    private String name;
    private int age;
    private Sex sex;
    public Pn(){}
    public Pn(String name,int age,Sex sex){
        this.setName(name);
        this.setAge(age);
        this.setSex(sex);
    }
    public String toString(){
        return "姓名：" + this.name + " 年龄：" + this.age + " 性别 :" + this.sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
public class enumeration_1 {
    public static void main(String[] args) {
        System.out.println(new Pn("张三",20,Sex.MALE));
    }
}
