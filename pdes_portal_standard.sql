/*
 Navicat Premium Data Transfer

 Source Server         : 量子
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 111.204.202.54:62091
 Source Schema         : portal

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 20/12/2022 19:51:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pdes_portal_standard
-- ----------------------------
DROP TABLE IF EXISTS `pdes_portal_standard`;
CREATE TABLE `pdes_portal_standard`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `description` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `enable_publish` smallint(6) NOT NULL DEFAULT 0 COMMENT '启用发布;0待发布;1已发布',
  `publish_date` datetime NOT NULL COMMENT '发布日期',
  `use_date` datetime NOT NULL COMMENT '实施日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '标准;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdes_portal_standard
-- ----------------------------
INSERT INTO `pdes_portal_standard` VALUES (5, 'test', 'String', 1, '2022-12-09 15:23:42', '2022-12-09 15:23:20');
INSERT INTO `pdes_portal_standard` VALUES (19, 'GB/T 39784-2021 电子档案', '22号发布', 0, '2022-12-20 16:50:24', '2022-12-22 00:00:00');
INSERT INTO `pdes_portal_standard` VALUES (20, 'GB/T 39362-2020 党政机关', '22号凌晨发布', 0, '2022-12-20 17:13:30', '2022-12-22 00:00:00');
INSERT INTO `pdes_portal_standard` VALUES (21, 'DA/T 95—2022行政事业单位一般', '23号凌晨发布', 0, '2022-12-20 17:14:07', '2022-12-23 00:00:00');
INSERT INTO `pdes_portal_standard` VALUES (22, 'DA/T 90—2022档案仿真复制工作规范', '23号凌晨发布', 0, '2022-12-20 17:15:05', '2022-12-23 00:00:00');
INSERT INTO `pdes_portal_standard` VALUES (23, 'DA/T 88-2021产品数据管理(PDM) 系统电子文件归档与电子档案管理规', '21号凌晨发布', 0, '2022-12-20 17:16:31', '2022-12-21 00:00:00');
INSERT INTO `pdes_portal_standard` VALUES (24, 'DA/T 82—2019 基于文档型非关系型数据库的档案数据存储规范', '21号凌晨发布', 0, '2022-12-20 17:17:07', '2022-12-21 00:00:00');
INSERT INTO `pdes_portal_standard` VALUES (25, 'DA/T 80—2019 政府网站网页归档指南', '20号凌晨发布', 0, '2022-12-20 17:17:29', '2022-12-20 00:00:00');
INSERT INTO `pdes_portal_standard` VALUES (26, 'DA/T 77-2019 纸质档案数字复制件光学字符识别（OCR）工作规范', '20号凌晨发布', 0, '2022-12-20 17:19:30', '2022-12-20 00:00:00');
INSERT INTO `pdes_portal_standard` VALUES (27, 'DA/T 76-2019绿色档案馆建筑评价标准', '22号凌晨发布', 0, '2022-12-20 17:19:58', '2022-12-22 00:00:00');
INSERT INTO `pdes_portal_standard` VALUES (28, 'DA/T 74—2019 电子档案存储用可录类蓝光光盘（BD-R）技术要求和应用', '23号发布', 0, '2022-12-20 17:20:31', '2022-12-23 00:00:00');

SET FOREIGN_KEY_CHECKS = 1;
