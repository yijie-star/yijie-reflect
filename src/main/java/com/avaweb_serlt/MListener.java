package com.avaweb_serlt;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.util.LinkedHashMap;
import java.util.Map;

public class MListener implements ServletContextListener {
    /**
     * 在服务器启动时创建map，并保存到ServletContext
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Map<String,Integer> map = new LinkedHashMap<String, Integer>();
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("map",map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
