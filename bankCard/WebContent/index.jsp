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
				var results = $.parseJSON(data);
				var bank_card_number = results.result.bank_card_number;
				var bank_card_type = results.result.bank_card_type;
				switch (bank_card_type) {
				case 1:
					$("#bank_card_type").text("借记卡");
					break;
				case 2:
					$("#bank_card_type").text("信用卡");
					break;
				case 3:
					$("#bank_card_type").text("储蓄卡");
					break;
				default:
					$("#bank_card_type").text("无效卡");
					break;
				}
				var bank_name = results.result.bank_name;

				$("#bank_card_number").text(bank_card_number);
				$("#bank_name").text(bank_name);
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
					<img src="images/zhaoshang.png" alt="银行卡实例" width="453"
						height="282" id="b_img" />
					<div class="b_scan"></div>
					<div id="clear"></div>
				</div>

				<div class="b_result">
					<span id="bank_card_number">8888 8888 8888 8888</span> <span
						id="bank_name">工商银行</span> <span id="bank_card_type">信用卡</span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>