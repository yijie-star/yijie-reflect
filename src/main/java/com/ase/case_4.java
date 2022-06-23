/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: case_4.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

class Account{
    private String name ;
    private double balace ;

    public Account(){

    }
    public Account(String name){
        this(name, 0.0) ;

    }
    public Account(String name,double balace){
        this.name = name;
        this.balace = balace ;
    }

    public void setBalace(double balace) {
        this.balace = balace;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public double getBalace() {
        return this.balace;
    }
    public String getInfo(){
      return "账户名称：" + this.name + "、余额：" + this.balace;
    }
}


public class case_4 {
//    构造一个银行账户类：
//        数据成员的账户名称、用户的账户余额
//        方法包括开户（设置账户名称及余额），利用构造方法完成
//        查询余额
public static void main(String[] args) {
    Account account = new Account("覃义", 5200) ;
    System.out.println(account.getInfo());
    System.out.println(account.getBalace());
}




}
