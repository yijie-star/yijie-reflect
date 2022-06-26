package com.avaweb_serlt;


import jakarta.servlet.*;

import java.io.IOException;
import java.util.Map;

/**
 * 从application中获取map
 * 从request中到当前用户客户端的IP
 * 进行统计，保存到ServletContext
 */
public class MFilter implements Filter {
    private FilterConfig filterConfig;
    /**
     * 创建之后马上执行，进行初始化--只执行一次
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        this.filterConfig = filterConfig;
    }

    /**
     * 每次过滤都会执行，Filter是单例的
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ServletContext app = filterConfig.getServletContext();
        Map<String,Integer> map = (Map<String, Integer>) app.getAttribute("map");
        String ip = servletRequest.getRemoteAddr();
        if (map.containsKey(ip)){//IP在map中存在，即不是第一次访问
            int cnt = map.get(ip);
            map.put(ip,cnt+1);
        }else {
            map.put(ip,1);
        }
        app.setAttribute("map",map);//放回去
        filterChain.doFilter(servletRequest,servletResponse);//放行
    }

    /**
     * 销毁之前执行，对非内训资源进行释放
     */
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
