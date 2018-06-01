/*
Navicat MySQL Data Transfer

Source Server         : 毕设
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2018-06-01 16:04:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_number` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '图书号',
  `book_name` varchar(20) DEFAULT NULL COMMENT '书名',
  `author` varchar(200) DEFAULT NULL COMMENT '作者',
  `publisher` varchar(20) DEFAULT NULL COMMENT '出版社',
  `publish_date` datetime DEFAULT NULL COMMENT '出版日期',
  `price` decimal(10,0) DEFAULT NULL COMMENT '单价',
  `book_type` varchar(30) DEFAULT NULL,
  `store_location` varchar(30) DEFAULT NULL COMMENT '存放位置',
  `store_date` datetime DEFAULT NULL COMMENT '入库日期',
  `borrowed_number` int(11) DEFAULT NULL COMMENT '借出数量',
  `number` int(11) DEFAULT NULL COMMENT '图书数量',
  PRIMARY KEY (`book_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('2024655', '数据结构', '严蔚敏 吴伟民', '清华大学出版社', '2007-09-01 09:20:09', '30', '编程', 'b04', '2018-05-24 07:36:45', '3', '100');
INSERT INTO `book` VALUES ('2567698', '三体', '刘慈欣', '重庆出版社', '2008-02-01 09:41:20', '23', '文学', 'w07', '2018-06-01 09:41:27', '1', '100');
INSERT INTO `book` VALUES ('2994636', '计算机组成原理', '唐朔飞', '高等教育出版社', '2008-03-01 09:20:19', '43', '编程', 'b05', '2018-05-21 23:37:43', '0', '100');
INSERT INTO `book` VALUES ('5399293', 'JavaEE程序设计与应用开发', '郭克华 编', '清华大学', '2011-03-01 09:20:31', '32', '编程', 'b02', '2018-05-21 23:24:08', '0', '100');
INSERT INTO `book` VALUES ('6558446', '生如夏花', '泰戈尔', '江苏文艺出版社', '2011-10-01 09:21:52', '26', '文学', 'w02', '2018-05-22 13:15:07', '0', '100');
INSERT INTO `book` VALUES ('6721989', 'C++语言程序设计', '郑莉 董渊', '清华大学出版社', '2011-08-01 09:20:47', '23', '编程', 'b03', '2018-05-21 23:30:55', '0', '100');
INSERT INTO `book` VALUES ('19958089', '我们仨', '杨绛', '生活·读书·新知三联书店', '2012-11-01 09:21:01', '23', '文学', 'w04', '2018-05-21 23:19:09', '0', '100');
INSERT INTO `book` VALUES ('26079463', '计算机操作系统', '汤小丹', '西安电子科技大学出版社有限公司', '2014-06-21 09:22:59', '39', '编程', 'b01', '2018-05-21 09:22:59', '0', '100');
INSERT INTO `book` VALUES ('26974262', '小王子', '[法] 圣-埃克苏佩里', '浙江文艺出版社', '2017-05-01 09:21:14', '39', '文学', 'w05', '2018-05-23 00:01:15', '0', '100');
INSERT INTO `book` VALUES ('27006467', '浮生六记', '[清]沈复 周公度 译注', '浙江文艺出版社', '2017-06-01 09:21:37', '45', '文学', 'w01', '2018-05-21 23:13:44', '0', '100');
INSERT INTO `book` VALUES ('27096017', '花间集', '赵崇祚', '江苏文艺出版社', '2017-10-01 09:22:11', '46', '文学', 'w06', '2018-05-23 21:23:48', '0', '100');
INSERT INTO `book` VALUES ('30136325', '诗经', '骆玉明 解注 [日] 细井徇 撰绘', '三秦出版社', '2018-04-01 09:22:21', '138', '文学', 'w07', '2018-05-31 05:14:23', '0', '100');
INSERT INTO `book` VALUES ('30171389', '苏东坡传', '林语堂', '湖南文艺出版社', '2018-03-01 09:22:32', '52', '文学', 'w03', '2018-05-21 23:17:49', '0', '100');

-- ----------------------------
-- Table structure for booktype
-- ----------------------------
DROP TABLE IF EXISTS `booktype`;
CREATE TABLE `booktype` (
  `type` varchar(255) NOT NULL COMMENT '图书类别',
  `borrow_day` int(11) NOT NULL COMMENT '可借天数',
  `day_fine` decimal(10,0) DEFAULT NULL COMMENT '图书超期每天罚款金额',
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of booktype
-- ----------------------------
INSERT INTO `booktype` VALUES ('文学', '30', '1');
INSERT INTO `booktype` VALUES ('编程', '30', '1');

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `borrower_number` decimal(10,0) NOT NULL COMMENT '借阅卡号',
  `book_number` decimal(10,0) NOT NULL COMMENT '图书号',
  `borrower_name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `book_name` varchar(20) DEFAULT NULL COMMENT '书名',
  `return_date` datetime DEFAULT NULL COMMENT '实际归还日期',
  `borrowed_date` datetime DEFAULT NULL COMMENT '借出日期',
  `fine` decimal(10,0) DEFAULT NULL COMMENT '罚款'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrow
-- ----------------------------
INSERT INTO `borrow` VALUES ('1', '2024655', '小明', '数据结构', '2018-05-23 11:27:02', '2018-05-23 11:01:01', '0');
INSERT INTO `borrow` VALUES ('1', '2024655', '小明', '数据结构', null, '2018-06-01 10:00:29', null);
INSERT INTO `borrow` VALUES ('1', '2024655', '小明', '数据结构', null, '2018-06-01 10:10:15', null);
INSERT INTO `borrow` VALUES ('2', '2567698', '小刚', '三体', null, '2018-06-01 10:50:43', null);

-- ----------------------------
-- Table structure for borrower
-- ----------------------------
DROP TABLE IF EXISTS `borrower`;
CREATE TABLE `borrower` (
  `card_number` decimal(10,0) NOT NULL COMMENT '借阅卡号',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `sex` varchar(5) NOT NULL COMMENT '性别',
  `id_card_number` varchar(30) NOT NULL COMMENT '身份证号码',
  `work_place` varchar(30) DEFAULT NULL COMMENT '单位',
  `address` varchar(30) DEFAULT NULL COMMENT '家庭住址',
  `phone` varchar(30) DEFAULT NULL COMMENT '联系电话',
  `type` varchar(30) NOT NULL COMMENT '借阅者类别',
  `create_time` datetime NOT NULL COMMENT '办证日期',
  `borrowed` int(11) DEFAULT '0' COMMENT '已借书数目',
  `is_lost` int(11) DEFAULT '0' COMMENT '是否挂失\r\n1、挂失\r\n0、未挂失',
  PRIMARY KEY (`card_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrower
-- ----------------------------
INSERT INTO `borrower` VALUES ('1', '小明', '男', '111111111111111111', '燕山大学', '秦皇岛', '15117963494', '普通会员', '2018-05-22 10:00:01', '3', '0');
INSERT INTO `borrower` VALUES ('2', '小刚', '男', '111111111111111112', '燕山大学', '秦皇岛', '13750376797', '超级会员', '2018-05-22 11:00:03', '1', '0');
INSERT INTO `borrower` VALUES ('3', '小红', '女', '111111111111111113', '燕山大学', '秦皇岛', '18712781759', '普通会员', '2018-05-22 11:23:58', '0', '0');

-- ----------------------------
-- Table structure for borrowertype
-- ----------------------------
DROP TABLE IF EXISTS `borrowertype`;
CREATE TABLE `borrowertype` (
  `type` varchar(20) NOT NULL COMMENT '借阅者类型',
  `borrow_number` int(11) NOT NULL COMMENT '能借出书的数量',
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of borrowertype
-- ----------------------------
INSERT INTO `borrowertype` VALUES ('大会员', '8');
INSERT INTO `borrowertype` VALUES ('普通会员', '5');
INSERT INTO `borrowertype` VALUES ('超级会员', '10');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `is_admin` int(11) DEFAULT NULL COMMENT '是否是管理员',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('lijinliang', '123', '1');
