<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>shop</title>
<link rel="stylesheet" href="css/main.css" type="text/css" />
<script type="text/javascript">
	//当点击+或-号时，会向服务器发送请求，并通知服务器修改哪个商品及数量是多少
	function changeCount(id, count, totalCount) {
		//将字符串转换成数字
		count = parseInt(count);
		totalCount = parseInt(totalCount);
		//确认删除功能
		if (count <= 0) {
			var flag = window.confirm("确认删除吗");
			if (!flag) { //取消时，直接让程序结束
				document.getElementById(id).value = 1;
				count = 1;
			} else {
				count = 0;
			}
		}
		//控制购买数量不能大于库存
		if (count > totalCount) {
			alert("最大购买数量为" + totalCount);
			document.getElementById(id).value = totalCount;
			count = totalCount;
			//return;
		}

		location.href = "${pageContext.request.contextPath}/changeCartCount?id="
				+ id + "&count=" + count;
	}
</script>


</head>

<body class="main">

	<div id="divpagecontent">
		<table width="100%" border="0" cellspacing="0">
			<tr>

				<td><div style="text-align: right; margin: 5px 10px 5px 0px">
						<a href="index.html">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&gt;&nbsp;&nbsp;&nbsp;&nbsp;购物车
					</div>

					<table cellspacing="0" class="infocontent">
						<tr>
							<td><img src="ad/page_ad.jpg" width="666" height="89" />
								<table width="100%" border="0" cellspacing="0">
									<tr>
										<td><img src="images/buy1.gif" width="635" height="38" />
										</td>
									</tr>
									<tr>
										<td>
											<table cellspacing="1" class="carttable">
												<tr>
													<td width="25%">序号</td>
													<td width="15%">商品名称</td>
													<td width="10%">价格</td>
													<td width="20%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数量</td>
													<td width="10%">库存</td>
													<td width="10%">小计</td>
													<td width="10%">取消</td>
												</tr>
											</table> <c:forEach items="${cart}" var="entry">
												<table width="100%" border="0" cellspacing="0">
													<tr>
														<td width="25%">${entry.key.id}</td>
														<td width="15%">${entry.key.name}</td>

														<td width="10%">${entry.key.price }</td>
														<td width="20%"><input type="button" value='-'
															style="width: 20px"
															onclick="changeCount('${entry.key.id}','${entry.value-1}','${entry.key.count}')">

															<input name="text" type="text" value="${entry.value}"
															id="${entry.key.id}"
															style="width: 40px; text-align: center"
															onblur="changeCount('${entry.key.id}',this.value,'${entry.key.count}')" />

															<input type="button" value='+' style="width: 20px"
															onclick="changeCount('${entry.key.id}','${entry.value+1}','${entry.key.count}')">

														</td>
														<td width="10%">${entry.key.count }</td>
														<td width="10%">${entry.key.price*entry.value}</td>

														<td width="10%"><a href="javascript:void(0);"
															style="color: #FF0000; font-weight: bold"
															onclick="changeCount('${entry.key.id}','0','${entry.key.count}')">X</a>

														</td>
													</tr>
												</table>
											</c:forEach>


											<table cellspacing="1" class="carttable">
												<tr>
													<td style="text-align: right; padding-right: 40px;"><font
														style="color: #FF6600; font-weight: bold">合计：&nbsp;&nbsp;元</font>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table></td>
						</tr>
					</table></td>
			</tr>
		</table>
	</div>



	<%-- 	<jsp:include page="foot.jsp" /> --%>


</body>
</html>