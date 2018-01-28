<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link
	href="${pageContext.request.contextPath}/static/category/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/category/css/style.css" />
<link
	href="${pageContext.request.contextPath}/static/category/assets/css/codemirror.css"
	rel="stylesheet" style="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/category/assets/css/ace.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/category/Widget/zTree/css/zTreeStyle/zTreeStyle.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/category/assets/css/font-awesome.min.css" />

<script
	src="${pageContext.request.contextPath}/static/category/assets/js/jquery.min.js"></script>
<script type="text/javascript">
			window.jQuery || document.write("<script src='${pageContext.request.contextPath}/static/category/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>
<script
	src="${pageContext.request.contextPath}/static/category/assets/js/ace-elements.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/category/assets/js/ace.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/category/assets/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/category/assets/js/typeahead-bs2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/category/Widget/zTree/js/jquery.ztree.all-3.5.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/category/js/lrtk.js"
	type="text/javascript"></script>
<title>Insert title here</title>
</head>
<body>
	<div class=" clearfix">
		<div id="category">
			<div id="scrollsidebar" class="left_Treeview">
				<div class="show_btn" id="rightArrow">
					<span></span>
				</div>
				<div class="widget-box side_content">
					<div class="side_title">
						<a title="隐藏" class="close_btn"><span></span></a>
					</div>
					<div class="side_list">
						<div class="widget-header header-color-green2">
							<h4 class="lighter smaller">产品类型列表</h4>
						</div>
						<div>
							<div
								style="font-size: 16px; margin-left: 18px; margin-right: 20px; height: 30px">
								<a href="${pageContext.request.contextPath}/insertCate.html"
									id="a1" name="a1h" target="testIframe" class="dropdown-toggle">
									<i class="icon-desktop"></i> <span class="menu-text">增加商品类类别</span>
									<b class="arrow icon-angle-down"></b>
								</a>
							</div>
							<br /> 
							<a href="${pageContext.request.contextPath}/selectAllCate.do"
								id="a2" name="a2h" target="testIframe"
								style="font-size: 16px; margin-left: 18px; margin-right: 20px; height: 30px">
								<i class="icon-desktop"></i> 
								<span class="menu-text">查询所有商品类别</span>
								<b class="arrow icon-angle-down"></b>
							</a>
						</div>
					</div>
				</div>
			</div>
			<!---->
			<iframe id="testIframe" name="testIframe" FRAMEBORDER=0
				SCROLLING=AUTO SRC="${pageContext.request.contextPath}/selectAllCate.do" class="page_right_style"></iframe>
		</div>
	</div>
</body>
</html>
<script type="text/javascript"> 
$(function() { 
	$("#category").fix({
		float : 'left',
		//minStatue : true,
		skin : 'green',	
		durationTime :false
	});
});
</script>
<script type="text/javascript">
//初始化宽度、高度  
 $(".widget-box").height($(window).height()); 
 $(".page_right_style").width($(window).width()-220);
  //当文档窗口发生改变时 触发  
    $(window).resize(function(){
	$(".widget-box").height($(window).height());
	 $(".page_right_style").width($(window).width()-220);
	})
</script>