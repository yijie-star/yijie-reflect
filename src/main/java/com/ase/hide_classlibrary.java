/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: hide_classlibrary.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

import java.util.Random;

class Coin{
    private int front;//正面
    private int back;//背面
    private Random random = new Random();

    /**
     * 扔硬币的处理
     * @param number 扔硬币的执行次数
     */
    public void throwCoin(int number){
        for (int i = 0; i < number; i++) {
            int temp = random.nextInt(2);
            if (temp == 0){
                this.front ++;
            }else {
                this.back ++;
            }
        }
    }
    public int getFront(){
        return this.front;
    }

    public int getBack() {
        return this.back;
    }
}
public class hide_classlibrary {
    public static void main(String[] args) {
        /*
        编写程序，用0-1之间的随机数来模拟扔硬币试验，统计扔1000次后出现正、反的次数并输出
         */
        Coin coin = new Coin();
        coin.throwCoin(1000);
        System.out.println("正面出现的次数：" + coin.getFront() + "  背面出现的次数：" + coin.getBack());
    }
}
