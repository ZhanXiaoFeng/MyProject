<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>会员中心</title>
<!--[if IE]>
    <!--[if IE 7]><link rel="stylesheet" type="text/css" href="css/ie7.css">
<![endif]-->
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
<style type="text/css">
h3#show_time {
	margin-left: 650px;
}
</style>

</head>
<body>
	<!--top-->
	<div class="top" id="wyqtb">
		<div class="top_in">
			<em>地区选择</em>
			<!--插入插件-->
			<input type="text" id="city"
				style="margin-top: 8px; font-size: 12px; text-align: center; color: #343434; height: 24px; float: left"
				value="请输入地址范围..." />
			<script type="text/javascript">
				$("#city").click(function(e) {
					SelCity(this, e);
				});
			</script>
			<!--注册/登录-->
			<div class="zcdl">
				<a href="#">注册</a> <i></i> <a href="#">登录</a>
			</div>
			<!--客服电话-->
			<div class="kfdh">客服热线：400-9022-567</div>
			<!--手机微信-->
			<div class="sjwx">
				<em title="微信公众号" id="wxgzh"><img
					src="${pageContext.request.contextPath}/static/personal/images/weixin.png" /></em>
				<em title="移动app" id="sjapp"><img
					src="${pageContext.request.contextPath}/static/personal/images/shouji.png" /></em>
				<b class="wxgzh none"><img
					src="${pageContext.request.contextPath}/static/personal/images/乐乐公众号.jpg"
					/ width="80" height="80"></b> <b class="sjapp none"><img
					src="${pageContext.request.contextPath}/static/personal/images/乐乐官网二维码.jpg"
					/ width="80" height="80"></b>
			</div>
		</div>
	</div>
	<!--导航加搜索框-->
	<div style="width: 100%; height: auto; background: #fff">
		<div class="dhjssk">
			<a href="#" class="logo"><img
				src="${pageContext.request.contextPath}/static/images/cLogo.png"
				style="width: 300px; height: 87px;" /></a>
			<div class="searchk">
				<div class="sjhcp">
					<!--left-->
					<div class="sjhcp_in">
						<span>商家</span>
						<div class="little_list">
							<em>菜品</em> <em>商家</em>
						</div>
					</div>
					<script>
						//模拟下拉菜单的js*/
						$(".sjhcp_in span").on("mouseenter", function(e) {
							if ($(".little_list").is(":hidden")) {
								$(".little_list").show();
							} else {
								$(".little_list").hide();
							}
							$(".little_list em").click(function() {
								var txt = $(this).text();
								$(".sjhcp_in span").text(txt);
								$(".little_list").hide();
							})
							$(document).one("click", function() {
								$(".little_list").hide();
							});
							e.stopPropagation();
						});
						$(".little_list").on("click", function(e) {
							e.stopPropagation();
						});
					</script>
					<!--right-->
					<div class="jiantou">
						<img
							src="${pageContext.request.contextPath}/static/personal/images/jiantou.png" />
					</div>
				</div>
				<input type="text"
					style="width: 307px; height: 40px; background: #fff; float: left; font-size: 16px; color: #adadad; text-indent: 16px; line-height: 40px"
					value="请输入..." onfocus="if(value=='请输入...') {value=''}"
					onblur="if (value=='') {value='请输入...'}">
				<div class="ssl">
					<img
						src="${pageContext.request.contextPath}/static/personal/images/fangdajing.png" />
				</div>
			</div>
			<!--我们的优势-->
			<div class="wmdys">
				<ul>
					<li><b
						style="background: url(${pageContext.request.contextPath}/static/personal/images/wmdys.png) no-repeat 0 0"></b>
						<p>金牌商家</p></li>
					<li><b
						style="background: url(${pageContext.request.contextPath}/static/personal/images/wmdys.png) no-repeat -36px 0"></b>
						<p>提前预定</p></li>
					<li><b
						style="background: url(${pageContext.request.contextPath}/static/personal/images/wmdys.png) no-repeat -72px 0"></b>
						<p>放心安全</p></li>
				</ul>
			</div>
			<!--热门搜索-->
			<div class="hot_ss">
				<a href="#">川菜</a> <a href="#">粤菜</a> <a href="#">火锅</a> <a href="#">家常菜</a>
				<a href="#">快餐</a> <a href="#">海鲜</a> <a href="#">牛排</a> <a href="#">蛋糕</a>
			</div>
		</div>
	</div>
	<!--导航-->
	<div class="dao_hang">
		<div class="nav_css">
			<!--右下侧广告-->
			<div class="advertisement" style="display: none">
				<h4>最新公告</h4>
				<div class="notice_new">
					<p>
						<a href="#">【优选】金秋聚会，买一送一</a>
					</p>
					<p>
						<a href="#">【优选】中秋嘉年华，好礼钜惠</a>
					</p>
					<p>
						<a href="#">【优选】冰点破纪录，低价不猫腻</a>
					</p>
					<p>
						<a href="#">【优选】开学季，“纸”想“净、净”学习</a>
					</p>
					<p>
						<a href="#">【优选】金秋聚会，买一送一</a>
					</p>
					<p>
						<a href="#">【优选】中秋嘉年华，好礼钜惠</a>
					</p>
					<p>
						<a href="#">【优选】开学季，“纸”想“净、净”学习</a>
					</p>
				</div>
				<a href="#">
					<div class="notice_img">
						<img
							src="${pageContext.request.contextPath}/static/personal/images/activity.jpg"
							class="img1"> <img
							src="${pageContext.request.contextPath}/static/personal/images/activity.jpg"
							class="img2">
					</div>
				</a>
				<!--<script>
			$(function(){
				$(".notice_img")
				})
            </script>-->
			</div>
			<!--全部商品分类-->
			<div class="important">
				<img
					src="${pageContext.request.contextPath}/static/personal/images/all_list.png"
					style="margin-top: 13px">&nbsp;全部商品分类
				<div class="aside"></div>

			</div>
			<!--结束-->
			<div class="dao_list">
				<a href="#">首页</a> <a href="#">商家</a> <a href="#">优惠活动</a> <a
					href="#">诚邀加盟</a>
			</div>
		</div>
	</div>
	<script>
		window.onload = function() {
			$(".aside").css({
				display : "none"
			})
			$(".important").mouseenter(function() {
				$(".aside").css({
					display : "block"
				})
			}).mouseleave(function() {
				$(".aside").css({
					display : "none"
				})
			})
		}
	</script>
	<!--当前位置-->
	<div class="now_positionm">
		<span>当前位置：</span><a href="#">首页></a><a href="#">个人中心</a>
	</div>
	<!--centers-->
	<div class="centers_m">
		<!--清除浮动-->
		<div class="clear_sm"></div>
		<!--left-->
		<div class="centers_ml">
			<!--头像-->
			<div class="center_header">
				<a href="#"><img
					src="${pageContext.request.contextPath}/static/personal/images/66f625e1ecfd7ad8244efabaa744aa73.png" /></a>
				<em>您好，<font>${username}</font></em>
			</div>
			<!--列表go-->
			<div class="centers_listm">
				<div class="centers_listm_one">
					<img
						src="${pageContext.request.contextPath}/static/personal/images/zshy.png" />
					<em>会员中心</em>
				</div>
				<!--一条开始-->
				<div class="centers_listm_one_in">
					<img
						src="${pageContext.request.contextPath}/static/personal/images/shezhi.png" />
					<em>资料管理</em> <b></b>
				</div>
				<span class="gjszmdm"> <a
					href="${pageContext.request.contextPath}/customer/selectById.do?id=${customer.getId()}"
					class="center_in_self" target="testIframe" id="c1" name="c1h"><font>个人信息资料</font></a>
					<a
					href="${pageContext.request.contextPath}/customer/uploadPersonalImg.html"
					class="center_in_self" target="testIframe" id="c1" name="c1h"><font>头像修改</font></a>
				</span>


				<!--一条开始-->
				<div class="centers_listm_one_in">
					<img
						src="${pageContext.request.contextPath}/static/personal/images/ddgl.png" />
					<em>订单管理</em> <b></b>
				</div>
				<span class="gjszmdm"> <a href="#" class="center_in_self"
					target="testIframe"><font>我的订单</font></a>

				</span>



				<!--一条开始-->
				<div class="centers_listm_one_in">
					<img
						src="${pageContext.request.contextPath}/static/personal/images/suo.png" />
					<em>账户安全</em> <b></b>
				</div>
				<span class="gjszmdm"> <a href="${pageContext.request.contextPath}/customer/updatePwd.html" class="center_in_self" target="testIframe"><font>账户安全</font></a>
					<a href="#" class="center_in_self"><font>账户余额</font></a>
				</span>




				<!--一条开始-->
				<div class="centers_listm_one_in">
					<img
						src="${pageContext.request.contextPath}/static/personal/images/wdssc.png" />
					<em>收藏管理</em> <b></b>
				</div>
				<span class="gjszmdm"> <a href="#" class="center_in_self"><font>店铺收藏</font></a>
					<a href="#" class="center_in_self"><font>菜品收藏</font></a>
				</span>
				<!--一条开始-->
				<div class="centers_listm_one_in">
					<img
						src="${pageContext.request.contextPath}/static/personal/images/myfridend.png" />
					<em>好友管理</em> <b></b>
				</div>
				<span class="gjszmdm"> <a href="#" class="center_in_self"><font>我的消息</font></a>
					<a href="#" class="center_in_self"><font>我的好友</font></a>
				</span>
			</div>
			<script type="text/javascript">
				$(function() {//第一步都得写这个
					$(".centers_listm_one_in").click(
							function() {
								$(this).next(".gjszmdm").slideToggle()
										.siblings("gjszmdm").slideUp()
							});
				})
			</script>
		</div>

		<!--right-->
		<div class="centers_mr">
			<h1 class="welcom_tm">
				欢迎您，超级会员 <font>${username}</font>
				
				<h3 id="show_time">
					<script>
						//setInterval("show_time.innerHTML= new Date().toLocaleString()",1000);  
						setInterval(
								"show_time.innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",
								1000);
					</script>
			</h1>
		</div>
		<div class="centers_mr">
			<table border="1" bordercolor="#cccccc" cellspacing="0"
				cellpadding="0" style="width: 100%; text-align: center;height: 80px;">
				<tr>
					<th>收货地址</th>
					<th>收件人</th>
					<th>联系电话</th>
					<th>备注信息</th>
				</tr>
				<tr>
					<td width="120px"><span
						style="font-family: '楷体'; color: #000; font-size: 20px;">${addr.addr}${addr.area}</span></td>
					<td width="150px"><span
						style="font-family: '楷体'; color: #CB3437; font-size: 20px;">${addr.name}</span></td>
					<td width="150px"><span
						style="font-family: '楷体'; color: #000; font-size: 20px;">${addr.phone}</span></td>
					<td width="150px"><span
						style="font-family: '楷体'; color: #000; font-size: 20px;">${addr.remark}</span></td>
				</tr>
			</table>
			<iframe id="testIframe" name="testIframe" frameborder="0" 
                scrolling="no" SRC="" width="956px" height="600px"></iframe>
		</div>

		<!--页脚-->
</body>
</html>



































































