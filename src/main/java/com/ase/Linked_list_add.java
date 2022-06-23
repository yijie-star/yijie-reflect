/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: Linked_list_add.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

//定义一个标准并设置泛型--避免安全隐患
interface ILik<E>{
    //增加数据
    public void add(E e);
    //获取数据个数
    public int size();
    //判断是否为空
    public boolean isEmpty();
    //返回数据,将集合元素以数组的形式返回
    public Object [] toArray();
    //根据索引获取数据
    public E get(int index);
    //修改索引数据
    public void set(int index,E data);
    //判断数据是否存在
    public boolean contains(E data);
    //删除数据
    public void remove(E data);
    //清空数据
    public void clean();
}
class LikImpl<E> implements ILik<E> {
    //----------以下为lik类中定义的成员---------------
    //保存根元素
    private Node root;
    //保存数据个数
    private int count;
    //描述操作数据的角标
    private int foot;
    //返回的数据保存
    private Object [] returnDate;
    //----------以下为lik类中定义的方法---------------
    @Override
    public void add(E e) {
        if (e == null) {
            return;
        }
        //数据本省不具有关联特性只有Node类有，要实现关联处理，需要将数据封装在Node类之中
        Node newNode = new Node((E) e);
        //没有根节点，第一个节点作为根节点
        if (this.root == null) {
            this.root = newNode;
        } else {
            //根节点存在  将新节点保存在合适的位置
            this.root.addNode(newNode);
        }
        this.count++;
    }
    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        /*
        使用根节点或长度的判断本质之一样的
         */
        //return this.root == null;
        return this.count == 0;
    }
    @Override
    public Object[] toArray() {
        if (this.isEmpty()){
            //是空集合 没有数据
            return null;
        }
        //角标清零
        this.foot = 0;
        //根据已有的长度开辟数据
        this.returnDate = new Object[this.count];
        //利用Note类递归获取数据
        this.root.toArrayNode();
        return returnDate;
    }
    @Override
    public E get(int index) {
        if (index >= this.count) {
            //索引在指定的范围之内
            return null;
        }
        //索引数据的获取由Node类完成
        //重置索引下标
        this.foot = 0;
        return this.root.getNode(index);
    }
    @Override
    public void set(int index, E data) {
        if (index >= this.count) {
            //索引在指定的范围之内 没有返回值方法结束
            return ;
        }
        //索引数据的获取由Node类完成
        //重置索引下标
        this.foot = 0;
        this.root.setNode(index, data);
    }
    @Override
    public boolean contains(E data) {
        if (data == null){
            //没有数据
            return false;
        }
        //交给Node类判断
        return this.root.containNode(data);
    }
    @Override
    public void remove(E data) {
        if (this.contains(data)){
            //判断数据是否存在
            if (this.root.data.equals(data)){
                //根节点为要删除的节点
                this.root = this.root.next;
            }else {
                //交由Node负责
                this.root.next.removeNode(this.root, data);
            }
            this.count --;
        }
    }
    @Override
    public void clean() {
        this.root = null;
        this.count = 0;
    }
    //--------Node类的相关操作------------
    //内部类 ：保存节点的数据关系  内部类方便访问，不必写getter,setter  私有类方法
    private class Node {
        //存数据
        private E data;
        //下一个引用
        private Node next;
        //有数据才有意义
        public Node() {
        }
        public Node(E data) {
            this.data = data;
        }
        //保存新的Node数据  第一次调用LikImpl.root.addNode() 即this = LikImpl.root
        //第二次调用  this = LikImpl.root.next
        //第三次调用  this = LikImpl.root.next.next ......
        public void addNode(Node newNode) {
            if (this.next == null) {
                //当前节点的下一个节点为空 保存当前节点
                this.next = newNode;
            } else {
                // 当前节点的下一个节点不为空 继续往下判断  递归
                this.next.addNode(newNode);
            }
        }
        /*
        第一次调用：this = LikImpl.root
        第二次调用: this = LikImpl.root.next
        第三次地调用：this = LikImpl.root.next.next
         */
        public void toArrayNode() {
            LikImpl.this.returnDate [LikImpl.this.foot++] = this.data;
            if (this.next != null){
                //还有下一个数据
                this.next.toArrayNode();
            }
        }
        public E getNode(int index){
            if (LikImpl.this.foot ++ == index){
                //索引相同
                return this.data;
            }else {
                return this.next.getNode(index);
            }
        }
        public void setNode(int index,E data){
            if (LikImpl.this.foot ++ == index) {
                //索引相同 修改数据
                this.data = data;
            }else {
                this.next.setNode(index, data);
            }
        }
        public boolean containNode(E data){
            if (this.data.equals(data)){
                //对象比较
                return true;
            }else {
                if (this.next == null){
                    //找不到
                    return false;
                }else {
                    //向后继续判断
                    return this.next.containNode(data);
                }
            }
        }
        public void removeNode(Node previous,E data){
            if (this.data.equals(data)){
                //空出当前节点
                previous.next = this.next;
            }else {
                if (this.next != null){
                    //有后续节点  向后继续删除
                    this.next.removeNode(this, data);
                }
            }
        }
    }
}

