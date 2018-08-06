<%@ page language="java" import="java.util.*" pageEncoding="Utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@page import="org.apache.hadoop.fs.FileStatus"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<script type="text/javascript" src="scripts/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		$(".delete").click(function(){
			var content = $(this).parent().parent().find("td:eq(1)").text();
			var flag= confirm("确定要删除"+ content +"的信息吗")
			return flag;
		});
	});
</script>
<title>SkyDrive</title>
</head>

<body>
	 <table style="width:1000px;margin-left:100px;">
	      		<tr style=" border-bottom:2px solid #ddd">
	      			<td >文件名</td><td style="width:100px">类型</td><td style="width:100px;">大小</td><td style="width:100px;">操作</td><td style="width:100px;">操作</td>
	      		</tr>
	      		<%
			FileStatus[] list = (FileStatus[])request.getAttribute("list");
			if(list != null)
			for (int i=0; i<list.length; i++) {
				%>
					<tr >
					<%
						if(list[i].isDirectory())
						{
							out.print("<td> <a href=\"documentServlet?filePath="+list[i].getPath()+"\">"+list[i].getPath().getName()+"</a></td>");
						}else{
							out.print("<td>"+list[i].getPath().getName()+"</td>");
						}
					%>
 						<td><%= (list[i].isDirectory()?"目录":"文件") %></td>
						<td><%= list[i].getLen()/1024%></td>
						<td><a href="deleteFileServlet?filePath=<%=java.net.URLEncoder.encode(list[i].getPath().toString(),"utf-8") %>" class = "delete">删除</a></td>
						<td><a href="downloadServlet?filePath=<%=java.net.URLEncoder.encode(list[i].getPath().toString(),"utf-8") %>" >下载</a></td>
			 		
			 		</tr >
				
			<%
			}
			%>
	      	</table><br>
	<a href="upload.jsp">上传文件</a>
	<a href="logoutServlet">退出</a>
</body>
</html>
