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

 Date: 22/02/2025 19:40:50
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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES (3, '超级管理员', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id（自动生成',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户昵称',
  `tel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '电话号码（用作用户名）',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `age` int NOT NULL COMMENT '年龄',
  `gender` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '性别',
  `unit` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '工作单位/学校',
  `job_id` bigint NOT NULL COMMENT '职业编码（外键）',
  `living_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '住址',
  `registered_address_id` int NOT NULL COMMENT '户籍地id（外键）（邮编代替）',
  `is_leader` int NOT NULL COMMENT '是否是志愿负责人（0否1是）',
  `join_date` date NOT NULL COMMENT '用户创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '滕杰灵', '15716273511', 'TJL123456.', 21, '男', '南京芷间科技有限公司', 0, '江苏省南京市浦口区桃湖里花园', 226500, 1, '2025-02-21');
INSERT INTO `user` VALUES (2, '石优雨', '15252805689', 'SYY123456.', 22, '女', '江苏省无锡市江阴市申利纺织工业园', 1, '江苏省无锡市江阴市申利纺织工业园宿舍区', 226500, 0, '2025-02-21');

SET FOREIGN_KEY_CHECKS = 1;
