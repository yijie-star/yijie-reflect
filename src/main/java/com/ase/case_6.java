/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: case_6.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

class Booke{
    private int bookId ;
    private String title ;
    private double bookPrive;
    private static int count = 0 ;
    public Booke(){}

    public Booke(String title,double bookPrive){
        this.bookId = count + 1 ;
        this.setTitle(title);
        this.setBookPrive(bookPrive);
        count++ ;

    }

    public String getInfo(){
      return "图书编号：" + this.bookId + "\n名称： " + this.title + "\n价格：" + this.bookPrive;
    }

//    public static void setCount(int count) {
//        Book.count = count;
//    }

    public void setBookPrive(double bookPrive) {
        this.bookPrive = bookPrive;
    }

//    public void setBookId(int bookId) {
//        this.bookId = bookId;
//    }

    public void setTitle(String title) {
        this.title = title;
    }

    public  static int getCount() {
        return count;
    }

    public String getTitle() {
        return this.title;
    }

    public double getBookPrive() {
        return this.bookPrive;
    }
}



public class case_6 {

//    声明一个图书类，数据成员有书名、编号、书价，并拥有静态数据成员册数、记录图书的总册数
//        在构造方法中利用次静态变量为对象的编号赋值，在主方法中定义多个对象，并求出总册数
    public static void main(String[] args) {
//        Book bookA = new Book()
        Booke bookA = new Booke("卓如入机",250);
        Booke bookB = new Booke("红楼梦",500);
        Booke bookC = new Booke("西游记",200);
        System.out.println(bookA.getInfo());
        System.out.println(bookB.getInfo());
        System.out.println(bookC.getInfo());
        System.out.println(Booke.getCount());
    }
}
