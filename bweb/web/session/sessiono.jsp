<%--
  Created by IntelliJ IDEA.
  User: name
  Date: 2022/6/27
  Time: 15:35
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
<h1>已保存信息到session域中</h1>
    <%
        session.setAttribute("aaa","AAA");
    %>
</body>
</html>
