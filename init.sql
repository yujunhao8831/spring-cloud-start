/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost
 Source Database       : pijingzhanji

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : utf-8

 Date: 11/18/2017 22:07:59 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `pijingzhanji_order`;
CREATE TABLE `order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(64) DEFAULT NULL COMMENT '订单号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `order`
-- ----------------------------
BEGIN;
INSERT INTO `pijingzhanji_order` VALUES ('1', '20171118220732'), ('2', '20171118220733'), ('3', '20171118220736');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `pijingzhanji_user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(32) NOT NULL COMMENT '用户名(登录名称)',
  `password` varchar(128) NOT NULL COMMENT '密码',
  `password_salt` varchar(32) DEFAULT '-1' COMMENT '盐(目前未用到,目前使用全局的)',
  `nick_name` varchar(128) DEFAULT NULL COMMENT '昵称',
  `real_name` varchar(128) DEFAULT NULL COMMENT '真实姓名',
  `email` varchar(128) DEFAULT NULL COMMENT '电子邮箱',
  `phone` varchar(18) DEFAULT NULL COMMENT '手机号码',
  `user_image_url` varchar(128) DEFAULT NULL COMMENT '用户头像',
  `last_password_reset_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '密码最后重置(修改)日期',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '修改人',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `is_enabled` tinyint(1) NOT NULL DEFAULT '1' COMMENT '账户状态(1:激活,0:锁定)',
  `remark` varchar(128) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `AK_manage_user_username_uk` (`username`) USING BTREE,
  UNIQUE KEY `manage_admin_user_username_uk_index` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `pijingzhanji_user` VALUES ('5', 'admin', '$2a$10$PCraATW//vUUYWZLpvqoQukDDAjlDfsuwsZfhAsqEi9gEp94s05DO', '-1', null, null, null, null, null, '2017-09-01 15:14:04', null, null, '2017-09-01 15:14:04', '2017-09-01 15:14:04', '1', null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
