/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: onheritanceAnalysis_3.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

class StringUtil{
    //返回的第一个内容是字母n的个数，第二个内容为字母o的个数
    public static int [] count(String str){
        int countData [] = new int[2];
        //将字符串变为字符数组
        char [] data = str.toCharArray();
        for (int i = 0 ; i < data.length;i++){
            if (data[i] == 'n' || data[i] == 'N'){
                countData[0] ++;
            }
            else if (data[i] == 'o' || data[i] == 'O'){
                countData[1]++;

            }
        }
        return countData;
    }

}

class StringUtilsa{
    private String string;
    public StringUtilsa(){}
    public StringUtilsa(String string){
        this.setString(string);
    }

    public String getInfo() {
        return this.getString();
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getString() {
        return this.string;
    }
}

class StringCount extends StringUtilsa{
    private int ncount;
    private int ocount;

    public StringCount(){}
    public StringCount(String string){
        super(string);
        //构造方法统计
        this.countChar();
    }

    public void countChar(){
        //将字符串变为字符数组
        char [] data = super.getString().toCharArray();
        for (int i = 0 ; i < data.length;i++){
            if (data[i] == 'n' || data[i] == 'N'){
                this.ncount ++;
            }
            else if (data[i] == 'o' || data[i] == 'O'){
                this.ocount++;

            }
        }

    }

    public String getInfo() {
        return "字母n的个数：" + this.ncount + " 字母o的个数：" + this.ocount;
    }

    public void setNcout(int ncout) {
        this.ncount = ncout;
    }

    public void setOcount(int ocount) {
        this.ocount = ocount;
    }

    public int getNcount() {
        return this.ncount;
    }

    public int getOcount() {
        return this.ocount;
    }
}

public class onheritanceAnalysis_3 {
    public static void main(String[] args) {
        /**
         * 编写程序，统计出字符串“want you to know one thing”中字母n和字母o的出现次数
         */
//        定义一个单独处理类
//        String str = "want you to know one thing";
//        int result [] = StringUtil.count(str);
//        System.out.println("字母n的个数："+ result[0]);
//        System.out.println("字母o的个数："+ result[1]);

//        通过继承的方法实现:面向对象的方法
        StringCount stringCount = new StringCount("want you to know one thing");
        System.out.println(stringCount.getNcount());
        System.out.println(stringCount.getOcount());
        System.out.println(stringCount.getInfo());


    }
}
