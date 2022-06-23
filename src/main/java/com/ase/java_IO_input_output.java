/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_IO_input_output.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class java_IO_input_output {
    public static void main(String[] args) throws IOException {
        /*
        打印流： 本质在于提高已有类的功能
            PrintStream、PrintWriter
            只要是程序进行输出的时候全部使用打印流
            实现：
        File file = new File("E:" + File.separator + "output.txt");
        格式化输出：printf函数
         */
        /*
        system（系统类）对IO 的支持：提供有三个常量
            错误输出：static final PrintStream err   The "standard" error output stream.
            标准输入（键盘）：static final InputStream in    The "standard" input stream.
            标准输出（显示器）：static final PrintStream out   The "standard" output stream.
        System.out和System.err是同一种类型：
            目的：System.out是输出那些希望用户看见的信息，System.err输出不希望用户看见的信息
         */
        /*
        缓冲输入流：BufferedReader  不止一个
        public String readLine() throws IOException 重要--读取一行数据
        实现：


        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入信息：");
        String msg = input.readLine();//接收输入信息
        System.out.println("输入的的内容为：" + msg);

         */
        /*
        Scanner扫描流：
            解决输入流的访问问题，可以理解为BufferedReader的替代类
            可以直接利用正则进行判断
            实现：

         */
        Scanner scan =  new Scanner(System.in);
        System.out.println("请输入年龄：");
        if (scan.hasNextInt()){//判断是否有整数数据输入
            int age = scan.nextInt();//直接获取数据
            System.out.println("年龄：" + age);
        }
    }
}
