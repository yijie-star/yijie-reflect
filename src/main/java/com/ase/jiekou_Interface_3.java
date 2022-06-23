/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: jiekou_Interface_3.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;
//定义一个食物的标准
interface IFood{
    public void eat();


}
//定义一种食物
class Bread implements IFood{
    @Override
    public void eat() {
        System.out.println("吃面包！");

    }
}
class Milk implements IFood{
    @Override
    public void eat() {
        System.out.println("吃牛奶！");

    }
}
//如果以后要进行子类的扩充，只需要修改Factory程序类实现
class Factoryv{
    public static IFood getInstance(String className){
        if ("bread".equals(className)){
            return new Bread();

        }else if ("milke".equals(className)){
            return new Milk();
        }else {
            return null;

        }
    }

}

public interface jiekou_Interface_3 {
    public static void main(String[] args) {
        //工厂设计模式 （Factory）
        /*
        对于接口：必须有子类，并且子类可以通过对象的向上转型来获取接口的实例化对象
        在对象实例化过程中，也存在有设计问题

         */
        //明确地知道子类
        IFood food = Factoryv.getInstance(args[0]) ;
        food.eat();
        /*
        根据接口进行 子类的定义，并且利用对象的向上转型进行接口的实例化处理
        程序表示会出现耦合的问题
         */


    }
}
