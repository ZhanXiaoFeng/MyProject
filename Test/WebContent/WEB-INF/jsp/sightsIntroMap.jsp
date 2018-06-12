<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<title>厉害了，我的广西</title>
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

<script type="text/JavaScript"
	src="${pageContext.request.contextPath}/static/js/echarts.min.js"></script>
<script type="text/JavaScript"
	src="${pageContext.request.contextPath}/static/js/guangxi.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<link
	href="${pageContext.request.contextPath}/static/css/guangxi_map.css"
	rel="stylesheet" type="text/css" />
<style>
body {
	cursor: url('NWPen.cur'), auto;
}
</style>

<!--[if IE 7]><link rel="stylesheet" type="text/css" href="css/ie7.css"><![endif]-->
</head>

<body>
	<!--Header-->
	<div class="full-width-wrapper" id="header">
		<div class="full-width-wrapper" id="abstract-bg">
			<!--Banner-->
			<div class="fixed-width-wrapper" id="banner">
				<a href="index.html" title="" class="logo"><img
					src="${pageContext.request.contextPath}/static/images/logo.png"
					alt="Maxx - The Modern HTML template"></a>
				<ul class="social-network">
					<li><a href="#" title="Facebook"><img
							src="${pageContext.request.contextPath}/static/images/icons/facebook.png"
							alt=""></a></li>
					<li><a href="#" title="Twitter"><img
							src="${pageContext.request.contextPath}/static/images/icons/twitter.png"
							alt=""></a></li>
					<li><a href="#" title="Delicious"><img
							src="${pageContext.request.contextPath}/static/images/icons/delicious.png"
							alt=""></a></li>
				</ul>
			</div>
			<!--/Banner-->
			<!--Navigation + Search-->
			<div class="fixed-width-wrapper border-radius-5px"
				id="navigation-bar">
				<div id="g-navigation">
					<ul class="simple-drop-down-menu">
						<li class="home-page border-radius-left-5px"><a
							href="index.html">首页</a></li>
						<li class="current"><a href="sightsIntroMap.html" title="">风景如画</a>
						</li>
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
								<li><a href="services.html" title="">Our Services</a>
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
			<div id="content" class="fixed-width-wrapper">
				<div class="header-text">
					<ul id="breadcrumbs">
						<li><a href="index.html" title="">Home</a></li>
						<li class="current"><a href="sightsIntroMap.html" title="">风景如画</a></li>
					</ul>
					<h1 class="first-word double-color sp">Our Services</h1>
				</div>
				<div class="portfolio">



					<!--Porfolio Content-->
					<div class="portfolio-content three-column clear" id="map"></div>
					<script>
						$(document).ready(function() {
							$("#map").load("guangXiMap.html");
						});
					</script>

				</div>
				<!--/Porfolio Content-->

			</div>
		</div>
		<!--/Content-->
		<!--Get in touch-->
		<div id="get-in-touch" class="fixed-width-wrapper">
			<div class="via-phone-number float-left"></div>
			<div class="via-email float-right"></div>
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