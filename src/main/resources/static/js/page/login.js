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
						password: hex_md5(this.login.password)
					},
					dataType: "json",
					success: function (resp) {
						console.log(resp);
					}
				})

			}
		}
	});
};