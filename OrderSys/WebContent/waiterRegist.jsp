<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>服务员注册</title>
<link href="css/regist.css?v=2" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>

<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
         <!-- $("#tiJiao").attr('disabled', "true"); 代表 密码不一致 不能点击提交按钮 -->
		$("#password2").blur(function() {
			var v1 = $("#password1").val();
			var v2 = $("#password2").val();
			if (v1 != v2) {
				alert("密码和确认密码不一致，请重新输入");
				$("#tiJiao").attr('disabled', "true");
			} 
			if(v1==""){
				alert("密码不能为空，请重新输入");
				$("#tiJiao").attr('disabled', "true");
			}
			if(v2==""){
				alert("密码不能为空，请重新输入");
				$("#tiJiao").attr('disabled', "true");
			}
			else {
				$('#tiJiao').removeAttr("disabled");
			}
		});
	});
	
</script>

<style>
body {
	background: url(img/mgrloginbg.jpg);
	background-repeat: no-repeat;
	background-attachment: fixed; "
	margin-top: 100px;
	background-position: center center;
}
</style>
</head>
<body>

	<div class="wrap">
		<div class="container">
			<form action="waiterServlet?op=regist" method="post">
				<div class="register-box">
					<div class="reg-slogan">服务员注册</div>
					<div class="reg-form" id="js-form-mobile">
						<br>
						
						<div class="cell">
							<label for="js-mobile_ipt"></label> <input type="text"
								name="waiterId" id="waiterId" placeholder="用户编号"
								class="text" maxlength="11" />
						</div>
						
						<div class="cell">
							<label for="js-mobile_ipt"></label> <input type="text"
								name="waiterName" id="waiterName" placeholder="用户名"
								class="text" maxlength="11" />
						</div>
						<div class="cell">
							<label for="js-mobile_pwd_ipt"></label> 
							<input type="password"
								name="password1" id="password1" placeholder="密码"
								class="text" />
						</div>
						<div class="cell">
							<label for="js-mobile_pwd_ipt"></label> <input type="password"
								name="password2" id="password2" placeholder="确认密码"
								class="text" />
						</div>
						<div class="bottom">
						<input type="submit" value="注册" id="tiJiao"
							class="button btn-green"></div>
						<!-- <div class="bottom"> <a id="js-mail_btn" href="javascript:;" class="button btn-green"> 立即注册</a></div>
		  用户名：<input type="text" name="waiterName"><br> 
		密码：<input type="password" name="password1" id="password1"><br>
		确认密码：<input type="password" name="password2" id="password2"><br>
		性别：<input type="radio" name="gender" value="male"> 男
			<input type="radio" name="gender" value="female">女<br>			
			<input type="submit" value="注册" id="tiJiao">-->


					</div>
				</div>
			</form>
		</div>
	</div>

</body>
</html>