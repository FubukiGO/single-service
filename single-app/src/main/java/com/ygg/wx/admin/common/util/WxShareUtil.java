package com.ygg.wx.admin.common.util;

import com.alibaba.fastjson.JSONObject;
import com.xiaoleilu.hutool.crypto.SecureUtil;
import com.xiaoleilu.hutool.http.HttpUtil;
import com.ygg.debt.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;


/**
 * Created by hhg on 2018/11/23.
 */
@Slf4j
public class WxShareUtil {
    public static String WX_APPID = "wxc5e40428291c04c7";
    public static String WX_APP_SECRET = "efc66c28719c8004102fbce6b00af966";

    public static String getAccessToken(String appId, String appSecret) {

        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId + "&secret=" + appSecret;
        String accessToken = null;
        String content = HttpUtil.get(url);
        JSONObject object = JSONObject.parseObject(content);
        //{"access_token":"15_Ub4FmX70U54bmSmZ2xrSSNH1W2uamT0Dtj-g5g7UX7Nwkx601X5Zn4YalNiKtlefYlrF0yWAf1QNC-5dNjjQUJKNT-i1hUnmCWvYOFxs3P_6YrlRgQAIc5bDPiTq2lE-tpqmciW_p4XUQWk2OIVbACASMZ","expires_in":7200}
        if (object.get("access_token") == null) {
            throw new BusinessException("获取token失败.");
        }
        accessToken = object.get("access_token").toString();
        return accessToken;
    }

    public static String getAccessTicket(String accessToken) {
        String ticket = null;
        String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + accessToken + "&type=jsapi";//这个url链接和参数不能变
        String content = HttpUtil.get(url);
        JSONObject object = JSONObject.parseObject(content);
        if (object.get("ticket") == null) {
            throw new BusinessException("获取ticket失败.");
        }
        ticket = object.get("ticket").toString();
        return ticket;
    }

    public static String SHA1(String decript) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

//    public static void main (String[] agr){
//        //1、获取AccessToken
//        String accessToken = getAccessToken(WX_APPID,WX_APP_SECRET);
//
//        //2、获取Ticket
//        String jsapiTicket = getAccessTicket(accessToken);
//
//        //3、时间戳和随机字符串
//        String noncestr = UUID.randomUUID().toString().replace("-", "").substring(0, 16);//随机字符串
//        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);//时间戳
//
//        System.out.println("accessToken:"+accessToken+"jsapi_ticket:"+jsapiTicket+"\n时间戳："+timestamp+"\n随机字符串："+noncestr);
//
//        //4、获取url
//        String url="http://www.luiyang.com/add.html";
//    /*根据JSSDK上面的规则进行计算，这里比较简单，我就手动写啦
//    String[] ArrTmp = {"jsapi_ticket","timestamp","nonce","url"};
//    Arrays.sort(ArrTmp);
//    StringBuffer sf = new StringBuffer();
//    for(int i=0;i<ArrTmp.length;i++){
//        sf.append(ArrTmp[i]);
//    }
//    */
//
////        //5、将参数排序并拼接字符串
////        String str = "jsapi_ticket="+jsapiTicket+"&noncestr="+noncestr+"&timestamp="+timestamp+"&url="+url;
//
//        Map<String,Object> map=new TreeMap<>();
//        map.put("jsapi_ticket",jsapiTicket);
//        map.put("noncestr",noncestr);
//        map.put("timestamp",timestamp);
//        map.put("url",url);
//
//        String str=null;
//        StringBuffer sf=new StringBuffer();
//        map.forEach((k,v)->{
//            sf.append(k).append("=").append(v).append("&");
//        });
//        str=sf.toString();
//        str=str.substring(0,str.length()-1);
//
//        //6、将字符串进行sha1加密
//        String signature =SHA1(str);
//        System.out.println("参数："+str+"\n签名："+signature);
//    }

    public static Map<String, Object> signature(String url) {
        //1、获取AccessToken
        String accessToken = getAccessToken(WX_APPID, WX_APP_SECRET);

        //2、获取Ticket
        String jsapiTicket = getAccessTicket(accessToken);

        //3、时间戳和随机字符串
        String noncestr = UUID.randomUUID().toString().replace("-", "").substring(0, 16);//随机字符串
        String timestamp = String.valueOf(System.currentTimeMillis() / 1000);//时间戳
        log.info("accessToken:" + accessToken + "jsapi_ticket:" + jsapiTicket + "时间戳：" + timestamp + "随机字符串：" + noncestr + "url:" + url);

        //4、获取url
    /*根据JSSDK上面的规则进行计算，这里比较简单，我就手动写啦
    String[] ArrTmp = {"jsapi_ticket","timestamp","nonce","url"};
    Arrays.sort(ArrTmp);
    StringBuffer sf = new StringBuffer();
    for(int i=0;i<ArrTmp.length;i++){
        sf.append(ArrTmp[i]);
    }
    */

//        //5、将参数排序并拼接字符串
//        String str = "jsapi_ticket="+jsapiTicket+"&noncestr="+noncestr+"&timestamp="+timestamp+"&url="+url;

        Map<String, Object> map = new TreeMap<>();
        map.put("jsapi_ticket", jsapiTicket);
        map.put("noncestr", noncestr);
        map.put("timestamp", timestamp);
        map.put("url", url);

        String str = null;
        StringBuffer sf = new StringBuffer();
        map.forEach((k, v) -> {
            sf.append(k).append("=").append(v).append("&");
        });
        str = sf.toString();
        str = str.substring(0, str.length() - 1);

        //6、将字符串进行sha1加密
        String signature = SecureUtil.sha1(str);

        log.info("参数：" + str + "签名：" + signature);
        Map<String, Object> result = new HashMap<>();
        result.put("noncestr", noncestr);
        result.put("timestamp", timestamp);
        result.put("signature", signature);
        result.put("appId", WX_APPID);
        return result;
    }

}
