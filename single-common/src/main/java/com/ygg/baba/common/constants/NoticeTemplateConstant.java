package com.ygg.baba.common.constants;

/**
 * @author akhan
 * @description
 * @date 12:35 PM 2018/10/16
 */
public interface NoticeTemplateConstant {

    //------------------------系统------------------------------

    //发送验证码
    int SEND_CHECK_CODE = 1;

    //提现成功
    int WITHDRAW_SUCCESS = 2;

    //提现失败
    int WITHDRAW_FAILED = 3;

    //充值
    int PAY_SUCCESS = 4;

    //------------------------p2p------------------------------

    //转让人-预付款
    int PREPAY = 5;

    //转让人出售前审核
    int INSPECT_BEFORE_PUB = 6;

    //转让人-发布成功
    int PUB_SUCCESS = 7;

    //转让人-撤销成功
    int CANCEL_SUCCESS = 8;

    //转让人-带承接人支付保证金
    int WAITING_HOLDER_PAY = 9;

    //承接人-带承接人支付保证金
    int WAITING_HOLDER_PAY_HOLDER = 10;

    //转让人-待支付折扣金
    int WAITING_USER_PAY = 11;

    //承接人-待支付折扣金
    int WAITING_USER_PAY_HOLDER = 12;

    //转让人-可上传凭证
    int UPLOAD_READY = 13;

    //承接人-可上传凭证
    int UPLOAD_READY_HOLDER = 14;

    //转让人-等待对方确认
    int WAITING_CONFIRM = 17;

    //承接人-等待对方确认
    int WAITING_CONFIRM_HOLDER = 18;

    //转让人-延长付款成功
    int EXTEND_SUCCESS = 19;

    //承接人-转让人已延长付款
    int EXTEND_SUCCESS_HOLDER = 20;

    //转让人-已发起申诉
    int APPEAL_USER_REQUEST = 21;

    //承接人-转让人已发起申诉
    int APPEAL_USER_REQUEST_HOLDER = 22;

    //转让人申诉成功
    int APPEAL_USER_SUCCESS = 23;

    //承接人-申诉成功
    int APPEAL_USER_SUCCESS_HOLDER = 24;

    //转让人申诉失败
    int APPEAL_USER_FAILED = 97;

    //承接人-申诉失败
    int APPEAL_USER_FAILED_HOLDER = 98;

    //转让人-承接人已发起申诉
    int APPEAL_HOLDER_REQUEST = 25;

    //承接人-承接人已发起申诉
    int APPEAL_HOLDER_REQUEST_HOLDER = 26;

    //转让人申诉成功
    int APPEAL_HOLDER_SUCCESS = 27;

    //承接人-申诉成功
    int APPEAL_HOLDER_SUCCESS_HOLDER = 28;

    //转让人申诉失败
    int APPEAL_HOLDER_FAILED = 99;

    //承接人-申诉失败
    int APPEAL_HOLDER_FAILED_HOLDER = 100;

    //转让人-上传超时
    int UPLOAD_TIME_OUT = 29;

    //承接人-上传超时
    int UPLOAD_TIME_OUT_HOLDER = 30;

    //转让人-上传超时冻结审核通过
    int UPLOAD_TIME_OUT_INSPECT_SUCESS = 31;

    //承接人-上传超时冻结审核通过
    int UPLOAD_TIME_OUT_INSPECT_SUCESS_HOLDER = 32;

    //转让人-上传超时冻结审核失败
    int UPLOAD_TIME_OUT_INSPECT_FAILED = 33;

    //承接人-上传超时冻结审核失败
    int UPLOAD_TIME_OUT_INSPECT_FAILED_HOLDER = 34;

    //转让人-超时确认
    int CONFIRM_TIME_OUT = 35;

    //承接人-转让人超时确认
    int CONFIRM_TIME_OUT_HOLDER = 36;

    //转让人-确认超时冻结审核通过
    int CONFIRM_TIME_OUT_INSPECT_SUCESS = 37;

    //承接人-确认超时冻结审核通过
    int CONFIRM_TIME_OUT_INSPECT_SUCESS_HOLDER = 38;

    //转让人-确认超时冻结审核失败
    int CONFIRM_TIME_OUT_INSPECT_FAILED = 39;

    //承接人-确认超时冻结审核失败
    int CONFIRM_TIME_OUT_INSPECT_FAILED_HOLDER = 40;

    //转让人-成功转账至承接人
    int ORDER_SUCCESS = 41;

    //承接人-已收到折扣金额
    int ORDER_SUCCESS_HOLDER = 42;

