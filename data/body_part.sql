/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50534
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2014-10-04 11:43:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for body_part
-- ----------------------------
DROP TABLE IF EXISTS `body_part`;
CREATE TABLE `body_part` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(32) NOT NULL,
  `body_part_type` varchar(20) NOT NULL,
  `body_part` varchar(20) NOT NULL,
  `body_part_url` varchar(255) NOT NULL,
  `create_at` longtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of body_part
-- ----------------------------
INSERT INTO `body_part` VALUES ('1', '913c11837ffd44d1b063b5877b73a54c', '颈部', '颈部', 'http://health.sina.com.cn/disease/body/bjb/', '1412393891272');
INSERT INTO `body_part` VALUES ('2', '7b5b25df863045e09fb3fdbb1388b410', '胸部', '胸部', 'http://health.sina.com.cn/disease/body/bxb/', '1412393891471');
INSERT INTO `body_part` VALUES ('3', '308b1def18734fcdbfd1af9addfeea43', '背部', '背部', 'http://health.sina.com.cn/disease/body/bbb/', '1412393891499');
INSERT INTO `body_part` VALUES ('4', 'a92560aed87c460f884e97f4f2b5ba39', '腹部', '腹部', 'http://health.sina.com.cn/disease/body/bfb/', '1412393891528');
INSERT INTO `body_part` VALUES ('5', 'ba9df35d3b3e4afb8f6b1edf03cf7062', '头部', '鼻', 'http://health.sina.com.cn/disease/body/btb/', '1412393891557');
INSERT INTO `body_part` VALUES ('6', 'e94dd365662d4f72b823d660276cc088', '头部', '耳', 'http://health.sina.com.cn/disease/body/bter/', '1412393891577');
INSERT INTO `body_part` VALUES ('7', 'c597949093cb486690556fea35ece049', '头部', '口', 'http://health.sina.com.cn/disease/body/btk/', '1412393891598');
INSERT INTO `body_part` VALUES ('8', 'dc7f947d09e54a9da7e2d20b4ba0ca99', '头部', '咽部', 'http://health.sina.com.cn/disease/body/btyb/', '1412393891619');
INSERT INTO `body_part` VALUES ('9', 'f62cff45c15c4e858bda6ba7c1fb64a3', '头部', '眼', 'http://health.sina.com.cn/disease/body/bty/', '1412393891639');
INSERT INTO `body_part` VALUES ('10', 'bfc44d9d65964df28c9193f52da35b67', '头部', '脑', 'http://health.sina.com.cn/disease/body/btn/', '1412393891661');
INSERT INTO `body_part` VALUES ('11', '253375ce7a4a4ff38f023818c8ca67f3', '盆腔', '盆腔', 'http://health.sina.com.cn/disease/body/bpq/', '1412393891717');
INSERT INTO `body_part` VALUES ('12', '1f661ba030a24a65952ed6f2a81688e2', '臀部', '臀部', 'http://health.sina.com.cn/disease/body/btbu/', '1412393891753');
INSERT INTO `body_part` VALUES ('13', 'bc8221f490074945a960ff5c528b6537', '生殖部位', '生殖部位', 'http://health.sina.com.cn/disease/body/bsz/', '1412393891773');
INSERT INTO `body_part` VALUES ('14', '355ee6898b3d456b95150c07b66db975', '四肢', '上肢', 'http://health.sina.com.cn/disease/body/bssz/', '1412393891794');
INSERT INTO `body_part` VALUES ('15', 'fa869dd6048f49669ad7203ea56ad989', '四肢', '下肢', 'http://health.sina.com.cn/disease/body/bsxz/', '1412393891823');
INSERT INTO `body_part` VALUES ('16', 'd9ae6463d8204017a33690f09baa0fff', '皮肤', '皮肤', 'http://health.sina.com.cn/disease/body/bpf/', '1412393891844');
INSERT INTO `body_part` VALUES ('17', '4e47b629463f4cdc8790f3c84c5c1595', '全身', '全身', 'http://health.sina.com.cn/disease/body/bqs/', '1412393891873');
INSERT INTO `body_part` VALUES ('18', 'b0394e6636ef4c3ba180e19a97892ffd', '其它', '其它', 'http://health.sina.com.cn/disease/body/bxn/', '1412393891894');
