<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Shortcut Icon" href="favicon.ico" />
<link
	href="${pageContext.request.contextPath}/static/category/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/category/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/category/assets/css/ace.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/category/assets/css/font-awesome.min.css" />
<link
	href="${pageContext.request.contextPath}/static/category/Widget/icheck/icheck.css"
	rel="stylesheet" type="text/css" />
<script
	src="${pageContext.request.contextPath}/static/category/js/jquery-1.9.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/category/assets/js/bootstrap.min.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/category/Widget/icheck/jquery.icheck.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/category/Widget/Validform/5.3.2/Validform.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/category/assets/layer/layer.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/category/js/H-ui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/category/js/H-ui.admin.js"></script>
<script type="text/javascript">
	$(function() {
		$('.skin-minimal input').iCheck({
			checkboxClass : 'icheckbox-blue',
			radioClass : 'iradio-blue',
			increaseArea : '20%'
		});

		$("#form-user-add").Validform({
			tiptype : 2,
			callback : function(form) {
				form[0].submit();
				var index = parent.layer.getFrameIndex(window.name);
				parent.$('.btn-refresh').click();
				parent.layer.close(index);
			}
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="type_style">
		<div class="type_title">产品类型信息</div>
		<div class="type_content">
			<div class="Operate_btn">
				<a href="${pageContext.request.contextPath}/insertCate.do" class="btn  btn-warning"><i
					class="icon-edit align-top bigger-125"></i>新增子类型</a> 
					<a href="${pageContext.request.contextPath}/deleteCate.do?id=${category.id }" class="btn  btn-danger">
					<i class="icon-trash   align-top bigger-125"></i>删除该类型</a>
			</div>
			<form action="${pageContext.request.contextPath}/updateC.do"
				method="post">
				<input type="hidden" name="id" value="${category.id}" />
				<div class="Operate_cont clearfix">
					<label class="form-label"><span class="c-red">*</span>类别名称：</label>
					<div class="formControls ">
						<input id="name" class="input-text" placeholder="请输入类别名"
							type="text" name="name" value="${category.name}">
					</div>
				</div>
				<br />
				<div class="Operate_cont clearfix">
					<label class="form-label"><span class="c-red">*</span>是否展示：</label>
					<div class="formControls ">
						<select name="display" class="select" value="${category.display}">
							<option value="true" selected="selected">是</option>
							<option value="false" selected="selected">否</option>
						</select>
					</div>
				</div>
				<div class="Operate_cont clearfix">
					<label class="form-label"><span class="c-red">*</span>简介：</label>
					<div class="formControls ">
						<textarea rows="8" cols="20" id="intro" name="intro">${category.intro }</textarea>
					</div>
				</div>
				<div class="">
					<div class="" style="text-align: center">
						<input class="btn btn-primary radius" type="submit" value="提交">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>