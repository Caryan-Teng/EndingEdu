/*
 Navicat MySQL Dump SQL

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80041 (8.0.41)
 Source Host           : localhost:3306
 Source Schema         : volunteer-register-sys

 Target Server Type    : MySQL
 Target Server Version : 80041 (8.0.41)
 File Encoding         : 65001

 Date: 25/02/2025 18:49:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `job_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '职业名',
  `job_id` int NULL DEFAULT NULL COMMENT '职业id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES (3, '超级管理员', 0);
INSERT INTO `job` VALUES (4, '军人', 1);
INSERT INTO `job` VALUES (5, '教育工作者', 9);
INSERT INTO `job` VALUES (6, '医疗工作者', 3);
INSERT INTO `job` VALUES (7, '法律工作者', 4);
INSERT INTO `job` VALUES (8, '财务工作者', 5);
INSERT INTO `job` VALUES (9, '服务业工作者', 6);
INSERT INTO `job` VALUES (10, '农业工作者', 7);
INSERT INTO `job` VALUES (11, '技术工作者', 8);
INSERT INTO `job` VALUES (12, '学生', 2);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id（自动生成',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户昵称',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮箱地址（用作用户名）',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `age` int NOT NULL COMMENT '年龄',
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '性别',
  `unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '工作单位/学校',
  `job_id` bigint NOT NULL COMMENT '职业编码（外键）',
  `living_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '住址',
  `registered_address_id` int NOT NULL COMMENT '户籍地id（外键）（邮编代替）',
  `is_leader` int NOT NULL DEFAULT 0 COMMENT '是否是志愿负责人（0否1是）',
  `join_date` date NOT NULL COMMENT '用户创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '滕杰灵', '15716273511@163.com', 'TJL123456.', 21, '男', '南京芷间科技有限公司', 0, '江苏省南京市浦口区桃湖里花园', 226500, 1, '2025-02-21');
INSERT INTO `user` VALUES (2, '石优雨', '15252805689@163.com', 'SYY123456.', 22, '女', '江苏省无锡市江阴市申利纺织工业园', 1, '江苏省无锡市江阴市申利纺织工业园宿舍区', 226500, 0, '2025-02-21');

-- ----------------------------
-- Table structure for user_pass
-- ----------------------------
DROP TABLE IF EXISTS `user_pass`;
CREATE TABLE `user_pass`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `email` varbinary(255) NOT NULL COMMENT '用户邮箱',
  `pass` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户验证码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_pass
-- ----------------------------
INSERT INTO `user_pass` VALUES (10, 0x323232323232, '107519');

-- ----------------------------
-- Table structure for volunteer
-- ----------------------------
DROP TABLE IF EXISTS `volunteer`;
CREATE TABLE `volunteer`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `volunteer_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '志愿名',
  `is_begin` int NOT NULL DEFAULT 0 COMMENT '志愿是否开始（0/1）',
  `is_end` int NOT NULL DEFAULT 0 COMMENT '是否结束',
  `volunteer_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '志愿简介',
  `create_date` date NOT NULL COMMENT '创建时间',
  `max_participants` int NOT NULL COMMENT '最大参与人数',
  `current_participants` int NOT NULL DEFAULT 0 COMMENT '当前参与人数',
  `checked_participants` int NOT NULL DEFAULT 0 COMMENT '已签到人数',
  `leader_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '负责人姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of volunteer
-- ----------------------------
INSERT INTO `volunteer` VALUES (1, 'string2', 0, 0, 'string1', '2025-02-25', 50, 0, 0, '滕杰灵');

-- ----------------------------
-- Table structure for volunteer_user_is_check
-- ----------------------------
DROP TABLE IF EXISTS `volunteer_user_is_check`;
CREATE TABLE `volunteer_user_is_check`  (
  `id` bigint NOT NULL COMMENT '主键id',
  `user_id` bigint NOT NULL COMMENT '志愿者id',
  `volunteer_id` bigint NOT NULL COMMENT '志愿id',
  `is_check` int NOT NULL DEFAULT -1 COMMENT '是否签到',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of volunteer_user_is_check
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