    //转让人-下架 未付款
    int SOLD_OUT_REPAY_TIME_OUT = 43;

    //转让人-下架 已付款
    int SOLD_OUT = 44;

    //转让人-下架 发布前审核
    int SOLD_OUT_BEFORE_PUB_INSPECT = 45;

    //转让人-下架 支付失败
    int SOLD_OUT_PAY_FAILED = 46;

    //承接人-承接超时
    int HOLD_TIME_OUT = 47;

    //转让人-更改凭证
    int UPLOAD_RE = 48;

    //承接人-更改凭证
    int UPLOAD_RE_HOLDER = 49;

    //双方-人工延长支付
    int EXTEND_SUCCESS_FORCE_BOTH = 50;

    //双方-人工下架
    int SOLD_OUT_FORCE_BOTH = 51;

    //双方-人工移交审核
    int INSPECT_FORCE_BOTH = 52;

    //双方-人工上架
    int PUB_FORCE_BOTH = 53;

    //被扣除方-违约金扣除
    int PUNISH_MASTER = 54;

    //被补偿方-违约金补偿
    int PUNISH_SLAVE = 55;

    //------------------------借条------------------------------

    //转让人-借条发布
    int LOANS_PUB_SUCCESS = 56;

    //保证金支付成功
    int LOANS_PAY_SUCCESS = 57;

    //转让人-债转撤销
    int LOANS_CANCEL_SUCCESS = 59;

    //转让人支付保证金超时 下架
    int LOANS_SOLD_OUT_BY_PAY_OUT_TIME = 60;

    //订单转让期限到期下架（上架中）并退回保证金
    int LOANS_SOLD_OUT_BY_OVER_TIME = 61;
    //订单审核未通过
    int LOANS_VERIFY_FAIL = 62;

    //承接人付款超时
    int LOANS_HOLD_PAY_TIME_OUT = 65;

    //承接失败（承接人付款超时）
    int LOANS_HOLD_HOLD_FAIL = 66;

    //待承接人确认（发给转让人）
    int LOANS_WAIT_HOLD_CONFIRM = 67;

    //待承接人确认（发送给承接人）
    int LOANS_HOLD_CONFIRM = 68;

    int LOANS_COMPLAIN_TO_USER = 69;

    int LOANS_COMPLAIN_TO_HOLD = 70;

    int LOANS_COMPLAIN_FINISH_TO_USER = 71;

    int LOANS_COMPLAIN_FINISH_TO_HOLD = 72;

    //转让人-已下架（未承接）
    int LOANS_SOLD_OUT = 68;

    //转让人-待承接人支付
    int LOANS_HOLD_SUCCESS = 63;

    //承接人-待支付
    int LOANS_HOLD_SUCCESS_HOLDER = 64;

    //转让人-重新上架（超时付款）
    int LOANS_RECALL_SUCCESS_AFTER_PAY_TIME_OUT = 71;

    //承接人-已失效
    int LOANS_RECALL_SUCCESS_HOLDER_AFTER_PAY_TIME_OUT = 72;
    //延长（发给转让人）
    int LOANS_EXTEND_TO_USER = 73;
    //延长（发给承接人）
    int LOANS_EXTEND_TO_HOLD = 74;

    //确认超时（双方）
    int LOANS_FROZEN = 76;

    //人工冻结审核 通过
    int LOANS_FROZEN_VERIFIY_PASS = 77;

    //人工冻结审核 失败
    int LOANS_FROZEN_VERIFIY_FAIL = 78;

    //订单完成 发送至转让人
    int LOANS_SUCCESS_TO_USER = 78;

    //承接人-人工延长支付
    int LOANS_SUCCESS_TO_HOLD = 79;

    //待委托人确认
    int LOANS_WAIT_USER_COMFIR = 83;

    //待委托人确认 发送给承接人
    int LOANS_WAIT_USER_COMFIR_TO_HOLD = 84;
    //委托人发起申诉 结束
    int LOANS_USER_COMPLAINID = 90;
    //客服延长
    int LOANS_SERVER_EXTEND = 91;
    //客服下架
    int LOANS_SERVER_SOLD_OUT = 92;
    //客服移交申诉
    int LOANS_SERVER_MOVE_COMPLAINID = 93;
    //客服再次发起
    int LOANS_SERVER_RECALL = 94;
    //违约赔偿
    int LOANS_DAMAGE = 95;
    //违约补偿
    int LOANS_PAYMENT = 96;
    int LOANS_ENTRUST_SUCCESS = 174;


}
