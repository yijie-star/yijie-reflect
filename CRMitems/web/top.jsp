<%--
  Created by IntelliJ IDEA.
  User: name
  Date: 2022/6/30
  Time: 10:49
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
    <base href="<%=basePath%>" target="main">
    <title>top</title>
</head>
<body style="text-align: center">
    <h1>客户关系管理系统</h1>
    <a href="<c:url value="/add.jsp"></c:url> ">添加客户</a>
    <a href="<c:url value="/list.jsp"></c:url> ">查询客户</a>
    <a href="<c:url value="/query.jsp"></c:url> ">高级搜索</a>
</body>
</html>
