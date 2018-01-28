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
<title>顾客信息</title>
</head>
<body>
	<h1>所有顾客信息</h1>
	<hr>
	<br>
	<br>
	<br>
	<h3 align="center">
		用户列表
		<h3>
			<hr>

			<table border="1px" align="center" width="600px" height="300px">
				<tr>
					<td>序号</td>
					<td>用户名</td>
					<td>密码</td>
					<td>昵称</td>
					<td>头像</td>
					<td>电话号码</td>
					<td>电子邮箱</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${allCusts }" var="info">
					<tr>
						<td>${info.id}</td>
						<td>${info.username}</td>
						<td>${info.password}</td>
						<td>${info.nickname}</td>
						<td>${info.imgurl}</td>
						<td>${info.phone}</td>
						<td>${info.email}</td>

						<td><a
							href="${pageContext.request.contextPath }/customer/editCust.do?id=${info.id}">修改</a>
							<a
							href="${pageContext.request.contextPath }/customer/deleteCust.do?id=${info.id}">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			
			<%-- <p align="center">
				<a href="${pageContext.request.contextPath }/addCust.do">添加新用户</a>
			</p> --%>
</body>
</html>
