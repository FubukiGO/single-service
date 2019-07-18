package com.ygg.baba.common.util;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * @author akhan
 * @description 傻逼医保银行代码对照表(代扣 - > 提现)
 * @date 09:56 2019-01-02
 */
public class BankCodeDictUtil {
    private static Map<String, String> dict = Maps.newHashMap();

    static {
        //工行
        dict.put("ICBC", "ICBC");
        //中行
        dict.put("BOC", "BOC");
        //建行
        dict.put("CCB", "CCB");
        //邮政
        dict.put("PSBC", "PSBC");
        //中信
        dict.put("ECITIC", "ECITIC");
        //光大
        dict.put("CEB", "CEB");
        //华夏
        dict.put("HX", "HXB");
        //兴业
        dict.put("CIB", "CIB");
        //浦发
        dict.put("SPDB", "SPDB");
        //平安
        dict.put("SZPA", "SZCB");
        //民生
        dict.put("CMBC", "CMBC");
        //广发
        dict.put("GDB", "CGB");
        //农业
        dict.put("ABC", "ABC");
        //交行
        dict.put("BOCO", "BOCO");
        //招行
        dict.put("CMBCHINA", "CMBCHINA");
    }

    /**
     * @author akhan
     * @description 将代扣银行代码转换成提现用
     * @date 10:11 2019-01-02
     */
    public static String banckCodeTransfer(String bc) {
        return StringUtils.defaultString(dict.get(bc), bc);
    }

    public static boolean verifyBankCode(String bc) {
        return dict.get(bc) != null;
    }

    public static void main(String[] args) {

    }
}
