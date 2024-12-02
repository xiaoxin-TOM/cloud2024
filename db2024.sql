/*
 Navicat Premium Dump SQL

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80403 (8.4.3)
 Source Host           : localhost:3306
 Source Schema         : db2024

 Target Server Type    : MySQL
 Target Server Version : 80403 (8.4.3)
 File Encoding         : 65001

 Date: 03/12/2024 00:25:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_pay
-- ----------------------------
DROP TABLE IF EXISTS `t_pay`;
CREATE TABLE `t_pay` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `pay_no` varchar(50) NOT NULL COMMENT '支付流水号',
  `order_no` varchar(50) NOT NULL COMMENT '订单流水号',
  `user_id` int DEFAULT '1' COMMENT '用户账号ID',
  `amount` decimal(8,2) NOT NULL DEFAULT '9.90' COMMENT '交易金额',
  `deleted` tinyint unsigned NOT NULL DEFAULT '0' COMMENT '删除标志，默认0不删除，1删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='支付交易表';

-- ----------------------------
-- Records of t_pay
-- ----------------------------
BEGIN;
INSERT INTO `t_pay` (`id`, `pay_no`, `order_no`, `user_id`, `amount`, `deleted`, `create_time`, `update_time`) VALUES (1, 'pay17203699', '6544bafb424a', 1, 9.90, 0, '2024-10-28 23:15:25', '2024-10-28 23:15:25');
INSERT INTO `t_pay` (`id`, `pay_no`, `order_no`, `user_id`, `amount`, `deleted`, `create_time`, `update_time`) VALUES (2, '12333312', '222222', 3333333, 123323.00, 0, '2024-10-31 17:20:57', '2024-10-31 17:20:57');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
