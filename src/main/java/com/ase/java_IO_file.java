/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_IO_file.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

import java.io.File;

public class java_IO_file {
    public static void main(String[] args) {
        /*
        java.io.File支持，Fil是唯一一个与文件本身操作有关的类
        基本使用：
            路径的配置主要通过构造方法：
                public File(String pathname)：设置要操作的完整路径
                public File(String parent, String child)：设置父路径与子目录
            进行文件的基本操作，使用如下的方法：
                public boolean createNewFile() throws IOException ： 创建新的文件
                public boolean exists() ：判断文件是否存在
                删除文件：public boolean delete()
         */
        /*
        优化处理：
            1、在实际的软件项目开发和运行的过程之中，往往都会在window中进行项目开发部署时常用Linux系统
            以保证生产环节的安全性；
                在不同的操作系统中，存在有不同的路径分隔符，File提供有一个常量解决问题：public static final String separator
                正常的路径编写：File file = new File("C:" + File.separator + "文件名");
            2、在使用file类进行文件处理的时候需要注意的是 ：程序 -  JVM - 操作系统函数 - 文件处理。所以在重复删除或
            创建文件时，有可能会出现延迟的问题，最好的方案是别重名；
            3、进行文件创建时重要的前提：文件的父路径必须首先存在
                如何获取父路径：public String getParent() 、 public File getParentFile()更好
                创建目录：public boolean mkdirs()多级目录 public boolean mkdir() 单节目录
         */
        /*
        获取文件信息：
            文件是否可读：public boolean canRead()
            文件是否可写：public boolean canWrite()
            文件是否可执行：public boolean canExecute()
            获取文件长度：public long length() 返回long数据类型、字节长度
            最后一次修改日期时间：public long lastModified()
            判断是否是目录：public boolean isDirectory()
            判断是否是文件：public boolean isFile()
            列出目录内容：public File[] listFiles()

         */
        /*
        file操作案例：列出指定目录中的全部文件
         */
//        File file = new File("E:" + File.separator);
//        listDir(file);
        /*
        批量修改文件名称
        public boolean renameTo(File dest)
         */
    }
    public static void listDir(File file){
        if (file.isDirectory()){//是一个目录
            File results [] = file.listFiles();//列出目录中的全部内容
            if (results != null)
                for (int i = 0; i < results.length; i++) {
                    listDir(results[i]);//继续判断
                }
        }else {
            file.delete();
        }
    }
}
