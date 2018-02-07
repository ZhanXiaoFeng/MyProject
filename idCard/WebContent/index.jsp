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
			data : {"src" : path},
			success : function(data) {
				var result = $.parseJSON(data);
				var name = result.words_result.姓名.words;
				var sex = result.words_result.性别.words;
				var nation = result.words_result.民族.words;
				var birthday = result.words_result.出生.words;
				var year = birthday.substring(0,4);
				var month = birthday.substring(4,6);
				var day = birthday.substring(6,8);
				var addr = result.words_result.住址.words;
				var num = result.words_result.公民身份号码.words;
				
				$("#name").text(name);
				$("#sex").text(sex);
				$("#nation").text(nation);
				$("#year").text(year);
				$("#month").text(month);
				$("#day").text(day);
				$("#addr").text(addr);
				$("#num").text(num); 
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
					<img src="images/1.png" alt="身份证实例" width="453" height="282"
						id="b_img" />
					<div class="b_scan"></div>
					<div id="clear"></div>
				</div>

				<div class="b_result">
					<span id="name">天在</span> <span id="sex">女</span> <span id="nation">汉</span>
					<span id="year">1999</span> <span id="month">12</span> <span
						id="day">18</span> <span id="addr">北京市海淀区100号中关村科技园</span> <span
						id="num">157894561234</span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>