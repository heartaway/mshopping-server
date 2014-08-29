
use test;

CREATE TABLE `item_house` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_id` longtext COLLATE utf8_bin,
  `title` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `price` double DEFAULT NULL,
  `pic` varchar(126) COLLATE utf8_bin DEFAULT NULL,
  `is_push` bit(1) DEFAULT NULL,
  `push_time` datetime DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;



CREATE TABLE `push_buffer` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_id` bigint(20) DEFAULT NULL,
  `item_house_id` bigint(20) NOT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `pic_url` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `price` double DEFAULT NULL,
  `title` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;



CREATE TABLE `pushed_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` bigint(20) DEFAULT NULL,
  `item_house_id` bigint(20) DEFAULT NULL,
  `push_opt_id` int(11) DEFAULT NULL,
  `push_time` datetime DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  `pic_url` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `title` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `price` double DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=82 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;



CREATE TABLE `push_opt` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `push_time` datetime DEFAULT NULL,
  `item_count` int(11) DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
