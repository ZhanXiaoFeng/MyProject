<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除地址</title>
</head>
<body>
${message}
<form action="${pageContext.request.contextPath }/deleteAddr.do">
    <input type="hidden" name="customerId" placeholder="顾客id" value="4"><br>
	<input type="text" name="id" placeholder="输入地址id"><br>
	<input type="submit" value="删除地址">
</form>
</body>
</html>