<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<meta name="keywords" content="首页" />
<meta name="description" content="首页" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/normalize.css" />
<link href="${pageContext.request.contextPath}/static/css/index.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery-1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/common.js"
	type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var showproduct = {
			"boxid" : "showbox",
			"sumid" : "showsum",
			"boxw" : 400,//宽度,该版本中请把宽高填写成一样
			"boxh" : 400,//高度,该版本中请把宽高填写成一样
			"sumw" : 60,//列表每个宽度,该版本中请把宽高填写成一样
			"sumh" : 60,//列表每个高度,该版本中请把宽高填写成一样
			"sumi" : 7,//列表间隔
			"sums" : 5,//列表显示个数
			"sumsel" : "sel",
			"sumborder" : 1,//列表边框，没有边框填写0，边框在css中修改
			"lastid" : "showlast",
			"nextid" : "shownext"
		};//参数定义	  
		$.ljsGlasses.pcGlasses(showproduct);//方法调用，务必在加载完后执行
	});
</script>
</head>
<body>
	<%
		String id = request.getParameter("goodsId");
		String name = request.getParameter("name");
		String price2 = request.getParameter("price2");
		String xiaoliang = request.getParameter("xiaoliang");
		String kucun = request.getParameter("kucun");
		String baoyou = request.getParameter("baoyou");
		int i = Integer.parseInt(baoyou);
		String source = request.getParameter("source");
		String intro = request.getParameter("intro");
		String imgs = request.getParameter("imgs");
	%>
	<!-- <div class="brand-logo">            
		 <a href="index2.jsp"><img src="./static/images/logo.png"></a>
