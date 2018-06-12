<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
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
<title>查询</title>
</head>
<body>
	<table class="table table-striped table-bordered table-hover"
		id="sample-table">
		<thead>
			<tr>
				<th width="80px">ID</th>
				<th width="100px">名称</th>
				<th width="80px">是否展示</th>
				<th width="200px">简介</th>
			</tr>
		</thead>

		<tbody>
			<tr>
				<td>${category3.id }</td>
				<td>${category3.name }</td>
				<td>${category3.display }</td>
				<td>${category3.intro }</td>
			</tr>
		</tbody>
	</table>
</body>
</html>