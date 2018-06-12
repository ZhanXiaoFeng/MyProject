<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<span>${message}</span>
	<form action="${pageContext.request.contextPath}/login.do"
		method="post">
		<div for="username">
			<input type="text" name="username" id="username" value="admin"
				placeholder="用户名" />
		</div>
		<div for="password">
			<input type="password" name="password" id="password" value="admin"
				placeholder="密码" />
		</div>
		<div>
			<input type="submit" value="登录">
		</div>
	</form>
</body>
</html>