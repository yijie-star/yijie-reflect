/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: ac_and_ife_1.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

interface IClassName{
    //数据一定要返回
    public String getClassName();
}
class Company implements IClassName{
    @Override
    public String getClassName() {
        return "company";
    }
}

public class ac_and_ife_1 {
    public static void main(String[] args) {
        IClassName ica = new Company();
        System.out.println(ica.getClassName());
        /*
        接口前追加一个字母I是是良好的习惯---定义原则
         */
    }
}
