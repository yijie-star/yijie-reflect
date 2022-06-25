package cn.java.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;

public class CityServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/xml;charset=utf-8");
        /**
         * 获取省份名称
         * 使用省份名称查找对应的province
         * 把province转换成字符串发送
         */
        try {
            SAXReader saxReader = new SAXReader();
            InputStream inputStream = this.getClass().getResourceAsStream("china.xml");
            Document document = saxReader.read(inputStream);
            String pname = req.getParameter("name");//获取省份名称
            Element provinceEle = (Element) document.selectSingleNode("//province[@name='" + pname + "']");//province[@name='北京']
            String xmlStr = provinceEle.asXML();//把元素转换为字符串
            res.getWriter().print(xmlStr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
