<%--
  Created by IntelliJ IDEA.
  User: name
  Date: 2022/6/30
  Time: 10:46
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
    <title>主页</title>
</head>
<frameset rows="30%,*">
    <frame src="<c:url value="/top.jsp"></c:url> " name="top">
    <frame src="<c:url value="/user/welcome.jsp"></c:url> " name="main">
</frameset>
<body style="background: lightgray;text-align: center">
</body>
</html>
