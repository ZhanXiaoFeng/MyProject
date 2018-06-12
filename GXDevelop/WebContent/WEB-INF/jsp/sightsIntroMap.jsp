<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

<script type="text/JavaScript"
	src="${pageContext.request.contextPath}/static/js/echarts.min.js"></script>
<script type="text/JavaScript"
	src="${pageContext.request.contextPath}/static/js/guangxi.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<link
	href="${pageContext.request.contextPath}/static/css/guangxi_map.css"
	rel="stylesheet" type="text/css" />
<link rel="Shortcut Icon" href="favicon.ico" />
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
					<li><a href="#" title="Weibo"><img
							src="${pageContext.request.contextPath}/static/images/icons/weibo.png"
							alt=""></a></li>
					<li><a href="#" title="QQ"><img
							src="${pageContext.request.contextPath}/static/images/icons/qq.jpg"
							alt=""></a></li>
					<li><a href="#" title="WeiXin"><img
							src="${pageContext.request.contextPath}/static/images/icons/weixin.jpg"
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
						<li><a href="services.html" title="">社会服务</a></li>
						<li><a
							href="${pageContext.request.contextPath}/foodsIntro.do" title="">美食文化</a></li>
						<li><a href="blog.html" title="">记忆与分享</a></li>
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






					<div class="contents" style="margin: 0 auto;">
						<div class="b_map">
							<div id="main"
								style="height: 600px; width: 900px; margin-left: -200px; margin-top: -80px;"></div>
							<script type="text/javascript">
								echarts.registerMap('guangxi', guangxiMap);
								var chart = echarts.init(document
										.getElementById('main'));
								chart.setOption({
									series : [ {
										type : 'map',
										map : 'guangxi'
									} ]
								});
							</script>
							<!--各个市-->
							<ul id="m_btn" class="e_map_tags">
								<li class="m_nanning centers" data-type="nanning">南宁</li>
								<li class="m_baise" data-type="baise">百色</li>
								<li class="m_hechi" data-type="hechi">河池</li>
								<li class="m_liuzhou" data-type="liuzhou">柳州</li>
								<li class="m_guilin" data-type="guilin">桂林</li>
								<li class="m_chongzuo" data-type="chongzuo">崇左</li>
								<li class="m_laibin" data-type="laibin">来宾</li>
								<li class="m_wuzhou" data-type="wuzhou">梧州</li>
								<li class="m_hezhou" data-type="hezhou">贺州</li>
								<li class="m_fangchenggang" data-type="fangchenggang">防城港</li>
								<li class="m_qinzhou" data-type="qinzhou">钦州</li>
								<li class="m_guigang" data-type="guigang">贵港</li>
								<li class="m_yulin" data-type="yulin">玉林</li>
								<li class="m_beihai" data-type="beihai">北海</li>
							</ul>

							<div class="e_map_info">
								<div class="m_content m_nanning hide" data-panel="nanning"
									style="display: block;">
									<div class="m_content_side">
										<a href="javascript:;" class="m_left"><img
											src="${pageContext.request.contextPath}/static/img/arraw-left.png" /></a>
										<a href="javascript:;" class="m_right"><img
											src="${pageContext.request.contextPath}/static/img/arraw-right.png" /></a>
									</div>
									<p
										style="text-align: center; font-size: 20px; padding-bottom: 20px;">南宁</p>
									<div>
										<img
											src="${pageContext.request.contextPath}/static/images/sights/qingxiushan.jpg" />
									</div>
									<p style="text-align: justify; width: 270px;">4A景区常年苍翠的青秀山风景区是南宁市最著名的风景区,位于南宁市东南方向约10公里，俗称青山。景区内山峦起伏，群峰叠翠，泉清石奇，素以山不高而秀，水不深而清著称。建有热带雨林大观、棕榈园、水月庵、龙象塔、泰国园、瑶池、天池等景点以及世界上最大的苏铁园...
									</p>
								</div>

								<div class="m_content m_baise hide" data-panel="baise">
									<div class="m_content_side">
										<a href="javascript:;" class="m_left"><img
											src="${pageContext.request.contextPath}/static/img/arraw-left.png" /></a>
										<a href="javascript:;" class="m_right"><img
											src="${pageContext.request.contextPath}/static/img/arraw-right.png" /></a>
									</div>
									<p
										style="text-align: center; font-size: 20px; padding-bottom: 20px;">百色</p>
									<div>
										<img
											src="${pageContext.request.contextPath}/static/images/sights/glsxiagu.jpg" />
									</div>
									<p style="text-align: justify; width: 270px;">靖西古龙山峡谷群景区（国家AAAA级旅游景区），这是一个集峡谷、瀑布、暗河、溶洞、原始植被、峰丛绝壁、溪流奇石为一体的人间仙境。这就是桂西边境旅游带上的一颗明珠——靖西县古龙山峡谷群风景区。素有“山水小桂林，气候小昆明”之美誉。古龙山峡谷群是由天然成型的...
									</p>
								</div>

								<div class="m_content m_hechi hide" data-panel="hechi">
									<div class="m_content_side">
										<a href="javascript:;" class="m_left"><img
											src="${pageContext.request.contextPath}/static/img/arraw-left.png" /></a>
										<a href="javascript:;" class="m_right"><img
											src="${pageContext.request.contextPath}/static/img/arraw-right.png" /></a>
									</div>
									<p
										style="text-align: center; font-size: 20px; padding-bottom: 20px;">河池</p>
									<div>
										<img
											src="${pageContext.request.contextPath}/static/images/sights/changshoug.jpg" />
									</div>
									<p style="text-align: justify; width: 270px;">长寿宫原名水晶宫，位于巴马县那社乡，属国内一流的罕见珍稀溶洞，并且还处在生长之中，极具观赏价值和科学研究价值。走进长寿宫，恍如置身一个玉砌般的童话世界。地上发育着鲜活、透明蘑菇状晶体；空中垂悬着白嫩、纤细、蜷曲且神态各异的水晶球、水晶花、水晶草；而那些洁白无瑕...
									</p>
								</div>

								<div class="m_content m_liuzhou hide" data-panel="liuzhou">
									<div class="m_content_side">
										<a href="javascript:;" class="m_left"><img
											src="${pageContext.request.contextPath}/static/img/arraw-left.png" /></a>
										<a href="javascript:;" class="m_right"><img
											src="${pageContext.request.contextPath}/static/img/arraw-right.png" /></a>
									</div>
									<p
										style="text-align: center; font-size: 20px; padding-bottom: 20px;">柳州</p>
									<div>
										<img
											src="${pageContext.request.contextPath}/static/images/sights/liyuf.jpg" />
									</div>
									<p style="text-align: justify; width: 270px;">立鱼峰风景区是柳州最主要的名山之一。平地崛起，突兀耸秀，通高68米，海拔156．3米，呈东西走向，长145米，环麓500米。唐代文学家柳宗元称其“山小而高，其形如立鱼”，故得名立鱼峰，也叫石鱼山，习称鱼峰山。公园因此山峰而得名。山上树木葱茏，亭台楼阁适布其间...
									</p>
								</div>

								<div class="m_content m_guilin hide" data-panel="guilin">
									<div class="m_content_side">
										<a href="javascript:;" class="m_left"><img
											src="${pageContext.request.contextPath}/static/img/arraw-left.png" /></a>
										<a href="javascript:;" class="m_right"><img
											src="${pageContext.request.contextPath}/static/img/arraw-right.png" /></a>
									</div>
									<p
										style="text-align: center; font-size: 20px; padding-bottom: 20px;">桂林</p>
									<div>
										<img
											src="${pageContext.request.contextPath}/static/images/sights/yangs.jpg" />
									</div>
									<p style="text-align: justify; width: 270px;">“桂林山水甲天下，阳朔堪称甲桂林”高度概括了阳朔自然风光在世界上所占有的重要位置。“山青、水秀、洞奇、石美”，为天下四绝。县内旅游资源可分为一环、二带、五景区。阳朔段漓江风光为整个漓江精华，还有遇龙河、十里画廊、古寨石城、兴坪古镇等特色著名景区景点。阳朔是汉族、壮族...
									</p>
								</div>

								<div class="m_content m_chongzuo hide" data-panel="chongzuo">
									<div class="m_content_side">
										<a href="javascript:;" class="m_left"><img
											src="${pageContext.request.contextPath}/static/img/arraw-left.png" /></a>
										<a href="javascript:;" class="m_right"><img
											src="${pageContext.request.contextPath}/static/img/arraw-right.png" /></a>
									</div>
									<p
										style="text-align: center; font-size: 20px; padding-bottom: 20px;">崇左</p>
									<div>
										<img
											src="${pageContext.request.contextPath}/static/images/sights/detianpb.jpg" />
									</div>
									<p style="text-align: justify; width: 270px;">德天大瀑布发源于归春河的上游，自北南流的归春河被峙在江心的浦汤岛所阻挡，使河水激石咆哮，夺路而下，形成高达50余米的瀑布。远望德天瀑布，只闻水声轰鸣，响如滚雷。巨大的跌水分成数股飞泻直下，水花四溅，烟雾溟蒙，在阳光下...
									</p>
								</div>

								<div class="m_content m_laibin hide" data-panel="laibin">
									<div class="m_content_side">
										<a href="javascript:;" class="m_left"><img
											src="${pageContext.request.contextPath}/static/img/arraw-left.png" /></a>
										<a href="javascript:;" class="m_right"><img
											src="${pageContext.request.contextPath}/static/img/arraw-right.png" /></a>
									</div>
									<p
										style="text-align: center; font-size: 20px; padding-bottom: 20px;">来宾</p>
									<div>
										<img
											src="${pageContext.request.contextPath}/static/images/sights/stshan.jpg" />
									</div>
									<p style="text-align: justify; width: 270px;">圣堂山是大瑶山主峰，距金秀县城西南面４５公里，
										总面积１５０平方公里，最高峰海拔１９７９米，为广西第五高峰，桂中第一高峰。圣堂山是金秀大瑶山自然风光精华所在。山上群峰林立，直插云天，常云封雾锁，神秘莫测。远眺峰浮云海，气势磅礴，峥嵘崔巍，恍如海市蜃楼，近看怪石凌空，塔林戟海，鬼斧神工，或绝壁高张，石塔千层...
									</p>
								</div>

								<div class="m_content m_wuzhou hide" data-panel="wuzhou">
									<div class="m_content_side">
										<a href="javascript:;" class="m_left"><img
											src="${pageContext.request.contextPath}/static/img/arraw-left.png" /></a>
										<a href="javascript:;" class="m_right"><img
											src="${pageContext.request.contextPath}/static/img/arraw-right.png" /></a>
									</div>
									<p
										style="text-align: center; font-size: 20px; padding-bottom: 20px;">梧州</p>
									<div>
										<img
											src="${pageContext.request.contextPath}/static/images/sights/yiqil.jpg" />
									</div>
									<p style="text-align: justify; width: 270px;">1897年开埠后，梧州成为广西的商业中心。上世纪二十年代，梧州商埠局拆古城墙、拓宽街道，原来的坊式房逐渐被骑楼取代，在河东老城区留下连绵成片的骑楼群。22条原汁原味骑楼长街上，560座中西文化水乳交融的传奇建筑，荟萃中外经典设计的骑楼。骑楼街士贾云集，最风光时街上...
									</p>
								</div>

								<div class="m_content m_hezhou hide" data-panel="hezhou">
									<div class="m_content_side">
										<a href="javascript:;" class="m_left"><img
											src="${pageContext.request.contextPath}/static/img/arraw-left.png" /></a>
										<a href="javascript:;" class="m_right"><img
											src="${pageContext.request.contextPath}/static/img/arraw-right.png" /></a>
									</div>
									<p
										style="text-align: center; font-size: 20px; padding-bottom: 20px;">贺州</p>
									<div>
										<img
											src="${pageContext.request.contextPath}/static/images/sights/hyguzhen.jpg" />
									</div>
									<p style="text-align: justify; width: 270px;">黄姚古镇，黄姚是有着近千年历史的古镇，发祥于宋朝年间，兴建于明朝万历年间，鼎盛于清朝乾隆年间。由于镇上以黄、姚两姓居多，故名“黄姚”。现已被列为省级风景名胜区。全镇居民600多户，八条街道，房屋多数保持明清风格，由于黄姚所处特殊的地理位置，四面皆山，易守难攻...
									</p>
								</div>

								<div class="m_content m_fangchenggang hide"
									data-panel="fangchenggang">
									<div class="m_content_side">
										<a href="javascript:;" class="m_left"><img
											src="${pageContext.request.contextPath}/static/img/arraw-left.png" /></a>
										<a href="javascript:;" class="m_right"><img
											src="${pageContext.request.contextPath}/static/img/arraw-right.png" /></a>
									</div>
									<p
										style="text-align: center; font-size: 20px; padding-bottom: 20px;">防城港</p>
									<div>
										<img
											src="${pageContext.request.contextPath}/static/images/sights/shiwds.jpg" />
									</div>
									<p style="text-align: justify; width: 270px;">十万大山国家森林公园地处桂林、南宁、十万大山森林公园、东兴、越南下龙湾黄金旅游线上。其前身是以水源林为管护对象的生态公益性林场――红旗林场。辖区总面积2037公顷，其中水源林1336公顷，占总面积65%，森林覆盖率达98%以上。1995年7月林场进行产业结构调整，利用...
									</p>
								</div>
								<div class="m_content m_qinzhou hide" data-panel="qinzhou">
									<div class="m_content_side">
										<a href="javascript:;" class="m_left"><img
											src="${pageContext.request.contextPath}/static/img/arraw-left.png" /></a>
										<a href="javascript:;" class="m_right"><img
											src="${pageContext.request.contextPath}/static/img/arraw-right.png" /></a>
									</div>
									<p
										style="text-align: center; font-size: 20px; padding-bottom: 20px;">钦州</p>
									<div>
										<img
											src="${pageContext.request.contextPath}/static/images/sights/bazgou.jpg" />
									</div>
									<p style="text-align: justify; width: 270px;">八寨沟旅游区位于钦州西北五十多公里的十万大山腹地的贵台镇境内，总面积三万多亩，交通方便，旅游资源丰富，气候温和。八寨沟亚热带雨林、竹林，清澈的山涧、瀑布、大小各异的泉潭和奇特的砂页岩地貌形成了桂南沿海地区知名度较高、集探险、猎奇、游泳、休闲度假、避暑...
									</p>
								</div>
								<div class="m_content m_guigang hide" data-panel="guigang">
									<div class="m_content_side">
										<a href="javascript:;" class="m_left"><img
											src="${pageContext.request.contextPath}/static/img/arraw-left.png" /></a>
										<a href="javascript:;" class="m_right"><img
											src="${pageContext.request.contextPath}/static/img/arraw-right.png" /></a>
									</div>
									<p
										style="text-align: center; font-size: 20px; padding-bottom: 20px;">贵港</p>
									<div>
										<img
											src="${pageContext.request.contextPath}/static/images/sights/bhguixiangy.jpg" />
									</div>
									<p style="text-align: justify; width: 270px;">北回归线公园因建在北回归线上而得名，广西第一座北回归线标志塔就建在该公园内。北回归线标志塔高17.2米，跨度26米，象征极线，犹如长虹般美丽的弧柱穿过象征地球的直径为6米的大球体，球体中间有一个10公分的窥阳孔。夏至日正午，阳光直射其上，竖竿无影。窥阳孔下睹骄阳..
										。</p>
								</div>
								<div class="m_content m_yulin hide" data-panel="yulin">
									<div class="m_content_side">
										<a href="javascript:;" class="m_left"><img
											src="${pageContext.request.contextPath}/static/img/arraw-left.png" /></a>
										<a href="javascript:;" class="m_right"><img
											src="${pageContext.request.contextPath}/static/img/arraw-right.png" /></a>
									</div>
									<p
										style="text-align: center; font-size: 20px; padding-bottom: 20px;">玉林</p>
									<div>
										<img
											src="${pageContext.request.contextPath}/static/images/sights/darongshan.jpg" />
									</div>
									<p style="text-align: justify; width: 270px;">大容山森林公园有着丰富的高山森林湖泊景观，这里有“桂东南的第一高峰”大容山，清秀的莲花瀑布，峡谷幽深的九瀑谷等。景观类型丰富，是欣赏山林美景和观日出、日落、云海的好去处。大容山森林公园的景点较为分散，龙门景区位于大容山山脚，这里有一幢韵味悠长的徽派古宅。九瀑谷峰回路转...
									</p>
								</div>

								<div class="m_content m_beihai hide" data-panel="beihai">
									<div class="m_content_side">
										<a href="javascript:;" class="m_left"><img
											src="${pageContext.request.contextPath}/static/img/arraw-left.png" /></a>
										<a href="javascript:;" class="m_right"><img
											src="${pageContext.request.contextPath}/static/img/arraw-right.png" /></a>
									</div>
									<p
										style="text-align: center; font-size: 20px; padding-bottom: 20px;">北海</p>
									<div>
										<img
											src="${pageContext.request.contextPath}/static/images/sights/bhyingtan.jpg" />
									</div>
									<p style="text-align: justify; width: 270px;">北海涠洲岛是我国最大最年轻的火山岛。岛上不但气候宜人，资源丰富，风光秀丽，景色迷人，四季如春，气候温暖湿润，富含负氧离子的空气清新宜人，具备世界旅游界向注的“三S”（海水sea、阳光sun、沙滩sand）的旅游资源十分丰富的岛屿；故素有“大蓬莱”仙岛之称...
									</p>
								</div>

							</div>

						</div>
					</div>

					<!--翻页的实现-->
					<script type="text/javascript">
						$(document)
								.ready(
										function() {

											$(".e_map_tags li")
													.mouseover(
															function() {
																$(this)
																		.addClass(
																				"centers")
																		.siblings(
																				"li")
																		.removeClass(
																				"centers");
																var index = $(
																		this)
																		.index();
																$(".m_content")
																		.eq(
																				index)
																		.show()
																		.siblings(
																				".m_content")
																		.hide();
															});
											//左右切换
											//点击左箭头
											$(".m_left")
													.click(
															function() {
																//获取当前左切换 父亲的 index
																var sideindexL = $(
																		this)
																		.parents(
																				".m_content")
																		.index();
																//全部隐藏
																$(".m_content")
																		.hide();
																//父亲的上一个显示
																$(this)
																		.parents(
																				".m_content")
																		.prev(
																				".m_content")
																		.fadeIn();
																//地图对应index添加默认样式
																$(
																		".e_map_tags li")
																		.eq(
																				sideindexL - 1)
																		.addClass(
																				"centers")
																		.siblings(
																				"li")
																		.removeClass(
																				"centers");
																//当左切换为第一个时候  第一个显示
																if (sideindexL == 0) {
																	$(
																			".m_content:first")
																			.show();
																	alert("没有了，我是有上限的！")
																	$(
																			".e_map_tags li")
																			.eq(
																					0)
																			.addClass(
																					"centers")
																			.siblings(
																					"li")
																			.removeClass(
																					"centers");
																}
															});

											//点击右箭头
											$(".m_right")
													.click(
															function() {
																//获取页面全部.m_content 的数量
																var sideindexR = $(
																		this)
																		.parents(
																				".m_content")
																		.index();
																$(".m_content")
																		.hide();
																$(this)
																		.parents(
																				".m_content")
																		.next(
																				".m_content")
																		.fadeIn();
																$(
																		".e_map_tags li")
																		.eq(
																				sideindexR + 1)
																		.addClass(
																				"centers")
																		.siblings(
																				"li")
																		.removeClass(
																				"centers");
																if (sideindexR == 13) { //这里的数字 是你地图的个数减去1
																	$(
																			".m_content:last")
																			.show();
																	alert("没有了，我是有下限的！")
																	$(
																			".e_map_tags li")
																			.eq(
																					sidelenAll)
																			.addClass(
																					"centers")
																			.siblings(
																					"li")
																			.removeClass(
																					"centers");
																}
															});

										});
					</script>
















					<!--Porfolio Content-->
					<!-- <div class="portfolio-content three-column clear" id="map"></div>
					<script>
						$(document).ready(function() {
							$("#map").load("guangXiMap.html");
						});
					</script>

				</div> -->
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