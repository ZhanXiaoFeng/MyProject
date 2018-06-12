<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>厉害了，我的广西</title>
<link rel="Shortcut Icon" href="favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/reset.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/base.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/tipTip.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/short-code.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/prettyPhoto.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/css3.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/slider.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/reset.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/hoverex-all.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/templates.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery.hoverex.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery.nivo.slider.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/cufon-yui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/TitilliumText.font.js"></script>
<!--<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/cufon-replace.js"></script>-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/scripts.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/custom.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/shortcode.js"></script>

<script type="text/javascript">
	function openWin(url, width, height, windowName, otherOptions) {
		if (typeof (url) == "undefined") {
			url = "";
		}
		if (typeof (width) == "undefined") {
			width = 1000;
		}
		if (typeof (height) == "undefined") {
			height = 600;
		}
		var left = (screen.availWidth - width) / 2;
		var top = (screen.availHeight - height) / 2;
		if (typeof (windowName) == "undefined" || windowName == "") {
			windowName = new Date().getTime();
		}
		if (typeof (otherOptions) == "undefined") {
			otherOptions = "alwaysRaised=no,location=no,menubar=no,resizable=no,scrollbars=no,titlebar=no,toolbar=no";
		}
		window.open(url, windowName, " left=" + left + ",top=" + top
				+ ",width=" + width + ",height=" + height + "," + otherOptions);
	}
</script>


<style>
body {
	cursor: url('NWPen.cur'), auto;
}
</style>
<!--[if IE 7]><link rel="stylesheet" type="text/css" href="css/ie7.css"><![endif]-->
</head>

