package com.avaweb_xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;

public class Dom4jUtils {
    private String path;
    public Dom4jUtils(){}
    public Dom4jUtils(String path){
        this.setPath(path);
    }

    /**
     * 创建解析器
     * @return 返回document
     * @throws DocumentException
     */
    public Document getDocument() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        return saxReader.read(this.getPath());
    }

    public XMLWriter getXmlWriter() throws FileNotFoundException, UnsupportedEncodingException {
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();//格式
        return new XMLWriter(new FileOutputStream(this.getPath()), outputFormat);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
