package com.ygg.baba.admin.common.support;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FCBook {

    private static HashMap<String, String> map;


    static {
        map = new LinkedHashMap<>();
        map.put("dkcs", "dkcs654321");
    }

    public static String getPassWd(String key) {
        return map.get(key);
    }
}
