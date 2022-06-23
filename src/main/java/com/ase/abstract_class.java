/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: abstract_class.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

//定义了一个抽象类
abstract class Mag{
    private String type;

    //抽象方法，（后面没有大括号）
    public abstract String getConnectInfo();
    //普通方法
    public void setType(String type) {
        this.type = type;
    }
    //普通方法
    public String getType() {
        return this.type;
    }
}
class DataMag extends Mag{
    @Override
    public String getConnectInfo() {
        return "成功覆写";
    }
}

//行为的模式定义
abstract class Action{
    //定义的是常量
    public static final int EAT = 1;
    public static final int SLEEP = 2;
    public static final int WORK = 3;
    public void command(int code) {
        switch (code){
            case EAT :{
                this.eat();
                break;
            }
            case SLEEP:{
                this.sleep();
                break;
            }
            case WORK:{
                this.work();
                break;
            }
            case EAT + SLEEP + WORK:
                this.eat();
                this.work();
                this.sleep();
                break;
        }
    }
    public abstract void eat();
    public abstract void sleep();
    public abstract void work();
}
//机器人的模式
class Robot extends Action{
    @Override
    public void eat() {
        System.out.println("机器人需要接通电源充电！");
    }

    @Override
    public void sleep() {
        //机器人不休息就暂时空着
    }

    @Override
    public void work() {
        System.out.println("机器人按照设定的程序不停的工作！");
    }
}
//人的模式定义
class Pso extends Action{
    @Override
    public void eat() {
        System.out.println("安静地坐着吃饭！");
    }

    @Override
    public void sleep() {
        System.out.println("安静的躺下睡觉！");
    }

    @Override
    public void work() {
        System.out.println("有想法的工作！");
    }
}
//猪的模式设定
class Pig extends Action{
    @Override
    public void eat() {
        System.out.println("吃石槽中人类投喂是粮食！");
    }

    @Override
    public void sleep() {
        System.out.println("倒地就睡！");
    }

    @Override
    public void work() {

    }
}

public class abstract_class {
    public static void main(String[] args) {
        /**
         * 类继承的主要作用，在于可以扩充已有类的功能，
         * 发现：子类任意覆写父类的某一方法，而父类无法对子类进行强制性约定（强制父类某一方法）
         *
         * 在进行父类设计的时候，优先考虑抽象类
         *
         * 定义：对子类中覆写方法进行约定，定义抽象方法 即用关键字abstract定义的并且有提供方法体的方法
         *抽象类是无法直接用的，即无法实例化
         *
         * 当一个抽象类定义完成之后，（不是一个完整的类）要想使用，则必须按照一下原则：
         *      1、抽象类必须提供有子类，子类使用extends继承一个抽象类
         *      2、抽象类的子类（不是一个抽象类）一定要覆写抽象类中的全部抽象方法
         *      3、抽象类的对象实例化可以利用对象多态性通过子类向上转型的方式完成
         *
         *
         *      抽象类：比普通类增加了抽象方法以及对子类额强制性的覆写要求
         *
         *
         *      意见：
         *          1、 抽象类使用很大程度上有一个核心的问题：抽象类无法自己直接实例化
         *          2、抽象类之中主要的目的是进行过渡操作使用，当使用抽象类开发的时候需要解决类继承问题时带来的代码重复处理
         *
         *
         *
         *
         * 相关说明：
         *
         *      一个重要的面向对象向设计的结构，使用时需注意以下几点问题：
         *          1、在定义抽象类的时候绝对不能够使用final关键字来进行定义，因为抽象类必须有子类
         *          而final类是不能够有子类的
         *          2、抽象类是作为普通类的加强版出现的（组成是在普通类的基础上扩展而来的，只是追加了抽象方法）
         *          抽象类一定可以提供有构造方法，并且子类也一定会按照子类对象实例化原则进行构造调用
         *          3、抽象类中允许没有抽象方法，但是即使没有抽象方法，也无法直接使用关键字new实例化
         *          4、抽象类中可以提供有static方法，并且该方法不受到对象的局限（永远不受到限制）
         *
         *
         *
         * 应用：
         *
         *
         */
//        Mag mag = new DataMag();
//        System.out.println(mag.getConnectInfo());
        /*
        描述三类事务：
            机器人：不休息只知道补充能量和工作
            人类：需要休息、吃饭以及努力的工作
            猪：需要休息，不需要工作只需要吃饭
            行为是抽象的
         */
        //机器人的行为
        Action robot = new Robot();
        Action pon = new Pso();
        Action pig = new Pig();

        System.out.println("-----机器人的行为------");
        robot.command(Action.SLEEP);
        robot.command(Action.EAT);
        System.out.println("-----人行为------");
        pon.command(Action.EAT + Action.SLEEP + Action.WORK);
        System.out.println("-----猪的行为------");
        pig.command(Action.EAT + Action.SLEEP);
        /*
        现在已经完整的实现了一个行为的抽象处理，但是也需要做出一点点思考：
        父类主要的目的是对行为进行处理


        好处：
            1、对子类方法的统一管理，
            2、自身提供一些普通方法，可以调用抽象方法（在子类提供实现的时候才会生效）
         */

    }
}
