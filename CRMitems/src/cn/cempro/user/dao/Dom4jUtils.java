package cn.cempro.user.dao;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class Dom4jUtils {

    /**
     * 创建解析器
     * @return 返回document
     * @throws DocumentException
     */
    public static Document getDocument(String path) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        return saxReader.read(path);
    }

    public static XMLWriter getXmlWriter(String path) throws FileNotFoundException, UnsupportedEncodingException {
        OutputFormat outputFormat = new OutputFormat("\t",true);//缩进使用\t，是否换行，是
        outputFormat.setTrimText(true);
        return new XMLWriter(new OutputStreamWriter(new FileOutputStream(path),"UTF-8"),outputFormat);
    }
}
