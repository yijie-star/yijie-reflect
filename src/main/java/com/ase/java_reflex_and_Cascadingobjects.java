/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_reflex_and_Cascadingobjects.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

import java.util.Date;

public class java_reflex_and_Cascadingobjects {
    public static void main(String[] args) {
        /*
        给定的类中存在有其他引用的级联对象--多级设置
        使用"."作为级联关系的处理.
        考虑代码的简洁性,所以通过级联的配置自动实现类中属性的实例化
         */
        /*
        属性的设置:
            不在调用set方法,开发中普遍采用的方式
         */
    }
}
class Companys{
    private String cname;
    private Date creatdate;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Date getCreatdate() {
        return creatdate;
    }

    public void setCreatdate(Date creatdate) {
        this.creatdate = creatdate;
    }
}
class Depts{
    private String dname;
    private String loc;
    //部门属于公司
    private Companys companys;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Companys getCompanys() {
        return companys;
    }

    public void setCompanys(Companys companys) {
        this.companys = companys;
    }
}
