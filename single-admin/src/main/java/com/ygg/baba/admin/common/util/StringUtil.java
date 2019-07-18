package com.ygg.baba.admin.common.util;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

    public static boolean objIsBlank(Object obj) {
        return null == obj ? true : StringUtils.isBlank(obj.toString());
    }

    public static String delSymbol(String str) {
        if (StringUtils.isBlank(str)) {
            return "";
        }
        if (str.startsWith(",")) {
            str = str.replaceFirst(",", "");
        }
        if (str.endsWith(",")) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

}
