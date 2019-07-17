/*
 Navicat Premium Data Transfer

 Source Server Type    : MySQL
 Source Server Version : 50628
 Source Schema         : phoenix

 Target Server Type    : MySQL
 Target Server Version : 50628
 File Encoding         : 65001

 Date: 12/06/2019 14:24:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `name` varchar(32) NOT NULL COMMENT '菜单名称',
  `permission` varchar(32) DEFAULT NULL COMMENT '菜单权限标识',
  `path` varchar(128) DEFAULT NULL COMMENT '前端URL',
  `url` varchar(128) DEFAULT NULL COMMENT '请求链接',
  `method` varchar(32) DEFAULT NULL COMMENT '请求方法',
  `parent_id` int(11) DEFAULT '-1' COMMENT '父菜单ID',
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `component` varchar(64) DEFAULT NULL COMMENT 'VUE页面',
  `sort` int(11) DEFAULT '1' COMMENT '排序值',
  `type` char(1) DEFAULT '0' COMMENT '菜单类型 （0菜单 1按钮）',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '0--正常 1--删除',
  `remark` varchar(25) DEFAULT NULL COMMENT '描述',
  `menu_flag` varchar(25) DEFAULT NULL COMMENT '菜单标识',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=289 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='菜单权限表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES (1, '系统管理', NULL, '/systemManage', NULL, NULL, -1, '@res/img/icon-yewu.png', 'Layout', 8, '0', '2017-11-07 20:56:00', '2019-02-21 18:00:14', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (27, '用户管理', NULL, '/userManage', NULL, NULL, -1, '@res/img/icon-yewu.png', NULL, 2, '0', '2018-10-11 13:28:44', '2019-02-21 12:37:10', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (28, '用户列表', NULL, '/userManage/userList', NULL, NULL, 27, NULL, NULL, 1, '0', '2018-10-11 13:29:41', '2019-02-21 14:28:38', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (29, '银行卡管理', NULL, '/userManage/bankManage', NULL, NULL, 27, NULL, NULL, 1, '0', '2018-10-11 13:32:08', '2019-02-21 12:37:03', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (30, '资金管理', NULL, '/fundsManage', NULL, NULL, -1, '@res/img/icon-yewu.png', NULL, 3, '0', '2018-10-11 13:33:39', '2019-02-21 13:50:25', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (31, '提现管理', NULL, '/fundsManage/cashManage', NULL, NULL, 30, NULL, NULL, 1, '0', '2018-10-11 13:34:42', '2019-02-21 12:44:27', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (32, '提现审核', NULL, '/fundsManage/cashManage/withdrawalAudit', NULL, NULL, 31, NULL, NULL, 1, '0', '2018-10-11 13:35:02', '2019-02-21 12:44:40', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (33, '提现记录', NULL, '/fundsManage/cashManage/withdrawalRecord', NULL, NULL, 31, NULL, NULL, 1, '0', '2018-10-11 13:35:20', '2019-02-21 12:44:52', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (34, '用户账户', NULL, '/fundsManage/userAccount', NULL, NULL, 30, NULL, NULL, 1, '0', '2018-10-11 13:37:53', '2019-02-21 13:50:18', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (35, '资金记录', NULL, '/fundsManage/moneyRecord', NULL, NULL, 30, NULL, NULL, 1, '0', '2018-10-11 13:38:35', '2019-02-21 13:50:40', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (36, '充值管理', NULL, '/fundsManage/topUpManage', NULL, NULL, 30, NULL, NULL, 1, '0', '2018-10-11 13:38:58', '2019-02-21 13:50:32', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (37, 'P2P债权管理', NULL, '/debtManage', NULL, NULL, -1, '@res/img/icon-yewu.png', NULL, 4, '0', '2018-10-11 13:40:33', '2019-03-05 09:50:02', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (38, '债权列表', NULL, '/debtManage/debtList', NULL, NULL, 37, NULL, NULL, 1, '0', '2018-10-11 13:41:45', '2019-02-21 13:09:06', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (39, '申诉管理', NULL, '/debtManage/appealManage', NULL, NULL, 37, NULL, NULL, 1, '0', '2018-10-11 13:43:36', '2019-02-21 13:09:07', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (40, '审核管理', NULL, '/debtManage/auditManage', NULL, NULL, 37, NULL, NULL, 1, '0', '2018-10-11 13:45:54', '2019-02-21 13:09:10', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (41, '内容管理', NULL, '/contentManage', NULL, NULL, -1, '@res/img/icon-yewu.png', NULL, 7, '0', '2018-10-11 13:47:13', '2019-01-29 15:41:32', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (42, '帮助中心', NULL, '/contentManage/helpCenter', '/debt/sysTips/*', NULL, 41, NULL, NULL, 1, '0', '2018-10-11 13:47:44', '2019-03-27 09:59:16', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (43, '问答管理', NULL, '/contentManage/helpCenter/answersManage', '/debt/sysTips/findPageList', NULL, 42, NULL, NULL, 1, '0', '2018-10-11 13:49:57', NULL, '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (44, '分类管理', NULL, '/contentManage/helpCenter/classifyManage', '/debt/sysTips/type/list', NULL, 42, NULL, NULL, 1, '0', '2018-10-11 13:50:28', '2018-10-11 13:50:40', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (45, '网贷平台管理', NULL, '/contentManage/onlineLendingPlatformManage', NULL, NULL, 41, NULL, NULL, 1, '0', '2018-10-11 13:50:59', '2019-02-21 15:08:13', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (46, 'banner管理', NULL, '/contentManage/bannerManage', NULL, NULL, 41, NULL, NULL, 1, '0', '2018-10-11 13:52:32', '2019-02-21 15:08:31', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (47, '推送', NULL, '/systemManage/push', '/debt/message/**', NULL, 1, NULL, NULL, 1, '0', '2018-10-11 13:54:15', '2018-10-11 13:55:03', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (48, '短信推送', NULL, '/systemManage/push/smsPush', NULL, NULL, 47, NULL, NULL, 1, '0', '2018-10-11 13:55:29', NULL, '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (49, '系统推送', NULL, '/systemManage/push/systemPush', NULL, NULL, 47, NULL, NULL, 1, '0', '2018-10-11 13:55:49', NULL, '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (50, '权限管理', NULL, '/systemManage/permissionsManage', NULL, NULL, 1, NULL, NULL, 98, '0', '2018-10-11 13:56:14', '2018-10-11 15:23:31', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (51, '角色管理', NULL, '/systemManage/permissionsManage/roleManage', NULL, NULL, 50, NULL, NULL, 1, '0', '2018-10-11 13:56:32', NULL, '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (52, '管理员管理', NULL, '/systemManage/permissionsManage/adminManage', NULL, NULL, 50, NULL, NULL, 1, '0', '2018-10-11 13:56:52', NULL, '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (53, '消息模板', NULL, '/systemManage/messageTemplate', NULL, NULL, 1, NULL, NULL, 1, '0', '2018-10-11 13:57:10', '2019-05-16 18:32:40', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (54, '资金统计', NULL, '/fundsManage/moneyStatistics', NULL, NULL, 30, NULL, NULL, 1, '0', '2018-10-11 13:57:10', '2018-11-08 16:43:59', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (55, '用户债权管理', NULL, '/debtManage', NULL, NULL, -1, '@res/img/icon-message.png', NULL, 5, '0', '2018-10-11 13:57:10', '2019-01-29 15:42:42', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (56, '债权信息管理', NULL, '/userDebtManage/debtInfoManage', '/debt/userInvokeProtect/**', NULL, 55, NULL, NULL, 1, '0', '2018-10-11 13:57:10', '2019-01-29 15:21:22', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (58, '存证管理', NULL, '/certificateManage', NULL, NULL, -1, NULL, NULL, 6, '0', '2019-01-17 11:34:52', '2019-02-21 13:36:08', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (59, '存证列表', NULL, '/certificateManage/certificateList', NULL, NULL, 58, NULL, NULL, 1, '0', '2019-01-17 11:35:39', '2019-01-17 11:36:04', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (60, '文章管理', NULL, '/contentManage/articleManage', NULL, NULL, 41, NULL, NULL, 50, '0', '2019-01-18 14:21:13', '2019-02-21 15:08:39', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (61, '标签管理', NULL, '/contentManage/labelManage', NULL, NULL, 41, NULL, NULL, 52, '0', '2019-01-18 14:27:39', '2019-01-29 15:17:50', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (62, '标签管理', NULL, '/contentManage/labelManage/labelManage', '/debt/label/**', NULL, 61, NULL, NULL, 1, '0', '2019-01-18 14:29:05', '2019-01-18 14:30:57', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (63, '分类管理', NULL, '/contentManage/labelManage/classifyManage', '/debt/genre/**', NULL, 61, NULL, NULL, 1, '0', '2019-01-18 14:30:16', '2019-01-18 14:31:07', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (64, '求购信息管理', NULL, '/userDebtManage/buyInfoManage', '/debt/user_invoke_buy/**', NULL, 55, NULL, NULL, 1, '0', '2019-01-21 11:22:25', NULL, '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (66, '收费规则管理', NULL, '/fundsManage/chargeRulesManage', NULL, NULL, 30, NULL, NULL, 1, '0', '2019-01-29 14:14:29', '2019-02-21 12:55:04', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (67, '优惠券管理', NULL, '/couponManage/couponManage', NULL, NULL, 254, NULL, NULL, 1, '0', '2019-01-29 14:15:12', '2019-04-17 17:43:46', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (68, '用户优惠券', NULL, '/couponManage/userCoupon', NULL, NULL, 254, NULL, NULL, 1, '0', '2019-01-29 14:15:42', '2019-04-17 17:43:47', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (69, '邀请记录', NULL, '/userManage/inviteRecord', NULL, NULL, 27, NULL, NULL, 1, '0', '2019-01-29 14:18:13', '2019-01-29 15:20:38', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (87, '菜单管理', NULL, '/systemManage/treeManage', NULL, NULL, 1, NULL, NULL, 9, '0', '2019-02-21 11:31:11', '2019-02-21 11:31:11', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (88, '测试', NULL, NULL, NULL, NULL, 86, NULL, NULL, 9, '0', '2019-02-21 11:38:19', '2019-02-21 11:39:44', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (89, '首页', NULL, '/indexData', NULL, NULL, -1, NULL, NULL, 1, '0', '2019-02-21 11:41:22', '2019-02-21 11:43:30', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (90, '首页数据统计', NULL, '/indexData/dataStatistics', NULL, NULL, 89, NULL, NULL, 1, '0', '2019-02-21 11:42:09', '2019-02-21 11:43:56', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (91, '活动数据统计', NULL, '/indexData/activityStatistics', NULL, NULL, 89, NULL, NULL, 2, '0', '2019-02-21 11:42:55', '2019-02-21 11:44:13', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (93, '查询', NULL, NULL, '/debt/sys_step/page', NULL, 91, NULL, NULL, 1, '1', '2019-02-21 11:46:56', '2019-02-21 12:37:40', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (94, '修改', NULL, NULL, '/debt/sys_step', NULL, 91, NULL, NULL, 2, '1', '2019-02-21 12:32:25', '2019-02-21 12:37:41', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (95, '查看详情', NULL, NULL, '/debt/sys_step/coupon_summary', NULL, 91, NULL, NULL, 3, '1', '2019-02-21 12:34:31', '2019-02-21 12:37:45', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (96, '导出', NULL, NULL, '/sys_step/export_coupon_summary', NULL, 91, NULL, NULL, 4, '1', '2019-02-21 12:36:05', '2019-02-21 12:36:05', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (97, '查询', NULL, NULL, '/debt/appuser/invite_manage', NULL, 69, NULL, NULL, 1, '1', '2019-02-21 12:42:00', '2019-02-21 12:47:24', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (99, '查询', NULL, NULL, '/debt/appuser/list', NULL, 28, NULL, NULL, 1, '1', '2019-02-21 12:44:22', '2019-02-21 12:47:10', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (100, '导出', NULL, NULL, '/debt/appuser/export', NULL, 28, NULL, NULL, 2, '1', '2019-02-21 12:46:55', '2019-02-21 14:30:38', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (101, '导出', NULL, NULL, '/debt/appuser/export_invite_info', NULL, 69, NULL, NULL, 2, '1', '2019-02-21 12:48:04', '2019-02-21 12:48:04', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (102, '查询', NULL, NULL, '/debt/acUserWithdraw/page', NULL, 32, NULL, NULL, 1, '1', '2019-02-21 12:48:54', '2019-02-21 12:48:54', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (103, '审核', NULL, NULL, '/debt/acUserWithdraw/inspect', NULL, 32, NULL, NULL, 2, '1', '2019-02-21 12:50:27', '2019-02-21 12:50:27', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (104, '禁用', NULL, NULL, '/debt/appuser/status', NULL, 28, NULL, NULL, 3, '1', '2019-02-21 12:50:39', '2019-02-21 12:50:39', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (105, '详情', NULL, NULL, '/debt/appuser/details', NULL, 28, NULL, NULL, 4, '1', '2019-02-21 12:51:12', '2019-02-21 12:51:12', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (106, '查询', NULL, NULL, '/debt/appuser/bankCards', NULL, 29, NULL, NULL, 1, '1', '2019-02-21 12:51:58', '2019-02-21 12:51:58', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (107, '查询', NULL, NULL, '/debt/acUserWithdraw/page', NULL, 33, NULL, NULL, 1, '1', '2019-02-21 12:51:59', '2019-02-21 12:51:59', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (108, '导出', NULL, NULL, '/debt/userapp/exportCard', NULL, 29, NULL, NULL, 2, '1', '2019-02-21 12:52:38', '2019-02-21 12:52:38', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (109, '统计', NULL, NULL, '/debt/acUserWithdraw/summary', NULL, 33, NULL, NULL, 2, '1', '2019-02-21 12:52:39', '2019-02-21 12:52:39', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (110, '查看详情', NULL, NULL, '/debt/appuser/details', NULL, 29, NULL, NULL, 3, '1', '2019-02-21 12:53:15', '2019-02-21 12:53:15', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (111, '解绑', NULL, NULL, '/debt/appuser/untieBank', NULL, 29, NULL, NULL, 4, '1', '2019-02-21 12:54:15', '2019-02-21 12:54:15', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (112, '导出', NULL, NULL, '/debt/acUserWithdraw/export', NULL, 33, NULL, NULL, 3, '1', '2019-02-21 12:54:22', '2019-02-21 12:54:22', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (113, '设为主卡', NULL, NULL, '/debt/appuser/masterCard', NULL, 29, NULL, NULL, 5, '1', '2019-02-21 12:55:02', '2019-02-21 12:55:02', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (115, '查询', NULL, NULL, '/debt/sys_fee/page', NULL, 66, NULL, NULL, 1, '1', '2019-02-21 12:57:29', '2019-02-21 12:57:29', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (116, '新增/修改', NULL, NULL, '/debt/sys_fee', NULL, 66, NULL, NULL, 2, '1', '2019-02-21 12:58:54', '2019-02-21 12:58:54', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (117, '查询', NULL, NULL, '/debt/userfund/userinfos', NULL, 34, NULL, NULL, 1, '1', '2019-02-21 13:02:36', '2019-02-21 13:02:36', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (118, '修改开关', NULL, NULL, '/debt/userfund/switch', NULL, 34, NULL, NULL, 2, '1', '2019-02-21 13:03:57', '2019-02-21 13:03:57', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (120, '导出', NULL, NULL, '/debt/userfund/exportInfos', NULL, 34, NULL, NULL, 3, '1', '2019-02-21 13:04:41', '2019-02-21 13:04:41', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (121, '查询', NULL, NULL, '/debt/userfund/record', NULL, 35, NULL, NULL, 1, '1', '2019-02-21 13:05:49', '2019-02-21 13:05:49', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (122, '导出', NULL, NULL, '/debt/userfund/exportRecord', NULL, 35, NULL, NULL, 2, '1', '2019-02-21 13:06:28', '2019-02-21 13:06:28', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (123, '查询', NULL, NULL, '/debt/userfund/rechargeRecord', NULL, 36, NULL, NULL, 1, '1', '2019-02-21 13:07:13', '2019-02-21 13:07:13', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (124, '导出', NULL, NULL, '/debt/userfund/exportRechargeRecords', NULL, 36, NULL, NULL, 2, '1', '2019-02-21 13:07:52', '2019-02-21 13:07:52', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (125, '查询', NULL, NULL, '/debt/userfund/count', NULL, 54, NULL, NULL, 1, '1', '2019-02-21 13:08:44', '2019-02-21 13:08:44', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (126, '查询', NULL, NULL, '/debt/sysPlatform/page', NULL, 45, NULL, NULL, 1, '1', '2019-02-21 13:10:00', '2019-02-21 13:10:00', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (127, '新增', NULL, NULL, '/debt/sysPlatform/new', NULL, 45, NULL, NULL, 2, '1', '2019-02-21 13:11:05', '2019-02-21 13:11:05', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (128, '删除', NULL, NULL, '/debt/sysPlatform/del', NULL, 45, NULL, NULL, 2, '1', '2019-02-21 13:11:25', '2019-02-21 13:11:25', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (129, '编辑', NULL, NULL, '/debt/sysPlatform/edit', NULL, 45, NULL, NULL, 3, '1', '2019-02-21 13:11:51', '2019-02-21 13:11:51', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (130, '查询', NULL, NULL, '/debt/tBanner/findPageList', NULL, 46, NULL, NULL, 1, '1', '2019-02-21 13:12:31', '2019-02-21 13:12:31', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (131, '新增', NULL, NULL, '/debt/tBanner/new', NULL, 46, NULL, NULL, 2, '1', '2019-02-21 13:13:31', '2019-02-21 13:13:31', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (132, '删除', NULL, NULL, '/debt/tBanner/del', NULL, 46, NULL, NULL, 3, '1', '2019-02-21 13:13:49', '2019-02-21 13:13:49', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (133, '编辑', NULL, NULL, '/debt/tBanner/edit', NULL, 46, NULL, NULL, 4, '1', '2019-02-21 13:14:17', '2019-02-21 13:14:17', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (134, '修改状态', NULL, NULL, '/debt/tBanner/modifyStatus', NULL, 46, NULL, NULL, 5, '1', '2019-02-21 13:14:38', '2019-02-21 13:14:38', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (135, '切换规则状态', NULL, NULL, '/debt/sys_fee/status_switch/*', NULL, 66, NULL, NULL, 3, '1', '2019-02-21 13:16:00', '2019-02-21 13:16:00', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (136, '查询', NULL, NULL, '/debt/content/list', NULL, 235, NULL, NULL, 1, '1', '2019-02-21 13:16:21', '2019-03-14 15:21:20', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (137, '删除', NULL, NULL, '/debt/content/del', NULL, 235, NULL, NULL, 2, '1', '2019-02-21 13:17:21', '2019-03-14 15:21:22', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (138, '查看详情', NULL, NULL, '/debt/content/details', NULL, 235, NULL, NULL, 3, '1', '2019-02-21 13:17:39', '2019-03-14 15:21:23', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (139, '查询', NULL, NULL, '/debt/tOrderTransfer/page', NULL, 38, NULL, NULL, 1, '1', '2019-02-21 13:18:07', '2019-02-21 13:18:07', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (140, '新增or修改', NULL, NULL, '/debt/content/save_update', NULL, 235, NULL, NULL, 4, '1', '2019-02-21 13:18:26', '2019-03-14 15:21:24', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (141, '查询节点信息', NULL, NULL, '/debt/tOrderTransfer/find_logs', NULL, 38, NULL, NULL, 2, '1', '2019-02-21 13:19:33', '2019-05-24 10:28:23', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (142, '修改', NULL, NULL, '/debt/tOrderTransfer', NULL, 38, NULL, NULL, 3, '1', '2019-02-21 13:20:49', '2019-02-21 13:20:49', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (143, '下架', NULL, NULL, '/debt/tOrderTransfer/force_sold_out', NULL, 38, NULL, NULL, 4, '1', '2019-02-21 13:23:49', '2019-02-21 13:23:49', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (144, '人工介入信息', NULL, NULL, '/debt/tOrderTransfer/forceView/*', NULL, 38, NULL, NULL, 5, '1', '2019-02-21 13:24:28', '2019-05-30 17:20:21', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (145, '导出', NULL, NULL, '/debt/tOrderTransfer/export', NULL, 38, NULL, NULL, 6, '1', '2019-02-21 13:25:07', '2019-02-21 13:25:07', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (146, '查看用户信息', NULL, NULL, '/debt/appuser/simpleUserInfo/*', NULL, 38, NULL, NULL, 7, '1', '2019-02-21 13:26:48', '2019-02-21 13:26:48', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (147, '查看用户信息', NULL, NULL, '/debt/appuser/simpleUserInfo/*', NULL, 39, NULL, NULL, 1, '1', '2019-02-21 13:27:19', '2019-02-21 13:27:19', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (148, '查看用户信息', NULL, NULL, '/debt/appuser/simpleUserInfo/*', NULL, 40, NULL, NULL, 1, '1', '2019-02-21 13:27:35', '2019-02-21 13:27:35', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (149, '查询', NULL, NULL, '/debt/order_transfer_appeal/page', NULL, 39, NULL, NULL, 2, '1', '2019-02-21 13:28:31', '2019-04-30 17:19:31', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (150, '查询', NULL, NULL, '/debt/order_transfer_inspect/page', NULL, 40, NULL, NULL, 2, '1', '2019-02-21 13:29:26', '2019-04-30 17:17:02', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (151, '申诉审核', NULL, NULL, '/debt/order_transfer_appeal/appeal', NULL, 39, NULL, NULL, 3, '1', '2019-02-21 13:29:58', '2019-04-30 17:19:15', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (152, '冻结审核', NULL, NULL, '/debt/order_transfer_inspect/inspect', NULL, 40, NULL, NULL, 3, '1', '2019-02-21 13:30:20', '2019-04-30 17:16:42', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (153, '延长付款', NULL, NULL, '/debt/tOrderTransfer/force_pay_extend', NULL, 38, NULL, NULL, 8, '1', '2019-02-21 13:30:56', '2019-02-21 13:30:56', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (154, '上架', NULL, NULL, '/debt/tOrderTransfer/force_recall', NULL, 38, NULL, NULL, 9, '1', '2019-02-21 13:31:36', '2019-02-21 13:31:36', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (155, '导出', NULL, NULL, '/debt/order_transfer_appeal/export', NULL, 39, NULL, NULL, 4, '1', '2019-02-21 13:32:30', '2019-04-30 17:18:47', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (156, '导出', NULL, NULL, '/debt/order_transfer_inspect/export', NULL, 40, NULL, NULL, 4, '1', '2019-02-21 13:32:46', '2019-04-30 17:16:15', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (157, '查询', NULL, NULL, '/debt/evidence/page', NULL, 59, NULL, NULL, 1, '1', '2019-02-21 13:34:57', '2019-02-21 13:34:57', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (158, '查看附件', NULL, NULL, '/debt/evidence/file_list_view', NULL, 59, NULL, NULL, 2, '1', '2019-02-21 13:35:21', '2019-02-21 13:35:21', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (159, '导出', NULL, NULL, '/debt/evidence/export', NULL, 59, NULL, NULL, 3, '1', '2019-02-21 13:35:42', '2019-02-21 13:35:42', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (160, '查询', NULL, NULL, '/debt/sysNoticeTemplate/page', NULL, 53, NULL, NULL, 1, '1', '2019-02-21 13:40:11', '2019-02-21 13:40:11', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (161, '修改/删除', NULL, NULL, '/debt/sysNoticeTemplate/*', NULL, 53, NULL, NULL, 2, '1', '2019-02-21 13:40:33', '2019-02-21 13:40:52', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (162, '角色列表', NULL, NULL, '/debt/sysUserRole/rolePage', NULL, 51, NULL, NULL, 1, '1', '2019-02-21 13:44:42', '2019-02-21 13:44:42', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (163, '新增/删除/修改', NULL, NULL, '/debt/sysUserRole', NULL, 51, NULL, NULL, 2, '1', '2019-02-21 13:45:41', '2019-02-21 13:45:41', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (164, '查看指定角色菜单', NULL, NULL, '/debt/sysUserRole/findMenuIds/*', NULL, 51, NULL, NULL, 3, '1', '2019-02-21 13:46:39', '2019-02-21 13:46:39', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (165, '更新角色菜单', NULL, NULL, '/debt/sysUserRole/roleMenuUpd', NULL, 51, NULL, NULL, 5, '1', '2019-02-21 13:47:04', '2019-02-21 13:47:04', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (166, '查询', NULL, NULL, '/debt/sysUser/page', NULL, 52, NULL, NULL, 1, '1', '2019-02-21 13:48:47', '2019-02-21 13:48:47', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (167, '新增/修改/删除', NULL, NULL, '/debt/sysUser', NULL, 52, NULL, NULL, 3, '1', '2019-02-21 13:49:32', '2019-02-21 13:49:32', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (168, '步骤列表', NULL, NULL, '/debt/sys_coupon/step_list', NULL, 67, NULL, NULL, 1, '1', '2019-02-21 13:52:00', '2019-02-21 13:52:00', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (169, '查询', NULL, NULL, '/debt/sys_coupon/page', NULL, 67, NULL, NULL, 2, '1', '2019-02-21 13:52:22', '2019-02-21 13:52:22', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (170, '新增编辑', NULL, NULL, '/debt/sys_coupon', NULL, 67, NULL, NULL, 2, '1', '2019-02-21 13:52:49', '2019-02-21 13:52:49', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (171, '系统优惠券状态切换', NULL, NULL, '/debt/sys_coupon/status_switch/*', NULL, 67, NULL, NULL, 3, '1', '2019-02-21 13:53:21', '2019-02-21 13:53:21', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (172, '查询', NULL, NULL, '/debt/user_coupon/page', NULL, 68, NULL, NULL, 1, '1', '2019-02-21 13:54:04', '2019-02-21 13:54:04', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (173, '查询', NULL, NULL, '/debt/sys_menu/page', NULL, 87, NULL, NULL, 1, '1', '2019-02-21 13:55:29', '2019-02-21 13:55:29', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (174, '新增/修改', NULL, NULL, '/debt/sys_menu', NULL, 87, NULL, NULL, 2, '1', '2019-02-21 13:55:56', '2019-02-21 13:55:56', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (175, '删除', NULL, NULL, '/debt/sys_menu/*', NULL, 87, NULL, NULL, 3, '1', '2019-02-21 13:56:10', '2019-02-21 13:56:10', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (176, '用户菜单展示*', NULL, NULL, '/debt/auth/menuTree', NULL, -1, NULL, NULL, 0, '1', '2019-02-21 14:21:33', '2019-02-22 10:08:49', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (177, '级联菜单', NULL, NULL, '/debt/auth/allMenuTree/*', NULL, 87, NULL, NULL, 9, '1', '2019-02-21 14:29:47', '2019-02-21 14:29:47', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (178, '菜单树', NULL, NULL, '/debt/auth/allMenuTree/*', NULL, 51, NULL, NULL, 9, '1', '2019-02-21 14:30:28', '2019-02-21 14:30:28', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (179, '统计', NULL, NULL, '/debt/index/info', NULL, 90, NULL, NULL, 1, '1', '2019-02-21 18:48:41', '2019-02-21 18:48:41', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (180, '用户登出', NULL, NULL, '/debt/auth/logout', NULL, -1, NULL, NULL, 0, '1', '2019-02-22 10:09:16', '2019-02-22 10:09:16', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (181, '统计', NULL, NULL, '/debt/userfund/totalCountRecharge', NULL, 36, NULL, NULL, 3, '1', '2019-02-22 16:45:59', '2019-02-22 16:45:59', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (182, '通道列表', NULL, NULL, '/debt/tChannel/page', NULL, 46, NULL, NULL, 5, '1', '2019-03-04 18:00:32', '2019-03-04 18:00:32', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (183, '类型列表', NULL, NULL, '/debt/sysTips/types/*', NULL, 43, NULL, NULL, 4, '1', '2019-03-04 18:01:45', '2019-03-08 12:26:55', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (204, '借条债权管理', NULL, '/receiptDebtManage', '', NULL, -1, NULL, NULL, 4, '0', '2019-03-05 09:51:43', '2019-03-18 19:59:33', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (206, '债权列表', NULL, '/receiptDebtManage/debtList', '', NULL, 204, NULL, NULL, 1, '0', '2019-03-05 09:53:06', '2019-03-05 09:53:06', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (208, '查询', NULL, '', '/debt/order_loans/page', NULL, 206, NULL, NULL, 1, '1', '2019-03-05 10:06:03', '2019-03-05 10:06:03', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (209, '查询节点', NULL, '', '/debt/order_loans/find_logs', NULL, 206, NULL, NULL, 2, '1', '2019-03-05 10:06:24', '2019-03-05 10:06:24', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (210, '人工介入信息', NULL, '', '/debt/order_loans/force_view/*', NULL, 206, NULL, NULL, 3, '1', '2019-03-05 10:12:36', '2019-03-05 10:12:36', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (211, '再次发起订单', NULL, '', '/debt/order_loans/force_recall', NULL, 206, NULL, NULL, 4, '1', '2019-03-05 10:13:07', '2019-03-05 10:13:07', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (212, '下架订单', NULL, '', '/debt/order_loans/force_sold_out', NULL, 206, NULL, NULL, 5, '1', '2019-03-05 10:13:37', '2019-03-05 10:13:37', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (213, '延长付款', NULL, '', '/debt/order_loans/force_pay_extend', NULL, 206, NULL, NULL, 6, '1', '2019-03-05 10:14:07', '2019-03-05 10:14:07', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (214, '导出', NULL, '', '/debt/order_loans/export', NULL, 206, NULL, NULL, 6, '1', '2019-03-05 10:14:43', '2019-03-05 10:14:43', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (215, '爸爸权限', NULL, '', '/debt/**', NULL, -1, NULL, NULL, -1, '1', '2019-03-08 10:43:18', '2019-03-12 18:32:01', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (216, '审核管理', NULL, '', '', NULL, -1, NULL, NULL, 3, '0', '2019-03-09 14:29:07', '2019-03-09 14:29:07', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (217, '资产管理', NULL, '', '', NULL, -1, NULL, NULL, 3, '0', '2019-03-09 14:30:45', '2019-03-09 14:30:45', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (218, '分页查询', NULL, '', '/debt/app_user_attestation/page', NULL, 216, NULL, NULL, 1, '1', '2019-03-09 14:32:18', '2019-03-12 18:58:27', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (219, '审核', NULL, '', '/debt/app_user_attestation/verify', NULL, 216, NULL, NULL, 2, '1', '2019-03-09 14:32:58', '2019-03-09 14:32:58', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (220, '分页查询', NULL, '', '/debt/order_business/page_list', NULL, 217, NULL, NULL, 1, '1', '2019-03-09 14:33:52', '2019-03-09 14:33:52', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (221, '导出', NULL, '', '/debt/order_business/export', NULL, 217, NULL, NULL, 2, '1', '2019-03-09 14:34:49', '2019-03-09 14:34:49', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (222, '资产详情', NULL, '', '/debt/order_business/detail', NULL, 217, NULL, NULL, 3, '1', '2019-03-09 14:35:18', '2019-03-09 14:35:18', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (223, '审核拒绝', NULL, '', '/debt/order_business/verifier_reject', NULL, 217, NULL, NULL, 4, '1', '2019-03-09 14:35:44', '2019-03-09 14:35:44', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (224, '审核通过', NULL, '', '/debt/order_business/verifier_pass', NULL, 217, NULL, NULL, 5, '1', '2019-03-09 14:36:05', '2019-03-09 14:36:05', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (225, '切换用户状态', NULL, '', '/debt/sysUser/status_switch/*', NULL, 52, NULL, NULL, 3, '1', '2019-03-09 16:42:34', '2019-03-09 16:42:34', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (226, '下拉框数据', NULL, '', '/debt/sys_channel/select_list', NULL, 28, NULL, NULL, 4, '1', '2019-03-12 18:46:33', '2019-03-12 18:46:33', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (228, '认证详情', NULL, '', '/debt/appuser/attestation_view/*', NULL, 28, NULL, NULL, 6, '1', '2019-03-12 18:49:11', '2019-03-12 18:49:11', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (234, '审核认证信息', NULL, '', '/debt/app_user_attestation/verify', NULL, 216, NULL, NULL, 2, '1', '2019-03-12 18:51:38', '2019-03-12 18:51:38', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (235, '关于我们', NULL, '/contentManage/articleManage/aboutUs', '', NULL, 60, NULL, NULL, 1, '0', '2019-03-14 15:21:29', '2019-03-14 15:21:29', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (236, '平台档案', NULL, '/contentManage/articleManage/platformFile', '/debt/sysPlatformContent/list', NULL, 60, NULL, NULL, 2, '0', '2019-03-14 15:22:14', '2019-05-20 10:49:51', '1', NULL, NULL);
INSERT INTO `sys_menu` VALUES (237, '删除文章', NULL, NULL, '/debt/sysPlatformContent/del', NULL, 236, NULL, NULL, 1, '1', '2019-03-14 15:19:13', '2019-03-14 18:50:37', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (238, '文章详情', NULL, NULL, '/debt/sysPlatformContent/detail', NULL, 236, NULL, NULL, 1, '1', '2019-03-14 15:19:43', '2019-03-15 10:22:05', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (239, '保存或者修改', NULL, NULL, '/debt/sysPlatformContent/save_update', NULL, 236, NULL, NULL, 1, '1', '2019-03-14 15:20:12', '2019-03-14 18:50:23', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (240, '通道列表', NULL, '', '/debt/sysPlatformContent/list', NULL, 236, NULL, NULL, 2, '1', '2019-03-14 18:41:50', '2019-03-14 18:41:50', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (241, '通道列表', NULL, '', '/debt/sys_channel/select_list', NULL, 28, NULL, NULL, 4, '1', '2019-03-21 14:22:43', '2019-03-21 14:22:43', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (242, '安全卫士', NULL, '/securityguards', '', NULL, -1, NULL, NULL, 6, '0', '2019-04-10 15:08:51', '2019-04-10 15:22:21', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (243, '小贷卫士', NULL, '/securityguards/debtList', '', NULL, 242, NULL, NULL, 1, '0', '2019-04-10 15:10:57', '2019-04-10 15:10:57', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (244, 'p2p', NULL, '/securityguards/debtListp2p', '', NULL, 242, NULL, NULL, 2, '0', '2019-04-10 15:11:55', '2019-04-10 15:11:55', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (245, '充值记录', NULL, '/securityguards/prepaiderecords', '', NULL, 242, NULL, NULL, 3, '0', '2019-04-10 15:12:32', '2019-04-10 15:12:32', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (246, '分页查询', NULL, '', '/debt/ac_user_aw_recharge/page', NULL, 245, NULL, NULL, 1, '1', '2019-04-10 15:28:15', '2019-04-10 15:28:15', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (247, '导出', NULL, '', '/debt/ac_user_aw_recharge/export', NULL, 245, NULL, NULL, 2, '1', '2019-04-10 15:29:44', '2019-04-10 15:29:44', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (248, '分页查询', NULL, '', '/debt/order_support/page', NULL, 243, NULL, NULL, 1, '1', '2019-04-10 15:30:36', '2019-04-10 15:30:36', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (249, '分页查询', NULL, '', '/debt/order_support/page', NULL, 244, NULL, NULL, 1, '1', '2019-04-10 15:31:09', '2019-04-10 15:31:09', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (250, '审核', NULL, '', '/debt/order_support/inspect', NULL, 243, NULL, NULL, 2, '1', '2019-04-10 15:31:32', '2019-04-10 15:31:32', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (251, '审核', NULL, '', '/debt/order_support/inspect', NULL, 244, NULL, NULL, 2, '1', '2019-04-10 15:31:42', '2019-04-10 15:31:42', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (252, '导出', NULL, '', '/debt/order_support/export', NULL, 243, NULL, NULL, 3, '1', '2019-04-10 15:32:02', '2019-04-10 15:32:02', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (253, '导出', NULL, '', '/debt/order_support/export', NULL, 244, NULL, NULL, 3, '1', '2019-04-10 15:32:12', '2019-04-10 15:32:12', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (254, '优惠券管理', NULL, '/couponManage', '', NULL, -1, NULL, NULL, 6, '0', '2019-04-17 14:43:16', '2019-04-17 14:43:16', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (257, '优惠券发放', NULL, '/couponManage/couponGrant', '', NULL, 254, NULL, NULL, 3, '0', '2019-04-17 14:44:54', '2019-04-17 14:44:54', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (258, '审核列表查询', NULL, '', '/debt/user_coupon/inspect_page', NULL, 257, NULL, NULL, 1, '1', '2019-04-17 14:47:47', '2019-04-17 15:00:10', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (259, '审核', NULL, '', '/debt/user_coupon/inspect', NULL, 257, NULL, NULL, 2, '1', '2019-04-17 14:48:11', '2019-04-17 14:59:57', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (260, '列表查询', NULL, '', '/debt/user_coupon/page', NULL, 257, NULL, NULL, 1, '1', '2019-04-17 14:48:46', '2019-04-17 14:59:56', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (261, '发放', NULL, '', '/debt/user_coupon/release', NULL, 257, NULL, NULL, 1, '1', '2019-04-17 14:49:19', '2019-04-17 14:49:19', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (262, '上传', NULL, '', '/debt/user_coupon/upload_phone_excel', NULL, 257, NULL, NULL, 2, '1', '2019-04-17 14:49:52', '2019-04-17 14:49:52', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (263, '下载模版', NULL, '', '/debt/user_coupon/excel_temp', NULL, 257, NULL, NULL, 3, '1', '2019-04-17 14:50:09', '2019-04-17 14:50:09', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (264, '发布审核', NULL, '/debtManage/issuedAudit', '', NULL, 37, NULL, NULL, 1, '0', '2019-04-30 17:05:35', '2019-04-30 17:05:35', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (265, '分页查询', NULL, '', '/debt/order_transfer_inspect/before_release_page', NULL, 264, NULL, NULL, 1, '1', '2019-04-30 17:07:38', '2019-04-30 17:07:38', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (266, '审核', NULL, '', '/debt/order_transfer_inspect/inspect_before_release', NULL, 264, NULL, NULL, 2, '1', '2019-04-30 17:08:33', '2019-04-30 17:08:33', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (267, '发布审核', NULL, '/receiptDebtManage/issuedAudit', '/debt/order_loans/release_verify_list', NULL, 204, NULL, NULL, 1, '0', '2019-04-30 17:10:23', '2019-04-30 17:29:41', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (268, '申诉管理', NULL, '/receiptDebtManage/appealManage', '/debt/order_loans/complain_list', NULL, 204, NULL, NULL, 1, '0', '2019-04-30 17:10:47', '2019-04-30 17:32:39', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (269, '审核管理', NULL, '/receiptDebtManage/auditManage', '/debt/order_loans/frozen_list', NULL, 204, NULL, NULL, 1, '0', '2019-04-30 17:11:12', '2019-04-30 17:35:24', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (270, '日登录记录', NULL, '/userManage/loginLogs', '', NULL, 27, NULL, NULL, 1, '0', '2019-04-30 17:12:16', '2019-04-30 17:12:16', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (271, '分页查询', NULL, '', '/debt/user_login_logs/page', NULL, 270, NULL, NULL, 1, '1', '2019-04-30 17:13:24', '2019-04-30 17:13:24', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (272, '导出', NULL, '', '/debt/user_login_logs/export', NULL, 270, NULL, NULL, 2, '1', '2019-04-30 17:13:57', '2019-04-30 17:13:57', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (273, '发布审核', NULL, '', '/debt/order_loans/release_verify', NULL, 267, NULL, NULL, 1, '1', '2019-04-30 17:30:28', '2019-04-30 17:30:28', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (274, '发布列表导出', NULL, '', '/debt/order_loans/release_export', NULL, 267, NULL, NULL, 2, '1', '2019-04-30 17:31:16', '2019-04-30 17:31:16', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (275, '申诉审核', NULL, '', '/debt/order_loans/complain_verify', NULL, 268, NULL, NULL, 1, '1', '2019-04-30 17:33:52', '2019-04-30 17:33:52', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (276, '导出', NULL, '', '/debt/order_loans/complain_export', NULL, 268, NULL, NULL, 2, '1', '2019-04-30 17:34:33', '2019-04-30 17:34:33', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (277, '审核', NULL, '', '/debt/order_loans/frozen_verify', NULL, 269, NULL, NULL, 1, '1', '2019-04-30 17:35:59', '2019-04-30 17:35:59', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (278, '导出', NULL, '', '/debt/order_loans/freeze_export', NULL, 269, NULL, NULL, 2, '1', '2019-04-30 17:36:40', '2019-04-30 17:36:40', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (279, '详情', NULL, '', '/debt/order_loans/detail', NULL, 206, NULL, NULL, 6, '1', '2019-04-30 17:37:53', '2019-04-30 17:37:53', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (280, '移交审核', NULL, '', '/debt/order_loans/deliver_complain', NULL, 206, NULL, NULL, 7, '1', '2019-04-30 17:38:31', '2019-04-30 17:38:31', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (281, '内容咨询', NULL, '/contentManage/articleManage/contentInfo', '', NULL, 60, NULL, NULL, 3, '0', '2019-05-06 09:30:31', '2019-05-06 09:30:31', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (283, '查看订单详情', NULL, '', '/debt/tOrderTransfer/order_info/*', NULL, 38, NULL, NULL, 9, '1', '2019-05-24 10:31:07', '2019-05-24 10:31:07', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (284, '分页查询', NULL, '', '/debt/sysPlatformContent/list', NULL, 281, NULL, NULL, 1, '1', '2019-05-24 16:08:00', '2019-05-24 16:08:00', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (285, '文章详情', NULL, '', '/debt/sysPlatformContent/detail', NULL, 281, NULL, NULL, 2, '1', '2019-05-24 16:08:49', '2019-05-24 16:08:49', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (286, '删除文章', NULL, '', '/debt/sysPlatformContent/del', NULL, 281, NULL, NULL, 3, '1', '2019-05-24 16:09:24', '2019-05-24 16:09:24', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (287, '文章新增或修改', NULL, '', '/debt/sysPlatformContent/save_update', NULL, 281, NULL, NULL, 4, '1', '2019-05-24 16:09:58', '2019-05-24 16:09:58', '0', NULL, NULL);
INSERT INTO `sys_menu` VALUES (288, '移交审核', NULL, '', '/debt/tOrderTransfer/force_change_inspect', NULL, 38, NULL, NULL, 10, '1', '2019-06-05 16:05:33', '2019-06-05 16:05:33', '0', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_notice_template
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice_template`;
CREATE TABLE `sys_notice_template` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '模版名称[20]',
  `type` int(2) NOT NULL DEFAULT '1' COMMENT '消息类型1短信 2系统推送',
  `sign` varchar(20) DEFAULT NULL COMMENT '标示[20]',
  `title` varchar(20) NOT NULL COMMENT '标题[20]',
  `status` int(1) DEFAULT NULL COMMENT '状态:1启用 2关闭',
  `content` varchar(255) NOT NULL COMMENT '模版内容[255]',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注[255]',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `del_flag` char(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_notice_template
-- ----------------------------
BEGIN;
INSERT INTO `sys_notice_template` VALUES (1, '', 1, NULL, '', 1, '您的手机验证码为：%s，验证码有效时间10分钟。验证码很重要哦，不要轻易告诉别人！（如非本人操作，请忽略本条短信）', NULL, '2019-05-16 18:40:39', '2019-05-16 18:45:24', '0');
COMMIT;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `role_code` varchar(64) COLLATE utf8mb4_bin NOT NULL,
  `role_desc` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `ins_user_id` int(11) NOT NULL DEFAULT '1',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modified_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `del_flag` char(1) COLLATE utf8mb4_bin DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
  `remark` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`role_id`) USING BTREE,
  UNIQUE KEY `role_idx1_role_code` (`role_code`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES (1, '超级管理员', 'ROLE_ADMIN', '开发专用', 1, '2018-09-30 14:09:39', '2019-01-31 16:27:10', '0', NULL);
INSERT INTO `sys_role` VALUES (37, '测试', 'ROLE_1918451019', '测试专用', 1, '2018-10-15 18:10:04', '2019-02-22 10:12:34', '0', NULL);
INSERT INTO `sys_role` VALUES (38, '暂空', 'ROLE_7635506180', '暂空', 1, '2018-10-15 18:16:30', '2019-02-21 18:48:49', '0', NULL);
INSERT INTO `sys_role` VALUES (39, '商务运营', 'ROLE_8330412902', '商务相关运营需求', 1, '2018-10-17 16:12:05', '2019-02-21 18:23:11', '0', NULL);
INSERT INTO `sys_role` VALUES (40, '财务', 'ROLE_7766655744', '财务专用', 1, '2018-10-17 18:32:15', '2019-01-31 16:43:28', '0', NULL);
INSERT INTO `sys_role` VALUES (41, '用户运营', 'ROLE_1887122187', '客服及用户运营', 1, '2018-10-23 15:29:29', '2019-01-31 16:40:58', '0', NULL);
INSERT INTO `sys_role` VALUES (42, '社区运营', 'ROLE_3300208273', '社区用户运营', 1, '2018-10-24 12:02:39', '2019-01-31 16:40:06', '0', NULL);
INSERT INTO `sys_role` VALUES (43, '部门管理', 'ROLE_1372873960', '组长管理专用', 1, '2018-12-29 15:12:15', '2019-01-31 16:41:30', '0', NULL);
INSERT INTO `sys_role` VALUES (44, '数据运营', 'ROLE_4399777932', '数据统计分析专用', 1, '2019-01-04 10:38:24', '2019-01-31 16:41:34', '0', NULL);
INSERT INTO `sys_role` VALUES (46, '产品运营', 'ROLE_0400395332', '产品功能规则运营', 1, '2019-01-21 13:53:17', '2019-01-31 16:41:38', '0', NULL);
INSERT INTO `sys_role` VALUES (47, '企业借条-管理员', 'ROLE_8469812383', '11111', 1, '2019-03-12 18:30:52', '2019-03-12 18:30:52', '0', NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`,`menu_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色菜单表';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_menu` VALUES (1, 1);
INSERT INTO `sys_role_menu` VALUES (1, 27);
INSERT INTO `sys_role_menu` VALUES (1, 28);
INSERT INTO `sys_role_menu` VALUES (1, 29);
INSERT INTO `sys_role_menu` VALUES (1, 30);
INSERT INTO `sys_role_menu` VALUES (1, 31);
INSERT INTO `sys_role_menu` VALUES (1, 32);
INSERT INTO `sys_role_menu` VALUES (1, 33);
INSERT INTO `sys_role_menu` VALUES (1, 34);
INSERT INTO `sys_role_menu` VALUES (1, 35);
INSERT INTO `sys_role_menu` VALUES (1, 36);
INSERT INTO `sys_role_menu` VALUES (1, 37);
INSERT INTO `sys_role_menu` VALUES (1, 38);
INSERT INTO `sys_role_menu` VALUES (1, 39);
INSERT INTO `sys_role_menu` VALUES (1, 40);
INSERT INTO `sys_role_menu` VALUES (1, 41);
INSERT INTO `sys_role_menu` VALUES (1, 42);
INSERT INTO `sys_role_menu` VALUES (1, 43);
INSERT INTO `sys_role_menu` VALUES (1, 44);
INSERT INTO `sys_role_menu` VALUES (1, 45);
INSERT INTO `sys_role_menu` VALUES (1, 46);
INSERT INTO `sys_role_menu` VALUES (1, 47);
INSERT INTO `sys_role_menu` VALUES (1, 48);
INSERT INTO `sys_role_menu` VALUES (1, 49);
INSERT INTO `sys_role_menu` VALUES (1, 50);
INSERT INTO `sys_role_menu` VALUES (1, 51);
INSERT INTO `sys_role_menu` VALUES (1, 52);
INSERT INTO `sys_role_menu` VALUES (1, 53);
INSERT INTO `sys_role_menu` VALUES (1, 54);
INSERT INTO `sys_role_menu` VALUES (1, 55);
INSERT INTO `sys_role_menu` VALUES (1, 56);
INSERT INTO `sys_role_menu` VALUES (1, 58);
INSERT INTO `sys_role_menu` VALUES (1, 59);
INSERT INTO `sys_role_menu` VALUES (1, 60);
INSERT INTO `sys_role_menu` VALUES (1, 61);
INSERT INTO `sys_role_menu` VALUES (1, 62);
INSERT INTO `sys_role_menu` VALUES (1, 63);
INSERT INTO `sys_role_menu` VALUES (1, 64);
INSERT INTO `sys_role_menu` VALUES (1, 66);
INSERT INTO `sys_role_menu` VALUES (1, 67);
INSERT INTO `sys_role_menu` VALUES (1, 68);
INSERT INTO `sys_role_menu` VALUES (1, 69);
INSERT INTO `sys_role_menu` VALUES (1, 87);
INSERT INTO `sys_role_menu` VALUES (1, 89);
INSERT INTO `sys_role_menu` VALUES (1, 90);
INSERT INTO `sys_role_menu` VALUES (1, 91);
INSERT INTO `sys_role_menu` VALUES (1, 93);
INSERT INTO `sys_role_menu` VALUES (1, 94);
INSERT INTO `sys_role_menu` VALUES (1, 95);
INSERT INTO `sys_role_menu` VALUES (1, 96);
INSERT INTO `sys_role_menu` VALUES (1, 97);
INSERT INTO `sys_role_menu` VALUES (1, 99);
INSERT INTO `sys_role_menu` VALUES (1, 100);
INSERT INTO `sys_role_menu` VALUES (1, 101);
INSERT INTO `sys_role_menu` VALUES (1, 102);
INSERT INTO `sys_role_menu` VALUES (1, 103);
INSERT INTO `sys_role_menu` VALUES (1, 104);
INSERT INTO `sys_role_menu` VALUES (1, 105);
INSERT INTO `sys_role_menu` VALUES (1, 106);
INSERT INTO `sys_role_menu` VALUES (1, 107);
INSERT INTO `sys_role_menu` VALUES (1, 108);
INSERT INTO `sys_role_menu` VALUES (1, 109);
INSERT INTO `sys_role_menu` VALUES (1, 110);
INSERT INTO `sys_role_menu` VALUES (1, 111);
INSERT INTO `sys_role_menu` VALUES (1, 112);
INSERT INTO `sys_role_menu` VALUES (1, 113);
INSERT INTO `sys_role_menu` VALUES (1, 115);
INSERT INTO `sys_role_menu` VALUES (1, 116);
INSERT INTO `sys_role_menu` VALUES (1, 117);
INSERT INTO `sys_role_menu` VALUES (1, 118);
INSERT INTO `sys_role_menu` VALUES (1, 120);
INSERT INTO `sys_role_menu` VALUES (1, 121);
INSERT INTO `sys_role_menu` VALUES (1, 122);
INSERT INTO `sys_role_menu` VALUES (1, 123);
INSERT INTO `sys_role_menu` VALUES (1, 124);
INSERT INTO `sys_role_menu` VALUES (1, 125);
INSERT INTO `sys_role_menu` VALUES (1, 126);
INSERT INTO `sys_role_menu` VALUES (1, 127);
INSERT INTO `sys_role_menu` VALUES (1, 128);
INSERT INTO `sys_role_menu` VALUES (1, 129);
INSERT INTO `sys_role_menu` VALUES (1, 130);
INSERT INTO `sys_role_menu` VALUES (1, 131);
INSERT INTO `sys_role_menu` VALUES (1, 132);
INSERT INTO `sys_role_menu` VALUES (1, 133);
INSERT INTO `sys_role_menu` VALUES (1, 134);
INSERT INTO `sys_role_menu` VALUES (1, 135);
INSERT INTO `sys_role_menu` VALUES (1, 136);
INSERT INTO `sys_role_menu` VALUES (1, 137);
INSERT INTO `sys_role_menu` VALUES (1, 138);
INSERT INTO `sys_role_menu` VALUES (1, 139);
INSERT INTO `sys_role_menu` VALUES (1, 140);
INSERT INTO `sys_role_menu` VALUES (1, 141);
INSERT INTO `sys_role_menu` VALUES (1, 142);
INSERT INTO `sys_role_menu` VALUES (1, 143);
INSERT INTO `sys_role_menu` VALUES (1, 144);
INSERT INTO `sys_role_menu` VALUES (1, 145);
INSERT INTO `sys_role_menu` VALUES (1, 146);
INSERT INTO `sys_role_menu` VALUES (1, 147);
INSERT INTO `sys_role_menu` VALUES (1, 148);
INSERT INTO `sys_role_menu` VALUES (1, 149);
INSERT INTO `sys_role_menu` VALUES (1, 150);
INSERT INTO `sys_role_menu` VALUES (1, 151);
INSERT INTO `sys_role_menu` VALUES (1, 152);
INSERT INTO `sys_role_menu` VALUES (1, 153);
INSERT INTO `sys_role_menu` VALUES (1, 154);
INSERT INTO `sys_role_menu` VALUES (1, 155);
INSERT INTO `sys_role_menu` VALUES (1, 156);
INSERT INTO `sys_role_menu` VALUES (1, 157);
INSERT INTO `sys_role_menu` VALUES (1, 158);
INSERT INTO `sys_role_menu` VALUES (1, 159);
INSERT INTO `sys_role_menu` VALUES (1, 160);
INSERT INTO `sys_role_menu` VALUES (1, 161);
INSERT INTO `sys_role_menu` VALUES (1, 162);
INSERT INTO `sys_role_menu` VALUES (1, 163);
INSERT INTO `sys_role_menu` VALUES (1, 164);
INSERT INTO `sys_role_menu` VALUES (1, 165);
INSERT INTO `sys_role_menu` VALUES (1, 166);
INSERT INTO `sys_role_menu` VALUES (1, 167);
INSERT INTO `sys_role_menu` VALUES (1, 168);
INSERT INTO `sys_role_menu` VALUES (1, 169);
INSERT INTO `sys_role_menu` VALUES (1, 170);
INSERT INTO `sys_role_menu` VALUES (1, 171);
INSERT INTO `sys_role_menu` VALUES (1, 172);
INSERT INTO `sys_role_menu` VALUES (1, 173);
INSERT INTO `sys_role_menu` VALUES (1, 174);
INSERT INTO `sys_role_menu` VALUES (1, 175);
INSERT INTO `sys_role_menu` VALUES (1, 176);
INSERT INTO `sys_role_menu` VALUES (1, 177);
INSERT INTO `sys_role_menu` VALUES (1, 178);
INSERT INTO `sys_role_menu` VALUES (1, 179);
INSERT INTO `sys_role_menu` VALUES (1, 180);
INSERT INTO `sys_role_menu` VALUES (1, 181);
INSERT INTO `sys_role_menu` VALUES (1, 182);
INSERT INTO `sys_role_menu` VALUES (1, 183);
INSERT INTO `sys_role_menu` VALUES (1, 204);
INSERT INTO `sys_role_menu` VALUES (1, 206);
INSERT INTO `sys_role_menu` VALUES (1, 208);
INSERT INTO `sys_role_menu` VALUES (1, 209);
INSERT INTO `sys_role_menu` VALUES (1, 210);
INSERT INTO `sys_role_menu` VALUES (1, 211);
INSERT INTO `sys_role_menu` VALUES (1, 212);
INSERT INTO `sys_role_menu` VALUES (1, 213);
INSERT INTO `sys_role_menu` VALUES (1, 214);
INSERT INTO `sys_role_menu` VALUES (1, 225);
INSERT INTO `sys_role_menu` VALUES (1, 226);
INSERT INTO `sys_role_menu` VALUES (1, 228);
INSERT INTO `sys_role_menu` VALUES (1, 235);
INSERT INTO `sys_role_menu` VALUES (1, 241);
INSERT INTO `sys_role_menu` VALUES (1, 242);
INSERT INTO `sys_role_menu` VALUES (1, 243);
INSERT INTO `sys_role_menu` VALUES (1, 244);
INSERT INTO `sys_role_menu` VALUES (1, 245);
INSERT INTO `sys_role_menu` VALUES (1, 246);
INSERT INTO `sys_role_menu` VALUES (1, 247);
INSERT INTO `sys_role_menu` VALUES (1, 248);
INSERT INTO `sys_role_menu` VALUES (1, 249);
INSERT INTO `sys_role_menu` VALUES (1, 250);
INSERT INTO `sys_role_menu` VALUES (1, 251);
INSERT INTO `sys_role_menu` VALUES (1, 252);
INSERT INTO `sys_role_menu` VALUES (1, 253);
INSERT INTO `sys_role_menu` VALUES (1, 254);
INSERT INTO `sys_role_menu` VALUES (1, 257);
INSERT INTO `sys_role_menu` VALUES (1, 258);
INSERT INTO `sys_role_menu` VALUES (1, 259);
INSERT INTO `sys_role_menu` VALUES (1, 260);
INSERT INTO `sys_role_menu` VALUES (1, 261);
INSERT INTO `sys_role_menu` VALUES (1, 262);
INSERT INTO `sys_role_menu` VALUES (1, 263);
INSERT INTO `sys_role_menu` VALUES (1, 264);
INSERT INTO `sys_role_menu` VALUES (1, 265);
INSERT INTO `sys_role_menu` VALUES (1, 266);
INSERT INTO `sys_role_menu` VALUES (1, 267);
INSERT INTO `sys_role_menu` VALUES (1, 268);
INSERT INTO `sys_role_menu` VALUES (1, 269);
INSERT INTO `sys_role_menu` VALUES (1, 270);
INSERT INTO `sys_role_menu` VALUES (1, 271);
INSERT INTO `sys_role_menu` VALUES (1, 272);
INSERT INTO `sys_role_menu` VALUES (1, 273);
INSERT INTO `sys_role_menu` VALUES (1, 274);
INSERT INTO `sys_role_menu` VALUES (1, 275);
INSERT INTO `sys_role_menu` VALUES (1, 276);
INSERT INTO `sys_role_menu` VALUES (1, 277);
INSERT INTO `sys_role_menu` VALUES (1, 278);
INSERT INTO `sys_role_menu` VALUES (1, 279);
INSERT INTO `sys_role_menu` VALUES (1, 280);
INSERT INTO `sys_role_menu` VALUES (1, 281);
INSERT INTO `sys_role_menu` VALUES (1, 283);
INSERT INTO `sys_role_menu` VALUES (1, 284);
INSERT INTO `sys_role_menu` VALUES (1, 285);
INSERT INTO `sys_role_menu` VALUES (1, 286);
INSERT INTO `sys_role_menu` VALUES (1, 287);
INSERT INTO `sys_role_menu` VALUES (1, 288);
INSERT INTO `sys_role_menu` VALUES (37, 1);
INSERT INTO `sys_role_menu` VALUES (37, 27);
INSERT INTO `sys_role_menu` VALUES (37, 28);
INSERT INTO `sys_role_menu` VALUES (37, 29);
INSERT INTO `sys_role_menu` VALUES (37, 30);
INSERT INTO `sys_role_menu` VALUES (37, 31);
INSERT INTO `sys_role_menu` VALUES (37, 32);
INSERT INTO `sys_role_menu` VALUES (37, 33);
INSERT INTO `sys_role_menu` VALUES (37, 34);
INSERT INTO `sys_role_menu` VALUES (37, 35);
INSERT INTO `sys_role_menu` VALUES (37, 36);
INSERT INTO `sys_role_menu` VALUES (37, 37);
INSERT INTO `sys_role_menu` VALUES (37, 38);
INSERT INTO `sys_role_menu` VALUES (37, 39);
INSERT INTO `sys_role_menu` VALUES (37, 40);
INSERT INTO `sys_role_menu` VALUES (37, 41);
INSERT INTO `sys_role_menu` VALUES (37, 42);
INSERT INTO `sys_role_menu` VALUES (37, 43);
INSERT INTO `sys_role_menu` VALUES (37, 44);
INSERT INTO `sys_role_menu` VALUES (37, 45);
INSERT INTO `sys_role_menu` VALUES (37, 46);
INSERT INTO `sys_role_menu` VALUES (37, 47);
INSERT INTO `sys_role_menu` VALUES (37, 48);
INSERT INTO `sys_role_menu` VALUES (37, 49);
INSERT INTO `sys_role_menu` VALUES (37, 50);
INSERT INTO `sys_role_menu` VALUES (37, 51);
INSERT INTO `sys_role_menu` VALUES (37, 52);
INSERT INTO `sys_role_menu` VALUES (37, 53);
INSERT INTO `sys_role_menu` VALUES (37, 54);
INSERT INTO `sys_role_menu` VALUES (37, 55);
INSERT INTO `sys_role_menu` VALUES (37, 56);
INSERT INTO `sys_role_menu` VALUES (37, 58);
INSERT INTO `sys_role_menu` VALUES (37, 59);
INSERT INTO `sys_role_menu` VALUES (37, 60);
INSERT INTO `sys_role_menu` VALUES (37, 61);
INSERT INTO `sys_role_menu` VALUES (37, 62);
INSERT INTO `sys_role_menu` VALUES (37, 63);
INSERT INTO `sys_role_menu` VALUES (37, 64);
INSERT INTO `sys_role_menu` VALUES (37, 66);
INSERT INTO `sys_role_menu` VALUES (37, 67);
INSERT INTO `sys_role_menu` VALUES (37, 68);
INSERT INTO `sys_role_menu` VALUES (37, 69);
INSERT INTO `sys_role_menu` VALUES (37, 87);
INSERT INTO `sys_role_menu` VALUES (37, 89);
INSERT INTO `sys_role_menu` VALUES (37, 90);
INSERT INTO `sys_role_menu` VALUES (37, 91);
INSERT INTO `sys_role_menu` VALUES (37, 93);
INSERT INTO `sys_role_menu` VALUES (37, 94);
INSERT INTO `sys_role_menu` VALUES (37, 95);
INSERT INTO `sys_role_menu` VALUES (37, 96);
INSERT INTO `sys_role_menu` VALUES (37, 97);
INSERT INTO `sys_role_menu` VALUES (37, 99);
INSERT INTO `sys_role_menu` VALUES (37, 100);
INSERT INTO `sys_role_menu` VALUES (37, 101);
INSERT INTO `sys_role_menu` VALUES (37, 102);
INSERT INTO `sys_role_menu` VALUES (37, 103);
INSERT INTO `sys_role_menu` VALUES (37, 104);
INSERT INTO `sys_role_menu` VALUES (37, 105);
INSERT INTO `sys_role_menu` VALUES (37, 106);
INSERT INTO `sys_role_menu` VALUES (37, 107);
INSERT INTO `sys_role_menu` VALUES (37, 108);
INSERT INTO `sys_role_menu` VALUES (37, 109);
INSERT INTO `sys_role_menu` VALUES (37, 110);
INSERT INTO `sys_role_menu` VALUES (37, 111);
INSERT INTO `sys_role_menu` VALUES (37, 112);
INSERT INTO `sys_role_menu` VALUES (37, 113);
INSERT INTO `sys_role_menu` VALUES (37, 115);
INSERT INTO `sys_role_menu` VALUES (37, 116);
INSERT INTO `sys_role_menu` VALUES (37, 117);
INSERT INTO `sys_role_menu` VALUES (37, 118);
INSERT INTO `sys_role_menu` VALUES (37, 120);
INSERT INTO `sys_role_menu` VALUES (37, 121);
INSERT INTO `sys_role_menu` VALUES (37, 122);
INSERT INTO `sys_role_menu` VALUES (37, 123);
INSERT INTO `sys_role_menu` VALUES (37, 124);
INSERT INTO `sys_role_menu` VALUES (37, 125);
INSERT INTO `sys_role_menu` VALUES (37, 126);
INSERT INTO `sys_role_menu` VALUES (37, 127);
INSERT INTO `sys_role_menu` VALUES (37, 128);
INSERT INTO `sys_role_menu` VALUES (37, 129);
INSERT INTO `sys_role_menu` VALUES (37, 130);
INSERT INTO `sys_role_menu` VALUES (37, 131);
INSERT INTO `sys_role_menu` VALUES (37, 132);
INSERT INTO `sys_role_menu` VALUES (37, 133);
INSERT INTO `sys_role_menu` VALUES (37, 134);
INSERT INTO `sys_role_menu` VALUES (37, 135);
INSERT INTO `sys_role_menu` VALUES (37, 136);
INSERT INTO `sys_role_menu` VALUES (37, 137);
INSERT INTO `sys_role_menu` VALUES (37, 138);
INSERT INTO `sys_role_menu` VALUES (37, 139);
INSERT INTO `sys_role_menu` VALUES (37, 140);
INSERT INTO `sys_role_menu` VALUES (37, 141);
INSERT INTO `sys_role_menu` VALUES (37, 142);
INSERT INTO `sys_role_menu` VALUES (37, 143);
INSERT INTO `sys_role_menu` VALUES (37, 144);
INSERT INTO `sys_role_menu` VALUES (37, 145);
INSERT INTO `sys_role_menu` VALUES (37, 146);
INSERT INTO `sys_role_menu` VALUES (37, 147);
INSERT INTO `sys_role_menu` VALUES (37, 148);
INSERT INTO `sys_role_menu` VALUES (37, 149);
INSERT INTO `sys_role_menu` VALUES (37, 150);
INSERT INTO `sys_role_menu` VALUES (37, 151);
INSERT INTO `sys_role_menu` VALUES (37, 152);
INSERT INTO `sys_role_menu` VALUES (37, 153);
INSERT INTO `sys_role_menu` VALUES (37, 154);
INSERT INTO `sys_role_menu` VALUES (37, 155);
INSERT INTO `sys_role_menu` VALUES (37, 156);
INSERT INTO `sys_role_menu` VALUES (37, 157);
INSERT INTO `sys_role_menu` VALUES (37, 158);
INSERT INTO `sys_role_menu` VALUES (37, 159);
INSERT INTO `sys_role_menu` VALUES (37, 160);
INSERT INTO `sys_role_menu` VALUES (37, 161);
INSERT INTO `sys_role_menu` VALUES (37, 162);
INSERT INTO `sys_role_menu` VALUES (37, 164);
INSERT INTO `sys_role_menu` VALUES (37, 165);
INSERT INTO `sys_role_menu` VALUES (37, 166);
INSERT INTO `sys_role_menu` VALUES (37, 168);
INSERT INTO `sys_role_menu` VALUES (37, 169);
INSERT INTO `sys_role_menu` VALUES (37, 170);
INSERT INTO `sys_role_menu` VALUES (37, 171);
INSERT INTO `sys_role_menu` VALUES (37, 172);
INSERT INTO `sys_role_menu` VALUES (37, 173);
INSERT INTO `sys_role_menu` VALUES (37, 174);
INSERT INTO `sys_role_menu` VALUES (37, 175);
INSERT INTO `sys_role_menu` VALUES (37, 176);
INSERT INTO `sys_role_menu` VALUES (37, 177);
INSERT INTO `sys_role_menu` VALUES (37, 178);
INSERT INTO `sys_role_menu` VALUES (37, 179);
INSERT INTO `sys_role_menu` VALUES (37, 180);
INSERT INTO `sys_role_menu` VALUES (37, 183);
INSERT INTO `sys_role_menu` VALUES (37, 235);
INSERT INTO `sys_role_menu` VALUES (37, 241);
INSERT INTO `sys_role_menu` VALUES (37, 242);
INSERT INTO `sys_role_menu` VALUES (37, 243);
INSERT INTO `sys_role_menu` VALUES (37, 244);
INSERT INTO `sys_role_menu` VALUES (37, 245);
INSERT INTO `sys_role_menu` VALUES (37, 246);
INSERT INTO `sys_role_menu` VALUES (37, 247);
INSERT INTO `sys_role_menu` VALUES (37, 248);
INSERT INTO `sys_role_menu` VALUES (37, 249);
INSERT INTO `sys_role_menu` VALUES (37, 250);
INSERT INTO `sys_role_menu` VALUES (37, 251);
INSERT INTO `sys_role_menu` VALUES (37, 252);
INSERT INTO `sys_role_menu` VALUES (37, 253);
INSERT INTO `sys_role_menu` VALUES (37, 254);
INSERT INTO `sys_role_menu` VALUES (37, 257);
INSERT INTO `sys_role_menu` VALUES (37, 258);
INSERT INTO `sys_role_menu` VALUES (37, 259);
INSERT INTO `sys_role_menu` VALUES (37, 260);
INSERT INTO `sys_role_menu` VALUES (37, 261);
INSERT INTO `sys_role_menu` VALUES (37, 262);
INSERT INTO `sys_role_menu` VALUES (37, 263);
INSERT INTO `sys_role_menu` VALUES (37, 264);
INSERT INTO `sys_role_menu` VALUES (37, 265);
INSERT INTO `sys_role_menu` VALUES (37, 266);
INSERT INTO `sys_role_menu` VALUES (37, 270);
INSERT INTO `sys_role_menu` VALUES (37, 271);
INSERT INTO `sys_role_menu` VALUES (37, 272);
INSERT INTO `sys_role_menu` VALUES (37, 281);
INSERT INTO `sys_role_menu` VALUES (38, 176);
INSERT INTO `sys_role_menu` VALUES (39, 1);
INSERT INTO `sys_role_menu` VALUES (39, 30);
INSERT INTO `sys_role_menu` VALUES (39, 31);
INSERT INTO `sys_role_menu` VALUES (39, 32);
INSERT INTO `sys_role_menu` VALUES (39, 33);
INSERT INTO `sys_role_menu` VALUES (39, 34);
INSERT INTO `sys_role_menu` VALUES (39, 35);
INSERT INTO `sys_role_menu` VALUES (39, 36);
INSERT INTO `sys_role_menu` VALUES (39, 37);
INSERT INTO `sys_role_menu` VALUES (39, 38);
INSERT INTO `sys_role_menu` VALUES (39, 41);
INSERT INTO `sys_role_menu` VALUES (39, 42);
INSERT INTO `sys_role_menu` VALUES (39, 43);
INSERT INTO `sys_role_menu` VALUES (39, 44);
INSERT INTO `sys_role_menu` VALUES (39, 45);
INSERT INTO `sys_role_menu` VALUES (39, 46);
INSERT INTO `sys_role_menu` VALUES (39, 47);
INSERT INTO `sys_role_menu` VALUES (39, 48);
INSERT INTO `sys_role_menu` VALUES (39, 49);
INSERT INTO `sys_role_menu` VALUES (39, 53);
INSERT INTO `sys_role_menu` VALUES (39, 54);
INSERT INTO `sys_role_menu` VALUES (39, 55);
INSERT INTO `sys_role_menu` VALUES (39, 56);
INSERT INTO `sys_role_menu` VALUES (39, 60);
INSERT INTO `sys_role_menu` VALUES (39, 61);
INSERT INTO `sys_role_menu` VALUES (39, 62);
INSERT INTO `sys_role_menu` VALUES (39, 63);
INSERT INTO `sys_role_menu` VALUES (39, 64);
INSERT INTO `sys_role_menu` VALUES (39, 66);
INSERT INTO `sys_role_menu` VALUES (39, 67);
INSERT INTO `sys_role_menu` VALUES (39, 68);
INSERT INTO `sys_role_menu` VALUES (39, 87);
INSERT INTO `sys_role_menu` VALUES (39, 102);
INSERT INTO `sys_role_menu` VALUES (39, 103);
INSERT INTO `sys_role_menu` VALUES (39, 107);
INSERT INTO `sys_role_menu` VALUES (39, 109);
INSERT INTO `sys_role_menu` VALUES (39, 112);
INSERT INTO `sys_role_menu` VALUES (39, 115);
INSERT INTO `sys_role_menu` VALUES (39, 116);
INSERT INTO `sys_role_menu` VALUES (39, 117);
INSERT INTO `sys_role_menu` VALUES (39, 118);
INSERT INTO `sys_role_menu` VALUES (39, 120);
INSERT INTO `sys_role_menu` VALUES (39, 121);
INSERT INTO `sys_role_menu` VALUES (39, 122);
INSERT INTO `sys_role_menu` VALUES (39, 123);
INSERT INTO `sys_role_menu` VALUES (39, 124);
INSERT INTO `sys_role_menu` VALUES (39, 125);
INSERT INTO `sys_role_menu` VALUES (39, 126);
INSERT INTO `sys_role_menu` VALUES (39, 127);
INSERT INTO `sys_role_menu` VALUES (39, 128);
INSERT INTO `sys_role_menu` VALUES (39, 129);
INSERT INTO `sys_role_menu` VALUES (39, 130);
INSERT INTO `sys_role_menu` VALUES (39, 131);
INSERT INTO `sys_role_menu` VALUES (39, 132);
INSERT INTO `sys_role_menu` VALUES (39, 133);
INSERT INTO `sys_role_menu` VALUES (39, 134);
INSERT INTO `sys_role_menu` VALUES (39, 135);
INSERT INTO `sys_role_menu` VALUES (39, 136);
INSERT INTO `sys_role_menu` VALUES (39, 137);
INSERT INTO `sys_role_menu` VALUES (39, 138);
INSERT INTO `sys_role_menu` VALUES (39, 139);
INSERT INTO `sys_role_menu` VALUES (39, 140);
INSERT INTO `sys_role_menu` VALUES (39, 141);
INSERT INTO `sys_role_menu` VALUES (39, 146);
INSERT INTO `sys_role_menu` VALUES (39, 160);
INSERT INTO `sys_role_menu` VALUES (39, 161);
INSERT INTO `sys_role_menu` VALUES (39, 168);
INSERT INTO `sys_role_menu` VALUES (39, 169);
INSERT INTO `sys_role_menu` VALUES (39, 170);
INSERT INTO `sys_role_menu` VALUES (39, 171);
INSERT INTO `sys_role_menu` VALUES (39, 172);
INSERT INTO `sys_role_menu` VALUES (39, 173);
INSERT INTO `sys_role_menu` VALUES (39, 174);
INSERT INTO `sys_role_menu` VALUES (39, 175);
INSERT INTO `sys_role_menu` VALUES (39, 176);
INSERT INTO `sys_role_menu` VALUES (39, 177);
INSERT INTO `sys_role_menu` VALUES (39, 180);
INSERT INTO `sys_role_menu` VALUES (39, 181);
INSERT INTO `sys_role_menu` VALUES (39, 182);
INSERT INTO `sys_role_menu` VALUES (39, 183);
INSERT INTO `sys_role_menu` VALUES (39, 204);
INSERT INTO `sys_role_menu` VALUES (39, 206);
INSERT INTO `sys_role_menu` VALUES (39, 208);
INSERT INTO `sys_role_menu` VALUES (39, 209);
INSERT INTO `sys_role_menu` VALUES (39, 210);
INSERT INTO `sys_role_menu` VALUES (39, 211);
INSERT INTO `sys_role_menu` VALUES (39, 212);
INSERT INTO `sys_role_menu` VALUES (39, 213);
INSERT INTO `sys_role_menu` VALUES (39, 235);
INSERT INTO `sys_role_menu` VALUES (39, 242);
INSERT INTO `sys_role_menu` VALUES (39, 243);
INSERT INTO `sys_role_menu` VALUES (39, 244);
INSERT INTO `sys_role_menu` VALUES (39, 245);
INSERT INTO `sys_role_menu` VALUES (39, 246);
INSERT INTO `sys_role_menu` VALUES (39, 247);
INSERT INTO `sys_role_menu` VALUES (39, 248);
INSERT INTO `sys_role_menu` VALUES (39, 249);
INSERT INTO `sys_role_menu` VALUES (39, 250);
INSERT INTO `sys_role_menu` VALUES (39, 251);
INSERT INTO `sys_role_menu` VALUES (39, 252);
INSERT INTO `sys_role_menu` VALUES (39, 253);
INSERT INTO `sys_role_menu` VALUES (39, 254);
INSERT INTO `sys_role_menu` VALUES (39, 281);
INSERT INTO `sys_role_menu` VALUES (40, 30);
INSERT INTO `sys_role_menu` VALUES (40, 31);
INSERT INTO `sys_role_menu` VALUES (40, 32);
INSERT INTO `sys_role_menu` VALUES (40, 33);
INSERT INTO `sys_role_menu` VALUES (40, 34);
INSERT INTO `sys_role_menu` VALUES (40, 35);
INSERT INTO `sys_role_menu` VALUES (40, 36);
INSERT INTO `sys_role_menu` VALUES (40, 54);
INSERT INTO `sys_role_menu` VALUES (40, 102);
INSERT INTO `sys_role_menu` VALUES (40, 103);
INSERT INTO `sys_role_menu` VALUES (40, 107);
INSERT INTO `sys_role_menu` VALUES (40, 109);
INSERT INTO `sys_role_menu` VALUES (40, 112);
INSERT INTO `sys_role_menu` VALUES (40, 117);
INSERT INTO `sys_role_menu` VALUES (40, 118);
INSERT INTO `sys_role_menu` VALUES (40, 120);
INSERT INTO `sys_role_menu` VALUES (40, 121);
INSERT INTO `sys_role_menu` VALUES (40, 122);
INSERT INTO `sys_role_menu` VALUES (40, 123);
INSERT INTO `sys_role_menu` VALUES (40, 124);
INSERT INTO `sys_role_menu` VALUES (40, 125);
INSERT INTO `sys_role_menu` VALUES (40, 176);
INSERT INTO `sys_role_menu` VALUES (40, 180);
INSERT INTO `sys_role_menu` VALUES (41, 1);
INSERT INTO `sys_role_menu` VALUES (41, 27);
INSERT INTO `sys_role_menu` VALUES (41, 28);
INSERT INTO `sys_role_menu` VALUES (41, 29);
INSERT INTO `sys_role_menu` VALUES (41, 30);
INSERT INTO `sys_role_menu` VALUES (41, 31);
INSERT INTO `sys_role_menu` VALUES (41, 32);
INSERT INTO `sys_role_menu` VALUES (41, 33);
INSERT INTO `sys_role_menu` VALUES (41, 34);
INSERT INTO `sys_role_menu` VALUES (41, 35);
INSERT INTO `sys_role_menu` VALUES (41, 36);
INSERT INTO `sys_role_menu` VALUES (41, 37);
INSERT INTO `sys_role_menu` VALUES (41, 38);
INSERT INTO `sys_role_menu` VALUES (41, 39);
INSERT INTO `sys_role_menu` VALUES (41, 40);
INSERT INTO `sys_role_menu` VALUES (41, 41);
INSERT INTO `sys_role_menu` VALUES (41, 42);
INSERT INTO `sys_role_menu` VALUES (41, 43);
INSERT INTO `sys_role_menu` VALUES (41, 44);
INSERT INTO `sys_role_menu` VALUES (41, 45);
INSERT INTO `sys_role_menu` VALUES (41, 46);
INSERT INTO `sys_role_menu` VALUES (41, 47);
INSERT INTO `sys_role_menu` VALUES (41, 48);
INSERT INTO `sys_role_menu` VALUES (41, 49);
INSERT INTO `sys_role_menu` VALUES (41, 54);
INSERT INTO `sys_role_menu` VALUES (41, 55);
INSERT INTO `sys_role_menu` VALUES (41, 56);
INSERT INTO `sys_role_menu` VALUES (41, 58);
INSERT INTO `sys_role_menu` VALUES (41, 59);
INSERT INTO `sys_role_menu` VALUES (41, 60);
INSERT INTO `sys_role_menu` VALUES (41, 61);
INSERT INTO `sys_role_menu` VALUES (41, 62);
INSERT INTO `sys_role_menu` VALUES (41, 63);
INSERT INTO `sys_role_menu` VALUES (41, 64);
INSERT INTO `sys_role_menu` VALUES (41, 66);
INSERT INTO `sys_role_menu` VALUES (41, 67);
INSERT INTO `sys_role_menu` VALUES (41, 68);
INSERT INTO `sys_role_menu` VALUES (41, 69);
INSERT INTO `sys_role_menu` VALUES (41, 89);
INSERT INTO `sys_role_menu` VALUES (41, 90);
INSERT INTO `sys_role_menu` VALUES (41, 91);
INSERT INTO `sys_role_menu` VALUES (41, 93);
INSERT INTO `sys_role_menu` VALUES (41, 94);
INSERT INTO `sys_role_menu` VALUES (41, 95);
INSERT INTO `sys_role_menu` VALUES (41, 96);
INSERT INTO `sys_role_menu` VALUES (41, 97);
INSERT INTO `sys_role_menu` VALUES (41, 99);
INSERT INTO `sys_role_menu` VALUES (41, 102);
INSERT INTO `sys_role_menu` VALUES (41, 103);
INSERT INTO `sys_role_menu` VALUES (41, 104);
INSERT INTO `sys_role_menu` VALUES (41, 105);
INSERT INTO `sys_role_menu` VALUES (41, 106);
INSERT INTO `sys_role_menu` VALUES (41, 107);
INSERT INTO `sys_role_menu` VALUES (41, 108);
INSERT INTO `sys_role_menu` VALUES (41, 110);
INSERT INTO `sys_role_menu` VALUES (41, 111);
INSERT INTO `sys_role_menu` VALUES (41, 113);
INSERT INTO `sys_role_menu` VALUES (41, 115);
INSERT INTO `sys_role_menu` VALUES (41, 116);
INSERT INTO `sys_role_menu` VALUES (41, 117);
INSERT INTO `sys_role_menu` VALUES (41, 118);
INSERT INTO `sys_role_menu` VALUES (41, 121);
INSERT INTO `sys_role_menu` VALUES (41, 123);
INSERT INTO `sys_role_menu` VALUES (41, 125);
INSERT INTO `sys_role_menu` VALUES (41, 126);
INSERT INTO `sys_role_menu` VALUES (41, 127);
INSERT INTO `sys_role_menu` VALUES (41, 128);
INSERT INTO `sys_role_menu` VALUES (41, 129);
INSERT INTO `sys_role_menu` VALUES (41, 130);
INSERT INTO `sys_role_menu` VALUES (41, 131);
INSERT INTO `sys_role_menu` VALUES (41, 132);
INSERT INTO `sys_role_menu` VALUES (41, 133);
INSERT INTO `sys_role_menu` VALUES (41, 134);
INSERT INTO `sys_role_menu` VALUES (41, 135);
INSERT INTO `sys_role_menu` VALUES (41, 136);
INSERT INTO `sys_role_menu` VALUES (41, 137);
INSERT INTO `sys_role_menu` VALUES (41, 138);
INSERT INTO `sys_role_menu` VALUES (41, 139);
INSERT INTO `sys_role_menu` VALUES (41, 140);
INSERT INTO `sys_role_menu` VALUES (41, 141);
INSERT INTO `sys_role_menu` VALUES (41, 142);
INSERT INTO `sys_role_menu` VALUES (41, 143);
INSERT INTO `sys_role_menu` VALUES (41, 144);
INSERT INTO `sys_role_menu` VALUES (41, 146);
INSERT INTO `sys_role_menu` VALUES (41, 147);
INSERT INTO `sys_role_menu` VALUES (41, 148);
INSERT INTO `sys_role_menu` VALUES (41, 149);
INSERT INTO `sys_role_menu` VALUES (41, 150);
INSERT INTO `sys_role_menu` VALUES (41, 151);
INSERT INTO `sys_role_menu` VALUES (41, 152);
INSERT INTO `sys_role_menu` VALUES (41, 153);
INSERT INTO `sys_role_menu` VALUES (41, 154);
INSERT INTO `sys_role_menu` VALUES (41, 157);
INSERT INTO `sys_role_menu` VALUES (41, 158);
INSERT INTO `sys_role_menu` VALUES (41, 159);
INSERT INTO `sys_role_menu` VALUES (41, 168);
INSERT INTO `sys_role_menu` VALUES (41, 169);
INSERT INTO `sys_role_menu` VALUES (41, 170);
INSERT INTO `sys_role_menu` VALUES (41, 171);
INSERT INTO `sys_role_menu` VALUES (41, 172);
INSERT INTO `sys_role_menu` VALUES (41, 176);
INSERT INTO `sys_role_menu` VALUES (41, 179);
INSERT INTO `sys_role_menu` VALUES (41, 180);
INSERT INTO `sys_role_menu` VALUES (41, 182);
INSERT INTO `sys_role_menu` VALUES (41, 183);
INSERT INTO `sys_role_menu` VALUES (41, 204);
INSERT INTO `sys_role_menu` VALUES (41, 206);
INSERT INTO `sys_role_menu` VALUES (41, 208);
INSERT INTO `sys_role_menu` VALUES (41, 209);
INSERT INTO `sys_role_menu` VALUES (41, 210);
INSERT INTO `sys_role_menu` VALUES (41, 211);
INSERT INTO `sys_role_menu` VALUES (41, 212);
INSERT INTO `sys_role_menu` VALUES (41, 213);
INSERT INTO `sys_role_menu` VALUES (41, 226);
INSERT INTO `sys_role_menu` VALUES (41, 228);
INSERT INTO `sys_role_menu` VALUES (41, 235);
INSERT INTO `sys_role_menu` VALUES (41, 241);
INSERT INTO `sys_role_menu` VALUES (41, 242);
INSERT INTO `sys_role_menu` VALUES (41, 243);
INSERT INTO `sys_role_menu` VALUES (41, 244);
INSERT INTO `sys_role_menu` VALUES (41, 245);
INSERT INTO `sys_role_menu` VALUES (41, 246);
INSERT INTO `sys_role_menu` VALUES (41, 247);
INSERT INTO `sys_role_menu` VALUES (41, 248);
INSERT INTO `sys_role_menu` VALUES (41, 249);
INSERT INTO `sys_role_menu` VALUES (41, 250);
INSERT INTO `sys_role_menu` VALUES (41, 251);
INSERT INTO `sys_role_menu` VALUES (41, 252);
INSERT INTO `sys_role_menu` VALUES (41, 253);
INSERT INTO `sys_role_menu` VALUES (41, 254);
INSERT INTO `sys_role_menu` VALUES (41, 257);
INSERT INTO `sys_role_menu` VALUES (41, 258);
INSERT INTO `sys_role_menu` VALUES (41, 259);
INSERT INTO `sys_role_menu` VALUES (41, 260);
INSERT INTO `sys_role_menu` VALUES (41, 261);
INSERT INTO `sys_role_menu` VALUES (41, 262);
INSERT INTO `sys_role_menu` VALUES (41, 263);
INSERT INTO `sys_role_menu` VALUES (41, 264);
INSERT INTO `sys_role_menu` VALUES (41, 265);
INSERT INTO `sys_role_menu` VALUES (41, 266);
INSERT INTO `sys_role_menu` VALUES (41, 267);
INSERT INTO `sys_role_menu` VALUES (41, 268);
INSERT INTO `sys_role_menu` VALUES (41, 269);
INSERT INTO `sys_role_menu` VALUES (41, 273);
INSERT INTO `sys_role_menu` VALUES (41, 274);
INSERT INTO `sys_role_menu` VALUES (41, 275);
INSERT INTO `sys_role_menu` VALUES (41, 276);
INSERT INTO `sys_role_menu` VALUES (41, 277);
INSERT INTO `sys_role_menu` VALUES (41, 278);
INSERT INTO `sys_role_menu` VALUES (41, 279);
INSERT INTO `sys_role_menu` VALUES (41, 280);
INSERT INTO `sys_role_menu` VALUES (41, 281);
INSERT INTO `sys_role_menu` VALUES (41, 283);
INSERT INTO `sys_role_menu` VALUES (41, 284);
INSERT INTO `sys_role_menu` VALUES (41, 285);
INSERT INTO `sys_role_menu` VALUES (41, 286);
INSERT INTO `sys_role_menu` VALUES (41, 287);
INSERT INTO `sys_role_menu` VALUES (41, 288);
INSERT INTO `sys_role_menu` VALUES (42, 27);
INSERT INTO `sys_role_menu` VALUES (42, 69);
INSERT INTO `sys_role_menu` VALUES (42, 97);
INSERT INTO `sys_role_menu` VALUES (42, 101);
INSERT INTO `sys_role_menu` VALUES (42, 176);
INSERT INTO `sys_role_menu` VALUES (42, 180);
INSERT INTO `sys_role_menu` VALUES (43, 1);
INSERT INTO `sys_role_menu` VALUES (43, 27);
INSERT INTO `sys_role_menu` VALUES (43, 28);
INSERT INTO `sys_role_menu` VALUES (43, 29);
INSERT INTO `sys_role_menu` VALUES (43, 30);
INSERT INTO `sys_role_menu` VALUES (43, 31);
INSERT INTO `sys_role_menu` VALUES (43, 32);
INSERT INTO `sys_role_menu` VALUES (43, 33);
INSERT INTO `sys_role_menu` VALUES (43, 34);
INSERT INTO `sys_role_menu` VALUES (43, 35);
INSERT INTO `sys_role_menu` VALUES (43, 36);
INSERT INTO `sys_role_menu` VALUES (43, 37);
INSERT INTO `sys_role_menu` VALUES (43, 38);
INSERT INTO `sys_role_menu` VALUES (43, 39);
INSERT INTO `sys_role_menu` VALUES (43, 40);
INSERT INTO `sys_role_menu` VALUES (43, 41);
INSERT INTO `sys_role_menu` VALUES (43, 42);
INSERT INTO `sys_role_menu` VALUES (43, 43);
INSERT INTO `sys_role_menu` VALUES (43, 44);
INSERT INTO `sys_role_menu` VALUES (43, 45);
INSERT INTO `sys_role_menu` VALUES (43, 46);
INSERT INTO `sys_role_menu` VALUES (43, 47);
INSERT INTO `sys_role_menu` VALUES (43, 48);
INSERT INTO `sys_role_menu` VALUES (43, 49);
INSERT INTO `sys_role_menu` VALUES (43, 50);
INSERT INTO `sys_role_menu` VALUES (43, 52);
INSERT INTO `sys_role_menu` VALUES (43, 55);
INSERT INTO `sys_role_menu` VALUES (43, 56);
INSERT INTO `sys_role_menu` VALUES (43, 58);
INSERT INTO `sys_role_menu` VALUES (43, 59);
INSERT INTO `sys_role_menu` VALUES (43, 60);
INSERT INTO `sys_role_menu` VALUES (43, 61);
INSERT INTO `sys_role_menu` VALUES (43, 62);
INSERT INTO `sys_role_menu` VALUES (43, 63);
INSERT INTO `sys_role_menu` VALUES (43, 64);
INSERT INTO `sys_role_menu` VALUES (43, 66);
INSERT INTO `sys_role_menu` VALUES (43, 67);
INSERT INTO `sys_role_menu` VALUES (43, 68);
INSERT INTO `sys_role_menu` VALUES (43, 69);
INSERT INTO `sys_role_menu` VALUES (43, 97);
INSERT INTO `sys_role_menu` VALUES (43, 99);
INSERT INTO `sys_role_menu` VALUES (43, 100);
INSERT INTO `sys_role_menu` VALUES (43, 101);
INSERT INTO `sys_role_menu` VALUES (43, 102);
INSERT INTO `sys_role_menu` VALUES (43, 103);
INSERT INTO `sys_role_menu` VALUES (43, 104);
INSERT INTO `sys_role_menu` VALUES (43, 105);
INSERT INTO `sys_role_menu` VALUES (43, 106);
INSERT INTO `sys_role_menu` VALUES (43, 107);
INSERT INTO `sys_role_menu` VALUES (43, 108);
INSERT INTO `sys_role_menu` VALUES (43, 109);
INSERT INTO `sys_role_menu` VALUES (43, 110);
INSERT INTO `sys_role_menu` VALUES (43, 111);
INSERT INTO `sys_role_menu` VALUES (43, 112);
INSERT INTO `sys_role_menu` VALUES (43, 113);
INSERT INTO `sys_role_menu` VALUES (43, 115);
INSERT INTO `sys_role_menu` VALUES (43, 116);
INSERT INTO `sys_role_menu` VALUES (43, 117);
INSERT INTO `sys_role_menu` VALUES (43, 118);
INSERT INTO `sys_role_menu` VALUES (43, 120);
INSERT INTO `sys_role_menu` VALUES (43, 121);
INSERT INTO `sys_role_menu` VALUES (43, 122);
INSERT INTO `sys_role_menu` VALUES (43, 123);
INSERT INTO `sys_role_menu` VALUES (43, 124);
INSERT INTO `sys_role_menu` VALUES (43, 126);
INSERT INTO `sys_role_menu` VALUES (43, 127);
INSERT INTO `sys_role_menu` VALUES (43, 128);
INSERT INTO `sys_role_menu` VALUES (43, 129);
INSERT INTO `sys_role_menu` VALUES (43, 130);
INSERT INTO `sys_role_menu` VALUES (43, 131);
INSERT INTO `sys_role_menu` VALUES (43, 132);
INSERT INTO `sys_role_menu` VALUES (43, 133);
INSERT INTO `sys_role_menu` VALUES (43, 134);
INSERT INTO `sys_role_menu` VALUES (43, 135);
INSERT INTO `sys_role_menu` VALUES (43, 136);
INSERT INTO `sys_role_menu` VALUES (43, 137);
INSERT INTO `sys_role_menu` VALUES (43, 138);
INSERT INTO `sys_role_menu` VALUES (43, 139);
INSERT INTO `sys_role_menu` VALUES (43, 140);
INSERT INTO `sys_role_menu` VALUES (43, 141);
INSERT INTO `sys_role_menu` VALUES (43, 142);
INSERT INTO `sys_role_menu` VALUES (43, 143);
INSERT INTO `sys_role_menu` VALUES (43, 144);
INSERT INTO `sys_role_menu` VALUES (43, 145);
INSERT INTO `sys_role_menu` VALUES (43, 146);
INSERT INTO `sys_role_menu` VALUES (43, 147);
INSERT INTO `sys_role_menu` VALUES (43, 148);
INSERT INTO `sys_role_menu` VALUES (43, 149);
INSERT INTO `sys_role_menu` VALUES (43, 150);
INSERT INTO `sys_role_menu` VALUES (43, 151);
INSERT INTO `sys_role_menu` VALUES (43, 152);
INSERT INTO `sys_role_menu` VALUES (43, 153);
INSERT INTO `sys_role_menu` VALUES (43, 154);
INSERT INTO `sys_role_menu` VALUES (43, 155);
INSERT INTO `sys_role_menu` VALUES (43, 156);
INSERT INTO `sys_role_menu` VALUES (43, 157);
INSERT INTO `sys_role_menu` VALUES (43, 158);
INSERT INTO `sys_role_menu` VALUES (43, 159);
INSERT INTO `sys_role_menu` VALUES (43, 166);
INSERT INTO `sys_role_menu` VALUES (43, 167);
INSERT INTO `sys_role_menu` VALUES (43, 168);
INSERT INTO `sys_role_menu` VALUES (43, 169);
INSERT INTO `sys_role_menu` VALUES (43, 170);
INSERT INTO `sys_role_menu` VALUES (43, 171);
INSERT INTO `sys_role_menu` VALUES (43, 172);
INSERT INTO `sys_role_menu` VALUES (43, 176);
INSERT INTO `sys_role_menu` VALUES (43, 180);
INSERT INTO `sys_role_menu` VALUES (43, 182);
INSERT INTO `sys_role_menu` VALUES (43, 183);
INSERT INTO `sys_role_menu` VALUES (43, 226);
INSERT INTO `sys_role_menu` VALUES (43, 235);
INSERT INTO `sys_role_menu` VALUES (43, 241);
INSERT INTO `sys_role_menu` VALUES (43, 254);
INSERT INTO `sys_role_menu` VALUES (43, 288);
INSERT INTO `sys_role_menu` VALUES (44, 27);
INSERT INTO `sys_role_menu` VALUES (44, 28);
INSERT INTO `sys_role_menu` VALUES (44, 29);
INSERT INTO `sys_role_menu` VALUES (44, 30);
INSERT INTO `sys_role_menu` VALUES (44, 35);
INSERT INTO `sys_role_menu` VALUES (44, 37);
INSERT INTO `sys_role_menu` VALUES (44, 38);
INSERT INTO `sys_role_menu` VALUES (44, 55);
INSERT INTO `sys_role_menu` VALUES (44, 56);
INSERT INTO `sys_role_menu` VALUES (44, 58);
INSERT INTO `sys_role_menu` VALUES (44, 59);
INSERT INTO `sys_role_menu` VALUES (44, 64);
INSERT INTO `sys_role_menu` VALUES (44, 69);
INSERT INTO `sys_role_menu` VALUES (44, 97);
INSERT INTO `sys_role_menu` VALUES (44, 100);
INSERT INTO `sys_role_menu` VALUES (44, 101);
INSERT INTO `sys_role_menu` VALUES (44, 106);
INSERT INTO `sys_role_menu` VALUES (44, 108);
INSERT INTO `sys_role_menu` VALUES (44, 110);
INSERT INTO `sys_role_menu` VALUES (44, 111);
INSERT INTO `sys_role_menu` VALUES (44, 113);
INSERT INTO `sys_role_menu` VALUES (44, 122);
INSERT INTO `sys_role_menu` VALUES (44, 145);
INSERT INTO `sys_role_menu` VALUES (44, 159);
INSERT INTO `sys_role_menu` VALUES (44, 176);
INSERT INTO `sys_role_menu` VALUES (44, 180);
INSERT INTO `sys_role_menu` VALUES (46, 1);
INSERT INTO `sys_role_menu` VALUES (46, 30);
INSERT INTO `sys_role_menu` VALUES (46, 41);
INSERT INTO `sys_role_menu` VALUES (46, 42);
INSERT INTO `sys_role_menu` VALUES (46, 43);
INSERT INTO `sys_role_menu` VALUES (46, 44);
INSERT INTO `sys_role_menu` VALUES (46, 45);
INSERT INTO `sys_role_menu` VALUES (46, 46);
INSERT INTO `sys_role_menu` VALUES (46, 47);
INSERT INTO `sys_role_menu` VALUES (46, 48);
INSERT INTO `sys_role_menu` VALUES (46, 49);
INSERT INTO `sys_role_menu` VALUES (46, 53);
INSERT INTO `sys_role_menu` VALUES (46, 55);
INSERT INTO `sys_role_menu` VALUES (46, 56);
INSERT INTO `sys_role_menu` VALUES (46, 58);
INSERT INTO `sys_role_menu` VALUES (46, 59);
INSERT INTO `sys_role_menu` VALUES (46, 60);
INSERT INTO `sys_role_menu` VALUES (46, 61);
INSERT INTO `sys_role_menu` VALUES (46, 62);
INSERT INTO `sys_role_menu` VALUES (46, 63);
INSERT INTO `sys_role_menu` VALUES (46, 64);
INSERT INTO `sys_role_menu` VALUES (46, 66);
INSERT INTO `sys_role_menu` VALUES (46, 67);
INSERT INTO `sys_role_menu` VALUES (46, 68);
INSERT INTO `sys_role_menu` VALUES (46, 87);
INSERT INTO `sys_role_menu` VALUES (46, 115);
INSERT INTO `sys_role_menu` VALUES (46, 116);
INSERT INTO `sys_role_menu` VALUES (46, 126);
INSERT INTO `sys_role_menu` VALUES (46, 127);
INSERT INTO `sys_role_menu` VALUES (46, 128);
INSERT INTO `sys_role_menu` VALUES (46, 129);
INSERT INTO `sys_role_menu` VALUES (46, 130);
INSERT INTO `sys_role_menu` VALUES (46, 131);
INSERT INTO `sys_role_menu` VALUES (46, 132);
INSERT INTO `sys_role_menu` VALUES (46, 133);
INSERT INTO `sys_role_menu` VALUES (46, 134);
INSERT INTO `sys_role_menu` VALUES (46, 135);
INSERT INTO `sys_role_menu` VALUES (46, 136);
INSERT INTO `sys_role_menu` VALUES (46, 137);
INSERT INTO `sys_role_menu` VALUES (46, 138);
INSERT INTO `sys_role_menu` VALUES (46, 140);
INSERT INTO `sys_role_menu` VALUES (46, 157);
INSERT INTO `sys_role_menu` VALUES (46, 158);
INSERT INTO `sys_role_menu` VALUES (46, 159);
INSERT INTO `sys_role_menu` VALUES (46, 160);
INSERT INTO `sys_role_menu` VALUES (46, 161);
INSERT INTO `sys_role_menu` VALUES (46, 168);
INSERT INTO `sys_role_menu` VALUES (46, 169);
INSERT INTO `sys_role_menu` VALUES (46, 170);
INSERT INTO `sys_role_menu` VALUES (46, 171);
INSERT INTO `sys_role_menu` VALUES (46, 172);
INSERT INTO `sys_role_menu` VALUES (46, 173);
INSERT INTO `sys_role_menu` VALUES (46, 174);
INSERT INTO `sys_role_menu` VALUES (46, 175);
INSERT INTO `sys_role_menu` VALUES (46, 176);
INSERT INTO `sys_role_menu` VALUES (46, 177);
INSERT INTO `sys_role_menu` VALUES (46, 180);
INSERT INTO `sys_role_menu` VALUES (46, 182);
INSERT INTO `sys_role_menu` VALUES (46, 183);
INSERT INTO `sys_role_menu` VALUES (46, 235);
INSERT INTO `sys_role_menu` VALUES (46, 254);
INSERT INTO `sys_role_menu` VALUES (46, 281);
INSERT INTO `sys_role_menu` VALUES (46, 284);
INSERT INTO `sys_role_menu` VALUES (46, 285);
INSERT INTO `sys_role_menu` VALUES (46, 286);
INSERT INTO `sys_role_menu` VALUES (46, 287);
INSERT INTO `sys_role_menu` VALUES (47, 1);
INSERT INTO `sys_role_menu` VALUES (47, 27);
INSERT INTO `sys_role_menu` VALUES (47, 28);
INSERT INTO `sys_role_menu` VALUES (47, 41);
INSERT INTO `sys_role_menu` VALUES (47, 42);
INSERT INTO `sys_role_menu` VALUES (47, 43);
INSERT INTO `sys_role_menu` VALUES (47, 44);
INSERT INTO `sys_role_menu` VALUES (47, 50);
INSERT INTO `sys_role_menu` VALUES (47, 51);
INSERT INTO `sys_role_menu` VALUES (47, 52);
INSERT INTO `sys_role_menu` VALUES (47, 99);
INSERT INTO `sys_role_menu` VALUES (47, 100);
INSERT INTO `sys_role_menu` VALUES (47, 104);
INSERT INTO `sys_role_menu` VALUES (47, 105);
INSERT INTO `sys_role_menu` VALUES (47, 162);
INSERT INTO `sys_role_menu` VALUES (47, 163);
INSERT INTO `sys_role_menu` VALUES (47, 164);
INSERT INTO `sys_role_menu` VALUES (47, 165);
INSERT INTO `sys_role_menu` VALUES (47, 166);
INSERT INTO `sys_role_menu` VALUES (47, 167);
INSERT INTO `sys_role_menu` VALUES (47, 176);
INSERT INTO `sys_role_menu` VALUES (47, 178);
INSERT INTO `sys_role_menu` VALUES (47, 180);
INSERT INTO `sys_role_menu` VALUES (47, 183);
INSERT INTO `sys_role_menu` VALUES (47, 216);
INSERT INTO `sys_role_menu` VALUES (47, 217);
INSERT INTO `sys_role_menu` VALUES (47, 218);
INSERT INTO `sys_role_menu` VALUES (47, 219);
INSERT INTO `sys_role_menu` VALUES (47, 220);
INSERT INTO `sys_role_menu` VALUES (47, 221);
INSERT INTO `sys_role_menu` VALUES (47, 222);
INSERT INTO `sys_role_menu` VALUES (47, 223);
INSERT INTO `sys_role_menu` VALUES (47, 224);
INSERT INTO `sys_role_menu` VALUES (47, 226);
INSERT INTO `sys_role_menu` VALUES (47, 228);
INSERT INTO `sys_role_menu` VALUES (47, 234);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username` varchar(64) COLLATE utf8mb4_bin NOT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `real_name` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '真实姓名',
  `job_number` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '工号',
  `dept_name` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '部门名',
  `remark` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '备注',
  `mail` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '邮箱',
  `sex` int(1) DEFAULT '1' COMMENT '性别 1男 0女',
  `status` char(1) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '0冻结 1可用 ',
  `last_login_time` datetime(1) DEFAULT NULL COMMENT '最后登录时间',
  `phone` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '联系方式',
  `avatar` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '头像',
  `ins_user_id` int(11) DEFAULT '1',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modified_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `del_flag` char(1) COLLATE utf8mb4_bin DEFAULT '0' COMMENT '0-正常，1-删除',
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE KEY `user_idx1_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin ROW_FORMAT=COMPACT COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, 'admin', '$2a$10$mMnQ1I5.E7fJ9uY5t5CmEObu63W0nGcXUCPOKh.EVA./z3ENM3NXG', '大哥大', '666', '技术部', '', '', 1, '1', '2018-09-30 10:26:56.0', '18112345678', NULL, 1, '2018-09-30 10:26:33', '2018-09-30 10:26:48', '0');
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`,`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户角色表';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES (1, 1);
COMMIT;


-- ----------------------------
-- Table structure for t_app_user
-- ----------------------------
DROP TABLE IF EXISTS `t_app_user`;
CREATE TABLE `t_app_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `qq_code` varchar(20) DEFAULT NULL COMMENT 'qq号',
  `mail` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) DEFAULT NULL COMMENT '注册手机号',
  `pwd` varchar(80) DEFAULT NULL COMMENT '密码',
  `name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `head_url` varchar(50) DEFAULT NULL COMMENT '头像',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `source` decimal(2,0) DEFAULT '5' COMMENT ' 客户端类型 1、PC  2、H5 3、android 4、ios 5其他 6:p2p追讨渠道',
  `balance` decimal(11,2) NOT NULL DEFAULT '0.00' COMMENT '账户余额',
  `is_bind_card` int(1) DEFAULT '0' COMMENT '0：未绑卡 1:已绑卡',
  `is_set_transpwd` int(1) DEFAULT '0' COMMENT '0-未设置 1-已设置',
  `trans_password` varchar(20) DEFAULT NULL COMMENT '交易密码',
  `recharge_switch` int(1) DEFAULT '1' COMMENT '充值开关 1：开 0:关',
  `withdraw_switch` int(1) DEFAULT '1' COMMENT '提现开关 1：开 0：关',
  `shop_switch` int(1) DEFAULT '1' COMMENT '购买开关1：开 0：关',
  `last_login_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录时间',
  `status` int(1) DEFAULT '1' COMMENT '1- 正常 2-禁用',
  `ip` varchar(20) DEFAULT NULL COMMENT '注册ip',
  `last_login_ip` varchar(20) DEFAULT NULL COMMENT '最后登录ip',
  `upd_user_id` int(11) DEFAULT NULL COMMENT '修改人id',
  `today_date` date DEFAULT NULL COMMENT '今天日期（判断登录次数用）',
  `count_error_login` int(11) DEFAULT '0' COMMENT '错误登录次数（3次后当天无法登录）',
  `is_safe` int(1) DEFAULT '0',
  `is_watchful` int(1) DEFAULT '0' COMMENT '是否默认查询喜欢平台',
  `is_completion` int(1) DEFAULT '0' COMMENT '基本信息是否补全',
  `jwt_version` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'jwt当前版本',
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '乐观锁',
  `invite_code` varchar(10) DEFAULT NULL COMMENT '邀请码',
  `invite_id` int(25) DEFAULT NULL COMMENT '邀请人ID',
  `is_first` int(1) DEFAULT '0' COMMENT '首次发布',
  `local_province` varchar(20) DEFAULT '' COMMENT '所在省份',
  `local_city` varchar(20) DEFAULT '' COMMENT '所在城市',
  `nick_name` varchar(20) DEFAULT '' COMMENT '昵称',
  `personalized_signature` varchar(255) DEFAULT '' COMMENT '个性签名',
  `link_phone` varchar(25) DEFAULT NULL COMMENT '联系方式',
  `show_qq_code` int(1) DEFAULT '0' COMMENT '是否显示QQ号 1是 0否',
  `show_link_phone` int(1) DEFAULT '0' COMMENT '是否显示联系手机号 1是 0否',
  `show_succee_record` int(3) DEFAULT '180' COMMENT '展示交易成功记录 默认180天',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_phone` (`phone`),
  UNIQUE KEY `idx_invite_code` (`invite_code`)
) ENGINE=InnoDB AUTO_INCREMENT=17504418 DEFAULT CHARSET=utf8 COMMENT='H5   用户表';

-- ----------------------------
-- Records of t_app_user
-- ----------------------------
BEGIN;
INSERT INTO `t_app_user` VALUES (17470, '4133042511', NULL, '15868719192', 'aa123456', NULL, NULL, '2018-09-26 18:37:19', '2019-06-04 10:37:19', 1, 0.00, 1, 0, '', 1, 1, 1, '2019-01-25 13:56:48', 1, NULL, '115.200.225.51', NULL, '2019-01-19', 0, 0, 0, 0, '2018-12-11 19:33:24', 8, '674887', NULL, 0, '', '', '', '', NULL, 0, 0, 180);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
