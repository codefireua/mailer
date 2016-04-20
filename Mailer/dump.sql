/*
Navicat MySQL Data Transfer

Source Server         : MySQLlocalhost
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : mailer

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2016-04-21 01:40:53
*/

CREATE SCHEMA IF NOT EXISTS `mailer` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mailer` ;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for access_group
-- ----------------------------
DROP TABLE IF EXISTS `access_group`;
CREATE TABLE `access_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `moderator` int(255) DEFAULT NULL,
  `user` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `usr_id` (`user_id`),
  CONSTRAINT `usr_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of access_group
-- ----------------------------

-- ----------------------------
-- Table structure for contact_list
-- ----------------------------
DROP TABLE IF EXISTS `contact_list`;
CREATE TABLE `contact_list` (
  `contact_id` int(11) NOT NULL AUTO_INCREMENT,
  `contact_name` varchar(255) DEFAULT NULL,
  `contact_email` varchar(255) DEFAULT NULL,
  `contact_phone` varchar(255) DEFAULT NULL,
  `user_id` int(255) DEFAULT NULL,
  `contact_group` int(255) DEFAULT NULL,
  PRIMARY KEY (`contact_id`),
  KEY `contact_owner` (`user_id`),
  KEY `FK_contact_list_group_contacts_group_id` (`contact_group`),
  CONSTRAINT `FK_contact_list_group_contacts_group_id` FOREIGN KEY (`contact_group`) REFERENCES `group_contacts` (`group_id`),
  CONSTRAINT `contact_owner` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contact_list
-- ----------------------------

-- ----------------------------
-- Table structure for delivery
-- ----------------------------
DROP TABLE IF EXISTS `delivery`;
CREATE TABLE `delivery` (
  `delivery_id` int(11) NOT NULL AUTO_INCREMENT,
  `delivery_owner` int(255) DEFAULT NULL,
  `delivery_shablon_name` varchar(255) DEFAULT NULL,
  `delivery_from` varchar(255) DEFAULT NULL,
  `delivery_subject` varchar(255) DEFAULT NULL,
  `delivery_body_message` text,
  `delivery_date` datetime DEFAULT NULL,
  PRIMARY KEY (`delivery_id`),
  KEY `delivery_owner_fk` (`delivery_owner`) USING BTREE,
  CONSTRAINT `delivery_owner_fk` FOREIGN KEY (`delivery_owner`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of delivery
-- ----------------------------

-- ----------------------------
-- Table structure for delivery_contact_list
-- ----------------------------
DROP TABLE IF EXISTS `delivery_contact_list`;
CREATE TABLE `delivery_contact_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delivery_id` int(11) NOT NULL,
  `contact_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `contact_fk` (`contact_id`),
  KEY `delivery_id_fk` (`delivery_id`),
  CONSTRAINT `contact_fk` FOREIGN KEY (`contact_id`) REFERENCES `contact_list` (`contact_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `delivery_id_fk` FOREIGN KEY (`delivery_id`) REFERENCES `delivery` (`delivery_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of delivery_contact_list
-- ----------------------------

-- ----------------------------
-- Table structure for delivery_type
-- ----------------------------
DROP TABLE IF EXISTS `delivery_type`;
CREATE TABLE `delivery_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `delivery_id` int(11) NOT NULL,
  `eml_delivery` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `delivery_id_fk_idx` (`delivery_id`),
  KEY `delivery_fk_idx` (`delivery_id`),
  CONSTRAINT `delivery_fk` FOREIGN KEY (`delivery_id`) REFERENCES `delivery` (`delivery_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of delivery_type
-- ----------------------------

-- ----------------------------
-- Table structure for eml_blank
-- ----------------------------
DROP TABLE IF EXISTS `eml_blank`;
CREATE TABLE `eml_blank` (
  `eml_blank_id` int(11) NOT NULL,
  `blank_name` varchar(255) DEFAULT NULL,
  `blank_header` int(255) DEFAULT NULL,
  `blank_body` int(255) DEFAULT NULL,
  PRIMARY KEY (`eml_blank_id`),
  KEY `blank_header_fk` (`blank_header`),
  KEY `blank_body_fk` (`blank_body`),
  CONSTRAINT `blank_body_fk` FOREIGN KEY (`blank_body`) REFERENCES `eml_body_blank` (`body_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `blank_header_fk` FOREIGN KEY (`blank_header`) REFERENCES `eml_header_blank` (`header_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eml_blank
-- ----------------------------

-- ----------------------------
-- Table structure for eml_body_blank
-- ----------------------------
DROP TABLE IF EXISTS `eml_body_blank`;
CREATE TABLE `eml_body_blank` (
  `body_id` int(11) NOT NULL,
  `body_body` text,
  PRIMARY KEY (`body_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eml_body_blank
-- ----------------------------

-- ----------------------------
-- Table structure for eml_header_blank
-- ----------------------------
DROP TABLE IF EXISTS `eml_header_blank`;
CREATE TABLE `eml_header_blank` (
  `header_id` int(11) NOT NULL,
  `header_body` text,
  PRIMARY KEY (`header_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eml_header_blank
-- ----------------------------

-- ----------------------------
-- Table structure for eml_users_template
-- ----------------------------
DROP TABLE IF EXISTS `eml_users_template`;
CREATE TABLE `eml_users_template` (
  `template_id` int(11) NOT NULL,
  `template_name` varchar(255) DEFAULT NULL,
  `template_header` text,
  `template_body` text,
  `template_owner` int(255) DEFAULT NULL,
  PRIMARY KEY (`template_id`),
  KEY `shablon_owner` (`template_owner`),
  CONSTRAINT `shablon_owner` FOREIGN KEY (`template_owner`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of eml_users_template
-- ----------------------------

-- ----------------------------
-- Table structure for group_contacts
-- ----------------------------
DROP TABLE IF EXISTS `group_contacts`;
CREATE TABLE `group_contacts` (
  `group_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(255) DEFAULT NULL,
  `group_owner` int(255) DEFAULT NULL,
  PRIMARY KEY (`group_id`),
  KEY `group_owner_fk` (`group_owner`),
  CONSTRAINT `group_owner_fk` FOREIGN KEY (`group_owner`) REFERENCES `users` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_contacts
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_email` varchar(255) NOT NULL,
  `user_pwd` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_email` (`user_email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
