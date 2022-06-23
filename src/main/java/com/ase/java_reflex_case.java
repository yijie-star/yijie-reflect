/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_reflex_case.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

public class java_reflex_case {
    public static void main(String[] args) {
        /*
        反射实例化对象：
            jdk1.9前：@Deprecated(since="9")
                     public T newInstance()throws InstantiationException,IllegalAccessException

        clazz.newInstance()  （被替换can be replaced by）  clazz.getDeclaredConstructor().newInstance()
        任何情况下要实例化对象则一定要调用类中的构造方法
            通过反射实现对象的实例化处理，依然要调用类中的无参构造方法  其本质等价于“类 对象 = new 类();”
            被替代原因：newInstance（）方法只能调用无参构造方法
         */

        /*
        反射与工厂设计模式：
            不适用工厂设计直接实例化对象会产生耦合问题；

            1、没有产生实例化对象的意义，所以工厂设计的构造方法私有化：private Factory(){}


            解决方案：不适用关键字new来设计工厂类--原因：使用的时候需要有一个明确的类存在

            利用反射机制实现的工厂类，优势在于即使接口的子类不断扩充，也不需要修改工厂类
         */

        /*
        单例设计：在整体运行之中只允许产生一个实例化对象，有若干个线程后就可以产生多个实例化对象--不是单例设计模式了（解决出现的问题：同步处理synchronized）
        synchronized带来的后果：效率低 （整体代码只有一部分需要进行同步处理）

        合理的同步处理：

         面试题：
            请编写单例设计模式：
                1、直接编写一个饿汉式的返利设计模式，并且实现构造方法的私有化
                2、在java中哪里使用到了单例设计模式了Runtime类、Class、Pattern、Spring框架
                3、懒汉式单例设计模式的问题？---效率低，只进行一部分需要进行同步处理
         */
        /*
        工厂设计模式与annotation整合:

         */

    }
}
/* 工厂类模板
class Factory{
    private Factory(){}
    public static 接口名称 getInstance(String str) {
         接口名称 instance = null;
         try {
             instance = (接口名称)Class.forName(str).getDeclaredConstructor().newInstance();
         }catch (Exception e){
             e.printStackTrace();
         }
        return instance;
    }
}

 */

//工厂类为所有的接口服务：泛型
class Factory{
    private Factory(){}
    /**
     * 获取接口实例化对象
     * @param str 接口的子类
     * @param clazz 描述的是接口的类型
     * @return 如果接口存在则返回接口实例化对象
     * @param <T>
     */
    public static <T> T getInstance(String str,Class<T> clazz) {
         T instance = null;
         try {
             instance = (T)Class.forName(str).getDeclaredConstructor().newInstance();
         }catch (Exception e){
             e.printStackTrace();
         }
        return instance;
    }
}




