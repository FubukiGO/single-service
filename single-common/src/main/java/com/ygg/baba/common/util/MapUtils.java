package com.ygg.baba.common.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapUtils {

    public static Map<String, String> toMapFormat(Map map) {
        Map<String, String> params = new HashMap<>();
        for (Iterator iter = map.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) map.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        return params;
    }
}
