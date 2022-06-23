/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_basi_class.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

interface Issge extends AutoCloseable{
    public void send();
}
class Netssge implements Issge{

    private String msg;
    public Netssge(String msg){
        this.msg = msg;
    }
    public boolean open(){
        //获取资源链接
        System.out.println("获取消息发送链接资源");
        return true;
    }

    public void close() throws Exception{
        //关闭消息发送通道
        System.out.println("关闭消息发送通道");
    }

    @Override
    public void send() {
        this.open();
        System.out.println("发送消息" + this.msg);
    }
}
public class java_basi_class {
    public static void main(String[] args) throws Exception{
        /*
        StringBuffer类
            string是开发之中一定用到的一个功能类，并且拥有以下特点：
                1、每一个字符串的常量都属于一个string类的匿名对象，并且不可更改
                2、string有两个常量池：静态常量池、运行时的常量池
                3、string类对象建议使用世界赋值的形式完成，可以直接将对象保存在对象池之中以方便下次重用
                最大的弊端：内容；不允许修改解决此问题提供了stringbuffer类
          提供的部分方法：
                构造方法：public StringBuffer()
                构造方法：public StringBuffer(String str)  接收初始化字符串内容
                数据增加：public StringBuffer append(数据类型 变量)

          所有的额 “+” 都变成了stringbuffer类中的append()方法
          StringBuffer（线程安全性极高）和string可以直接互相转换
            string类对象转换为stringbuffer可以依靠stringbuffer中的构造方法或者使用append方法
            所有的类对象都可以通过tostring的方法变为string类型

            string类中不具备的方法：
                1、插入数据：public StringBuffer insert(int offset, 数据类型 b)
                2、删除指定范围：public StringBuffer delete(int start, int end)
                3、字符串内容反转：public StringBuffer reverse()

                类似的功能类stringbuilder（非线程安全）类

                请解释String、StringBuffer、StringBuilder类的区别
                    1、String类是字符首选，最大的特点是内容不允许修改
                    2、StringBuffer与StringBuilder的内容允许修改
                    3、StringBuffer属于线程安全操作
                    4、StringBuilder非线程安全操作
         */

        /*
        CharSequence是一个字符串结构的接口，三种常用的子类：（描述的就是字符串）
            string类：public final class String
extends Object
implements Serializable, Comparable<String>, CharSequence, Constable, ConstantDesc
        只要有字符串，就可以为CharSequence接口实例化
         */
        //子类实例向父接口转型
//        CharSequence charSequence = "www.baidu.com";
        /*
        CharSequence本身是一个接口，定义有如下操作方法：
            获取指定索引字符：
                char charAt(int index)
            获取字符串的长度：
                int length()
            截取部分字符串：
                CharSequence subSequence(int start,int end)
         */
        /*
        AutoCloseable主要是用于日后进行资源开发处理上，以实现资源的自动关闭（释放资源）
        通过一个消息的发送处理来完成：
        1、手工处理
        Netssge nm = new Netssge("www.baidu.com");
        if (nm.open()){
            //是否打开了链接
            nm.send();
            nm.close();
        }
        2、自动关闭
        除了使用 AutoCloseable之外，还需要使用异常处理语句才可以正常调用
       public void close ()throws Exception

       try (Issge nm = new Netssge("www.baidu.com")) {
            nm.send();
        }catch (Exception e){

        }
         */
        /*
        Runtime类描述运行时的状态，默认提供该类的实例化对象，属于单例设计模式：获取实例化对象，依靠类中的
        getRuntime（）方法：
            获取实例化对象：public static Runtime getRuntime()
            Runtime runtime = Runtime.getRuntime();//获取runtime实例化对象
            通过类中	availableProcessors()可以获得CPU的内核数
            获取最大可用内存空间：public long maxMemory ()  默认为本机系统的四分之一
            获取可用内存空间：public long totalMemory ()    默认为本机系统的六十四分之一
            获取空闲内存空间：public long freeMemory ()
            手工进行GC处理：public void gc()
         */
        /*
        system类：
            数组拷贝：public static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length);
            获取当前日期时间数值：public static long currentTimeMillis()；
            进行垃圾回收：public static void gc()
         */
        /*
        Cleaner是一个对象清理操作，主要的功能是进行finialize()方法的替代
        对于对象的回收释放：建议使用AutoCloseable或者是Cleaner
        新的清除处理中，更多的考虑是多线程的使用。即:
            为了防止有可能造成的延迟处理，多以许多对象回收前的处理都是单独通过一个线程完成的
         */
        /*
        对象克隆：全新的进行对象复制，即使已有对象内容创建一个新的对象，进行对象克隆，需要使用object中提供的clone方法
         */
    }
}
