/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_IO_case_1.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;


import java.util.Scanner;

public class java_IO_case_1 {
    public static void main(String[] args) {
        /*
        编写java程序，输入3个整数，并求出3个整数的最大值和最小值
         */
        //5、编写测试程序类
        INumberService numberService = FactoryNumber.getInstance();
        int result [] = numberService.stat(3);
        System.out.println("最大值：" + result[0] + "  最小值：" + result[1]);
    }
}
/*
4、定义工厂类获取接口对象
 */
class FactoryNumber{
    private FactoryNumber(){}
    public static INumberService getInstance(){
        return new NumberServiceImpl();
    }
}
/*
3、定义接口的实现子类
 */
class NumberServiceImpl implements INumberService{

    @Override
    public int[] stat(int counter) {
        int result[] = new int[2];//定义返回的结果
        int data [] = new int[counter];//开辟一个数组，长度为counter
        for (int i = 0; i < data.length; i++) {
            data[i] = InputUtil.getInt("请输入第“" + (i+1) + "”个数字：");
        }
        result[0] = data[0];
        result[1] = data[0];
        for (int i = 0; i < data.length; i++) {
            if (data[i] > result[0]){
                result[0] = data[i];
            }
            if (data[i] < result[1]){
                result[1] = data[i];
            }
        }
        return result;
    }
}
/*
2、定义一个输入的处理接口标准
 */
interface INumberService{
    /**
     * 输入数据并且返回数据的最大值与最小值
     * @param counter 输入数据的个数
     * @return 包含两个内容，第一个是最大值，第二个是最小值
     */
    public int[] stat(int counter);
}
/*
1、定义一个输入工具类
 */
class InputUtil{

    private InputUtil(){}

    /**
     * 实现键盘接收的操作
     * @param prompt 提示信息
     * @return 一个可以使用的数字
     */
    public static int getInt(String prompt){
        int num = 0;
        boolean flag =  true;

        while (flag){
            Scanner input = new Scanner(System.in);
            System.out.println(prompt);//打印提示信息

            if (input.hasNext("\\d+")){//hasNextInt如果输入的是整型，则返回true

                num = Integer.parseInt(input.next("\\d+"));//返回数据
                flag = false;
            }else {
                System.out.println("输入的内容不是数字！");
            }
        }
        return num;
    }
    public static String getString(String prompt){
        String str = null;
        boolean flag = true;
        while (flag){
            Scanner input = new Scanner(System.in);
            System.out.println(prompt);
            if (input.hasNext()){
                str = input.next().trim();
                if (!"".equals(str)){//不是空字符串
                    flag = false;//结束循环
                }else {
                    System.out.println("输入的内容不允许为空！");
                }
            }else {
                System.out.println("输入的内容不允许为空！");
            }
        }
        return str;
    }

}
