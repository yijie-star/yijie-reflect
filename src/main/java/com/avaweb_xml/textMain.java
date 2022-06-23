package com.avaweb_xml;

import org.dom4j.DocumentException;

import java.io.IOException;

public class textMain {
    public static void main(String[] args) throws DocumentException, IOException {
        //textAdd();
        //textDel();
        textSelect();
    }
    public static void textAdd() throws DocumentException, IOException {
        Student student = new Student();
        student.setSid("20220004");
        student.setSname("郑宇城");
        student.setSage("21");
        StuFactory.getInstance().addStu(student);
    }
    public static void textDel() throws DocumentException, IOException {
        StuFactory.getInstance().delStu("20220004");
    }
    public static void textSelect() throws DocumentException {
        Student student = StuFactory.getInstance().getStu("20220002");
        System.out.println(student.getInfo());
    }
}
