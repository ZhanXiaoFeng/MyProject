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
				var number = result.words_result.号牌号码.words;
				var type = result.words_result.车辆类型.words;
				var name = result.words_result.所有人.words;
				var addr = result.words_result.住址.words;
				var useing = result.words_result.使用性质.words;
				var usetype = result.words_result.品牌型号.words;
				var number1 = result.words_result.车辆识别代号.words;
				var number2 = result.words_result.发动机号码.words;
				var date1 = result.words_result.注册日期.words;
				var date2 = result.words_result.发证日期.words;

				$("#number").text(number);
				$("#type").text(type);
				$("#name").text(name);
				$("#addr").text(addr);
				$("#useing").text(useing);
				$("#usetype").text(usetype);
				$("#number1").text(number1);
				$("#number2").text(number2);
				$("#date1").text(date1);
				$("#date2").text(date2);
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
					<img src="images/demo-card-2.jpg" alt="行驶证实例" width="453"
						height="282" id="b_img" />
					<div class="b_scan"></div>
					<div id="clear"></div>
				</div>

				<div class="b_result">
					<span id="number">云G15245</span> <span id="type">重型半挂牵引车</span> <span
						id="name">沈阳沈沈运输有限公司</span> <span id="addr">沈阳市经济技术开发区沈新新路257号</span>
					<span id="useing">货运</span> <span id="usetype">东风牌DFL4251A00</span>
					<span id="number1">LGAG8DY88C88C8888</span> <span id="number2">C6666666</span>
					<span id="date1">20151011</span> <span id="date2">20151015</span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>