/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.18 : Database - shortmessage
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`shortmessage` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `shortmessage`;

/*Table structure for table `shortmessage` */

DROP TABLE IF EXISTS `shortmessage`;

CREATE TABLE `shortmessage` (
  `id` bigint(20) unsigned NOT NULL COMMENT '主键',
  `short_key` varchar(20) NOT NULL COMMENT '短标识',
  `original_url` varchar(800) NOT NULL COMMENT '原始连接',
  `biz` int(11) DEFAULT '1' COMMENT '业务类型1上上签发送短信连接,2小程序生成二维码参数',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `expire_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '超期时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_uniq_short_key` (`short_key`),
  UNIQUE KEY `idx_uniq_original_key` (`original_url`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
