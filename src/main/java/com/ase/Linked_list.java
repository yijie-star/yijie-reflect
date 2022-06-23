/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: Linked_list.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;
class Nde<E>{
    private E data;
    private Nde text;
    public Nde(){}
    public Nde(E data){
        this.setData(data);
    }
    public E getData(){
        return this.data;
    }
    public Nde getText(){
        return this.text;
    }
    public void setData(E data) {
        this.data = data;
    }

    public void setText(Nde<E> text) {
        this.text = text;
    }
}

public class Linked_list {
    public static void main(String[] args) {
        /*
        链表的本质是一个动态数组，它可以实现若干个对象的存储
        基本定义：（动态扩充的动态数组）
            数组最大的缺点是：数组长度是固定的  传统的对象数组开发依赖于角标控制 不利于实现内容的动态维护
            而链表更加的灵活将数据进行保存
         */
//         Nde<String> nde1 = new Nde<>("火车头");
////        Nde<String> nde2 = new Nde<>("车厢一");
////        Nde<String> nde3 = new Nde<>("车厢二");
////        Nde<String> nde4 = new Nde<>("车厢三");
////        Nde<String> nde5 = new Nde<>("车厢四");
////        nde1.setText(nde2);
////        nde2.setText(nde3);
////        nde3.setText(nde4);
////        nde4.setText(nde5);
////        prit(nde1);
        /*
        处理很麻烦
            ------进化------
            准备一个专门的链表操作类--并且作为内部类出现--先定义一个标准
         */
    }
    public static void prit(Nde<?> node){
        //不等于空--有节点
        if (node != null){
            System.out.println(node.getData());
            //递归调动
            prit(node.getText());
        }
    }
}
