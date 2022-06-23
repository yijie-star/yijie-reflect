package com.avaweb_xml;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Dom4jParser {
    public static void main(String[] args) throws DocumentException, IOException {
        /**
         * 1、创建解析器
         * 2、得到所有的document
         * 3、得到根节点
         * 4、得到所有指定的标签
         */
        Dom4jUtils_1.selectName();
    }

}
class Dom4jUtils_1{//其中都有共同的三个步骤，可以简化将其封装成Dom4jUtils返回document即可
    //查询xml中所有property元素的值
    public static void selectName() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/main/resources/conf/DataBaseConfig.xml");
        /*
        Element rootElement = document.getRootElement();
        List<Element> elementList = rootElement.elements("property");
        for (Element e : elementList
        ) {
            System.out.println(e.getText());
        }
         */
        //使用xpath：查询所有的property元素
        List<Node> nodeList = document.selectNodes("//property");
        for (Node temp: nodeList
             ) {
            System.out.println(temp.getText());
        }
    }
    //在第一个标签下增加一个元素
    public static void addSex() throws DocumentException, IOException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/main/resources/conf/DataBaseConfig.xml");
        Element rootElement = document.getRootElement();
        Element element1 = rootElement.element("property");
        Element name = element1.addElement("name");
        name.setText("qinyi");
        //回写---也封装在Dom4jUtils里面
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();//格式
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/main/resources/conf/DataBaseConfig.xml"), outputFormat);
        xmlWriter.write(document);
        xmlWriter.close();
    }
    public static void addAppointPosition() throws DocumentException, IOException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("src/main/resources/conf/DataBaseConfig.xml");
        Element rootElement = document.getRootElement();
        Element oneElement =  rootElement.element("property");//得到第一个property
        List<Element> list = oneElement.elements();//获取下面的所有元素
        //创建需要添加的元素
        Element addElement = DocumentHelper.createElement("tell");
        addElement.setText("17854265324");
        list.add(1,addElement);
        //回写
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();//格式
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream("src/main/resources/conf/DataBaseConfig.xml"), outputFormat);
        xmlWriter.write(document);
        xmlWriter.close();
    }
}
