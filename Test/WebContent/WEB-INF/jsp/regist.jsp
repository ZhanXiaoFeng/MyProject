<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/all.css" />
 <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/my.js"></script>                        
</head>
<body>
	<form action="${pageContext.request.contextPath}/customer/regist.do"
		method="post" enctype="multipart/form-data">
		${message}
		<!--头部-->
		<div class="header">
			<a class="logo" href="##" style=" background: url(${pageContext.request.contextPath}/static/images/cLogo.png) no-repeat;margin:-13px -38px;"></a>
			<div class="desc">欢迎注册</div>
		</div>
		<!--版心-->
		<div class="container">
			<!--注册模块-->
			<div class="register">
				<!--用户名-->
				<div class="register-box">
					<!--表单项-->
					<div class="box default">
						<label for="userName">用&nbsp;户&nbsp;名</label> 
						<input type="text"
							id="userName" name="username" placeholder="您的账户名和登录名" /> <i></i>
					</div>
					<!--提示信息-->
					<div class="tip">
						<i></i> <span></span>
					</div>
				</div>
				<!--设置密码-->
				<div class="register-box">
					<!--表单项-->
					<div class="box default">
						<label for="pwd">设 置 密 码</label> <input type="password" id="pwd"
							name="password1" placeholder="建议至少两种字符组合" /> <i></i>
					</div>
					<!--提示信息-->
					<div class="tip">
						<i></i> <span></span>
					</div>
				</div>
				<!--确认密码-->
				<div class="register-box">
					<!--表单项-->
					<div class="box default">
						<label for="pwd2">确 认 密 码</label> <input type="password" id="pwd2"
							name="password" placeholder="请再次输入密码" /> <i></i>
					</div>
					<!--提示信息-->
					<div class="tip">
						<i></i> <span></span>
					</div>
				</div>
				
				
				<div class="register-box">
					<!--表单项-->
					<div class="box default">
						<label for="nickname">昵&nbsp;&nbsp;称</label> <input type="text"
							id="nickname" name="nickname" placeholder="您的昵称名" /> <i></i>
					</div>
					<!--提示信息-->
					<div class="tip">
						<i></i> <span></span>
					</div>
				</div>
				
				<div class="register-box">
					<!-- 表单项 -->
					<div class="box default">
						<label for="part">上传头像</label> <input type="file" name="file" id="part"> <i></i>
					</div>
					<!--提示信息-->
					<div class="tip">
						<i></i> <span></span>
					</div>
				</div>
															
				<!--手机验证-->
				<div class="register-box">
					<!--表单项-->
					<div class="box default">
						<label for="mobile">手 机 验 证</label> <input type="number" id="mobile"
							name="phone" placeholder="请输入手机号" /> <i></i>
					</div>
					<!--提示信息-->
					<div class="tip">
						<i></i> <span></span>
					</div>
				</div>
				
				<!--设置邮箱-->
				<div class="register-box">
					<!--表单项-->
					<div class="box default">
						<label for="email">邮 箱 验 证</label> <input type="email" id="email"
							name="email" placeholder="请输入邮箱" /> <i></i>
					</div>
					<!--提示信息-->
					<div class="tip">
						<i></i> <span></span>
					</div>
				</div>				
				<input type="submit" value="注册" id="btn">
			</div>

		</div>
		<div style="text-align: center;">
			<p>
				<a href="${pageContext.request.contextPath}/customer/login.html" >登录</a>
			</p>
		</div>
	</form>
</body>
</html>