/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_IO_liu.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

import java.io.*;

public class java_IO_liu {
    public static void main(String[] args) throws Exception {
        /*
        file只能操作文件本身，不能操作内容
        数据流：字节数据   java.io包里面提供有两类支持：
            字节处理流：OutputStream（输出字节流）InputStream(输入字节流)
            字符处理流：Writer(输出字符流) Reader（输入字符流)
            流的操作属于资源操作，用完必须关闭
         */
        /*
        OutputStream类定义的是一个公共的输出操作标准，子类向上转型完成
        实现内容的输出：


        File file = new File("E:" + File.separator + "hello" + File.separator + "user.txt");
        if (!file.getParentFile().exists()){//文件不存在
            file.getParentFile().mkdirs();//创建父目录
        }
        OutputStream outputStream = new FileOutputStream(file);//通过子类实例化
        String str = "www.jd.com";
        outputStream.write(str.getBytes());//将字符串变为字节数组
        outputStream.close();
        可设置为自动关闭，是否使用取决于项目结构，
         */
        /*
        InputStream属于抽象类，这应该依靠它的子类来实例化对象从文件里读取，使用Fileinputstream
        读取数据：
        File file = new File("E:" + File.separator + "hello" + File.separator + "user.txt");
        InputStream inputStream = new FileInputStream(file);
        byte data[] = new byte[1024];//开辟一个缓冲期
        int len = inputStream.read(data);
        System.out.println(new String(data,0,len));
        inputStream.close();

         */
        /*
        Writer:能直接输出字符串,优势在于中文字符处理

        File file = new File("E:" + File.separator + "hello" + File.separator + "user.txt");
        if (!file.getParentFile().exists()){//文件不存在
            file.getParentFile().mkdirs();//创建父目录
        }
        Writer out = new FileWriter(file,true);
        String str = "\t\nhttps:www.baidu.com";
        out.write(str);
        out.close();


         */

        /*
        Reader：抽象类
        实现

        File file = new File("E:" + File.separator + "hello" + File.separator + "user.txt");
        if (file.exists()){
            Reader in = new FileReader(file);
            char data[] = new char[1024];
            int len = in.read(data);
            System.out.println(new String(data,0,len));
            in.close();
        }

         */
        /*
        字节流与字符流的区别：
            字节流在进行处理的时候并不会使用到缓冲区，而字符流会，另外使用缓冲区的字符流更加适合于中文的处理
         */
        /*
        可以进行字节流和字符流之间的转换功能：

         */
    }
}
