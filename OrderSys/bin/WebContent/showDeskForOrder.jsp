<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示订单的餐桌号</title>
<link href="css/waiterindex.css" rel='stylesheet' type='text/css'
	media="all" />
<link href="css/showDeskForOrder.css" rel='stylesheet' type='text/css'
	media="all" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" charset="UTF-8">
	$(function() {
		$("#sjs").change(function() {
			var v = $("#sjs").val();//获取当前所选择的餐桌的ID
			location.href = "orderServlet?op=showOrder&deskId=" + v;
		});
	});
</script>
</head>
<body>

	<div class="header-section"><!--插入背景图 -->
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
		<br>
		<br>
		<br>
		<br>
		<div class="bb">
			<div class="aa"><!-- 设置文字大小-->
				&nbsp;&nbsp;请选择要查看订单的餐桌号：
				<div class="choseLanguage">
					<div class="se">
						<select id="sjs" class="selectLanguage"
							style="width: 500px; height: 60px; font-size: 40px;">
							<option value=" "></option>
							<c:forEach items="${allHaveSelectedDesk}" var="haveSelectedDesk">
								<option class="optionLangeuage" style="font-size: 40px;"
									value="${haveSelectedDesk.id }">${haveSelectedDesk.id }号餐桌</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
		</div>


		<div class="content ver_hor_center">
			<center>
				<p>
					Copyright &copy; 2017. OrderSys company All rights reserved. <a
						href="index.html" title="首页" target="_blank">首页</a>
				</p>
			</center>
		</div>
	</div>
</body>
</html>