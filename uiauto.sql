/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : uiauto

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2018-04-15 21:04:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `object`
-- ----------------------------
DROP TABLE IF EXISTS `object`;
CREATE TABLE `object` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(60) default NULL,
  `type` varchar(10) default NULL,
  `locate` varchar(200) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of object
-- ----------------------------
INSERT INTO `object` VALUES ('1', 'login.username', 'name', 'account');
INSERT INTO `object` VALUES ('2', 'login.password', 'name', 'password');
INSERT INTO `object` VALUES ('3', 'login.btn', 'id', 'submit');
