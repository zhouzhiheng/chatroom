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
  `last_login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次登录时间',
  `version` int(11) NOT NULL COMMENT '数据库版本',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- 正在导出表  chatroom.c_user 的数据：~0 rows (大约)
DELETE FROM `c_user`;
/*!40000 ALTER TABLE `c_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `c_user` ENABLE KEYS */;

-- 导出  表 chatroom.c_user_relation 结构
DROP TABLE IF EXISTS `c_user_relation`;
CREATE TABLE IF NOT EXISTS `c_user_relation` (
  `source_uid` char(36) NOT NULL COMMENT '源uid',
  `target_uid` char(36) NOT NULL COMMENT '好友uid',
  `version` int(11) NOT NULL COMMENT '数据库版本',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户关系表';

-- 正在导出表  chatroom.c_user_relation 的数据：~0 rows (大约)
DELETE FROM `c_user_relation`;
/*!40000 ALTER TABLE `c_user_relation` DISABLE KEYS */;
/*!40000 ALTER TABLE `c_user_relation` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
