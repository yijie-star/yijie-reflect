/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: java_reflex_and_simpleclass.java
 * Date: 2022/6/20 下午2:20
 * Author: yijie
 */

package com.ase;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class java_reflex_and_simpleclass {
    public static void main(String[] args) {
        /*
        反射与简单java类：
            传统java类赋值弊端：实际项目中，java类非常多，因此在属性赋值时会很麻烦，大量的重复操作，
            解决方案：反射机制---object类直接操作、可以直接操作属性或方法---实现相同功能类的重复操作的抽象处理。


            属性自动设置方案：--采用字符串的形式描述对应的类型

                1、string字符串描述的内容很多，并且也可以自定义字符串结构  采用“属性：内容|属性：内容”的形式
                2、类设计基本结构：应该由一个专门的  ClassInstanceFactory类负责所有的反射处理，即接收反射对象
                同时可以获取指定类的实例化对象
                3、模板

         */

        /*
        单级属性配置：没有其他的引用关联
            处理两件事情：
                需要通过反射进行指定类对象的实例化处理
                进行内容的设置（Field属性类型、方法名称、要设置的内容）
         */
        /*
        java里面的数据类型一般的可选为long(Long),int,double,string,date

        做出修改:可以实现各种数据类型的配置:

         */
        String value = "empo:7369|ename:Smith|job:Cleck|salary:750.00|hiredate:2009-10-29";
        Empr empr = ClassInstanceFactory.create(Empr.class, value);
        System.out.println("编号:" + empr.getEmpo() + " 姓名：" + empr.getEname() + " 工作：" + empr.getJob() + " 薪资:" + empr.getSalary() + " 任职时间:" + empr.getHiredate());
    }
}
/*
ClassInstanceFactory负责实例化对象并且调用BeanUtils类实现属性内容的设置

 */
class ClassInstanceFactory{
    private ClassInstanceFactory(){}

    /**
     * 实例化对象方法，该对象可以根据传入的字符串结构“属性:内容|属性:内容|属性:内容”
     * @param claszz 要进行反射实例化的Class类对象，有Class就可以反射实例化对象
     * @param value 要设置给对象的属性内容
     * @return 一个已经配置好属性内容的java类对象
     * @param <T>
     */
    public static <T> T create(Class<T> claszz,String value){

        try {//如果采用反射进行java类对象属性设置的时候，类必须要有无参构造
            Object obj = claszz.getDeclaredConstructor().newInstance();
            BeanUtils.setValue(obj, value);//通过反射设置属性
            return (T) obj;//返回对象
        } catch (Exception e) {
            e.printStackTrace();//如果此时真的出现问题，本质上抛出异常也没用
            return null;
        }

    }
}
//雇员
class Empr{
    private long empo;
    private String ename;
    private String job;
    private double salary;
    private Date hiredate;
    private Depts depts;


    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public long getEmpo() {
        return empo;
    }

    public void setEmpo(long empo) {
        this.empo = empo;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }
}
//定义BeanUtils类，该工具类主要实现属性的设置
class BeanUtils{
    private BeanUtils(){}

    /**
     * 实现指定对象的属性设置
     * @param obj 要进行反射操作的实例化对象
     * @param value 包含有指定内容的字符串，格式：“属性:内容|属性:内容|属性:内容”
     */
    public static void setValue(Object obj,String value){
        String results []= value.split("\\|");//按照竖线进行内容每一组的拆分
        for (int i = 0; i < results.length; i++) {//循环设置属性内容
            //attval[0]保存属性名称，attval[1]保存属性内容
            String attval []= results[i].split(":");//获取“属性名称”和“属性内容
            try {
                if (attval[0].contains(".")){//多级配置
                    String temp [] = attval[0].split("\\.");
                    Object currentObject = obj;
                    //最后一一位肯定是指定类中的属性名称,所以不在本次实例化处理的范畴之内
                    for (int j = 0; j < temp.length - 1; j++) {
                        //调用get方法,若返回为null,则表示未实例化
                        Method getMethod = obj.getClass().getDeclaredMethod("get" + StringUtils.initcap(temp[j]));
                        Object tempObject = getMethod.invoke(currentObject);
                        if (tempObject == null){//该对象并没有被实例化
                            Field file = currentObject.getClass().getDeclaredField(temp[j]);//获取属性类型
                            Method setMethod = currentObject.getClass().getDeclaredMethod("set" + StringUtils.initcap(temp[j]), file.getType());
                            Object newObject = file.getType().getConstructor().newInstance();
                            setMethod.invoke(currentObject,newObject );//实例化
                            currentObject = newObject;
                        }else {
                            currentObject = tempObject;
                        }
                    }
                    //进行属性内容的设置
                    Field field = currentObject.getClass().getDeclaredField(temp[temp.length - 1]);//获取成员
                    Method setMethod = currentObject.getClass().getDeclaredMethod("set" + StringUtils.initcap(temp[temp.length - 1]), field.getType());
                    Object convertAttributeValueval = BeanUtils.convertAttributeValue(field.getType().getName(),attval[1]);
                    //setMethod.invoke(currentObject, attval[1]);//调用setter方法设置内容
                    setMethod.invoke(currentObject, convertAttributeValueval);//改变后的
                }else {//单级配置
                    Field field = obj.getClass().getDeclaredField(attval[0]);//获取成员
                    Method setMethod = obj.getClass().getDeclaredMethod("set" + StringUtils.initcap(attval[0]), field.getType());
                    Object convertAttributeValueval = BeanUtils.convertAttributeValue(field.getType().getName(),attval[1]);
                    //setMethod.invoke(obj, attval[1]);//调用setter方法设置内容
                    setMethod.invoke(obj, convertAttributeValueval);//改变后的
                }

            }catch (Exception e){}
        }
    }

    /**
     * 实现属性类型转换处理
     * @param type 属性的类型,通过Field获取
     * @param value 属性内容传入的都是字符串,需要将其变为指定类型
     * @return 转换后的数据
     */
    private static Object convertAttributeValue(String type,String value){
        if ("long".equals(type) || "java.lang.Long".equals(type)){//长整型
            return Long.parseLong(value);
        }else if ("int".equals(type) || "java.lang.int".equals(type)){
            return Integer.parseInt(value);
        }else if ("double".equals(type) || "java.lang.double".equals(type)){
            return Double.parseDouble(value);
        }else if ("java.util.Date".equals(type)){
            SimpleDateFormat simpleDateFormat = null;
            if (value.matches("\\d{4}-\\d{2}-\\d{2}")){//日期类型
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            }else if (value.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")){
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            }else {
                return new Date();//当前日期
            }
            try {
                return simpleDateFormat.parse(value);
            } catch (ParseException e) {
                return new Date();
            }
        }else {
            return value;
        }
    }
}
//定义StringUtils，实现首字母大写
class StringUtils{
    public  static String initcap(String str){
        if (str == null || "".equals(str)){
            return str;
        }
        if (str.length() == 1){
            return str.toUpperCase();
        }else {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
    }
}
