package com.ygg.baba.common.util;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class SmsSender {
    private static Logger logger = LoggerFactory.getLogger(SmsSender.class);
    // appId
    private static final String appId = "EUCP-EMY-SMS1-1P3WM";//请联系销售，或者在页面中 获取
    // 密钥
    private static final String secretKey = "B5B3EB983AE2FA9C";//请联系销售，或者在页面中 获取
    // 接口地址
    private static final String host = "http://shmtn.b2m.cn";//请联系销售获取
    // 加密算法
    private static final String algorithm = "AES/ECB/PKCS5Padding";
    // 编码
    private static final String encode = "UTF-8";
    // 是否压缩
    private static final boolean isGizp = false;

    /**
     * @param mobiles
     * @param content
     * @param extend
     * @author akhan
     * @description 短信发送
     * @date 下午1:41 2018/4/16
     */
    public static void send(List<String> mobiles, String content, String extend) {
        //业务层作校验
        MobileUtil.validateMobile(mobiles.get(0));
        logger.info("=============begin setSingleSms==================");
        String timestamp = String.valueOf(System.currentTimeMillis());
        String sign = "【黑尘科技】";
        content = sign + content;
        Map<String, Object> params = Maps.newHashMap();

        params.put("appId", appId);
        params.put("timestamp", timestamp);
        params.put("sign", DigestUtils.md5Hex(appId + secretKey + timestamp));
        params.put("mobiles", Joiner.on(",").join(mobiles));
        params.put("content", content);
        if (StringUtils.isNotBlank(extend)) params.put("extendedCode", extend);
        JSONObject result = JSONObject.parseObject(HttpUtil.post(host + "/simpleinter/sendSMS", params));
        logger.info("result code :" + result.toJSONString());
        if ("SUCCESS".equals(result.getString("code"))) {
            JSONArray arr = result.getJSONArray("data");

        }
        logger.info("=============end setSingleSms==================");
    }

    public static void send(String mobile, String content, String extend) {
        send(Lists.newArrayList(mobile), content, extend);
    }

    public static void main(String[] args) {
        send("18106733778", "您的订单（NEO56446505342603264），转让人已支付至平台，请尽快至债权平台购买并上传凭证，订单锁定至2019-02-13 13:14:53。", null);
    }
}
