/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: this_Key.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

class Perso {
    private String name ;
    private int age ;
    //setter,getter正常必须有，这里省略
//    public Perso(String n, int a){
//        此构造方法为了使name,与age初始化
//        n与a 不合适 写成name，age更好 java中{}作为结构体的边界符
//        为了区别属性与参数，往往会在属性前追加this关键字 表示本类属性
//        name = n ;
//        age = a ;
//    }
//    重写
    public Perso(String name ,int age){
//        调用单参构造
        this(name) ;
//        加与不加this，都表示本类方法
        this.setName(name) ;
        this.setAge(age);
//        System.out.println("一个新的实例化对象");
    }
    public Perso(String name){
//        调用无参构造
        this();
        this.setName(name);
//        System.out.println("一个新的实例化对象");
    }
    public Perso(){
        System.out.println("一个新的实例化对象");
    }


    public void tell(){
        System.out.println("姓名：" + this.name + "\n年龄：" + this.age);
    }
    public void setName(String name){
        this.name = name ;
    }
    public void setAge(int age){
        this.age = age ;
    }
    public String getName(){
        return this.name ;
    }
    public int getAge(){
        return this.age ;
    }
}

class Emp{
    private long empno ;
    private String ename ;
    private String dept ;
    private double salary ;

//    重复代码非常多
    public Emp(){
//        重写
        this(1000,"无名氏",null,0.0) ;
//        this.empno = 1000 ;
//        this.ename = "无名氏" ;
    }

    public Emp(long empno){
        this(empno,"新员工","未定",0.0) ;

//        this.empno = empno ;
//        this.ename = "新员工" ;
//        this.dept = "未定" ;
    }

    public Emp(long empno,String ename,String dept){
        this(empno,ename,dept,2500.0) ;
//        this.empno = empno ;
//        this.ename = ename ;
//        this.dept = dept ;
//        this.salary = 2500.0 ;
    }

    public Emp(long empno,String ename,String dept,double salary){
        this.empno = empno ;
        this.ename = ename ;
        this.dept = dept ;
        this.salary = salary ;
    }

    public String getinfo(){
        return "\n雇员编号：" + this.empno +
                "\n雇员姓名："  + this.ename +
                "\n所在部门：" + this.dept +
                "\n基本工资：" + this.salary ;

    }}


class Dept{
    private long detno ;
    private String dname ;
    private String loc ;

//    必须提供有无参构造方法
    public Dept(){

    }
    public Dept(long detno,String dname,String loc){
        this.detno = detno ;
        this.dname = dname ;
        this.loc = loc ;
    }

    public String getInfo(){
        return "\n[部门信息]部门编号：" + this.detno +
                "\n部门名称：" + this.dname +
                "\n部门位置：" + this.loc ;
    }

    public void setDetno(long detno){
        this.detno = detno ;
    }
    public void setDname(String dname){
        this.dname = dname ;
    }
    public void setLoc(String loc){
        this.loc = loc ;
    }
    public String getDname(){
        return this.dname ;
    }
    public String getLoc(){
        return this.loc ;
    }
    public long getDetno(){
        return this.detno ;
    }



}

public class this_Key {
    public static void main(String[] args) {

//         java里面比较复杂的关键字，因为this的使用形式决定了它的灵活性实现三类的结构的描述
//        1、当前类中的属性：this.属性
//                2、当前类中的方法（普通方法，构造方法）：this()、this.方法名称()
//                3、描述当前对象：
//        使用this调佣当前类中属性
//        Perso perso = new Perso("ani") ;
//        perso.tell();

//        this 除了调用属性外，还可以调用方法
//        构造方法的调用（this()）:使用关键字new实例化对象的时候才会调用构造方法

//                普通方法的调用（this.方法名称()）:实例化对象后就可以调用普通方法 ：在构造方法中


//        代码的好坏：
//            代码结构可以重用，提供的是一个中间独立的支持。
//            没有重复代码
//        注意：
//        构造方法必须在实例化新对象的时候调用，所以this() 语句只能放在构造方法的首行
//            构造方法在互相调用时，请保留程序的出口 别形成死循环

//        案例
//        Emp emp = new Emp(7369L,"史密斯","主管部门") ;
//        System.out.println(emp.getinfo());

//        简单java类：无处不在 可以描述某一类信息的程序类，并没有复杂的逻辑操作，只作为信息存储的媒介存在
//        开发结构：
//              1、类名称要有意义，可以明确描述某一类事物
//              2、类属性必须使用 privata 进行封装，而起必须提供有setter,getter方法
//              3、类之中可以提供无数多个构造方法，但是必须要保留有无参构造方法
//              4、类之中不允许出现任何的输出语句，所有内容的获取必须返回
//              5、非必须：可以提供一个获取对象详细信息的方法 暂时将此名称定义为 getInfo()

//        实例
        Dept dept = new Dept(1000,"技术部","玉溪") ;
        System.out.println(dept.getInfo());


    }
}
