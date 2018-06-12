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
<link rel="Shortcut Icon" href="favicon.ico" />
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
		<div class="type_title">图文类型信息</div>
		<table class="table table-striped table-bordered table-hover"
			id="sample-table" >
			<thead>
				<tr>
					<th width="80px">ID</th>
					<th width="100px">名称</th>
					<th width="200px">图片</th>
					<th width="80px">类别id</th>
					<th width="80px">是否展示</th>
					<th width="80px">排序</th>
					<th width="200px">描述信息</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pics2}" var="pics2">
					<tr>
						<td>${pics2.id }</td>
						<td>${pics2.name }</td>
						<td><img src="${pageContext.request.contextPath}/static/upload/${pics2.imgs }" style="width: 100px;height: 100px;"/></td>
						<td>${pics2.categoryId }</td>
						<td>${pics2.display }</td>
						<td>${pics2.level }</td>
						<td>${pics2.intro }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>