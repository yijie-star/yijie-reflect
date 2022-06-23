/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: dataSheet_d_d_fuza.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

class Meb{
    private String mid;
    private String name;
    //一个用户有多个角色
    private Role roles[];

    public Meb(){}

    public Meb(String mid,String name){
        this.setMid(mid);
        this.setName(name);
    }

    public String getInfo(){
      return "【用户信息】ID：" + this.mid + " 用户昵称：" + this.name;
    }

    public void setRole(Role[] roles) {
        this.roles = roles;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMid() {
        return this.mid;
    }

    public String getName() {
        return this.name;
    }

    public Role[] getRole() {
        return this.roles;
    }
}
class Role{
    private long rid;
    private String title;
    //有多个用户 及多个权限
    private Meb mebs[];
    private Privilege privileges[];

    public Role(){}
    public Role(long rid,String title){
        this.setRid(rid);
        this.setTitle(title);
    }

    public String getInfo(){
      return "【用户角色】ID：" + this.rid + " 角色名称：" + this.title;
    }

    public void setMebs(Meb[] mebs) {
        this.mebs = mebs;
    }

    public void setPrivileges(Privilege[] privileges) {
        this.privileges = privileges;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getRid() {
        return this.rid;
    }

    public String getTitle() {
        return this.title;
    }

    public Meb[] getMebs() {
        return this.mebs;
    }

    public Privilege[] getPrivileges() {
        return this.privileges;
    }
}
class Privilege{
    private long pid;
    private String title;

    private Role role[];


    public Privilege(){}

    public Privilege(long pid,String title){
        this.setPid(pid);
        this.setTitle(title);
    }

    public String getInfo(){
      return "【权限信息】ID：" + this.pid + " 权限名称：" + this.title;
    }

    public void setRole(Role[] role) {
        this.role = role;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPid() {
        return this.pid;
    }

    public String getTitle() {
        return this.title;
    }

    public Role[] getRole() {
        return this.role;
    }
}



public class dataSheet_d_d_fuza {
    public static void main(String[] args) {
//        1、根据结构设置对象数据
        Meb mebA = new Meb("jx02","小明");
        Meb mebB = new Meb("jj00","小伙");
        Meb mebC = new Meb("ji10","法外狂徒");

        Role roleA = new Role(1001,"超级管理员");
        Role roleB = new Role(1002,"子管理员");
        Role roleC = new Role(1005,"普通用户");

        Privilege privilegeA = new Privilege(1000,"系统初始化");
        Privilege privilegeB = new Privilege(1001,"系统还原");
        Privilege privilegeC = new Privilege(2000,"系统环境修改");
        Privilege privilegeD = new Privilege(2001,"备份员工数据");
        Privilege privilegeE = new Privilege(3000,"备份部门数据");
        Privilege privilegeF = new Privilege(3001,"备份公文数据");
        Privilege privilegeG = new Privilege(4001,"增加员工");
        Privilege privilegeH = new Privilege(4002,"编辑员工");
        Privilege privilegeI = new Privilege(4003,"删除员工");
        //增加角色与权限的关系
        roleA.setPrivileges(new Privilege[]{privilegeA,privilegeB,
                privilegeC,privilegeD,privilegeE,privilegeF,privilegeG,privilegeH,privilegeI});
        roleB.setPrivileges(new Privilege[]{privilegeA,privilegeB,
                privilegeC,privilegeG,privilegeH,privilegeI});
        roleC.setPrivileges(new Privilege[]{privilegeD,privilegeE,privilegeF});
        //增加角色与用户的关系
        roleA.setMebs(new Meb[]{mebA,mebB});
        roleB.setMebs(new Meb[]{mebB,mebC});
        roleC.setMebs(new Meb[]{mebC,mebA});
        //增加权限与角色的关系
        privilegeA.setRole(new Role[]{roleA,roleB});
        privilegeB.setRole(new Role[]{roleA,roleB});
        privilegeC.setRole(new Role[]{roleA,roleB});
        privilegeD.setRole(new Role[]{roleA,roleC});
        privilegeE.setRole(new Role[]{roleA,roleC});
        privilegeF.setRole(new Role[]{roleA,roleC});
        privilegeG.setRole(new Role[]{roleA,roleB});
        privilegeH.setRole(new Role[]{roleA,roleB});
        privilegeI.setRole(new Role[]{roleA,roleB});
        //增加用户与角色的对应关系
        mebA.setRole(new Role[]{roleA,roleB,roleC});
        mebB.setRole(new Role[]{roleB,roleC});
        mebC.setRole(new Role[]{roleC});

//                2、根据要求获取数据
        System.out.println("=======根据用户查找信息==========");
        System.out.println(mebA.getInfo());
        for (int i = 0 ;i < mebA.getRole().length;i++){
            System.out.println(mebA.getRole()[i].getInfo());
            for (int j = 0 ; j < mebA.getRole()[i].getPrivileges().length;j++){
                System.out.println(mebA.getRole()[i].getPrivileges()[j].getInfo());
            }
        }
        System.out.println("=======根据角色查找信息==========");
        System.out.println(roleB.getInfo());
        System.out.println("--浏览此角色下的所有权限--");
        for (int i = 0; i < roleB.getPrivileges().length;i++){
            System.out.println(roleB.getPrivileges()[i].getInfo());


        }
        System.out.println("--浏览此角色下的所有用户--");
        for (int i = 0; i < roleB.getMebs().length;i++){
            System.out.println(roleB.getMebs()[i].getInfo());

        }
        System.out.println("=======根据权限查找信息==========");
        System.out.println(privilegeA.getInfo());
        System.out.println("--该权限下的所有角色--");
        for (int i = 0; i < privilegeA.getRole().length;i++){
            System.out.println(privilegeA.getRole()[i].getInfo());
            System.out.println("--该权限下的所有用户--");
            for (int j = 0; j < privilegeA.getRole()[i].getMebs().length;j++){
                System.out.println(privilegeA.getRole()[i].getMebs()[j].getInfo());

            }
        }

    }
}
