/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: dataSheet_d_d.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

class Member{
    private String mid;
    private String name;
    //一个用户能浏览多个商品
    private Peoduct peoduct [];


    public Member(){}

    public Member(String mid,String name){
        this.setMid(mid);
        this.setName(name);
    }
    public String getInfo(){
      return "【用户信息】ID：" + this.mid + " 用户姓名：" + this.name;
    }

    public void setPeoduct(Peoduct[] peoduct) {
        this.peoduct = peoduct;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getMid() {
        return this.mid;
    }

    public Peoduct[] getPeoduct() {
        return this.peoduct;
    }
}

class Peoduct{
    private long pid;
    private String title;
    private double price;
    //一个商品也能被多个用户浏览
    private Member member [];

    public Peoduct(){}
    public Peoduct(long pid,String title,double price){
        this.setPid(pid);
        this.setTitle(title);
        this.setPrice(price);

    }

    public String getInfo(){
      return "【商品信息】ID：" + this.pid + " 名称：" + this.title + " 价格：" + this.price;
    }

    public void setMember(Member[] member) {
        this.member = member;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getPid() {
        return this.pid;
    }

    public String getTitle() {
        return this.title;
    }

    public double getPrice() {
        return this.price;
    }

    public Member[] getMember() {
        return this.member;
    }
}

public class dataSheet_d_d {
    public static void main(String[] args) {
//        多对多只需要考略实体表的设计即可，对于中间的访问信息不要求进行转换
//        1、根据结构设置对象数据
        Member memberA = new Member("a123","张三");
        Member memberB = new Member("ak44","李四");
        Peoduct peoductA = new Peoduct(1000,"小学课本",120.00);
        Peoduct peoductB = new Peoduct(1001,"中学课本",128.80);
        Peoduct peoductC = new Peoduct(1002,"高中课本",150.99);
        memberA.setPeoduct(new Peoduct[]{peoductA,peoductB,peoductC});
        memberB.setPeoduct(new Peoduct[]{peoductA,peoductC});
        peoductA.setMember(new Member[]{memberA,memberB});
        peoductB.setMember(new Member[]{memberA});
        peoductC.setMember(new Member[]{memberA,memberB});
//        2、根据要求获取数据
        System.out.println("-------根据商品信息查看浏览的用户---------");
        System.out.println(peoductA.getInfo());
        //看过A商品信息的用户
        for (int i = 0;i < peoductA.getMember().length;i++){
            System.out.println(peoductA.getMember()[i].getInfo());
        }
        System.out.println("-------根据用户查看浏览单商品信息---------");
        System.out.println(memberA.getInfo());
        for (int i = 0;i < memberA.getPeoduct().length;i++){
            System.out.println(memberA.getPeoduct()[i].getInfo());

        }

    }
}
