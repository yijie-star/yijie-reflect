<%--
  Created by IntelliJ IDEA.
  User: name
  Date: 2022/6/30
  Time: 11:26
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
    <title>msg</title>
</head>
<body>
    <h1 style="color: green;text-align: center">${msg }</h1>
</body>
</html>
