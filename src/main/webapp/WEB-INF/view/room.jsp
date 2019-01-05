<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>chatroom</title>
</head>
<script>
    var userId = '${loginUser.uid}';
</script>
<body>

<div id="content-div">
    <div>
        接收的消息:
        <ul id="message">
        </ul>

    </div>

    好友列表
    <div>
        <ul>
            <li v-for="(val,index) in relationList" style="cursor: pointer" @click="chatFun(index,val.relationId,val.targetUid)">
                {{val.nickName}}
                <div v-show="index == chat.chatIndex">
                    <input type="text" placeholder="请输入内容" v-model="writeMessage"/>
                    <input type="button" value="发送" @click="sendChat"/>
                </div>
            </li>
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