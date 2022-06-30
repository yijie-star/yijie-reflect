<%--
  Created by IntelliJ IDEA.
  User: name
  Date: 2022/6/30
  Time: 10:56
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
    <title>添加客户</title>
    <script language="JavaScript" src="jquery.js"></script>
    <script language="JavaScript" src="jq.date.js"></script>
    <script src="js/jquery.ui.datepicker-zh-CN.js"></script>
    <script type="text/javascript">
        function add(){
            $(".error").text("");
            var bool = true;
            if (!$(":text[name=cname]").val()){
                $("#cnameError").text("客户名称不能为空");
                bool = false;
            }
            if (!$(#male).attr("checked") && !$("#female").attr("checked")){
                $("#genderError").text("客户性别不能为空");
                bool = false;
            }
            if (!$(":text[name=cellphone]").val()){
                $("#cellphoneError").text("手机号不能为空");
                bool = false;
            }
            if (!$(":text[name=email]").val()){
                $("#emailError").text("email不能为空");
                bool = false;
            }
            if (bool){
                $("form").submit();
            }
        }
    </script>
</head>
<body style="background: lightgray;text-align: center">
<c:choose>
    <c:when test="${empty sessionScope.sessionUser }">滚！</c:when>
    <c:otherwise>
        当前用户：${sessionScope.sessionUser.username }
        <form action="<c:url value="/CustomerServlet"></c:url> " method="post" style="text-align: center">
                <%--    向servlet传递个名为method的参数，其值表示要调用的servlet的哪一个方法--%>
            <input type="hidden" name="method" value="add">
            <table border="0" align="center" width="40%" style="margin-left: 100px;">
                <tr>
                    <td width="100px">客户名称</td>
                    <td width="40%">
                        <input type="text" name="cname">
                    </td>
                    <td align="left">
                        <label id="cnameError" class="error">&nbsp;</label>
                    </td>
                </tr>
                <tr>
                    <td>客户性别</td>
                    <td>
                        <input type="radio" name="gender" value="男" id="male">
                        <label for="male">男</label>
                        <input type="radio" name="gender" value="女" id="female">
                        <label for="female">女</label>
                    </td>
                    <td>
                        <label id="genderError" class="error">&nbsp;</label>
                    </td>
                </tr>
                <tr>
                    <td>客户生日</td>
                    <td>
                        <input type="text" name="birthday" id="birthday" property="property">
                    </td>
                    <td>
                        <label id="birthdayError" class="error">&nbsp;</label>
                    </td>
                </tr>
                <tr>
                    <td>手机</td>
                    <td>
                        <input type="text" name="cellphone" id="cellphone">
                    </td>
                    <td>
                        <label id="cellphoneError" class="error">&nbsp;</label>
                    </td>
                </tr>
                <tr>
                    <td>邮箱</td>
                    <td>
                        <input type="text" name="email" id="email">
                    </td>
                    <td>
                        <label id="emailError" class="error">&nbsp;</label>
                    </td>
                </tr>
                <tr>
                    <td>描述</td>
                    <td>
                        <input type="text" name="description" id="description">
                    </td>
                    <td>
                        <label id="descriptionError" class="error">&nbsp;</label>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <input type="submit" value="添加客户">
                        <input type="reset" value="重置">
                    </td>
                </tr>

            </table>

        </form>
    </c:otherwise>
</c:choose>

</body>
</html>
