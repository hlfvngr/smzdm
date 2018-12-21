/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : smzdm

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 19/12/2018 22:48:59
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` varchar(45)  NOT NULL,
  `content` varchar(200)  DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `user_id` varchar(45)  DEFAULT NULL,
  `news_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('a01f32a6038711e9a781c8d9d29714a4', '3123123', '2018-12-19 12:14:25', '520388f902bb11e9b760c8d9d29714a4', '140921d6036a11e9a781c8d9d29714a4');
INSERT INTO `comment` VALUES ('a4305c31038711e9a781c8d9d29714a4', 'eqwewq', '2018-12-19 12:14:32', '520388f902bb11e9b760c8d9d29714a4', '140921d6036a11e9a781c8d9d29714a4');
INSERT INTO `comment` VALUES ('b50ea4e3038711e9a781c8d9d29714a4', '13123', '2018-12-19 12:15:00', '520388f902bb11e9b760c8d9d29714a4', '140921d6036a11e9a781c8d9d29714a4');
INSERT INTO `comment` VALUES ('c2e68cc5038711e9a781c8d9d29714a4', '楚中天', '2018-12-19 12:15:24', '520388f902bb11e9b760c8d9d29714a4', 'fac8f3e4036311e9a781c8d9d29714a4');

-- ----------------------------
-- Table structure for conversation
-- ----------------------------
DROP TABLE IF EXISTS `conversation`;
CREATE TABLE `conversation`  (
  `id` varchar(45)  NOT NULL,
  `content` varchar(200)   DEFAULT NULL,
  `unread` int(11)  DEFAULT 0,
  `create_date` datetime  DEFAULT NULL,
  `user_id` varchar(45)   DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for like
-- ----------------------------
DROP TABLE IF EXISTS `like`;
CREATE TABLE `like`  (
  `id` varchar(45)  NOT NULL,
  `news_id` varchar(45)  DEFAULT NULL,
  `support_id` varchar(45)  DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of like
-- ----------------------------
INSERT INTO `like` VALUES ('0e08fdb8038e11e9a781c8d9d29714a4', 'fac8f3e4036311e9a781c8d9d29714a4', '520388f902bb11e9b760c8d9d29714a4');
INSERT INTO `like` VALUES ('1979c3d6038e11e9a781c8d9d29714a4', 'e8b09aff036311e9a781c8d9d29714a4', '520388f902bb11e9b760c8d9d29714a4');
INSERT INTO `like` VALUES ('331a9238039211e9a781c8d9d29714a4', '140921d6036a11e9a781c8d9d29714a4', '520388f902bb11e9b760c8d9d29714a4');
INSERT INTO `like` VALUES ('4c57b743038e11e9a781c8d9d29714a4', 'dc5cd19c036311e9a781c8d9d29714a4', '520388f902bb11e9b760c8d9d29714a4');
INSERT INTO `like` VALUES ('66bb83c9039211e9a781c8d9d29714a4', 'b135071e036111e9a781c8d9d29714a4', '520388f902bb11e9b760c8d9d29714a4');
INSERT INTO `like` VALUES ('67975e8b039211e9a781c8d9d29714a4', '3cf12b6f036311e9a781c8d9d29714a4', '520388f902bb11e9b760c8d9d29714a4');
INSERT INTO `like` VALUES ('683160f9039211e9a781c8d9d29714a4', 'a78bb627036311e9a781c8d9d29714a4', '520388f902bb11e9b760c8d9d29714a4');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` varchar(45)  NOT NULL,
  `to_name` varchar(45)  DEFAULT NULL,
  `context` varchar(45)  DEFAULT NULL,
  `user_id` varchar(45)   DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` varchar(45)  NOT NULL,
  `title` varchar(45)  NOT NULL,
  `link` varchar(45)  DEFAULT NULL,
  `like_count` int(11)  DEFAULT 0,
  `image` varchar(200)  DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `comment_count` int(11) DEFAULT 0,
  `user_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('140921d6036a11e9a781c8d9d29714a4', 'JJ', 'jj', 0, 'https://half.oss-cn-shenzhen.aliyuncs.com/6bc54cffc8b94eb399de435ba7588336桌面壁纸 (47).jpg', '2018-12-19 08:42:55', 3, '1864311f036311e9a781c8d9d29714a4');
INSERT INTO `news` VALUES ('2', '狗十三', NULL, 23, NULL, '2016-09-05 16:00:00', 2, '520388f902bb11e9b760c8d9d29714a4');
INSERT INTO `news` VALUES ('3cf12b6f036311e9a781c8d9d29714a4', '2B小姐姐', 'two bi', 1, 'https://half.oss-cn-shenzhen.aliyuncs.com/443bdadc50194cb089daa70a7b67c8741494601810_nier-automata.jpg', '2018-12-19 07:53:57', 0, '1864311f036311e9a781c8d9d29714a4');
INSERT INTO `news` VALUES ('a78bb627036311e9a781c8d9d29714a4', '2B小姐姐', 'two bi', 1, 'https://half.oss-cn-shenzhen.aliyuncs.com/df380f4c27dc455f8b9ec4be7ec9ef391494601810_nier-automata.jpg', '2018-12-19 07:56:56', 0, '1864311f036311e9a781c8d9d29714a4');
INSERT INTO `news` VALUES ('b135071e036111e9a781c8d9d29714a4', '一人', 'qweqwe', 1, 'https://half.oss-cn-shenzhen.aliyuncs.com/41aea6af609c4aebac685664b29b3154c844c59f727abbc3b1671464e6a3472f.jpeg', '2018-12-19 07:42:53', 0, '520388f902bb11e9b760c8d9d29714a4');
INSERT INTO `news` VALUES ('dc5cd19c036311e9a781c8d9d29714a4', '123132', 'fsdfsdf', 0, 'https://half.oss-cn-shenzhen.aliyuncs.com/c187781a95354c018d193e94e74709c16e6f73a6gy1foxhlpswouj21hc0u07wi.jpg', '2018-12-19 07:58:25', 0, '1864311f036311e9a781c8d9d29714a4');
INSERT INTO `news` VALUES ('e8b09aff036311e9a781c8d9d29714a4', '一人之下', 'qweasdad', 0, 'https://half.oss-cn-shenzhen.aliyuncs.com/a436d03ceb49497f922a4f3265650cd917e69691444496486f13a59fe2499fb2.jpeg', '2018-12-19 07:58:45', 0, '520388f902bb11e9b760c8d9d29714a4');
INSERT INTO `news` VALUES ('fac8f3e4036311e9a781c8d9d29714a4', 'rqerr', 'asdasd', 0, 'https://half.oss-cn-shenzhen.aliyuncs.com/26f0fec9a7404fa488a7f47953eb009fc844c59f727abbc3b1671464e6a3472f.jpeg', '2018-12-19 07:59:16', 1, '520388f902bb11e9b760c8d9d29714a4');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` varchar(45)  NOT NULL,
  `name` varchar(45)  NOT NULL,
  `password` varchar(45)  NOT NULL,
  `head_url` varchar(45)  DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1864311f036311e9a781c8d9d29714a4', 'hyj', 'e10adc3949ba59abbe56e057f20f883e', NULL);
INSERT INTO `users` VALUES ('520388f902bb11e9b760c8d9d29714a4', 'lzr', '29397f33ffd16a105421a14e9a8f0259', NULL);

SET FOREIGN_KEY_CHECKS = 1;
