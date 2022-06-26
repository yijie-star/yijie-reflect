package com.avaweb_serlt;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");//处理post请求编码
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        if (httpServletRequest.getMethod().equals("GET")) {
            EncodingRequest encodingRequest = new EncodingRequest(httpServletRequest);
            filterChain.doFilter(servletRequest,servletResponse);
        }else if (httpServletRequest.getMethod().equals("POST")){
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
