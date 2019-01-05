/*
 Navicat Premium Data Transfer

 Source Server         : locahost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : chatroom

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 05/01/2019 23:39:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for c_user
-- ----------------------------
DROP TABLE IF EXISTS `c_user`;
CREATE TABLE `c_user`  (
  `uid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `nick_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户昵称',
  `head_url` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户头像',
  `status` tinyint(1) NOT NULL COMMENT '用户状态。1-正常；2-冻结',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `is_member` tinyint(1) NOT NULL COMMENT '是否是会员。1-是；2-不是',
  `last_login_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后一次登录时间',
  `version` int(11) NOT NULL COMMENT '数据库版本',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of c_user
-- ----------------------------
INSERT INTO `c_user` VALUES ('0496d837-0e7c-11e9-833e-309c233cd1e5', 'master', '', 1, '4a76607de2a034f29ccca035009587c8', 2, NULL, 1, '2019-01-02 10:49:03', '2019-01-02 10:49:03');
INSERT INTO `c_user` VALUES ('5b9e56a3-0e65-11e9-833e-309c233cd1e5', 'opsigtesdfsa', '', 1, '14718dd80731e3c79fbbf416d3100a2f', 2, NULL, 1, '2019-01-02 08:06:50', '2019-01-02 08:06:50');
INSERT INTO `c_user` VALUES ('5fb2f0e5-0e7d-11e9-833e-309c233cd1e5', 'test', '', 1, '6a42684f2be600e858f8ebb0a0111449', 2, NULL, 1, '2019-01-02 10:58:45', '2019-01-02 10:58:45');
INSERT INTO `c_user` VALUES ('7cd218a4-100b-11e9-833e-309c233cd1e5', '张三', '', 1, '78f1428238763f20ef0c52c209c273a0', 2, NULL, 1, '2019-01-04 10:28:30', '2019-01-04 10:28:30');
INSERT INTO `c_user` VALUES ('7cf7ebe8-0e65-11e9-833e-309c233cd1e5', 'opsigtesdfsas', '', 1, 'b42647b89afaed97f8e5f370749ec898', 2, NULL, 1, '2019-01-02 08:07:46', '2019-01-02 08:07:46');
INSERT INTO `c_user` VALUES ('eec384a3-0e64-11e9-833e-309c233cd1e5', 'opsigte', '', 1, 'e581e3f0a36a84ade075774439291551', 2, NULL, 1, '2019-01-02 08:03:48', '2019-01-02 08:03:48');

-- ----------------------------
-- Table structure for c_user_relation
-- ----------------------------
DROP TABLE IF EXISTS `c_user_relation`;
CREATE TABLE `c_user_relation`  (
  `relation_id` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主键id',
  `source_uid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '源uid',
  `target_uid` char(36) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '好友uid',
  `version` int(11) NOT NULL COMMENT '数据库版本',
  `create_time` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_time` timestamp(0) NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`relation_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of c_user_relation
-- ----------------------------
INSERT INTO `c_user_relation` VALUES ('510f6895-0ffd-11e9-833e-309c233cd1e5', 'eec384a3-0e64-11e9-833e-309c233cd1e5', '5fb2f0e5-0e7d-11e9-833e-309c233cd1e5', 1, '2019-01-04 08:47:04', '2019-01-04 08:47:04');
INSERT INTO `c_user_relation` VALUES ('93cb6a04-100a-11e9-833e-309c233cd1e5', '7cf7ebe8-0e65-11e9-833e-309c233cd1e5', 'eec384a3-0e64-11e9-833e-309c233cd1e5', 1, '2019-01-04 10:21:59', '2019-01-04 10:21:59');

SET FOREIGN_KEY_CHECKS = 1;
