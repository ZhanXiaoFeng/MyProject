<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>用户首页</title>
</head>
<body>
	<h1>欢迎${login.username }进入主页</h1>
	<hr>
	<br>
	<br>
	<br>
	<h3 align="center">
		用户列表
		<h3>
			<hr>
			<p align="center">
				<a href="${pageContext.request.contextPath }/customer/selectAllCust.do">查询所有顾客信息</a>
			</p>
</body>
</html>
