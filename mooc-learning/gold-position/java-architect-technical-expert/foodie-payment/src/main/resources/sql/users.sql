/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : mall-pay

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2021-01-17 10:28:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `imooc_user_id` varchar(64) DEFAULT NULL COMMENT '用户在mall的用户id',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `end_date` datetime DEFAULT NULL COMMENT '用户访问有效期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('100001', 'imooc', 'imooc', '2022-01-26 17:20:02');
INSERT INTO `users` VALUES ('100002', '123', '123', '2022-03-01 22:05:22');
