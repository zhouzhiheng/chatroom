window.onload=function(){
	var vm = new Vue({
		el: "#form-div",
		data: {
			login: {
				username: "",
				password: ""
			}
		},
		methods: {
			userLogin: function () {
				if (vm.login.username === "") {
					alert("请输入用户名");
					return false;
				}
				if (vm.login.password === "") {
					alert("请输入密码");
					return false;
				}

				//hex_md5
				$.ajax({
					type: "post",
					url: "/chatroom/login.json",
					data: {
						username: this.login.username,
						password: hex_md5(String(this.login.username) + String(this.login.password))
					},
					dataType: "json",
					success: function (resp) {
						if (resp.code === "200") {
							setCookie("uid", resp.data.uid,24 * 60 * 60 * 1000);
							window.location.href = "/room";
						} else {
							alert(resp.message);
						}
					}
				})
			},
			userRegister:function () {
				window.location.href = "/register";
			}
		}
	});
};