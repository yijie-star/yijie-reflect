package cn.java.web.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 辅助Servlet简化编码代码
 */
public class EncodingFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		 * 处理post请求乱码问题
		 */
		request.setCharacterEncoding("utf-8");
		/*
		 * 处理GET请求编码问题
		 *   String name1 =  request.getParameter("name");
		 *   name2 = new String(name.getBytes("ISO-8859-1"),"utf-8");
		 *    GET不一样，设置编码后，servlet中获取name，获取应该是name2,都是如果如上写的话，
		 *     getParameter("name")获取的是name1 .
		 * 掉包request
		 *    1. 写一个request的装饰类
		 *    2. 放行时，使用我们自己的request
		 *    3. 但是POST方式依然使用request
		 */
		HttpServletRequest req = (HttpServletRequest) request ;
		if(req.getMethod().equals("GET")){
		    EncodingRequest er = new EncodingRequest(req);	 
		    chain.doFilter(er, response);
		}else if(req.getMethod().equals("POST")){
		    chain.doFilter(request, response);
		}
//		response.setContentType("text/html;charset=UTF-8");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
