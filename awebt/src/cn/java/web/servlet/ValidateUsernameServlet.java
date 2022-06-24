package cn.java.web.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ValidateUsernameServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        if ("qinyi".equals(username)){
            response.getWriter().print("1");
        }else {
            response.getWriter().print("0");
        }
    }
}