<body class="home" onload="loadpopup()">
	<audio autoplay="autoplay"   loop="-1"> <source
		src="${pageContext.request.contextPath}/static/music/m.mp3"
		type="audio/mpeg" volume="10"></audio>

	<!--<*embed  type="audio/x-pn-realaudio-plugin" autostart="true" loop="true" hidden="true" src="music/m.mp3" ></embed>-->
	<!--Header-->
	<div class="full-width-wrapper" id="header">
		<div class="full-width-wrapper" id="abstract-bg">
			<!--Banner-->
			<div class="fixed-width-wrapper" id="banner">
				<a href="index.html" title="" class="logo"><img
					src="${pageContext.request.contextPath}/static/images/logo.png"
					alt="Maxx - The Modern HTML template"></a>
				<ul class="social-network">
					<li>
							<a href="#" title="Weibo"><img src="${pageContext.request.contextPath}/static/images/icons/weibo.png" alt=""></a>
						</li>
						<li>
							<a href="#" title="QQ"><img src="${pageContext.request.contextPath}/static/images/icons/qq.jpg" alt=""></a>
						</li>
						<li>
							<a href="#" title="WeiXin"><img src="${pageContext.request.contextPath}/static/images/icons/weixin.jpg" alt=""></a>
						</li>
				</ul>
			</div>
			<!--/Banner-->
			<!--Navigation + Search-->
			<div class="fixed-width-wrapper border-radius-5px"
				id="navigation-bar">
				<div id="g-navigation">
					<ul class="simple-drop-down-menu">
						<li class="home-page current border-radius-left-5px"><a
							href="index.html">首页</a></li>
						<li><a href="sightsIntroMap.html" title="">风景如画</a></li>
						<li><a href="services.html" title="">社会服务</a>
						</li>
						<li><a
							href="${pageContext.request.contextPath}/foodsIntro.do" title="">美食文化</a></li>
						<li><a href="blog.html" title="">记忆与分享</a>
						</li>
						<li><a href="contact.html" title="">关于我们</a></li>
					</ul>
				</div>
				<div id="g-search">
					<form action="" method="post">
						<div>
							<input type="text"
								class="input-field border-radius-left-3px reset-text"
								value="Search here...">
						</div>
						<div>
							<button type="submit" title="Search" class="sprite">
								<em>Search</em>
							</button>
						</div>
					</form>
				</div>
			</div>
			<!--/Navigation + Search-->
		</div>
	</div>
	<!--/Header-->
	<!--/Header-->
	<!--Slider-->
	<div class="clear" id="slider-bg">
		<div class="full-width-wrapper" id="slider-frame">
			<div class="fixed-width-wrapper maxx-theme" id="slider-wrapper">
				<div id="slider" class="nivoSlider">
					<a href="#"><img
						src="${pageContext.request.contextPath}/static/images/pix/slide1.jpg"
						alt="" title="#htmlcaption"></a> <a href="#"><img
						src="${pageContext.request.contextPath}/static/images/pix/slide2.jpg"
						alt="" title=""></a> <a href="#"><img
						src="${pageContext.request.contextPath}/static/images/pix/slide3.jpg"
						alt="" title="#htmlcaption2"></a> <a href="#"><img
						src="${pageContext.request.contextPath}/static/images/pix/slide4.jpg"
						alt="" title=""></a> <a href="#"><img
						src="${pageContext.request.contextPath}/static/images/pix/slide5.jpg"
						alt="" title="#htmlcaption3"></a>
				</div>
				<div id="htmlcaption" class="nivo-html-caption">
					<h1>New development of the new era</h1>
					<strong>This</strong> is an new <em>GUANG XI</em> <a href="#">learn
						more</a>.
				</div>
				<div class="copyrights">
					Collect from <a href="http://www.ronghc.cn/" title="新时代，新发展">新时代，新发展</a>
				</div>
				<div id="htmlcaption2" class="nivo-html-caption">
					<h1>New development of the new era</h1>
					<strong>This</strong> is an new <em>GUANG XI</em> <a href="#">&nbsp;&nbsp;learn
						more</a>.
				</div>
				<div id="htmlcaption3" class="nivo-html-caption">
					<h1>New development of the new era</h1>
					<strong>This</strong> is an new <em>GUANG XI</em> <a href="#">learn
						more</a>.
				</div>
			</div>
		</div>
	</div>
	<!--/Slider-->
	<!--Body content-->
	<div class="full-width-wrapper">
		<div class="fixed-width-wrapper body-divider " id="body-content">
			<!--Entry-->
			<div class="entry three-column fixed-width-wrapper">
				<!--block-->
				<div class="block type1">
					<h1 class="first-word double-color">Develop 美丽广西</h1>
					<div class="content">
						<a href="#" title=""
							class="preloading-light img-border align-none"><img
							src="${pageContext.request.contextPath}/static/images/pix/slide1.jpg"
							width="280" alt=""></a>
						<div class="clear"></div>
						<p style="font-size: 14px; line-height: 25px;">
							2017年以来，我区认真贯彻落实习近平总书记在党的十九大报告和“一带一路”国际合作高峰论坛以及视察广西等重要讲话精神，紧紧围绕中央赋予的“三大定位”历史使命，狠抓各项工作，“一带一路”建设取得显著成效。
							广西与“一带一路”国家互联互通不断拓展，广西在<a
								href="http://v.ifeng.com/include/exterior.swf?guid=9c39ca53-0150-46d7-8cee-fcfb767cfd81&AutoPlay=false"
								class="tipMe" title="“一带一路”">“一带一路” </a>上发展的新脉络不断延伸。
						</p>

					</div>
					<a class="read-more" href="#" title="Read more">Read more</a>
				</div>
				<!--/block-->
				<!--block-->
				<div class="block type2">
					<div class="clear"></div>
					<h1 class="first-word double-color">Cultural 人文景观</h1>
					<div class="content">
						<ul class="zigzag list">
							<li style="font-size: 14px; line-height: 24px;"><img
								src="${pageContext.request.contextPath}/static/images/icons/lijiang.jpg"
								alt="" class="align-right"><strong>桂林山水甲天下</strong><span>桂林是世界著名的风景游览城市，有着举世无双的喀斯特地貌。这里的山，平地拔起，千姿百态；漓江的水，蜿蜒曲折，明洁如镜....
							</span> <a href="#" title="">more</a></li>
							<li style="font-size: 14px; line-height: 24px;"><img
								src="${pageContext.request.contextPath}/static/images/icons/yintan.jpg"
								alt="" class="align-left"><strong>北海银滩-天下第一滩</strong><span>在银滩长达七八个月的诱人泳季，在蓝天白云下沐浴着灿烂的阳光，在洁白的沙滩上游玩嬉戏，在轻柔的波浪中尽情畅游，在微腥阵阵的海风中冥想；乘海上降落伞翱翔蓝天，驾惊险刺激的摩托艇....
							</span> <a href="#" title="">more</a></li>

						</ul>
					</div>
					<a class="read-more" href="#" title="Read more">Read more</a>
				</div>
				<!--/block-->
				<!--block-->
				<div class="block type3">
					<h1 class="first-word double-color">News 新闻大事件</h1>

					<div class="content">
						<p style="font-size: 14px;">新闻资讯早知道，看看最近都发生了哪些大事件。关注广西动态，获取发展资讯。</p>
						<ul class="list point" style="font-size: 14px;">
							<li><a href="javascript:void(0)"
								onclick="openWin('news_detail1.html',1000,600,'News 新闻大事件','location=no')"
								title=""><em>1.</em>“互联网+”助力广西靖西县旅游二次创业</a></li>
							<li><a href="javascript:void(0)"
								onclick="openWin('news_detail2.html',1000,600,'News 新闻大事件','location=no')"
								title=""><em>2.</em>“广西旅游号”动车今日启程 提升八桂旅游知名度</a></li>
							<li><a href="javascript:void(0)"
								onclick="openWin('news_detail3.html',1000,600,'News 新闻大事件','location=no')"
								title=""><em>3.</em>广西油茶产业跃居全国前三强 产业规模十年增十倍</a></li>
							<li><a href="javascript:void(0)"
								onclick="openWin('news_detail4.html',1000,600,'News 新闻大事件','location=no')"
								title=""><em>4.</em>"一带一路"国际合作高峰论坛举行广西专场记者会</a></li>
							<li><a href="javascript:void(0)"
								onclick="openWin('news_detail5.html',1000,600,'News 新闻大事件','location=no')"
								title=""><em>5.</em>【喜迎十九大】创新铸造“活力广西”</a></li>
						</ul>
					</div>
					<a class="read-more" href="#" title="Read more">Read more</a>
				</div>
				<!--/block-->
			</div>
			<!--/Entry-->

			<!--图片展示          	
                -->
			<div class="page a_slow elasticInLeft">

				<!--template 4-->
				<div class="title cf">

					<h1 class="first-word double-color">Foods 舌尖上的广西</h1>
				</div>
				<div class="demowrap cf">
					<ul>
						<li class="boxner">
							<div class="box">
								<div class="he-wrap tpl4">
									<img
										src="${pageContext.request.contextPath}/static/images/foods/mifen.jpg"
										alt="" />
									<div class="he-view">
										<div class="bg">
											<div class="a0" data-animate="fadeInDown"></div>
											<div class="a0" data-animate="fadeInUp"></div>
											<div class="a0" data-animate="fadeInDown"></div>
											<div class="a0" data-animate="fadeInUp"></div>
											<div class="a0" data-animate="fadeInDown"></div>
										</div>
										<div class="content">
											<h3 class="info-title a2" data-animate="fadeInDown">桂林米粉</h3>
											<div class="detail a2" data-animate="fadeInUp">桂林米粉以其独特的风味远近闻名，其做工考究，先将上好大米磨成浆，装袋滤干，揣成粉团煮熟后压榨成圆根或片状即成。
											</div>
											<a href="#" class="more a2" data-animate="fadeInRight">查看Detail</a>
										</div>
									</div>
								</div>
							</div>
						</li>
						<li class="boxner">

							<div class="box">
								<div class="he-wrap tpl4">
									<img
										src="${pageContext.request.contextPath}/static/images/foods/zhibaoji.jpg"
										alt="" />
									<div class="he-view">
										<div class="bg">
											<div class="a0" data-animate="fadeIn"></div>
											<div class="a1" data-animate="fadeIn"></div>
											<div class="a2" data-animate="fadeIn"></div>
											<div class="a3" data-animate="fadeIn"></div>
											<div class="a4" data-animate="fadeIn"></div>
										</div>
										<div class="content">
											<h3 class="info-title a3" data-animate="rotateInLeft">梧州纸包鸡</h3>
											<div class="detail a4" data-animate="rotateInLeft">梧州纸包鸡色泽金黄，香味诱人。吃起来，入口甘、滑、甜、软，食后齿颊留香。</div>
											<a href="#" class="more a5" data-animate="fadeInUp">查看Detail</a>
										</div>
									</div>
								</div>
							</div>
						</li>
						<li class="boxner">

							<div class="box">
								<div class="he-wrap tpl4">
									<img
										src="${pageContext.request.contextPath}/static/images/foods/zhujiaofen.jpg"
										alt="" />
									<div class="he-view">
										<div class="bg">
											<div class="a0" data-animate="fadeInUp"></div>
											<div class="a1" data-animate="fadeInUp"></div>
											<div class="a2" data-animate="fadeInUp"></div>
											<div class="a3" data-animate="fadeInUp"></div>
											<div class="a4" data-animate="fadeInUp"></div>
										</div>
										<div class="content">
											<h3 class="info-title a3" data-animate="fadeInLeft">钦州猪脚粉</h3>
											<div class="detail a4" data-animate="fadeInRight">在钦州,有“钦州猪脚粉，神仙也打滚”的说法。钦州猪脚粉是一种以猪脚为主、润滑可口的钦州传统特色小吃。</div>
											<a href="#" class="more a5" data-animate="fadeInRight">查看Detail</a>
										</div>
									</div>
								</div>
							</div>
				</div>
				</li>
				</ul>
			</div>

			<!--图片end--->

			<!--Get in touch-->
			<div id="get-in-touch" class="fixed-width-wrapper">
				<div class="via-phone-number float-left">
					<a class="icon sprite float-left" title="Keep in touch with us">Keep
						in touch with us</a>
					<h2>
						We can Help You. Call Us <strong>+ 1 800 123 4567</strong>
					</h2>
					<span>Keep in touch with our news and receive FREE THEMES</span>
				</div>
				<div class="via-email float-right">
					<form action="" method="post">
						<div>
							<input
								class="input-field border-radius-3px reset-text float-left"
								value="Enter your E-mail address...">
						</div>
						<div>
							<button type="submit" class="black border-radius-3px float-right">
								<em class="sprite"></em>Subcribe !
							</button>
						</div>
					</form>
				</div>
			</div>
			<!--/Get in touch-->
		</div>
	</div>
	<!--/Body content-->

	<!--Footer Extra-->
	<div class="full-width-wrapper" id="footer-extra-wrapper">
		<div class="fixed-width-wrapper">
			<div id="copyright">
				<a href="#" class="logo float-left" title=""><img
					src="${pageContext.request.contextPath}/static/images/logo-footer.png"
					alt=""></a>
				<ul>
					<li>(c) Copyright 2018 lenovo. All Rights Reserved.</li>
					<li><a href="#" title="">广西师范大学15计本3班</a></li>
					<li><a href="#" title="">邮编：541006</a></li>

					<li><a href="http://www.ronghc.cn" title="">厉害了，我的广西</a></li>
				</ul>
				<a href="#" class="back-to-top sprite" title="Back to top">Back
					to top</a>
			</div>
		</div>
	</div>
	<!--/Footer Extra-->

</body>

</html>