package cn.book.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class StaticFilter implements Filter {
    private FilterConfig filterConfig ;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /**
         * 1、第一次访问时查找对应的html页面是否存在，如果存在重定到html
         * 2、不存在--放行，把servlet访问数据库后，输出给客户端的数据保存到一个html文件中
         * 3、再进行重定向
         *      获取category参数（null--null.html，1---1.html,2---2.html,3--3.html）
         *      html页面的保存路径：/view/HTMLs/
         *      判断对应的html文件是否存在，如果存在直接重定向
         *      没有就需要进行生成html
         */
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String category = request.getParameter("category");
        String htmlPage = category + ".html";
        String htmlPath = filterConfig.getServletContext().getRealPath("/view/HTMLs");
        File destFile = new File(htmlPage,htmlPath);
        if (destFile.exists()){//文件存在
            response.sendRedirect(request.getContextPath() + "/view/Htmls/" + htmlPage);
            return;
        }
        StaticResponse staticResponse = new StaticResponse(response,destFile.getAbsolutePath());
        filterChain.doFilter(request,staticResponse);//放行，即生成html文件
        //这时页面已经存在，重定向到html
        response.sendRedirect(request.getContextPath() + "*view/Htmls/" + htmlPage);
    }

    @Override
    public void destroy() {

    }
}
