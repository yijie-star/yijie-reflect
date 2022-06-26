package com.avaweb_serlt;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 给出多个请求方法，除名称意外其他都相同
 * 客户端必须传递一个参数--规定随意取，但必须统一
 */
@SuppressWarnings("serial")
public class AServlet extends BaseServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Hello Ajax!");
        response.getWriter().print("郑宇城啥B！啥B！");
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

    }
}
