/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: Packaging_class.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

class Int{
    //包装了一个基本数据类型
    private int data;

    public Int(){}
    public Int(int data){
        this.setData(data);
    }
    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

}

public class Packaging_class {
    public static void main(String[] args) {
        /*
          包装类的主要功能：针对于基本数据的对象转换而实现的
          简介：基本数据不是类，如果想将基本数据类型进行类处理，则需要进行包装
          以int数据为例实现包装处理
         */
        //装箱：将基本数据类型保存在包装类之中
        Int temp = new Int(10);
        //拆箱：从包装类中获取基本数据类型
        int x = temp.getData();
        /*
        包装类一共有两种类型：
            1、对象型的包装类（object直接子类）Boolean、Character
            2、数值型包装类(抽象类number直接子类)：Byte,Short,integer,long,float,等
         */

    }
}
