<%--
  Created by IntelliJ IDEA.
  User: name
  Date: 2022/6/29
  Time: 13:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%--<jsp:forward page="/frame.jsp"></jsp:forward>--%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>主页</title>
</head>
<body style="background: lightgray;text-align: center">
<c:choose>
    <c:when test="${empty sessionScope.sessionUser }">滚！</c:when>
    <c:otherwise>
        当前用户：${sessionScope.sessionUser.username }
    </c:otherwise>
</c:choose>


</body>
</html>
