/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50639
 Source Host           : localhost:3306
 Source Schema         : crmdb

 Target Server Type    : MySQL
 Target Server Version : 50639
 File Encoding         : 65001

 Date: 16/02/2018 15:33:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for crm_class
-- ----------------------------
DROP TABLE IF EXISTS `crm_class`;
CREATE TABLE `crm_class` (
  `classId` varchar(50) NOT NULL,
  `courseTypeId` varchar(255) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `beginTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `totalCount` int(11) DEFAULT NULL,
  `upgradeCount` int(11) DEFAULT NULL,
  `changeCount` int(11) DEFAULT NULL,
  `runoffCount` int(11) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `uploadTime` datetime DEFAULT NULL,
  `uploadPath` varchar(200) DEFAULT NULL,
  `uploadFilename` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`classId`),
  KEY `courseTypeId` (`courseTypeId`),
  CONSTRAINT `crm_class_ibfk_1` FOREIGN KEY (`courseTypeId`) REFERENCES `crm_course_type` (`courseTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_class
-- ----------------------------
BEGIN;
INSERT INTO `crm_class` VALUES ('2c9091c14c78e58b014c78e8cc62000a', '2c9091c14c78e58b014c78e829b70008', '1期', '2015-03-10 00:00:00', '2015-04-30 00:00:00', NULL, 80, 2, 0, 2, '', '2015-04-02 16:33:09', '/WEB-INF/upload/0d7a042741544da988b2d2462c683e57', '(第173期)2015年01月22日 JavaEE就业班.xls');
INSERT INTO `crm_class` VALUES ('2c9091c14c78e58b014c78e9106e000b', '2c9091c14c78e58b014c78e829b70008', '2期', '2015-04-28 00:00:00', '2015-05-27 00:00:00', NULL, 67, 0, 0, 0, '', NULL, NULL, NULL);
INSERT INTO `crm_class` VALUES ('2c9091c14c78e58b014c78e9601a000c', '2c9091c14c78e58b014c78e867b80009', '1期ee', '2015-03-29 00:00:00', '2015-07-13 00:00:00', NULL, 120, 0, 0, 0, '', NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for crm_course_type
-- ----------------------------
DROP TABLE IF EXISTS `crm_course_type`;
CREATE TABLE `crm_course_type` (
  `courseTypeId` varchar(255) NOT NULL,
  `courseCost` double DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `courseName` varchar(500) DEFAULT NULL,
  `remark` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`courseTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_course_type
-- ----------------------------
BEGIN;
INSERT INTO `crm_course_type` VALUES ('2c9091c14c78e58b014c78e829b70008', 2000, 1000, 'java基础', '');
INSERT INTO `crm_course_type` VALUES ('2c9091c14c78e58b014c78e867b80009', 18000, 4000, 'java就业', '');
COMMIT;

-- ----------------------------
-- Table structure for crm_department
-- ----------------------------
DROP TABLE IF EXISTS `crm_department`;
CREATE TABLE `crm_department` (
  `depId` varchar(255) NOT NULL,
  `depName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`depId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_department
-- ----------------------------
BEGIN;
INSERT INTO `crm_department` VALUES ('2c9091c14c78e58b014c78e67de10001', 'java学院');
INSERT INTO `crm_department` VALUES ('2c9091c14c78e58b014c78e68ded0002', '咨询部');
COMMIT;

-- ----------------------------
-- Table structure for crm_post
-- ----------------------------
DROP TABLE IF EXISTS `crm_post`;
CREATE TABLE `crm_post` (
  `postId` varchar(255) NOT NULL,
  `postName` varchar(100) DEFAULT NULL,
  `depId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`postId`),
  KEY `depId` (`depId`),
  CONSTRAINT `crm_post_ibfk_1` FOREIGN KEY (`depId`) REFERENCES `crm_department` (`depId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_post
-- ----------------------------
BEGIN;
INSERT INTO `crm_post` VALUES ('2c9091c14c78e58b014c78e6b34a0003', '总监', '2c9091c14c78e58b014c78e67de10001');
INSERT INTO `crm_post` VALUES ('2c9091c14c78e58b014c78e6d4510004', '讲师', '2c9091c14c78e58b014c78e67de10001');
INSERT INTO `crm_post` VALUES ('2c9091c14c78e58b014c78e6f2340005', '主管', '2c9091c14c78e58b014c78e68ded0002');
COMMIT;

-- ----------------------------
-- Table structure for crm_staff
-- ----------------------------
DROP TABLE IF EXISTS `crm_staff`;
CREATE TABLE `crm_staff` (
  `staffId` varchar(255) NOT NULL,
  `loginName` varchar(100) DEFAULT NULL,
  `loginPwd` varchar(100) DEFAULT NULL,
  `staffName` varchar(100) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `onDutyDate` datetime DEFAULT NULL,
  `postId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`staffId`),
  KEY `postId` (`postId`),
  CONSTRAINT `crm_staff_ibfk_1` FOREIGN KEY (`postId`) REFERENCES `crm_post` (`postId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of crm_staff
-- ----------------------------
BEGIN;
INSERT INTO `crm_staff` VALUES ('2c9091c14c78e58b014c78e5c32a0000', 'jack', '81dc9bdb52d04dc20036dbd8313ed055', '管理员', '男', '2018-02-15 15:01:48', '2c9091c14c78e58b014c78e6b34a0003');
INSERT INTO `crm_staff` VALUES ('2c9091c14c78e58b014c78e759b40006', 'rose', '81dc9bdb52d04dc20036dbd8313ed055', '肉丝', '女', '2013-04-16 00:00:00', '2c9091c14c78e58b014c78e6f2340005');
INSERT INTO `crm_staff` VALUES ('2c9091c14c78e58b014c78e7ecd90007', 'tom', '81dc9bdb52d04dc20036dbd8313ed055', '汤姆', '男', '2014-04-24 00:00:00', '2c9091c14c78e58b014c78e6d4510004');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
