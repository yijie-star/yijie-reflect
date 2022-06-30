<%--
  Created by IntelliJ IDEA.
  User: name
  Date: 2022/6/28
  Time: 15:48
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
    <title>regist</title>
    <script type="text/javascript">
        function _change(){
            /**
             * 1、得到img元素
             * 2、修改src为/bweb//CaptchaServlet
             */
            var imgEle = document.getElementById("img_captcha");
            imgEle.src = "/CRMitems//SecurityCode?securityCode=" + new Date().getTime();
        }

    </script>
</head>
<body>
    <div style="text-align: left;background: white;width: 178px;position: fixed;top: 20%;left: 39%">
        <form action="<c:url value="/RegistServlet"></c:url> " method="post">
            用户名：<input type="text" name="username" value="${user.username }"><br><br>
            密 码：<input type="password" name="password" value="${user.password }"><br><br>
            验证码：<input type="text" name="securityCode" style="width: 70px" value="${user.securityCode }"><br>
            <img id="img_captcha" src="<c:url value="/SecurityCode"></c:url> ">&nbsp;&nbsp;
            <a href="javascript:_change() ">换一张</a>
            <br><br>
            <input type="submit" value="注册">
            <div style="width: 200px;height: 110px;position: fixed;top: 19%;left: 54%;text-align: center;font-size: 15px">
                <p style="color: red">${msg }</p>
                <p style="color: red">${errors.username }</p>
                <p style="color: red">${errors.password }</p>
                <p style="color: red">${errors.securityCode }</p>
                <p style="color: red">${sinIn }</p>
            </div>
        </form>
    </div>
</body>
</html>
