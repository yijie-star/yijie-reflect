/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_reflex_and_class.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

public class java_reflex_and_class {
    public static void main(String[] args) {
        /*
        反射获取类结构信息：
            1、获取父类信息：
                类的基本信息：包名称、父类的定义、父接口的定义
                Class类中的方法：
                    1、获取包名称：getPackage()、getPackageName()
                    2、获取继承父类：public Class<? super T> getSuperclass()
                    3、获取父接口：public Class<?>[] getInterfaces()
            2、反射调用构造方法：
                实例化方法替代：clazz.getDeclaredConstructor().newInstance()
                获取所有构造方法：public Constructor<?>[] getDeclaredConstructors()
                               throws SecurityException

                               public Constructor<?>[] getConstructors()
                               throws SecurityException
                获取指定构造方法：public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
                               throws NoSuchMethodException,SecurityException

                               public Constructor<T> getConstructor(Class<?>... parameterTypes)
                                throws NoSuchMethodException,SecurityException
            3、反射调用普通方法：
                获取全部方法：
                获取指定方法：
                获取本类全部方法：
                获取本类指定方法：

            4、反射调用成员：
                获取本类全部成员：
                获取本类指定成员：
                获取父类全部成员：
                获取父类的指定成员：
         */
        /*
        Unsafe工具类：利用反射来获取对象，并且直接使用底层的C++来代替JVM执行  即绕过JVM相关的管理机制

         */
    }
}
