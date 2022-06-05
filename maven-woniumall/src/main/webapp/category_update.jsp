<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>论文管理系统-论文列表</title>
	<link href="http://localhost/maven-woniumall/css/bootstrap.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery-3.5.1.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
<style type="text/css">
.table tbody tr td {
	vertical-align: middle;
}

table {
	margin-top: 10px;
}
</style>
</head>
<body>
	
		<div>
			<!-- 路径导航  -->
			<ol class="breadcrumb">
				<li>你现在的位置是：商品管理</li>
				<li class="active"><a href="">修改类别</a></li>
			</ol>
		</div>
		
		<div class="container">
			<form action="${pageContext.request.contextPath}/manage/category" method="post" id="myform">
				<input type="hidden" name="opr" value="categoryUpdate">
				<input type="hidden" name="id" value="${category.id}">
				<table class="table table-bordered">
					<tr>
						<td class="col-md-1">类别名称：</td>
						<td class="text-center">
							<input type="text" class="form-control" name="title" id="title" value="${category.name}">
						</td>
					</tr>
					<tr>
						<td>类别状态：</td>
						<td class="text-center">
							<select name="categoryStatus" class="form-control">
								<option value="1" ${category.status eq 1?"selected":""}>正常</option>
								<option value="0" ${category.status eq 0?"selected":""}>禁用</option>
							</select>
						</td>
					</tr>

					<tr>
						<td colspan="2" class="text-center">
							<input type="submit" class="btn btn-success" value="提交">
						</td>
					</tr>
				</table>
			</form>
		</div>
</body>
</html>