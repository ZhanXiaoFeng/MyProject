<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    <title>添加信息</title>
  </head>
  <body>
  <br>
  <br>
  <br>
  <h3 align="center">新用户信息<h3>
  <hr>
    	<form  method="post" action="${pageContext.request.contextPath}/addCust.do">
    		<table align="center">
    		<tr><td>用户名:</td><td><input type="text" name="name"></td></tr><br>
    		<tr><td>年龄:</td><td><input type="text" name="age"></td></tr><br>
    		<tr><td>地址:</td><td><input type="text" name="address"></td></tr><br>
    		<tr><td align="center"><input type="submit" value="添加"></td></tr>
    		</table>
    	</form>
  </body>
</html>
