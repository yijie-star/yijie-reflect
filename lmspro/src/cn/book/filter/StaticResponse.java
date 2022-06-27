package cn.book.filter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class StaticResponse extends HttpServletResponseWrapper {
//    private HttpServletResponse response;
    private PrintWriter printWriter;

    /**
     * String path: html文件的路径
     * @param response
     * @param path
     */
    public StaticResponse(HttpServletResponse response,String path) throws FileNotFoundException, UnsupportedEncodingException {
        super(response);
//        this.response = response;
        //创建一个与html文件路径绑定在一起的流对象
        printWriter = new PrintWriter(path,"utf-8");
    }
    public PrintWriter getWriter(){
        //返回一个与html绑定在一起的printwriter对象
        //jsp会使用它进行输出，数据输出到html文件中
        return printWriter;
    }
}
