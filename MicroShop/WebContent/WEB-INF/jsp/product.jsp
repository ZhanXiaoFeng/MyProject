<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<title>网上商城</title>
	<%-- <link href="${pageContext.request.contextPath }/css/common.css"
		rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath }/css/product.css"
			rel="stylesheet" type="text/css"> --%>
			<script type="text/javascript"
				src="<c:url value='${pageContext.request.contextPath }/js/jquery-1.8.3.js'/>"></script>

			<script type="text/javascript">
				function saveCart() {
					document.getElementById("addForm").submit();
				}

				$(function() {
					//增加数量
					$(".increase").click(function() {
						//获得数量
						var val = Number($("#quantity").val());
						//数量加1
						val = val + 1;
						$("#quantity").val(val);
					});
					//减少数量
					$(".decrease").click(function() {
						//获得数量
						var val = Number($("#quantity").val());
						//数量加1
						val = val - 1;
						if (val >= 1) {
							$("#quantity").val(val);
						}
					});

				});
			</script>
</head>
<body>
	
	<div class="container productContent">

		<div class="span18 last">

			<div class="productImage">
				<a title="" style="outline-style: none; text-decoration: none;"
					id="zoom"
					href="http://image/r___________renleipic_01/bigPic1ea8f1c9-8b8e-4262-8ca9-690912434692.jpg"
					rel="gallery">
					<div class="zoomPad">
						<img style="opacity: 1;" title="" class="medium"
							src="${pageContext.request.contextPath }/${goods.imgs }">
						
					</div>
				</a>

			</div>
			<div class="name">
				<div>${goods.name }</div>
			</div>
			<div class="sn">
				<div>编号：${goods.id }</div>
			</div>
			<div class="info">
				<dl>
					<dt>商城价:</dt>
					<dd>
						<strong>￥：${goods.price2 }元/份</strong> 
						参 考 价：
						<del>￥${goods.price1 }元/份</del>
					</dd>
				</dl>							
			</div>
			<form
				action="${pageContext.request.contextPath }/cart/addCart.do"
				id="addForm" method="post">
				<input type="hidden" name="gid" value="${goods.id }" />
				<div class="action">
					<dl class="quantity">
						<dt>购买数量:</dt>
						<dd>
							<input id="quantity" name="count" value="1" maxlength="4"
								onpaste="return false;" type="text">
								<div>
									<span id="increase" class="increase">&nbsp;</span> <span
										id="decrease" class="decrease">&nbsp;</span>
								</div>
						</dd>
						<dd>件</dd>
					</dl>
					<div class="buy">
						<input id="addCart" class="addCart" value="加入购物车" type="button"
							onclick="saveCart()">
					</div>
				</div>
			</form>
			
			
			<%-- <div id="bar" class="bar">
				<ul>
					<li id="introductionTab"><a href="#introduction">商品介绍</a></li>

				</ul>
			</div>

			<div id="introduction" name="introduction" class="introduction">
				<div class="title">
					<strong>${goods.intro }</strong>
				</div>
				<div>
					<img src="${pageContext.request.contextPath }/${goods.imgs }" />
				</div>
			</div>
 --%>


		</div>
	</div>
	
</body>
</html>