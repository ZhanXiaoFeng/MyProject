<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>结账结果</title>
<link href="css/waiterindex.css" rel='stylesheet' type='text/css'
	media="all" />
<link href="css/showDeskForOrder.css" rel='stylesheet' type='text/css'
	media="all" />
</head>
<body>
	<div class="header-section"><!-- 插入背景图-->
		<div class="div-inline">
			<center>
				<table>
					<tr>
						<td>
							<div class="container">
								<div class="header-top">
									<div class="header-logo">
										<a href="index.html"><img src="img/windex/logo.png" alt="" /></a>
									</div><!-- 插入返回首页的图片-->
								</div>
							</div>
						</td>
					</tr>
				</table>
			</center>
		</div>
		<br> <br> <br> <br>
		<hr width=100% size=3 color=#000000
			style="filter: progid:DXImageTransform.Microsoft.Shadow(color:#f6ae56, direction:145, strength:15)">
		<center>
			<div class="aa">餐桌 ${haveSelectedDeskId}总账：${haveSelectedDeskTotalPrice}元请确认结账</div>
			<br> <br> <br>
			<form action="deskServlet?op=payMoney" method="post"><!--以下内容将提交到deskservlet的post放大的case：paymoney里 -->
				<input type="hidden" value="${haveSelectedDeskId }"
					name="haveSelectedDeskId"><!--隐藏项 上一级传来的餐桌号 -->

                    <!--显示账单里的菜单表格 -->
					<table id="table-3" width="800px" height="100px" border="1">
						<tr>
							<th>菜品编号</th>
							<th>菜品名称</th>
							<th>单价</th>
							<th>菜品样图</th>
						</tr>
					<c:forEach items="${menuList}" var="menu">
						<tr>
							<td class="center" width="200" align="center">${menu.id}</td>
							<td class="center" width="200" align="center">${menu.name}</td>
							<td class="center" width="200" align="center">${menu.price}</td>
							<td class="center"><img src="${menu.img }" width="200"
								height="100" align="center" /></td>
						</tr>
					</c:forEach>
					</table>
				
				<input type="submit"
					style="weight: 150px; height: 40px; color: black; background: white"
					value="确认结账">
			</form>
		</center>
	</div>
	<hr width=100% size=3 color=#000000
		style="filter: progid:DXImageTransform.Microsoft.Shadow(color:#f6ae56, direction:145, strength:15)">
</body>
</html>
