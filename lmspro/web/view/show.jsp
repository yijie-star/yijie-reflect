<%--
  Created by IntelliJ IDEA.
  User: yijie
  Date: 2022/6/26
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1 align="center">图书列表</h1>
    <table border="1" align="center" width="50%">
        <tr>
            <th>图书名</th>
            <th>单价</th>
            <th>分类</th>
        </tr>
        <c:forEach items="${bookList}" var="book">
        <tr>
            <td>${book.bname}</td>
            <td>${book.price}</td>
            <td>${book.category}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
