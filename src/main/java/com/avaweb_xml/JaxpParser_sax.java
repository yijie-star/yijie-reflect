package com.avaweb_xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class JaxpParser_sax {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        /**
         * 1、创建解析器工厂SAXParserFactory
         * 2、创建解析器
         * 3、使用指定的 .xml 解析指定为 XML 的文件的内容DefaultHandler(继承object并且是EntityResolver, DTDHandler, ContentHandler, ErrorHandler的实现子类)。
         * 4、写一个事件继承DefaultHandler，重写
         * startElement(String uri, String localName, String qName, Attributes attributes)
         * characters(char[] ch, int start, int length)
         * endElement(String uri, String localName, String qName)
         */
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        saxParser.parse("src/main/resources/conf/DataBaseConfig.xml",new Maffair());

    }
}
class Maffair extends DefaultHandler{
    boolean flag = false;
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("property".equals(qName)){
            flag = true;
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (flag == true){
            System.out.println(new String(ch,start,length));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("property".equals(qName)){
            flag = false;
        }
    }
}
