/*
 Navicat Premium Data Transfer

 Source Server         : localMysql
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : CRM_APP

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 23/02/2021 21:33:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for PROJECT
-- ----------------------------
DROP TABLE IF EXISTS `PROJECT`;
CREATE TABLE `PROJECT`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `startDate` date NULL DEFAULT NULL,
  `endDate` date NULL DEFAULT NULL,
  `createUser` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE,
  INDEX `FK_PROJECT_CREATE_USER`(`createUser`) USING BTREE,
  CONSTRAINT `FK_PROJECT_CREATE_USER` FOREIGN KEY (`createUser`) REFERENCES `USER` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of PROJECT
-- ----------------------------
INSERT INTO `PROJECT` VALUES (1, 'First Project', '1', NULL, NULL, 5);
INSERT INTO `PROJECT` VALUES (2, 'Second Project', '2', NULL, NULL, 1);

-- ----------------------------
-- Table structure for ROLE
-- ----------------------------
DROP TABLE IF EXISTS `ROLE`;
CREATE TABLE `ROLE`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ROLE
-- ----------------------------
INSERT INTO `ROLE` VALUES (1, 'ADMIN', 'Quản trị viên');
INSERT INTO `ROLE` VALUES (3, 'STAFF', 'Nhân viên');
INSERT INTO `ROLE` VALUES (5, 'MANAGER', 'Quản lý');

-- ----------------------------
-- Table structure for STATUS
-- ----------------------------
DROP TABLE IF EXISTS `STATUS`;
CREATE TABLE `STATUS`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for TASK
-- ----------------------------
DROP TABLE IF EXISTS `TASK`;
CREATE TABLE `TASK`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `startDate` date NULL DEFAULT NULL,
  `endDate` date NULL DEFAULT NULL,
  `projectId` int(0) NOT NULL,
  `userId` int(0) NOT NULL,
  `createUserId` int(0) NOT NULL,
  `statusId` int(0) NOT NULL,
  `categoryId` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE,
  INDEX `FK_TASK_PROJECT`(`projectId`) USING BTREE,
  INDEX `FK_TASK_USER`(`userId`) USING BTREE,
  INDEX `FK_TASK_CREATE_USER`(`createUserId`) USING BTREE,
  INDEX `FK_TASK_STATUS`(`statusId`) USING BTREE,
  INDEX `FK_TASK_CATEGORY`(`categoryId`) USING BTREE,
  CONSTRAINT `FK_TASK_CATEGORY` FOREIGN KEY (`categoryId`) REFERENCES `TASK_CATEGORY` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_TASK_CREATE_USER` FOREIGN KEY (`createUserId`) REFERENCES `USER` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_TASK_PROJECT` FOREIGN KEY (`projectId`) REFERENCES `PROJECT` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_TASK_STATUS` FOREIGN KEY (`statusId`) REFERENCES `STATUS` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_TASK_USER` FOREIGN KEY (`userId`) REFERENCES `USER` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for TASK_CATEGORY
-- ----------------------------
DROP TABLE IF EXISTS `TASK_CATEGORY`;
CREATE TABLE `TASK_CATEGORY`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for USER
-- ----------------------------
DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `password` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `address` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `fullname` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `roleid` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `email`(`email`) USING BTREE,
  INDEX `FK_USER_ROLE`(`roleid`) USING BTREE,
  CONSTRAINT `FK_USER_ROLE` FOREIGN KEY (`roleid`) REFERENCES `ROLE` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of USER
-- ----------------------------
INSERT INTO `USER` VALUES (1, '$2a$10$l3b7vLlXyHJJVutONjfKL.TajYFbNPe95P9x4Xe3lP0Ftgw1etPBy', '1lamtrinhthong@gmail.com', '123 test', 'Thông Lam', '(+84)775311127', 3);
INSERT INTO `USER` VALUES (5, '$2a$10$tmaUi1WJTdT87OzBTZIOd.Eq0A5tRKwAglj8Ar4Ny448afQeICBwO', 'greylam@gmail.com', '123 Điện Biên Phủ', 'Grey Lam', '(+84)775311127', 1);
INSERT INTO `USER` VALUES (6, '$2a$10$iNVMVfiPdKSs52VvL.mFXOhcAf5Llyrdek6CAptZA33BHElBYnwdu', 'lamtrinhthong1@gmail.com', '123 Điện Biên Phủ', 'Grey1 Lam', '(+84)775311127', 3);
INSERT INTO `USER` VALUES (7, '$2a$10$lgsm2HjOyeWVMuXy7wNXNOHFJwU3QbqwHsN9S2D8tXOrIDH8HjYKO', 'lamtrinhthong2@gmail.com', '123 Điện Biên Phủ', 'Grey2 Lam', '(+84)775311127', 5);
INSERT INTO `USER` VALUES (8, '$2a$10$donnmPN7O053pcQNK48JG.3b5tBIMxr.5qiJmNKddNcNy/NNz.uWK', 'lamtrinhthong3@gmail.com', '123 Điện Biên Phủ', 'Grey3 Lam', '(+84)775311127', 3);

-- ----------------------------
-- Table structure for USER_PROJECT
-- ----------------------------
DROP TABLE IF EXISTS `USER_PROJECT`;
CREATE TABLE `USER_PROJECT`  (
  `projectId` int(0) NOT NULL,
  `userId` int(0) NOT NULL,
  `joinDate` date NOT NULL,
  `role` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`projectId`, `userId`) USING BTREE,
  INDEX `FK_UP_USER`(`userId`) USING BTREE,
  CONSTRAINT `FK_UP_PROJECT` FOREIGN KEY (`projectId`) REFERENCES `PROJECT` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_UP_USER` FOREIGN KEY (`userId`) REFERENCES `USER` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of USER_PROJECT
-- ----------------------------
INSERT INTO `USER_PROJECT` VALUES (1, 1, '2021-02-23', '1');
INSERT INTO `USER_PROJECT` VALUES (1, 5, '2021-02-23', '2');
INSERT INTO `USER_PROJECT` VALUES (1, 6, '2021-02-23', '3');
INSERT INTO `USER_PROJECT` VALUES (2, 1, '2021-02-23', '1');
INSERT INTO `USER_PROJECT` VALUES (2, 6, '2021-02-23', '3');
INSERT INTO `USER_PROJECT` VALUES (2, 7, '2021-02-23', '2');
INSERT INTO `USER_PROJECT` VALUES (2, 8, '2021-02-23', '3');

SET FOREIGN_KEY_CHECKS = 1;
