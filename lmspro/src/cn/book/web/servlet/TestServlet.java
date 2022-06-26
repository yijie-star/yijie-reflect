package cn.book.web.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * TestServlet 
 *    实现了一个Servlet中多个请求处理方法
 *    方法的的参数必须和service方法相同
 *    客户端必须传递过来method参数，说明是调用哪一个请求处理方法
 * @author ZHAOYUQIANG
 *
 */
public class TestServlet extends BaseServlet {
	/**
	 * 测试post传递过来的参数
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
    public String fun1(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	String param = request.getParameter("param");
    	request.setAttribute("param", param);
    	return "f:/view/b.jsp" ;
    }
    /**
     * 测试get请求传递过来的参数
     * @param req
     * @param resp
     * @return
     * @throws ServletException
     * @throws IOException
     */
	public String fun2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String param = request.getParameter("param");
		request.setAttribute("param", param);
		return "f:/view/b.jsp";
	}

}
