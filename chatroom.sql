-- --------------------------------------------------------
-- 主机:                           localhost
-- 服务器版本:                        5.7.17-log - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 chatroom 的数据库结构
DROP DATABASE IF EXISTS `chatroom`;
CREATE DATABASE IF NOT EXISTS `chatroom` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `chatroom`;

-- 导出  表 chatroom.c_user 结构
DROP TABLE IF EXISTS `c_user`;
CREATE TABLE IF NOT EXISTS `c_user` (
  `uid` char(36) NOT NULL COMMENT '用户id',
  `nice_name` varchar(20) NOT NULL COMMENT '用户昵称',
  `head_url` varchar(500) NOT NULL COMMENT '用户头像',
  `status` tinyint(1) NOT NULL COMMENT '用户状态。1-正常；2-冻结',
  `password` varchar(100) NOT NULL COMMENT '用户密码',
  `is_member` tinyint(1) NOT NULL COMMENT '是否是会员。1-是；2-不是',
  `last_login_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次登录时间',
  `version` int(11) NOT NULL COMMENT '数据库版本',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 正在导出表  chatroom.c_user 的数据：~6 rows (大约)
/*!40000 ALTER TABLE `c_user` DISABLE KEYS */;
REPLACE INTO `c_user` (`uid`, `nice_name`, `head_url`, `status`, `password`, `is_member`, `last_login_time`, `version`, `create_time`, `update_time`) VALUES
	('0496d837-0e7c-11e9-833e-309c233cd1e5', 'master', '', 1, '4a76607de2a034f29ccca035009587c8', 2, NULL, 1, '2019-01-02 10:49:03', '2019-01-02 10:49:03'),
	('5b9e56a3-0e65-11e9-833e-309c233cd1e5', 'opsigtesdfsa', '', 1, '14718dd80731e3c79fbbf416d3100a2f', 2, NULL, 1, '2019-01-02 08:06:50', '2019-01-02 08:06:50'),
	('5fb2f0e5-0e7d-11e9-833e-309c233cd1e5', 'test', '', 1, '6a42684f2be600e858f8ebb0a0111449', 2, NULL, 1, '2019-01-02 10:58:45', '2019-01-02 10:58:45'),
	('7cd218a4-100b-11e9-833e-309c233cd1e5', '张三', '', 1, '78f1428238763f20ef0c52c209c273a0', 2, NULL, 1, '2019-01-04 10:28:30', '2019-01-04 10:28:30'),
	('7cf7ebe8-0e65-11e9-833e-309c233cd1e5', 'opsigtesdfsas', '', 1, 'b42647b89afaed97f8e5f370749ec898', 2, NULL, 1, '2019-01-02 08:07:46', '2019-01-02 08:07:46'),
	('eec384a3-0e64-11e9-833e-309c233cd1e5', 'opsigte', '', 1, 'e581e3f0a36a84ade075774439291551', 2, NULL, 1, '2019-01-02 08:03:48', '2019-01-02 08:03:48');
/*!40000 ALTER TABLE `c_user` ENABLE KEYS */;

-- 导出  表 chatroom.c_user_relation 结构
DROP TABLE IF EXISTS `c_user_relation`;
CREATE TABLE IF NOT EXISTS `c_user_relation` (
  `relation_id` char(36) NOT NULL COMMENT '主键id',
  `source_uid` char(36) NOT NULL COMMENT '源uid',
  `target_uid` char(36) NOT NULL COMMENT '好友uid',
  `version` int(11) NOT NULL COMMENT '数据库版本',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户关系表';

-- 正在导出表  chatroom.c_user_relation 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `c_user_relation` DISABLE KEYS */;
REPLACE INTO `c_user_relation` (`relation_id`, `source_uid`, `target_uid`, `version`, `create_time`, `update_time`) VALUES
	('510f6895-0ffd-11e9-833e-309c233cd1e5', 'eec384a3-0e64-11e9-833e-309c233cd1e5', '5fb2f0e5-0e7d-11e9-833e-309c233cd1e5', 1, '2019-01-04 08:47:04', '2019-01-04 08:47:04'),
	('93cb6a04-100a-11e9-833e-309c233cd1e5', '7cf7ebe8-0e65-11e9-833e-309c233cd1e5', 'eec384a3-0e64-11e9-833e-309c233cd1e5', 1, '2019-01-04 10:21:59', '2019-01-04 10:21:59');
/*!40000 ALTER TABLE `c_user_relation` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
