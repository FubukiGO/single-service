package com.ygg.baba.admin.common.constants;

/**
 * @author akhan
 * @description
 * @date 上午10:42 2018/8/31
 */
public interface YeeConstant {
    String TRANSFER_STATUS_SUCCESS = "S";

    String TRANSFER_STATUS_PROCESSING = "I";

    String TRANSFER_STATUS_FALSE = "F";

    String BANK_STATUS_RECEIVED = "0025";

    String BANK_STATUS_SUCCESS = "0026";

    String BANK_STATUS_REFUSED = "0027";

    String YEE_URL = "https://www.jcs188.com/_pay/api/yop";
    //String YEE_URL = "http://193.112.137.159:8060/cost/yop";

    String YEE_TRANSFERSEND_URI = "/transferSend";

    String LLP_TRANSFERSEND_URI = "/transferSendLL";

    String YEE_TRANSFERQUERY_URI = "/transferQuery";

    String LLP_TRANSFERQUERY_URI = "/transferQueryLL";
}
