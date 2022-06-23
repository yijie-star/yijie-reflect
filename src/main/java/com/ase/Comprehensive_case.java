/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: Comprehensive_case.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;
//将前面写的链表拿过来使用
interface ILink<E>{

    void add(E pet);

    void remove(E pet);

    Object[] toArray();
}
class LinkImpl<E> implements ILink<E>{

    @Override
    public void add(E pet) {

    }

    @Override
    public void remove(E pet) {

    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
}
interface Pet{
    public String getName();
    public String getColor();

}
class PetShop {
    //保存多个宠物信息
    private ILink<Pet> allPets =  new LinkImpl<>();
    //商品上架，追加宠物
    public void add(Pet pet){
        //集合中保存对象
        this.allPets.add(pet);
    }
    public void delete(Pet pet){
        this.allPets.remove(pet);
    }
    public ILink<Pet> search(String keyword){
        //保存查询结果
        ILink<Pet> searchResult = new LinkImpl<>();
        //获取全部数据
         Object result [] = this.allPets.toArray();
         if (result != null){
             for (Object obj : result){
                Pet pet = (Pet) obj;
                if (pet.getName().contains(keyword) || pet.getColor().contains(keyword)){
                    searchResult.add(pet);
                }
             }
         }
        return searchResult;
    }
}
class Cat implements Pet{
    private String name;
    private String color;
    public Cat(){}
    public Cat(String name,String color){

    }

    public void setName(String name) {
        this.setName(name);
        this.setColor(color);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (!(obj instanceof Cat)){
            return false;
        }
        if (this == obj){
            return true;
        }
        Cat cat = (Cat) obj;
        return this.name.equals(cat.name) || this.color.equals(cat.color);
    }

    public String toString(){
      return  "【宠物猫】名字：" + this.name + " 颜色：" + this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getColor() {
        return this.color;
    }
}
class Dg implements Pet{
    private String name;
    private String color;
    public Dg(){}
    public Dg(String name,String color){

    }

    public void setName(String name) {
        this.setName(name);
        this.setColor(color);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        if (!(obj instanceof Dg)){
            return false;
        }
        if (this == obj){
            return true;
        }
        Dg dog = (Dg) obj;
        return this.name.equals(dog.name) || this.color.equals(dog.color);
    }

    public String toString(){
        return  "【宠物狗】名字：" + this.name + " 颜色：" + this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getColor() {
        return this.color;
    }
}
public class Comprehensive_case {
    public static void main(String[] args) {
        /*
        假设有一个宠物商店，里面可以出售各种宠物，要求：
            宠物的上架、下架处理，也可以根据关键字查询出宠物的关键信息
         */
        /*
        1、应该定义出宠物的标准
        2、宠物商店应该以宠物的标准为主
        3、根据宠物的标准来定义宠物信息
        4、实现宠物商店的操作
         */
        PetShop shop = new PetShop();
        shop.add(new Dg("黄班狗", "绿色"));
        shop.add(new Dg("小强猫", "黑色"));
        Object result [] = shop.search("黄").toArray();
        for (Object obj : result){
            System.out.println(obj);
        }
    }
}
