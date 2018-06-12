<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery-1.6.4.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery.nivo.slider.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/cufon-yui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/TitilliumText.font.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/cufon-replace.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/scripts.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/custom.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/shortcode.js"></script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/css/normalizes.css" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/static/css/jquery.classyleaves.min.css" />
<!--[if IE 7]><link rel="stylesheet" type="text/css" href="css/ie7.css"><![endif]-->
<style>
body {
	cursor: url('NWPen.cur'), auto;
}
</style>
</head>

<body>

	<script
		src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/jquery.rotate.js"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/jquery.classyleaves.min.js"></script>
	<script>
		$(document).ready(function() {
			var tree = new ClassyLeaves({
				leaves : 30,
				maxY : -10,
				multiplyOnClick : true,
				multiply : 2,
				infinite : true,
				speed : 4000
			});
			$('body').on('click', '.addLeaf', function() {
				console.log('8');
				tree.add(8);
				return false;
			});
		});
	</script>

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
							<ul>
								<li><a href="index.html" title="">Home Nivo Slider</a></li>
								<li><a href="index-3d-slider.html" title="">Home 3D
										Piece Maker</a></li>
								<li><a href="404.html" title="">404 page</a></li>
								<li><a href="#" title="">Demo submenu</a>
									<ul>
										<li><a href="#" title="">Sub menu 1</a></li>
										<li><a href="#" title="">Sub menu 2</a></li>
										<li><a href="#" title="">Sub menu 3</a></li>
										<li><a href="#" title="">Sub menu 4</a></li>
										<li><a href="#" title="">Sub menu 5</a></li>
									</ul></li>
								<li><a href="Services.html" title="">Our Services</a>
							</ul></li>
						<li><a
							href="${pageContext.request.contextPath}/foodsIntro.do" title="">美食文化</a></li>
						<li><a href="blog.html" title="">记忆与分享</a>
							<ul>
								<li><a href="blog.html" title="">Blog post</a></li>
								<li><a href="blog-detail.html" title="">Single posts</a></li>
								<li><a href="full-width.html" title="">Full-Width</a></li>
								<li><a href="short-code.html" title="">Shortcode</a></li>
							</ul></li>
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
	<!--Body content-->
	<div class="full-width-wrapper">
		<div class="fixed-width-wrapper" id="body-content">
			<!--Content-->
			<div id="content" class="float-left content-left">
				<div class="header-text">
					<ul id="breadcrumbs">
						<li><a href="#" title="">Home</a></li>
						<li class="current"><a href="#" title="">About us</a></li>
					</ul>
					<h1 class="first-word double-color sp">About us</h1>
				</div>
				<div class="post entry-content">
					<h2>About Our Website</h2>
					<p style="font-size: 14px;">
						本网站由广西师范大学计算机科学与信息工程学院学生开发,
						网站数据库采用MYSQL,使用SSM框架开发后台，前端技术用到HTML5+CSS、javascript、jQuery、json等.<strong>开发工具为eclipse、HBuilder</strong>
					</p>
					<p style="font-size: 14px;">
						网站域名为： <a href="www.ronghc.cn" title="">www.ronghc.cn</a>.
						网站功能比较简单，主要介绍了广西的发展情况。
					</p>
					<div class="first one-half address">
						<h3 class="first-word">Our Address</h3>
						<span class="map-point"></span>
						<p>
							<strong>广西桂林市雁山区雁中路1号</strong><br>广西师范大学
						</p>
						<p>Tell: + 15607835514</p>
						<p>
							Email: <a href="#" title="">hcr_gxnu@163.com</a><br>Website:
							<strong>www.ronghc.cn</strong>
						</p>
					</div>
					<div class="one-half address">
						<h3 class="first-word">Design</h3>
						<span class="map-point"></span>
						<p>
							<strong>厉害了，我的广西</strong><br>2018年05月15日
						</p>
						<p>Tell: + 0080.0123 456 789</p>
						<p>
							Email: <a href="#" title="">info@maxxd.com</a><br>Website: <strong>www.maxxd.com</strong>
						</p>
					</div>
					<div class="clear"></div>

				</div>
			</div>
			<!--/Content-->
			<!--Sidebar-->
			<div id="sidebar" class="float-right">
				<!--box-->
				<div class="box">
					<h1 class="first-word double-color sp">Locate us</h1>
					<div class="img-border preloading-light">
						<img
							src="${pageContext.request.contextPath}/static/images/pix/address.jpg"
							alt="">
					</div>
				</div>
				<!--/box-->
			</div>
			<!--/Sidebar-->
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