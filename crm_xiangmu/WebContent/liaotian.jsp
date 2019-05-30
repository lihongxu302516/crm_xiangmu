<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>聊天</title>
<script src="js/gonggong.js" type="text/javascript" charset="utf-8"></script>
<script src="js/yincang.js" type="text/javascript" charset="utf-8"></script>
<style type="text/css">



</style>
</head>
<body>


<div id="cc" class="easyui-layout" data-options="fit:true">   
    <div data-options="region:'south',title:'请输入信息',split:true" style="height:200px;">
    <div style="width: 86%;float: left;">
				<textarea cols="60" rows="10" id="nr_lt_neirong"
					style="OVERFLOW: hidden;width:100%"></textarea>
			</div>
	<a href="javascript:void(0);" onclick="send()" style="float: right;width: 13%;height: 150px;" class="easyui-linkbutton"> 发 送 </a>
    
    </div>   
    <div data-options="region:'east',title:'聊天信息',split:true" style="width:200px;">
    
    
    </div>    
    <div data-options="region:'center',title:'聊天内容'" >
    
    <div id="message"></div>
    
    
    </div>   
</div>



</body>
<script type="text/javascript">
	var us_name="${user.us_name}";
    var websocket = null;
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws:localhost:8080/crm_xiangmu/newwebsocket/"+us_name);
    }
    else {
        alert('当前浏览器 Not support websocket')
    }

    //连接发生错误的回调方法
    websocket.onerror = function () {
        setMessageInnerHTML("WebSocket连接发生错误");
    };

    //连接成功建立的回调方法
    websocket.onopen = function () {
        setMessageInnerHTML("您已进入聊天室！");
        websocket.send("您已进入聊天室！");
    }

    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        setMessageInnerHTML(event.data);
    }

    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("您已离开入聊天室！");
    }

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        closeWebSocket();
    }

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        document.getElementById('message').innerHTML += innerHTML + '<br/>';
    }

    //关闭WebSocket连接
    function closeWebSocket() {
        websocket.close();
    }

    //发送消息
    function send() {
        var message = $("#nr_lt_neirong").val();
        websocket.send(message);
    }
</script>
</html>