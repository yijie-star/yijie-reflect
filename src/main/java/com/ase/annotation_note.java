/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: annotation_note.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

public class annotation_note {
    public static void main(String[] args) {
        /**
         * 是从jdk1.5之后，提出的一个新的开发结构，可以有效的减少程序配置代码
         * 并且可以进行一些结构化的定义，是以一种注解的形式实现程序开发
         *
         * 过程一：将所有可能使用到的资源全部定义在程序代码之中
         *
         * 过程二：引用配置文件在配置文件之中定义全部需要使用的服务器资源
         *
         * 过程三：将配置信息重新写回到程序里面利用一些特殊的标注，与程序代码进行分离这就是注解的作用
         *
         * 现目前基本按照配置问价 + 注解完成的
         *
         * 几个基本注解：
         * @Override  @Deprecated  @SuppressWarnings
         */

        //准确覆写@Override

        /*
        当一个子类继承一个父类之后  ，往往会采用覆写的形式对某些方法重写
        在程序编译时，帮助开发者检查井出错误
         */
        // @Deprecated 过期声明

        /*
        新版本出现，有些程序或类考虑不周，使用过期注解
         */

        //压制警告

        /*
        已经明确知道了错误的位置，只是让警告信息不出现
         */





    }
}
