<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>chatroom</title>
        <link href="${pageContext.request.contextPath}/static/css/style.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
        <script>
			var userId = '${loginUser.uid}';
        </script>
	</head>


	<body>
		<div class="big-div" id="content-div">
			<div class="left-div">
				<div class="left-top-div">
                    <input type="text"  class="form-control" placeholder="搜索好友">
				</div>
				<div class="left-bottom-div">
					<div :style="chat.chatIndex == index ? 'background-color: #5e5e5e;':''" class="room-relation-list" v-for="(val,index) in relationList" @click="chatFun(index,val.relationId,val.targetUid)">
                        <img :src="val.headUrl"/>
                        <div class="room-relation-nick">
                            <span>{{val.nickName}}</span>
                        </div>
                        <div class="room-relation-msg">
                            <span></span>
                        </div>
                    </div>
				</div>
			</div>
			<div class="middle-div">
				<div class="middle-top-div">
				</div>
				<div class="middle-bottom-div">
                    <textarea v-model="writeMessage" rows="10" placeholder="请输入聊天内容" style="height: 100px;" class="form-control"></textarea>
                    <button class="room-send-button" @click="sendChat">确定</button>
				</div>
			</div>
			<div class="right-div">
				<div class="right-top-div">
				</div>
				<div class="right-bottom-div">
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