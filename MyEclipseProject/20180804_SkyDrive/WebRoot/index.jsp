<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	<form action="myServlet?op=login" method="post">
		<h4>Welcome to SkyDrive</h4>
		用户名：<input type="text" name="userName" value="root"></input> <br>
		<input name="登录" value="submit" type="submit">
	</form>
	<a href="upload.jsp">文件上传</a>
	<a href="myServlet?op=listAll">查看所有文件</a>
</body>
</html>