public class Linked_list_add {

    public static void main(String[] args) {
         /*
            利用链表实现数据增加
            Lik类只是负责数据的操作与根节点的处理，而后面的节点的处理全部由Node类处理
         */

        ILik<String> all = new LikImpl<String>();
        System.out.println("增加之前数据的个数：" + all.size() + " 是否为空集合：" + all.isEmpty());
        all.add("Hello");
        all.add("Word");
        all.add("qin");
        all.set(0, "世界");
        System.out.println("增加之后数据的个数：" + all.size() + " 是否为空集合：" + all.isEmpty());
        /*
        获取链表的数据长度，需要在LikImpl里面追加有个数统计信息，当增加或删除数据时对数据进行修改
        1、在ILik接口中追加一个获取数据个数的方法public int size
        2、在LikImpl子类里面追加一个统计的属性
        3、在add()方法里面进行数据个数的追加
        4、在LikImpl子类返回数据的个数
         */

        /*
        链表里面可以保存有若干个数据，如果现在链表还没有保存数据，则表示为一个空集合，所以应该提供一个空集合的判断
        1、在ILik接口里面追加一个判断方法：public boolean isEmpty();
        2、LikImpl子类中覆写
         */

        /*
        返回集合数据：链表数据动态数组，就可以以数据的形式返回
            返回的数组长度是链表的数据个数，并且需要设置数组的角标=0
            1、在ILik接口里面追加新的处理方法：
            2、在LikImpl子类里面追加两个属性
            3、在Note类中根据递归获取数据
            4、在进行数据返回的时候一定要首先判断是否为空集合
            集合的数据一般如果要返回肯定要以对象数组的形式返回
         */
        Object re [] = all.toArray();
        if (re != null){
            for (Object obj : re) {
                System.out.println(obj);
            }
        }

        /*
        获取指定索引数据:利用递归的形式来完成
            1、在ILik接口里面追加 ： public E get(int index);
            2、在Node类中追加索引数据的获取
            3、在LikImpl子类定义数据获取实现
            数组获取数据的时间复杂度为1，而链表获取数据的时间复杂度为n
         */
        System.out.println("---------数据获取-----------");
        System.out.println(all.get(0));
        System.out.println(all.get(1));
        System.out.println(all.get(2));
//        System.out.println(all.get(3));
//        System.out.println(all.get(4));
        /*
        修改指定索引的数据
            1、在ILik接口里面追加：public void set(int index,E data);
            2、在Node类中修改索引数据的支持
            3、在LikImpl子类进行发方法的覆写
         */

        /*
        判断指定数据是否存在
            1、在ILik接口里面追加判断的方法
            2、在Node类中进行依次的判断
            3、在LikImpl子类实现此方法
         */
        System.out.println("---------数据判断-----------");
        System.out.println(all.contains("Word"));
        /*
        链表数据的删除处理:从集合里面 删除指定的数据内容
            考虑两种情况：
                1、要删除的是根节点数据（LikImpl与根节点有关，所以这个判断由根节点完成）
                2、要删除的不是根节点数据（由Node类负责）
            1、在ILik接口里面追加：public void remove(E data);
            2、在LikImpl中实现根节点的判断
            3、在Node类中增加删除处理，并从根节点的下一个节点判断
         */
        /*
        清空链表：只要root设置为空，那么后续节点就不存在了
        1、ILik接口里面追加：public void clean();
        2、在LikImpl子类中覆写方法
         */
        /*
        这些就是链表的基础功能，只是最简单的单向链实现
         */
    }
}