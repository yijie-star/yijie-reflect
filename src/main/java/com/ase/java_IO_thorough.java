/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_IO_thorough.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

import java.io.*;

public class java_IO_thorough {
    public static void main(String[] args) throws IOException {
        /*
        字符编码：编码和解码需使用统一规则，否则会乱码
GB2312编码：1981年5月1日发布的简体中文汉字编码国家标准。GB2312对汉字采用双字节编码，收录7445个图形字符，其中包括6763个汉字。

BIG5编码：台湾地区繁体中文标准字符集，采用双字节编码，共收录13053个中文字，1984年实施。

GBK编码：1995年12月发布的汉字编码国家标准，是对GB2312编码的扩充，对汉字采用双字节编码。GBK字符集共收录21003个汉字，包含国家标准GB13000-1中的全部中日韩汉字，和BIG5编码中的所有汉字。

GB18030编码：2000年3月17日发布的汉字编码国家标准，是对GBK编码的扩充，覆盖中文、日文、朝鲜语和中国少数民族文字，其中收录27484个汉字。GB18030字符集采用单字节、双字节和四字节三种方式对字符编码。兼容GBK和GB2312字符集。

Unicode编码：国际标准字符集，它将世界各种语言的每个字符定义一个唯一的编码，以满足跨语言、跨平台的文本信息转换。Unicode采用四个字节为每个字符编码。

UTF-8和UTF-16编码：Unicode编码的转换格式，可变长编码，相对于Unicode更节省空间。UTF-16的字节序有大尾序（big-endian）和小尾序（little-endian）之别。
            列出本机属性：System.getProperties().list(System.out);
         */
        /*
        内存操作类：
             两类内存操作流：
                字节内存操作流：
                字符内存操作流：

                内存流实现小写字母转大写字母

        String str = "https://www.jd.com";
        InputStream input = new ByteArrayInputStream(str.getBytes());//将数据保存到内存流
        //使用子类来调用子类自己的扩展方法
        ByteArrayOutputStream output = new ByteArrayOutputStream();//读取内存中的数据
        int data = 0;
        while ((data = input.read()) != -1){//每次读取一个字节
            output.write(Character.toUpperCase(data));//保存数据
        }
        byte result[] = output.toByteArray();
        System.out.println(new String(result));//自己处理字节
        input.close();
        output.close();

         */
        /*
        管道流：实现两个线程之间的IO处理操作。
            字节管道流：PipedInputStream、PipedOutputStream
            字符管道流：PipedReader、PipedWriter
            实现管道操作：


        SendTread sendTread = new SendTread();
        ReceiveTread receiveTread = new ReceiveTread();
        sendTread.getOutput().connect(receiveTread.getInput());//进行管道连接
        new Thread(sendTread,"消息发送").start();
        new Thread(receiveTread,"消息接收").start();

         */
        /*
        随机读取数据：RandomAccessFile实现文件的跳跃式读取（需要有一个完善的保存形式）数据保存的位数要确定好
            实现文件的保存：(主要的是读的操作)
         */
        File file = new File("E:" + File.separator + "qy.txt");//定义操作文件
        RandomAccessFile raf = new RandomAccessFile(file,"rw");//读写模式
        String names [] = new String[] {"张三","王五","lisi"};
        int ages [] = new int[] {30,20,18};
        for (int i = 0; i < names.length; i++) {
            raf.write(names[i].getBytes());//写入字符串
            raf.write(ages[i]);
        }
        raf.close();
    }
}
class SendTread implements Runnable{
    PipedOutputStream output;//管道输出流
    public SendTread(){
        this.output = new PipedOutputStream();//实例化管道输出流
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {//利用管道实现数据的发送
                this.output.write((Thread.currentThread().getName()).getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            this.output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public PipedOutputStream getOutput() {
        return output;
    }
}
class ReceiveTread implements Runnable{
    private PipedInputStream input;
    public ReceiveTread(){
        this.input = new PipedInputStream();
    }

    @Override
    public void run() {

        byte data[] = new byte[1024];
        try {
            int len = this.input.read(data);
            System.out.println("{" + Thread.currentThread().getName() + "接收消息}" + new String(data,0,len));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            this.input.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public PipedInputStream getInput() {
        return input;
    }
}