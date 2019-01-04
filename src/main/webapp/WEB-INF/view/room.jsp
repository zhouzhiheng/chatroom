<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>chatroom</title>
</head>
<body>

<div id="content-div">
    <label for="text"></label><input id="text" type="text"/><br/>
    <button type="button" @click="sendMessage">发送</button>

    <br/>

    <div>
        接收的消息:
        <ul id="message">
        </ul>

    </div>

</div>


    <script src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/vue.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/vue-resource.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/utils.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/page/room.js"></script>
    <script>

    </script>
</body>
</html>