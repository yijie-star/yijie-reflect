/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: jiekou_Interface_1.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;


//由于类名称与接口名称的定义要求相同，为了区分往往会加上字母 I （interfece）
//定义一个接口
//此时的接口无法直接产生实例化对象
interface IMssge{
    //全局常量
    public static final String INFO = "https://www.baidu.com";
    //抽象方法
    public abstract String getInfo();
}
interface IChannl{
    public abstract boolean connect();
}

//实现子类接口
class MssgeImpl implements IMssge,IChannl{
    @Override
    public String getInfo() {
        if (this.connect()){
            return "520";
        }
        return "发送失败";
    }

    @Override
    public boolean connect() {
        System.out.println("通道成功");
        return true;
    }
}

public interface jiekou_Interface_1 {
    public static void main(String[] args) {


        /*
        当你可以灵活的使用抽象类和接口设计的时候，那么基本上表示面向对象熟练掌握
        基本定义：
            抽象类与普通类相比最大的优势在于对子类覆写方法的控制，但是在抽象类可能会保留一些普通方法，
            而普通方法可能会涉及到安全或者隐私
        因此，开发过程中，要想对外部隐藏全部的实现细节，则通过接口来进行描述。

        可理解为一个纯粹的抽象类（最原始的定义接口之中是只包含抽象方法与全局常量的）

        使用interface关键字来定义：
                使用原则：
                    1、接口需要被子类实现（implements）,一个子类可以实现多个接口
                    2、子类（不是抽象类）一定要覆写接口之中的全部抽象方法
                    3、接口对象可以利用子类的向上转型进行实例化
         */
        IMssge msg = new MssgeImpl();

        System.out.println(msg.getInfo());
        //通过接口调用输出全局常量
//        System.out.println(IMssge.INFO);
        /*
        说明：使用接口主要目的是一个子类可以实现多个接口，利用接口实现多继承的概念
        但是需要考虑实际情况：对象的转型问题
            子类对象可以任意的父接口的转换
            接口不允许继承父类，但是一个接口却可以通过extends继承若干个父接口 成为接口的多继承
                接口可以通过object接收，
            接口之中所有的抽象方法的访问权限都为public

            接口中的abstract可以省略，但抽象类中的不可以省略abstract
         */

        /*
        在开发之中，有三种形式：
            进行标准设置
            表示一种操作的能力
            暴露远程方法视图 一般在RPC分布式开发中使用
         */

    }
}
