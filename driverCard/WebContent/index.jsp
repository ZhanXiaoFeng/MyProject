<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="utf-8">
<title>index</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/index.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		scan();
		//请求服务器数据
		query();
	});

	function scan() {
		var box = $(".b_view");
		$(".b_scan").css({
			"bottom" : box.height()
		}).animate({
			bottom : 0
		}, 2000, function() {
			$(this).css({
				"bottom" : box.height()
			})
		});
	};

	//请求服务器数据
	function query() {
		var path = $("#b_img").attr("src");
		$.ajax({
			type : "post",
			url : "data.jsp",
			data : {
				"src" : path
			},
			success : function(data) {
				var result = $.parseJSON(data);
				var zhenghao = result.words_result.证号.words;
				var name = result.words_result.姓名.words;
				var sex = result.words_result.性别.words;
				var country = result.words_result.国籍.words;
				var addr = result.words_result.住址.words;
				var birthday = result.words_result.出生日期.words;
				var date1 = result.words_result.初次领证日期.words;
				var driver = result.words_result.准驾车型.words;
				var date2 = result.words_result.至.words;

				$("#zhenghao").text(zhenghao);
				$("#name").text(name);
				$("#sex").text(sex);
				$("#country").text(country);
				$("#addr").text(addr);
				$("#birthday").text(birthday);
				$("#date1").text(date1);
				$("#driver").text(driver);
				$("#date2").text(date1+"至"+date2);
			}
		})
	};
</script>

</head>
<body>
	<div class="top">
		<div class="banner">
			<div class="t_desc">大数据卡顿识别</div>
			<div class="b_box">
				<div class="b_view">
					<img src="images/demo-card-1.jpg" alt="驾驶证实例" width="453"
						height="282" id="b_img" />
					<div class="b_scan"></div>
					<div id="clear"></div>
				</div>

				<div class="b_result">
					<span id="zhenghao">888814199911240066</span>
				    <span id="name">张三</span>
					<span id="sex">男</span>
					<span id="country">中国</span>
					<span id="addr">江苏省南京市江宁区</span>
					<span id="birthday">19751025</span>
					<span id="date1">20151011</span>
					<span id="driver">C1</span>
					<span id="date2">20151011至20261011</span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>