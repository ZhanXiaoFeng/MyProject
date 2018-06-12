<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>顾客结账</title>
<link href="css/waiterindex.css" rel='stylesheet' type='text/css' media="all" />
<link href="css/showDeskForOrder.css" rel='stylesheet' type='text/css' media="all" />
</head>
<body>
<div class = "header-section"><!--插入背景图 -->
<div class="div-inline"><center>
	<table>
		<tr>
			<td>	
			<div class="container">
			<div class="header-top">				
				<div class="header-logo">
					<a href="index.html"><img src="img/windex/logo.png" alt="" /></a>
				</div>	<!--插入返回首页的背景图 -->
			</div>
			</div>
			</td>
		</tr>
	</table>
   </center>
</div>
<br><br><br><br>
<div class="bb">
   <div class = "aa"  > &nbsp;&nbsp;请选择要结账的餐桌<br><br>
	<c:forEach items="${allHaveSelectedDesk}" var="haveSelectedDesk">
		<form action="orderServlet?op=showPayMoneyOrder" method="post">
		    <input type="hidden" value="${haveSelectedDesk.totalPrice}" name="haveSelectedDeskTotalPrice">
		    <input type="hidden" value="${haveSelectedDesk.id }" name="haveSelectedDeskId">
			&nbsp;&nbsp;为餐桌<c:out value="${haveSelectedDesk.id }">结账</c:out>
			<input type="submit"  style="weight:150px;height:40px;color:black;background:white"value="结账"> 
			<br>
			<br>
			<br>
		</form>
	</c:forEach>
	</div>
</div>
</div>
</body>
</html>
