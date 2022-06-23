/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_IO_filecopy.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

import java.io.*;

public class java_IO_filecopy {
    public static void main(String[] args) throws Exception {
        /*
        需求：
            拷贝各种类型的文件-字节流
            大文件的拷贝问题
            实现：
         */

        if (args.length != 2){//程序的执行出错
            System.out.println("命令执行出错！");
            System.exit(1);
        }
        long start = System.currentTimeMillis();
        FileUtil fileUtil = new FileUtil(args[0],args[1]);
        if (new File(args[0]).isFile()){//文件拷贝
            System.out.println(fileUtil.copy() ? "问价拷贝成功" : "文件拷贝失败");
        }else {//目录拷贝
            System.out.println(fileUtil.copyDir() ? "问价拷贝成功" : "文件拷贝失败");
        }

        long end = System.currentTimeMillis();
        System.out.println("拷贝完成的时间：" + (end - start));
        //以上方法是最原始的文件拷贝
        //IO操作的核心代码
    }
}

class FileUtil{//定义一个文件操作类
    private File srcFile;//源文件路径
    private File destFile;//目标文件路径

    public FileUtil(String src,String des){
        this(new File(src),new File(des));
    }
    public FileUtil(File srcFile,File destFile){
        this.setSrcFile(srcFile);
        this.setDestFile(destFile);
    }

    private boolean copyFileImpl(File srcFile,File destFile) throws Exception {
        if (!destFile.getParentFile().exists()){//父目录不存在
            destFile.getParentFile().mkdirs();//创建父目录
        }
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(srcFile);
            outputStream = new FileOutputStream(destFile);
            //新的方法：转存
            inputStream.transferTo(outputStream);
            /*
            int len = 0;
            //1、读取数据到数组之中，随后返回读取的个数
            //2、判断个数是否是-1，如果不是则进行写入
            while ((len =  inputStream.read(data)) != -1){
                outputStream.write(data,0,len);
            }

             */
            /*
            do {
                len =  inputStream.read(data);
                if (len != -1){
                    outputStream.write(data,0,len);
                }

            }while (len != -1);

             */
            return true;
        } catch (IOException e) {
            throw e;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
    public boolean copy() throws Exception {
        if (!this.srcFile.exists()){//源文件必须存在
            System.out.println("拷贝的源文件不存在！");
            return false;
        }

        //byte data[] = new byte[1024];//开辟拷贝的缓冲区  使用转存就不需要了（程序运行版本9）
        return this.copyFileImpl(this.srcFile, this.destFile);

    }
    private void copyImpl(File file) throws Exception{//递归操作
        if (file.isDirectory()){//是目录
            File result [] = file.listFiles();//列出全部目录组成
            if (result != null){
                for (int i = 0; i < result.length; i++) {
                    copyImpl(result[i]);
                }
            }
        }else {//是文件
            String newFilePath = file.getPath().replace(this.srcFile.getPath() + File.separator, "");
            File newFile = new File(this.destFile,newFilePath);
            this.copyFileImpl(file, newFile);
        }
    }
    public boolean copyDir() throws Exception{

        try {
            this.copyImpl(this.srcFile);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public File getSrcFile() {
        return srcFile;
    }

    public void setSrcFile(File srcFile) {
        this.srcFile = srcFile;
    }

    public File getDestFile() {
        return destFile;
    }

    public void setDestFile(File destFile) {
        this.destFile = destFile;
    }
}

