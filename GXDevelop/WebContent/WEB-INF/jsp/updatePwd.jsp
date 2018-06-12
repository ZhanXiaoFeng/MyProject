<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>会员中心</title>
<link rel="Shortcut Icon" href="favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/personal/css/jiazaitoubu.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/personal/css/css.css">
<script
	src="${pageContext.request.contextPath}/static/personal/js/jquery-1.8.3.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/personal/js/index2.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/personal/css/center.css">
<!--城市联动-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/personal/city/city.css">
<script
	src="${pageContext.request.contextPath}/static/personal/city/Popt.js"></script>
<script
	src="${pageContext.request.contextPath}/static/personal/city/cityJson.js"></script>
<script
	src="${pageContext.request.contextPath}/static/personal/city/citySet.js"></script>
</head>
<body>
	<div class="public_m1">
		<div class="public_m2">登录密码修改</div>
		<!--提示信息-->
		<div class="tip_notem">
			<ul>
				<li>1.请牢记登录密码</li>
				<li>2.如果丢失密码，可以通过绑定的手机或邮箱找到</li>
			</ul>
		</div>

		<form method="post"
			action="${pageContext.request.contextPath}/customer/updatePersonal.do">
			<input type="hidden" name="id" value="${customer.id }" /><br>
			<div class="public_m4">
				<p>
					<em>原密码：</em> <input type="text"
						style="height: 23px; border: 1px solid #eaeaea; width: 140px"
						value="${customer.password }">
				</p>
				<p>
					<em>新的密码：</em> <input type="text"
						style="height: 23px; border: 1px solid #eaeaea; width: 140px">
				</p>
				<p>
					<em>确认密码：</em> <input type="text"
						style="height: 23px; border: 1px solid #eaeaea; width: 140px"
						name="password">
				</p>
				<input type="submit" value="确认修改">
			</div>
		</form>
	</div>
</body>
</html>