package com.avaweb_serlt;

import jakarta.servlet.*;

import java.io.IOException;
import java.util.Enumeration;

public class AServlet implements Servlet {
    /**
     * 生命周期方法，在Servlet被销毁之前调用，并且只会被调用一次
     */
    @Override
    public void destroy() {

    }

    /**
     * 获取Servlet的配置信息
     * 一个ServletConfig对象，对应一段web.xml信息
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 获取Servlet的信息
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 生命周期方法，在Servlet创建之后马上执行，只执行一次
     * @param servletConfig the servlet config.
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) {
        /**
         * 获取初始化操作
         */
        System.out.println(servletConfig.getInitParameter("p1"));
        Enumeration e = servletConfig.getInitParameterNames();
        while (e.hasMoreElements()){
            System.out.println(e.nextElement());
        }
    }

    /**
     * 生命周期方法，被调用多次，每次处理请求便会调用
     * @param request the request.
     * @param response the response.
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void service(ServletRequest request, ServletResponse response) throws IOException, ServletException {

    }
}
