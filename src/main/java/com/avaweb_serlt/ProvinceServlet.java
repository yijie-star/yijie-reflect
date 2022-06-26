package com.avaweb_serlt;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;



public class ProvinceServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        res.setContentType("text/html;charset=utf-8");
        /**
         * 创建解析器，读取xml文件
         */
        {
            try {
                SAXReader saxReader = new SAXReader();
                InputStream inputStream = this.getClass().getResourceAsStream("/china.xml");
                Document document = saxReader.read(inputStream);
                List<Node> provincelist = document.selectNodes("//province/@name");
                StringBuilder province = new StringBuilder();
                for (int i = 0; i < provincelist.size(); i++) {
                    Attribute attribute = (Attribute) provincelist.get(i);
                    province.append(attribute.getValue());//把每个属性的值存放到province中
                    if (i < provincelist.size() - 1){
                        province.append(",");
                    }
                }
                res.getWriter().print(province);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
