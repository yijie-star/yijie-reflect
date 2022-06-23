/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: jiekou_Interface_4.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

interface IEat{
    public void get();

}
//真正吃饭的人
class EatReal implements IEat{
    @Override
    public void get() {
        System.out.println("得到食物，开始吃！");
    }
}
//为吃来服务，即服务代理
class EatProxy implements IEat{
    //为吃而服务
    private IEat iEat;
    //代理项
    public EatProxy(IEat iEat){
        this.iEat = iEat;

    }
    public void prepare() {
        System.out.println("1、购买食材");
        System.out.println("2、处理食材");
    }

    @Override
    public void get() {
        this.prepare();
        this.iEat.get();
        this.clear();
    }
    public void clear(){
        System.out.println("清洁");

    }

}

public interface jiekou_Interface_4 {
    //修饰符 'public' 对于接口成员是冗余的
    static void main(String[] args) {
        /*
        代理设计模式：主要功能是帮助用户将所有的开发注意力只集中在
        核心业务功能的处理上
         */
        //实现代理模式
        IEat eat =  new EatProxy(new EatReal());
        eat.get();
        /*
        主要设计特点：
            一个接口提供有两个子类其中一个子类是真实业务操作，另一个代理业务操作（真实业务无法进行）
         */


        /*
        抽象类与接口的区别：
                            抽象类                              接口
            1、定义：abstract class 抽象类名{}   interface 接口名称{}
            2、组成：构造方法、普通方法静态方法全局常量、成员、static方法     抽象方法、全局常量、普通方法、static方法
            3、权限：可以使用各种权限定义      只能够使用public
            4、子类使用：通过 extends关键字继承一个抽象类      子类使用implements关键字实现多个接口
            5、关系：抽象类可以实现若干个接口      接口不允许继承抽象类，但是允许继承多个父接口
            6、使用：抽象类或接口必须定义子类、子类一定要覆写抽象类或接口中的全部抽象方法、通过子类向上转型实现抽象类或接口的实例化
         */
        /*
        如果抽象类和子类都可以使用的话，优先考虑使用接口，可以避免子类的单继承局限
         */
    }
}
