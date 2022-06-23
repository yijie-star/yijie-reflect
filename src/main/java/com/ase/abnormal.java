/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: abnormal.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

import javax.xml.transform.Source;
import java.lang.annotation.Annotation;

class MyMath{
    //这个代码执行时可能会产生异常 如果产生异常调用处处理
    public static int div(int x,int y) throws Exception {
        int temp= 0;
        System.out.println("[1]除法计算开始！");
        try {
            temp= x / y;
        }catch (Exception e){
            //向上抛异常对象
                throw e;
        }finally {
            System.out.println("[1]除法计算结束！");
        }
        return temp;
    }
}
public class abnormal {
    public static void main(String[] args) {
        /*
        认识：异常指的是导致程序中断执行的一种指令流。
            没有异常：程序从头到尾执行
            出现异常：出现错误之后，程序不会按照既定的方式进行执行，而是中断执行
         */
        /*
        处理异常：使用try ,catch ,finally 来完成
            要想获得非常完整的异常信息，则可以使用异常类中的pintStackTrace()方法
         */
        /*
        处理多个异常：
            即使用多个catch进行处理

         */
        /*
        throws关键字：在方法上使用throws关键字来进行异常类型的标注
        使用
         */
//        try {
//            System.out.println(MyMath.div(10, 2));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        /*
        throws与throw的区别：
            throw表示手工进行异常的抛出
                throw是在代码块中使用的主要是手工进行异常的抛出
                throws是在方法中定义的，表示将此方法中可能产生的异常明确告诉给调用处由调用处处理
         */

        /*
        标准格式：
            定义一个实现除法计算的方法，要求如下：
                在进行数据计算看开始与结束的时候进行信息提示
                如果在计算过程之中产生了异常则要交给调用处来进行处理
         */
        try {
            System.out.println(MyMath.div(10,2));
        }catch (Exception e){
            e.printStackTrace();
        }
        /*
        面试题：RuntimeException与Exception的区别？
            RuntimeException是Exception的子类；
            RuntimeException标注的异常可以不需要进行强制性的处理而Exception必须强制性处理
            请例举出你常见的RuntimeException
                javase docx 文档
         */
        /*
        自定义异常类：
            实现方案：
                继承Exception,或继承RuntimeException

         */

        /*
        断言的功能：
         */
    }
}
class BomException extends Exception{
    public BomException(String msg){
        super(msg);
    }
}
class Fod{
    public static void eat(int num) throws BomException {
        if (num > 10){
            throw new BomException("吃太多了");
        }else {
            System.out.println("正常吃，不怕吃胖！");
        }
    }
}