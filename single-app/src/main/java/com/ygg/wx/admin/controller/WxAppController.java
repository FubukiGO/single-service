package com.ygg.wx.admin.controller;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.ygg.debt.common.util.R;
import com.ygg.wx.admin.config.WxSupportConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;

/**
 * @author akhan
 * @description 微信支持 控制器
 * @date 18:03 2019-01-08
 */
@Slf4j
@RestController
@RequestMapping("/wx_app_support")
@Api(description = "微信支持", tags = {"微信支持"})
public class WxAppController extends BaseController {

    @Resource
    private WxSupportConfig wxSupportConfig;

    @GetMapping(value = "/get_ticket")
    @ApiOperation(value = "获取小程序凭证")
    public R getTicket(@RequestParam("url") String url) {
        Assert.notNull(url, "url can not be null");

        String ts = String.valueOf(Instant.now().getEpochSecond());

        String noncestr = UUID.randomUUID().toString().replaceAll("-", "");

        String token = JSONObject.parseObject(HttpRequest
                .get(wxSupportConfig.getAccessTokenUrl())
                .form("grant_type", "client_credential")
                .form("appid", wxSupportConfig.getAppId())
                .form("secret", wxSupportConfig.getAppSecret())
                .execute()
                .body()).getString("access_token");

        String ticket = JSONObject.parseObject(HttpRequest
                .get(wxSupportConfig.getTicketUrl())
                .form("type", "jsapi")
                .form("access_token", token)
                .execute()
                .body()).getString("ticket");

        String params = new StringBuilder()
                .append("jsapi_ticket=")
                .append(ticket)
                .append("&noncestr=")
                .append(noncestr)
                .append("&timestamp=")
                .append(ts)
                .append("&url=")
                .append(url).toString();

        String signature = DigestUtils.sha1Hex(params);

        Map<String, Object> ret = Maps.newHashMap();
        ret.put("ticket", ticket);
        ret.put("noncestr", noncestr);
        ret.put("timestamp", ts);
        ret.put("signature", signature);

        return new R<>(ret);
    }
}
