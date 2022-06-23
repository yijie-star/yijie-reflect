
/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: referencePassing.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

/*
 * @Created by IntelliJ IDEA.
 * @fileName: referencePassing.java
 * @Description：
 * @Author: Jike Y
 * @email smile_yijie@163.com
 * @Datetime: 2022/4/28 下午8:41
 */

package com.ase;

class Psn{
    private String name ;
    private int age ;
//    一个人有一辆车
    private Car car;
//    一个人有一个孩子 多个孩子用数组
    private Psn children [];
    public Psn(){}
    public Psn(String name,int age){
        this.name = name ;
        this.age = age ;
    }
    public String getInfo(){
        return "姓名：" + this.name + "、年龄：" + this.age ;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setChildren(Psn[] children) {
        this.children = children;
    }

    public Psn[] getChildren() {
        return this.children;
    }
}

class Car{
    private String name;
    private double price;
    //  一辆车 有 一个人
    private Psn psn;
    public Car(){}
    public Car(String name,double price){
        this.name = name;
        this.price = price;
    }
    public String getInfo(){
      return "汽车名字：" + this.name + "\n汽车价格：" + this.price;
    }

    public void setPsn(Psn psn) {
        this.psn = psn;
    }

    public Psn getPsn() {
        return this.psn;
    }
}

class Computer{

}

class Host{

}
class Monitor{

}
//等等



public class referencePassing {
    public static void main(String[] args) {
//        引用传递是java开发和设计中最为重要的技术组成
//        引用分析一：
//       第一步： 声明对象并设置彼此关系
//        Psn psn = new Psn("林强",29);
//        Psn childrenA = new Psn("小王",18);
//        Psn childrenB = new Psn("小徐",20);
//        Car car = new Car("宾利",80000.00);
////        一个人有多个孩子
//        psn.setChildren(new Psn[]{childrenA,childrenB});
//        childrenA.setCar(new Car("BMW",52000));
//        childrenB.setCar(new Car("BMW",5200));

//        一个人有一辆车
//        psn.setCar(car);
//        一辆车有一个人
//        car.setPsn(psn);
//        第二步：根据关系获取数据
//        代码链
//        System.out.println(psn.getCar().getInfo());
//        System.out.println(car.getPsn().getInfo());

//        两个自定义类型，并且能联系在一起

//        完善
//        根据人找到所有的孩子及孩子对应的汽车
//        for (int i= 0 ; i < psn.getChildren().length;i++){
//            System.out.println(psn.getChildren()[i].getInfo());
//            System.out.println(psn.getChildren()[i].getCar().getInfo());
//
//        }
//        这种关系的匹配都是通过引用数据类型来完成的

//        合成设计模式



    }
}
