<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>论文管理系统-论文列表</title>
	<link href="css/bootstrap.css" rel="stylesheet">
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
				<li>你现在的位置是：<a href="">商品管理</a></li>
				<li class="active"><a href="">添加商品</a></li>
			</ol>
		</div>
		
		<div class="container">
			<form action="${pageContext.request.contextPath}/manage/goods" method="post" id="myform">
				<input type="hidden" name="opr" value="gotoAddGoods">
				<table class="table table-bordered">
					<tr>
						<td class="col-md-1">商品名称：</td>
						<td class="text-center">
							<input type="text" class="form-control" name="goodsName" id="goodsName"
							placeholder="请输入商品名称"></td>
					</tr>

					<tr>
						<td>商品类型：</td>
						<td class="text-center">
							<select name="typeId" class="form-control">
								<option value="">---请选择---</option>
								<c:forEach var="category" items="${categoryList}">
									<option value="${category.id}">${category.name}</option>
								</c:forEach>
							</select>
						</td>
					</tr>

					<tr>
						<td>商品图片：</td>
						<td class="text-center">
						    <input type="file" name="goodPicture" id="goodPicture" class="pull-left">
						</td>
					</tr>

					<tr>
						<td>库存：</td>
						<td class="text-center">
							<input type="number" class="form-control" name="goodStock" id="goodStock">
						</td>
					</tr>
					<tr>
						<td>市场价：</td>
						<td class="text-center">
							<input type="number" class="form-control" name="marketPrice" id="marketPrice">
						</td>
					</tr>
					<tr>
						<td>销售价：</td>
						<td class="text-center">
							<input type="number" class="form-control" name="salePrice" id="salePrice">
						</td>
					</tr>
					<tr>
						<td>是否最新</td>
						<td class="text-center">
							<select class="form-control" name="isNew" id="isNew">
								<option value="Y">是</option>
								<option value="N">否</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>是否热卖</td>
						<td class="text-center">
							<select class="form-control" name="isHot" id="isHot">
								<option value="Y">是</option>
								<option value="N">否</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<button type="submit" class="btn btn-success">保存</button>
						</td>
					</tr>
				</table>
			</form>
		</div>



</body>
</html>