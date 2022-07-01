package cn.cempro.user.web.servlet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class C3p0Demo extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {
        //C3p0在项目中的实现 Context.xml的存储路径在con文件的localhost里面 是对Context的整个配置
        //也是实现C3p0连接池的方法
        try {
            //此类是执行命名操作的初始上下文。用于解析该 URL
            Context ctx = new InitialContext();
            System.out.println("ok1");
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/mysqlDS");
            System.out.println("ok2");


            System.out.println(ds.getConnection());

            System.out.println("ok3");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException{
    }

}
