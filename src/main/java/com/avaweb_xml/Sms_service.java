package com.avaweb_xml;

import org.dom4j.DocumentException;

import java.io.IOException;


public interface Sms_service {
    //增加
    void addStu(Student student) throws DocumentException, IOException ;
    //删除 根据学生id删除
    void delStu(String sid) throws DocumentException, IOException;
    ;
    //查询 根据id查询
    Student getStu(String sid) throws DocumentException;
}
