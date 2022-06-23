/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: dataSheet_1_d.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

class Item{
    private long iid;
    private String title;

//    一个分类下有多个子分类
    private Subitem subitem [];

    public Item(){}


    public Item(long iid,String title){
        this.setIid(iid);
        this.setTitle(title);
    }

    public void setSubitem(Subitem[] subitem) {
        this.subitem = subitem;
    }

    public void setIid(long iid) {
        this.iid = iid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getIid() {
        return this.iid;
    }

    public String getTitle() {
        return this.title;
    }

    public Subitem[] getSubitem() {
        return this.subitem;
    }

    public String getInfo(){
      return "【分类信息】ID：" + this.iid + " 分类标题：" + this.title;
    }

}

class Subitem{
    private long sid;
    private String title;

//    一个子分类有一个主分类
    private Item item;

    public Subitem(){}
    public Subitem(long sid,String title){
        this.setSid(sid);
        this.setTitle(title);
    }
    public void setSid(long sid) {
        this.sid = sid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public long getSid() {
        return this.sid;
    }

    public String getTitle() {
        return this.title;
    }

    public Item getItem() {
        return this.item;
    }

    public String getInfo(){
      return "【子分类信息】ID：" + this.sid + " 子分类标题：" + this.title;
    }
}
public class dataSheet_1_d {
    public static void main(String[] args) {
//        数据表与简单java类的转换-1对多
//        1、根据结构设置对象数据
        Item item = new Item(20001,"图书");
        Subitem subitem [] = new Subitem[]{
                new Subitem(10,"大数据"),new Subitem(20,"C语言"),new Subitem(30,"计算机")
        };
        //一个分类下有多个子分类
        item.setSubitem(subitem);

        for (int i = 0; i < subitem.length;i++){
            //一个子分类有一个主分类
            subitem[i].setItem(item);
        }
//        2、根据要求获取数据
        //主分类
        System.out.println(item.getInfo());
        //子分类
        for (int i = 0; i < item.getSubitem().length;i++){
            System.out.println(item.getSubitem()[i].getInfo());
        }
    }
}
