<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>论文管理-登录</title>
	<link href="css/bootstrap.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript">
    	
    </script>
</head>
<body>
	<div style="width:20%;margin:0 auto; text-align: center; padding-top:5% ">
		<p id="msg" style="color:red"></p>
		<form action="${pageContext.request.contextPath}/manage/category" id="myform" method="post">
			<input type="hidden" name="opr" value="login" />
			<div class="form-group form-inline">
				<label for="account">用户名：</label>
		        <input type="text" class="form-control" id="account" name="account" placeholder="请输入用户名">
			</div>
			<div class="form-group form-inline">
				<label for="account">密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
		    	<input type="password" class="form-control" id="password" name="password" placeholder="请输入密码"/>
			</div>
			<div class="form-group">
				<input class="btn btn-success btn-md" id="btnLogin" type="submit" value="登录">
				<button class="btn btn-danger btn-md"  type="reset">取消</button>
			</div>
		</form>
		<p align="center">${error}</p>
	</div>
</body>
</html>