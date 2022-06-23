/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_internation.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

/*
 * @Created by IntelliJ IDEA.
 * @fileName: java_internation.java
 * @Description：
 * @Author: Jike Y
 * @email smile_yijie@163.com
 * @Datetime: 2022/5/25 下午3:04
 */

package com.ase;

import java.util.Locale;
import java.util.ResourceBundle;

public class java_internation {
    public static void main(String[] args) {
        /*
        国际化程序：只同一个程序代码可以根据不同国家实现不同的语言描述，但是程序处理的核心业务是一样的
        定义不同的语言文字信息，进行资源读取
         */
        /*
        Local类：解决不同国家用户的区域和语言编码
        主要使用两个构造方法：
            构造方法：public Locale(String language)
            构造方法：public Locale(String language,String country)
            中文代码：zh_CN，美国英语代码：en_US
            实例化Local对象
            Locale loc = new Locale("zh","CN"); 手动选择
            自动：利用Local本身默认的方式实例化
                读取本地默认环境：public static Locale getDefault()

                并且提供有常量：优势在于避免一些区域编码信息的繁琐
         */
        /*
        ResourcesBundle类：public abstract class ResourceBundle extends Object是一个抽象类
        可以直接利用该类中提供的一个静态方法完成
        实例化对象：public static final ResourceBundle getBundle(String baseName)
            baseName描述资源名称，但是没有后缀
        读取资源内容：public final String getString(String key)，如果资源没有放在包之中，则直接编写资源名称即可
         */
        //实现国际化开发程序
//        ResourceBundle resourceBundle = ResourceBundle.getBundle("com.Message");
//        String val = resourceBundle.getString("info");
//        System.out.println(val);
        //默认加载本地
        /*
        读取顺序：读取指定区域的资源文件  > 默认的本地资源  > 公共的资源（没有区域设置）
         */
        /*
        格式化文本显示：
            通过占位符来进行描述，读取出来也要进行消息的格式化MessageFormat类进行
         */
    }
}
