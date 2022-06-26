<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value='/BookServlet?method=fun2&param=哈哈'/>"> 点击这里啊</a><br>

<h1>链接页面</h1>
<a href="<c:url value='/BookServlet?method=findall'/>">查询所有</a><br>
<a href="<c:url value='/BookServlet?method=findByCategory&category=1'/>">查询SE</a><br>
<a href="<c:url value='/BookServlet?method=findByCategory&category=2'/>">查询EE</a><br>
<a href="<c:url value='/BookServlet?method=findByCategory&category=3'/>">查询Framework</a>
</body>
</html>