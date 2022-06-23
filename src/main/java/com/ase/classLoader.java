/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: classLoader.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class classLoader {
    public static void main(String[] args) {
        /*
        类加载器:
            系统类加载器:
                获取:利用class类(反射的根源)实现方法:
                    public ClassLoader getClassLoader()
                获取父类的classloader对象
                    public final ClassLoader getParent()
        获得类加载器后可以实现类的反射加载处理:
            protected Class<?> findClass(String name) throws ClassNotFoundException
         */
        /*
        自定义类加载器:在所有加载器最后

         */
    }
}
class AutoClassLoader extends ClassLoader{
    private static final String FILE_CLASS_PASH = "磁盘" + File.separator + ".class文件";
    /**
     * 进行指定类的加载
     * @param classname 类的完整名称"包.类
     * @return 返回一个指定类的Class对象
     * @throws Exception 类不存在则无法加载
     */
    public Class<?> loadData(String classname) throws Exception{
        byte [] data = this.loadClassData();//读取二进制文件
        if (data != null){//读取到了
            super.defineClass(classname, data, 0, data.length);
        }
        return null;
    }
    private byte[] loadClassData() throws Exception{//通说文件进行类的加载
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;//将数据加载到内存之中
        byte data[] = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();//实例化内存流对象
            inputStream = new FileInputStream(new File(FILE_CLASS_PASH));//文件流加载
            //byte data [] = new byte[1024];//进行读取
            inputStream.transferTo(byteArrayOutputStream);//进行读取
            data = byteArrayOutputStream.toByteArray();//将所有字节数据取出

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (inputStream != null){
                inputStream.close();
            }
            if (byteArrayOutputStream != null){
                byteArrayOutputStream.close();
            }
        }
        return data;
    }
}
