package com.avaweb_filter;


import jakarta.servlet.*;

import java.io.IOException;

public class MFilter implements Filter {
    /**
     * 创建之后马上执行，进行初始化
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    /**
     * 销毁之前执行，对非内训资源进行释放
     */
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
