var vm = new Vue({
	el:"#content-div",
	data:{
		socket:"",
		uid:""
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
						vm.setMessageInnerHTML(ev.data);
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
		sendMessage:function () {
			var text = document.getElementById("text").value;
			this.socket.send(text+"|"+"eec384a3-0e64-11e9-833e-309c233cd1e5");
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
					console.log(resp);
				}
			})
		}
	},
	created:function () {
		this.uid = getCookie("uid");
		this.createWebSocket();
		this.queryRelationList();
	}
});