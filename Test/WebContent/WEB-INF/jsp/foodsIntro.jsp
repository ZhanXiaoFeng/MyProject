<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	src="${pageContext.request.contextPath}/static/js/TitilliumText.font.js"></script>

<!--  -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/cufon-yui.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/cufon-replace.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/scripts.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/custom.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/shortcode.js"></script>
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
								<li><a href="services.html" title="">Our Services</a>
							</ul></li>
						<li class="current"><a
							href="${pageContext.request.contextPath}/foodsIntro.do" title="">美食文化</a>
						</li>
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
						<li class="current"><a
							href="${pageContext.request.contextPath}/foodsIntro.do" title="">美食文化</a></li>
					</ul>
					<h1 class="first-word double-color sp">Our Services</h1>
				</div>
				<div class="portfolio">
					<ul class="portfolio-main filter">
						<li class="active all-projects"><a href="" title="">所有美食文化</a></li>
						<li class="cat-item 特色粉"><a href="" title="">特色粉</a></li>
						<li class="cat-item 特色鱼"><a href="" title="">特色鱼</a></li>
						<li class="cat-item 特色荤"><a href="" title="">特色荤</a></li>
						<li class="cat-item 特色小吃"><a href="" title="">特色小吃</a></li>
					</ul>
					<!--Porfolio Content-->
					<div class="portfolio-content three-column clear">
						<div data-id="post-1" data-type="特色鱼" class="block">
							<a
								href="${pageContext.request.contextPath}/static/upload/${pics2[0].imgs }"
								title="${pics2[0].name }"
								class="img-border preloading-light align-none project-thumbnail image-preview"><img
								src="${pageContext.request.contextPath}/static/upload/${pics2[0].imgs }"
								style="width: 286px; height: 150px;" alt=""></a>
							<h3 class="first-word">${pics2[0].name }</h3>
							<p>${fn:substring(pics2[0].intro,0,46)}...</p>
							<a class="read-more" href="#" title="Read more">Read more</a>
							<div class="sp"></div>
						</div>

						<div data-id="post-2" data-type="特色粉" class="block">
							<a
								href="${pageContext.request.contextPath}/static/upload/${pics2[1].imgs }"
								title="${pics2[1].name }"
								class="img-border preloading-light align-none project-thumbnail video-preview"><img
								src="${pageContext.request.contextPath}/static/upload/${pics2[1].imgs }"
								alt="" style="width: 286px; height: 150px;"></a>
							<h3 class="${pageContext.request.contextPath}/static/first-word">${pics2[1].name }</h3>
							<p>${fn:substring(pics2[1].intro,0,46)}...</p>
							<a class="read-more" href="#" title="Read more">Read more</a>
							<div class="sp"></div>
						</div>

						<div data-id="post-3" data-type="特色鱼" class="block">
							<a
								href="${pageContext.request.contextPath}/static/upload/${pics2[2].imgs }"
								title="${pics2[2].name }"
								class="img-border preloading-light align-none project-thumbnail image-preview"><img
								src="${pageContext.request.contextPath}/static/upload/${pics2[2].imgs }"
								alt="" style="width: 286px; height: 150px;"></a>
							<h3 class="first-word">${pics2[2].name }</h3>
							<p>${fn:substring(pics2[2].intro,0,46)}...</p>
							<a class="read-more" href="#" title="Read more">Read more</a>
							<div class="sp"></div>
						</div>

						<div data-id="post-4" data-type="特色粉" class="block">
							<a
								href="${pageContext.request.contextPath}/static/upload/${pics2[3].imgs }"
								title="${pics2[3].name }"
								class="img-border preloading-light align-none project-thumbnail image-preview"><img
								src="${pageContext.request.contextPath}/static/upload/${pics2[3].imgs }"
								alt="" style="width: 286px; height: 150px;"></a>
							<h3 class="first-word">${pics2[3].name }</h3>
							<p>${fn:substring(pics2[3].intro,0,46)}...</p>
							<a class="read-more" href="#" title="Read more">Read more</a>
							<div class="sp"></div>
						</div>

						<div data-id="post-5" data-type="特色荤" class="block">
							<a
								href="${pageContext.request.contextPath}/static/upload/${pics2[4].imgs }"
								title="${pics2[4].name }"
								class="img-border preloading-light align-none project-thumbnail image-preview"><img
								src="${pageContext.request.contextPath}/static/upload/${pics2[4].imgs }"
								alt="" style="width: 286px; height: 150px;"></a>
							<h3 class="first-word">${pics2[4].name }</h3>
							<p>${fn:substring(pics2[4].intro,0,46)}...</p>
							<a class="read-more" href="#" title="Read more">Read more</a>
							<div class="sp"></div>
						</div>

						<div data-id="post-6" data-type="特色粉" class="block">
							<a
								href="${pageContext.request.contextPath}/static/upload/${pics2[5].imgs }"
								title="${pics2[5].name }"
								class="img-border preloading-light align-none project-thumbnail image-preview"><img
								src="${pageContext.request.contextPath}/static/upload/${pics2[5].imgs }"
								alt="" style="width: 286px; height: 150px;"></a>
							<h3 class="first-word">${pics2[5].name }</h3>
							<p>${fn:substring(pics2[5].intro,0,46)}...</p>
							<a class="read-more" href="#" title="Read more">Read more</a>
							<div class="sp"></div>
						</div>

						<div data-id="post-7" data-type="特色荤" class="block">
							<a
								href="${pageContext.request.contextPath}/static/upload/${pics2[6].imgs }"
								title="${pics2[6].name }"
								class="img-border preloading-light align-none project-thumbnail image-preview"><img
								src="${pageContext.request.contextPath}/static/upload/${pics2[6].imgs }"
								alt="" style="width: 286px; height: 150px;"></a>
							<h3 class="first-word">${pics2[6].name }</h3>
							<p>${fn:substring(pics2[6].intro,0,46)}...</p>
							<a class="read-more" href="#" title="Read more">Read more</a>
							<div class="sp"></div>
						</div>

						<div data-id="post-8" data-type="特色鱼" class="block">
							<a
								href="${pageContext.request.contextPath}/static/upload/${pics2[7].imgs }"
								title="${pics2[7].name }"
								class="img-border preloading-light align-none project-thumbnail image-preview"><img
								src="${pageContext.request.contextPath}/static/upload/${pics2[7].imgs }"
								alt="" style="width: 286px; height: 150px;"></a>
							<h3 class="first-word">${pics2[7].name }</h3>
							<p>${fn:substring(pics2[7].intro,0,46)}...</p>
							<a class="read-more" href="#" title="Read more">Read more</a>
							<div class="sp"></div>
						</div>

						<div data-id="post-9" data-type="特色小吃" class="block">
							<a
								href="${pageContext.request.contextPath}/static/upload/${pics2[8].imgs }"
								title="${pics2[8].name }"
								class="img-border preloading-light align-none project-thumbnail image-preview"><img
								src="${pageContext.request.contextPath}/static/upload/${pics2[8].imgs }"
								alt="" style="width: 286px; height: 150px;"></a>
							<h3 class="first-word">${pics2[8].name }</h3>
							<p>${fn:substring(pics2[8].intro,0,46)}...</p>
							<a class="read-more" href="#" title="Read more">Read more</a>
							<div class="sp"></div>
						</div>

						<div data-id="post-10" data-type="特色鱼" class="block">
							<a
								href="${pageContext.request.contextPath}/static/upload/${pics2[9].imgs }"
								title="${pics2[9].name }"
								class="img-border preloading-light align-none project-thumbnail image-preview"><img
								src="${pageContext.request.contextPath}/static/upload/${pics2[9].imgs }"
								alt="" style="width: 286px; height: 150px;"></a>
							<h3 class="first-word">${pics2[9].name }</h3>
							<p>${fn:substring(pics2[9].intro,0,46)}...</p>
							<a class="read-more" href="#" title="Read more">Read more</a>
							<div class="sp"></div>
						</div>

						<div data-id="post-11" data-type="特色小吃" class="block">
							<a
								href="${pageContext.request.contextPath}/static/upload/${pics2[10].imgs }"
								title="${pics2[10].name }"
								class="img-border preloading-light align-none project-thumbnail video-preview"><img
								src="${pageContext.request.contextPath}/static/upload/${pics2[10].imgs }"
								alt="" style="width: 286px; height: 150px;"></a>
							<h3 class="first-word">${pics2[10].name }</h3>
							<p>${fn:substring(pics2[10].intro,0,46)}...</p>
							<a class="read-more" href="#" title="Read more">Read more</a>
							<div class="sp"></div>
						</div>

						<div data-id="post-12" data-type="特色荤" class="block">
							<a
								href="${pageContext.request.contextPath}/static/upload/${pics2[11].imgs }"
								title="${pics2[11].name }"
								class="img-border preloading-light align-none project-thumbnail image-preview"><img
								src="${pageContext.request.contextPath}/static/upload/${pics2[11].imgs }"
								alt="" style="width: 286px; height: 150px;"></a>
							<h3 class="first-word">${pics2[11].name }</h3>
							<p>${fn:substring(pics2[11].intro,0,46)}...</p>
							<a class="read-more" href="#" title="Read more">Read more</a>
							<div class="sp"></div>
						</div>

						<div data-id="post-13" data-type="特色小吃" class="block">
							<a href="${pageContext.request.contextPath}/static/upload/${pics2[12].imgs }" title="${pics2[12].name }"
								class="img-border preloading-light align-none project-thumbnail video-preview"><img
								src="${pageContext.request.contextPath}/static/upload/${pics2[12].imgs }"
								alt="" style="width: 286px; height: 150px;"></a>
							<h3 class="first-word">${pics2[12].name }</h3>
							<p>${fn:substring(pics2[12].intro,0,46)}...</p>
							<a class="read-more" href="#" title="Read more">Read more</a>
							<div class="sp"></div>
						</div>

						<div data-id="post-14" data-type="特色小吃" class="block">
							<a
								href="${pageContext.request.contextPath}/static/upload/${pics2[13].imgs }"
								title="${pics2[13].name }"
								class="img-border preloading-light align-none project-thumbnail image-preview"><img
								src="${pageContext.request.contextPath}/static/upload/${pics2[13].imgs }"
								alt="" style="width: 286px; height: 150px;"></a>
							<h3 class="first-word">${pics2[13].name }</h3>
							<p>${fn:substring(pics2[13].intro,0,46)}...</p>
							<a class="read-more" href="#" title="Read more">Read more</a>
							<div class="sp"></div>
						</div>

						<div data-id="post-15" data-type="特色荤" class="block">
							<a
								href="${pageContext.request.contextPath}/static/upload/${pics2[14].imgs }"
								title="${pics2[14].name }"
								class="img-border preloading-light align-none project-thumbnail image-preview"><img
								src="${pageContext.request.contextPath}/static/upload/${pics2[14].imgs }"
								alt="" style="width: 286px; height: 150px;"></a>
							<h3 class="first-word">${pics2[14].name }</h3>
							<p>${fn:substring(pics2[14].intro,0,46)}...</p>
							<a class="read-more" href="#" title="Read more">Read more</a>
							<div class="sp"></div>
						</div>
					</div>
					<!--/Porfolio Content-->
					<!--Pagination-->
					<div class="clear"></div>
					<div class="page-pagination clear fixed-width-wrapper">
						<a href="#" title="">Prev</a> <a href="#" title="">1</a> <a
							href="#" title="" class="current">2</a> <a href="#" title="">3</a>
						<a href="#" title="">4</a> <a href="#" title="">5</a><span>...</span>
						<a href="#" title="">15</a> <a href="#" title="">Next</a>
					</div>
					<!--/Pagination-->
				</div>
			</div>
			<!--/Content-->
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