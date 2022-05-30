<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Index.jsp</title>
</head>
<body>
    <h1>欢迎来到登录页面</h1>
    <form action="login" method="post" onsubmit="return login()">
        <input type="text" name="username" id="username" placeholder="请输入用户名" /><br>
        <input type="password" name="password" id="password" placeholder="请输入密码" /><br>
        <input type="submit" value="登录" />
        <input type="button" value="注册" onclick="window.open('http://localhost/maven-demo/register.jsp')" />
        <span style="color:red" id="loginError">
            <%=request.getAttribute("error")%>
        </span>
    </form>
    <script>
        var error = document.getElementById("loginError");

        if (error.innerText == "null") {
            error.style.display = "none";
        }

        function login(){
            var username = document.getElementById("username").value;
            var password = document.getElementById("password").value;
            if(username == "" || password == ""){
                alert("用户名或密码不能为空");
                return false;
            }
            return true;
        }
    </script>
</body>
</html>
