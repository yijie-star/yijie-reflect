package com.avaweb_xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.XMLWriter;

import java.io.IOException;
import java.util.List;


public class StuServiceImpl implements Sms_service{
    @Override
    public void addStu(Student student) throws DocumentException, IOException {
        Dom4jUtils dom4jUtils = new Dom4jUtils("src/main/resources/conf/pupil.xml");//实例化工具类
        Document document = dom4jUtils.getDocument();
        Element rootElement = document.getRootElement();
        Element stu = rootElement.addElement("stu");
        Element sid = stu.addElement("id");
        Element sname = stu.addElement("name");
        Element sage = stu.addElement("age");
        sid.setText(student.getSid());
        sname.setText(student.getSname());
        sage.setText(student.getSage());
        XMLWriter xmlWriter = dom4jUtils.getXmlWriter();
        xmlWriter.write(document);
        xmlWriter.close();
    }

    @Override
    public void delStu(String sid) throws DocumentException, IOException {
        Dom4jUtils dom4jUtils = new Dom4jUtils("src/main/resources/conf/pupil.xml");//实例化工具类
        Document document = dom4jUtils.getDocument();
        //使用xpath获取所有的id
        List<Node> idNode = document.selectNodes("//id");
        for (Node node : idNode
             ) {
            String str = node.getText();
            if (str.equals(sid)){
                //得到stu节点
                Element stuElement = node.getParent();
                //获取student节点
                Element studentElement = stuElement.getParent();
                studentElement.remove(stuElement);
            }
        }
        //回写xml
        XMLWriter xmlWriter = dom4jUtils.getXmlWriter();
        xmlWriter.write(document);
        xmlWriter.close();
    }

    @Override
    public Student getStu(String id) throws DocumentException {
        Dom4jUtils dom4jUtils = new Dom4jUtils("src/main/resources/conf/pupil.xml");//实例化工具类
        Document document = dom4jUtils.getDocument();
        List<Node> idNode = document.selectNodes("//id");
        Student student = new Student();
        for (Node node : idNode
        ) {
            String str = node.getText();
            if (str.equals(id)){
                //得到stu节点
                Element stuElement = node.getParent();
                String sname = stuElement.element("name").getText();
                String sage = stuElement.element("age").getText();
                student.setSid(id);
                student.setSname(sname);
                student.setSage(sage);
            }
        }
        return student;
    }
}
