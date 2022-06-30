package cn.cempro.user.web.servlet;


import cn.cempro.user.domain.User;
import cn.cempro.user.service.UserException;
import cn.cempro.user.service.UserService;
import cn.itike.iutils.commons.CommonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * UserServlet层
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        UserService userService = new UserService();

        //封装表单数据到user form中
        User form = CommonUtils.toBean(req.getParameterMap(),User.class);


        Map<String,String> errors = new HashMap<>();
//        String username = form.getUsername();


//        if (username == null || username.trim().isEmpty()){
//            errors.put("username","用户名不能为空！");
//        }else if (username.length() < 3 || username.length() > 15){
//            errors.put("username","用户名必须是3~15之间！");
//        }

        String securityCode = form.getSecurityCode();
        String sessionSecurityCode = (String) req.getSession().getAttribute("securityCode");
        if (securityCode == null || securityCode.trim().isEmpty()){
            errors.put("securityCode","验证码不能为空！");
        }else if (securityCode.length() != 4){
            errors.put("securityCode","验证码长度必须为4！");
        }else if (!securityCode.equalsIgnoreCase(sessionSecurityCode)){
            errors.put("securityCode","验证码错误！");
        }
        /**
         * 判断map是否为空，不为空说明存在错误
         * 1、保存errors到request域中
         * 2、保存form到request域中为了回显
         * 3、转发到regist
         */
        if (errors != null && errors.size() > 0){
            req.setAttribute("errors",errors);
            req.setAttribute("user",form);
            req.getRequestDispatcher("/user/login.jsp").forward(req,resp);
            return;
        }


        try {
            User user = userService.login(form);
            req.getSession().setAttribute("sessionUser",user);
            resp.sendRedirect(req.getContextPath() + "/frame.jsp");
        }catch (UserException e){
            req.setAttribute("msg",e.getMessage());
            req.setAttribute("user",form);
            req.getRequestDispatcher("/user/login.jsp").forward(req,resp);
        }

    }
}
