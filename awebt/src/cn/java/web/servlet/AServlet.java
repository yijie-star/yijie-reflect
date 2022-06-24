package cn.java.web.servlet;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@SuppressWarnings("serial")
public class AServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Hello Ajax!");
        response.getWriter().print("郑宇城啥B！啥B！");
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

    }
}
