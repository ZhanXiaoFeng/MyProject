<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Document</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/personal/css/jiazaitoubu.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/personal/css/css.css">
<script src="js/jquery-1.8.3.min.js"></script>
<script src="js/index2.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/personal/css/center.css">
<!--城市联动-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/personal/city/city.css">
<script
	src="${pageContext.request.contextPath}/static/personal/city/Popt.js"></script>
<script
	src="${pageContext.request.contextPath}/static/personal/city/cityJson.js"></script>
<script
	src="${pageContext.request.contextPath}/static/personal/city/citySet.js"></script>


<script src="${pageContext.request.contextPath}/static/personal/js/jquery.min.js"></script>

<link href="${pageContext.request.contextPath}/static/personal/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/personal/cropper/cropper.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/static/personal/sitelogo/sitelogo.css" rel="stylesheet">

<script src="${pageContext.request.contextPath}/static/personal/cropper/cropper.min.js"></script>
<script src="${pageContext.request.contextPath}/static/personal/sitelogo/sitelogo.js"></script>
<script src="${pageContext.request.contextPath}/static/personal/bootstrap/js/bootstrap.min.js"></script>

</head>
<body style="overflow: hidden;">


	<!--一条开始-->

	<div class="public_m1">
		<div class="public_m2">资料管理</div>
		
		<!--照片和内容-->
		<div class="zp_nrm">
			<!--left-->
				<!--left-->
                <div class="zp_nrm_l">
                	<img src="${pageContext.request.contextPath}/static/personal/images/66f625e1ecfd7ad8244efabaa744aa73.png"/>
                   
                </div>
			<!--right-->
			<div class="zp_nrm_r">
				<p>
					<em>用户名：</em><i>${personalInfo.username }</i>
				</p>
				<p>
					<em>昵称</em><i>${personalInfo.nickname }</i>
				</p>
				<p>
					<em>邮箱：</em><i>${personalInfo.email }</i>
				</p>
				<p>
					<em>手机号：</em><i>${personalInfo.phone }</i><a href="#">立即绑定</a>
				</p>
				<p>
					<em>性别：</em><input type="radio" name="sex" class="sex_m"><i>保密</i><input
						type="radio" name="sex" class="sex_m"><i>男</i><input
						type="radio" name="sex" class="sex_m"><i>女</i>
				</p>
				<span class="borth_m"> <em>生日：</em> <select
					style="float: left; height: 23px; border: 1px solid #eaeaea; margin-top: 13px; margin-right: 3px">
						<option>-年-</option>
						<option>1994年</option>
				</select> <select
					style="float: left; border: 1px solid #eaeaea; margin-top: 13px; margin-right: 3px">
						<option>-月-</option>
						<option>08月</option>
				</select> <select
					style="float: left; border: 1px solid #eaeaea; margin-top: 13px; margin-right: 3px">
						<option>-日-</option>
						<option>14日</option>
				</select> <font>(可能有惊喜哦)</font>
				</span>
				
				<a href="${pageContext.request.contextPath }/customer/editPersonal.do?id=${personalInfo.id}" class="public_m3">修改信息</a>
			</div>
		</div>
	</div>




	<div class="modal fade" id="avatar-modal" aria-hidden="true"
		aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<form class="avatar-form" action="{{url('admin/upload-logo')}}"
					enctype="multipart/form-data" method="post">
					<div class="modal-header">
						<button class="close" data-dismiss="modal" type="button">&times;</button>
						<h4 class="modal-title" id="avatar-modal-label">Change Logo
							Picture</h4>
					</div>
					<div class="modal-body">
						<div class="avatar-body">
							<div class="avatar-upload">
								<input class="avatar-src" name="avatar_src" type="hidden">
								<input class="avatar-data" name="avatar_data" type="hidden">
								<label for="avatarInput">图片上传</label> <input
									class="avatar-input" id="avatarInput" name="avatar_file"
									type="file">
							</div>
							<div class="row">
								<div class="col-md-9">
									<div class="avatar-wrapper"></div>
								</div>
								<div class="col-md-3">
									<div class="avatar-preview preview-lg"></div>
									<div class="avatar-preview preview-md"></div>
									<div class="avatar-preview preview-sm"></div>
								</div>
							</div>
							<div class="row avatar-btns">
								<div class="col-md-9">
									<div class="btn-group">
										<button class="btn" data-method="rotate" data-option="-90"
											type="button" title="Rotate -90 degrees">
											<i class="fa fa-undo"></i> 向左旋转
										</button>
									</div>
									<div class="btn-group">
										<button class="btn" data-method="rotate" data-option="90"
											type="button" title="Rotate 90 degrees">
											<i class="fa fa-repeat"></i> 向右旋转
										</button>
									</div>
								</div>
								<div class="col-md-3">
									<button class="btn btn-success btn-block avatar-save"
										type="submit">
										<i class="fa fa-save" ></i> 保存修改
									</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>

</body>
</html>