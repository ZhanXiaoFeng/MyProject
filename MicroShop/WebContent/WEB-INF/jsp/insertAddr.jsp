<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建地址</title>
</head>
<body>
${message}
<form action="${pageContext.request.contextPath }/insertAddr.do">
    <input type="hidden" name="customerId" placeholder="顾客id" value="4"><br>
	<input type="text" name="addr" placeholder="地址"><br>
	<input type="text" name="area" placeholder="具体地址"><br>
	<input type="text" name="name" placeholder="收件人姓名"><br>
	<input type="text" name="phone" placeholder="收件人电话"><br>
	默认备注<input type="radio" name="def" value="1">是
	<input type="radio" name="def" value="0">否<br>
	<input type="text" name="remark" placeholder="备注"><br>
	<input type="submit" value="添加地址">
</form>
</body>
</html>