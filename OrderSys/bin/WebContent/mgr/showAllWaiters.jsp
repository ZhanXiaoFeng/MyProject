<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示所有服务员</title>
<link rel="stylesheet" type="text/css" href="css/allmenu.css">
</head>

<body>
<section class="rt_wrap content mCustomScrollbar">
 <div class="rt_content">
      <div class="page_title">
       <h2 class="fl">服务员列表</h2>.   
 	  </div>
     <form action="${pageContext.request.contextPath}/waiterServlet?op=showAllWaiters" method = "post">   
      <table class="table">
       <tr>
        <th>服务员编号</th>
        <th>服务员姓名</th>
        <th>服务员密码</th>             
       </tr>
        <!--c:forEach 将所有服务员循环列出  -->
       <c:forEach items="${allWaiters}" var="waiter" >
       <tr>
        <td class="center">${waiter.id}</td>
        <td class="center">${waiter.name}</td>
        <td class="center">${waiter.pwd}</td>           
       </tr>  
        </c:forEach>  
      </table>
     </form> 
 </div>
 
</section>
</body>
</html>