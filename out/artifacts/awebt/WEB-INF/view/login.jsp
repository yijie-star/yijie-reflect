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
        /**
         * 在文档加载完毕时，发出请求得到所有省份名称，
         * 在选择新的省份时，发送请求（参数是省名称），得到xml文档
         * 解析xml
         */
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
            var xmlHttp = creatXMLHttpRequest();
            xmlHttp.open("GET","/awebt/ProvinceServlet",true);
            xmlHttp.send(null);
            xmlHttp.onreadystatechange = function (){
                //获取服务端的响应
                if (xmlHttp.readyState == 4 && xmlHttp.status == 200){
                    var protext = xmlHttp.responseText;
                    //使用逗号分隔，得到数组
                    var arr = protext.split(",");
                    //遍历
                    for (var i = 0; i < arr.length; i++) {
                        var op = document.createElement("option");//创建指定名称的元素
                        op.value = arr[i];//设置op的实际值为当前的省份名称
                        var protextNode = document.createTextNode(arr[i]);//创建文本节点
                        op.appendChild(protextNode);//将文本子节点添加到op元素中，指定其显示值
                        document.getElementById("pro").appendChild(op);//
                    }
                }
            };
            var proSelet = document.getElementById("pro");
            proSelet.onchange = function (){
                var xmlHttp = creatXMLHttpRequest();
                xmlHttp.open("POST","/awebt/CityServlet ",true);
                xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
                xmlHttp.send("name=" + proSelet.value);//把下拉链表中选择的值发送给服务器
                xmlHttp.onreadystatechange = function (){
                    //获取服务端的响应
                    if (xmlHttp.readyState == 4 && xmlHttp.status == 200){
                        var cityselect = document.getElementById("res");
                        var optionList = cityselect.getElementsByTagName("option");
                        while (optionList.length > 1){
                            cityselect.removeChild(optionList[1]);
                        }

                        var document = xmlHttp.responseXML;
                        //使用逗号分隔，得到数组
                        var itemEleList = document.getElementsByTagName("item");
                        for (var i = 0; i < itemEleList.length; i++) {
                            var cityEle = itemEleList[i];
                            var cityName;
                            if (window.addEventListener()){
                                cityName = cityEle.textContent;
                            }else {
                                cityName = cityEle.text;
                            }
                            var op = document.createElement("option");//创建指定名称的元素
                            op.value = cityName;//设置op的实际值为当前的省份名称
                            var protextNode = document.createTextNode(cityName);//创建文本节点
                            op.appendChild(protextNode);//将文本子节点添加到op元素中，指定其显示值

                            cityselect.appendChild(op);
                        }
                    }
                };
            };
        };
    </script>
</head>
<body>
    <select name="province" id="pro">
        <option>请选择省份</option>
    </select>
    <select name="city" id="res">
        <option>请选择城市</option>
    </select>
</body>
</html>
