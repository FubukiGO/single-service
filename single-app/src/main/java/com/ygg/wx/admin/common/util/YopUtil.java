package com.ygg.wx.admin.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaoleilu.hutool.crypto.SecureUtil;
import com.xiaoleilu.hutool.http.HttpUtil;
import com.ygg.debt.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by hhg on 2018/9/25.
 */
@Component
@Slf4j
public class YopUtil {
    /**
     * 等待短验
     */
    public static String TO_VALIDATE = "TO_VALIDATE";
    /**
     * 绑定成功
     */
    public static String BIND_SUCCESS = "BIND_SUCCESS";
    /**
     * 身份证有误
     */
    public static String ID_CARD_ERROR_CODE = "TZ0600020";
    /**
     * 支付成功
     */
    public static String PAY_SUCCESS = "PAY_SUCCESS";
    /**
     * 支付处理中
     */
    public static String PROCESSING = "PROCESSING";
    /**
     * 支付失败
     */
    public static String PAY_FAIL = "PAY_FAIL";

    public static String TIME_OUT = "TIME_OUT";

    /**
     * serverRoot
     */
    @Value("${payserver.url}")
    private String baseurl;
    @Value("${payserver.toPay}")
    private String toPay;

    /**
     * 绑卡请求
     */
    public static String BIND_CARD_REQUEST = "/bindCardRequest";
    /**
     * 绑卡短验重发
     */
    public static String BIND_CARD_SMS_RESEND = "/bindCardResendsms";
    /**
     * 绑卡确认
     */
    public static String BIND_CARD_COFIRM = "/bindCardConfirm";
    /**
     * app充值（代扣）
     */
    public static String APP_PAY = "/appPay";
    /**
     * PC充值
     */
    public static String PC_PAY = "/pay";

    /**
     * PC 查询
     */
    public static String PC_QUERY = "/query";

    /**
     * PC 充值成功
     */
    public static String PC_PAY_SUCCESS = "SUCCESS";

    /*
     * APP 充值确认
     */
    public static String APP_PAY_CONFIRM = "/appPayConfirm";

    /**
     * APP 充值短验重发
     */
    public static String APP_PAY_SMS_RESEND = "/appPayResendCode";

    public static String APP_PAY_QUERY = "/appPayQuery";

    /**
     * 连连认证支付
     */
    public static String L_L_PAY = "/lianlian_pay";

    /**
     * 连连支付查询
     */
    public static String L_L_PAY_QUERY = "/lianlian_pay_query";

    /**
     * 连连网银支付
     *
     * @param method
     * @param body
     * @return
     */
    public static String L_L_PC_PAY = "/lianlian_pc_pay";

    public static String ALI_PAY_REFUND = "/ali_pay_refund";

    public static String ALI_WX_PAY = "/paySendAW";

    public static String ALI_PAY_QUERY = "/ali_pay_query";


    public Map<String, Object> yopRequest(String method, String body) {
        log.info("========== 请求路径：{},参数：{}=================", baseurl + method, body);
        try {
            return JSON.parseObject(HttpUtil.post(baseurl + method, body, 5000));
        } catch (Exception e) {
            throw new BusinessException("请求超时，请稍后再试");
        }
    }

    public JSONObject newYopRequest(String method, JSONObject jsonObject) {
        log.info("========== 请求路径：{},参数：{}=================", baseurl + method, jsonObject.toJSONString());
        JSONObject requestBody = new JSONObject();
        String timestamp = String.valueOf(System.currentTimeMillis());
        String aesKey = DigestUtils.md5Hex("dkcs654321" + timestamp.substring(2, 7)).toUpperCase().substring(0, 16);
        requestBody.put("content", SecureUtil.aes(aesKey.getBytes()).encryptHex(jsonObject.toJSONString()));
        requestBody.put("fcode", "dkcs");
        try {
            return JSON.parseObject(HttpUtil.post(baseurl + method, requestBody.toJSONString(), 5000));
        } catch (Exception e) {
            throw new BusinessException("请求超时，请稍后再试");
        }
    }

    public String toPay(String orderId, String amount, String bank, String callback) {
        return toPay.replaceAll("#orderId", orderId).replaceAll("#amount", amount).replaceAll("#bank", bank).replaceAll("#callback", callback);
    }

}
