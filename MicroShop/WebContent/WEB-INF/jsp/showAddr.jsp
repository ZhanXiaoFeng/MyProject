<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>查看地址</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" charset="UTF-8">
	$(function() {
		$("#sjs")
				.change(
						function() {
							var v = $("#sjs").val();//获取当前所选择的类别的ID
							location.href = "${pageContext.request.contextPath}/showAddrById?id="+v;
						});
	});
</script>
</head>
<body>
	请选择需要查询单个地址
	<select id="sjs">
		<c:forEach items="${Addrs}" var="i">
			<option value="${i.id }">${i.name }</option>
		</c:forEach>
	</select>
	<a href="${pageContext.request.contextPath }/showAllAddr.do">查看所有地址</a>
</body>
</html>