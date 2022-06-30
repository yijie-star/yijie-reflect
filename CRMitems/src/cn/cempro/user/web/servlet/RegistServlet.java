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

public class RegistServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        UserService userService = new UserService();

        User form = CommonUtils.toBean(req.getParameterMap(), User.class);

        /**
         * 表单校验：
         *  1、创建map，用来装在所有的表单错误信息
         *  2、校验过程中，如果失败向map中添加错误信息，其中key为表单字段名称
         *  3、校验之后，查看map长度是否大于0，大于--有错误信息
         *      保存map到request中，保存form到request中，转发到regist中
         */
        Map<String,String> errors = new HashMap<String,String>();
        String username = form.getUsername();
        String password = form.getPassword();
        if (username == null || username.trim().isEmpty()){
            errors.put("username","用户名不能为空！");
        }else if (username.length() < 3 || username.length() > 15){
            errors.put("username","用户名必须是3~15之间！");
        }

        if (password == null || password.trim().isEmpty()){
            errors.put("password","密码不能为空！");
        }else if (password.length() < 3 || password.length() > 15){
            errors.put("password","密码必须在3~15之间！");
        }

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
            req.getRequestDispatcher("/user/regist.jsp").forward(req,resp);
            return;
        }

        /**
         * 1、封装表单数据（到User对象中）
         * 2、调用userService的regist方法，传form过去
         * 3、得到异常：获取异常信息，保存到request域中，转发出去
         * 4、没有异常：输出注册成功
         */
        try {
            userService.regist(form);
            String sinIn = "<h2>注册成功！</h2><a href='" + req.getContextPath() + "/user/login.jsp" + "'><h3>登录</h3></a>";
            //resp.getWriter().print("<h2>注册成功！</h2><a href='" + req.getContextPath() + "/user/login.jsp" + "'>登录</a>");
            req.setAttribute("sinIn",sinIn);
            req.getRequestDispatcher("/user/regist.jsp").forward(req,resp);
        } catch (UserException e) {
            //获取异常信息，保存到request域中
            req.setAttribute("msg",e.getMessage());
            req.getRequestDispatcher("/user/regist.jsp").forward(req,resp);
        }
        /**
         * 校验验证码：
         * 1、用户填写的验证码已经封装到user中；
         * 2、从session获得真正的验证码，比较两者，如果不同，保存错误信息，转发
         * 3、相同什么也不做，向下执行
         */
        /*
        String sessionSecurityCode = (String) req.getSession().getAttribute("securityCode");
        if (!sessionSecurityCode.equalsIgnoreCase(form.getSecurityCode())){
            req.setAttribute("msg","验证码错误！请重新再试...");
            req.setAttribute("user",form);
            req.getRequestDispatcher("/user/regist.jsp").forward(req,resp);
            return;
        }
         */
    }
}
