<%--
  Created by IntelliJ IDEA.
  User: yijie
  Date: 2022/6/24
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function creatXMLHttpRequest() {
            try {
                return new XMLHttpRequest();
            }catch (e){
                try {
                    return new ActiveXObject("Msxml2.XMLHTTP");//IE6.0
                }catch (e) {
                    try {
                        return new ActiveXObject("Microsoft.XMLHTTP");//IE5.5更早
                    }catch (e) {
                        alert("你用的是什么浏览器！");
                        throw e;
                    }
                }
            }
        }
        window.onload = function (){
            var userEle = document.getElementById("usernameEle");
            userEle.onblur = function (){
                var xmlHttp = creatXMLHttpRequest();
                xmlHttp.open("POST","/awebt/ValidateUsernameServlet",true)
                xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
                xmlHttp.send("username=" + userEle.value);
                xmlHttp.onreadystatechange = function () {
                    if(xmlHttp.readyState == 4 && xmlHttp.status == 200){//双重判断是否为4，是否为200
                        //获取服务器响应内容
                        var text = xmlHttp.responseText	;
                        var span = document.getElementById("errorSpan");
                        if (text == "1"){

                            span.innerHTML = "用户名已被注册！";
                        }else {
                            span.innerHTML = "";
                        }
                    }
                };
            }
        }
    </script>
</head>
<body>
    <form action="" method="post">
        用户名：<input type="text" name="username" id="usernameEle"><span id="errorSpan"></span><br>
        密码：<input type="password" name="password" id="passwors"/><br>
        <input type="submit" value="注册！">
    </form>
</body>
</html>
