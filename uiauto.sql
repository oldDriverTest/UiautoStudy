/*
Navicat MySQL Data Transfer

Source Server         : testmySql
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : uiauto

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2018-06-04 16:36:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for addbuginformation
-- ----------------------------
DROP TABLE IF EXISTS `addbuginformation`;
CREATE TABLE `addbuginformation` (
  `id` int(11) NOT NULL auto_increment,
  `product` varchar(255) default NULL,
  `bugtitle` varchar(255) default NULL,
  `errorlevel` int(11) default NULL,
  `repetestep` varchar(100) default NULL,
  `expextresult` varchar(100) default NULL,
  `run` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of addbuginformation
-- ----------------------------
INSERT INTO `addbuginformation` VALUES ('1', 'guns-sugar', '自定义的标题041301788', '1', '测试步骤内容', '自定义的标题041301788', '1');
INSERT INTO `addbuginformation` VALUES ('2', '呜哩哇啦', '自定义的标题041301817', '2', '测试步骤内容，开始自动输入。。。。', '自定义的标题041301817', '1');
INSERT INTO `addbuginformation` VALUES ('3', 'isTester.com', '自定义的标题041301847', '3', '自动化测试步骤自动输入', '自定义的标题041301847', '1');

-- ----------------------------
-- Table structure for object
-- ----------------------------
DROP TABLE IF EXISTS `object`;
CREATE TABLE `object` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(60) default NULL,
  `type` varchar(10) default NULL,
  `locate` varchar(200) default NULL,
  `explain` varchar(200) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of object
-- ----------------------------
INSERT INTO `object` VALUES ('1', 'login.username', 'name', 'account', '用户名');
INSERT INTO `object` VALUES ('2', 'login.password', 'name', 'password', '密码');
INSERT INTO `object` VALUES ('3', 'login.btn', 'id', 'submit', '登录按钮');
INSERT INTO `object` VALUES ('4', 'testmodel', 'xpath', '//*[@id=\"mainmenu\"]/ul/li[4]/a', '测试模块按钮');
INSERT INTO `object` VALUES ('5', 'testmodel.bug', 'link', 'Bug', 'bug模块');
INSERT INTO `object` VALUES ('6', 'testmodel.addbug', 'link', '提Bug', '提bug按钮');
INSERT INTO `object` VALUES ('7', 'addbug.product', 'xpath', '//*[@class=\"w-p45-f\"]/div/div', '产品点击');
INSERT INTO `object` VALUES ('8', 'addbug.productchoose', 'xpath', '//*[@id=\"product_chosen\"]/div/div/input', '新增bug--产品选择');
INSERT INTO `object` VALUES ('9', 'addbug.title', 'id', 'title', 'bug标题');
INSERT INTO `object` VALUES ('10', 'addbug.errolevel', 'xpath', '//*[@id=\"dataform\"]/table/tbody/tr[5]/td/div[2]/div[2]/div/div[1]/button', '严重程度');
INSERT INTO `object` VALUES ('11', 'addbug.article', 'tagname', 'body', '重现步骤');
INSERT INTO `object` VALUES ('15', 'addbug.affectversion', 'xpath', '//*[@id=\"buildBox\"]/div/ul/li/input', '影响版本');
INSERT INTO `object` VALUES ('16', 'addbug.submit', 'id', 'submit', '保存按钮');
INSERT INTO `object` VALUES ('17', 'addbug.chooseproduct', 'id', 'currentItem', '测试模块下左上角的产品选择');
INSERT INTO `object` VALUES ('18', 'addbug.searchproduct', 'id', 'search', '产品选择框');
INSERT INTO `object` VALUES ('19', 'addbug.kewword', 'name', 'keywords', '关键词输入框');
INSERT INTO `object` VALUES ('20', 'searchbug.step', 'classname', 'content', 'bug查询界面的重现步骤');
INSERT INTO `object` VALUES ('21', 'searchbug.level', 'classname', 'severity1', '验证程度');
INSERT INTO `object` VALUES ('22', 'searchbug.product', 'id', 'currentItem', null);
INSERT INTO `object` VALUES ('23', 'addbug.search', 'id', 'search', '搜索框');
INSERT INTO `object` VALUES ('24', 'searchbug.more', 'link', '更多', '测试模块的更多链接');
