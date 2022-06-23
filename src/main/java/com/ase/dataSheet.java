/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: dataSheet.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

class Det{
    private long deptno;
    private String dname;
    private String loc;
//    一个部门有多个雇员:多个雇员信息
    private Empe empe [];
    public Det(){}

    public Det(long deptno,String dname,String loc){
        this.setDeptno(deptno);
        this.setDname(dname);
        this.setLoc(loc);

    }
    public String getInfo(){
      return "【部门信息】部门编号：" + this.deptno + "\n部门名称：" + this.dname + "\n部门位置：" + this.loc;
    }

    public long getDeptno() {
        return this.deptno;
    }

    public String getDname() {
        return this.dname;
    }

    public String getLoc() {
        return this.loc;
    }

    public void setDeptno(long deptno) {
        this.deptno = deptno;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public void setEmpe(Empe[] empe) {
        this.empe = empe;
    }

    public Empe[] getEmpe() {
        return empe;
    }
}

class Empe {
    private long empo;
    private String ename;
    private String job;
    private double sel;
    private double comm;
//    所属部门
    private Det det;
//    所属领导
    private Empe mgr;

    public Empe(){}
    public Empe(long empo,String ename,String job,double sel,double comm){
        this.empo = empo;
        this.ename = ename ;
        this.job = job;
        this.sel = sel;
        this.comm = comm;
    }
    public String getInfo(){
      return "【雇员信息】雇员编号：" + this.empo +
              "\n雇员的姓名：" + this.ename +
              "\n雇员职位：" + this.job +
              "\n基本工资：" + this.sel +
              "\n佣金：" + this.comm;
    }

    public void setDet(Det det) {
        this.det = det;
    }

    public void setMgr(Empe mgr) {
        this.mgr = mgr;
    }

    public Det getDet() {
        return this.det;
    }

    public Empe getMgr() {
        return this.mgr;
    }
}

public class dataSheet {
    public static void main(String[] args) {
//        简单java类是现在面向对象设计的主要分析基础，在开发中，简单java类是会根据表的结构来实现的，
//在数据库中实际提供很多的数据表  数据表与简单java类映射关系如下 ：
//        1、数据实体表的而设计 = 类的定义
//                2、表中的字段 = 类的成员属性
//                3、表的一行记录 = 类的一个对象
//                4、表的多行记录 = 多行数组
//        5、表的外键关联 = 引用关联实现
//        案例
//        1、基本信息的编码：保证不要出错
//        2、配置关联字段
//        3、实现开发需求
//        开发中。。。。
//        1、根据关系进行类的定义
        Det det = new Det(1001,"财务部","上海");
        Empe empeA = new Empe(7369L,"史密斯","办事员",800.0,0.0);
        Empe empeB = new Empe(7369L,"史密斯1","办事员1",8000.0,0.0);
        Empe empeC = new Empe(7369L,"史密斯2","办事员2",80000.0,0.0);
        Empe empeD = new Empe(7369L,"史密斯3","办事员3",800000.0,0.0);
//       需要为对象进行关联的设置
        //设置雇员与部门的关联
        empeA.setDet(det);
        empeB.setDet(det);
        empeC.setDet(det);
        empeD.setDet(det);
        //设置雇员与领导的关联
        empeA.setMgr(empeB);
        empeB.setMgr(empeC);
        empeC.setMgr(empeD);
        //部门与雇员的关联
        det.setEmpe(new Empe[]{empeA,empeB,empeC,empeD});
//        2、根据关系获取数据
        //部门信息
        System.out.println(det.getInfo());
//        成员信息包含部门
        for (int i = 0;i < det.getEmpe().length;i++){
            System.out.println("\t-" + det.getEmpe()[i].getInfo());
            if (det.getEmpe()[i].getMgr() != null) {
                System.out.println("\t\t-" + det.getEmpe()[i].getMgr().getInfo());
            }
        }
        //根据雇员获取部门信息
        System.out.println("--------------------");
        System.out.println(empeB.getDet().getInfo());
        //根据雇员获取老板信息
        System.out.println(empeB.getMgr().getInfo());
    }

//    要求熟练完成
}
