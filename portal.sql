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

 Date: 20/12/2022 09:39:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pdes_portal_annals
-- ----------------------------
DROP TABLE IF EXISTS `pdes_portal_annals`;
CREATE TABLE `pdes_portal_annals`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `content_abstract` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '摘要',
  `enable_publish` smallint(6) NOT NULL DEFAULT 0 COMMENT '启用发布;0=待发布，1=已发布',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '年鉴' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdes_portal_annals
-- ----------------------------

-- ----------------------------
-- Table structure for pdes_portal_annals_file
-- ----------------------------
DROP TABLE IF EXISTS `pdes_portal_annals_file`;
CREATE TABLE `pdes_portal_annals_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键;附件ID',
  `annals_id` int(11) NOT NULL COMMENT '年鉴ID',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '附件标题',
  `file_size` int(11) NOT NULL COMMENT '附件大小',
  `file_suffix` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '后缀',
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '存储路径',
  `memo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `order_seq` int(11) NOT NULL COMMENT '排序号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '年鉴附件' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdes_portal_annals_file
-- ----------------------------

-- ----------------------------
-- Table structure for pdes_portal_chronicle_events
-- ----------------------------
DROP TABLE IF EXISTS `pdes_portal_chronicle_events`;
CREATE TABLE `pdes_portal_chronicle_events`  (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `content_abstract` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '摘要',
  `enable_publish` smallint(6) NOT NULL DEFAULT 0 COMMENT '启用发布;0=待发布，1=已发布',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '档案大事记' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdes_portal_chronicle_events
-- ----------------------------
INSERT INTO `pdes_portal_chronicle_events` VALUES (8, '市委书记武文罡主持召开视频会议', '市委书记武文罡主持召开视频会议，部署调度全市近期重点工作。市长王浩传达省委专题会议精神。市委副书记、政法委书记范永斌，市委常委高晶华、陈莲、罗武侠在主会场参会', '视频会议', 0, '2022-12-03 11:24:58', '2022-12-10 21:37:56');
INSERT INTO `pdes_portal_chronicle_events` VALUES (9, '市委书记武文罡主持召开视频会议', '市委书记武文罡主持召开视频会议，部署调度全市近期重点工作。市长王浩传达省委专题会议精神。市委副书记、政法委书记范永斌，市委常委高晶华、陈莲、罗武侠在主会场参会', '会议', 1, '2022-12-04 11:24:58', '2022-12-08 10:55:21');
INSERT INTO `pdes_portal_chronicle_events` VALUES (10, '国家档案局关于印发《国家档案局优秀科技成果奖励办法》的通知', '各省、自治区、直辖市档案局，新疆生产建设兵团档案局，中央和国家机关各部委档案部门，中央军委办公厅保密和档案局，各人民团体档案部门，各中央企业档案部门：现将《国家档案局优秀科技成果奖励办法》印发给你们，请认真遵照执行。', '国家档案局优秀科技成果奖励办法', 0, '2022-12-04 11:24:58', '2022-12-10 21:06:18');
INSERT INTO `pdes_portal_chronicle_events` VALUES (13, '国家档案局关于印发《国家档案局优秀科技成果奖励办法》的通知', '各省、自治区、直辖市档案局，新疆生产建设兵团档案局，中央和国家机关各部委档案部门，中央军委办公厅保密和档案局，各人民团体档案部门，各中央企业档案部门：现将《国家档案局优秀科技成果奖励办法》印发给你们，请认真遵照执行。', '国家档案局优秀科技成果奖励办法', 1, '2022-12-10 20:44:50', '2022-12-10 20:44:50');

-- ----------------------------
-- Table structure for pdes_portal_chronicle_events_file
-- ----------------------------
DROP TABLE IF EXISTS `pdes_portal_chronicle_events_file`;
CREATE TABLE `pdes_portal_chronicle_events_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键;附件ID',
  `chronicle_events_id` int(11) NOT NULL COMMENT '大事记ID',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '附件标题',
  `file_size` int(11) NOT NULL COMMENT '附件大小',
  `file_suffix` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '后缀',
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '存储路径',
  `memo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `order_seq` int(11) NOT NULL COMMENT '排序号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '档案大事记附件' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdes_portal_chronicle_events_file
-- ----------------------------
INSERT INTO `pdes_portal_chronicle_events_file` VALUES (3, 10, 'meeting.jpg', 4, 'jpg', 'http://uplaod-189989.oss-cn-hangzhou.aliyuncs.com/meeting.jpg', '图片', 1, '2022-12-08 12:17:09', NULL);
INSERT INTO `pdes_portal_chronicle_events_file` VALUES (20, 6, 'meeting.jpg', 21232, 'jpg', 'http://uplaod-189989.oss-cn-hangzhou.aliyuncs.com/meeting.jpg', '发发发', 0, '2022-12-10 13:42:41', '2022-12-10 21:05:02');
INSERT INTO `pdes_portal_chronicle_events_file` VALUES (24, 10, '幸福时刻 - Light Wedding Piano.mp3', 2139549, 'mp3', 'http://www.patrickstarm.top:9090/pde-file/chronicle/306f633b-248d-4be1-a8c9-b710d9c588c2.mp3', '发发发', 0, '2022-12-10 13:43:48', '2022-12-10 13:43:48');
INSERT INTO `pdes_portal_chronicle_events_file` VALUES (26, 6, 'meeting.jpg', 21232, 'jpg', 'http://uplaod-189989.oss-cn-hangzhou.aliyuncs.com/meeting.jpg', NULL, 0, '2022-12-10 20:39:20', '2022-12-10 20:39:20');
INSERT INTO `pdes_portal_chronicle_events_file` VALUES (27, 6, 'meeting.jpg', 21232, 'jpg', 'http://uplaod-189989.oss-cn-hangzhou.aliyuncs.com/meeting.jpg', NULL, 0, '2022-12-10 20:50:58', '2022-12-10 20:50:58');
INSERT INTO `pdes_portal_chronicle_events_file` VALUES (33, 8, '121285525_prev.m4a', 2852707, 'm4a', 'http://www.patrickstarm.top:9090/pde-file/chronicle/5d1d29bb-6739-4bbd-8848-e0144a541d9e.m4a', '测试', 1, '2022-12-19 10:47:29', '2022-12-19 11:02:29');
INSERT INTO `pdes_portal_chronicle_events_file` VALUES (34, 8, 'Love Home 17.00', 2521173, '00', 'http://www.patrickstarm.top:9090/pde-file/chronicle/fd68c661-d2e8-4ee2-aa1e-aec62db82073.00', '的', 1, '2022-12-19 10:48:25', '2022-12-19 10:48:25');
INSERT INTO `pdes_portal_chronicle_events_file` VALUES (35, 13, '4.jpg', 33828, 'jpg', 'http://www.patrickstarm.top:9090/pde-file/chronicle/553e5b95-070a-40d3-812f-0fe9dd9ed0e4.jpg', '图片', 1, '2022-12-19 12:03:45', '2022-12-19 12:03:45');

-- ----------------------------
-- Table structure for pdes_portal_honor
-- ----------------------------
DROP TABLE IF EXISTS `pdes_portal_honor`;
CREATE TABLE `pdes_portal_honor`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '相册名称',
  `description` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `enable_publish` smallint(6) NOT NULL DEFAULT 0 COMMENT '启用发布;0待发布;1已发布',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '荣誉档案(相册);' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdes_portal_honor
-- ----------------------------
INSERT INTO `pdes_portal_honor` VALUES (1, '苏州市档案', '苏州市历史档案记录', 0, '2022-12-02 06:25:34');
INSERT INTO `pdes_portal_honor` VALUES (3, '江阴档案馆', '江阴历史档案馆', 0, '2022-12-08 09:52:48');
INSERT INTO `pdes_portal_honor` VALUES (4, '云南市档案', '云南市历史档案', 1, '2022-12-02 06:30:45');
INSERT INTO `pdes_portal_honor` VALUES (11, '中国档案', '中国历史档案', 1, '2022-12-08 11:19:37');
INSERT INTO `pdes_portal_honor` VALUES (12, '河北档案', '河北历史档案', 1, '2022-12-08 11:20:21');
INSERT INTO `pdes_portal_honor` VALUES (13, '北京档案', '北京历史档案', 0, '2022-12-08 11:25:44');
INSERT INTO `pdes_portal_honor` VALUES (14, '天津档案', '天津历史档案', 1, '2022-12-08 11:25:59');

-- ----------------------------
-- Table structure for pdes_portal_honor_file
-- ----------------------------
DROP TABLE IF EXISTS `pdes_portal_honor_file`;
CREATE TABLE `pdes_portal_honor_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `honor_id` int(11) NOT NULL COMMENT '相册ID',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名',
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件路径',
  `file_size` int(11) NOT NULL COMMENT '文件大小',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `enable_front` smallint(6) NULL DEFAULT 0 COMMENT '开启封面;0内页;1封面',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '荣誉档案文件表;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdes_portal_honor_file
-- ----------------------------
INSERT INTO `pdes_portal_honor_file` VALUES (1, 3, '测', 'https://chl-bucket.oss-cn-hangzhou.aliyuncs.com/avatar/head1.jpg', 8402, '2022-12-02 06:34:51', 0);
INSERT INTO `pdes_portal_honor_file` VALUES (3, 1, '测试2', 'http://www.patrickstarm.top:9090/pde-file/honor/d437dbef-65d1-4f4b-bfb4-328a18794f5e.jpg', 1050114, '2022-12-02 06:35:02', 0);
INSERT INTO `pdes_portal_honor_file` VALUES (9, 3, '档案图片', 'https://chl-bucket.oss-cn-hangzhou.aliyuncs.com/banner/banner11.jpg', 9718, '2022-12-06 07:39:42', 0);
INSERT INTO `pdes_portal_honor_file` VALUES (10, 3, '档案图片', 'https://chl-bucket.oss-cn-hangzhou.aliyuncs.com/banner/banner12.jpg', 25984, '2022-12-06 07:39:55', 0);
INSERT INTO `pdes_portal_honor_file` VALUES (11, 3, '档案图片', 'https://chl-bucket.oss-cn-hangzhou.aliyuncs.com/banner/banner13.jpg', 27080, '2022-12-06 07:40:03', 0);
INSERT INTO `pdes_portal_honor_file` VALUES (12, 3, '档案图片', 'https://chl-bucket.oss-cn-hangzhou.aliyuncs.com/banner/banner13.jpg', 27080, '2022-12-06 07:40:09', 0);
INSERT INTO `pdes_portal_honor_file` VALUES (13, 12, '档案', 'http://www.patrickstarm.top:9090/pde-file/honor/75f3e591-22a4-4419-bd54-0df707fd93a1.png', 209599, '2022-12-06 07:40:15', 0);
INSERT INTO `pdes_portal_honor_file` VALUES (14, 3, '档案图片', 'https://chl-bucket.oss-cn-hangzhou.aliyuncs.com/banner/banner3.jpg', 10168, '2022-12-06 07:40:21', 0);
INSERT INTO `pdes_portal_honor_file` VALUES (15, 3, '档案图片', 'https://chl-bucket.oss-cn-hangzhou.aliyuncs.com/banner/banner3.jpg', 10168, '2022-12-06 07:40:28', 0);
INSERT INTO `pdes_portal_honor_file` VALUES (16, 3, '档案图片', 'https://chl-bucket.oss-cn-hangzhou.aliyuncs.com/banner/banner5.jpg', 11716, '2022-12-06 07:40:34', 0);
INSERT INTO `pdes_portal_honor_file` VALUES (17, 11, '档案图片', 'http://www.patrickstarm.top:9090/pde-file/honor/5fcd55e2-7477-4ff1-93cf-a5b24e254c51.jpg', 8704, '2022-12-06 07:45:39', 0);
INSERT INTO `pdes_portal_honor_file` VALUES (20, 4, '无脸男', 'http://www.patrickstarm.top:9090/pde-file/honor/727b2e65-90a6-4b8c-92ac-e2263d6f1f21.png', 209599, '2022-12-08 22:19:59', 0);
INSERT INTO `pdes_portal_honor_file` VALUES (22, 3, '测试文件上传', 'http://www.patrickstarm.top:9090/pde-file/honor/b0b5953b-add0-4ece-81dc-e42f1cd9a541.jpg', 462358, '2022-12-09 09:41:09', 0);
INSERT INTO `pdes_portal_honor_file` VALUES (23, 1, '新增图片', 'http://www.patrickstarm.top:9090/pde-file/honor/c38b0cf4-04a4-4c8e-8406-1ab35094e9bb.jpg', 2069036, '2022-12-09 09:48:47', 0);
INSERT INTO `pdes_portal_honor_file` VALUES (24, 3, '测试上传图片', 'http://www.patrickstarm.top:9090/pde-file/honor/481aeba6-cf35-47dc-8923-d1e076f24416.jpg', 5435, '2022-12-19 09:40:19', 0);
INSERT INTO `pdes_portal_honor_file` VALUES (25, 3, '北京档案馆', 'http://www.patrickstarm.top:9090/pde-file/honor/f7632497-0dae-406b-8b7d-071693ca5880.jpg', 1876, '2022-12-19 09:51:10', 0);
INSERT INTO `pdes_portal_honor_file` VALUES (26, 3, '测试查询', 'http://www.patrickstarm.top:9090/pde-file/honor/e111dd5a-463b-4ed4-b462-e91ed1ca242f.jpg', 44308, '2022-12-19 09:52:49', 0);
INSERT INTO `pdes_portal_honor_file` VALUES (27, 3, '测试查询2', 'http://www.patrickstarm.top:9090/pde-file/honor/372bea83-7286-4e33-bde4-027bfa35da16.jpg', 36960, '2022-12-19 09:53:32', 0);
INSERT INTO `pdes_portal_honor_file` VALUES (28, 3, '测试数据', 'http://www.patrickstarm.top:9090/pde-file/honor/50761e12-1f73-4613-afaa-9cdf6973baac.jpg', 8402, '2022-12-19 09:54:22', 0);
INSERT INTO `pdes_portal_honor_file` VALUES (29, 3, '测试数据', 'http://www.patrickstarm.top:9090/pde-file/honor/fb919c97-1fa2-4b2f-ab78-45d2af8c6e96.jpg', 33792, '2022-12-19 09:55:18', 1);
INSERT INTO `pdes_portal_honor_file` VALUES (30, 12, '测试数据', 'http://www.patrickstarm.top:9090/pde-file/honor/761450b7-a2a0-4269-b5b4-864fccbcfbd8.jpg', 30054, '2022-12-19 10:06:01', 1);
INSERT INTO `pdes_portal_honor_file` VALUES (31, 11, '钱钱钱', 'http://www.patrickstarm.top:9090/pde-file/honor/96818d8d-6c52-404b-ab0f-b8420c941e5a.jpg', 19806, '2022-12-19 10:09:07', 0);
INSERT INTO `pdes_portal_honor_file` VALUES (32, 11, '测试数据', 'http://www.patrickstarm.top:9090/pde-file/honor/901b4058-078a-4223-bf15-a0727cbdb4c0.jpg', 9040, '2022-12-19 10:11:02', 1);
INSERT INTO `pdes_portal_honor_file` VALUES (33, 4, 'head1.jpg', 'http://www.patrickstarm.top:9090/pde-file/honor/2d9f80d9-b685-4432-b8a8-5c35fe664f7a.jpg', 8402, '2022-12-20 08:44:54', 0);
INSERT INTO `pdes_portal_honor_file` VALUES (34, 4, 'head1.jpg', 'http://www.patrickstarm.top:9090/pde-file/honor/2d9f80d9-b685-4432-b8a8-5c35fe664f7a.jpg', 8402, '2022-12-20 08:44:55', 1);
INSERT INTO `pdes_portal_honor_file` VALUES (35, 4, 'head-0.jpg', 'http://www.patrickstarm.top:9090/pde-file/honor/03f55892-d890-4e0f-bd2b-8197c2e1d31d.jpg', 43107, '2022-12-20 08:45:14', 0);
INSERT INTO `pdes_portal_honor_file` VALUES (36, 1, 'Title.jpg', 'http://www.patrickstarm.top:9090/pde-file/honor/85629328-1c24-46c3-80e6-ab2c79909b9a.png', 1433371, '2022-12-20 09:01:44', 1);

-- ----------------------------
-- Table structure for pdes_portal_news
-- ----------------------------
DROP TABLE IF EXISTS `pdes_portal_news`;
CREATE TABLE `pdes_portal_news`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `content_abstract` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '摘要',
  `enable_publish` smallint(6) NOT NULL DEFAULT 0 COMMENT '启用发布;0=待发布，1=已发布',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '动态新闻' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdes_portal_news
-- ----------------------------
INSERT INTO `pdes_portal_news` VALUES (1, '23', '23', '23', 0, '2022-12-19 02:15:28', NULL);
INSERT INTO `pdes_portal_news` VALUES (2, 'test', 'test', 'test', 0, '2022-12-19 02:15:45', NULL);

-- ----------------------------
-- Table structure for pdes_portal_news_file
-- ----------------------------
DROP TABLE IF EXISTS `pdes_portal_news_file`;
CREATE TABLE `pdes_portal_news_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键;附件ID',
  `news_id` int(11) NOT NULL COMMENT '动态新闻ID',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '附件标题',
  `file_size` int(11) NOT NULL COMMENT '附件大小',
  `file_suffix` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '后缀',
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '存储路径',
  `memo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `order_seq` int(11) NOT NULL COMMENT '排序号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '新闻附件' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdes_portal_news_file
-- ----------------------------
INSERT INTO `pdes_portal_news_file` VALUES (1, 1, '1_HP2-4BAND-3090_4band_arch-500m_1_Instruments.wav', 29524, 'wav', '/users/jarvizshen/downloads/newsFile/other', NULL, -1828856660, '2022-12-19 02:18:26', NULL);

-- ----------------------------
-- Table structure for pdes_portal_notify
-- ----------------------------
DROP TABLE IF EXISTS `pdes_portal_notify`;
CREATE TABLE `pdes_portal_notify`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `content_abstract` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '摘要',
  `enable_publish` smallint(6) NOT NULL DEFAULT 0 COMMENT '启用发布;0=待发布，1=已发布',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '通知公告' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdes_portal_notify
-- ----------------------------
INSERT INTO `pdes_portal_notify` VALUES (1, '14', '<h1 class=\"ql-align-center\"><span style=\"background-color: rgb(255, 153, 0);\">svsfvsfv</span><span style=\"color: rgb(255, 153, 0);\">411cac</span></h1><p class=\"ql-align-center ql-indent-8\"><img src=\"http://www.patrickstarm.top:9090/pde-file/notice/ca82967c-1c03-4aad-b012-6f186654647e.jpg\"></p>', '414vsfv sf', 0, '2022-12-01 02:11:20', '2022-12-19 10:50:10');
INSERT INTO `pdes_portal_notify` VALUES (2, '上海应用技术学院', '火红的萨日朗', '小寒', 1, '2022-10-25 12:39:00', '2022-10-05 10:46:34');
INSERT INTO `pdes_portal_notify` VALUES (5, '武汉工业学院', '演员', '大暑', 1, '2022-05-30 08:46:00', '2022-10-12 01:18:23');
INSERT INTO `pdes_portal_notify` VALUES (6, '青岛港湾职业技术学院', '<p>像我这样的人像我这样的人像我这样</p>', '秋分', 0, '2022-04-09 00:02:39', '2022-12-08 10:55:16');
INSERT INTO `pdes_portal_notify` VALUES (7, '武汉化工学院', '<p>稻香vdavs</p>', '秋分', 0, '2022-04-02 11:20:04', '2022-12-08 10:55:00');
INSERT INTO `pdes_portal_notify` VALUES (9, '河北工业大学', '遇见', '夏至', 0, '2022-11-01 14:13:24', '2022-03-03 04:38:53');
INSERT INTO `pdes_portal_notify` VALUES (10, '沈阳大学', '坏女孩', '清明', 1, '2022-07-03 09:04:22', '2022-04-13 10:12:53');
INSERT INTO `pdes_portal_notify` VALUES (15, '青岛港湾职业技术学院', '像我这样的人', '秋分', 1, '2022-04-09 00:02:39', '2022-08-29 01:13:34');
INSERT INTO `pdes_portal_notify` VALUES (17, '浙江科技学院', '发如雪', '芒种', 0, '2022-08-26 18:13:55', '2022-05-12 12:39:39');
INSERT INTO `pdes_portal_notify` VALUES (18, '河北工业大学', '遇见', '夏至', 0, '2022-11-01 14:13:24', '2022-03-03 04:38:53');
INSERT INTO `pdes_portal_notify` VALUES (19, '沈阳大学', '坏女孩', '清明', 0, '2022-07-03 09:04:22', '2022-04-13 10:12:53');
INSERT INTO `pdes_portal_notify` VALUES (20, '中央司法警官学院', '烟花易冷', '小寒', 0, '2022-01-16 06:30:48', '2022-10-03 10:25:15');
INSERT INTO `pdes_portal_notify` VALUES (21, '山东农业大学', '发如雪', '霜降', 1, '2022-01-16 06:01:57', '2022-09-29 05:00:33');
INSERT INTO `pdes_portal_notify` VALUES (22, '华中农业大学', '手写的从前', '大雪', 0, '2022-10-17 04:12:45', '2022-03-14 15:21:43');
INSERT INTO `pdes_portal_notify` VALUES (23, '集美大学', '漠河舞厅', '寒露', 0, '2022-04-16 06:41:42', '2022-11-19 08:36:35');
INSERT INTO `pdes_portal_notify` VALUES (24, '北京外国语大学', '像我这样的人', '芒种', 0, '2022-05-25 22:44:37', '2022-01-30 14:08:16');
INSERT INTO `pdes_portal_notify` VALUES (25, '中南财经政法大学', '发如雪', '芒种', 1, '2022-04-18 01:17:25', '2022-02-22 07:20:38');
INSERT INTO `pdes_portal_notify` VALUES (26, '南昌大学', '反方向的钟', '秋分', 0, '2022-01-07 07:12:46', '2022-11-22 12:29:17');
INSERT INTO `pdes_portal_notify` VALUES (28, '山东农业大学', '光阴的故事', '大暑', 1, '2022-04-21 17:58:19', '2022-11-02 09:39:44');
INSERT INTO `pdes_portal_notify` VALUES (29, '浙江科技学院', '手写的从前', '大暑', 0, '2022-02-28 07:10:54', '2022-10-02 14:00:26');
INSERT INTO `pdes_portal_notify` VALUES (30, '青岛大学', '像我这样的人', '小满', 1, '2022-10-13 17:00:46', '2022-04-10 17:33:29');
INSERT INTO `pdes_portal_notify` VALUES (31, '上海应用技术学院', '火红的萨日朗', '小寒', 0, '2022-10-25 12:39:00', '2022-10-05 10:46:34');
INSERT INTO `pdes_portal_notify` VALUES (33, '山西财经大学', '发如雪', '处暑', 1, '2022-07-09 20:41:47', '2022-01-04 10:11:56');
INSERT INTO `pdes_portal_notify` VALUES (34, '武汉工业学院', '演员', '大暑', 1, '2022-05-30 08:46:00', '2022-10-12 01:18:23');
INSERT INTO `pdes_portal_notify` VALUES (36, '武汉化工学院', '稻香', '秋分', 0, '2022-04-02 11:20:04', '2022-05-04 04:49:00');
INSERT INTO `pdes_portal_notify` VALUES (37, '浙江科技学院', '发如雪', '芒种', 0, '2022-08-26 18:13:55', '2022-05-12 12:39:39');
INSERT INTO `pdes_portal_notify` VALUES (38, '河北工业大学', '遇见', '夏至', 0, '2022-11-01 14:13:24', '2022-03-03 04:38:53');
INSERT INTO `pdes_portal_notify` VALUES (39, '沈阳大学', '坏女孩', '清明', 0, '2022-07-03 09:04:22', '2022-04-13 10:12:53');
INSERT INTO `pdes_portal_notify` VALUES (40, '中央司法警官学院', '烟花易冷', '小寒', 0, '2022-01-16 06:30:48', '2022-10-03 10:25:15');
INSERT INTO `pdes_portal_notify` VALUES (41, '山东农业大学', '发如雪', '霜降', 0, '2022-01-16 06:01:57', '2022-09-29 05:00:33');
INSERT INTO `pdes_portal_notify` VALUES (42, '华中农业大学', '手写的从前', '大雪', 0, '2022-10-17 04:12:45', '2022-03-14 15:21:43');
INSERT INTO `pdes_portal_notify` VALUES (43, '集美大学', '漠河舞厅', '寒露', 0, '2022-04-16 06:41:42', '2022-11-19 08:36:35');
INSERT INTO `pdes_portal_notify` VALUES (44, '北京外国语大学', '像我这样的人', '芒种', 0, '2022-05-25 22:44:37', '2022-01-30 14:08:16');
INSERT INTO `pdes_portal_notify` VALUES (45, '中南财经政法大学', '发如雪', '芒种', 0, '2022-04-18 01:17:25', '2022-02-22 07:20:38');
INSERT INTO `pdes_portal_notify` VALUES (46, '南昌大学', '反方向的钟', '秋分', 0, '2022-01-07 07:12:46', '2022-11-22 12:29:17');
INSERT INTO `pdes_portal_notify` VALUES (48, '山东农业大学', '光阴的故事', '大暑', 0, '2022-04-21 17:58:19', '2022-11-02 09:39:44');
INSERT INTO `pdes_portal_notify` VALUES (53, '测试标题', '测试内容测试内容测试内容测试内容测试内容测试内容', '测试内容测试内容测试内容', 0, '2022-12-07 02:54:51', '2022-12-07 02:54:51');
INSERT INTO `pdes_portal_notify` VALUES (54, '测试标题', '<p>测<span style=\"color: rgb(61, 20, 102);\">试内容测试内容测试内容测试内容测试内容测试内容</span></p>', '测试内容测试内容测试内容', 0, '2022-12-07 02:56:07', '2022-12-09 18:10:54');
INSERT INTO `pdes_portal_notify` VALUES (55, '测试标题', '测试内容测试内容测试内容测试内容测试内容测试内容', '测试内容测试内容测试内容', 0, '2022-12-07 10:59:54', '2022-12-07 10:59:54');
INSERT INTO `pdes_portal_notify` VALUES (56, '中央档案馆国家档案局2022年度公开招聘工作人员公告', '<p>	根据工作需要，按照《事业单位人事管理条例》和事业单位公开招聘有关政策规定，2022年度面向应届高校毕业生公开招聘工作人员5名。现将有关具体事项公告如下。</p><p>	一、招聘单位基本情况</p><p>	中国档案报社是全国档案工作的重要舆论阵地，主要围绕中心、服务大局，发布档案高层信息，交流档案工作经验，指导档案业务，披露历史真相，记载当代要事，宣传档案事业。</p><p>	档案科学技术研究所主要承担档案保护技术、档案信息化管理技术、档案相关专业技术研究标准制定等方面基础性科学研究，为我国档案保管、利用及档案事业行政管理提供公益服务，为国家档案局中央档案馆行使职能提供技术支持保障。</p><p>	中国档案杂志社主办的《中国档案》杂志，是中国期刊方阵双效期刊，档案学、档案事业类核心期刊，是国家档案局政策法规发布和解读的平台、档案业务指导和经验交流的平台、档案学术研讨和科技成果推介的平台、档案工作者职业风采展示和档案文化传播的平台。</p><p>	二、应聘人员基本资格条件</p><p>	1.具有中华人民共和国国籍。</p><p>	2.政治立场坚定，拥护中国共产党的领导和社会主义制度，在思想上政治上行动上同以习近平同志为核心的党中央保持高度一致。</p><p>	3.拥护中华人民共和国宪法和法律法规，品行端正，遵纪守法。</p><p>	4.大学本科生不超过24周岁（1997年6月1日以后出生），硕士研究生不超过27周岁（1994年6月1日以后出生），博士研究生不超过35周岁（1986年6月1日以后出生）。</p><p>	5. 具备岗位要求的专业或技能条件。</p><p>	6. 具有正常履行职责的身体条件和心理素质。</p><p>	7. 具备岗位所需的其他条件。</p><p>	因犯罪受过刑事处罚的人员、被开除中国共产党党籍的人员、被开除公职的人员、被依法列为失信联合惩戒对象的人员，在各级公职人员招考中被认定有舞弊等严重违反考试录（聘）用纪律行为的人员，以及法律法规规定不得聘为事业单位工作人员的其他情形的人员，不得报名应聘。</p><p>	报考应聘人员不得报考聘用后即构成回避关系的招聘岗位。</p><p>	三、招聘范围</p><p>	招聘对象为2022年全国高等学校应届毕业生（含两年择业期内未落实工作单位的高校毕业生，不含各类委培生、定向生）。应聘人员毕业时须取得学历学位证书、就业报到证（派遣证），岗位要求的专业条件均为报名应聘人员获得的最高学历所对应专业。京内生源是指已具有北京市常住户口的报名应聘人员，不含北京高校集体户口。</p><p>	四、招聘岗位及资格条件</p><p>	此次招聘涉及5个岗位、计划招聘5人，具体岗位及资格条件详见《中央档案馆国家档案局2022年度公开招聘岗位信息表》。其中，有关岗位专业条件参考教育部公布的专业目录（《普通高等学校本科专业目录》和《授予博士、硕士学位和培养研究生的学科、专业目录》）。报名应聘人员在报名时对专业有任何疑问的，可以直接拨打报名咨询电话进行咨询了解。</p><p>	五、招聘程序</p><p>	（一）报名应聘方式和时间</p><p>	报名应聘采取网上（电子邮件）报名方式进行，每人限报1个岗位，报名应聘人员提交报名申请的时间为2022年6月17日至2022年6月28日，有意报名者须如实填写《事业单位公开招聘工作人员报名表》按报考岗位分别发送至以下邮箱：</p><p>	中国档案报社：danganbaors@163.com</p><p>	联系人：易文君 电话：010-63157625</p><p>	李 蔚 010-63161681</p><p>	档案科学技术研究所：zhaopin@istra.org.cn</p><p>	联系人：张蒴、刘艳莉 电话：010-63040979</p><p>	中国档案杂志社：da63021355@163.com</p><p>	联系人：马京宏 电话：010-83160071</p><p>	郑东红 010-63021355</p><p>	聘用单位将于6月30日17:00之前电话通知初审合格人员，未通过初审者不再通知。</p><p>	（二）资格审查</p><p>	资格审查工作由中国档案报社、档案科学技术研究所和中国档案杂志社分别负责，贯穿公开招聘全过程。根据本公告规定的报名资格条件和招聘岗位要求，对报名申请进行审查，做到客观、公正、及时，对所有报名应聘人员一视同仁。同一岗位通过资格审查的人数与该岗位计划招聘数的比例至少达到3:1方可开考，达不到该比例的，在笔试开考前应当减少该岗位招聘人数以确保达到开考比例，直至取消该岗位招聘计划。取消岗位招聘计划的，该岗位报名应聘人员可在笔试开始前改报符合报名资格条件的其他岗位。减少岗位招聘人数或者取消岗位招聘计划将于笔试前在国家档案局网站公布。</p><p>	（三）笔试</p><p>	笔试前，对报名应聘人员进行资格复审，根据报名申请与应聘人员本人及其身份证件（身份证、学生证、工作证等）原件、所在学校或者单位盖章的报名推荐表等材料进行核对。凡有关材料主要信息不实、影响资格审查结果的，招聘单位有权取消其参加面试的资格。</p><p>	笔试成绩按百分制计算，具体时间、地点和有关事项将在国家档案局网站公布（或者另行通知）。笔试结束7日内，通过电话通知报名应聘人员笔试成绩。本次考试不指定辅导用书，不举办也不委托任何机构举办辅导培训班。</p><p>	（四）面试</p><p>	根据应聘人员笔试成绩从高到低的顺序，按照3:1的比例确定面试人选（笔试成绩并列的，一并进入面试）。面试人选、面试时间、地点和有关事项将在国家档案局网站公布。如报名应聘人员放弃面试资格，按笔试成绩从高到低的顺序依次递补。</p><p>	面试采取结构化面试的方式进行，面试成绩按百分制计算，面试成绩当场宣布。</p><p>	考试综合成绩的计算按照笔试成绩、面试成绩各占50%的比例合成。</p><p>	（五）体检及考察</p><p>	按照报名应聘人员考试综合成绩从高到低的顺序，等额确定参加体检和考察的人选。其中，实际参加面试人数与该岗位计划招收数的比例低于3:1的，报名应聘人员面试成绩应当达到其所在面试考官组使用同一面试题本面试的所有人员的平均分，方可确定为体检和考察人选。考察人选在所报考单位主管机关及其所属单位有近亲属关系和主要社会关系的，需主动向所报考单位报告。</p><p>	1.体检。参照现行公务员录用体检标准组织实施体检，有关费用由用人单位承担。</p><p>	2.考察。按照新时期好干部标准及相关政策规定，根据招聘岗位的资格条件和要求开展聘用前考察工作。考察组应当深入考察对象所在学校或者单位，采取个别谈话、审核人事档案、查询社会信用记录、同考察人选面谈等方法进行，根据需要也可以进行延伸考察。</p><p>	人选体检或者考察不合格的，或拟聘用人选申明放弃的，经研究，可根据考试综合成绩从高到低的顺序进行递补，也可不递补。</p><p>	（六）公示</p><p>	根据报名应聘人员的考试综合成绩、体检结果和考察情况等，择优确定拟聘用人员，并在人力资源社会保障部“中央和国家机关事业单位公开招聘服务平台”和国家档案局网站进行公示。公示期为7个工作日。</p><p>	（七）聘用</p><p>	公示期满后，没有问题或者反映的问题不影响聘用的，经报有关部门备案同意后，按规定办理聘用手续；对反映有影响聘用的问题并查实的，不予聘用；对反映的问题一时难以查实的，可以暂缓聘用，待查清后再决定是否办理聘用手续。</p><p>	新聘用人员按规定实行试用期制度，试用期满合格的，予以正式聘用；不合格的，取消聘用。</p><p>	六、有关待遇</p><p>	受聘人员享受国家规定的事业单位工作人员工资待遇。</p><p>	七、其他事项</p><p>	1.本次公开招聘相关信息均在国家档案局网站发布，请及时关注，并保持通讯工具畅通。</p><p>	2.报名应聘人员提交的报名材料及信息应当真实、准确、完整，对于伪造、涂改证件、证明等报名材料，或者以其他不正当手段获取应聘资格的，在考试体检考察过程中作弊的，或者有其他违反公开招聘纪律行为的，将按照《事业单位公开招聘违纪违规行为处理规定》进行处理。</p><p>	监督举报电话：010－83083863。</p><p>	本公告由中央档案馆国家档案局人事司负责解释。</p><p>	附件：1、中央档案馆国家档案局公开招聘岗位信息表</p><p>	2、事业单位公开招聘工作人员报名表</p><p class=\"ql-align-right\">	中央档案馆国家档案局</p><p class=\"ql-align-center\"><br></p>', '中央档案馆国家档案局2022年度公开招聘工作人员公告', 0, '2022-12-07 11:02:34', '2022-12-19 11:05:45');
INSERT INTO `pdes_portal_notify` VALUES (57, '第32届“国际档案日”大会将于线上举办', '<p>	由意大利的里雅斯特—斯洛文尼亚马里博尔国际档案学研究所（International Institute for the archival science Trieste/ Italy-Maribor/ Slovenia）、欧洲阿尔玛学院—马里博尔欧洲中心（Alma Mater Europaea-ECM/ Archival studies）、的里雅斯特国家档案馆（State Archives of Trieste）、马里博尔大学（University of Maribor）和斯洛文尼亚研究机构（Slovenian Research Agency）共同主办的第32届“国际档案日”大会将于2022年10月10日—10月11日，北京时间16：00—22：00在线上举办。本次会议免费。</p><p>	会议主题为：</p><p>	1、档案塑造集体记忆。</p><p>	2、档案学和档案科教、利用领域的国际合作。</p><p>	约27位来自斯洛文尼亚、意大利、荷兰、波兰、澳大利亚、罗马尼亚、德国、克罗地亚等国的档案专家将进行主旨发言。</p><p>	欢迎点击会议链接参会：</p><p>		<a href=\"http://almamater-si.zoom.us/j/84286230930?pwd=eUk3d3lKOGErZzVpclBLU29EUE5CQT09\" rel=\"noopener noreferrer\" target=\"_blank\" style=\"color: rgb(51, 51, 51);\">http://almamater-si.zoom.us/j/84286230930?pwd=eUk3d3lKOGErZzVpclBLU29EUE5CQT09</a></p>', '秋分', 0, '2022-12-08 10:52:08', '2022-12-08 10:52:08');

-- ----------------------------
-- Table structure for pdes_portal_notify_file
-- ----------------------------
DROP TABLE IF EXISTS `pdes_portal_notify_file`;
CREATE TABLE `pdes_portal_notify_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键;附件ID',
  `notify_id` int(11) NOT NULL COMMENT '通知公告ID',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '附件标题',
  `file_size` int(11) NOT NULL COMMENT '附件大小',
  `file_suffix` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '后缀',
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '存储路径',
  `memo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `order_seq` int(11) NOT NULL COMMENT '排序号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '通知公告附件' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdes_portal_notify_file
-- ----------------------------
INSERT INTO `pdes_portal_notify_file` VALUES (1, 1, '1.jpg', 149102, '.jpg', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/LiangZi/2022-12-09/10:24:42/file_4414974254854588007.jpg', NULL, 1, '2022-12-09 10:24:43', '2022-12-09 10:24:43');
INSERT INTO `pdes_portal_notify_file` VALUES (2, 1, '布局组件.xmind', 189262, '.xmind', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/LiangZi/2022-12-09/10:25:22/file_2730929808490047758.xmind', NULL, 1, '2022-12-09 10:25:22', '2022-12-09 10:25:22');
INSERT INTO `pdes_portal_notify_file` VALUES (4, 2, '跨平台开发技术复习(1).md', 23446, '.md', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/LiangZi/2022-12-09/11:34:13/file_969076056221057056.md', NULL, 1, '2022-12-09 11:34:14', '2022-12-09 11:34:14');
INSERT INTO `pdes_portal_notify_file` VALUES (5, 2, '微服务技术复习题.md', 5610, '.md', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/LiangZi/2022-12-09/11:37:35/file_6425958694202231910.md', NULL, 1, '2022-12-09 11:37:36', '2022-12-09 11:37:36');
INSERT INTO `pdes_portal_notify_file` VALUES (6, 2, '微服务技术复习题.md', 5610, '.md', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/LiangZi/2022-12-09/11:37:37/file_593166647433238028.md', NULL, 1, '2022-12-09 11:37:38', '2022-12-09 11:37:38');
INSERT INTO `pdes_portal_notify_file` VALUES (7, 1, '微服务技术复习题.md', 5610, '.md', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/LiangZi/2022-12-09/18:30:42/file_8125486872090104375.md', NULL, 1, '2022-12-09 18:30:43', '2022-12-09 18:30:43');
INSERT INTO `pdes_portal_notify_file` VALUES (8, 1, 'QQ图片20191225163216.jpg', 23580, '.jpg', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/LiangZi/2022-12-09/18:32:59/file_485775956046493598.jpg', NULL, 1, '2022-12-09 18:33:00', '2022-12-09 18:33:00');
INSERT INTO `pdes_portal_notify_file` VALUES (9, 1, 'QQ图片20190724202702.png', 564034, '.png', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/LiangZi/2022-12-09/18:33:50/file_7100494032329960721.png', NULL, 1, '2022-12-09 18:33:50', '2022-12-09 18:33:50');
INSERT INTO `pdes_portal_notify_file` VALUES (10, 1, '微服务技术复习题.md', 5610, '.md', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/LiangZi/2022-12-09/18:34:38/file_5597223732252563256.md', NULL, 1, '2022-12-09 18:34:38', '2022-12-09 18:34:38');
INSERT INTO `pdes_portal_notify_file` VALUES (11, 1, 'bg.jpg', 1605933, '.jpg', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/LiangZi/2022-12-09/18:35:03/file_3584387051869397244.jpg', NULL, 1, '2022-12-09 18:35:04', '2022-12-09 18:35:04');
INSERT INTO `pdes_portal_notify_file` VALUES (12, 56, '123.jpg', 31427, '.jpg', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/LiangZi/2022-12-09/18:36:48/file_8648933887296881638.jpg', NULL, 1, '2022-12-09 18:36:49', '2022-12-09 18:36:49');
INSERT INTO `pdes_portal_notify_file` VALUES (13, 56, 'QQ图片20190723202038.jpg', 467658, '.jpg', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/LiangZi/2022-12-10/13:19:59/file_2066295378853423152.jpg', NULL, 1, '2022-12-10 13:20:00', '2022-12-10 13:20:00');
INSERT INTO `pdes_portal_notify_file` VALUES (14, 57, '英语字母发音全攻略 .pdf', 3962390, '.pdf', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/LiangZi/2022-12-19/09:10:29/file_6615763444104481116.pdf', NULL, 1, '2022-12-19 09:10:31', '2022-12-19 09:10:31');

-- ----------------------------
-- Table structure for pdes_portal_photo
-- ----------------------------
DROP TABLE IF EXISTS `pdes_portal_photo`;
CREATE TABLE `pdes_portal_photo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '相册名称',
  `description` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `enable_publish` smallint(6) NOT NULL DEFAULT 0 COMMENT '启用发布;0待发布;1已发布',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '照片专题(相册);' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdes_portal_photo
-- ----------------------------
INSERT INTO `pdes_portal_photo` VALUES (1, '相册一', '描述11112', 0, '2022-12-02 06:48:29');
INSERT INTO `pdes_portal_photo` VALUES (2, '相册二', '描述22222', 1, '2022-12-02 06:52:03');
INSERT INTO `pdes_portal_photo` VALUES (3, '相册三', '描述333333', 0, '2022-12-04 08:24:10');
INSERT INTO `pdes_portal_photo` VALUES (4, '相册四', '描述44444', 1, '2022-12-08 02:10:02');
INSERT INTO `pdes_portal_photo` VALUES (5, '相册5', '描述55555', 1, '2022-12-08 02:26:40');
INSERT INTO `pdes_portal_photo` VALUES (9, '123231', '2', 1, '2022-12-08 09:24:41');
INSERT INTO `pdes_portal_photo` VALUES (10, '3', '222', 1, '2022-12-08 09:30:22');
INSERT INTO `pdes_portal_photo` VALUES (12, '111', '11', 0, '2022-12-09 01:16:14');
INSERT INTO `pdes_portal_photo` VALUES (13, 'aaaa', 'aaaa', 0, '2022-12-09 02:33:04');
INSERT INTO `pdes_portal_photo` VALUES (14, '相册11', '1333', 0, '2022-12-09 06:33:57');

-- ----------------------------
-- Table structure for pdes_portal_photo_file
-- ----------------------------
DROP TABLE IF EXISTS `pdes_portal_photo_file`;
CREATE TABLE `pdes_portal_photo_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `photo_id` int(11) NOT NULL COMMENT '相册ID',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名',
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件路径',
  `file_size` int(11) NOT NULL COMMENT '文件大小',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `enable_front` smallint(6) NULL DEFAULT 0 COMMENT '开启封面;0内页;1封面',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '照片专题文件表;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdes_portal_photo_file
-- ----------------------------
INSERT INTO `pdes_portal_photo_file` VALUES (1, 1, 'file1', '111', 111, '2022-12-08 23:04:57', 0);
INSERT INTO `pdes_portal_photo_file` VALUES (2, 10, 'file2', '111', 111, '2022-12-08 23:05:20', 0);
INSERT INTO `pdes_portal_photo_file` VALUES (3, 10, 'file2', '111', 111, '2022-12-08 23:05:20', 0);
INSERT INTO `pdes_portal_photo_file` VALUES (4, 9, 'file2', '111', 111, '2022-12-08 23:05:20', 0);
INSERT INTO `pdes_portal_photo_file` VALUES (5, 9, 'file2', '111', 111, '2022-12-08 23:05:20', 0);

-- ----------------------------
-- Table structure for pdes_portal_public_archive
-- ----------------------------
DROP TABLE IF EXISTS `pdes_portal_public_archive`;
CREATE TABLE `pdes_portal_public_archive`  (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `archival_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '档号',
  `fonds` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '全宗',
  `year` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '年度',
  `security_class` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密级',
  `retention_period` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '保管期限',
  `title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '题名',
  `enable_publish` smallint(6) NOT NULL COMMENT '启用发布;0未发布；1已发布',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '开放档案;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdes_portal_public_archive
-- ----------------------------
INSERT INTO `pdes_portal_public_archive` VALUES (1, '202212011223', '南京工业', '2022', '绝密', '长期', '处分决定0', 1, '2022-12-01 09:37:32', '2022-12-01 09:37:35');
INSERT INTO `pdes_portal_public_archive` VALUES (2, '202212011244', '常州信息', '2022', '绝密', '定期10年', '处分决定1', 0, '2022-12-01 09:37:32', '2022-12-19 01:38:44');
INSERT INTO `pdes_portal_public_archive` VALUES (3, '202212011254', '苏州城市', '2022', '国内', '定期30年', '处分决定2', 1, '2022-12-01 09:37:32', '2022-12-01 09:37:35');
INSERT INTO `pdes_portal_public_archive` VALUES (4, '202212011264', '南京工业', '2022', '内部', '永久', '处分决定3', 1, '2022-12-01 09:37:32', '2022-12-01 09:37:35');
INSERT INTO `pdes_portal_public_archive` VALUES (5, '202212011274', '南京工业', '2022', '机密', '定期10年', '处分决定4', 1, '2022-12-01 09:37:32', '2022-12-01 09:37:35');
INSERT INTO `pdes_portal_public_archive` VALUES (6, '202212011284', '南京工业', '2022', '秘密', '长期', '处分决定5', 1, '2022-12-01 09:37:32', '2022-12-01 09:37:35');
INSERT INTO `pdes_portal_public_archive` VALUES (7, '202212011294', '南京工业', '2022', '绝密', '定期30年', '处分决定6', 1, '2022-12-01 09:37:32', '2022-12-01 09:37:35');
INSERT INTO `pdes_portal_public_archive` VALUES (8, '202212011230', '南京工业', '2022', '内部', '长期', '处分决定7', 1, '2022-12-01 09:37:32', '2022-12-01 09:37:35');
INSERT INTO `pdes_portal_public_archive` VALUES (9, '202212011231', '南京工业', '2022', '绝密', '永久', '处分决定8', 0, '2022-12-01 09:37:32', '2022-12-01 09:37:35');
INSERT INTO `pdes_portal_public_archive` VALUES (10, '202212011774', '南京工业', '2022', '内部', '长期', '处分决定9', 1, '2022-12-01 09:37:32', '2022-12-01 09:37:35');
INSERT INTO `pdes_portal_public_archive` VALUES (11, '202212011664', '南京工业', '2022', '公开', '定期10年', '处分决定10', 1, '2022-12-01 09:37:32', '2022-12-01 09:37:35');
INSERT INTO `pdes_portal_public_archive` VALUES (12, '202212018254', '南京工业', '2022', '国内', '定期30年', '处分决定11', 1, '2022-12-01 09:37:32', '2022-12-01 09:37:35');
INSERT INTO `pdes_portal_public_archive` VALUES (13, '202212017264', '南京工业', '2022', '内部', '永久', '处分决定12', 1, '2022-12-01 09:37:32', '2022-12-01 09:37:35');
INSERT INTO `pdes_portal_public_archive` VALUES (14, '202212016274', '南京工业', '2022', '机密', '定期10年', '处分决定13', 1, '2022-12-01 09:37:32', '2022-12-01 09:37:35');
INSERT INTO `pdes_portal_public_archive` VALUES (15, '202212015234', '南京工业', '2022', '内部', '长期', '处分决定14', 1, '2022-12-01 09:37:32', '2022-12-01 09:37:35');
INSERT INTO `pdes_portal_public_archive` VALUES (16, '202212014284', '南京工业', '2022', '秘密', '长期', '处分决定15', 1, '2022-12-01 09:37:32', '2022-12-01 09:37:35');

-- ----------------------------
-- Table structure for pdes_portal_public_archive_file
-- ----------------------------
DROP TABLE IF EXISTS `pdes_portal_public_archive_file`;
CREATE TABLE `pdes_portal_public_archive_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `archive_id` int(11) NOT NULL COMMENT '档案条目ID',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名',
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件路径',
  `file_size` int(11) NOT NULL COMMENT '文件大小',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '档案库原文表;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdes_portal_public_archive_file
-- ----------------------------
INSERT INTO `pdes_portal_public_archive_file` VALUES (1, 1, '处分决定', 'https://xzpsjc11.oss-cn-hangzhou.aliyuncs.com/upload/7171d441gy1h4oainnjr5j20tz0tzgri.jpg', 2, '2022-12-01 09:44:50');
INSERT INTO `pdes_portal_public_archive_file` VALUES (2, 2, '处分决定1', 'https://xzpsjc11.oss-cn-hangzhou.aliyuncs.com/upload/7171d441gy1h4oainnjr5j20tz0tzgri.jpg', 2, '2022-12-01 09:44:50');
INSERT INTO `pdes_portal_public_archive_file` VALUES (3, 3, '处分决定2', 'https://xzpsjc11.oss-cn-hangzhou.aliyuncs.com/upload/7171d441gy1h4oainnjr5j20tz0tzgri.jpg', 2, '2022-12-01 09:44:50');
INSERT INTO `pdes_portal_public_archive_file` VALUES (4, 4, '处分决定3', 'https://xzpsjc11.oss-cn-hangzhou.aliyuncs.com/upload/7171d441gy1h4oainnjr5j20tz0tzgri.jpg', 2, '2022-12-01 09:44:50');
INSERT INTO `pdes_portal_public_archive_file` VALUES (5, 5, '处分决定4', 'https://xzpsjc11.oss-cn-hangzhou.aliyuncs.com/upload/7171d441gy1h4oainnjr5j20tz0tzgri.jpg', 2, '2022-12-01 09:44:50');
INSERT INTO `pdes_portal_public_archive_file` VALUES (6, 6, '处分决定5', 'https://xzpsjc11.oss-cn-hangzhou.aliyuncs.com/upload/7171d441gy1h4oainnjr5j20tz0tzgri.jpg', 2, '2022-12-01 09:44:50');
INSERT INTO `pdes_portal_public_archive_file` VALUES (7, 7, '处分决定6', 'https://xzpsjc11.oss-cn-hangzhou.aliyuncs.com/upload/7171d441gy1h4oainnjr5j20tz0tzgri.jpg', 2, '2022-12-01 09:44:50');
INSERT INTO `pdes_portal_public_archive_file` VALUES (8, 8, '处分决定7', 'https://xzpsjc11.oss-cn-hangzhou.aliyuncs.com/upload/7171d441gy1h4oainnjr5j20tz0tzgri.jpg', 2, '2022-12-01 09:44:50');
INSERT INTO `pdes_portal_public_archive_file` VALUES (9, 9, '处分决定8', 'https://xzpsjc11.oss-cn-hangzhou.aliyuncs.com/upload/7171d441gy1h4oainnjr5j20tz0tzgri.jpg', 2, '2022-12-01 09:44:50');
INSERT INTO `pdes_portal_public_archive_file` VALUES (10, 10, '处分决定', 'https://xzpsjc11.oss-cn-hangzhou.aliyuncs.com/upload/7171d441gy1h4oainnjr5j20tz0tzgri.jpg', 2, '2022-12-01 09:44:50');
INSERT INTO `pdes_portal_public_archive_file` VALUES (11, 11, '处分决定1', 'https://xzpsjc11.oss-cn-hangzhou.aliyuncs.com/upload/7171d441gy1h4oainnjr5j20tz0tzgri.jpg', 2, '2022-12-01 09:44:50');
INSERT INTO `pdes_portal_public_archive_file` VALUES (12, 12, '处分决定2', 'https://xzpsjc11.oss-cn-hangzhou.aliyuncs.com/upload/7171d441gy1h4oainnjr5j20tz0tzgri.jpg', 2, '2022-12-01 09:44:50');
INSERT INTO `pdes_portal_public_archive_file` VALUES (13, 13, '处分决定3', 'https://xzpsjc11.oss-cn-hangzhou.aliyuncs.com/upload/7171d441gy1h4oainnjr5j20tz0tzgri.jpg', 2, '2022-12-01 09:44:50');
INSERT INTO `pdes_portal_public_archive_file` VALUES (14, 14, '处分决定4', 'https://xzpsjc11.oss-cn-hangzhou.aliyuncs.com/upload/7171d441gy1h4oainnjr5j20tz0tzgri.jpg', 2, '2022-12-01 09:44:50');
INSERT INTO `pdes_portal_public_archive_file` VALUES (15, 15, '处分决定5', 'https://xzpsjc11.oss-cn-hangzhou.aliyuncs.com/upload/7171d441gy1h4oainnjr5j20tz0tzgri.jpg', 2, '2022-12-01 09:44:50');
INSERT INTO `pdes_portal_public_archive_file` VALUES (16, 16, '处分决定6', 'https://xzpsjc11.oss-cn-hangzhou.aliyuncs.com/upload/7171d441gy1h4oainnjr5j20tz0tzgri.jpg', 2, '2022-12-01 09:44:50');
INSERT INTO `pdes_portal_public_archive_file` VALUES (23, 51, '201332893335709.jpg', 'http://www.patrickstarm.top:9090/pde-file/archive/29717aa1-f6af-434c-a86c-3b7302760d40.jpg', 311, '2022-12-19 03:18:24');
INSERT INTO `pdes_portal_public_archive_file` VALUES (24, 52, '201332893335709.jpg', 'http://www.patrickstarm.top:9090/pde-file/archive/29717aa1-f6af-434c-a86c-3b7302760d40.jpg', 311, '2022-12-19 03:18:26');
INSERT INTO `pdes_portal_public_archive_file` VALUES (25, 53, '201332893335709.jpg', 'http://www.patrickstarm.top:9090/pde-file/archive/db95b8d2-3da9-4df8-a9ec-ef03bed350fb.jpg', 311, '2022-12-19 03:25:49');
INSERT INTO `pdes_portal_public_archive_file` VALUES (26, 54, '201332893335709.jpg', 'http://www.patrickstarm.top:9090/pde-file/archive/db95b8d2-3da9-4df8-a9ec-ef03bed350fb.jpg', 311, '2022-12-19 03:25:55');
INSERT INTO `pdes_portal_public_archive_file` VALUES (27, 55, '201332893335709.jpg', 'http://www.patrickstarm.top:9090/pde-file/archive/db95b8d2-3da9-4df8-a9ec-ef03bed350fb.jpg', 311, '2022-12-19 03:25:58');

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
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '标准;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdes_portal_standard
-- ----------------------------
INSERT INTO `pdes_portal_standard` VALUES (3, 'String', 'String', 0, '2022-12-09 15:23:34', '2022-12-09 15:23:20');
INSERT INTO `pdes_portal_standard` VALUES (5, 'test', 'String', 1, '2022-12-09 15:23:42', '2022-12-09 15:23:20');
INSERT INTO `pdes_portal_standard` VALUES (13, '测试添加', '测试描述', 1, '2022-12-09 16:36:44', '2022-12-09 00:00:00');
INSERT INTO `pdes_portal_standard` VALUES (14, '1111111222', '11111111111112222', 0, '2022-12-19 16:46:17', '2022-12-01 00:00:00');

-- ----------------------------
-- Table structure for pdes_portal_standard_file
-- ----------------------------
DROP TABLE IF EXISTS `pdes_portal_standard_file`;
CREATE TABLE `pdes_portal_standard_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `standard_id` int(11) NOT NULL COMMENT '标准ID',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名',
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件路径',
  `file_size` int(11) NOT NULL COMMENT '文件大小',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '标准文件表;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdes_portal_standard_file
-- ----------------------------
INSERT INTO `pdes_portal_standard_file` VALUES (6, 5, '2.jpg6257287483773632262.jpg', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/liangzi/2022-12-07/18:11:44/2.jpg6257287483773632262.jpg', 1348980, '2022-12-07 10:11:45');
INSERT INTO `pdes_portal_standard_file` VALUES (8, 5, '123', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/liangzi/2022-12-07/18:23:42/2.jpg9119586693296556603.jpg', 1348980, '2022-12-07 10:23:44');
INSERT INTO `pdes_portal_standard_file` VALUES (9, 3, '123', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/liangzi/2022-12-07/18:34:03/2.jpg295994867716566122.jpg', 1348980, '2022-12-07 10:34:05');
INSERT INTO `pdes_portal_standard_file` VALUES (10, 5, '123', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/liangzi/2022-12-07/18:36:54/2.jpg1088539484124825162.jpg', 1348980, '2022-12-07 10:36:56');
INSERT INTO `pdes_portal_standard_file` VALUES (12, 5, '123', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/liangzi/2022-12-07/18:43:23/file600221246980118580.jpg', 1348980, '2022-12-07 10:43:25');
INSERT INTO `pdes_portal_standard_file` VALUES (14, 3, '123', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/liangzi/2022-12-07/18:49:10/file_7038190929744705971.jpg', 1348980, '2022-12-07 10:49:11');
INSERT INTO `pdes_portal_standard_file` VALUES (16, 13, '222', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/liangzi/2022-12-19/11:47:35/file_2188217663786118589.pdf', 225590, '2022-12-19 11:47:36');
INSERT INTO `pdes_portal_standard_file` VALUES (17, 3, '测试添加', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/liangzi/2022-12-19/11:48:03/file_3812966684521989005.pdf', 225590, '2022-12-19 11:48:04');
INSERT INTO `pdes_portal_standard_file` VALUES (18, 15, '啦啦啦', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/liangzi/2022-12-19/21:49:00/file_5797510153663899222.pdf', 225590, '2022-12-19 21:49:01');
INSERT INTO `pdes_portal_standard_file` VALUES (19, 3, '', 'https://wang-rich.oss-cn-hangzhou.aliyuncs.com/liangzi/2022-12-20/08:57:40/file_4798654606062828292.pdf', 225590, '2022-12-20 08:57:41');

-- ----------------------------
-- Table structure for pdes_portal_user
-- ----------------------------
DROP TABLE IF EXISTS `pdes_portal_user`;
CREATE TABLE `pdes_portal_user`  (
  `login_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `gender` smallint(6) NOT NULL COMMENT '性别;0=男，1=女',
  `age` int(3) NULL DEFAULT NULL COMMENT '年龄',
  `telephone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `valid_state` smallint(6) NOT NULL DEFAULT 1 COMMENT '状态;0=删除，1=有效',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modified_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`login_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdes_portal_user
-- ----------------------------

-- ----------------------------
-- Table structure for pdes_portal_video
-- ----------------------------
DROP TABLE IF EXISTS `pdes_portal_video`;
CREATE TABLE `pdes_portal_video`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专辑名称',
  `description` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `enable_publish` smallint(6) NOT NULL DEFAULT 0 COMMENT '启用发布;0待发布;1已发布',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '视频档案(专辑);' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdes_portal_video
-- ----------------------------
INSERT INTO `pdes_portal_video` VALUES (1, '修改测试', '修改测试描述', 1, '2022-12-02 02:10:05');
INSERT INTO `pdes_portal_video` VALUES (3, '测试视频专辑3', '这是第三个测试视频专辑', 1, '2022-12-02 05:56:11');
INSERT INTO `pdes_portal_video` VALUES (5, '编辑测试测试', '这是一个编辑描述des', 1, '2022-12-08 21:14:36');
INSERT INTO `pdes_portal_video` VALUES (6, '新增测试', '新增专辑1', 0, '2022-12-09 10:40:19');

-- ----------------------------
-- Table structure for pdes_portal_video_file
-- ----------------------------
DROP TABLE IF EXISTS `pdes_portal_video_file`;
CREATE TABLE `pdes_portal_video_file`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `video_id` int(11) NOT NULL COMMENT '视频专辑ID',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名',
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件路径',
  `file_size` int(11) NOT NULL COMMENT '文件大小',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `is_front_file` smallint(6) NOT NULL COMMENT '是否为专辑封面;0不是,1是',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '视频档案文件表;' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdes_portal_video_file
-- ----------------------------
INSERT INTO `pdes_portal_video_file` VALUES (1, 1, '修改测试名称', 'http://www.patrickstarm.top:9090/pde-file/video/393096db-6d46-4d47-aa1d-1159fb35c509.mp4', 100000, '2022-12-02 03:35:49', 1);
INSERT INTO `pdes_portal_video_file` VALUES (2, 1, '测试视频-大大的', 'http://www.patrickstarm.top:9090/pde-file/video/393096db-6d46-4d47-aa1d-1159fb35c509.mp4', 100000, '2022-12-02 03:53:39', 0);

-- ----------------------------
-- Table structure for pdes_portal_video_file_front
-- ----------------------------
DROP TABLE IF EXISTS `pdes_portal_video_file_front`;
CREATE TABLE `pdes_portal_video_file_front`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `video_file_id` int(11) NOT NULL COMMENT '视频文件ID',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件名',
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '文件路径',
  `file_size` int(11) NOT NULL COMMENT '文件大小',
  `is_front_file` smallint(6) NOT NULL COMMENT '是否为视频封面;0为否,1为是',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '视频档案文件封面表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pdes_portal_video_file_front
-- ----------------------------
INSERT INTO `pdes_portal_video_file_front` VALUES (1, 1, 'first', 'http://www.patrickstarm.top:9090/pde-file/video/0c0820b5-afa6-455e-b3f9-d37890fa3f39.jpg', 1000, 1, '2022-12-07 09:35:00');

SET FOREIGN_KEY_CHECKS = 1;
