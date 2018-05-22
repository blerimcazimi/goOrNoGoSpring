# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 77.66.47.183 (MySQL 5.6.39)
# Database: tandbud_spring
# Generation Time: 2018-05-22 17:48:11 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table post_likes_or_dislikes
# ------------------------------------------------------------

DROP TABLE IF EXISTS `post_likes_or_dislikes`;

CREATE TABLE `post_likes_or_dislikes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `post_id` int(11) NOT NULL,
  `like_or_dislike` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

LOCK TABLES `post_likes_or_dislikes` WRITE;
/*!40000 ALTER TABLE `post_likes_or_dislikes` DISABLE KEYS */;

INSERT INTO `post_likes_or_dislikes` (`id`, `post_id`, `like_or_dislike`, `userid`)
VALUES
	(1,30,1,1),
	(2,30,1,1),
	(3,30,1,1),
	(4,30,1,1),
	(5,30,0,1),
	(6,30,1,1),
	(7,30,1,1),
	(8,30,1,1),
	(9,30,1,1),
	(10,30,1,1),
	(11,30,1,1),
	(12,30,1,1),
	(13,30,1,1),
	(14,30,1,1),
	(15,30,1,1),
	(16,30,1,1),
	(17,30,1,1),
	(18,30,1,1);

/*!40000 ALTER TABLE `post_likes_or_dislikes` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table posts
# ------------------------------------------------------------

DROP TABLE IF EXISTS `posts`;

CREATE TABLE `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `question` longtext,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

LOCK TABLES `posts` WRITE;
/*!40000 ALTER TABLE `posts` DISABLE KEYS */;

INSERT INTO `posts` (`id`, `userid`, `image_path`, `question`)
VALUES
	(3,1,'test','Ligner jeg en, der laver 90 løg om måneden?'),
	(2,1,'test','Synes I jeg skal købe den her bil i blå farve?');

/*!40000 ALTER TABLE `posts` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table users
# ------------------------------------------------------------

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(80) unsigned NOT NULL AUTO_INCREMENT,
  `facebook` varchar(80) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;

INSERT INTO `users` (`id`, `facebook`)
VALUES
	(1,'825650117586188');

/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
