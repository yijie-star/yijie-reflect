package cn.java.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        /**
         * 校验验证码
         * 1、从session中获取正确的验证码
         * 2、从表单中获取用户填写的验证码
         * 3、进行比较，相同向下运行，否则保存到request域中，转发到login.jsp
         */
        String captcha = (String) req.getSession().getAttribute("captcha");
        String usercaptcha = req.getParameter("captcha");
        if (!usercaptcha.equalsIgnoreCase(captcha)){
            req.setAttribute("msg","验证码错误！请重新再试....");
            RequestDispatcher qr = req.getRequestDispatcher("/log/login.jsp");//得到转发器
            qr.forward(req,resp);//转发
            return;
        }


        /**
         * 1、获取表单数据
         * 2、校验用户名或密码是否正确
         * 3、登录成功，保存用户信息到session域中
         *      重定向到susso.jsp中
         * 4、登录失败
         *     保存错误信息到request域中
         *     转发到login.jsp中
         */

        String userName = req.getParameter("username");
        String passWord = req.getParameter("password");
        if (!"yijie".equalsIgnoreCase(userName)){
            /**
             * 附加：把用户名保存到cookie中，发送给客户端浏览器
             * 当再次打开login时，login.jsp中会读取request中的cookie，把它显示到用户名文本框
             */
            Cookie cookie = new Cookie("uname",userName);//创建cookie
            cookie.setMaxAge(60*60*24);//设置cookie的命长为1天
            resp.addCookie(cookie);
            HttpSession session = req.getSession();
            session.setAttribute("userName",userName);
            resp.sendRedirect("/bweb/log/susso.jsp");
        }else {
            req.setAttribute("msg","用户名或密码错误！");
            RequestDispatcher qr = req.getRequestDispatcher("/log/login.jsp");//得到转发器
            qr.forward(req,resp);//转发
        }

    }
}
