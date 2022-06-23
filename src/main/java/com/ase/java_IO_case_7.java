/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_IO_case_7.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

import java.util.Arrays;

public class java_IO_case_7 {
    public static void main(String[] args) {
        /*
        投票选举
         */
        new VoteMenu();
    }
}
//1、建立学生类，这个类里面需要保存有编号、姓名、票数
class StudentBz implements Comparable<StudentBz>{
    private long sid;
    private String name;
    private int vote;
    public StudentBz(long sid,String name,int vote){
        this.setName(name);
        this.setSid(sid);
        this.setVote(vote);
    }
    public String toString(){
      return "【"  + this.sid + "】姓名：" + this.name + " 票数：" + this.vote;
    }

    @Override
    public int compareTo(StudentBz stu) {//降序排序
        return stu.vote - this.vote;
    }

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}
//2、投票服务
interface IVoteService{
    boolean inc(long sid);//根据编号进行票数的增长
    StudentBz [] result();//获取投票的结果
    StudentBz [] getData();//获取全部数据
}
//3、实现子类
class VoteServiceImpl implements IVoteService{
    private StudentBz [] studentBzs = new StudentBz[]{
            new StudentBz(1,"张三",0),
            new StudentBz(2,"李四",0),
            new StudentBz(3,"王五",0),
            new StudentBz(4,"赵六",0)
    };

    @Override
    public boolean inc(long sid) {
        for (int i = 0; i < studentBzs.length; i++) {
            if (this.studentBzs[i].getSid() == sid){
                this.studentBzs[i].setVote(this.studentBzs[i].getVote() + 1);//票数增长
                return true;
            }
        }
        return false;
    }

    @Override
    public StudentBz[] result() {
        Arrays.sort(this.studentBzs);
        return this.studentBzs;
    }

    @Override
    public StudentBz[] getData() {
        return this.studentBzs;
    }
}
//4、定义工厂类
class VoteFactory{
    public static IVoteService getInstance(){
        return new VoteServiceImpl();
    }
}
//5、定义一个信息显示类
class VoteMenu{
    private IVoteService voteService;
    public VoteMenu(){
        this.voteService = VoteFactory.getInstance();
        this.vote();
    }
    public void vote(){
        StudentBz  studentBz []= this.voteService.getData();
        for (StudentBz temp : studentBz){
            System.out.println(temp.getSid() + " ：" + temp.getName() + "【" + temp.getVote() + "】");
        }
        int num = 10;
        while (num != 0){//循环投票
            num = InputUtil.getInt("请输入班长候选人代号（数字0结束）：");
            if (num != 0){
                if (!this.voteService.inc(num)){
                    System.out.println("此选票无效，请输入正确的候选人代号!");
                }
            }
        }
        System.out.println("投票最终结果：");
        StudentBz  stu []= this.voteService.result();
        for (StudentBz temp : stu){
            System.out.println(temp.getSid() + " ：" + temp.getName() + "【" + temp.getVote() + "】");
        }
    }
}

