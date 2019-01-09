var vm = new Vue({
	el:"#content-div",
	data:{
		socket:"",
		uid:"",
		targetUser:{

		},
		relationList:[],
		chat:{
			chatIndex:-1,
			relationId:"",
			targetUid:""
		},
		writeMessage:"",
		messageList:[]
	},
	methods:{
		createWebSocket:function () {

			if (!typeof (WebSocket) === undefined) {
				alert("你的浏览器不支持WebSocket!");
			} else {
				this.socket = new WebSocket("ws://localhost:10005/socket/"+this.uid);
				if (this.socket !== undefined && this.socket != null) {
					this.socket.onopen = function (ev) {
						console.log("连接成功,uid:" + vm.uid);
					};
					this.socket.onmessage = function (ev) {
						var msg = ev.data;
						var index = msg.lastIndexOf("|");
						var relationId = msg.substring(index+1);

						// 接收消息
						vm.queryMessageList(relationId);
					};
					this.socket.onclose = function (ev) {
						setCookie("uid", null);
						vm.socket.close();
					};
					/*window.onbeforeunload = function (ev) {
						setCookie("uid", null);
						vm.socket.close();
					};*/
					window.onclose = function (ev) {
						setCookie("uid", null);
						vm.socket.close();
					}
				}
			}
		},
		sendMessage:function (msg,uid) {
			// "消息" + "|" + "接收人uid" + "," + "发送人uid"
			// 后来加了一个发送人uid是为了，让接收人在onmessage的时候知道是谁给他发的消息，从而去查询relationId
			this.socket.send(msg+"|"+uid + "," + vm.uid);
		},
		setMessageInnerHTML:function (msg) {
			document.getElementById('message').innerHTML += '<li>'+msg + '</li>';
		},
		queryRelationList:function () {
			$.ajax({
				type: "post",
				url: "/user/queryRelationList.json",
				data: {
					uid:this.uid
				},
				dataType: "json",
				success: function (resp) {
					if (resp.code === "200") {
						vm.relationList = resp.data;
						console.log(vm.relationList);
					}
				},
				error:function (resp) {
					if (resp.status === 409) {
						window.location.href = "/login";
					}
				}
			});
		},
		chatFun:function (chatIndex,relationId,targetUid) {
			if (vm.chat.chatIndex !== chatIndex) {
				vm.writeMessage = "";
			}

			vm.chat = {
				chatIndex:chatIndex,
				relationId:relationId,
				targetUid:targetUid
			};
		},
		sendChat:function () {
			if (vm.chat.relationId === "") {
				alert("请选择联系人");
				return false;
			}
			if (vm.writeMessage === "") {
				alert("请输入内容");
				return false;
			}

			vm.sendMessage(vm.writeMessage,vm.chat.targetUid);
			this.addMessage();
			vm.writeMessage = "";
		},
		queryMessageList:function (relationId) {
			$.ajax({
				type: "post",
				url: "/user/findMessage.json",
				data: {
					relationId:relationId
				},
				dataType: "json",
				success: function (resp) {
					console.log(resp);
					if (resp.code === "200") {
						vm.messageList = resp.data[0].list;
					}
				},
				error:function (resp) {
					if (resp.status === 409) {
						window.location.href = "/login";
					}
				}
			});
		},
		addMessage:function () {
			$.ajax({
				type: "post",
				url: "/user/addMessage.json",
				data: {
					relationId:this.chat.relationId,
					uid:this.uid,
					msg:vm.writeMessage
				},
				dataType: "json",
				success: function (resp) {
					if (resp.code === "200") {
						// 如果消息发送成功，请求聊天记录
						vm.queryMessageList(vm.chat.relationId);
					}
				},
				error:function (resp) {
					if (resp.status === 409) {
						window.location.href = "/login";
					}
				}
			});
		}
	},
	created:function () {
		this.uid = userId;
		this.createWebSocket();
		this.queryRelationList();
	}
});