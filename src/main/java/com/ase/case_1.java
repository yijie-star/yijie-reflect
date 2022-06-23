/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: case_1.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

class Address{
    private String country ;
    private String province ;
    private String city ;
    private String street ;
    private String zipcode ;

    public Address(){

    }
    public Address(String country,String province,String city,String street,String zipcode){
        this.country = country ;
        this.province = province ;
        this.city = city ;
        this.street = street ;
        this.zipcode = zipcode ;
    }

    public String getInfo(){
        return "\n国家：" + this.country +
                "\n省份：" + this.province +
                "\n城市：" + this.city +
                "\n街道：" + this.street +
                "\n邮编：" + this.zipcode ;

    }
    public void setCountry(String country){
        this.country = country ;
    }
    public void setProvince(String province){
        this.province = province ;
    }
    public void setCity(String city){
        this.city = city ;
    }
    public void setStreet(String street){
        this.street = street ;
    }
    public void setZipcode(String zipcode){
        this.zipcode = zipcode ;
    }
}


public class case_1 {
    public static void main(String[] args) {
//        编写并测试一个代表地址的Address类，地址信息由国家、省份、城市、街道、邮编组成，并可以返回完整的地址信息
        Address ares = new Address("中华人民共和国","云南省","玉溪","红塔区凤凰路","100060") ;
        System.out.println(ares.getInfo());



    }
}
