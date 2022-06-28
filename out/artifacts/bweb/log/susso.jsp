<%--
  Created by IntelliJ IDEA.
  User: name
  Date: 2022/6/27
  Time: 17:11
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
<%
    String username = (String) session.getAttribute("userName");
    if (username == null){
        /**
         * 向request中保存信息，转发到login.jsp
         */
        request.setAttribute("msg","您还没有登录！请重新进行登录。");
        request.getRequestDispatcher("/log/login.jsp").forward(request,response);
        return;
    }
%>
<h1>Success!</h1>
<h2>欢迎亲爱的<%=session.getAttribute("userName") %>会员登录</h2>
</body>
</html>
