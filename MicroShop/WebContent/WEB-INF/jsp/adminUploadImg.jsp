<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上传头像</title>
</head>
<body>
	<span>${message}</span>
	<form action="${pageContext.request.contextPath}/uploadImg.do"
		method="post" enctype="multipart/form-data">
		<input type="hidden" name="id"
			value="<%=request.getParameter("id")%>" />
		<span>头像上传</span>
		<div style="height: 100px; width: 100px">
			<input type="file" name="file" id="file" />
		</div>
		<div>
			<input type="submit" value="点击上传">
		</div>
	</form>
</body>
</html>