package cn.java.web.servlet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Demo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Context initContext = null;
        try {
            initContext = new InitialContext();
            Context envContext  = (Context)initContext.lookup("java:/comp/env");
            System.out.println("sfgsfd");
            DataSource ds = (DataSource)envContext.lookup("jdbc/mysqlDS");
            System.out.println("sfaf");
            Connection conn = ds.getConnection();
            System.out.println("sessces");
        } catch (NamingException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
