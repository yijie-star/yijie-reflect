/*
 * 版权所有(c) 2022 - 2022
 * 项目名称: alisdy -- 文件名称: JaxpParser_dom.java
 * Date: 2022/6/22 下午5:25
 * Author: yijie
 */

package com.avaweb_xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class JaxpParser_dom {
    /**
     * 1、创建解析器工厂
     * 2、根据解析器工厂创建解析器
     * 3、解析xml返回document
     * 4、得到所有的元素
     * 5、返回集合，遍历集合,得到每一个元素
     * 6、获取name元素的值
     */
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse("alistdy/src/main/conf/DataBaseConfig.xml");
        NodeList nodeList = document.getElementsByTagName("property");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;
            String str = element.getAttribute("value");

            System.out.println(str);
        }


    }
}
