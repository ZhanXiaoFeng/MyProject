<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/addOrder.do">
	<input type="text" name="status" placeholder="订单状态"><br>
	<input type="text" name="price" placeholder="价格"><br>
	<input type="text" name="paymethod" placeholder="支付方式"><br>
	<input type="text" name="addrId" placeholder="客户地址ID"><br>
	<input type="text" name="customerId" placeholder="客户ID"><br>
	<input type="submit" value="添加">
</form>
</body>
</html>