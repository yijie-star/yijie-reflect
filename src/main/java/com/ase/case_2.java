/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: case_2.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

class Employee{
    private long empno ;
    private String ename ;
    private double salary ;
    private double rate ;
//    setter,getter 略写
    public Employee(){

    }

    public Employee(long empno,String ename,double salary,double rate){
        this.empno = empno ;
        this.ename = ename ;
        this.rate = rate ;
        this.salary = salary ;
    }

    public double salaryIncValue(){
        return salary * this.rate ;

    }

    public double salaryIncResult(){
        return salary * (1+this.rate) ;

    }
    public String getInfo(){
        return "\n雇员编号：" + this.empno +
                "\n雇员姓名：" + this.ename +
                "\n基本工资：" + this.salary +
                "\n工资增长率：" + this.rate ;

    }
}

public class case_2 {
    public static void main(String[] args) {
//        定义一个代表员工的Employee 类，员工包括“编号”、“姓名”、“基本薪水”、“薪水增长率”，还包括计算薪水增长额
//                及计算增长后的工资总额的操作方法
//        超过了简单java类的范畴，不涉及到复杂的计算逻辑
        Employee emp = new Employee(10001,"覃义",3000.0,0.6) ;
        System.out.println(emp.getInfo());
        System.out.println("工资增长的额度：" + emp.salaryIncValue());
        System.out.println("上调后的工资：" + emp.salaryIncResult());

    }
}
