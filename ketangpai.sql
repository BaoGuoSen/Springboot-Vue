/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : ketangpai

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-12-30 21:12:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `cname` varchar(255) DEFAULT NULL,
  `cflag` int(255) NOT NULL,
  `uid` int(11) DEFAULT NULL,
  `state` tinyint(1) DEFAULT NULL,
  `wid` int(255) DEFAULT NULL,
  `teacher` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cflag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('顶点', '123', '2', '1', null, '周鹏');
INSERT INTO `course` VALUES ('高级Java', '124', '2', '1', null, '周鹏');
INSERT INTO `course` VALUES ('编辑后', '333', '5', '1', null, '刘洋');

-- ----------------------------
-- Table structure for c_stu
-- ----------------------------
DROP TABLE IF EXISTS `c_stu`;
CREATE TABLE `c_stu` (
  `cflag` int(255) NOT NULL,
  `uid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of c_stu
-- ----------------------------
INSERT INTO `c_stu` VALUES ('123', '1');
INSERT INTO `c_stu` VALUES ('123', '3');
INSERT INTO `c_stu` VALUES ('123', '4');
INSERT INTO `c_stu` VALUES ('124', '1');
INSERT INTO `c_stu` VALUES ('666', '1');
INSERT INTO `c_stu` VALUES ('123', '6');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `namezw` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'teacher', '老师');
INSERT INTO `role` VALUES ('2', 'student', '学生');

-- ----------------------------
-- Table structure for upwork
-- ----------------------------
DROP TABLE IF EXISTS `upwork`;
CREATE TABLE `upwork` (
  `wid` int(255) NOT NULL,
  `id` int(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `score` int(10) DEFAULT NULL,
  `fileurl` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of upwork
-- ----------------------------
INSERT INTO `upwork` VALUES ('1', '1', '包国森', '99', 'http://127.0.0.1:8080/image/1576943255270.jpg');
INSERT INTO `upwork` VALUES ('4', '1', '包国森', '99', 'http://127.0.0.1:8080/image/1577065777302.png');
INSERT INTO `upwork` VALUES ('2', '1', '包国森', '99', 'http://127.0.0.1:8080/image/1577065807630.png');
INSERT INTO `upwork` VALUES ('1', '3', '许雄兵', '44', 'http://127.0.0.1:8080/image/1577072095051.png');
INSERT INTO `upwork` VALUES ('1', '6', '周冰鑫', '45', 'http://127.0.0.1:8080/image/1577632147229.png');
INSERT INTO `upwork` VALUES ('2', '1', '包国森', null, 'http://127.0.0.1:8080/image/1577703434533.doc');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `locked` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '包国森', '$2a$10$U17.vhZ68.0Fmg2gkqVLQuFOirMIkaeG4NBTO247IdmKgIapIkh02', '1', '0');
INSERT INTO `user` VALUES ('2', '周鹏', '$2a$10$6IH9Xu/XNhXVeXapGZrdfeBen23iazAUXsN9k8GnkA1PafK1DvR06', '1', '0');
INSERT INTO `user` VALUES ('3', '许雄兵', '$2a$10$G2ho53k5dNccetgeOrauROfxY.8oJA.FYlGKCd.vOAqkN05lbwVJO', '1', '0');
INSERT INTO `user` VALUES ('4', '包流量', '$2a$10$G2ho53k5dNccetgeOrauROfxY.8oJA.FYlGKCd.vOAqkN05lbwVJO', '1', '0');
INSERT INTO `user` VALUES ('5', '刘洋', '$2a$10$QPy2TAGWu8OFuZvIjckXoO2bFvQbVuYL1DoMUPasMHGNuZdMXrDdC', '1', '0');
INSERT INTO `user` VALUES ('6', '周冰鑫', '$2a$10$wgG7VjLR4PkkH2cl8bHeBOk8RL9C9E/ur8hZ5U2CgqOC1Ae7bN0Z.', '1', '0');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '2');
INSERT INTO `user_role` VALUES ('2', '2', '1');
INSERT INTO `user_role` VALUES ('9', '3', '2');
INSERT INTO `user_role` VALUES ('10', '4', '2');
INSERT INTO `user_role` VALUES ('11', '5', '1');
INSERT INTO `user_role` VALUES ('12', '5', '1');
INSERT INTO `user_role` VALUES ('13', '6', '2');

-- ----------------------------
-- Table structure for work
-- ----------------------------
DROP TABLE IF EXISTS `work`;
CREATE TABLE `work` (
  `cflag` int(255) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) NOT NULL,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `deadline` datetime DEFAULT NULL,
  `wid` int(255) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`wid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of work
-- ----------------------------
INSERT INTO `work` VALUES ('123', '二分查找', '二分查找也称折半查找（Binary Search），它是一种效率较高的查找方法。但是，折半查找要求线性表必须采用顺序存储结构，而且表中元素按关键字有序排列。', '2019-12-19 00:00:00', '2019-12-27 00:00:00', '1');
INSERT INTO `work` VALUES ('123', '欧拉回路', '如果图G中的一个路径包括每个边恰好一次，则该路径称为欧拉路径(Euler path)。', '2019-12-22 00:00:00', '2020-01-18 00:00:00', '2');
INSERT INTO `work` VALUES ('124', 'java作业', '测试content', '2019-12-04 00:00:00', '2019-12-22 00:00:00', '4');
INSERT INTO `work` VALUES ('333', '旅行商问题', '作业描述', '2019-12-29 00:00:00', '2019-12-29 00:00:00', '13');
