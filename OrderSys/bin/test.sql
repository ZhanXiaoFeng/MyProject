/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50087
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50087
File Encoding         : 65001

Date: 2017-08-27 22:30:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_desk`
-- ----------------------------
DROP TABLE IF EXISTS `tb_desk`;
CREATE TABLE `tb_desk` (
  `id` int(11) NOT NULL,
  `waiterid` int(11) default NULL,
  `totalprice` int(11) default NULL,
  `pay` tinyint(1) default NULL,
  PRIMARY KEY  (`id`),
  KEY `waiterid` (`waiterid`),
  CONSTRAINT `tb_desk_ibfk_1` FOREIGN KEY (`waiterid`) REFERENCES `tb_waiter` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_desk
-- ----------------------------
INSERT INTO `tb_desk` VALUES ('1', '0', '0', '1');
INSERT INTO `tb_desk` VALUES ('2', '2', '405', '0');
INSERT INTO `tb_desk` VALUES ('3', '0', '0', '1');
INSERT INTO `tb_desk` VALUES ('4', '0', '0', '1');
INSERT INTO `tb_desk` VALUES ('5', '0', '0', '1');

-- ----------------------------
-- Table structure for `tb_menu`
-- ----------------------------
DROP TABLE IF EXISTS `tb_menu`;
CREATE TABLE `tb_menu` (
  `id` int(11) NOT NULL,
  `name` varchar(17) default NULL,
  `price` int(11) default NULL,
  `img` varchar(80) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_menu
-- ----------------------------
INSERT INTO `tb_menu` VALUES ('2', '红烧牛肉', '30', null);
INSERT INTO `tb_menu` VALUES ('3', '水母', '60', 'upload/menu/Jellyfish.jpg');
INSERT INTO `tb_menu` VALUES ('4', '企鹅', '100', 'upload/menu/Penguins.jpg');
INSERT INTO `tb_menu` VALUES ('5', '水花', '50', 'upload/menu/Hydrangeas.jpg');
INSERT INTO `tb_menu` VALUES ('6', '菊花茶', '5', 'upload/menu/Chrysanthemum.jpg');
INSERT INTO `tb_menu` VALUES ('7', '郁金香', '10', 'upload/menu/Tulips.jpg');

-- ----------------------------
-- Table structure for `tb_mgr`
-- ----------------------------
DROP TABLE IF EXISTS `tb_mgr`;
CREATE TABLE `tb_mgr` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(17) default NULL,
  `pwd` varchar(17) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_mgr
-- ----------------------------
INSERT INTO `tb_mgr` VALUES ('1', 'admin', '1234');
INSERT INTO `tb_mgr` VALUES ('2', 'admin', 'admin');

-- ----------------------------
-- Table structure for `tb_order`
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` int(11) NOT NULL auto_increment,
  `deskid` int(11) default NULL,
  `foodid` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `deskid` (`deskid`),
  KEY `foodid` (`foodid`),
  CONSTRAINT `tb_order_ibfk_1` FOREIGN KEY (`deskid`) REFERENCES `tb_desk` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `tb_order_ibfk_2` FOREIGN KEY (`foodid`) REFERENCES `tb_menu` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES ('46', '2', '2');
INSERT INTO `tb_order` VALUES ('47', '2', '3');
INSERT INTO `tb_order` VALUES ('48', '2', '4');
INSERT INTO `tb_order` VALUES ('52', '2', '5');
INSERT INTO `tb_order` VALUES ('53', '2', '6');
INSERT INTO `tb_order` VALUES ('54', '2', '7');
INSERT INTO `tb_order` VALUES ('61', '2', '4');
INSERT INTO `tb_order` VALUES ('62', '2', '5');

-- ----------------------------
-- Table structure for `tb_waiter`
-- ----------------------------
DROP TABLE IF EXISTS `tb_waiter`;
CREATE TABLE `tb_waiter` (
  `id` int(11) NOT NULL,
  `name` varchar(17) NOT NULL,
  `pwd` varchar(17) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_waiter
-- ----------------------------
INSERT INTO `tb_waiter` VALUES ('0', 'null', 'null');
INSERT INTO `tb_waiter` VALUES ('1', 'waiter', '1234');
INSERT INTO `tb_waiter` VALUES ('2', 'wanger', '1234');
INSERT INTO `tb_waiter` VALUES ('6', '张三', '1234');
INSERT INTO `tb_waiter` VALUES ('10', 'zhou', '1234');
