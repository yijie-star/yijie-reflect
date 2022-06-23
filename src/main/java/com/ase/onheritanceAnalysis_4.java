/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: onheritanceAnalysis_4.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

//数组操作类
class Arrays{
    private int data [];
    //角标索引控制
    private int foot;

    public Arrays(int len){
        if (len > 0){
            //开辟数组
            this.data = new int[len];
        }else {
            this.data = new int[1];
        }
    }
    //容量扩充 实际大小=已有大小 + 扩充大小
    public void increment(int num){
        int newData []= new int[num + this.data.length];
//        进行拷贝数据
        System.arraycopy(this.data, 0, newData, 0, this.data.length);
        //改变数组引用
        this.data = newData;
    }


    //数据增加
    public boolean add(int num){
        //有位置
        if (this.foot < this.data.length){
            this.data[this.foot ++] = num;
            return true;
        }
        return false;
    }
    public int[] getData() {
        return this.data;
    }
}

//定义排序子类
class SortArray extends Arrays{

    public SortArray(int len){
        super(len);
    }
    //获得排序结果
    public int [] getData(){
        //直接排序
        java.util.Arrays.sort(super.getData());
        return super.getData();
    }
}
//定义翻转子类
class ReverseArray extends Arrays{
    public ReverseArray(int len){
        super(len);
    }

    @Override
    public int[] getData() {
        int center = super.getData().length / 2;
        int head = 0;
        int tail = super.getData().length - 1;
        for (int i = 0;i < center;i++){
            int temp = super.getData()[head];
            super.getData()[head] = super.getData()[tail];
            super.getData()[tail] = temp;
            head++;
            tail--;
        }
        return super.getData();
    }
}

public class onheritanceAnalysis_4 {
    public static void main(String[] args) {
        /**
         * 建立一个实现整型数组的操作类（Arrays），而后在里面可以操作数组的大小由外部决定
         * 需提供数组的处理：进行数据的增加（如果数据满了就无法增加）、可以实现数组容量扩充、取得全部数组内容
         * 完成之后再此基础上派生出两个子类：
         *      数组排序类：返回数组必须是已排序后的结果
         *      数组反转类：可以实现内容的首尾交换
         */
        ReverseArray arr = new ReverseArray(5);
        System.out.println(arr.add(20));
        System.out.println(arr.add(3));
        System.out.println(arr.add(2));


        //arr.increment(5);
        System.out.println(arr.add(4));
        System.out.println(arr.add(6));
//        System.out.println(arr.add(1));
//        System.out.println(arr.add(10));
        int res [] = arr.getData();
        for (int temp : res){
            System.out.println(temp);
        }


    }
}
