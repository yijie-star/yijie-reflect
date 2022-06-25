package cn.java.web.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 给出多个请求方法，除名称意外其他都相同
 * 客户端必须传递一个参数--规定随意取，但必须统一
 */
@SuppressWarnings("serial")
public class AServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parName = req.getParameter("参数名");//获取客户端传递的参数
        /**
         * 得到方法名称，通过反射来调用需求
         * 需要得到class，然后调用它的方法来进行查询，得到传递过来的参数
         * 要查询的是当前类的方法，所以需要得到当前类额class
         */
        if (parName == null || parName.trim().isEmpty()){
            //trim--去掉空格
            throw new RuntimeException("没有获取到您传递的请求参数，无法确定您的需求！");
        }
        Class current_class = this.getClass();//获得当前类对象
        Method method = null;
        try {
            method = current_class.getMethod(parName,HttpServletRequest.class,HttpServletResponse.class);//通过传递过来的参数查询对应的处理方法
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("您调用的需求无法满足！" + parName + "不存在！");
        }
        /**
         * 调用parName方法
         * 反射调用:method.invoke(this,req,resp);
         */
        try {
            method.invoke(this,req,resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Hello Ajax!");
        response.getWriter().print("郑宇城啥B！啥B！");
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");

    }
}
