<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>删除菜品</title>
<link rel="stylesheet" type="text/css" href="../css/allmenu.css">
</head>
<body>

	<section class="rt_wrap content mCustomScrollbar">
		<div class="rt_content">
		<div class="page_title">
			<h2 class="fl">删除菜品</h2>
			<a class="fr top_rt_btn"
				href="${pageContext.request.contextPath }/mgr/mgrShowAllMenu.jsp">返回产品列表</a>
		</div>
	<section>
		<form action="${pageContext.request.contextPath}/menuServlet?op=deleteMenu"
			method="post">
			<ul class="ulColumn2">
				<li><span class="item_name" style="width: 120px;">菜品编号：</span>
					<input type="text" class="textbox" name="id" placeholder="菜品编号..." />
				</li>

				<li><span class="item_name" style="width: 120px;"></span> 
				<input
					type="submit" class="link_btn" value="删除" />
				</li>
			</ul>
		</form>	
</body>
</html>