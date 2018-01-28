<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link
	href="${pageContext.request.contextPath}/admin/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/css/style.css" />
<link
	href="${pageContext.request.contextPath}/admin/assets/css/codemirror.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/assets/css/ace.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/assets/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/assets/css/font-awesome-ie7.min.css" />
<script
	src="${pageContext.request.contextPath}/admin/assets/js/jquery.min.js"></script>

<script type="text/javascript">
	window.jQuery
			|| document
					.write("<script src='${pageContext.request.contextPath}/admin/assets/js/jquery-2.0.3.min.js'>"
							+ "<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

<script type="text/javascript">
	if ("ontouchend" in document)
		document
				.write("<script src='${pageContext.request.contextPath}/admin/assets/js/jquery.mobile.custom.min.js'>"
						+ "<"+"/script>");
</script>
<script
	src="${pageContext.request.contextPath}/admin/assets/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/admin/assets/js/typeahead-bs2.min.js"></script>
<!-- page specific plugin scripts -->
<script
	src="${pageContext.request.contextPath}/admin/assets/js/jquery.dataTables.min.js"></script>
<script
	src="${pageContext.request.contextPath}/admin/assets/js/jquery.dataTables.bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/admin/js/H-ui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/admin/js/H-ui.admin.js"></script>
<script
	src="${pageContext.request.contextPath}/admin/assets/layer/layer.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath}/admin/assets/laydate/laydate.js"
	type="text/javascript"></script>
<title>用户列表</title>
</head>

<body>
	<div class="page-content clearfix">
		${message}
		<!--添加修改用户图层-->
		<div class="add_menber" id="add_menber_style">
			<form method="post"
				action="${pageContext.request.contextPath}/customer/edit.do"
				onSubmit="return edit()">
				<input type="hidden" name="id" value="${customerInfo.id}" />

				<ul class=" page-content">
					<li><label class="label_name">用&nbsp;&nbsp;户 &nbsp;名：</label><span
						class="add_name"><input type="text" class="text_add"
							name="username" value="${customerInfo.username}" /></span>
						<div class="prompt r_f"></div></li>
					<li><label class="label_name">昵称：</label><span
						class="add_name"><input type="text" class="text_add"
							name="nickname" value="${customerInfo.nickname}" /></span>
						<div class="prompt r_f"></div></li>

					<li><label class="label_name">移动电话：</label><span
						class="add_name"><input type="text" class="text_add"
							name="phone" value="${customerInfo.phone}" /></span>
						<div class="prompt r_f"></div></li>
					<li><label class="label_name">电子邮箱：</label><span
						class="add_name"><input type="email" class="text_add"
							name="email" value="${customerInfo.email}" /></span>
						<div class="prompt r_f"></div></li>
					<!-- <li class="adderss"><label class="label_name">家庭住址：</label><span
					class="add_name"><input name="家庭住址" type="text"
						class="text_add" style="width: 350px" /></span>
				<div class="prompt r_f"></div></li> -->
					<li><label class="label_name">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</label><span
						class="add_name"> <label><input
								name="form-field-radio1" type="radio" checked="checked"
								class="ace"><span class="lbl">开启</span></label>&nbsp;&nbsp;&nbsp;
							<label><input name="form-field-radio1" type="radio"
								class="ace"><span class="lbl">关闭</span></label></span>
						<div class="prompt r_f">
							<input type="submit" value="确认修改">
						</div></li>
				</ul>
			</form>
		</div>
</body>
</html>
<script>
	jQuery(function($) {
		var oTable1 = $('#sample-table').dataTable({
			"aaSorting" : [ [ 1, "desc" ] ],//默认第几个排序
			"bStateSave" : true,//状态保存
			"aoColumnDefs" : [
			//{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			{
				"orderable" : false,
				"aTargets" : [ 0, 8, 9 ]
			} // 制定列不参与排序
			]
		});

		$('table th input:checkbox').on(
				'click',
				function() {
					var that = this;
					$(this).closest('table').find(
							'tr > td:first-child input:checkbox').each(
							function() {
								this.checked = that.checked;
								$(this).closest('tr').toggleClass('selected');
							});

				});

		$('[data-rel="tooltip"]').tooltip({
			placement : tooltip_placement
		});
		function tooltip_placement(context, source) {
			var $source = $(source);
			var $parent = $source.closest('table')
			var off1 = $parent.offset();
			var w1 = $parent.width();

			var off2 = $source.offset();
			var w2 = $source.width();

			if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2))
				return 'right';
			return 'left';
		}
	})

	/*用户-编辑*/
	function edit() {

		if (confirm("您确认提交吗？")) {

			return true;

		};
		
		return false;

	}
	function member_edit(id) {
		layer.open({
			type : 1,
			title : '修改用户信息',
			maxmin : true,
			shadeClose : false, //点击遮罩关闭层
			area : [ '800px', '' ],
			content : $('#add_menber_style'),

			yes : function(index, layero) {
				var num = 0;
				var str = "";
				$(".add_menber input[type$='text']").each(
						function(n) {
							if ($(this).val() == "") {

								layer.alert(str += "" + $(this).attr("name")
										+ "不能为空！\r\n", {
									title : '提示框',
									icon : 0,
								});
								num++;
								return false;
							}
						});
				if (num > 0) {
					return false;
				} else {
					layer.alert('添加成功！', {
						title : '提示框',
						icon : 1,
					});
					layer.close(cusomer_list);
				}
			}
		});
	}

	//面包屑返回值
	var index = parent.layer.getFrameIndex(window.name);
	parent.layer.iframeAuto(index);
	$('.Order_form').on('click', function() {
		var cname = $(this).attr("title");
		var chref = $(this).attr("href");
		var cnames = parent.$('.Current_page').html();
		var herf = parent.$("#iframe").attr("src");
		parent.$('#parentIframe').html(cname);
		parent.$('#iframe').attr("src", chref).ready();
		;
		parent.$('#parentIframe').css("display", "inline-block");
		parent.$('.Current_page').attr({
			"name" : herf,
			"href" : "javascript:void(0)"
		}).css({
			"color" : "#4c8fbd",
			"cursor" : "pointer"
		});
		//parent.$('.Current_page').html("<a href='javascript:void(0)' name="+herf+" class='iframeurl'>" + cnames + "</a>");
		parent.layer.close(index);

	});
</script>