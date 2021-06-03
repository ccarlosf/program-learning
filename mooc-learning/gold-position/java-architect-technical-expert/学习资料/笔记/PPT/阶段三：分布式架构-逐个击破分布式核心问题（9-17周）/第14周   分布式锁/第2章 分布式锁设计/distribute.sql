/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : distribute

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2021-05-31 20:37:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for distribute_lock
-- ----------------------------
DROP TABLE IF EXISTS `distribute_lock`;
CREATE TABLE `distribute_lock` (
  `id` int(11) NOT NULL,
  `business_code` varchar(255) NOT NULL,
  `business_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of distribute_lock
-- ----------------------------
INSERT INTO `distribute_lock` VALUES ('1', 'demo', 'demo演示');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `order_status` int(1) NOT NULL DEFAULT '1' COMMENT '订单状态 1：待支付；',
  `receiver_name` varchar(255) NOT NULL,
  `receiver_mobile` varchar(11) NOT NULL,
  `order_amount` decimal(11,2) NOT NULL,
  `create_time` datetime NOT NULL,
  `create_user` varchar(255) NOT NULL,
  `update_time` datetime NOT NULL,
  `update_user` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('32', '1', 'xxx', '13311112222', '5.00', '2020-09-20 15:44:35', 'xxx', '2020-09-20 15:44:35', 'xxx');

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `purchase_price` decimal(11,2) NOT NULL,
  `purchase_num` int(3) NOT NULL,
  `create_time` datetime NOT NULL,
  `create_user` varchar(255) NOT NULL,
  `update_time` datetime NOT NULL,
  `update_user` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES ('32', '32', '100100', '5.00', '1', '2020-09-20 15:44:35', 'xxx', '2020-09-20 15:44:35', 'xxx');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `product_name` varchar(255) NOT NULL,
  `price` decimal(11,0) NOT NULL,
  `count` int(5) NOT NULL,
  `product_desc` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` varchar(255) NOT NULL,
  `update_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_user` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('100100', '测试商品', '5', '1', '测试商品', '1970-01-01 21:30:05', 'xxx', '2020-09-20 15:44:35', 'xxx');
