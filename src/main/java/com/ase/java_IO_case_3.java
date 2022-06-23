/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_IO_case_3.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

import java.util.Arrays;

public class java_IO_case_3 {
    public static void main(String[] args) {
        /*
        从键盘传入多个字符串到程序中，并将他们按逆序输出在屏幕上
         */
        new Menu();

    }
}
//1、定义字符串的操作标准
interface IStringService {
    void append(String str);//追加数据
    String[] reverse();//反转处理
}
//2、实现子类
class StringServiceImpl implements IStringService{
    private StringBuffer data = new StringBuffer();

    @Override
    public void append(String str) {
        this.data.append(str).append("|");
    }

    @Override
    public String[] reverse() {
        String result [] = this.data.toString().split("\\|");
        int center = result.length / 2;
        int head = 0;
        int tail = result.length - 1;
        for (int i = 0; i < center; i++) {
            String temp = result[head];
            result[head] = result[tail];
            result[tail] = temp;
        }
        return result;
    }
}
//3、工厂类实现
class StringFactory{
    private StringFactory(){}
    public static IStringService getInstance(){
        return new StringServiceImpl();
    }
}
//4、定义一个Menu处理类，采用交互式的界面形式完成处理
class Menu{
    private IStringService stringService;
    public Menu(){
        this.stringService = StringFactory.getInstance();
        this.choose();
    }
    public void showMenu() {
        System.out.println("【1】、追加字符数据：\n");
        System.out.println("【2】、逆序显示所有字符串数据：\n");
        System.out.println("【0】、结束程序！");
        System.out.println("\n\n");
    }
    public void choose(){
        this.showMenu();
        String choose = InputUtil.getString("请进行选择：");
        switch (choose){
            case "1":{
                String str = InputUtil.getString("请输入字符串数据：");
                this.stringService.append(str);
                choose();
            }
            case "2":{

                String result [] = this.stringService.reverse();
                System.out.println(Arrays.toString(result));
                choose();
            }
            case "0":{
                System.out.println("下次再见!");
                System.exit(1);
            } default:{
                System.out.println("您输入了非法的选项，请核对后再输入！");
                choose();
            }
        }
    }
}
