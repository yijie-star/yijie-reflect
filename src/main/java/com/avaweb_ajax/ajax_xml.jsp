<%--
  Created by IntelliJ IDEA.
  User: yijie
  Date: 2022/6/25
  Time: 11:02
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
        window.onload = function (){//文档加载完成后
            var btn = document.getElementById("btn");
            btn.onclick = function (){//按钮监听
                var xmlHttp = creatXMLHttpRequest();
                xmlHttp.open("POST",'/awebt/BServlet',true);
                xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
                xmlHttp.send("username=zhangsang&password=123");
                xmlHttp.onreadystatechange = function (){
                    if (xmlHttp.readyState == 4 && xmlHttp.status == 200){
                        var doc = xmlHttp.responseXML;
                        var ele = doc.getElementsByTagName("student")[0];
                        var number = ele.getAttribute("number");
                        var name ;
                        if (window.addEventListener()){//判断浏览器差异
                            name = ele.getElementsByTagName("name")[0].textContent;
                        }else {
                            name = ele.getElementsByTagName("name")[0].text;
                        }//下面也可以如此判断
                        var age = ele.getElementsByTagName("age")[0].textContent;
                        var sex = ele.getElementsByTagName("sex")[0].textContent;
                        var text = number + "," + name + "," + age + "," + sex;
                        document.getElementById("h1").innerHTML = text;
                    }
                };
            };
        };
    </script>
</head>
<body>
    <button id="btn">点击这里</button>
    <h1 id="h1">郑宇城啥B！！！</h1>
</body>
</html>
