/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: stu_classlibrary.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

public class stu_classlibrary {
    /*
    按照“姓名：年龄：成绩 | 姓名：年龄：成绩”的格式定义字符串“张三：21:98 | 李四：22：89| 王五：20:70”，要去
    求将每组值分别保存在student对象之中，并对这些对象进行排序，排序的原则是：按照成绩由高到低排序，如果成绩相同，则
    按照年龄由低到高
     */
    public static void main(String[] args) {
        System.out.println();
    }
}
class Stu implements Comparable<Stu>{
    private String name;
    private int age;
    private double score;

    public Stu(String name, int age, double score) {
        super();
        this.name = name;
        this.age = age;
        this.score = score;
    }
    @Override
    public String toString(){
        return  "姓名：" + this.name + " 年龄：" + this.age + " 成绩：" + this.score  + "\n";
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public int compareTo(Stu stu) {
        if (this.score < stu.score){
            return 1;
        }else if (this.score > stu.score){
            return -1;
        }else {
            return this.age - stu.age;
        }
    }
}
