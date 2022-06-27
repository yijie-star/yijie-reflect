<%--
  Created by IntelliJ IDEA.
  User: name
  Date: 2022/6/27
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
<h1>已获取sessiont中的数据</h1>
<%
    String s = (String) session.getAttribute("aaa");

%>
<%=s%>
</body>
</html>
