<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员首页</title>
</head>
<!-- frameset主要用来实现导航栏不变，而右侧实现变化.注意不要放到body中 -->
<frameset rows="100px,*,19px" framespacing="0" border="0" frameborder="0">
		<frame src="detail/top.html" scrolling="no" noresize /> 
		<frameset cols="178px,*">
			<frame noresize src="detail/left.html" scrolling="yes"/> 			
				<frame noresize name="right" src="detail/right.html" scrolling="yes" /> 			
		</frameset>
		<frame noresize name="status_bar" scrolling="no" src="detail/bottom.html" />
</frameset>

<body>
   
</body>
</html>