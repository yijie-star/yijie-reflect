/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_IO_case_2.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class java_IO_case_2 {

    /*
    static静态代码块优先于主方法执行
     */
    static {//项目启动的时候，该路径应该首先创建
        File file = new File(FileServiceImpl.SAVE_DIR);
        if (file.exists()){//文件目录不存在
            file.mkdirs();//创建目录
        }
    }
    public static void main(String[] args) {
        /*
        从键盘输入文件的内容和要保存的文件名称，然后根输入的名称创建文件，并将内容保存在文件之中
         */
        IFileService fileService = FileServiceFactory.getInstance();
        fileService.save();
    }

}

/*
1、定义一个文件操作的服务接口
 */
interface IFileService{
    //准备好路劲
    public static final String SAVE_DIR = "E:" + File.separator + "case" + File.separator;
    /**
     * 定义文件的保存处理方法
     * @return 保存成功返回true，否则返回false
     */
    public boolean save();
}
/*
  2 、 接口实现，使用到java_IO_1提供的getstring
 */
class FileServiceImpl implements IFileService{
    private String name;
    private String content;
    public FileServiceImpl (){
        this.name = InputUtil.getString("请输入保存的文件名称：");
        this.content = InputUtil.getString("请输入保存文件的内容：");
    }

    @Override
    public boolean save() {
        File file = new File(IFileService.SAVE_DIR + this.name);
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileOutputStream(file));
            out.print(this.content);
            out.close();
        } catch (FileNotFoundException e) {
            return false;
        }finally {
            if (out != null){
                out.close();
            }
        }
        return true;
    }
}
/*
3、工厂类
 */
class FileServiceFactory {
    private FileServiceFactory(){}
    public static IFileService getInstance(){
        return new FileServiceImpl();
    }
}
