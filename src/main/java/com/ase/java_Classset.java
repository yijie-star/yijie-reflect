/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_Classset.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

public class java_Classset {
    public static void main(String[] args) {
        /*
        类集开发框架:
            简介:一套动态对象数组的实现方案,对常见的数据结构进行完整的包装

            1 java.util.Collection:是单集合操作的最大的父接口,
                两个方法最为常用:add(),iterator()
                允许重复的List子接口,不允许重复的Set子接口

            2 List集合:Itellyou/material/picture/List接口.png
                public interface List<E> extends Collection<E>: 并且进行了扩充
                存储的特征: 保存顺序即存储顺序, 允许存在重复数据, 输出支持(非标准): default void forEach(Consumer<? super E> action)

                2.1 ArrayList子类: 是list子接口使用更多的子类 , Itellyou/material/picture/ArrayList子类.png
                    定义: public class ArrayList<E> extends AbstractList<E>
                    implements List<E>, RandomAccess, Cloneable, Serializable

                    若在进行数据增加的时候,原有数组长度不够,会开辟一个新的数组,并将原有的数据拷贝到新数组中

                    保存自定义类对象: 如果想使用remove(),contains()  必须保证已经成功覆写equals()方法

                2.2 LinkedList子类: 基于链表的实现  , Itellyou/material/picture/LinkedList子类.png
                    定义: public class LinkedList<E> extends AbstractSequentialList<E>
                        implements List<E>, Deque<E>, Cloneable, Serializable

                        功能差不多相同,但内部实现不同   封装的就是链表的实现

                ArrayList  与  LinkedList有什么区别?
                    ArrayList是数组实现的集合操作,LinkedList是链表实现的集合操作

                2.3 Vector子类:
                    定义: public class Vector<E> extends AbstractList<E>
                        implements List<E>, RandomAccess, Cloneable, Serializable
            3 set集合:
                public interface Set<E> extends Collection<E>

                3.1 HashSet: 保存的数据是无序的  Itellyou/material/picture/HashSet.png  不允许保存重复元素(Set接口定义)
                    public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable

                3.2 TreeSet: 保存的数据时有序的  












         */
    }
}
