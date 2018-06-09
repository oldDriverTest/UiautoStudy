/*
Navicat MySQL Data Transfer

Source Server         : testmySql
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : uiauto

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2018-06-09 17:21:35
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
INSERT INTO `addbuginformation` VALUES ('1', 'guns-sugar', '自定义的标题095239474', '1', '测试步骤内容', '自定义的标题095239474', '1');
INSERT INTO `addbuginformation` VALUES ('2', '呜哩哇啦', '自定义的标题095239507', '2', '测试步骤内容，开始自动输入。。。。', '自定义的标题095239507', '0');
INSERT INTO `addbuginformation` VALUES ('3', 'isTester.com', '自定义的标题095239567', '3', '自动化测试步骤自动输入', '自定义的标题095239567', '0');

-- ----------------------------
-- Table structure for bugobject
-- ----------------------------
DROP TABLE IF EXISTS `bugobject`;
CREATE TABLE `bugobject` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(60) default NULL,
  `type` varchar(10) default NULL,
  `locate` varchar(200) default NULL,
  `explain` varchar(200) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of bugobject
-- ----------------------------
INSERT INTO `bugobject` VALUES ('1', 'login.username', 'name', 'account', '用户名');
INSERT INTO `bugobject` VALUES ('2', 'login.password', 'name', 'password', '密码');
INSERT INTO `bugobject` VALUES ('3', 'login.btn', 'id', 'submit', '登录按钮');
INSERT INTO `bugobject` VALUES ('4', 'testmodel', 'xpath', '//*[@id=\"mainmenu\"]/ul/li[4]/a', '测试模块按钮');
INSERT INTO `bugobject` VALUES ('5', 'testmodel.bug', 'link', 'Bug', 'bug模块');
INSERT INTO `bugobject` VALUES ('6', 'testmodel.addbug', 'link', '提Bug', '提bug按钮');
INSERT INTO `bugobject` VALUES ('7', 'addbug.product', 'xpath', '//*[@class=\"w-p45-f\"]/div/div', '产品点击');
INSERT INTO `bugobject` VALUES ('8', 'addbug.productchoose', 'xpath', '//*[@id=\"product_chosen\"]/div/div/input', '新增bug--产品选择');
INSERT INTO `bugobject` VALUES ('9', 'addbug.title', 'id', 'title', 'bug标题');
INSERT INTO `bugobject` VALUES ('10', 'addbug.errolevel', 'xpath', '//*[@id=\"dataform\"]/table/tbody/tr[5]/td/div[2]/div[2]/div/div[1]/button', '严重程度');
INSERT INTO `bugobject` VALUES ('11', 'addbug.article', 'tagname', 'body', '重现步骤');
INSERT INTO `bugobject` VALUES ('15', 'addbug.affectversion', 'xpath', '//*[@id=\"buildBox\"]/div/ul/li/input', '影响版本');
INSERT INTO `bugobject` VALUES ('16', 'addbug.submit', 'id', 'submit', '保存按钮');
INSERT INTO `bugobject` VALUES ('17', 'addbug.chooseproduct', 'id', 'currentItem', '测试模块下左上角的产品选择');
INSERT INTO `bugobject` VALUES ('18', 'addbug.searchproduct', 'id', 'search', '产品选择框');
INSERT INTO `bugobject` VALUES ('19', 'addbug.kewword', 'name', 'keywords', '关键词输入框');
INSERT INTO `bugobject` VALUES ('20', 'searchbug.step', 'classname', 'content', 'bug查询界面的重现步骤');
INSERT INTO `bugobject` VALUES ('21', 'searchbug.level', 'classname', 'severity1', '验证程度');
INSERT INTO `bugobject` VALUES ('22', 'searchbug.product', 'id', 'currentItem', null);
INSERT INTO `bugobject` VALUES ('23', 'addbug.search', 'id', 'search', '搜索框');
INSERT INTO `bugobject` VALUES ('24', 'searchbug.more', 'link', '更多', '测试模块的更多链接');
INSERT INTO `bugobject` VALUES ('25', 'editbug.editbtn', 'xpath', '//*[@id=\"titlebar\"]/div[2]/div[2]/a', '编辑按钮');
INSERT INTO `bugobject` VALUES ('26', 'editbug,browser', 'id', 'browser', 'bug编辑界面的浏览器');
INSERT INTO `bugobject` VALUES ('27', 'editbug.submit', 'id', 'submit', '修改界面的保存按钮');
INSERT INTO `bugobject` VALUES ('28', 'editbug.browservalue', 'xpath', '//*[@id=\"legendBasicInfo\"]/table/tbody/tr[12]/td', '浏览器值');
