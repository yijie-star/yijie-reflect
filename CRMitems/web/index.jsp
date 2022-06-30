<%--
  Created by IntelliJ IDEA.
  User: name
  Date: 2022/6/28
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%--<jsp:forward page="/frame.jsp"></jsp:forward>--%>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>yijie</title>
  </head>
  <body>
  <div style="height: 345px;width: 460px;background: darkseagreen;position: relative;left: 32%;top: 82px;">
    <h1 style="position: absolute;top: 60px;left: 100px">客户关系管理系统</h1>
    <br><br><br><br><br><br>
    <br><br><br><br>
    <a href="<c:url value="/user/regist.jsp"></c:url> ">
      <button type="button" style="width: 95px;"><h2>注册</h2></button>
    </a>
    <a href="<c:url value="/user/login.jsp"></c:url> ">
      <button type="button" style="width: 95px;position: absolute;left: 365px"><h2>登录</h2></button>
    </a>


  </div>
  </body>
</html>
