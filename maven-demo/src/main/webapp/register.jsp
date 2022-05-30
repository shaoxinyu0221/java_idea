<%--
  Created by IntelliJ IDEA.
  User: shaoxinyu
  Date: 2022/5/29
  Time: 08:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<html>
<head>
    <title>注册页面</title>
</head>
<body>
  <h1>欢迎来到注册页面</h1>
  <form action="register" method="post" onsubmit="return register()">
      <span>请输入账号:</span><input type="text" name="username" id="username"/>
      <span>
          ${message}
      </span>
      <br>
      <span>请输入密码:</span><input type="password" name="password" id="password"/><br>
      <span>请确认密码:</span><input type="password" name="passwordOk" id="passwordOk" onblur="check()"/><br>
      <span>请输入年龄:</span><input type="number" name="age" id="age" placeholder="请选择年龄"/><br>
      <span>请输入性别:</span>
      <input type="radio" name="sex" id="man" value="男"/><label for="man">男</label>
      <input type="radio" name="sex" id="woman" value="女"/><label for="woman">女</label>
      <br><input type="submit" value="点击注册"/>
  </form>
<script>

    function register(){
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        var passwordOk = document.getElementById("passwordOk").value;
        var age = document.getElementById("age").value;
        if (username == "" || password == "" || passwordOk == "" || age == ""){
            alert("该选项不能为空")
            return false;
        }
        return true;
    }

    function check(){
        var password = document.getElementById("password").value;
        var passwordOk = document.getElementById("passwordOk").value;
        if (password != passwordOk){
            alert("两次密码输入必须一致")
        }
    }

</script>
</body>
</html>
