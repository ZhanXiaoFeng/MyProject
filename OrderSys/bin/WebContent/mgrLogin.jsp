<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录</title>
<link href="css/login.css" rel="stylesheet" rev="stylesheet"
	type="text/css" media="all" />
<link href="css/demo.css" rel="stylesheet" rev="stylesheet"
	type="text/css" media="all" />
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
<script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
<script type="text/javascript" src="js/Validform_v5.3.2_min.js"></script>

<script>
	$(function() {

		$(".i-text").focus(function() {
			$(this).addClass('h-light');
		});

		$(".i-text").focusout(function() {
			$(this).removeClass('h-light');
		});

		$("#mgrname").focus(function() {
			var mgrname = $(this).val();
			if (mgrname == 'MgrName') {
				$(this).val('');
			}
		});

		$("#mgrname").focusout(function() {
			var mgrname = $(this).val();
			if (mgrname == '') {
				$(this).val('输入账号');
			}
		});

		$("#password").focus(function() {
			var password = $(this).val();
			if (password == 'MgrPwd') {
				$(this).val('');
			}
		});

		$("#password").focusout(function() {
			var password = $(this).val();
			if (password == '') {
				$(this).val('输入密码');
			}
		});
	});
</script>
<script type="text/javascript">
	jQuery(".banner").slide({
		titCell : ".hd ul",
		mainCell : ".bd ul",
		effect : "fold",
		autoPlay : true,
		autoPage : true,
		trigger : "click"
	});
</script>

</head>
<body>

	<div class="header"><!--引入背景图 -->
		<h1 class="headerLogo"><!--插入标志图片 -->
			<a title="后台管理系统" target="_blank" ><img
				alt="logo" src="img/logo1.png"></a>
		</h1>
		<div class="headerNav"><!--其他相关链接 -->
			<a target="_blank" >Order官网</a> <a
				target="_blank">关于我们</a> <a target="_blank"
				>开发团队</a> <a target="_blank"
				>意见反馈</a> <a target="_blank"
				>帮助</a>
		</div>
	</div>
	<div class="banner">

		<div class="login-aside">
			<div id="o-box-up"></div>
			<div id="o-box-down" style="table-layout: fixed;">
				<div class="error-box"></div>
				<form class="registerform" action="mgrServlet?op=login"
					method="post">
					<div class="fm-item"
					>
						<label for="logonId" class="form-label">ORDER系统登陆：</label> <input
							type="text" value="admin" maxlength="100" id="mgrname"
							class="i-text" name="mgrName">
						<div class="ui-form-explain"></div>
					</div>

					<div class="fm-item">
						<label for="logonId" class="form-label">密码：</label> <input
							type="password" value="1234" maxlength="100" id="password"
							class="i-text" datatype="*6-16" name="mgrPwd">
						<div class="ui-form-explain"></div>
					</div>

					<div class="fm-item">
						<label for="logonId" class="form-label"></label> <input
							type="submit" value="管理员登录" tabindex="4" id="send-btn"
							class="btn-login">
						<div class="ui-form-explain"></div>
					</div>

				</form>

			</div>

		</div>

		<div class="bd">
			<ul>
				<li
					style="background: url(img/mgrloginbg.jpg) #CCE1F3 center 0 no-repeat;">
					<a target="_blank"></a>
				</li>

			</ul>
		</div>
	 <div class="hd"></div>
	</div>
	<div class="banner-shadow"></div>

	<div class="footer">
		<p>
			Copyright &copy; 2017.Company OrderSys All rights reserved.<br>
			<a target="_blank" href="#">版权所有，严禁盗版</a>
		</p>
	</div>
	<div style="display: none;">
		<script src='' language='JavaScript' charset='GB2312'></script>
	</div>
</body>
</html>