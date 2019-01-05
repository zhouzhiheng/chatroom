<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>chatroom</title>
        <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet">
        <script>
			var userId = '${loginUser.uid}';
        </script>
	</head>

    <%--<div>
        <ul>
            <li v-for="(val,index) in relationList" style="cursor: pointer" @click="chatFun(index,val.relationId,val.targetUid)">
                {{val.nickName}}
                <div v-show="index == chat.chatIndex">
                    <input type="text" placeholder="请输入内容" v-model="writeMessage"/>
                    <input type="button" value="发送" @click="sendChat"/>
                </div>
            </li>
        </ul>
    </div>--%>

	<body>
		<div class="big-div" id="content-div">
			<div class="left-div">
				<div class="left-top-div">
                    <input type="text" placeholder="搜索好友">
				</div>
				<div class="left-bottom-div">
					这里是左边div的底部
				</div>
			</div>
			<div class="middle-div">
				<div class="middle-top-div">
					这里是中边div的上边
				</div>
				<div class="middle-bottom-div">
					这里是中边div的下边
				</div>
			</div>
			<div class="right-div">
				<div class="right-top-div">
					这里是右边div的上边
				</div>
				<div class="right-bottom-div">
					这里是右边div的下边
				</div>
			</div>

		</div>

        <script src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/vue.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/vue-resource.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/utils.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/page/room.js"></script>
	</body>

</html>