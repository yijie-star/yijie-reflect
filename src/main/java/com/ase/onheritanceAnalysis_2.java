/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: onheritanceAnalysis_2.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

class Employees{
    private String name;
    private int age;
    private String sex;

    public Employees(){}

    public Employees(String name,int age,String sex){
        this.setName(name);
        this.setAge(age);
        this.setSex(sex);
    }

    public String getInfo() {
        return "姓名：" + this.name + " 年龄：" + this.age + " 性别：" + this.sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getSex() {
        return this.sex;
    }
}

class Manager extends Employees{
    private String job;
    private double income;

    public Manager(){}

    public Manager(String name,int age,String sex,String job,double income){
        super(name,age,sex);
        this.setJob(job);
        this.setIncome(income);
    }

    @Override
    public String getInfo() {
        return "管理层：" + super.getInfo() + " 职位：" + this.job + " 年薪" + this.income;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String getJob() {
        return this.job;
    }

    public double getIncome() {
        return this.income;
    }
}

class Staff extends Employees{
    private String dept;
    private double salary;

    public Staff(){}
    public Staff(String name,int age,String sex,String dept,double salary){
        super(name,age,sex);
        this.setDept(dept);
        this.setSalary(salary);
    }

    @Override
    public String getInfo() {
        return "职员：" +super.getInfo() + " 所属部门：" + this.dept + " 月薪：" + this.salary;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDept() {
        return this.dept;
    }

    public double getSalary() {
        return this.salary;
    }
}

public class onheritanceAnalysis_2 {
    /**
     * 定义员工类，具有姓名、年龄、性别，并具有显示数据的方法和构造方法
     * 定义管理层类，继承员工类，并有自己的属性职务和年薪
     * 定义职员类，继承员工类，并有自己的属性所属部门及月薪
     */
    public static void main(String[] args) {
        Manager manager = new Manager("覃义",19,"男","人事总监",200000.00);
        Staff staff = new Staff("张三",11,"女","秘书",8500.00);
        System.out.println(manager.getInfo());
        System.out.println(staff.getInfo());
    }
}
