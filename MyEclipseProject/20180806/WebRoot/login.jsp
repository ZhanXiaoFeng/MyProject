<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>SkyDrive</title>
</head>

<body>
	<form action="loginServlet" method="post">
		用户名：<input name="username" type="text" value="myDir" /><br> 
		密码：<input name="password" type="password" value="root"><br> 
		    <input type="submit" value="登录">
	</form>
</body>
</html>
