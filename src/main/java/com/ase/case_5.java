/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: case_5.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

class User{
    private String username ;
    private String password ;
    private static int count = 0 ;

    public User(){
        this("NOID","88888888");
    }
    public User(String username){
        this(username,"88888888")  ;
    }
    public User(String username,String password){
        this.setUsername(username);
        this.setPassword(password);
        count++ ;
    }

    public static int getCount(){
        return count;
    }

    public String getInfo(){
      return "用户名：" + this.username + "\n口令：" + this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void setCount(int count) {
        User.count = count;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
public class case_5 {

//    设计一个表示用户的User类。变量有用户名、口令和记录用户个数的变量，定义3个构造方法（无参、为用户名赋值、为用户名和口令赋值）
//        获取和设置口令的方法和返回类信息的方法


    public static void main(String[] args) {
        User userA = new User() ;
        User userB = new User("小冰");
        User userC = new User("yijie","520") ;
        System.out.println(userA.getInfo());
        System.out.println(userB.getInfo());
        System.out.println(userC.getInfo());
        System.out.println("用户的个数：" +User.getCount());
    }
}