</div>
 -->
	<div class="w">
		<div class="logo">
			<a href=""><img
				src="${pageContext.request.contextPath}/static/images/cLogo.png"></a>
		</div>
		<form
			action="${pageContext.request.contextPath }/goodsSelectByName.do"
			method="post">
			<div class="search">
				<input type="text" name="name" class="text" />
				<!-- <input type="text" value="家电一折抢" class="text" id="textt"> -->
			</div>
			<div class="search">
				<input type="submit" value="搜索" class="button" />
			</div>
		</form>
	</div>

	<div class="showall" style="float: left; margin-left: 100px">
		<!--left -->
		<div class="showbot">
			<div id="showbox">
				<img
					src="${pageContext.request.contextPath }/static/upload/<%=imgs%>"
					width="400" height="400" />
			</div>
			<!--展示图片盒子-->
			<div id="showsum">
				<!--展示图片里边-->
			</div>
			<p class="showpage">
				<a href="javascript:void(0);" id="showlast"> < </a> <a
					href="javascript:void(0);" id="shownext"> > </a>
			</p>
		</div>
		<!--conet -->
		<div class="tb-property">
			<div class="tr-nobdr">
				<h3 style="color: #FD532D">商品：<%=name%></h3>
			</div>
			<div class="txt">
				<span class="nowprice">￥<input id="goodsPrice"
					name="goodsPrice" value="<%=price2%>"></span>
				<div class="cumulative">
					<span class="number ty1">累计售出<br /> <em
						id="add_sell_num_363"><%=xiaoliang%></em></span>

				</div>
			</div>
			<div class="txt-h">

				<ul class="glist" id="glist"
					data-monitor="goodsdetails_fenlei_click">
			</div>
			<script>
				$(document).ready(function() {

					var t = $("#text_box");

					$('#min').attr('disabled', true);

					$("#add").click(function() {
						t.val(parseInt(t.val()) + 1)
						if (parseInt(t.val()) != 1) {
							$('#min').attr('disabled', false);
						}

					})

					$("#min").click(function() {
						t.val(parseInt(t.val()) - 1);
						if (parseInt(t.val()) == 1) {
							$('#min').attr('disabled', true);
						}

					})
				});

				$(function() {
					$("#addcart")
							.click(
									function() {
										var amount = $("#text_box").val();
										var goodsId = $("#goodsId").val();
										var price = $("#goodsPrice").val();
										location.href = "${pageContext.request.contextPath }/cart/addOrderItem.do?gid="
												+ goodsId
												+ "&gamount="
												+ amount + "&gprice=" + price;
									})
				});

				$(function() {
					$("#buy")
							.click(
									function() {
										var amount = $("#text_box").val();
										var goodsId = $("#goodsId").val();
										var price = $("#goodsPrice").val();
										location.href = "${pageContext.request.contextPath }/cart/addOrderItemBuyBefore.do?gid="
												+ goodsId
												+ "&gamount="
												+ amount + "&gprice=" + price;
									})
				});
			</script>
			<div class="gcIpt">
				<input type="hidden" id="goodsId" name="goodsId" value="<%=id%>">
				<span class="guT">数量</span> <input id="min" name="" type="button"
					value="-" /> <input id="text_box" name="Amount" type="text"
					value="1" style="width: 30px; text-align: center; color: #0F0F0F;" />
				<input id="add" name="" type="button" value="+" /> <span
					class="Hgt">库存（<%=kucun%>）
				</span>
			</div>

			<div class="nobdr-btns">
				<button type="button" class="addcart hu" id="addcart">
					<img
						src="${pageContext.request.contextPath }/static/images/shop.png"
						width="25" height="25" />加入购物车
				</button>
				<button class="addcart yh" id="buy" name="buy">
					<img src="${pageContext.request.contextPath }/static/images/ht.png"  
						width="25" height="25" />立即购买
				</button>
			</div>
			<div class="guarantee">
				<br> <br> <br> 邮费：<%=i * 10%>元 <a href=""><img
					src="${pageContext.request.contextPath }/static/images/me.png" /></a>
			</div>
		</div>
		<!--right -->
		<div class="extInfo">
			<br> <br> <br> <br> <br>
			<div class="suport-icons">
				<h4>
					扫一扫<br />手机下单更优惠
				</h4>
				<img
					src="${pageContext.request.contextPath }/static/images/ho_11.jpg" />
			</div>
		</div>
	</div>
	<!-- 商品介紹 -->
	<div class="gdetail">
		<!-- left -->
		<div class="aside">
			<h3>
				看了还看<span><img
					src="${pageContext.request.contextPath }/static/images/fod.png"
					width="22" height="22" />换一批</span>
			</h3>
			<dl class="ac-mod-list">
				<dt>
					<a href=""><img
						src="${pageContext.request.contextPath }/static/images/hdy_09.png" /></a>
				</dt>
				<dd>
					O2+车载空气净化器DM2 <span>￥99</span>
				</dd>
			</dl>
			<dl class="ac-mod-list">
				<dt>
					<a href=""><img
						src="${pageContext.request.contextPath }/static/images/hdy_07.png" /></a>
				</dt>
				<dd>
					O2+车载空气净化器DM2 <span>￥99</span>
				</dd>
			</dl>
			<dl class="ac-mod-list">
				<dt>
					<a href=""><img
						src="${pageContext.request.contextPath }/static/images/hdy_11.jpg" /></a>
				</dt>
				<dd>
					O2+车载空气净化器DM2 <span>￥99</span>
				</dd>
			</dl>
		</div>
		<!-- right -->
		<script>
			var detail = document.querySelector('.detail');
			var origOffsetY = detail.offsetTop;
			function onScroll(e) {
				window.scrollY >= origOffsetY ? detail.classList.add('sticky')
						: detail.classList.remove('sticky');
			}
			document.addEventListener('scroll', onScroll);
		</script>
		<div class="detail">
			<div class="active_tab" id="outer">
				<ul class="act_title_left" id="tab">
					<li class="act_active"><a href="#">规格参数</a></li>
					<li><a href="#">商品介绍</a></li>

				</ul>
				<ul class="act_title_right">
					<li class="mui"><a id="mui-a" href="#">扫一扫下单</a></li>
					<li class="mui-ac"><a href="#">加入购物车</a></li>
				</ul>
				<div class="clear"></div>
			</div>
			<div id="content" class="active_list">
				<!--0-->
				<div id="ui-a" class="ui-a">
					<ul style="display: block;">
						<li>商品名称：<%=name%></li>
						<li>品牌</li>
						<li>产地:<%=source%></li>
						<li>库存：<%=kucun%>
						</li>
						<li>介绍：<%=intro%>
						</li>
						<li><img
							src="${pageContext.request.contextPath }/static/upload/<%=imgs %>"
							style="width: 240px; height: 230px;" /></li>
					</ul>
				</div>
				<!--商品规格-->
				<div id="bit" class="bit">
					<ul style="display: none;">
						<div
							style="float: left; font-family: '楷体'; font-size: 20px; color: #FD532D">
							<li><img
								src="${pageContext.request.contextPath }/static/upload/<%=imgs %>"
								style="width: 240px; height: 230px;" /></li>
							<li style="margin: 12px 48px; width: 200px;"><%=intro%></li>
						</div>
					</ul>
				</div>
			</div>
			<script>
				$(function() {
					window.onload = function() {
						var $li = $('#tab li');
						var $ul = $('#content ul');

						$li.mouseover(function() {
							var $this = $(this);
							var $t = $this.index();
							$li.removeClass();
							$this.addClass('act_active');
							$ul.css('display', 'none');
							$ul.eq($t).css('display', 'block');
						})
					}
				});
			</script>
		</div>
	</div>
</body>
</html>
