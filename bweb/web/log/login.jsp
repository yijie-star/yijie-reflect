<%--
  Created by IntelliJ IDEA.
  User: name
  Date: 2022/6/27
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
</head>
<body>
<%--本页面是登录页面，还要显示错误信息！--%>
<h1>登录</h1>
<%
    /**
     * 读取名为uname的cookie
     * 如果为空，显示：""
     * 如果不为空，显示：cookie的值
     */
    String uname = "";
    Cookie [] cookie  = request.getCookies();
    if (cookie != null){
        for (Cookie c : cookie
             ) {
            if ("uname".equalsIgnoreCase(c.getName())){
                uname = c.getValue();
            }
        }
    }
%>
<form action="/bweb/LoginServlet" method="post">
    用户名：<input type="text" name="username" value="<%=uname%>"><br>
    密 码：<input type="password" name="password"><br>
    验证码：<input type="text" name="captcha" size="3">
    <img id="img_captcha" src="/bweb//CaptchaServlet">
    <a href="javascript:reloadImage()">看不清楚！</a>
    <script type="text/javascript">
        function reloadImage(){
            /**
             * 1、得到img元素
             * 2、修改src为/bweb//CaptchaServlet
             */
            var imgEle = document.getElementById("img_captcha");
            imgEle.src = "/bweb//CaptchaServlet?captcha=" + new Date().getTime();
        }
    </script>
    <br>
    <input type="submit" value="登录">
</form><br>
<%
    String message = "";
    String msg = (String) request.getAttribute("msg");//获取request域中msg的属性
    if (msg != null){
        message = msg;
    }

%>
<span style="color: red; "><b><%=message %> </b></span>
</body>
</html>
