<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%  String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>服务员登录</title>
<link rel="shortcut icon" href="img/favicon.ico">
<link rel="stylesheet" type="text/css" href="css/wloginstyle.css" />
<script src="js/modernizr.custom.63321.js"></script>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function(){//AJAX
		$("#code").blur(function(){
			var v = $("#code").val();
			$.post("waiterServlet",{op:"yanZheng",code:v},function(data){    
				if(data!="ok")//验证码输入不正确
					alert("验证码不正确，请重新输入");
			});
		});
	});
</script>
<style>
body {
	
	background-color:#fff8Dc;
	background-repeat:no-repeat;
	background-position:center;
	padding-top: 100px;
	
}
</style>

</head>
<body>

	<form class="form-2" action="waiterServlet?op=login" method="post"><!--以下内容提交到waiterservlet的post方法的case：login中 -->
		<center class="aa"><h1>欢迎进入点餐系统</h1></center> 
			
		用戶名:<input type="text" name="waiterName"><br>
			
		密码:<input type="password" name="waiterPwd"><br>
		
		验证码:<img src="codeServlet"/>
		<input type="text" name="code" id="code"/><br>
		<input type ="submit" name="submit" value="换张验证码">	
		<input type="submit" name="submit" value="&nbsp;&nbsp;服务员登录" ><br>	<br>				
		</form>
	
</body>
</html>