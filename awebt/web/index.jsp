<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'a.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>

<%--get请求，传递过去method参数，指明调用TestServlet的fun2方法，并且传递一个参数param--%>
<a href="<c:url value='/TestServlet?method=fun2&param=哈哈'/>"> 点击这里啊</a>
<%--post请求--%>
<form action="<c:url value='/TestServlet'/>" method="post">
   <input type="hidden" name="method" value="fun1"/>
   <input type="text" name="param" value="我是表单参数" />
   <input type="submit" name="提交"/>
</form>
  </body>
</html>
