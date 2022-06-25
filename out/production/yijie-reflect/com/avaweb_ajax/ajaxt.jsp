
<%--
  Created by IntelliJ IDEA.
  User: yijie
  Date: 2022/6/24
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>mweb</title>
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-vache">
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
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
        window.onload = function (){//文档加载完成后
            var btn = document.getElementById("btn");
            btn.onclick = function (){//按钮监听
                var xmlHttp = creatXMLHttpRequest();
                xmlHttp.open("POST","/awebt/BServlet",true);
                xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
                xmlHttp.send("username=zhangsang&password=123");
                xmlHttp.onreadystatechange = function (){
                    if (xmlHttp.readyState == 4 && xmlHttp.status == 200){
                        var text = xmlHttp.responseText;
                        var h1 = document.getElementById("h1");
                        h1.innerHTML = text;
                    }
                };
            };
        };
    </script>
</head>
<body>
<button id="btn">点击这里</button>
<h1 id="h1">郑宇城啥B！！！</h1>
<h2>我要吃饭！</h2>

<a href="https://www.baidu.com">点击我</a>

</body>
</html>
