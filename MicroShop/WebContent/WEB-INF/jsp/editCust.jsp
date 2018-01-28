<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>修改信息</title>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/personal/css/jiazaitoubu.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/personal/css/css.css">
<script src="js/jquery-1.8.3.min.js"></script>
<script src="js/index2.js"></script>
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


<script src="${pageContext.request.contextPath}/static/personal/js/jquery.min.js"></script>

<link href="${pageContext.request.contextPath}/static/personal/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/personal/cropper/cropper.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/personal/sitelogo/sitelogo.css" rel="stylesheet">

<script src="${pageContext.request.contextPath}/static/personal/cropper/cropper.min.js"></script>
<script src="${pageContext.request.contextPath}/static/personal/sitelogo/sitelogo.js"></script>
<script src="${pageContext.request.contextPath}/static/personal/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<br>


	<!--一条开始-->

	<div class="public_m1">
		<div class="public_m2">资料管理</div>
		<form method="post"
			action="${pageContext.request.contextPath}/customer/updatePersonal.do">
			<input type="hidden" name="id" value="${personalInfo.id}" /><br>
			<!--照片和内容-->
			<div class="zp_nrm">

				<!--right-->
				<div class="zp_nrm_r">
					<p>
						<em>用户名：</em><i><input type="text" name="username"
							value="${personalInfo.username}" /></i>
					</p>
					<p>
						<em>昵称</em><i><input type="text" name="nickname"
							value="${personalInfo.nickname}" /></i>
					</p>
					<p>
						<em>邮箱：</em><i><input type="email" name="email"
							value="${personalInfo.email}" /></i>
					</p>
					<p>
						<em>手机号：</em><i><input type="number" name="phone"
							value="${personalInfo.phone}" /></i><a href="#">立即绑定</a>
					</p>
					<input type="submit" value="确认修改">
					</td>
				</div>
			</div>
		</form>
	</div>
	<!--一条开始-->

</body>
</html>