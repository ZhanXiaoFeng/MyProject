<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<link href="${pageContext.request.contextPath }/admin/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/style.css" />
<link href="${pageContext.request.contextPath }/admin/assets/css/codemirror.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath }/admin/assets/css/ace.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/admin/assets/css/font-awesome.min.css" />
<link href="${pageContext.request.contextPath }/admin/Widget/icheck/icheck.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/admin/Widget/webuploader/0.1.5/webuploader.css" rel="stylesheet"
	type="text/css" />

<title>添加图文</title>
</head>
<body>
		<div class="page_right_style">
			<div class="type_title">修改图文</div>
			<form action="${pageContext.request.contextPath }/picUpdateCondition.do"
				class="form form-horizontal"  method="post"
				enctype="multipart/form-data"  id="form-article-add">
				<input type="hidden" name="id" value="${pics.id}" />
				<div>${message}</div>
				<div class="clearfix cl">
					<label class="form-label col-2"><span class="c-red">*</span>图文名称：</label>
					<div class="formControls col-10">
						<input type="text" class="input-text" value="${pics.name}" placeholder=""
							name="name">
					</div>
				</div>

					<div class=" clearfix cl">
						<div class="Add_p_s">
							<label class="form-label col-2">类别id：</label>
							<div class="formControls col-2">
								<input type="text" class="input-text" value="${pics.categoryId}" placeholder=""
									id="" name="categoryId">
							</div>
						</div>


						<div class="Add_p_s">
							<label class="form-label col-2">展示：</label>
							<div class="formControls col-2">
								<span class="select-box"> <select class="select"
									name="display">
										<option value="1">上线</option>
										<option value="0">不上线</option>
								</select>
								</span>
							</div>
						</div>

						<div class="Add_p_s">
							<label class="form-label col-2">排&nbsp;&nbsp;&nbsp;&nbsp;序：</label>
							<div class="formControls col-2">
								<input type="text" class="input-text" value="${pics.level}" placeholder=""
									id="" name="level">
							</div>
						</div>
					</div>

					<div class="clearfix cl">
						<label class="form-label col-2">图文简介：</label>
						<div class="formControls col-5">
							<textarea name="intro" cols="" rows="" class="textarea"
								placeholder="说点什么...最少输入10个字符" datatype="*10-100"
								dragonfly="true" nullmsg="备注不能为空！"
								onKeyUp="textarealength(this,200)" ></textarea>
							<p class="textarea-numberbar">
								<em class="textarea-length">0</em>/200
							</p>
						</div>
					</div>

				<div class="clearfix cl">
			<div class="formControls col-10">
				<input type="submit" name="submit" value="保存并提交" />
			</div>
		</div>
	</div>

			<!-- 	<div class="clearfix cl">
					<div class="Button_operation">
						<button onClick="save()" class="btn btn-primary radius"
							type="button">
							<i class="icon-save "></i>保存并提交审核
						</button>
						<button onClick="article_save();"
							class="btn btn-secondary  btn-warning" type="button">
							<i class="icon-save"></i>保存草稿
						</button>
						<button onClick="layer_close();" class="btn btn-default radius"
							type="button">&nbsp;&nbsp;取消&nbsp;&nbsp;</button>
					</div>
				</div> -->

			</form>
		</div>
	</div>
	</div>
	<!-- <script type="text/javascript">
   function save() {
	   location.href='${pageContext.request.contextPath }/goodsInsert.do';
}
</script> -->
</body>
</html>