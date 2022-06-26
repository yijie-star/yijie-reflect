package cn.java.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
/**
 * 辅助过滤器来处理GET编码问题
 * @author ZHAOYUQIANG
 *
 */
public class EncodingRequest extends HttpServletRequestWrapper{
private HttpServletRequest request ;
	
	public EncodingRequest(HttpServletRequest request) {
		super(request);
		this.request = request ;
	}
	/**
     * 处理编码问题
     */
	public String getParameter(String name) {
		String value = request.getParameter(name);
		/*
		 * 处理编码问题
		 */
		try {
			value = new String (value.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		return value;
	}

}
