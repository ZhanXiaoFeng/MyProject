<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有的菜品</title>
<link rel="stylesheet" type="text/css" href="css/allmenu.css">
</head>
<body>

<section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
 
      <div class="page_title">
       <h2 class="fl">菜品列表</h2>
       <a href="mgr/addMenu.jsp" class="fr top_rt_btn add_icon">添加菜品</a>
      </div>
      <!-- ${pageContext.request.contextPath}获取根路径 -->
      <form action="${pageContext.request.contextPath}/menuServlet?op=mgrShowAllMenu" method = "post">
      <c:forEach items="${allMenu}" var="menu" >
      <table class="table">
       <tr>
        <th>缩列图</th>
        <th>菜品编号</th>
        <th>菜品名称</th>    
        <th>单价</th>      
       </tr>
       <tr>
        <td class="center"><img src="${menu.img }" width="50" height="50"/></td>
        <td class="center">${menu.id}</td>
        <td class="center">${menu.name}</td>
        <td class="center">${menu.price}</td>       
       </tr>    
      </table>
      </c:forEach>
     </form> 
 
 </div>
</section>
</body>
</html>