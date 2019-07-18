/*
 *    Copyright (c) 2018-2025, baba All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: baba (wzysz888@gmail.com)
 */

package com.ygg.baba.common.constants;

/**
 * @author baba
 * @date 2017/10/29
 */
public interface CommonConstant {
    /**
     * token请求头名称
     */
    //String REQ_HEADER = "Authorization";
    String REQ_HEADER = "token";

    /**
     * token分割符
     */
    String TOKEN_SPLIT = "Bearer ";

    /**
     * jwt签名
     */
    String SIGN_KEY = "RABBIT@TANK@BESTMATCH!";
    /**
     * 删除
     */
    String STATUS_DEL = "1";
    /**
     * 正常
     */
    String STATUS_NORMAL = "0";

    /**
     * 锁定
     */
    String STATUS_LOCK = "9";

    /**
     * 菜单
     */
    Integer MENU = 0;

    /**
     * 按钮
     */
    String BUTTON = "1";

    /**
     * 删除标记
     */
    String DEL_FLAG = "del_flag";

    /**
     * 编码
     */
    String UTF8 = "UTF-8";

    /**
     * JSON 资源
     */
    String CONTENT_TYPE = "application/json; charset=utf-8";

    /**
     * 阿里大鱼
     */
    String ALIYUN_SMS = "aliyun_sms";

    /**
     * 路由信息Redis保存的key
     */
    String ROUTE_KEY = "_ROUTE_KEY";

    /**
     * 订单前缀
     */
    String ORDER_PREFIX = "NEO";

    /**
     * 借条前缀
     */
    String LOANS_PREFIX = "LNS";

    /**
     * 小贷卫士前缀
     */
    String SUPPORT_PREFIX = "SUP";

    /**
     * 企业借条前缀
     */
    String FIRM_PREFIX = "wwa";

    /**
     * 全局订单操作延时(毫秒)
     */
    long OPERATION_TIME_OUT = 2 * 3600 * 1000;

    long OPERATION_TIME_OUT_24_HOURS = 24 * 3600 * 1000;

    long TOKEN_EXPIRE_TIME = 7 * 3600 * 24 * 1000;

    /**
     * 全局延长时间限制
     */
    long ORDER_EXTEND_TIME_LIMIT = 24 * 3600 * 1000;

    String ORDER_BY_DESC = "DESC";

    String ORDER_BY_ASC = "ASC";

    String INVOKE_BUY_COUNT = "invoke_buy_count:";

    String LABEL_GENRE_SAFE = "正常";

    String LEBEL_GEERE_NOT_SAFE = "问题";

    Integer LIAN_LIAN_TYPE = 3;


    //---------充值订单状态-------------------

    Integer PAY_ING = 1;

    Integer PAY_SUCCESS = 2;

    Integer PAY_FAIL = 3;

    //=============== 阿里支付状态 ==================

    String ALI_PAY_SUCCESS = "TRADE_SUCCESS";


    //--------------------- 借条相关（附件类型） ----------------
    //借条附件
    int LOANS_ACCESSORYS = 1;
    //担保附件
    int GUARANTEE_ACCESSORYS = 2;
    //上诉附件
    int LAWSUIT_ACCESSORYS = 3;
    //判决附件
    int JUDGMENT_ACCESSORYS = 4;
    //转让
    Integer LOANS_TYPE_TRANSFER = 1;
    //委托
    Integer LOANS_TYPE_ENTRUST = 2;

    //--------------------- 借条状态 ---------------
    // 状态 -2 待审核 -1:待支付 0上架中(转让中) 1锁定中 2已承接  3已申诉 4:已下架 5:已冻结 6:交易完成
    Integer LOANS_WAIT_VERIFY = -2;

    Integer LOANS_WAIT_PAY = -1;

    Integer LOANS_RELEASE = 0;

    Integer LOANS_LOCK_ING = 1;
    /**
     * 待承接人确认
     */
    Integer LOANS_WAIT_HOLD_CONFIRM = 21;
    /**
     * 待发起人确认
     */
    Integer LOANS_WAIT_INITIATOR_CONFIRM = 22;
    //申诉
    Integer LOANS_APPEAL = 3;
    //下架
    Integer LOANS_SOLD_OUT = 4;

    Integer LOANS_FROZEN_ASSETS = 5;

    Integer LOANS_SUCCESS = 6;

    //----------------------- 借条申诉状态
    Integer LOANS_COMPLAIN_STATUS_WAIT = 0;

    Integer LOANS_COMPLAIN_STATUS_PASS = 1;

    Integer LOANS_COMPLAIN_STATUS_NO_PASS = 2;


    String LOANS_CASH_DEPOSIT_TXT = "%s 元 - %s 元,保证金 %s 元";

    String LOANS_CASH_DEPOSIT_TXT_DEF = "默认保证金 %s 元";


}
