<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>查询</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/category/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" charset="UTF-8">
	$(function() {
		$("#sjs")
				.change(
						function() {
							var v = $("#sjs").val();//获取当前所选择的类别的ID
							location.href = "${pageContext.request.contextPath}/selectCateById.do?id="
									+ v;
						});
	});
</script>
</head>
<body>
	<div class="type_style">
		<div class="type_title">产品类型信息</div>

		<div style="margin-top: 10px; margin-left: 10px">
			<span style="font-size: 15px">请选择需要查询的类别的详细信息 :<select
				id="sjs"></span>
			<c:forEach items="${categorys}" var="i">
				<option value="${i.id }">${i.name }</option>
			</c:forEach>
			</select>
		</div>

		<br>

		<table class="table table-striped table-bordered table-hover"
			id="sample-table">
			<thead>
				<tr>
					<th width="25px"><label><input type="checkbox"
							class="ace"><span class="lbl"></span></label></th>
					<th width="80px">类别编号</th>
					<th width="250px">类别名称</th>
					<th width="100px">是否展示</th>
					<th width="100px">简介</th>
					<th width="80px">审核状态</th>
					<th width="70px">状态</th>
					<th width="200px">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${categorys }" var="i">
					<tr>
						<td width="25px"><label><input type="checkbox"
								class="ace"><span class="lbl"></span></label></td>
						<td width="80px">${i.id }</td>
						<td width="250px"><u style="cursor: pointer"
							class="text-primary" onclick=""><a
								href="${pageContext.request.contextPath}/selectAllByCategory.do?categoryId=${i.id }">${i.name }</a></u></td>
						<td width="100px">${i.display }</td>
						<td width="100px">${i.intro}</td>
						<td class="text-l">通过</td>
						<td class="td-status"><span
							class="label label-success radius">已启用</span></td>
						<td class="td-manage"><a onClick="member_stop(this,'10001')"
							href="${pageContext.request.contextPath}/selectAllByCategory.do?categoryId=${i.id }"
							title="详情" class="btn btn-xs btn-success"> <i
								class="icon-ok bigger-120"></i></a> <a title="编辑"
							onclick="member_edit('编辑','member-add.html','4','','510')"
							href="${pageContext.request.contextPath}/updateCate.do?id=${i.id }"
							class="btn btn-xs btn-info"> <i class="icon-edit bigger-120"></i></a>
							<a title="删除"
							href="${pageContext.request.contextPath}/deleteCate.do?id=${i.id }"
							onclick="member_del(this,'1')" class="btn btn-xs btn-warning">
								<i class="icon-trash  bigger-120"></i>
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

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
	})
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
 
/**************/
var setting = {
	view: {
		dblClickExpand: false,
		showLine: false,
		selectedMulti: false
	},
	data: {
		simpleData: {
			enable:true,
			idKey: "id",
			pIdKey: "pId",
			rootPId: ""
		}
	},
	callback: {
		beforeClick: function(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("tree");
			if (treeNode.isParent) {
				zTree.expandNode(treeNode);
				return false;
			} else {
				demoIframe.attr("src",treeNode.file + ".jsp");
				return true;
			}
		}
	}
};

var zNodes =[
	{ id:1, pId:0, name:"商城分类列表", open:true},
	{ id:11, pId:1, name:"蔬菜水果"},
	{ id:111, pId:11, name:"蔬菜"},
	{ id:112, pId:11, name:"苹果"},
	{ id:113, pId:11, name:"大蒜"},
	{ id:114, pId:11, name:"白菜"},
	{ id:115, pId:11, name:"青菜"},
	{ id:12, pId:1, name:"手机数码"},
	{ id:121, pId:12, name:"手机 "},
	{ id:122, pId:12, name:"照相机 "},
	{ id:13, pId:1, name:"电脑配件"},
	{ id:131, pId:13, name:"手机 "},
	{ id:122, pId:13, name:"照相机 "},
	{ id:14, pId:1, name:"服装鞋帽"},
	{ id:141, pId:14, name:"手机 "},
	{ id:42, pId:14, name:"照相机 "},
];

var code;
		
function showCode(str) {
	if (!code) code = $("#code");
	code.empty();
	code.append("<li>"+str+"</li>");
}
		
$(document).ready(function(){
	var t = $("#treeDemo");
	t = $.fn.zTree.init(t, setting, zNodes);
	demoIframe = $("#testIframe");
	demoIframe.bind("load", loadReady);
	var zTree = $.fn.zTree.getZTreeObj("tree");
	zTree.selectNode(zTree.getNodeByParam("id",'11'));
});	
</script>