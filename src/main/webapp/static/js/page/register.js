var vm = new Vue({
	el:"#form-div",
	data:{
		register:{
			username:"",
			password:""
		}
	},
	methods:{
		userRegister:function () {
			if (vm.register.username === "") {
				alert("请输入用户名");
				return false;
			}
			if (vm.register.password === "") {
				alert("请输入密码");
				return false;
			}

			//hex_md5
			$.ajax({
				type: "post",
				url: "/user/register.json",
				data: {
					username: this.register.username,
					password: hex_md5(String(this.register.username) + String(this.register.password))
				},
				dataType: "json",
				success: function (resp) {
					if (resp.code === "200") {
						alert("注册成功");
					} else {
						alert(resp.message);
					}
				}
			})
		},
		userLogin:function () {
			window.location.href = "/login";
		}
	}
});