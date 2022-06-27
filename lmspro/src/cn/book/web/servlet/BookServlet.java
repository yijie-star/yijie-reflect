package cn.book.web.servlet;

import cn.book.dao.BookDao;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookServlet extends BaseServlet {
    private BookDao bookDao = new BookDao();

//    public String findall(ServletRequest request, ServletResponse response) throws ServletException, IOException {
//        String findarr = request.getParameter("findall");
//        request.setAttribute("bookList",bookDao.findAll());
//        return "/view/show.jsp";
//    }
    public String findByCategory(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        String value = request.getParameter("category");
        int category = Integer.parseInt(value);
        request.setAttribute("bookList",bookDao.findByCategory(category));
        return "/view/show.jsp";
    }
    public String fun1(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String param = request.getParameter("param");
        request.setAttribute("param", param);
        return "f:/view/b.jsp" ;
    }
    public String findall(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String param = request.getParameter("param");
        request.setAttribute("param",param);
        return "/view/b.jsp";

    }
}
