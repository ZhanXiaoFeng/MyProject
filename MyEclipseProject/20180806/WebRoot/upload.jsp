<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="zh-cn">
<head>
</head>
<body>
	<form action="${ctx }/uploadServlet" method="post" enctype="multipart/form-data">
		<input name="file" type="file"/> 
		<input type="submit" value="upload"/>
	</form>
	${msg }
</body>
</html>