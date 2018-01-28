<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link
	href="${pageContext.request.contextPath}/static/category/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/category/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/category/assets/css/ace.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/category/assets/css/font-awesome.min.css" />
<link
	href="${pageContext.request.contextPath}/static/category/Widget/icheck/icheck.css"
	rel="stylesheet" type="text/css" />
<script
	src="${pageContext.request.contextPath}/static/category/js/jquery-1.9.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/category/assets/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>根据类别商品信息</title>
</head>
<body>
	<div class="type_style">
		<div class="type_title">产品类型信息</div>
		<table class="table table-striped table-bordered table-hover"
			id="sample-table" >
			<thead>
				<tr>
					<th width="80px">ID</th>
					<th width="100px">名称</th>
					<th width="200px">图片</th>
					<th width="80px">商品关键字</th>
					<th width="80px">商品颜色</th>
					<th width="80px">类别id</th>
					<th width="80px">市场价格</th>
					<th width="80px">平台价格</th>
					<th width="80px">销量</th>
					<th width="80px">产地</th>
					<th width="80px">是否包邮</th>
					<th width="80px">是否上架</th>
					<th width="80px">排序</th>
					<th width="80px">库存</th>
					<th width="200px">描述信息</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${goods2}" var="goods2">
					<tr>
						<td>${goods2.id }</td>
						<td>${goods2.name }</td>
						<td><img src="${pageContext.request.contextPath}/static/upload/${goods2.imgs }" style="width: 100px;height: 100px;"/></td>
						<td>${goods2.tags }</td>
						<td>${goods2.color }</td>
						<td>${goods2.categoryId }</td>
						<td>${goods2.price1 }</td>
						<td>${goods2.price2 }</td>
						<td>${goods.xiaoLiang }</td>
						<td>${goods2.source }</td>
						<td>${goods2.baoYou }</td>
						<td>${goods2.display }</td>
						<td>${goods2.level_ }</td>
						<td>${goods2.kuCun }</td>
						<td>${goods2.intro }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>