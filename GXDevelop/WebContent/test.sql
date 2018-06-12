/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-05-15 23:58:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_admin
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `degree` varchar(10) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `imgUrl` varchar(100) DEFAULT NULL,
  `phone` varchar(13) DEFAULT NULL,
  `realName` varchar(8) DEFAULT NULL,
  ` school` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '管理员', '1655429377@qq.com', 'man', 'logo.png', '18593276326', 'ZRF', '广西师范大学');

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `display` bit(1) DEFAULT NULL,
  `intro` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO `tb_category` VALUES ('1', '美食文化', '', '美食文化类别');
INSERT INTO `tb_category` VALUES ('2', '人文景观', '', '人文景观类别');
INSERT INTO `tb_category` VALUES ('3', '社会服务', '', '社会服务类别');
INSERT INTO `tb_category` VALUES ('4', '新闻类', '', '新闻类别');
INSERT INTO `tb_category` VALUES ('5', '其它类', '', '其它类别');

-- ----------------------------
-- Table structure for tb_news
-- ----------------------------
DROP TABLE IF EXISTS `tb_news`;
CREATE TABLE `tb_news` (
  `id` int(11) NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `author` varchar(10) DEFAULT NULL,
  `time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `content` text,
  `Source` varchar(20) DEFAULT NULL,
  `picurl` varchar(100) DEFAULT NULL,
  `boardid` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT '0',
  `categoryId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `categoryId` (`categoryId`),
  CONSTRAINT `tb_news_ibfk_1` FOREIGN KEY (`categoryId`) REFERENCES `tb_newscategory` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_news
-- ----------------------------

-- ----------------------------
-- Table structure for tb_newscategory
-- ----------------------------
DROP TABLE IF EXISTS `tb_newscategory`;
CREATE TABLE `tb_newscategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_newscategory
-- ----------------------------

-- ----------------------------
-- Table structure for tb_pic
-- ----------------------------
DROP TABLE IF EXISTS `tb_pic`;
CREATE TABLE `tb_pic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `imgs` varchar(100) DEFAULT NULL,
  `intro` varchar(500) DEFAULT NULL,
  `categoryId` int(11) DEFAULT NULL,
  `display` bit(1) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `picId` (`categoryId`),
  CONSTRAINT `tb_pic_ibfk_1` FOREIGN KEY (`categoryId`) REFERENCES `tb_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_pic
-- ----------------------------
INSERT INTO `tb_pic` VALUES ('1', '巴马油鱼', 'bama_youyu.jpg', '巴马油鱼，学名叫巴马穗唇鲃，生活在巴马瑶族自治县甲篆乡坡月村百魔洞到巴马镇练乡村这一段10多公里的盘阳河流里。巴马油鱼肉味鲜美，富含不饱和脂肪酸和人体必需的氨基酸，营养价值较高。', '1', '', '1');
INSERT INTO `tb_pic` VALUES ('2', '宾阳酸粉', 'binyang_suanfen.jpg', '宾阳酸粉历史悠久，它以特有的地方民间风味闻名县内外。盛夏、酷秋时节吃上一碗，顿感凉爽透体、心旷神怡、精神倍增，具辟邪祛暑之奇效。宾阳酸粉作为冷盘小吃，它粉质雪白幼嫩，配料金黄喷香，上面放上几片清脆的酸黄瓜和少许鲜红的辣椒末，令人垂涎欲滴。加上其爽滑可口、酸甜适中、柔滑香脆兼而有之的口感，使人胃口大开。', '1', '', '1');
INSERT INTO `tb_pic` VALUES ('3', '崇左沉香鱼', 'chongzuo_chengxiangyu.jpg', '在广西崇左市江州区新和镇泗坝至通康这一河段，有一种特别的鱼叫沉香鱼。“沉香鱼”，又名华桂鲮、青衣，形似鲮鱼、鳞片厚，色泽青稍黑，有淡红点，唇下勾，脊刺由1l根硬骨组成，肉质嫩滑，做鱼生，更是色、香、味俱全；生煎香甜之极，营养价值很高，是淡水鱼中的珍品。', '1', '', '1');
INSERT INTO `tb_pic` VALUES ('4', '桂林米粉', 'guilin_mifen.jpg', '桂林米粉，从秦王朝就开始产生和生产了，桂林人吃米粉，已经吃了两千三百年啦。', '1', '', '1');
INSERT INTO `tb_pic` VALUES ('5', '苗家“羊瘪汤”', 'miaojia_yanbietang.jpg', '“羊瘪汤”主要用料为羊的内脏即羊的肠、肚、血，羊肝也可。将羊宰杀后剖腹，然后取出肠、肚冲洗干净，但不能将羊肠里的脂肪全部除去。将肥肠编制成辫子状（俗称“羊辫肠”），如果肠子里的脂肪越多，“羊辫肠”就越鲜美。', '1', '', '1');
INSERT INTO `tb_pic` VALUES ('6', '钦州猪脚粉', 'qinzhou_zhujiaofen.jpg', '在钦州,有“钦州猪脚粉，神仙也打滚”的说法。钦州猪脚粉是一种以猪脚为主、润滑可口的钦州传统特色小吃。', '1', '', '1');
INSERT INTO `tb_pic` VALUES ('7', '梧州纸包鸡', 'wuzhou_zhibaoji.jpg', '梧州纸包鸡色泽金黄，香味诱人。吃起来，入口甘、滑、甜、软，食后齿颊留香。', '1', '', '1');
INSERT INTO `tb_pic` VALUES ('8', '阳朔啤酒鱼', 'yangshuo_pijiuyu.jpg', '阳朔“啤酒鱼”，是阳朔有名的地方特色菜，鱼肉鲜辣可口，无一丝鱼本身的腥味，啤酒和鱼肉的香味保证可以让你胃口大开。正如所说“不吃不知道，一吃忘不掉”，啤酒鱼一独到的口味吸引了大批慕名而来的游客，吃了以后都赞不绝口，留恋忘返，在阳朔街边的餐馆都可以品尝得到。', '1', '', '1');
INSERT INTO `tb_pic` VALUES ('9', '崇左小吃——艾糍', 'chongzuo_aici.jpg', '在客家人的餐桌上，艾草可算是一种常见的食材。每到春季，田头水边就会长出一丛丛艾草，绿色的叶子盘旋而上，像宝塔似的非常可爱。这时客娘会带着孩子们把它们采下来，回家将糯米蒸熟之后拌入艾叶一起舂成米膏，在中间包些花生或芝麻馅，团成一个个绿绿的小粑粑放进锅里蒸熟，这就成了有名的客家美食——“艾糍”。', '1', '', '1');
INSERT INTO `tb_pic` VALUES ('10', '清蒸漓江桂鱼', 'guilin_lijiangguiyu.jpg', '用漓江桂鱼和猪肉丝蒸制而成，成菜鱼肉细嫩，滋味甚为鲜美，爽滑适口。', '1', '', '1');
INSERT INTO `tb_pic` VALUES ('11', '东兴风吹饼', 'dongxing_fengchuibing.jpg', '东兴风吹饼俗称“冰喇”，像草帽般大，是广西防城港市东兴京岛最有名的风味小吃之一，因其极薄，薄得连风都可吹走，故名“风吹饼”。曾在京族三宝评选中，风吹饼、京族粉丝、“红姑娘”红薯、成为当之无愧的京族“三宝”。', '1', '', '1');
INSERT INTO `tb_pic` VALUES ('12', '吊烧蛋黄肠', 'diaoshaodanhuangchang.jpg', '特点：色金红艳亮，皮香脆粉绵。\r\n制作关键：肠头要洗净，酿要匀满，上色后要晾干透，烧烤火候要掌握好，防焦黑或过干不起色。', '1', '', '1');
INSERT INTO `tb_pic` VALUES ('13', '风味炒田螺', 'fengweichaotianluo.jpg', '特点：螺肉爽脆可口，味清香鲜美，有清热、生津明目、利水通淋之功效。\r\n制作关键：田螺一定要用铁锈养24小时以上，让其吐污泥净并刷洗干净，充分炒出香味；熬煮时一定要掌握好火候。', '1', '', '1');
INSERT INTO `tb_pic` VALUES ('14', '蜂蛹焗蛋', 'fengyongjudan.jpg', '特点：色金黄，表面焦香，内嫩滑，清香味鲜。\r\n制作关键：蒸水蛋比例要当，烤焗火候要掌握准。', '1', '', '1');
INSERT INTO `tb_pic` VALUES ('15', '吉列栗子卷', 'jilielizijuan.jpg', '特点：色浅黄，味清香，鲜甜，质松脆软绵，具有补血、美容之功效。\r\n制作关键：栗肉要新鲜粉质好的，蒸熟后要搓打泥茸；包卷要牢，上蛋液、包糠要匀；炸的油温要适中。', '1', '', '1');
INSERT INTO `tb_pic` VALUES ('16', '山黄皮炒鸭', 'shanhuangpichaoya.jpg', '特点：浓香、嫩滑，味鲜带辣酸，开胃消食。\r\n制作关键：要新鲜的嫩土鸭，掌握好炒的火候。', '1', '', '1');
INSERT INTO `tb_pic` VALUES ('17', '南宁青秀山', 'qingxiushan.jpg', '4A景区 常年苍翠的青秀山风景区是南宁市最著名的风景区,位于南宁市东南方向约10公里，俗称青山。景区内山峦起伏，群峰叠翠，泉清石奇，素以山不高而秀，水不深而清著称。建有热带雨林大观、棕榈园、水月庵、龙象塔、泰国园、瑶池、天池等景点以及世界上最大的苏铁园。现存明清时期的古迹和名人文士的题吟颇丰，是游客观光旅游、寻古探幽的好去处。山上还建有观光缆车，可一饱湖光山色，被评为广西十佳景区之一。', '2', '', '2');
INSERT INTO `tb_pic` VALUES ('18', '百色靖西古龙山峡谷群景区', 'glsxiagu.jpg', '靖西古龙山峡谷群景区（国家AAAA级旅游景区），这是一个集峡谷、瀑布、暗河、溶洞、原始植被、峰丛绝壁、溪流奇石为一体的人间仙境。这就是桂西边境旅游带上的一颗明珠——靖西县古龙山峡谷群风景区。素有“山水小桂林，气候小昆明”之美誉。古龙山峡谷群是由天然成型的地下河道，以其所特有的喀斯特蕴育了这神秘的峡谷。而地壳的变迁和亿万年河水的冲刷鬼斧神工般的将大自然的杰作展现在世人的眼前。', '2', '', '2');
INSERT INTO `tb_pic` VALUES ('19', '河池长寿宫', 'changshoug.jpg', '长寿宫原名水晶宫，位于巴马县那社乡，属国内一流的罕见珍稀溶洞，并且还处在生长之中，极具观赏价值和科学研究价值。走进长寿宫，恍如置身一个玉砌般的童话世界。地上发育着鲜活、透明蘑菇状晶体；空中垂悬着白嫩、纤细、蜷曲且神态各异的水晶球、水晶花、水晶草；而那些洁白无瑕通体透亮的玉柱、玉笋则在天地间毫无顾忌地疯长着。 整个溶洞活脱脱就是世界长寿之乡的缩影，那些发出水晶般的光泽的钟乳石就像一个个老寿星堆砌着、排列着、舒展着，“寿星探秘”、“圣母祝寿”、“寿乡活力”、“寿比南山”、“寿成正果”等景致错落有致，让你不得不一边惊叹大自然的鬼斧神工。', '2', '', '2');
INSERT INTO `tb_pic` VALUES ('20', '柳州立鱼峰风景区', 'liyuf.jpg', '立鱼峰风景区是柳州最主要的名山之一。平地崛起，突兀耸秀，通高68米，海拔156．3米，呈东西走向，长145米，环麓500米。唐代文学家柳宗元称其“山小而高，其形如立鱼”，故得名立鱼峰，也叫石鱼山，习称鱼峰山。公园因此山峰而得名。山上树木葱茏，亭台楼阁适布其间，有翠松亭、冠山亭、观美阁等建筑。半山腰有崖刻“柳江砥柱”四个大字。山中清凉洞、玉洞、盘古洞、纯阳洞、阴风洞、螽斯洞、三姐岩七个岩洞彼此贯通，习称“灵通七窍”。明代徐霞客来游，盛称诸洞景奇。', '2', '', '2');
INSERT INTO `tb_pic` VALUES ('21', '桂林山水', 'lijiang.jpg', '“桂林山水甲天下，阳朔堪称甲桂林”高度概括了阳朔自然风光在世界上所占有的重要位置。“山青、水秀、洞奇、石美”，为天下四绝。 县内旅游资源可分为一环、二带、五景区。阳朔段漓江风光为整个漓江精华，还有遇龙河、十里画廊、古寨石城、兴坪古镇等特色著名景区景点。 阳朔是汉族、壮族、瑶族聚居地，在数千年的历史中，形成了富有民族特色和地方特色的民风民俗。 在阳朔，坐竹筏漂流是最热门也是最有特色的旅游方式之一，不可错过。 阳朔地处中亚热带季风区，气候温和，四季宜人。', '2', '', '2');
INSERT INTO `tb_pic` VALUES ('22', '崇左德天大瀑布', 'detianpb.jpg', '德天大瀑布发源于归春河的上游，自北南流的归春河被峙在江心的浦汤岛所阻挡，使河水激石咆哮，夺路而下，形成高达50余米的瀑布。远望德天瀑布，只闻水声轰鸣，响如滚雷。巨大的跌水分成数股飞泻直下，水花四溅，烟雾溟蒙，在阳光下，色彩缤纷，蔚为壮观。瀑布景观随河水流量的多寡而变化，河水有季节变化，瀑布亦因而有四季景色。春天来临，崖草泛青，山花吐蕊，木棉花盛开，归春河两岸一片红霞，不是秋色，胜似秋色。', '2', '', '2');
INSERT INTO `tb_pic` VALUES ('23', '来宾圣堂山', 'stshan.jpg', '圣堂山是大瑶山主峰，距金秀县城西南面４５公里， 总面积１５０平方公里，最高峰海拔１９７９米，为广西第五高峰，桂中第一高峰。 圣堂山是金秀大瑶山自然风光精华所在。山上群峰林立，直插云天，常云封雾锁，神秘莫测。远眺峰浮云海，气势磅礴，峥嵘崔巍，恍如海市蜃楼，近看怪石凌空，塔林戟海，鬼斧神工，或绝壁高张，石塔千层，巨笋穿空；或猛虎下山，万马奔腾，势不可挡，或仙女下凡，恋人相会，顽猴戏月，寿龟赏花，大将点兵，老人安坐，怨女盼夫……，形象逼真，栩栩如生，令人称绝。山谷间尚存古冰川时期的遗迹石河、石海。', '2', '', '2');
INSERT INTO `tb_pic` VALUES ('24', '北海涠洲岛', 'bhyingtan.jpg', '北海涠洲岛是我国最大最年轻的火山岛。岛上不但气候宜人，资源丰富，风光秀丽，景色迷人，四季如春，气候温暖湿润，富含负氧离子的空气清新宜人，具备世界旅游界向注的“三S”（海水sea 、阳光sun、沙滩sand）的旅游资源十分丰富的岛屿；故素有“大蓬莱”仙岛之称。在高空鸟瞰，面积为25平方公里的涠洲岛犹如一枚翡翠漂浮于湛蓝的大海中。', '2', '', '2');
INSERT INTO `tb_pic` VALUES ('25', '防城港十万大山国家森林公园', 'shiwds.jpg', '十万大山国家森林公园地处桂林、南宁、十万大山森林公园、东兴、越南下龙湾黄金旅游线上。其前身是以水源林为管护对象的生态公益性林场――红旗林场。辖区总面积2037公顷，其中水源林1336公顷，占总面积65%，森林覆盖率达98%以上。1995年7月林场进行产业结构调整，利用森林资源和自然景观发展森林旅游业，创办十万大山森林公园。该公园座落在十万大山核心区，50年代拍摄的影片《英雄虎胆》的故事就发生在十万大山，十万大山森林公园也是该片重要的拍摄外景地。', '2', '', '2');
INSERT INTO `tb_pic` VALUES ('26', '钦州八寨沟旅游区', 'bazgou.jpg', '八寨沟旅游区位于钦州西北五十多公里的十万大山腹地的贵台镇境内，总面积三万多亩，交通方便，旅游资源丰富，气候温和。八寨沟亚热带雨林、竹林，清澈的山涧、瀑布、大小各异的泉潭和奇特的砂页岩地貌形成了桂南沿海地区知名度较高、集探险、猎奇、游泳、休闲度假、避暑、观光的旅游胜地。', '2', '', '2');
INSERT INTO `tb_pic` VALUES ('27', '医疗', '', '健康是人们共同追求的，但疾病也一路伴随人生。每人都会有生老病死，这是无可厚非的。', '3', '', '3');
INSERT INTO `tb_pic` VALUES ('28', '教育', '', '教育，教育者有目的有计划有组织的对受教育者的心智发展进行教化培育，以现有的经验、学识推敲于人，为其解释各种现象、问题或行为，以增长能力经验，其根本是以人的一种相对成熟或理性的思维来认知对待，让事物得以接近其最根本的存在，人在其中，慢慢的对一种事物由感官触摸而到以认知理解的状态，并形成一种相对完善或理性的自我意识思维...但同时，人有着自我意识上的思维，又有着其自我的感官维度，所以，任何教育性的意识思维都未必能够绝对正确，而应该感性式的理解其思维的方向，只要他不偏差事物的内在；教育又是一种思维的传授，而人因为其自身的意识形态，又有着另样的思维走势，所以，教育当以最客观、最公正的意识思维教化于人，如此，人的思维才不至于过于偏差，并因思维的丰富而逐渐成熟、理性，并由此，走向最理性的自我和拥有最正确的思维认知，这就是教育的根本所在。', '3', '', '3');
INSERT INTO `tb_pic` VALUES ('29', '养老', '', '养老起源于原始社会末期，夏商两代继承之，但西周才在制度上臻于完善。《礼记·王制》：“凡养老，有虞氏以燕礼，夏后氏以飨礼，殷人以食礼，周人修而兼用之。五十养于乡，六十养于国，七十养于学，达于诸侯。”这说明西周规定按年龄大小由地方或国家分别承担养老责任，在政策上，不仅中央要负责养老，地方也要负责养老。凡年满五十的则养于乡遂之学，年满六十的则养于国学中的小学，年满七十的则养于国学中的大学。这种养老制度，自天子以达诸侯，都是相同的。不过一国的长老，由诸侯致养，若是天下的长老，则由天子致养。西周养老不仅鉴于老年人积累有丰富的知识经验，更出于宗法的等级社会的需要：按长幼之序，定尊卑之礼。正如《王制》所说：“养耆老以致孝。”《礼记·乡饮酒义》也说：“民知尊长养老而后能入孝弟；民入孝弟，出尊长养老，而后成教；成教而后国可安也。”这就是西周重视养老制度的根本原因。', '3', '', '3');
INSERT INTO `tb_pic` VALUES ('30', '就业', '', '就业的含义是指在法定年龄内的有劳动能力和劳动愿望的人们所从事的为获取报酬或经营收入进行的活动。\r\n如果再进一步分析，则需要把就业从三个方面进行界定：\r\n一是就业条件，指在法定劳动年龄内，有劳动能力和劳动愿望；\r\n二是收入条件，指获得一定的劳动报酬或经营收入；\r\n三是时间条件，即每周工作时间的长度。', '3', '', '3');
INSERT INTO `tb_pic` VALUES ('31', '交通', '', '交通是指从事旅客和货物运输及语言和图文传递的行业，包括运输和邮电两个方面，在国民经济中属于第三产业。运输有铁路、公路、水路、航空、管道五种方式，邮电包括邮政和电信两方面内容。', '3', '', '3');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL,
  `pwd` varchar(32) DEFAULT NULL,
  `phone` varchar(13) DEFAULT NULL,
  `photo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'zhangsan', '123456', '18593276328', 'usr/zhangsan.jpg');
