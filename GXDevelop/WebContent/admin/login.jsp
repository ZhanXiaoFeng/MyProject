<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="Shortcut Icon" href="favicon.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/admin/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/assets/css/ace.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/style.css" />
<script src="${pageContext.request.contextPath}/admin/assets/js/ace-extra.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/jquery-1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/assets/layer/layer.js" type="text/javascript"></script>
<title>管理员登录</title>
<script type="text/javascript">
	function checkForm() {
		if (form1.username.value == null || form1.username.value == "") {
			layer.alert("请输入用户名!\r\n", {
				title : '提示框',
				icon : 0,
			});
			form1.username.focus();
			return false;
		}

		if (form1.password.value == null || form1.password.value == "") {
			layer.alert("请输入用户密码！\r\n", {
				title : '提示框',
				icon : 0,
			});
			form1.password.focus();
			return false;
		}
		return true;
	}
</script>

</head>

<body class="login-layout Reg_log_style">
	<div class="logintop">
		<span>欢迎后台管理界面平台</span>
		<ul>
			<li><a href="#">返回首页</a></li>
			<li><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
		</ul>
	</div>
	<div class="loginbody">
		<div class="login-container">
			<div class="center">
				<img src="${pageContext.request.contextPath}/admin/images/logo.png" />
			</div>

			<div class="space-6"></div>

			<div class="position-relative">
				<div id="login-box" class="login-box widget-box no-border visible">
					<div class="widget-body">
						<div class="widget-main">
							<h4 class="header blue lighter bigger">
								<i class="icon-coffee green"></i> 管理员登陆
							</h4>

							<div class="login_icon">
								<img src="${pageContext.request.contextPath}/admin/images/login.png" />
							</div>

							<form action="${pageContext.request.contextPath}/login.do" method="post" name="form1"
								onsubmit="return checkForm();">
								<fieldset>
									<ul>
										<li class="frame_style form_error"><label
											class="user_icon"></label><input type="text" name="username"
											id="username" value="admin" placeholder="用户名" /></li>
										<li class="frame_style form_error"><label
											class="password_icon"></label><input name="password"
											type="password" id="password" value="admin" placeholder="密码" /></li>
										<!-- <li class="frame_style form_error"><label
											class="Codes_icon"></label><input name="验证码" type="text"
											id="Codes_text" /><i>验证码</i>
											<div class="Codes_region"></div></li> -->

									</ul>
									<div class="space"></div>

									<div class="clearfix">
										<label class="inline"> <input type="checkbox"
											class="ace"> <span class="lbl">保存密码</span></label>

										<!-- <button type="button"
											class="width-35 pull-right btn btn-sm btn-primary"
											id="login_btn">
											<i class="icon-key"></i> 登陆
										</button> -->

										<div class="width-35 pull-right btn btn-sm btn-primary">
											<i class="icon-key"><input type="submit" value="submit"
												style="border: 0; background: #428BCA"></i>
										</div>
									</div>
									<div class="space-4"></div>
								</fieldset>
							</form>

							<div class="social-or-login center">
								<span class="bigger-110">通知</span>
							</div>

							<div class="social-login center">本网站系统不再对IE8以下浏览器支持，请见谅。</div>
						</div>
						<!-- /widget-main -->

						<div class="toolbar clearfix"></div>
					</div>
					<!-- /widget-body -->
				</div>
				<!-- /login-box -->
			</div>
			<!-- /position-relative -->
		</div>
	</div>
	<div class="loginbm">
		<strong>版权所有 盗版必究Copyright@2018</strong>
	</div>
</body>
</html>