<%@page import="entity.Goods"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="static/css/index.css" type="text/css" rel="stylesheet">

<title>selectAllByCategoryRes</title>
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
		<ul class="header-right">
			<li class="denglu"><a href="customer/login.html">您好，请登录</a> <a
				href="customer/regist.html" class="red">免费注册</a></li>
			<li class="shu"></li>
			<li class="denglu"><a href="showOrder.do">我的订单</a></li>
			<li class="shu"></li>
			<li class="my bj"><a href="shopdetial.html">我的微购</a> <i
				class="ci-right "> <s class="jt">◇</s>
			</i>
				<div class="my1">
					<div class="my2">
						<img src="./static/images/no-img_mid_.jpg">
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
						<li><a href="">我的资料</a></li>
					</ul>
				</div></li>
			<li class="shu"></li>
			<li class="denglu"><a href="">微购会员</a></li>
			<li class="shu"></li>
			<li class="shu"></li>
			<li class="kehu bj"><a href="">客户服务</a> <i class="ci-right ">
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
			<li class="daohang"><a href="shopdetial.html">网站导航</a> <i
				class="ci-right "> <s class="jt">◇</s>
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
			<a href=""><img src="./static/images/logo.png"></a>
		</div>
		<form action="${pageContext.request.contextPath }/goodsSelectByName.do" method="post">
		<div class="search">
		    <input type="text" name="name" value="${name}"class="text"  />
			<!-- <input type="text" value="家电一折抢" class="text" id="textt"> -->
		</div>
		<div class="search">
		    <input type="submit" value="搜索" class="button"/>
		</div>
		</form>
		<div class="right">
			<i class="gw-left"
				style="background: url(./static/images/jd2015img.png) 0 -58px no-repeat; width: 24px; height: 24px;"></i>
			<i class="gw-right"></i> <i class="gw-count">0</i> <a
				href="shopdetial.html">我的购物车</a>
			<div class="dorpdown-layer">
				<img src="./static/images/settleup-nogoods.png">
				购物车中还没有商品，赶紧选购吧！
			</div>
		</div>
	</div>

    <div class="clear"></div>

    <div id="navv">
		<div class="nav-img"
			style="background: url(./static/images/568a1258N2edec1ab.jpg) repeat-x"></div>
	</div>
	
	<div class="focus">
		<div class="focus-a">
			<div class="fouc-img1">
				<img src="./static/images/5689d4ebN19f155a6.jpg" class="nav-img2">
			</div>
			<div class="fouc-font">
				<a href="">商品</a>
			</div>
		</div>	
		<br><br><br><br>
			<div class="list1">
				<div class="spacer">
					<i></i>
				</div>
				
				<div style="width: 1500px; margin:0 auto;">
				<ul >
				<c:forEach items="${goods3}" var="good" varStatus="status">
					<li class="fore1" style="float:left;margin-left: 100px">
						<div class="p-img" >
							<a href="shopdetial.jsp?name=${good.name}&price2=${good.price2.toString()}&xiaoliang=${good.xiaoLiang.toString()}
							&kucun=${good.kuCun.toString()}&baoyou=${good.baoYou.toString()}&source=${good.source}&intro=${good.intro}&imgs=${good.imgs}" target="_blank"> <img
								data-lazy-img="done" width="130" height="130"
								title="${good.name}"
								src="${pageContext.request.contextPath }/static/upload/${good.imgs}" class="">
							</a>
						</div>
						<div class="p-info">
							<div class="p-name">
								<a href="shopdetial.jsp?name=${good.name}&price2=${good.price2.toString()}&xiaoliang=${good.xiaoLiang.toString()}
							&kucun=${good.kuCun.toString()}&baoyou=${good.baoYou.toString()}&source=${good.source}&intro=${good.intro}&imgs=${good.imgs}" target="_blank"
									title="${good.name }">${good.name}</a>
							</div>
							<div class="p-price" data-lazyload-fn="done">
								<i>¥</i>${good.price2 }
							</div>
						</div>
					</li>
					 <c:if test="${status.count}%4==0"><br></c:if>
				</c:forEach>
				</ul>
				</div>
				
			</div>
   </div>
		
</body>
</html>