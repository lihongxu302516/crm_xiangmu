/*
Navicat MySQL Data Transfer

Source Server         : lhx
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : crm_xiangmu

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2019-05-10 15:57:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for genzongrizhi
-- ----------------------------
DROP TABLE IF EXISTS `genzongrizhi`;
CREATE TABLE `genzongrizhi` (
  `gz_id` int(11) NOT NULL AUTO_INCREMENT,
  `gz_xuesheng` int(11) DEFAULT NULL,
  `gz_user` int(11) DEFAULT NULL,
  `gz_genzongtime` datetime DEFAULT NULL,
  `gz_genzongneirong` varchar(255) DEFAULT NULL,
  `gz_genzongfangshi` varchar(255) DEFAULT NULL,
  `gz_beizhu` varchar(255) DEFAULT NULL,
  `gz_xiacigenzongtime` datetime DEFAULT NULL,
  `gz_exe1` varchar(255) DEFAULT NULL,
  `gz_exe2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gz_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of genzongrizhi
-- ----------------------------

-- ----------------------------
-- Table structure for juese
-- ----------------------------
DROP TABLE IF EXISTS `juese`;
CREATE TABLE `juese` (
  `js_id` int(11) NOT NULL AUTO_INCREMENT,
  `js_name` varchar(50) DEFAULT NULL,
  `js_exe1` varchar(255) DEFAULT NULL,
  `js_exe2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`js_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of juese
-- ----------------------------
INSERT INTO `juese` VALUES ('1', '管理员', null, null);
INSERT INTO `juese` VALUES ('2', '咨询经理', null, null);
INSERT INTO `juese` VALUES ('3', '咨询师', null, null);
INSERT INTO `juese` VALUES ('4', '网络咨询师', null, null);

-- ----------------------------
-- Table structure for juese_mokuai
-- ----------------------------
DROP TABLE IF EXISTS `juese_mokuai`;
CREATE TABLE `juese_mokuai` (
  `jm_id` int(11) NOT NULL AUTO_INCREMENT,
  `jm_jueseid` int(11) DEFAULT NULL,
  `jm_mokuaiid` int(11) DEFAULT NULL,
  `jm_exe1` varchar(255) DEFAULT NULL,
  `jm_exe2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`jm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of juese_mokuai
-- ----------------------------
INSERT INTO `juese_mokuai` VALUES ('1', '1', '1', null, null);
INSERT INTO `juese_mokuai` VALUES ('2', '1', '2', null, null);
INSERT INTO `juese_mokuai` VALUES ('3', '1', '3', null, null);
INSERT INTO `juese_mokuai` VALUES ('4', '1', '4', null, null);

-- ----------------------------
-- Table structure for mokuai
-- ----------------------------
DROP TABLE IF EXISTS `mokuai`;
CREATE TABLE `mokuai` (
  `mk_id` int(11) NOT NULL AUTO_INCREMENT,
  `mk_name` varchar(50) DEFAULT NULL,
  `mk_fuid` int(11) DEFAULT NULL,
  `mk_checked` int(11) DEFAULT NULL,
  `mk_lujing` varchar(50) DEFAULT NULL,
  `mk_exe1` varchar(255) DEFAULT NULL,
  `mk_exe2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mokuai
-- ----------------------------
INSERT INTO `mokuai` VALUES ('1', '系统模块', '0', '1', null, null, null);
INSERT INTO `mokuai` VALUES ('2', '用户管理', '1', '2', 'yonghu_guanli', null, null);
INSERT INTO `mokuai` VALUES ('3', '角色管理', '1', '2', 'juese_guanli.jsp', null, null);
INSERT INTO `mokuai` VALUES ('4', '模块管理', '1', '2', 'mokuai_guanli.jsp', null, null);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `xs_id` int(11) NOT NULL AUTO_INCREMENT,
  `xs_chuangjiantime` datetime DEFAULT NULL,
  `xs_name` varchar(50) DEFAULT NULL,
  `xs_dianhua` varchar(50) DEFAULT NULL,
  `xs_xingbie` int(11) DEFAULT NULL,
  `xs_nianling` int(11) DEFAULT NULL,
  `xs_xueli` varchar(50) DEFAULT NULL,
  `xs_zhuangtai` varchar(50) DEFAULT NULL,
  `xs_laiyuanqudao` varchar(50) DEFAULT NULL,
  `xs_laiyuanwangzhi` varchar(50) DEFAULT NULL,
  `xs_guanzhu` varchar(50) DEFAULT NULL,
  `xs_liyuanguanjianzi` varchar(50) DEFAULT NULL,
  `xs_namezixun` varchar(50) DEFAULT NULL,
  `xs_suozaiquyu` varchar(50) DEFAULT NULL,
  `xs_weixin` varchar(50) DEFAULT NULL,
  `xs_qq` varchar(50) DEFAULT NULL,
  `xs_laiyuanbumen` varchar(50) DEFAULT NULL,
  `xs_isbaobei` varchar(50) DEFAULT NULL,
  `xs_kecheng` varchar(50) DEFAULT NULL,
  `xs_isyouxiao` int(11) DEFAULT NULL,
  `xs_dafen` varchar(50) DEFAULT NULL,
  `xs_ishuifang` int(11) DEFAULT NULL,
  `xs_shuocihuifangtime` datetime DEFAULT NULL,
  `xs_isshangmen` int(11) DEFAULT NULL,
  `xs_shangmentime` datetime DEFAULT NULL,
  `xs_wuxiaoyuanyin` varchar(225) DEFAULT NULL,
  `xs_isjiaofei` int(11) DEFAULT NULL,
  `xs_jiaofeitime` datetime DEFAULT NULL,
  `xs_jine` decimal(10,2) unsigned zerofill DEFAULT NULL,
  `xs_istuifei` int(11) DEFAULT NULL,
  `xs_isjinban` int(11) DEFAULT NULL,
  `xs_jinbantime` datetime DEFAULT NULL,
  `xs_jinbanbeizhu` varchar(255) DEFAULT NULL,
  `xs_tuifeiyuanyin` varchar(255) DEFAULT NULL,
  `xs_dingjinjine` decimal(10,2) unsigned zerofill DEFAULT NULL,
  `xs_dingjintime` datetime DEFAULT NULL,
  `xs_zixunshi` int(11) DEFAULT NULL,
  `xs_lururen` int(11) DEFAULT NULL,
  `xs_zixunshibeizhu` varchar(255) DEFAULT NULL,
  `xs_exe1` varchar(255) DEFAULT NULL,
  `xs_exe2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`xs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `us_id` int(11) NOT NULL AUTO_INCREMENT,
  `us_name` varchar(50) DEFAULT NULL,
  `us_password` varchar(50) DEFAULT NULL,
  `us_shojihao` varchar(50) DEFAULT NULL,
  `us_youxiang` varchar(50) DEFAULT NULL,
  `us_issuoding` int(11) DEFAULT NULL,
  `us_suodingtime` datetime DEFAULT NULL,
  `us_passcuowucishu` int(11) DEFAULT NULL,
  `us_chuangjiantime` datetime DEFAULT NULL,
  `us_zuihoutime` datetime DEFAULT NULL,
  `us_quanzhong` int(11) DEFAULT NULL,
  `us_pingfen` int(11) DEFAULT NULL,
  `us_pingfenrenshu` int(11) DEFAULT NULL,
  `us_isdaka` int(255) DEFAULT NULL,
  `us_dakatime` datetime DEFAULT NULL,
  `us_biezhu` varchar(255) DEFAULT NULL,
  `us_exe1` varchar(255) DEFAULT NULL,
  `us_exe2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`us_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '小红', '93aeab278e125b175cf45b7ab09af446', '18749089301', '2636973217@qq.com', '2', null, '0', null, '2019-05-10 13:08:57', null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('4', 'abc', '93aeab278e125b175cf45b7ab09af446', '18749089301', '2636973217@qq.com', '2', null, '0', '2019-05-06 20:32:53', '2019-05-06 20:33:30', '99', '0', '0', null, null, null, null, null);

-- ----------------------------
-- Table structure for user_juese
-- ----------------------------
DROP TABLE IF EXISTS `user_juese`;
CREATE TABLE `user_juese` (
  `uj_id` int(11) NOT NULL AUTO_INCREMENT,
  `uj_userid` int(11) DEFAULT NULL,
  `uj_jueseid` int(11) DEFAULT NULL,
  `uj_exe1` varchar(255) DEFAULT NULL,
  `uj_exe2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uj_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_juese
-- ----------------------------
INSERT INTO `user_juese` VALUES ('1', '1', '1', null, null);
