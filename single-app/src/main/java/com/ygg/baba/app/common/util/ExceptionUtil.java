package com.ygg.baba.app.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by Devin on 2017/11/22.
 */
public class ExceptionUtil {

    public static String getMessage(Exception e) {
        StringWriter out = new StringWriter();
        e.printStackTrace(new PrintWriter(out));
        return out.toString();
    }
}
