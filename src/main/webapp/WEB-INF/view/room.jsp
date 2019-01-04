<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>chatroom</title>
</head>
<body>

<label for="text"></label><input id="text" type="text"/><br/>
    <button type="button" onclick="sendMessage()">发送</button>

    <br/>

    <div>
        接收的消息:
        <ul id="message">
        </ul>

    </div>


    <script src="${pageContext.request.contextPath}/static/js/utils.js"></script>
    <script>
	    var uid = getCookie("uid");

        var socket;
        if (!typeof (WebSocket) === undefined) {
	        alert("你的浏览器不支持WebSocket!");
        } else {
	        socket = new WebSocket("ws://localhost:10005/socket/"+uid);
	        if (socket !== undefined && socket != null) {
	        	socket.onopen = function (ev) {
			        console.log("连接成功,uid:" + uid);
                };
	        	socket.onmessage = function (ev) {
			        setMessageInnerHTML(ev.data);
                };
	        }
        }


        function sendMessage() {
	        var text = document.getElementById("text").value;
	        socket.send(text+"|"+"eec384a3-0e64-11e9-833e-309c233cd1e5");
        }


	    function setMessageInnerHTML(msg) {
		    document.getElementById('message').innerHTML += '<li>'+msg + '</li>';
	    }

    </script>
</body>
</html>