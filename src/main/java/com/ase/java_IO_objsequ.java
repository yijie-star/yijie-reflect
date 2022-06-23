/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_IO_objsequ.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

public class java_IO_objsequ {
    public static void main(String[] args) {
        /*
        对象序列化：将内存中保存的对象以二进制数据流的形式进行处理，可以实现对象的保存或者是网络的传输
            强制性的要求：如果要序列化的对象，那么对象所在的类一定要实现java.io.serializable父接口作为序列化的标记
            这个接口并没有任何的方法，它描述的是以综合类的能力
         */
        /*
        序列化与反序列化操作：
            在java中的对象序列化和反序列化必须使用内部提供的对象操作流，如果要想实现一组对象的序列化，可以使用对象数组完成

         */
        /*
        transient关键字：不会被序列化处理
         */
    }
}
