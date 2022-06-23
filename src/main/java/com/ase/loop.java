/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: loop.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;



import java.util.Scanner;

public class loop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        if分支：主要是针对关系表达式判断处理的分支操作
//        System.out.println("请输入您的年龄： ");
//        int age = sc.nextInt();
//        if (age >= 18 && age <= 20){
//            System.out.println("适合");
//        }else{
//            System.out.println("不适合");
//        }
//         switch 语句：只能判断的是数据（int,char,枚举）不能进行逻辑判断
//        int ch = 2;
//        switch (ch){
//            case 1:{
//                System.out.println("设置的内容是2");
//                break;
//            }
//
//            case 2:{
//                System.out.println("设置的内容是1");
//                break;
//            }
//
//            default:{
//                System.out.println("没有内容满足");
//                break;
//            }
//
//        }
//        while 循环:
//         int sum = 0;
//         int num = 1;
//         while (num <= 100){
//             sum += num;
//             num++;
//        }
//         System.out.println(sum);

//        do...while循环
//        int sum = 0;
//        int num = 1;
//        do {
//            sum += num;
//            num++;
//       }while (num <= 100);
//        System.out.println(sum);
//        for 循环
//        int sum = 0;
//        for (int x = 1;x<=100;x++){
//            sum += x;
//        }
//        System.out.println(sum);

//        循环控制：break,continue

//        循环嵌套
        int i,j;
        for (i = 1;i < 10;i++){
            for (j = 1;j <= i;j++){
                int product = i*j;
                System.out.print(j + "*" +i + "=" + product + "\t");
            }
            System.out.println();
        }

//        打印三角形
        int line = 5;
        for (int x = 0;x < line ;x++){
            for (int y = 0;y < line - x;y++){
                System.out.print(" ");
            }
            for (int y = 0; y <= x ;y++){
                System.out.print("* ");

            }
            System.out.println();
        }



    }


}
