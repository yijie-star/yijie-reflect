/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: mthod.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

public class mthod {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入您的钱：");
//        double money = sc.nextDouble();
//        System.out.println(getMeal(money));
//        方法重载
//        int resultA = sum(10,20);
//        int resultB = sum(10,20,30);
//        double resultC = sum(10.5,50.0);
//        System.out.println("执行结果：" + resultA);
//        System.out.println("执行结果：" + resultB);
//        System.out.println("执行结果：" + resultC);
//        方法的递归调佣
        System.out.println(sum(100));
    }
//    方法方便进行重负调佣
    public static void printMessage(){

    }

    public static String getMeal(double money){
        if (money >= 10.0){
            return "给您一份汉堡！ 找零：" + (money - 10.0);
        }else {
            return "对不起，您的余额不足，请先充值！";
        }
    }
//    重载：方法重载是指在一个类中定义多个同名的方法，但要求每个方法具有不同的参数的类型或参数的个数。
    public static int sum(int x,int y){
        return x + y ;
    }
    public static int sum(int x,int y,int z){
        return x + y +z;
    }
    public static double sum(double x,double y){
        return x + y;
    }

    public static int sum(int num){
        if (num == 1){
            return 1;
        }
        return num + sum(num -1);
    }
}
