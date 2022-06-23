/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_comp.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

import org.w3c.dom.Node;

import java.util.IdentityHashMap;

class BinaryTreee<T extends Comparable<T>>{
    //内部类
    private class Node{
        private Comparable<T> data;
        private Node parent;
        private Node left;
        private Node right;
        public Node(Comparable<T> data){
            this.data = data;
        }
        public void addNode(Node newNode){//实现节点数据的适当存储
            if (newNode.data.compareTo((T) this.data) <= 0){//比当前节点数据小
                if (this.left == null){//没有左子树
                    this.left = newNode;
                    newNode.parent = this;//保存父节点
                }else {//需要向左边继续判断
                    this.left.addNode(newNode);
                }
            }else {//比根节点数据大
                if (this.right == null){
                    this.right = newNode;
                    newNode.parent = this;
                }
                else {//向右继续判断
                    this.right.addNode(newNode);
                }
            }
        }
        public void toArrayNode(){//实现数据的获取处理，按照中序遍历的形式完成
            if (this.left != null){//有左子树
                this.left.toArrayNode();//递归调用
            }
            BinaryTreee.this.returnData[BinaryTreee.this.footerCount ++ ] = this.data;
            if (this.right != null){
                this.right.toArrayNode();
            }
        }
        public boolean containsNode(Comparable<T> data){
            if (data.compareTo((T) this.data) == 0){
                return true;//查找到了
            }
            else if (data.compareTo((T) this.data) < 0){//左边有数据
                if (this.left != null){
                    return this.left.containsNode(data);
                }else {
                    return false;
                }
            }else {
                if (this.right != null){
                    return this.right.containsNode(data);
                }else {
                    return false;
                }
            }
        }
        public Node getRemoveNode(Comparable<T> data){
            if (data.compareTo((T) this.data) == 0){
                return this;//查找到了
            }
            else if (data.compareTo((T) this.data) < 0){//左边有数据
                if (this.left != null){
                    return this.left.getRemoveNode(data);
                }else {
                    return null;
                }
            }else {
                if (this.right != null){
                    return this.right.getRemoveNode(data);
                }else {
                    return null;
                }
            }
        }
    }
    //-----------以下为二叉树的功能实现---------------
    private Node rootNode;//根节点
    private int count;//保存数据的个数
    private Object [] returnData;// 返回数据
    private int footerCount = 0;//角标控制
    public void addNode(Comparable<T> data){//进行数据的保存
        if (data == null){
            throw new NullPointerException("保存的数据不允许为空！");//数据为空时抛出异常
        }
        //所有的数据本省不具备有节点关系的匹配，那么一定要将其包装在Node类之中
        Node newNode = new Node(data);//保存节点
        if (this.rootNode == null){//没有根节点，第一份节点作为根节点
            this.rootNode = newNode;
        }else {//需要保存到一个合适的节点
            this.rootNode.addNode(newNode);//交由addNode处理
        }
        this.count++;
    }
    //以对象数据的形式返回全部数据，没有返回null

    public Object[] toArray() {
        if (this.count == 0){
            return null;
        }
        this.returnData = new Object[this.count];//保存长度为数据长度
        this.footerCount = 0;//角标清零
        this.rootNode.toArrayNode();//通过Node类负责
        return this.returnData;
    }
    public void remove(Comparable<T> data){
        if (this.rootNode == null){//根节点不存在
            return;//结束
        }else {
            if (this.rootNode.data.compareTo((T) data) == 0){//要删除的是根节点
                Node moveNode = this.rootNode.right;
                while (moveNode.left != null){//还有左边的节点
                    moveNode = moveNode.left;//一直向左找
                }//可以确定删除节点的右节点的最小左节点
                moveNode.left = this.rootNode.left;
                moveNode.right = this.rootNode.right;
                moveNode.parent.left = null;
                this.rootNode = moveNode;//改变根节点
            }else {
                Node removedNode = this.rootNode.getRemoveNode(data);
                if (removedNode != null){//找到删除的对象信息
                    if (removedNode.left == null && removedNode.right == null){
                        removedNode.parent.left = null;
                        removedNode.parent.right = null;
                        removedNode.parent = null;//父节点断开
                    }else if (removedNode.left != null && removedNode.right == null){//左边不为空
                        removedNode.parent.left = removedNode.left;
                        removedNode.left.parent = removedNode.parent;
                    }else if (removedNode.left == null && removedNode.right != null){//右边不为空
                        removedNode.parent.left = removedNode.right;
                        removedNode.right.parent = removedNode.parent;
                    }else {//两边都有节点，则将右边节点中最左边的节点找到，改变其指向
                        Node moveNode = removedNode.right;
                        while (moveNode.left != null){//还有左边的节点
                            moveNode = moveNode.left;//一直向左找
                        }//可以确定删除节点的右节点的最小左节点
                        removedNode.parent = moveNode;
                        moveNode.parent.left = null;//断开原本连接
                        moveNode.parent = removedNode.parent;
                        moveNode.right = removedNode.right;//改变原始右节点的指向
                        moveNode.left = removedNode.left;
                    }
                }
            }
            this.count--;
        }
    }
}
public class java_comp {
    public static void main(String[] args) {
        /*
        问题：任意的类默认情况下是无法使用系统内部的类实现数组排序或比较需求的
            comparable比较器：指定比较规则
            实现：继承接口comparable，只需要有一个compareTo（）方法进行排序规则的定义，即可实现


            comparator：主要目的是解决一些没有使用comparable排序的类的对象数组排序，挽救性操作
            需使用到get方法，因此在类中必不可少（尽可能少用）

            面试题：请解释Comparable 与 Comparator的区别？
                1、java.lang.Comparable是在类定义的时候实现的父接口，主要用于定义排序规则。里面只有一个compareTo方法
                2、java.util.Comparator是挽救的比较器操作，需要单独的比较器规则类实现排序，里面有compare方法
         */

        /*
        二叉树结构：
            实现原理：取第一个数据为保存的根节点，小于等于根节点的数据放在节点的左子树，大于节点的数据放在节点的右子树
            遍历：前序遍历（根-左-右）、中序遍历（左-根-右）、后序遍历（左-右-根）
            内容都是与排序的结果
            实现二叉树存储数据：

            数据删除非常繁琐，不是必须不建议使用删除
            特点：数据查询提供更好的查询性能
            有明显缺陷的（增加或删除）
         */

        /*
        红黑树是一种特定类型的二叉树，它是在计算机科学中用来组织数据比如数字的块的一种结构。
        红黑树是一种平衡二叉查找树的变体，它的左右子树高差有可能大于 1，所以红黑树不是严格意义上的平衡二叉树（AVL），
        但对之进行平衡的代价较低， 其平均统计性能要强于 AVL。
        由于每一棵红黑树都是一颗二叉排序树，因此，在对红黑树进行查找时，
        可以采用运用于普通二叉排序树上的查找算法，在查找过程中不需要颜色信息。
红黑树数据删除平衡修复

        本质：在节点上追加一个表示颜色的操作信息
        利用黑色和红色节点实现二叉树的均衡，为了可以进行左旋和右旋控制以保证树的平衡性
            数据插入平衡修复：

            数据删除平衡修复:

            修复的目的：保证树结构中，黑色节点的数量平衡
                过程：一方面是红黑的处理，另一方面是黑色子节点的保存层次
         */

    }
}
