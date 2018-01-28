<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath}/static/css/index.css"
	type="text/css" rel="stylesheet">
<title>主页</title>
<!-- <script type="text/javascript">
	location.href="${pageContext.request.contextPath}/index.html";
</script> -->
</head>
<body>
	<div class="jdm-toolbar-wrap J-wrap">
		<div class="jdm-toolbar J-toolbar">
			<div class="jdm-toolbar-panels J-panel"></div>
			<div class="jdm-toolbar-tabs J-tab">
				<div data-type="bar"
					class="J-trigger jdm-toolbar-tab jdm-tbar-tab-cart">
					<i class="tab-ico"></i> <em class="tab-text"><a
						href="cart.html">购物车</a> </em>
				</div>
				<div data-type="bar" clstag="h|keycount|cebianlan_h_follow|btn"
					class="J-trigger jdm-toolbar-tab jdm-tbar-tab-follow"
					data-name="follow" data-login="true">
					<i class="tab-ico"></i> <em class="tab-text"> 我的关注 </em>
				</div>
				<div data-type="bar" clstag="h|keycount|cebianlan_h_history|btn"
					class="J-trigger jdm-toolbar-tab jdm-tbar-tab-history"
					data-name="history">
					<i class="tab-ico"></i> <em class="tab-text"> 我的足迹 </em>
				</div>
				<div class="J-trigger jdm-toolbar-tab jdm-tbar-tab-message"
					data-name="message">
					<a target="_blank" href="shopdetial.html"> <i class="tab-ico"></i>
						<em class="tab-text"> 我的消息 </em></a>
				</div>
				<div data-type="bar" clstag="h|keycount|cebianlan_h_jimi|btn"
					class="J-trigger jdm-toolbar-tab jdm-tbar-tab-jimi"
					data-name="jimi" data-login="true"
					data-iframe="//jimi.jd.com/index.action?source=jdhome">
					<i class="tab-ico"></i> <em class="tab-text"> 咨询JIMI </em>
				</div>
			</div>
			<div class="jdm-toolbar-footer">
				<div data-type="link" id="shopdetial.htmltop"
					class="J-trigger jdm-toolbar-tab jdm-tbar-tab-top">
					<a href="shopdetial.html" clstag="h|keycount|cebianlan_h|top">
						<i class="tab-ico"></i> <em class="tab-text">顶部</em>
					</a>
				</div>
				<div data-type="link"
					class="J-trigger jdm-toolbar-tab jdm-tbar-tab-feedback">
					<a
						href="http://surveys.jd.com/index.php?r=survey/index/sid/889711/newtest/Y/lang/zh-Hans"
						target="_blank" clstag="h|keycount|cebianlan_h|feedback"> <i
						class="tab-ico"></i> <em class="tab-text">反馈</em>
					</a>
				</div>
			</div>
			<div class="jdm-toolbar-mini"></div>
		</div>
		<div id="J-toolbar-load-hook" clstag="h|keycount|cebianlan_h|load"></div>
	</div>
	<!-----------------------------------------顶部-------------->
	<header id="header">
	<div class="header-box">
		<ul class="header-left">
			<li class="bj">送至：北京 <i class="ci-leftll"> <s class="jt">◇</s>
			</i>
				<div class="bj-1">
					<a href="">北京</a><a href="">上海</a><a href="">天津</a><a href="">重庆</a><a
						href="">河北</a><a href="">山西</a><a href="">河南</a><a href="">辽宁</a><a
						href="">吉林</a><a href="">黑龙江</a><a href="">浙江</a><a href="">江苏</a><a
						href="">山东</a><a href="">安徽</a><a href="">内蒙古</a><a href="">湖北</a><a
						href="">湖南</a><a href="">广东</a><a href="">广西</a><a href="">江西</a><a
						href="">四川</a><a href="">海南</a><a href="">贵州</a><a href="">云南</a><a
						href="">西藏</a><a href="">陕西</a><a href="">甘肃</a><a href="">青海</a><a
						href="">宁夏</a><a href="">新疆</a><a href="">台湾</a><a href="">香港</a><a
						href="">澳门</a><a href="">海外</a><a href="">钓鱼岛</a>
				</div>
			</li>
		</ul>
		<%
			String username = request.getParameter("username");
		    Object username1 = request.getAttribute("username");
		%>
		<ul class="header-right">
			<li class="denglu"><span>
					<%
						if (username == null && username1 == null) {
							out.print("未登录");
						}if(username !=null){
							out.print("欢迎你：" + username);
						} else if(username1 !=null){
							out.print("欢迎你：" + username1);
						}
					%>
			</span></li>
			<li class="denglu"><a
				href="${pageContext.request.contextPath}/customer/login.html">&nbsp;&nbsp;&nbsp;&nbsp;登录</a>
				<a href="${pageContext.request.contextPath}/customer/regist.html"
				class="red">免费注册</a></li>
			<li class="shu"></li>
			<li class="denglu"><a
				href="${pageContext.request.contextPath}/showOrder.do">我的订单</a></li>
			<li class="shu"></li>
			<li class="my bj"><a href="${pageContext.request.contextPath}/customer/personal.html">我的微购</a> <i class="ci-right ">
					<s class="jt">◇</s>
			</i>
				<div class="my1">
					<div class="my2">
						<img
							src="${pageContext.request.contextPath}/static/images/no-img_mid_.jpg">
						<div class="my3">
							<h3 class="neirong2">
								<a href="">您好请登录</a>
							</h3>
							<p class="neirong2">
								<a href="">优惠卷 丨 消息</a>
							</p>
						</div>
					</div>
					<ul class="neirong2">
						<li><a href="">待处理订单</a></li>
						<li><a href="">以往的订单</a></li>
						<li><a href="">咨询回复</a></li>
						<li><a href="${pageContext.request.contextPath}/customer/editCust.html">我的资料</a></li>
					</ul>
				</div></li>
			<li class="shu"></li>
			<li class="denglu"><a href="#">微购会员</a></li>
			<li class="shu"></li>
			<li class="shu"></li>
			<li class="kehu bj"><a href="#">客户服务</a> <i class="ci-right ">
					<s class="jt">◇</s>
			</i>
				<div class="kehu1">
					<h3 class="neirong2">客户</h3>
					<ul class="kehu2">
						<li><a href="">帮助中心</a></li>
						<li><a href="">售后服务</a></li>
						<li><a href="">在线客服</a></li>
						<li><a href="">帮助中心</a></li>
						<li><a href="">客服邮箱</a></li>
					</ul>
				</div></li>
			<li class="shu"></li>
			<li class="daohang"><a href="#">网站导航</a> <i class="ci-right ">
					<s class="jt">◇</s>
			</i>
				<div class="aa">
					<div class="neirong">
						<h4 class="neirong2">特色主题</h4>
						<ul>
							<li><a href="">品牌街</a></li>
							<li><a href="">今日抄底</a></li>
							<li><a href="">好东西</a></li>
							<li><a href="">微购预售</a></li>
						</ul>
						<ul>

							<li><a href="">尖er货</a></li>
							<li><a href="">微购首发</a></li>
							<li><a href="">今日团购</a></li>
							<li><a href="">优惠券</a></li>
						</ul>
						<ul>

							<li><a href="">闪购</a></li>
							<li><a href="">微购会员</a></li>
							<li><a href="">定期送</a></li>
						</ul>
						<ul>

							<li><a href="">装机大师</a></li>
							<li><a href="">新奇特</a></li>
							<li><a href="">微购试用</a></li>
						</ul>

					</div>
					<div class="neirong">

						<h4 class="neirong2">行业频道</h4>

						<ul>

							<li><a href="">品牌街</a></li>
							<li><a href="">今日抄底</a></li>
							<li><a href="">好东西</a></li>

						</ul>
						<ul>

							<li><a href="">尖er货</a></li>
							<li><a href="">微购首发</a></li>
							<li><a href="">今日团购</a></li>

						</ul>
						<ul>

							<li><a href="">闪购</a></li>
							<li><a href="">微购会员</a></li>
							<li><a href="">微购京选</a></li>

						</ul>
						<ul>

							<li><a href="">装机大师</a></li>
							<li><a href="">新奇特</a></li>
							<li><a href="">微购试用</a></li>

						</ul>
						<ul>

							<li><a href="">智能馆</a></li>
							<li><a href="">玩bigger</a></li>
							<li><a href="">大牌免息</a></li>

						</ul>
					</div>
					<div class="neirong">
						<h4 class="neirong2">生活服务</h4>
						<ul>
							<li><a href="">品牌街</a></li>
							<li><a href="">今日抄底</a></li>
							<li><a href="">好东西</a></li>
						</ul>
						<ul>
							<li><a href="">尖er货</a></li>
							<li><a href="">微购首发</a></li>
							<li><a href="">今日团购</a></li>
						</ul>
						<ul>
							<li><a href="">闪购</a></li>
							<li><a href="">微购会员</a></li>
						</ul>
						<ul>
							<li><a href="">装机大师</a></li>
							<li><a href="">新奇特</a></li>
							<li><a href="">微购试用</a></li>
						</ul>
						<ul>
							<li><a href="">智能馆</a></li>
							<li><a href="">玩bigger</a></li>
							<li><a href="">大牌免息</a></li>
						</ul>
					</div>
					<div class="neirong neirong3">
						<h4 class="neirong2">更多精选</h4>
						<ul>
							<li><a href="">品牌街</a></li>
							<li><a href="">今日抄底</a></li>
							<li><a href="">好东西</a></li>
						</ul>
						<ul>
							<li><a href="">尖er货</a></li>
							<li><a href="">微购首发</a></li>
							<li><a href="">今日团购</a></li>
						</ul>
						<ul>
							<li><a href="">闪购</a></li>
							<li><a href="">微购会员</a></li>
						</ul>
						<ul>
							<li><a href="">装机大师</a></li>
							<li><a href="">新奇特</a></li>
							<li><a href="">微购试用</a></li>
						</ul>
						<ul>
							<li><a href="">智能馆</a></li>
							<li><a href="">玩bigger</a></li>
							<li><a href="">大牌免息</a></li>
						</ul>
					</div>
				</div></li>
		</ul>
	</div>
	</header>
	<div class="w">
		<div class="logo">
			<a href="#"><img
				src="${pageContext.request.contextPath}/static/images/cLogo.png"></a>
		</div>
		<form
			action="${pageContext.request.contextPath }/goodsSelectByName.do"
			method="post">
			<div class="search">
				<input type="text" name="name" class="text" />
				<!-- <input type="text" value="家电一折抢" class="text" id="textt"> -->
			</div>
			<div>
				<input type="hidden" name="username" value="<%=username%>" />
			</div>
			<div class="search">
				<input type="submit" value="搜索" class="button" />
			</div>
		</form>
		<div class="right">
			<i class="gw-left"
				style="background: url(${pageContext.request.contextPath}/static/images/jd2015img.png) 0 -58px no-repeat; width: 24px; height: 24px;"></i>
			<i class="gw-right"></i> <i class="gw-count">0</i> <a
				href="${pageContext.request.contextPath}/cart/showMyCart.do">我的购物车</a>
			<div class="dorpdown-layer">
				<img
					src="${pageContext.request.contextPath}/static/images/settleup-nogoods.png">
				购物车中还没有商品，赶紧选购吧！
			</div>
		</div>
	</div>

	<div class="clear"></div>
	<!--轮播图上方导航栏  一栏-->
	<div id="navv">
		<div class="nav-img"
			style="background: url(${pageContext.request.contextPath}/static/images/568a1258N2edec1ab.jpg) repeat-x"></div>
	</div>
	<div class="focus">
		<div class="focus-a">
			<div class="fouc-img1">
				<img
					src="${pageContext.request.contextPath}/static/images/5689d4ebN19f155a6.jpg"
					class="nav-img2">
			</div>
			<div class="fouc-font">
				<a href="">全部商品分类</a>
			</div>
		</div>

		<!------------------------------------轮播图------------------------------------>
		<div id="lunbo">
			<img id="imgs"
				src="${pageContext.request.contextPath }/static/upload/${goods2[0].imgs}"
				width="730px" height="450px" />
		</div>

		<script language="javascript">
			setInterval(test, 4000);
			var array = new Array();
			var index = 0;
			var array = new Array(
					"${pageContext.request.contextPath }/static/upload/${goods2[0].imgs}",
					"${pageContext.request.contextPath }/static/upload/${goods2[1].imgs}",
					"${pageContext.request.contextPath }/static/upload/${goods2[2].imgs}",
					"${pageContext.request.contextPath }/static/upload/${goods2[3].imgs}");
			function test() {
				var myimg = document.getElementById("imgs");
				if (index == array.length - 1) {
					index = 0;
				} else {
					index++;
				}
				myimg.src = array[index];
			}
		</script>
		<!------------------------------------轮播图右侧一栏------------------------>
		<div class="m">
			<div class="mt">
				<h3>微购快报</h3>
				<div class="extra">
					<a href="#">更多 ></a>
				</div>
			</div>
			<div class="mc">
				<ul>
					<li><a href="#"><span>[特惠]</span>小年备好礼 年货美食满99减50</a></li>
				</ul>
			</div>
			<div class="mc">
				<ul>
					<li><a href="#"><span>[公告]</span>华北区因雨雪天气配送延迟</a></li>
				</ul>
			</div>
			<div class="mc">
				<ul>
					<li><a href="#"><span>[特惠]</span>微购全球年货节礼盒买一赠一</a></li>
				</ul>
			</div>
			<div class="mc">
				<ul>
					<li><a href="#"><span>[公告]</span>品牌+服务 升级茗茶消费体验</a></li>
				</ul>
			</div>
			<div class="mc">
				<ul>
					<li><a href="#"><span>[特惠]</span>彪马年终促满300减50</a></li>
				</ul>
			</div>
		</div>
		<div class="ms">
			<div class="mm">
				<h3>微购快报</h3>
				<div class="extra">
					<a href="#">更多 ></a>
				</div>
			</div>
			<div class="mmm">
				<ul>
					<li><a href="#"> <i class="ci-left"
							style="background: url(${pageContext.request.contextPath}/static/images/568dfdbdN4f7d7ca3.png) no-repeat;"></i>
							<span class="ci-bottom">话费</span>
					</a></li>
					<li><a href="#"> <i class="ci-left"
							style="background: url(${pageContext.request.contextPath}/static/images/568dfdbdN4f7d7ca3.png) no-repeat 0 -25px;"></i>
							<span class="ci-bottom">机票</span>
					</a></li>
					<li><a href="#"> <i class="ci-left"
							style="background: url(${pageContext.request.contextPath}/static/images/568dfdbdN4f7d7ca3.png) no-repeat 0 -50px;"></i>
							<span class="ci-bottom">电影票</span>
					</a></li>
					<li><a href="#"> <i class="ci-left"
							style="background: url(${pageContext.request.contextPath}/static/images/568dfdbdN4f7d7ca3.png) no-repeat 0 -75px;"></i>
							<span class="ci-bottom">游戏</span>
					</a></li>
					<li><a href="#"> <i class="ci-left"
							style="background: url(${pageContext.request.contextPath}/static/images/568dfdbdN4f7d7ca3.png) no-repeat -25px -100px;"></i>
							<span class="ci-bottom">彩票</span>
					</a></li>
					<li><a href="#"> <i class="ci-left"
							style="background: url(${pageContext.request.contextPath}/static/images/568dfdbdN4f7d7ca3.png) no-repeat -25px -125px;"></i>
							<span class="ci-bottom">团购</span>
					</a></li>
					<li><a href="#"> <i class="ci-left"
							style="background: url(${pageContext.request.contextPath}/static/images/568dfdbdN4f7d7ca3.png) no-repeat -25px -150px;"></i>
							<span class="ci-bottom">酒店</span>
					</a></li>
					<li><a href="#"> <i class="ci-left"
							style="background: url(${pageContext.request.contextPath}/static/images/568dfdbdN4f7d7ca3.png) no-repeat -25px -175px;"></i>
							<span class="ci-bottom">火车票</span>
					</a></li>
					<li><a href="#"> <i class="ci-left"
							style="background: url(${pageContext.request.contextPath}/static/images/568dfdbdN4f7d7ca3.png) no-repeat 0px -250px;"></i>
							<span class="ci-bottom">众筹</span>
					</a></li>
					<li><a href="#"> <i class="ci-left"
							style="background: url(${pageContext.request.contextPath}/static/images/568dfdbdN4f7d7ca3.png) no-repeat -25px -200px;"></i>
							<span class="ci-bottom">理财</span>
					</a></li>
					<li><a href="#"> <i class="ci-left"
							style="background: url(${pageContext.request.contextPath}/static/images/568dfdbdN4f7d7ca3.png) no-repeat -25px -275px;"></i>
							<span class="ci-bottom">礼品卡</span>
					</a></li>
					<li><a href="#"> <i class="ci-left"
							style="background: url(${pageContext.request.contextPath}/static/images/568dfdbdN4f7d7ca3.png) no-repeat -25px -225px;"></i>
							<span class="ci-bottom">白条</span>
					</a></li>
				</ul>

			</div>
		</div>
		<div class="focus-b">
			<ul>
				<li><a href="#">服装城</a></li>
				<li><a href="#">美妆馆</a></li>
				<li><a href="#">超市</a></li>
				<li><a href="#">全球购</a></li>
				<li><a href="#">闪购</a></li>
				<li><a href="#">团购</a></li>
				<li><a href="#">拍卖</a></li>
				<li><a href="#">金融</a></li>
			</ul>
		</div>
		<div class="focus-c">
			<a href="#"><img
				src="${pageContext.request.contextPath}/static/images/hhh.jpg"></a>
		</div>
		<div class="focus-d">
			<a href="#"><img
				src="${pageContext.request.contextPath}/static/images/nianhuo.jpg"></a>
		</div>
		<!--轮播图左边当行蓝-->
		<div class="bb"></div>
		<div class="dd-inner">
			<div class="font-item">
				<div class="item fore1">
					<h3>
						<a href="#">家用电器</a>
					</h3>
					<i>></i>
				</div>
				<div class="font-item1">
					<div class="font-lefty">
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
							</dl>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
							</dl>
					</div>
					<div class="font-right">
						<div>
							<a href="#"> <img src="./static/images/54d9ef4cN4fe57f9b.jpg">
							</a>
						</div>
					</div>
					<div class="font-righty">
						<a href="#"> <img src="./static/images/5673a854N10856704.jpg">
						</a> <a href="#"> <img src="./static/images/56a0376aN7de1bdcf.jpg">
						</a>
					</div>
				</div>
			</div>
			<div class="fore-2">
				<div class="item fore2">
					<h3>
						<a href="">手机、</a><a href="">数码、</a><a href="">京东通讯</a>
					</h3>
					<i>></i>
				</div>
				<div class="font-item1">
					<div class="font-lefty">
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
							</dl>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
							</dl>
					</div>
					<div class="font-right">
						<div>
							<a href="#"> <img src="./static/images/54d9ef4cN4fe57f9b.jpg">
							</a>
						</div>
					</div>
					<div class="font-righty">
						<a href="#"> <img src="./static/images/5673a854N10856704.jpg">
						</a> <a href="#"> <img src="./static/images/56a0376aN7de1bdcf.jpg">
						</a>
					</div>
				</div>
			</div>
			<div class="fore-3">
				<div class="item fore3">
					<h3>
						<a href="">电脑、</a> <a href="">办公</a>
					</h3>
					<i>></i>
				</div>
				<div class="font-item1">
					<div class="font-lefty">
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
							</dl>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
							</dl>
					</div>
					<div class="font-right">
						<div>
							<a href="#"> <img src="./static/images/54d9ef4cN4fe57f9b.jpg">
							</a>
						</div>
					</div>
					<div class="font-righty">
						<a href="#"> <img src="./static/images/5673a854N10856704.jpg">
						</a> <a href="#"> <img src="./static/images/56a0376aN7de1bdcf.jpg">
						</a>
					</div>
				</div>
			</div>
			<div class="fore-4">
				<div class="item fore4">
					<h3>
						<a href="##">家居、</a> <a href="##">家具、</a> <a href="##">家装、</a> <a
							href="##">厨具</a>
					</h3>
					<i>></i>
				</div>
				<div class="font-item1">
					<div class="font-lefty">
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
							</dl>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
							</dl>
					</div>
					<div class="font-right">
						<div>
							<a href="#"> <img src="./static/images/54d9ef4cN4fe57f9b.jpg">
							</a>
						</div>
					</div>
					<div class="font-righty">
						<a href="#"> <img src="./static/images/5673a854N10856704.jpg">
						</a> <a href="#"> <img src="./static/images/56a0376aN7de1bdcf.jpg">
						</a>
					</div>
				</div>
			</div>
			<div class="fore-5">
				<div class="item fore5">
					<h3>
						<a href="##">男装、</a> <a href="##">女装、</a> <a href="##">内衣、</a> <a
							href="##">珠宝</a>
					</h3>
					<i>></i>
				</div>
				<div class="font-item1">
					<div class="font-lefty">
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
							</dl>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
							</dl>
					</div>
					<div class="font-right">
						<div>
							<a href="#"> <img src="./static/images/54d9ef4cN4fe57f9b.jpg">
							</a>
						</div>
					</div>
					<div class="font-righty">
						<a href="#"> <img src="./static/images/5673a854N10856704.jpg">
						</a> <a href="#"> <img src="./static/images/56a0376aN7de1bdcf.jpg">
						</a>
					</div>
				</div>
			</div>
			<div class="fore-6">
				<div class="item fore6">
					<h3>
						<a href="">个人化妆、</a> <a href="">清洁用品</a>
					</h3>
					<i>></i>
				</div>
				<div class="font-item1">
					<div class="font-lefty">
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
							</dl>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
							</dl>
					</div>
					<div class="font-right">
						<div>
							<a href="#"> <img src="./static/images/54d9ef4cN4fe57f9b.jpg">
							</a>
						</div>
					</div>
					<div class="font-righty">
						<a href="#"> <img src="./static/images/5673a854N10856704.jpg">
						</a> <a href="#"> <img src="./static/images/56a0376aN7de1bdcf.jpg">
						</a>
					</div>
				</div>
			</div>
			<div class="fore-7">
				<div class="item fore7">
					<h3>
						<a href="">鞋靴、</a> <a href="">箱包、</a> <a href="">钟表、</a> <a
							href="">奢饰品</a>
					</h3>
					<i>></i>
				</div>
				<div class="font-item1">
					<div class="font-lefty">
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
							</dl>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
							</dl>
					</div>
					<div class="font-right">
						<div>
							<a href="#"> <img src="./static/images/54d9ef4cN4fe57f9b.jpg">
							</a>
						</div>
					</div>
					<div class="font-righty">
						<a href="#"> <img src="./static/images/5673a854N10856704.jpg">
						</a> <a href="#"> <img src="./static/images/56a0376aN7de1bdcf.jpg">
						</a>
					</div>
				</div>
			</div>
			<div class="fore-8">
				<div class="item fore8">
					<h3>
						<a href="">运动户外</a>
					</h3>
					<i>></i>
				</div>
				<div class="font-item1">
					<div class="font-lefty">
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
							</dl>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
							</dl>
					</div>
					<div class="font-right">
						<div>
							<a href="#"> <img src="./static/images/54d9ef4cN4fe57f9b.jpg">
							</a>
						</div>
					</div>
					<div class="font-righty">
						<a href="#"> <img src="./static/images/5673a854N10856704.jpg">
						</a> <a href="#"> <img src="./static/images/56a0376aN7de1bdcf.jpg">
						</a>
					</div>
				</div>
			</div>
			<div class="fore-9">
				<div class="item fore9">
					<h3>
						<a href="">汽车、</a> <a href="">汽车用品</a>
					</h3>
					<i>></i>
				</div>
				<div class="font-item1">
					<div class="font-lefty">
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
							</dl>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
							</dl>
					</div>
					<div class="font-right">
						<div>
							<a href="#"> <img src="./static/images/54d9ef4cN4fe57f9b.jpg">
							</a>
						</div>
					</div>
					<div class="font-righty">
						<a href="#"> <img src="./static/images/5673a854N10856704.jpg">
						</a> <a href="#"> <img src="./static/images/56a0376aN7de1bdcf.jpg">
						</a>
					</div>
				</div>
			</div>
			<div class="fore-10">
				<div class="item fore10">
					<h3>
						<a href="">母婴、</a> <a href="">玩具乐器</a>
					</h3>
					<i>></i>
				</div>
				<div class="font-item1">
					<div class="font-lefty">
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
							</dl>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
							</dl>
					</div>
					<div class="font-right">
						<div>
							<a href="#"> <img src="./static/images/54d9ef4cN4fe57f9b.jpg">
							</a>
						</div>
					</div>
					<div class="font-righty">
						<a href="#"> <img src="./static/images/5673a854N10856704.jpg">
						</a> <a href="#"> <img src="./static/images/56a0376aN7de1bdcf.jpg">
						</a>
					</div>
				</div>
			</div>
			<div class="fore-11">
				<div class="item fore11">
					<h3>
						<a href="">食品、</a> <a href="">酒类、</a> <a href="">生鲜、</a> <a
							href="">特产</a>
					</h3>
					<i>></i>
				</div>
				<div class="font-item1">
					<div class="font-lefty">
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
							</dl>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
							</dl>
					</div>
					<div class="font-right">
						<div>
							<a href="#"> <img src="./static/images/54d9ef4cN4fe57f9b.jpg">
							</a>
						</div>
					</div>
					<div class="font-righty">
						<a href="#"> <img src="./static/images/5673a854N10856704.jpg">
						</a> <a href="#"> <img src="./static/images/56a0376aN7de1bdcf.jpg">
						</a>
					</div>
				</div>
			</div>
			<div class="fore-12">
				<div class="item fore12">
					<h3>
						<a href="">营养保健</a>
					</h3>
					<i>></i>
				</div>
				<div class="font-item1">
					<div class="font-lefty">
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
							</dl>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
							</dl>
					</div>
					<div class="font-right">
						<div>
							<a href="#"> <img src="./static/images/54d9ef4cN4fe57f9b.jpg">
							</a>
						</div>
					</div>
					<div class="font-righty">
						<a href="#"> <img src="./static/images/5673a854N10856704.jpg">
						</a> <a href="#"> <img src="./static/images/56a0376aN7de1bdcf.jpg">
						</a>
					</div>
				</div>
			</div>
			<div class="fore-13">
				<div class="item fore13">
					<h3>
						<a href="">图书、</a> <a href="">音像、</a> <a href="">电子书</a>
					</h3>
					<i>></i>
				</div>
				<div class="font-item1">
					<div class="font-lefty">
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
							</dl>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
							</dl>
					</div>
					<div class="font-right">
						<div>
							<a href="#"> <img src="./static/images/54d9ef4cN4fe57f9b.jpg">
							</a>
						</div>
					</div>
					<div class="font-righty">
						<a href="#"> <img src="./static/images/5673a854N10856704.jpg">
						</a> <a href="#"> <img src="./static/images/56a0376aN7de1bdcf.jpg">
						</a>
					</div>
				</div>
			</div>
			<div class="fore-14">
				<div class="item fore14">
					<h3>
						<a href="">彩票、</a> <a href="">旅行、</a> <a href="">充值、</a> <a
							href="">票务</a>
					</h3>
					<i>></i>
				</div>
				<div class="font-item1">
					<div class="font-lefty">
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
							</dl>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
							</dl>
					</div>
					<div class="font-right">
						<div>
							<a href="#"> <img src="./static/images/54d9ef4cN4fe57f9b.jpg">
							</a>
						</div>
					</div>
					<div class="font-righty">
						<a href="#"> <img src="./static/images/5673a854N10856704.jpg">
						</a> <a href="#"> <img src="./static/images/56a0376aN7de1bdcf.jpg">
						</a>
					</div>
				</div>
			</div>
			<div class="fore-15">
				<div class="item fore15">
					<h3>
						<a href="">理财、</a> <a href="">众筹、</a> <a href="">白条、</a> <a
							href="">保险</a>
					</h3>
					<i>></i>
				</div>
				<div class="font-item1">
					<div class="font-lefty">
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">大家电</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">生活电器</a>
							</dt>
						</dl>
						<dl class="fore1">
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dt>
								<a
									href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">厨房电器</a>
							</dt>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">个护健康</a>
								</dt>
							</dl>
							<dl class="fore1">
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
								<dt>
									<a
										href="${pageContext.request.contextPath}/selectAllByCategory2.do?categoryId=2">五金家装</a>
								</dt>
							</dl>
					</div>
					<div class="font-right">
						<div>
							<a href="#"> <img src="./static/images/54d9ef4cN4fe57f9b.jpg">
							</a>
						</div>
					</div>
					<div class="font-righty">
						<a href="#"> <img src="./static/images/5673a854N10856704.jpg">
						</a> <a href="#"> <img src="./static/images/56a0376aN7de1bdcf.jpg">
						</a>
					</div>
				</div>
			</div>
		</div>
		<!--*****************轮播下方*****************-->
		<div id="guessyou" class="">
			<div class="mt">
				<h2>猜你喜欢</h2>
				<a href="shopdetial.html" class="extra">换一批</a>
			</div>
			<div class="list1">
				<div class="spacer">
					<i></i>
				</div>
				<ul>
					<!-- 第一个图片 -->
					<li class="fore1">
						<div class="p-img">
							<a
								href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[4].id }&name=${goods2[4].name}&price2=${goods2[4].price2.toString()}&xiaoliang=${goods2[4].xiaoLiang.toString()}
				&kucun=${goods2[4].kuCun.toString()}&baoyou=${goods2[4].baoYou.toString()}&source=${goods2[4].source}&intro=${goods2[4].intro}&imgs=${goods2[4].imgs}"
								target="_blank"> <img data-lazy-img="done" width="134"
								height="134" title="${goods2[4].name}"
								src="${pageContext.request.contextPath }/static/upload/${goods2[4].imgs}">
							</a>
						</div>
						<div class="p-info">
							<div class="p-name">
								<a
									href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[4].id }&name=${goods2[4].name}&price2=${goods2[4].price2.toString()}&xiaoliang=${goods2[4].xiaoLiang.toString()}
				&kucun=${goods2[4].kuCun.toString()}&baoyou=${goods2[4].baoYou.toString()}&source=${goods2[4].source}&intro=${goods2[4].intro}&imgs=${goods2[4].imgs}"
									target="_blank" title="${goods2[4].name}">${goods2[4].name}</a>
							</div>
							<div class="p-price" data-lazyload-fn="done">
								<i>¥</i>${goods2[4].price2}
							</div>
						</div>
					</li>

					<!-- 第二个图片 -->
					<li class="fore2">
						<div class="p-img">
							<a
								href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[5].id }&name=${goods2[5].name}&price2=${goods2[5].price2.toString()}&xiaoliang=${goods2[5].xiaoLiang.toString()}
				&kucun=${goods2[5].kuCun.toString()}&baoyou=${goods2[5].baoYou.toString()}&source=${goods2[5].source}&intro=${goods2[5].intro}&imgs=${goods2[5].imgs}"
								target="_blank"> <img data-lazy-img="done" width="134"
								height="134" title="${goods2[5].name}"
								src="${pageContext.request.contextPath }/static/upload/${goods2[5].imgs}">
							</a>
						</div>
						<div class="p-info">
							<div class="p-name">
								<a
									href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[5].id }&name=${goods2[5].name}&price2=${goods2[5].price2.toString()}&xiaoliang=${goods2[5].xiaoLiang.toString()}
				&kucun=${goods2[5].kuCun.toString()}&baoyou=${goods2[5].baoYou.toString()}&source=${goods2[5].source}&intro=${goods2[5].intro}&imgs=${goods2[5].imgs}"
									target="_blank" title="${goods2[5].name}">${goods2[5].name}</a>
							</div>
							<div class="p-price" data-lazyload-fn="done">
								<i>¥</i>${goods2[5].price2}
							</div>
						</div>
					</li>


					<li class="fore3">
						<div class="p-img">
							<a
								href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[6].id }&name=${goods2[6].name}&price2=${goods2[6].price2.toString()}&xiaoliang=${goods2[6].xiaoLiang.toString()}
				&kucun=${goods2[6].kuCun.toString()}&baoyou=${goods2[6].baoYou.toString()}&source=${goods2[6].source}&intro=${goods2[6].intro}&imgs=${goods2[6].imgs}"
								target="_blank"> <img data-lazy-img="done" width="130"
								height="130" title="${goods2[6].name}"
								src="${pageContext.request.contextPath }/static/upload/${goods2[6].imgs}">
							</a>
						</div>
						<div class="p-info">
							<div class="p-name">
								<a
									href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[6].id }&name=${goods2[6].name}&price2=${goods2[6].price2.toString()}&xiaoliang=${goods2[6].xiaoLiang.toString()}
				&kucun=${goods2[6].kuCun.toString()}&baoyou=${goods2[6].baoYou.toString()}&source=${goods2[6].source}&intro=${goods2[6].intro}&imgs=${goods2[6].imgs}"
									target="_blank" title="${goods2[6].name}">${goods2[6].name}</a>
							</div>
							<div class="p-price" data-lazyload-fn="done">
								<i>¥</i>${goods2[6].price2}
							</div>
						</div>
					</li>


					<li class="fore4">
						<div class="p-img">
							<a
								href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[7].id }&name=${goods2[7].name}&price2=${goods2[7].price2.toString()}&xiaoliang=${goods2[7].xiaoLiang.toString()}
				&kucun=${goods2[7].kuCun.toString()}&baoyou=${goods2[7].baoYou.toString()}&source=${goods2[7].source}&intro=${goods2[7].intro}&imgs=${goods2[7].imgs}"
								target="_blank"> <img data-lazy-img="done" width="130"
								height="130" title="${goods2[7].name}"
								src="${pageContext.request.contextPath }/static/upload/${goods2[7].imgs}">
							</a>
						</div>
						<div class="p-info">
							<div class="p-name">
								<a
									href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[7].id }&name=${goods2[7].name}&price2=${goods2[7].price2.toString()}&xiaoliang=${goods2[7].xiaoLiang.toString()}
				&kucun=${goods2[7].kuCun.toString()}&baoyou=${goods2[7].baoYou.toString()}&source=${goods2[7].source}&intro=${goods2[7].intro}&imgs=${goods2[7].imgs}"
									target="_blank" title="${goods2[7].name}">${goods2[7].name}</a>
							</div>
							<div class="p-price" data-lazyload-fn="done">
								<i>¥</i>${goods2[7].price2}
							</div>
						</div>
					</li>


					<li class="fore5">
						<div class="p-img">
							<a
								href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[8].id }&name=${goods2[8].name}&price2=${goods2[8].price2.toString()}&xiaoliang=${goods2[8].xiaoLiang.toString()}
				&kucun=${goods2[8].kuCun.toString()}&baoyou=${goods2[8].baoYou.toString()}&source=${goods2[8].source}&intro=${goods2[8].intro}&imgs=${goods2[8].imgs}"
								target="_blank"> <img data-lazy-img="done" width="130"
								height="130" title="${goods2[8].name}"
								src="${pageContext.request.contextPath }/static/upload/${goods2[8].imgs}">
							</a>
						</div>
						<div class="p-info">
							<div class="p-name">
								<a
									href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[8].id }&name=${goods2[8].name}&price2=${goods2[8].price2.toString()}&xiaoliang=${goods2[8].xiaoLiang.toString()}
				&kucun=${goods2[8].kuCun.toString()}&baoyou=${goods2[8].baoYou.toString()}&source=${goods2[8].source}&intro=${goods2[8].intro}&imgs=${goods2[8].imgs}"
									target="_blank" title="${goods2[8].name}">${goods2[8].name}</a>
							</div>
							<div class="p-price" data-lazyload-fn="done">
								<i>¥</i>${goods2[8].price2}
							</div>
						</div>
					</li>


					<li class="fore6">
						<div class="p-img">
							<a
								href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[9].id }&name=${goods2[9].name}&price2=${goods2[9].price2.toString()}&xiaoliang=${goods2[9].xiaoLiang.toString()}
				&kucun=${goods2[9].kuCun.toString()}&baoyou=${goods2[9].baoYou.toString()}&source=${goods2[9].source}&intro=${goods2[9].intro}&imgs=${goods2[9].imgs}"
								target="_blank"> <img data-lazy-img="done" width="130"
								height="130" title="${goods2[9].name}"
								src="${pageContext.request.contextPath }/static/upload/${goods2[9].imgs}">
							</a>
						</div>
						<div class="p-info">
							<div class="p-name">
								<a
									href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[9].id }&name=${goods2[9].name}&price2=${goods2[9].price2.toString()}&xiaoliang=${goods2[9].xiaoLiang.toString()}
				&kucun=${goods2[9].kuCun.toString()}&baoyou=${goods2[9].baoYou.toString()}&source=${goods2[9].source}&intro=${goods2[9].intro}&imgs=${goods2[9].imgs}"
									target="_blank" title="${goods2[9].name}">${goods2[9].name}</a>
							</div>
							<div class="p-price" data-lazyload-fn="done">
								<i>¥</i>${goods2[9].price2}
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
		<!--猜你喜欢结束-->

		<div class="footer-banner-1">
			<img src="${pageContext.request.contextPath}/static/images/kx.png"
				alt="">
		</div>
		<!--天天特价-->
		<div class="w clearfix lazy-fn lazy-fn-done" id="lazy-special">
			<div id="special">
				<div class="mt">
					<h2>天天低价</h2>
				</div>
				<div class="mc">
					<ul>

						<li class="fore1">
							<div class="p-img">
								<a
									href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[10].id }&name=${goods2[10].name}&price2=${goods2[10].price2.toString()}&xiaoliang=${goods2[10].xiaoLiang.toString()}
				&kucun=${goods2[10].kuCun.toString()}&baoyou=${goods2[10].baoYou.toString()}&source=${goods2[10].source}&intro=${goods2[10].intro}&imgs=${goods2[10].imgs}"
									target="_blank"><img
									src="${pageContext.request.contextPath }/static/upload/${goods2[10].imgs}"
									width="219" height="180" alt=""></a>
							</div>
							<div class="p-info">
								<div class="p-name">
									<a
										href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[10].id }&name=${goods2[10].name}&price2=${goods2[10].price2.toString()}&xiaoliang=${goods2[10].xiaoLiang.toString()}
				&kucun=${goods2[10].kuCun.toString()}&baoyou=${goods2[10].baoYou.toString()}&source=${goods2[10].source}&intro=${goods2[10].intro}&imgs=${goods2[10].imgs}"
										target="_blank">${goods2[10].name}</a>
								</div>
								<div class="p-price">
									<span>￥:${goods2[10].price2}元</span>
								</div>
							</div>
						</li>
						<li class="fore2">
							<div class="p-img">
								<a
									href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[11].id }&name=${goods2[11].name}&price2=${goods2[11].price2.toString()}&xiaoliang=${goods2[11].xiaoLiang.toString()}
				&kucun=${goods2[11].kuCun.toString()}&baoyou=${goods2[11].baoYou.toString()}&source=${goods2[11].source}&intro=${goods2[11].intro}&imgs=${goods2[11].imgs}"
									target="_blank"><img
									src="${pageContext.request.contextPath }/static/upload/${goods2[11].imgs}"
									width="100" height="100" alt=""></a>
							</div>
							<div class="p-info">
								<div class="p-name">
									<a
										href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[11].id }&name=${goods2[11].name}&price2=${goods2[11].price2.toString()}&xiaoliang=${goods2[11].xiaoLiang.toString()}
				&kucun=${goods2[11].kuCun.toString()}&baoyou=${goods2[11].baoYou.toString()}&source=${goods2[11].source}&intro=${goods2[11].intro}&imgs=${goods2[11].imgs}"
										target="_blank">${goods2[11].name}</a>
								</div>
								<div class="p-price">
									<span>￥:${goods2[11].price2}元</span>
								</div>
							</div>
						</li>
						<li class="fore3">
							<div class="p-img">
								<a
									href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[12].id }&name=${goods2[12].name}&price2=${goods2[12].price2.toString()}&xiaoliang=${goods2[12].xiaoLiang.toString()}
				&kucun=${goods2[12].kuCun.toString()}&baoyou=${goods2[12].baoYou.toString()}&source=${goods2[12].source}&intro=${goods2[12].intro}&imgs=${goods2[12].imgs}"
									target="_blank"><img
									src="${pageContext.request.contextPath }/static/upload/${goods2[12].imgs}"
									width="100" height="100" alt=""></a>
							</div>
							<div class="p-info">
								<div class="p-name">
									<a
										href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[12].id }&name=${goods2[12].name}&price2=${goods2[12].price2.toString()}&xiaoliang=${goods2[12].xiaoLiang.toString()}
				&kucun=${goods2[12].kuCun.toString()}&baoyou=${goods2[12].baoYou.toString()}&source=${goods2[12].source}&intro=${goods2[12].intro}&imgs=${goods2[12].imgs}"
										target="_blank">${goods2[12].name}</a>
								</div>
								<div class="p-price">
									<span>￥:${goods2[12].price2}元</span>
								</div>
							</div>
						</li>
						<li class="fore4">
							<div class="p-img">
								<a
									href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[13].id }&name=${goods2[13].name}&price2=${goods2[13].price2.toString()}&xiaoliang=${goods2[13].xiaoLiang.toString()}
				&kucun=${goods2[13].kuCun.toString()}&baoyou=${goods2[13].baoYou.toString()}&source=${goods2[13].source}&intro=${goods2[13].intro}&imgs=${goods2[13].imgs}"
									target="_blank"><img
									src="${pageContext.request.contextPath }/static/upload/${goods2[13].imgs}"
									width="100" height="100" alt=""></a>
							</div>
							<div class="p-info">
								<div class="p-name">
									<a
										href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[13].id }&name=${goods2[13].name}&price2=${goods2[13].price2.toString()}&xiaoliang=${goods2[13].xiaoLiang.toString()}
				&kucun=${goods2[13].kuCun.toString()}&baoyou=${goods2[13].baoYou.toString()}&source=${goods2[13].source}&intro=${goods2[13].intro}&imgs=${goods2[13].imgs}"
										target="_blank">${goods2[13].name}</a>
								</div>
								<div class="p-price">
									<span>￥:${goods2[13].price2}元</span>
								</div>
							</div>
						</li>
						<li class="fore5" clstag="h|keycount|21015|31a5">
							<div class="p-img">
								<a
									href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[14].id }&name=${goods2[14].name}&price2=${goods2[14].price2.toString()}&xiaoliang=${goods2[14].xiaoLiang.toString()}
				&kucun=${goods2[14].kuCun.toString()}&baoyou=${goods2[14].baoYou.toString()}&source=${goods2[14].source}&intro=${goods2[14].intro}&imgs=${goods2[14].imgs}"
									target="_blank"><img
									src="${pageContext.request.contextPath }/static/upload/${goods2[14].imgs}"
									width="100" height="100" alt=""></a>
							</div>
							<div class="p-info">
								<div class="p-name">
									<a
										href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[14].id }&name=${goods2[14].name}&price2=${goods2[14].price2.toString()}&xiaoliang=${goods2[14].xiaoLiang.toString()}
				&kucun=${goods2[14].kuCun.toString()}&baoyou=${goods2[14].baoYou.toString()}&source=${goods2[14].source}&intro=${goods2[14].intro}&imgs=${goods2[14].imgs}"
										target="_blank">${goods2[14].name}</a>
								</div>
								<div class="p-price">
									<span>￥:${goods2[14].price2}元</span>
								</div>
							</div>
						</li>
						<li class="fore6">
							<div class="p-img">
								<a
									href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[15].id }&name=${goods2[15].name}&price2=${goods2[15].price2.toString()}&xiaoliang=${goods2[15].xiaoLiang.toString()}
				&kucun=${goods2[15].kuCun.toString()}&baoyou=${goods2[15].baoYou.toString()}&source=${goods2[15].source}&intro=${goods2[15].intro}&imgs=${goods2[15].imgs}"
									target="_blank"><img
									src="${pageContext.request.contextPath }/static/upload/${goods2[15].imgs}"
									width="100" height="100" alt=""></a>
							</div>
							<div class="p-info">
								<div class="p-name">
									<a
										href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[15].id }&name=${goods2[15].name}&price2=${goods2[15].price2.toString()}&xiaoliang=${goods2[15].xiaoLiang.toString()}
				&kucun=${goods2[15].kuCun.toString()}&baoyou=${goods2[15].baoYou.toString()}&source=${goods2[15].source}&intro=${goods2[15].intro}&imgs=${goods2[15].imgs}"
										target="_blank">${goods2[15].name}</a>
								</div>
								<div class="p-price">
									<span>￥:${goods2[15].price2}元</span>
								</div>
							</div>
						</li>
						<li class="fore7">
							<div class="p-img">
								<a
									href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[16].id }&name=${goods2[16].name}&price2=${goods2[16].price2.toString()}&xiaoliang=${goods2[16].xiaoLiang.toString()}
				&kucun=${goods2[16].kuCun.toString()}&baoyou=${goods2[16].baoYou.toString()}&source=${goods2[16].source}&intro=${goods2[16].intro}&imgs=${goods2[16].imgs}"
									target="_blank"><img
									src="${pageContext.request.contextPath }/static/upload/${goods2[16].imgs}"
									width="100" height="100" alt=""></a>
							</div>
							<div class="p-info">
								<div class="p-name">
									<a
										href="${pageContext.request.contextPath }/shopdetial.jsp?goodsId=${goods2[16].id }&name=${goods2[16].name}&price2=${goods2[16].price2.toString()}&xiaoliang=${goods2[16].xiaoLiang.toString()}
				&kucun=${goods2[16].kuCun.toString()}&baoyou=${goods2[16].baoYou.toString()}&source=${goods2[16].source}&intro=${goods2[16].intro}&imgs=${goods2[16].imgs}"
										target="_blank">${goods2[16].name}</a>
								</div>
								<div class="p-price">
									<span>￥:${goods2[16].price2}元</span>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div class="ss" id="share">
				<div class="mt">
					<h2>热门晒单</h2>
				</div>
				<div class="mc">
					<div class="sw" style="position: relative;">
						<ul style="top: -720px; position: absolute;">
							<li clstag="h|keycount|2015|31b5" data-switchable-clone="1"
								style="display: list-item;">
								<div class="p-img">
									<a href="shopdetial.html"><img
										src="${pageContext.request.contextPath}/static/images/55d3f67aNc7bd1217.jpg"
										alt="" width="80" height="80"></a>
								</div>
								<div class="p-info">
									<div class="author-info">
										<img title="JalenChou1"
											src="${pageContext.request.contextPath}/static/images/56cfa1c4Nb5d69f89.jpg"
											alt="JalenChou1" width="28" height="28"> <span>JalenChou1</span>
									</div>
									<div class="p-detail">
										<a target="_blank" href="shopdetial.html">给老爸买的手机，昨天晚上下的单……
											<span class="icon-r">”</span>
										</a> <span class="detail-arrow">◆</span> <span class="icon-l">“</span>
									</div>
								</div>
							</li>
							<li clstag="h|keycount|2015|31b6" data-switchable-clone="1"
								style="display: list-item;">
								<div class="p-img">
									<a href="shopdetial.html" target="_blank"><img
										src="${pageContext.request.contextPath}/static/images/566e3801N5416f870.jpg"
										alt="电陶炉很好，拆开试了加热很快。" width="80" height="80"></a>
								</div>
								<div class="p-info">
									<div class="author-info">
										<img title="lhm9199"
											src="${pageContext.request.contextPath}/static/images/56cfa1ccN3dee9031.jpg"
											alt="lhm9199" width="28" height="28"> <span>lhm9199</span>
									</div>
									<div class="p-detail">
										<a target="_blank" href="shopdetial.html">电陶炉很好，拆开试了加热很快。
											<span class="icon-r">”</span>
										</a> <span class="detail-arrow">◆</span> <span class="icon-l">“</span>
									</div>
								</div>
							</li>

							<li style="display: list-item;">
								<div class="p-img">
									<a href="shopdetial.html" target="_blank"><img
										src="static/images/5668ee98N42fbbfc0.jpg" alt="" width="80"
										height="80"></a>
								</div>
								<div class="p-info">
									<div class="author-info">
										<img title="zhou-fei"
											src="static/images/56cfa1a3Ne51145d7.jpg" alt="zhou-fei"
											width="28" height="28"> <span>zhou-fei</span>
									</div>
									<div class="p-detail">
										<a target="_blank" href="shopdetial.html">质地轻薄挺好吸收的，淡淡的香味……
											<span class="icon-r">”</span>
										</a> <span class="detail-arrow">◆</span> <span class="icon-l">“</span>
									</div>
								</div>
							</li>
							<li style="display: list-item;" class="">
								<div class="p-img">
									<a href="shopdetial.html" target="_blank"><img
										src="static/images/56273f03N5d252709.jpg" alt="感觉还可以，相信京东"
										width="80" height="80"></a>
								</div>
								<div class="p-info">
									<div class="author-info">
										<img title="沈洪娟" src="static/images/56cfa1aaNea6b7699.jpg"
											alt="沈洪娟" width="28" height="28"> <span>沈洪娟</span>
									</div>
									<div class="p-detail">
										<a target="_blank" title="感觉还可以，相信京东" href="shopdetial.html">感觉还可以，相信京东
											<span class="icon-r">”</span>
										</a> <span class="detail-arrow">◆</span> <span class="icon-l">“</span>
									</div>
								</div>
							</li>
							<li style="display: list-item;" class="">
								<div class="p-img">
									<a href="shopdetial.html" target="_blank"><img
										src="static/images/56c2dd74N1bd18e2b.jpg"
										alt="台灯买来女儿很开心她说非常好用，京东值得肯定！" width="80" height="80"></a>
								</div>
								<div class="p-info">
									<div class="author-info">
										<img title="微笑xhq66" src="static/images/56cfa1b2N3f8a29be.jpg"
											alt="微笑xhq66" width="28" height="28"> <span>微笑xhq66</span>
									</div>
									<div class="p-detail">
										<a target="_blank" href="shopdetial.html">台灯买来女儿很开心她说非常好用……
											<span class="icon-r">”</span>
										</a> <span class="detail-arrow">◆</span> <span class="icon-l">“</span>
									</div>
								</div>
							</li>
							<li style="display: list-item;">
								<div class="p-img">
									<a href="shopdetial.html" target="_blank"><img
										src="static/images/56580901N2c691a23.jpg" alt="" width="80"
										height="80"></a>
								</div>
								<div class="p-info">
									<div class="author-info">
										<img src="static/images/56cfa1bbNc1ad9a8a.jpg" alt="药材公司办公室"
											width="28" height="28"> <span>药材公司办公室</span>
									</div>
									<div class="p-detail">
										<a target="_blank" href="shopdetial.html">本本今天收到了，真的好薄的好帅……
											<span class="icon-r">”</span>
										</a> <span class="detail-arrow">◆</span> <span class="icon-l">“</span>
									</div>
								</div>
							</li>
							<li class="ui-switchable-panel-selected"
								style="display: list-item;">
								<div class="p-img">
									<a href="shopdetial.html" target="_blank"><img
										src="${pageContext.request.contextPath}/static/images/55d3f67aNc7bd1217.jpg"
										alt="" width="80" height="80"></a>
								</div>
								<div class="p-info">
									<div class="author-info">
										<img title="JalenChou1"
											src="${pageContext.request.contextPath}/static/images/56cfa1c4Nb5d69f89.jpg"
											alt="JalenChou1" width="28" height="28"> <span>JalenChou1</span>
									</div>
									<div class="p-detail">
										<a target="_blank" href="shopdetial.html">给老爸买的手机，昨天晚上下的单……
											<span class="icon-r">”</span>
										</a> <span class="detail-arrow">◆</span> <span class="icon-l">“</span>
									</div>
								</div>
							</li>
							<li class="" style="display: list-item;">
								<div class="p-img">
									<a href="shopdetial.html" target="_blank"><img
										src="${pageContext.request.contextPath}/static/images/566e3801N5416f870.jpg"
										alt="" width="80" height="80"></a>
								</div>
								<div class="p-info">
									<div class="author-info">
										<img title="lhm9199"
											src="${pageContext.request.contextPath}/static/images/56cfa1ccN3dee9031.jpg"
											alt="lhm9199" width="28" height="28"> <span>lhm9199</span>
									</div>
									<div class="p-detail">
										<a target="_blank" href="shopdetial.html">电陶炉很好，拆开试了加热很快。
											<span class="icon-r">”</span>
										</a> <span class="detail-arrow">◆</span> <span class="icon-l">“</span>
									</div>
								</div>
							</li>
							<li style="display: list-item;">
								<div class="p-img">
									<a href="" target="_blank"><img
										src="${pageContext.request.contextPath}/static/images/5668ee98N42fbbfc0.jpg"
										alt="" width="80" height="80"></a>
								</div>
								<div class="p-info">
									<div class="author-info">
										<img title="zhou-fei"
											src="${pageContext.request.contextPath}/static/images/56cfa1a3Ne51145d7.jpg"
											alt="zhou-fei" width="28" height="28"> <span>zhou-fei</span>
									</div>
									<div class="p-detail">
										<a target="_blank" href="shopdetial.html">质地轻薄挺好吸收的，淡淡的香味……
											<span class="icon-r">”</span>
										</a> <span class="detail-arrow">◆</span> <span class="icon-l">“</span>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<!--index_ok-->
		</div>
		<!--***********************************************-->
		<div class="lazy-fn lazy-fn-done" id="lazy-footer">
			<div id="service-2014">
				<div class="slogen">
					<img src="${pageContext.request.contextPath}/static/images/duo.png"
						alt="">
				</div>
			</div>
			<div class="w">
				<div id="footer-2014">
					<div class="links">
						<a rel="nofollow" target="_blank" href="">关于我们</a>|<a href="">联系我们</a>|<a
							rel="nofollow" target="_blank" href="">商家入驻</a>|<a rel="nofollow"
							target="_blank" href="">营销中心</a>|<a rel="nofollow"
							target="_blank" href="">手机微购</a>|<a target="_blank" href="">友情链接</a>|<a
							target="_blank" href="">销售联盟</a>|<a href="" target="_blank">微购社区</a>|<a
							href="" target="_blank">微购公益</a>|<a href="" target="_blank">English
							Site</a>|<a href="" target="_blank">Contact Us</a>
					</div>
					<div class="copyright">
						<a target="_blank" href=""><img
							src="${pageContext.request.contextPath}/static/images/56a0a994Nf1b662dc.png">
							京公网安备 11000002000088号</a>&nbsp;&nbsp;|&nbsp;&nbsp;京ICP证070359号&nbsp;&nbsp;|&nbsp;&nbsp;<a
							target="_blank" href="">互联网药品信息服务资格证编号(京)-经营性-2014-0008</a>&nbsp;&nbsp;|&nbsp;&nbsp;新出发京零&nbsp;字第大120007号<br>
						<a rel="nofollow" href="" target="_blank">音像制品经营许可证苏宿批005号</a>&nbsp;&nbsp;|&nbsp;&nbsp;出版物经营许可证编号新出发(苏)批字第N-012号&nbsp;&nbsp;|&nbsp;&nbsp;互联网出版许可证编号新出网证(京)字150号<br>
						<a href="" target="_blank">网络文化经营许可证京网文[2014]2148-348号</a>&nbsp;&nbsp;违法和不良信息举报电话：4006561155&nbsp;&nbsp;Copyright&nbsp;©&nbsp;2004-2016&nbsp;&nbsp;京东JD.com&nbsp;版权所有<br>京东旗下网站：<a
							target="_blank" href="http://www.360top.com/">360TOP</a>&nbsp;&nbsp;<a
							href="" target="_blank">拍拍网</a>&nbsp;&nbsp;<a
							href="shopdetial.html" target="_blank">网银在线</a>
					</div>

					<div class="authentication">
						<a rel="nofollow" target="_blank" href=""> <img width="103"
							height="32" alt="经营性网站备案中心"
							src="${pageContext.request.contextPath}/static/images/54b8871eNa9a7067e.png"
							class="err-product">
						</a> <a rel="nofollow" target="_blank" id="urlknet" tabindex="-1"
							href=""> <img border="true" width="103" height="32"
							onclick="CNNIC_change('urlknet')" oncontextmenu="return false;"
							name="CNNIC_seal" alt="可信网站"
							src="${pageContext.request.contextPath}/static/images/54b8872dNe37a9860.png"
							class="err-product">
						</a> <a rel="nofollow" target="_blank" href=""> <img width="103"
							height="32" alt="网络警察"
							src="${pageContext.request.contextPath}/static/images/56a89b8fNfbaade9a.jpg"
							class="err-product">
						</a> <a rel="nofollow" target="_blank" href=""> <img width="103"
							height="32"
							src="${pageContext.request.contextPath}/static/images/54b8875fNad1e0c4c.png"
							class="err-product">
						</a> <a target="_blank" href=""><img width="103" height="32"
							src="${pageContext.request.contextPath}/static/images/5698dc03N23f2e3b8.jpg"></a>
						<a target="_blank" href=""><img width="103" height="32"
							src="${pageContext.request.contextPath}/static/images/5698dc16Nb2ab99df.jpg"></a>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</body>
</html>