/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50133
Source Host           : localhost:3306
Source Database       : www

Target Server Type    : MYSQL
Target Server Version : 50133
File Encoding         : 65001

Date: 2020-12-14 11:58:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_device
-- ----------------------------
DROP TABLE IF EXISTS `user_device`;
CREATE TABLE `user_device` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `sn` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_device
-- ----------------------------
INSERT INTO `user_device` VALUES ('33', '1', '11604101126445');
INSERT INTO `user_device` VALUES ('34', '1', '21609105126414');
INSERT INTO `user_device` VALUES ('35', '1', '21609105126372');
INSERT INTO `user_device` VALUES ('36', '1', '21609105126430');
INSERT INTO `user_device` VALUES ('37', '1', '21609105126331');
INSERT INTO `user_device` VALUES ('38', '1', '21609105126356');
INSERT INTO `user_device` VALUES ('39', '1', '21609105126315');
INSERT INTO `user_device` VALUES ('40', '1', '11603501126526');
INSERT INTO `user_device` VALUES ('41', '1', '11603501126500');
INSERT INTO `user_device` VALUES ('42', '1', '11603501126518');
INSERT INTO `user_device` VALUES ('43', '1', '11604101126494');
INSERT INTO `user_device` VALUES ('44', '1', '11604101126460');
INSERT INTO `user_device` VALUES ('45', '1', '11604101126478');
INSERT INTO `user_device` VALUES ('46', '1', '11604101126452');
INSERT INTO `user_device` VALUES ('47', '1', '11604101126486');
INSERT INTO `user_device` VALUES ('48', '140', '11604101126452');
INSERT INTO `user_device` VALUES ('49', '140', '11604101126486');
INSERT INTO `user_device` VALUES ('50', '140', '11604101126445');
INSERT INTO `user_device` VALUES ('51', '140', '21609105126414');

-- ----------------------------
-- Table structure for user_func
-- ----------------------------
DROP TABLE IF EXISTS `user_func`;
CREATE TABLE `user_func` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `func` int(11) DEFAULT NULL,
  `ishava` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1113 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_func
-- ----------------------------
INSERT INTO `user_func` VALUES ('1', '1', '1', '1');
INSERT INTO `user_func` VALUES ('2', '1', '2', '1');
INSERT INTO `user_func` VALUES ('3', '1', '3', '1');
INSERT INTO `user_func` VALUES ('4', '1', '4', '1');
INSERT INTO `user_func` VALUES ('5', '1', '5', '1');
INSERT INTO `user_func` VALUES ('6', '1', '6', '1');
INSERT INTO `user_func` VALUES ('7', '1', '7', '1');
INSERT INTO `user_func` VALUES ('8', '1', '8', '1');
INSERT INTO `user_func` VALUES ('1097', '139', '1', '1');
INSERT INTO `user_func` VALUES ('1098', '139', '2', '1');
INSERT INTO `user_func` VALUES ('1099', '139', '3', '1');
INSERT INTO `user_func` VALUES ('1100', '139', '4', '0');
INSERT INTO `user_func` VALUES ('1101', '139', '5', '0');
INSERT INTO `user_func` VALUES ('1102', '139', '6', '1');
INSERT INTO `user_func` VALUES ('1103', '139', '7', '0');
INSERT INTO `user_func` VALUES ('1104', '139', '8', '1');
INSERT INTO `user_func` VALUES ('1105', '140', '1', '1');
INSERT INTO `user_func` VALUES ('1106', '140', '2', '1');
INSERT INTO `user_func` VALUES ('1107', '140', '3', '0');
INSERT INTO `user_func` VALUES ('1108', '140', '4', '0');
INSERT INTO `user_func` VALUES ('1109', '140', '5', '0');
INSERT INTO `user_func` VALUES ('1110', '140', '6', '1');
INSERT INTO `user_func` VALUES ('1111', '140', '7', '0');
INSERT INTO `user_func` VALUES ('1112', '140', '8', '0');

