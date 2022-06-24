<%--
  Created by IntelliJ IDEA.
  User: yijie
  Date: 2022/6/24
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        //创建异步对象
        function creatXMLHttpRequest(){
            try{
                return new XMLHttpRequest();
            }catch(e){
                try{
                    return new ActiveXObject("Msxml2.XMLHTTP");//IE6.0
                }catch(e){
                    try{
                        return new ActiveXObject("Microsoft.XMLHTTP");//IE5.5更早
                    }catch(e){
                        alert("你用的是什么浏览器！")
                        throw e;
                    }
                }
            }
        }
        window.onclick = function(){//文档加载完毕后
            var btn = document.getElementById("btn");
            btn.onclick = function(){//给按钮的点击事件注册监听
                //得到异步对象
                var xmlHttp = new XMLHttpRequest();
                //请求连接
                xmlHttp.open("GET","<c:url value = '/AServlet'>",true);
                //发送请求
                xmlHttp.send(null);
                //xmlHttp对象的一个事件上注册一个监听器：onreadystatechange
                xmlHttp.onreadystatechange = function () {
                    if(xmlHttp.readyState == 4 && xmlHttp.status == 200){//双重判断是否为4，是否为200
                        //获取服务器响应内容
                        var text = xmlHttp.responseText	;
                        //获取h1元素
                        var h1 = document.getElementById("h1");
                        h1.innerHTML = text;
                    }
                };
            }
        };
    </script>
</head>
<body>
    <button id="btn">点击这里</button>
    <h1 id="h1">Hello ajax!</h1>
</body>
</html>
