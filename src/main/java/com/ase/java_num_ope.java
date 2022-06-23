/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_num_ope.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

public class java_num_ope {
    public static void main(String[] args) {
        /*
        math数学操作类：
            类中的所有方法被私有化，所有提供的方法都是static方法，即这些方法都可以通过类名称直接调用
            提供的都是基础的数学公式，需要的时候需要自己重新整合
         */
        /*
        java.util.Random主要功能是产生随机数
            产生一个不大于边界的随机正整数：public int nextInt(int bound)

         */
        /*
        大数字的操作类：（超过double的范围）最早通过string保存
            提供biginteger和bigdecimal
         */

        /*
        日期处理类：
            java.util.Date类，直接实例化可以获取当前的日期
                Date类中只是对long数据的一种包装，提供有转换方法
                将long转为date：public Date(long date
                将date转换为long：public long getTime()
                long之中可以保存毫秒额数据级，这样方便程序处理
         */
        /*
        日期格式化出处理：
            java.text.SimpleDateFormat：

         */
    }
}
