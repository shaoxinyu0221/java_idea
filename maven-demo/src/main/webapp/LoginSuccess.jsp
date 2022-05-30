<%@ page import="com.demo.entity.User" %>
<%@ page import="com.demo.service.UserService" %>
<%@ page import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: shaoxinyu
  Date: 2022/5/27
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录成功</title>
</head>
<body>
    <h1>登录成功</h1>
    <%
        List<User> users = UserService.getUsers();
        request.setAttribute("users",users);
    %>
    <table>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>密码</td>
            <td>年龄</td>
            <td>性别</td>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.age}</td>
                <td>${user.sex}</td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
