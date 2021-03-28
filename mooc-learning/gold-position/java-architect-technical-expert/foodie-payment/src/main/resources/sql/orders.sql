/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : mall-pay

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2021-01-17 10:28:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` varchar(64) NOT NULL COMMENT '订单主键',
  `merchant_order_id` varchar(64) NOT NULL COMMENT '商户订单号',
  `merchant_user_id` varchar(64) NOT NULL COMMENT '商户方的发起用户的用户主键id',
  `amount` int(11) NOT NULL COMMENT '实际支付总金额',
  `pay_method` int(11) NOT NULL COMMENT '支付方式',
  `pay_status` int(11) NOT NULL COMMENT '支付状态 10：未支付 20：已支付 30：支付失败 40：已退款',
  `come_from` varchar(128) NOT NULL COMMENT '从哪一端来的，比如从天天吃货这门实战过来的',
  `return_url` varchar(255) NOT NULL COMMENT '支付成功后的通知地址，这个是开发者那一段的，不是第三方支付通知的地址',
  `is_delete` int(11) NOT NULL COMMENT '逻辑删除状态;1: 删除 0:未删除',
  `created_time` datetime NOT NULL COMMENT '创建时间（成交时间）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('200126CSNTGDRKP0', '200126CSNR3W4FNC', '1908189H7TNWDTXP', '1', '1', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 09:57:01');
INSERT INTO `orders` VALUES ('200126CT169RD6K4', '200126CT15ZBCWSW', '1908189H7TNWDTXP', '1', '1', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 09:58:02');
INSERT INTO `orders` VALUES ('200126CTC42ZGT2W', '200126CT91Z3HNXP', '1908189H7TNWDTXP', '1', '1', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 09:59:12');
INSERT INTO `orders` VALUES ('200126CTKXZT7FK4', '200126CTKXGWX6K4', '1908189H7TNWDTXP', '1', '1', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 09:59:49');
INSERT INTO `orders` VALUES ('200126CWDZC6YSA8', '200126CWDZ2W6P28', '1908189H7TNWDTXP', '1', '1', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 10:02:24');
INSERT INTO `orders` VALUES ('200126CX7KM0K214', '200126CX7A2A39AW', '1908189H7TNWDTXP', '1', '1', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 10:04:43');
INSERT INTO `orders` VALUES ('200126DBRN193354', '200126DBRMMZ2RAW', '1908189H7TNWDTXP', '1', '1', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 10:48:16');
INSERT INTO `orders` VALUES ('200126DC1GPG48DP', '200126DC1G9NDSY8', '1908189H7TNWDTXP', '1', '1', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 10:49:06');
INSERT INTO `orders` VALUES ('200126DCD2T9P000', '200126DCBN7Y78BC', '1908189H7TNWDTXP', '1', '1', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 10:50:21');
INSERT INTO `orders` VALUES ('200126DFDPWXFKS8', '200126DFDPCZ49S8', '1908189H7TNWDTXP', '1', '1', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 10:56:25');
INSERT INTO `orders` VALUES ('200126DFPTK71M14', '200126DFP3K992A8', '1908189H7TNWDTXP', '1', '1', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 10:57:11');
INSERT INTO `orders` VALUES ('200126DG3CD7S4PH', '200126DG34Y2YGTC', '1908189H7TNWDTXP', '1', '1', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 10:58:19');
INSERT INTO `orders` VALUES ('200126DM08CWZ44H', '200126DKZ597GT2W', '1908189H7TNWDTXP', '1', '1', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 11:06:59');
INSERT INTO `orders` VALUES ('200126F2328SS3R4', '200126F21KCHY8M8', '1908189H7TNWDTXP', '1', '1', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 11:43:19');
INSERT INTO `orders` VALUES ('200126F2KT4AANR4', '200126F2KB8SGZ9P', '1908189H7TNWDTXP', '1', '1', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 11:44:54');
INSERT INTO `orders` VALUES ('200126F2S73AN6RP', '200126F2RYM07Y14', '1908189H7TNWDTXP', '1', '1', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 11:45:22');
INSERT INTO `orders` VALUES ('200126GH6SPXA9KP', '200126GH6DX1G44H', '1908189H7TNWDTXP', '1', '1', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 13:49:49');
INSERT INTO `orders` VALUES ('200126GH999DZNF8', '200126GH98Z3Z9P0', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 13:50:05');
INSERT INTO `orders` VALUES ('200126GHKYWFF0DP', '200126GHHS35KKAW', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 13:51:01');
INSERT INTO `orders` VALUES ('200126GHS2RK3B0H', '200126GHRPG08G0H', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 13:51:28');
INSERT INTO `orders` VALUES ('200126GHXH4YFSNC', '200126GHX6GX0RWH', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 13:51:50');
INSERT INTO `orders` VALUES ('200126GMWP3NF2RP', '200126GMD41TDYW0', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 13:57:45');
INSERT INTO `orders` VALUES ('200126GMWP8298H0', '200126GMN9FY8ACH', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 13:57:45');
INSERT INTO `orders` VALUES ('200126GMX0FZX9GC', '200126GMS08KRCDP', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 13:57:47');
INSERT INTO `orders` VALUES ('200126GMX0KSAK40', '200126GMK1Y4KB54', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 13:57:47');
INSERT INTO `orders` VALUES ('200126GMX0N790BC', '200126GMKP68WSW0', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 13:57:47');
INSERT INTO `orders` VALUES ('200126GMX0PDC9S8', '200126GMK0MH9K1P', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 13:57:47');
INSERT INTO `orders` VALUES ('200126GMX0RSZ63C', '200126GMGB4P632W', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 13:57:47');
INSERT INTO `orders` VALUES ('200126GN0TAKPZC0', '200126GN0T0B44H0', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 13:58:11');
INSERT INTO `orders` VALUES ('200126GNB7NY2KS8', '200126GNB7CKAKD4', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 13:59:18');
INSERT INTO `orders` VALUES ('200126GP0154X028', '200126GP00XDYAY8', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 14:01:06');
INSERT INTO `orders` VALUES ('200126GPF5FBNAA8', '200126GPF598AYY8', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 14:02:37');
INSERT INTO `orders` VALUES ('200126GPPTM9ZBMW', '200126GPPTCR0WDP', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 14:03:20');
INSERT INTO `orders` VALUES ('200126GR610HH18H', '200126GR0WD99CSW', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 14:04:45');
INSERT INTO `orders` VALUES ('200126GRMDP7BDKP', '200126GRKZ1K7DYW', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 14:06:05');
INSERT INTO `orders` VALUES ('200126GRXP9MK028', '200126GRXAGK62RP', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 14:06:52');
INSERT INTO `orders` VALUES ('200126GSASTP4H00', '200126GSABF18MK4', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 14:08:16');
INSERT INTO `orders` VALUES ('200126GSS9MHYHDP', '200126GSRWA9GMFW', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 14:09:30');
INSERT INTO `orders` VALUES ('200126GTASBM7RD4', '200126GT9RP43N54', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 14:11:16');
INSERT INTO `orders` VALUES ('200126GTHPKF0754', '200126GTHPA1WNXP', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 14:11:54');
INSERT INTO `orders` VALUES ('200126GW1AT8XK1P', '200126GW1AK68Y3C', '1908189H7TNWDTXP', '1', '2', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 14:13:16');
INSERT INTO `orders` VALUES ('200126GXHRNTA3R4', '200126GXHRCFM3C0', '1908189H7TNWDTXP', '1', '1', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-26 14:17:55');
INSERT INTO `orders` VALUES ('200127GD1XWPDAW0', '200127GD0N0SDA5P', '1908189H7TNWDTXP', '1', '1', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-27 13:40:17');
INSERT INTO `orders` VALUES ('2001288HP6KCK214', '2001288HM4D6M23C', '1908189H7TNWDTXP', '1', '1', '10', '天天吃货', 'http://localhost:8088/orders/notifyMerchantOrderPaid', '0', '2020-01-28 04:02:46');
