/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: array.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

//一个数据操作类
class ArrayUtil{
    private int sum;
    private double avg ;
    private int max ;
    private int min ;

//    进行数组计算
    public ArrayUtil(int data[]){
        this.max = data[0] ;
        this.min = data[0];
        for (int i = 0 ;i < data.length;i ++){
            if (data[i] > max){
                this.max = data[i] ;
            }
            if (data[i] < min){
                this.min = data[i];
            }
            this.sum += data[i] ;

        }
        this.avg = this.sum / data.length ;
    }

    public static void sort(int data[]){
        for (int j = 0; j < data.length;j++){
            for (int i = 0;i< data.length - j - 1;i++){
                if (data[i]>data[i+1]){
                    int temp = data[i];
                    data[i] = data[i+1];
                    data[i+1] = temp ;
                }

            }
        }
    }

//    转置
    public static void reverse(int data[]){

//        确定转换次数
        int center = data.length / 2;
//        操作的角标1
        int head = 0;
//        操作的角标2
        int tail = data.length - 1;
        for (int i = 0 ; i < center; i++){
            int temp = data[head];
            data[head] = data[tail];
            data[tail] = temp;
            head++;
            tail--;
        }

    }    //    修改数组的方法：修改数组public static void changeArray(){}

    //    使用方法定义()并返回数组
    public static void pringArray(int temp []){
        for (int i = 0;i < temp.length;i++){
            System.out.println(temp[i]);
        }
    }


    public int getSum() {//返回总和
        return this.sum;
    }

    public double getAvg() {
        return this.avg;
    }

    public int getMax() {
        return this.max;
    }

    public int getMin() {
        return this.min;
    }
}

class Pson{
    private String name ;
    private int age ;
    public Pson(){}
    public Pson(String name,int age){
        this.name = name ;
        this.age = age ;
    }
    public String getInfo(){
      return "姓名：" + this.name + "、年龄：" + this.age ;
    }

}

public class array {
    public static void main(String[] args) {
//        数组的概念：一种相关变量的集合
//                定义格式：
//        1、数组的动态初始化：初始化之后，数组每一个元素的保存内容为其对应数据类型的默认值
//            声明并初始化数组：数据类型 数组名称 [] = new 数据类型 [长度] ;
//                            数据类型 [] 数组名称 = new 数据类型 [长度] ;
//
//        2、数组的静态初始化：在数组定义的时候就为其设置好内容
//                简化格式：数据类型 数据名称 [] = {数据1,数据2,...,数据n}
//                完整格式：数据类型 数据名称 [] = new 数据类型[]{数据1,数据2,...,数据n}
//        1、动态初始化定义数组
//        int data [] = new int[3] ;

//        System.out.println(data[0]);
//        System.out.println(data[1]);
//        System.out.println(data[2]);
//        2、数组操作：常用for循环完成
//        for (int i = 0;i < data.length;i++){
//            System.out.println(data[i]);
//
//        }
//        3、数组的长度可以使用“数组名称.length”来进行获得
//        System.out.println(data.length );
//        以后开发过程中见到最多的数组使用形式：进行数组的循环处理
//        4、静态初始化
//        int dat [] = new int[] {10,20,50};



//        数组的引用传递
//        数组属于引用数据类型：一个堆内存可以被多个栈内存所指向


//        foreach输出
//        传统采用数组下标来访问
//                为了解除下标的影响（处理不当会越界）
//        增强型的for循环--foreach:直接获取数组中的每一个元素，避免下标访问

//        int data [] = new int[] {10,50,60};
////        自动循环
//        for (int temp : data){
//            System.out.println(temp);
//
//        }

//        二位数据:多行多列的数据
//        传统的数组就好比是一行数据：1,2,5,6,...,n
//        定义语法：
//            数组的动态初始化：数据类型 数组名称 [][] = new 数据类型[行个数][列个数];
//            数组的静态初始化：数据类型 数组名称 [][] = new 数据类型[行个数][列个数] {{数据,数据},{数据,数据},...,{数据,数据}};
//        int data [][] = new int[][]{
//                {1,2,0,3},{2,5,4,0,2}
//        } ;
//        for (int i = 0 ;i < data.length;i++){
//            for (int j = 0; j < data[i].length ; j++){
//                System.out.println("data["+i+"]["+j+"] = "+data[i][j]);
//            }
//
//        }
//        System.out.println();
//        使用foreach输出

//        for (int temp[] : data){
//            for (int num : temp){
//                System.out.println(num + "、");
//            }
//            System.out.println();
//        }
//        数组与方法
//        实现数组的引用传递

//        int data [] = new int[] {10,50,52,30} ;
//        pringArray(data);
//        ArrayUtil arrayUtil = new ArrayUtil(data) ;
//        System.out.println("数据的总和：" + arrayUtil.getSum());
//        System.out.println("数据的最大值：" + arrayUtil.getMax());
//        System.out.println("数据的最小值：" + arrayUtil.getMin());
//        System.out.println("数据的平均值：" + arrayUtil.getAvg());
//        int data [] = intiArray() ;


//        数组的排序

//        int data [] = new int[]{1,5,6,3,5,10,2};
//        ArrayUtil.sort(data);
//        ArrayUtil.pringArray(data);

//        数组的转置操作
//        第一种会产生垃圾空间
//        int data [] = new int[]{1,2,3,4,5,6,7};
//        int temp [] = new int[data.length];
//        //第二个数组的角标
//        int foot = temp.length - 1;
//        for (int i = 0; i < data.length ;i++){
//            temp[foot --] = data[i];
//        }
//        data = temp ;
//        ArrayUtil.pringArray(data);

//        第二种：在一个数组上转置 最好将其放入类中完成
//        int data [] = new int[]{1,2,3,4,5,6,7};
//        ArrayUtil.reverse(data);
//        ArrayUtil.pringArray(data);

//        数组相关的操作方法：（开发中使用的）
//            1、数组排序：Java.util.Arrays.sort(数组名称)
//        int data [] = new int[]{1,4,3,6,5,2,7};
//        java.util.Arrays.sort(data);
//        ArrayUtil.pringArray(data);
//            2、数组拷贝（把方法做了变形）：System.arraycopy(原数组, 原数组开始点, 目标数组, 目标数组开始点, 拷贝长度);
//        int dataA [] = new int[]{1,2,3,4,5,6,7,8,9};
//        int dataB [] = new int[]{11,22,33,44,55,77,88,99};
//        System.arraycopy(dataA,5,dataB,3, 3);
//        ArrayUtil.pringArray(dataB);

//       方法可变参数


//        对象数组：
//        动态数组初始化：类 对象数组名称[] = new 类[长度]（每一个元素都是null）;
//        静态数组初始化：类 对象数组名称[] = new 类[长度]{实例化对象,实例化对象,....,实例化对象}
//        动态初始化
        Pson pson [] = new Pson[3];
        for (int i = 0 ;i < pson.length ;i++){
            System.out.println(pson[i]);
        }

    }
//    要求接受一个int型的数组

    public static int [] intiArray(){
        int arr[] = new int[]{1,2,35,2};
        return arr;

    }

//    可变参数相当于变种数组 最大作用
//    在进行程序类设计的时候或者开发者调用的时候，就可以避免数组的传递操作（可变参数的本质：依然是数组）多了灵活性

    public static int sum(int ... data){
        int sum = 0;
        for (int temp : data){
            sum += temp;

        }
        return sum;
    }

}
