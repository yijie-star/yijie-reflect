<%--
  Created by IntelliJ IDEA.
  User: yijie
  Date: 2022/6/26
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>链接页面</h1>
    <a href="<c:url value='/BookServlet?method=findAll'></c:url> ">查询所有</a><br>
    <a href="<c:url value='/BookServlet?method=findByCategory&category=1'></c:url> ">查询SE</a><br>
    <a href="<c:url value='/BookServlet?method=findByCategory&category=2'></c:url> ">查询EE</a><br>
    <a href="<c:url value='/BookServlet?method=findByCategory&category=3'></c:url> ">查询Framework</a>
</body>
</html>
