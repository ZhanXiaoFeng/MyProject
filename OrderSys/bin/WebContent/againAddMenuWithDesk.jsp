<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>为指定的餐桌加餐</title>
<link href="css/waiterindex.css" rel='stylesheet' type='text/css'
	media="all" /><!-- 引入css文件 -->
<link href="css/showDeskForOrder.css" rel='stylesheet' type='text/css'
	media="all" /><!-- 引入css文件 -->
<link rel="stylesheet" type="text/css" href="css/index_1.css" /><!--引入css文件  -->
<link href="css/index.css" rel="stylesheet" type="text/css" /><!--  引入css文件-->
</head>
<body>
	<div class="header-section">
		<div class="container">
			<div class="header-top">
				<div class="header-logo">
					<a href="index.html"><img src="img/windex/logo.png" alt="" /></a><!-- 插入返回首页的图片 -->
				</div>
			</div>
		</div>
		<br> <br> <br> <br> <br> <br> <br>
		<hr width=100% size=3 color=#000000
			style="filter: progid:DXImageTransform.Microsoft.Shadow(color:#f6ae56, direction:145, strength:15)">
		<!-- 使center中的内容居中 -->	
		<center>
			<div class="test_demo">
				<h1>
					<div class="aa">
					${waiter.id}号服务员为${haveSelectedDeskId }号餐桌加菜
					</div>
				</h1>
				<br> <br>
				<form action="orderServlet?op=againAddMenuWithDesk" method="post">
				<!-- 以下范围内的内容会提交到orderservlet文件的post方法中的case：againaddmenuwithdesk中去 -->
					<input type="hidden" name="menuLength" value="${menuLength }"><!-- 隐藏项 菜品种类的个数 -->
					<input type="hidden" name="waiterid" value="${waiter.id}"><!-- 隐藏项 当前登录的服务员的id -->
					<input type="hidden" name="haveSelectedDeskId"
						value="${haveSelectedDeskId }"><!-- 隐藏项 上一级传来的餐桌的id -->
					<!-- 显示菜品的div -->
					<div id="top" align="center">
						<c:forEach items="${allMenu }" var="menu" varStatus="status">
							<ul>
								<!-- 循环列出餐品 -->

								<li>
									<dl>
										<dt>
											<a href="#"> <img width="214px" height="145px"
												src="${menu.img }" /><!--菜品的样图  -->
											</a>
										</dt>
										<dd class="f1" text-align:center>
											<a href="#">${menu.name}</a><!-- 菜品的名字 -->
										</dd>
										<dd class="f2">
											<label>&yen;${menu.price}</label><!--菜品的价格  -->
											
												<input type="checkbox" style="height: 20px; width: 20px;"
													value="${menu.id}" name="cb${status.count}"><!--选择按钮的值为菜品的id  -->
											
										</dd>
									</dl>
								</li>

								<li>
									<dl>
									</dl>
								</li>
							</ul>
						</c:forEach>
					<input type="submit"
						style="weight: 150px; height: 40px; color: black; background: white"
						value="加菜"><!-- 提交 -->
				</form>
			</div>
		</center>
	</div>
</body>
</html>