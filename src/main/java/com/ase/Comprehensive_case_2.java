/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: Comprehensive_case_2.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;


import java.util.concurrent.atomic.DoubleAccumulator;

//链表将之前写的拿来用
interface IGoods{
    public String getName();
    public double getPrice();
}
interface IShopCar{
    public void add(IGoods goods);
    public void delete(IGoods goods);
    public Object [] getAll();

}
class ShopCarImpl implements IShopCar{
    private  ILink<IGoods> allGoods = new LinkImpl<IGoods>();

    @Override
    public void add(IGoods goods) {
        //this.allGoods = add(goods);
    }

    @Override
    public void delete(IGoods goods) {
        this.allGoods.remove(goods);
    }

    @Override
    public Object[] getAll() {
        return this.allGoods.toArray();
    }
}
class Cashier{
    private IShopCar shopCar;
    public Cashier(IShopCar shopCar){
        this.shopCar = shopCar;
    }
    public double allPrice(){
        double all = 0.0;
        Object re [] = this.shopCar.getAll();
        for (Object obj : re){
            IGoods iGoods = (IGoods) obj;
            all += iGoods.getPrice();
        }
        return all;
    }
    public int allCount(){
        return this.shopCar.getAll().length;
    }
}
public class Comprehensive_case_2 {
    public static void main(String[] args) {
        /*
        1、定义出商品的标准
        2、定义购物车的处理标准
        3、定义一个购物车的实现类
        4、定义收银台
        5、定义商品信息
        6、代码测试编写
         */
    }
}
