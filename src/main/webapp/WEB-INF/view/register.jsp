<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>chatroom</title>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="width: 350px">

    <form class="form-signin" id="form-div">
        <h2 class="form-signin-heading">注册</h2>
        <label for="inputName" class="sr-only">user name</label>
        <input v-model="register.username" type="text" id="inputName" class="form-control" placeholder="用户昵称,必须唯一" required
               autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input v-model="register.password" type="password" id="inputPassword" class="form-control" placeholder="登录密码"
               required>
        <br/>
        <button class="btn btn-lg btn-primary btn-block" type="button" @click="userRegister">注册</button>
        <button class="btn btn-lg btn-primary btn-block" type="button" @click="userLogin">登录</button>
    </form>

</div>

<script src="${pageContext.request.contextPath}/static/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/vue.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/vue-resource.js"></script>
<script src="${pageContext.request.contextPath}/static/js/md5.js"></script>
<script src="${pageContext.request.contextPath}/static/js/page/register.js"></script>
</body>
</html>