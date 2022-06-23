/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: jiekou_Interface_2.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

//定义了USB标准
interface IUSB{
    public boolean check();
    public void work();

}
class Compter{
    public void plugin(IUSB iusb){
        if (iusb.check()){
            //开始工作
            iusb.work();

        }

    }
}

class Keyboad implements IUSB{
    @Override
    public boolean check() {
        return true;
    }

    @Override
    public void work() {
        System.out.println("可以开始打字了！");
    }
}

class Prin implements IUSB{
    @Override
    public boolean check() {
        return false;
    }

    @Override
    public void work() {
        System.out.println("开始进行打印！");
    }
}
public interface jiekou_Interface_2 {
    public static void main(String[] args) {
        /*
        接口的主要特点是由全部抽象方法和全局常量组成，项目设计不当，出现的问题：
        如果子类非常多，就需要覆写多次方法，并且实现功能一样

        为了不让子类直接实现接口，而是在中间追加一个过度的抽象类：不能被直接实例化（jdk1.8后改变）

        接口中的普通方法需使用default声明，但是该操作属于挽救功能，所以不是必须情况下，不应该作为设计的首选

        除了追加普通方法，也可以定义static方法，并且可以直接通过接口进行调用：这两个方法已经可以取代抽象类，但是
        建议还是奉行：接口就是抽象方法
         */

        /*
        定义标准：（现实开发中，对于标准的概念无处不在）
            主要是看标准

         */
        Compter compter = new Compter();
        compter.plugin(new Keyboad());
        compter.plugin(new Prin());



    }
}
