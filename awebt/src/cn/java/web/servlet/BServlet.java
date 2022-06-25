package cn.java.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

public class BServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String xml = "<students>" +
                "<student number='1001'>" +
                "<name>zhangsan</name>" +
                "<age>18</age>" +
                "<sex>nv</sex>" +
                "</student>" +
                "</students>";
        res.setContentType("text/xml;charset=utf-8");
        res.getWriter().print(xml);

    }
}
