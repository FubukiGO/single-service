package com.ygg.baba.app.common.util;

import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NotifyTranslator {

    public static final String REWARD_RATE_CHANGE_MESSAGE = "您在{}领取的任务:{}佣金比例上调为{}。请合理规划自己的理财计划，如需修改请点击修改规则";

    public static final String PUSH_NEW_MISSION_MESSAGE = "{}发布新的任务，任务量为{}，佣金结算比例为{}，任务有效时间为{}至{}。如需领取任务，请点击这里领取任务";

    @Nullable
    public static String getMessage(String temp, @Nullable Object... args) {
        String[] temps = temp.split("[{}]");
        StringBuilder sb = new StringBuilder();
        int index = 0;

        for (int i = 0; i < temps.length; i++) {
            if ("".equals(temps[i])) {
                if (i == 0 && temp.startsWith("{}")) continue;
                if (index <= args.length - 1) {
                    if (args[index] instanceof Date) {
                        args[index] = new SimpleDateFormat("yyyy年MM余dd日 HH时mm分").format((Date) args[index]);
                    }
                    if (args[index] instanceof BigDecimal) {
                        args[index] = new DecimalFormat("#.00").format(args[index]);
                    }
                    temps[i] = args[index].toString();
                    index++;
                }
            }
            sb.append(temps[i]);

        }
        return sb.toString();
    }
}