-- ----------------------------
-- Table structure for w_device
-- ----------------------------
DROP TABLE IF EXISTS `w_device`;
CREATE TABLE `w_device` (
  `did` int(255) NOT NULL AUTO_INCREMENT,
  `sn` varchar(255) DEFAULT NULL,
  `alias` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `series` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `district` varchar(255) DEFAULT NULL,
  `lat` varchar(255) DEFAULT NULL,
  `lng` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of w_device
-- ----------------------------
INSERT INTO `w_device` VALUES ('3', '11604101126452', '阿绿洲2020年', '土壤监测', '智墒', 'Fault', '阿拉善盟', '阿拉善左旗', '39.79090585', '106.69884218', '内蒙古自治区');
INSERT INTO `w_device` VALUES ('4', '11604101126486', '阿绿洲2019年', '土壤监测', '智墒', 'Used', '阿拉善盟', '阿拉善左旗', '39.79092837', '106.69872195', '内蒙古自治区');
INSERT INTO `w_device` VALUES ('5', '11604101126445', '阿绿洲纯沙地', '土壤监测', '智墒', 'Used', '阿拉善盟', '阿拉善左旗', '39.79088885', '106.69894437', '内蒙古自治区');
INSERT INTO `w_device` VALUES ('6', '21609105126414', '阿巨菌草1米高', '气象监测', '天圻智能生态站', 'Used', '阿拉善盟', '阿拉善左旗', '39.7907614', '106.69778172', '内蒙古自治区');
INSERT INTO `w_device` VALUES ('7', '21609105126372', '阿巨菌草2米高', '气象监测', '天圻智能生态站', 'Used', '阿拉善盟', '阿拉善左旗', '39.79077487', '106.69780392', '内蒙古自治区');
INSERT INTO `w_device` VALUES ('8', '21609105126430', '阿巨菌草3米高', '气象监测', '天圻智能生态站', 'Used', '阿拉善盟', '阿拉善左旗', '39.79077035', '106.69786228', '内蒙古自治区');
INSERT INTO `w_device` VALUES ('9', '21609105126331', '阿纯沙地1米高', '气象监测', '天圻智能生态站', 'Used', '阿拉善盟', '阿拉善左旗', '39.79320413', '106.69744052', '内蒙古自治区');
INSERT INTO `w_device` VALUES ('10', '21609105126356', '阿纯沙地2米高', '气象监测', '天圻智能生态站', 'Used', '阿拉善盟', '阿拉善左旗', '39.79319925', '106.69748853', '内蒙古自治区');
INSERT INTO `w_device` VALUES ('11', '21609105126315', '阿纯沙地3米高', '气象监测', '天圻智能生态站', 'Used', '阿拉善盟', '阿拉善左旗', '39.79321572', '106.69750357', '内蒙古自治区');
INSERT INTO `w_device` VALUES ('12', '11603501126526', '石绿洲轻度盐碱', '土壤监测', '智墒', 'Used', '石嘴山市', '惠农区', '39.087003', '106.722338', '宁夏回族自治区');
INSERT INTO `w_device` VALUES ('13', '11603501126500', '石绿洲重度盐碱', '土壤监测', '智墒', 'Used', '石嘴山市', '惠农区', '39.088028', '106.721808', '宁夏回族自治区');
INSERT INTO `w_device` VALUES ('14', '11603501126518', '石绿洲中度盐碱', '土壤监测', '智墒', 'Used', '石嘴山市', '惠农区', '39.087483', '106.722308', '宁夏回族自治区');
INSERT INTO `w_device` VALUES ('15', '11604101126494', '磴绿洲2020年', '土壤监测', '智墒', 'Fault', '阿拉善盟', '阿拉善左旗', '40.16418407', '106.8459193', '内蒙古自治区');
INSERT INTO `w_device` VALUES ('16', '11604101126460', '磴绿洲纯沙地', '土壤监测', '智墒', 'Used', '阿拉善盟', '阿拉善左旗', '40.16407827', '106.84590912', '内蒙古自治区');
INSERT INTO `w_device` VALUES ('17', '11604101126478', '磴绿洲2019年', '土壤监测', '智墒', 'Used', '阿拉善盟', '阿拉善左旗', '40.16456035', '106.84634408', '内蒙古自治区');

-- ----------------------------
-- Table structure for w_func
-- ----------------------------
DROP TABLE IF EXISTS `w_func`;
CREATE TABLE `w_func` (
  `fid` int(11) NOT NULL AUTO_INCREMENT,
  `fname` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  `href` varchar(255) DEFAULT NULL,
  `target` varchar(255) DEFAULT NULL,
  `ismenu` int(11) DEFAULT NULL,
  PRIMARY KEY (`fid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of w_func
-- ----------------------------
INSERT INTO `w_func` VALUES ('1', '菌草系统', '-1', 'fa fa-address-book', null, '_self', '0');
INSERT INTO `w_func` VALUES ('2', '用户管理', '1', 'fa fa-window-maximize', null, '_self', '0');
INSERT INTO `w_func` VALUES ('3', '项目管理', '1', 'fa fa-window-maximize', null, '_self', '0');
INSERT INTO `w_func` VALUES ('4', '创建用户', '2', 'fa fa-window-maximize', 'user/create', '_self', '1');
INSERT INTO `w_func` VALUES ('5', '设备授权', '2', 'fa fa-window-maximize', 'user/deviceauth', '_self', '1');
INSERT INTO `w_func` VALUES ('6', '设备查看', '2', 'fa fa-window-maximize', 'user/deviceinfo', '_self', '1');
INSERT INTO `w_func` VALUES ('7', '创建项目', '3', 'fa fa-window-maximize', 'pro/create', '_self', '1');
INSERT INTO `w_func` VALUES ('8', '项目查看', '3', 'fa fa-window-maximize', 'pro/proinfo', '_self', '1');

-- ----------------------------
-- Table structure for w_user
-- ----------------------------
DROP TABLE IF EXISTS `w_user`;
CREATE TABLE `w_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) DEFAULT NULL,
  `upwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=141 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of w_user
-- ----------------------------
INSERT INTO `w_user` VALUES ('1', 'root', '63a9f0ea7bb98050796b649e85481845');
INSERT INTO `w_user` VALUES ('139', 'wwj', '202cb962ac59075b964b07152d234b70');
INSERT INTO `w_user` VALUES ('140', 'xly', '202cb962ac59075b964b07152d234b70');
