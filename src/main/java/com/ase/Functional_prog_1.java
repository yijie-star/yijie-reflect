/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: Functional_prog_1.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;
import java.util.function.*;
public class Functional_prog_1 {
    public static void main(String[] args) {
        /*
        在java中，提供java.util.function 的开发包可以直接使用函数式的接口，有如下几个核心接口：
            功能型函数接口：
                @FunctionInterface
                public interface Function<T,R>{
                    public R apply (T t);
                }
            消费型函数接口：只能够进行数据的处理才操作，而没有任何的返回
                在进行系统数据输出的时候使用：System.out.println();
                @FunctionInterface
                public interface Consumer<T>{
                    public void accept(T t)
                }
            供给型函数接口：
                在string类中提供有转小写的方法，没有接收参数，有返回值public String toLowerCase()
                @FunctionInterface
                    public interface Supplier<T>{
                        public T get();
                    }
            断言型函数式接口：进行判断处理
            在string类中有一个equalsIgnoreCase()方法
                @FunctionInterface
                    public interface Predicate<T>{
                        public boolean test(T t);
                    }


         */
        //one
//        Function<String,Boolean> fun = "Hello" :: startsWith;
//        System.out.println(fun.apply("H"));
        //two
//        Consumer<String> consumer = System.out :: println;
//        consumer.accept("https://jd.com");
        //three
//        Supplier<String> supplier = "HTTPS://jd.com" :: toLowerCase;
//        System.out.println(supplier.get());
        //four
        Predicate<String> predicate = "mldn" ::equalsIgnoreCase;
        System.out.println(predicate.test("MLDN"));

    }
}
