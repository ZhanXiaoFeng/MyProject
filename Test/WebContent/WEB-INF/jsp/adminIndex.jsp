<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员主页</title>
</head>
<body>
	<span>${message},${admin2.username}</span>
	<h3>个人资料</h3>
	<a href="${pageContext.request.contextPath}/selectById.do?id=${admin2.id}">查看个人信息</a><br/>
	<a href="${pageContext.request.contextPath}/uploadImg.html?id=${admin2.id}">头像上传</a>
</body>
</html>