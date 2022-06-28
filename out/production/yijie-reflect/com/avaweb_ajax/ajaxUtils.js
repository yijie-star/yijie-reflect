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
};

/**
 *
 * @param method 请求方式
 * @param url 请求的URL
 * @param asyn 是否异步
 * @param parms 请求体
 * @param callback 回调方法
 * @param type 服务器响应数据转换成什么类型
 */
/**
 *
 * @param option method,url,asyn,parms,callback,type
 */
function ajax(option){
    /**
     * 1、得到xmlHttp
     */
    var xmlHttp = creatXMLHttpRequest();
    /**
     * 2、打来连接
     */
    if (!option.method){
        option.method = "GET";
    }
    if (option.asyn == undefined){
        option.async = true;
    }
    xmlHttp.open(option.method,option.url,option.asyn);
    /**
     * 3、判断是否为POST
     */
    if ("POST" == option.method){
        xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

    }
    /**
     * 4、发送请求
     */
    xmlHttp.send(option.parms);
    /**
     * 5、注册监听
     */
    xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200){
            var data;
            if (!option.type){
                data = xmlHttp.responseText;
            }else if (option.type == "xml"){
                data = xmlHttp.responseXML;
            }else if (option.type == "text"){
                data = xmlHttp.responseText;
            }else if (option.type == "json"){
                var text = xmlHttp.responseText;
                data = eval("(" + text + ")");
            }
            option.callback(data);
        }
    };
};