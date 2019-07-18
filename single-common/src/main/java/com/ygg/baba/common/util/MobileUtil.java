package com.ygg.baba.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileUtil {
    /**
     * 判断传入的参数号码为哪家运营商
     *
     * @param mobile
     * @return 运营商名称
     */
    static Pattern pattern = Pattern.compile("[0-9]*");

    public static int validateMobile(String mobile) {
        int tag = 0; //未知运营商，虚拟运营商
        if (mobile != null)
            mobile = mobile.trim();

        if (mobile == null || mobile.length() != 11) {
            return -1;        //mobile参数为空或者手机号码长度不为11，错误！
        }
        Matcher isNum = pattern.matcher(mobile);
        if (!isNum.matches())
            return -1;
        /***
         * 移动：134, 135 , 136, 137, 138, 139, 147, 150, 151, 152, 157, 158, 159,
         * 178, 182, 183, 184, 187, 188
         * 联通：130,131,132,155,156,185,186,145,176
         * 电信：133,153,177,180,181,189
         * 虚拟：“1700”号段为中国电信转售、“1705”为中国移动转售、“1709”为中国联通转售。
         */
        if (mobile.substring(0, 3).equals("170")) {
            if (mobile.substring(0, 4).equals("1705"))
                tag = 1;
            else if (mobile.substring(0, 4).equals("1709"))
                tag = 2;
            else if (mobile.substring(0, 4).equals("1700"))
                tag = 3;
            else if (mobile.substring(0, 4).equals("1707"))
                tag = 2;
            else if (mobile.substring(0, 4).equals("1708"))
                tag = 2;
        }
        if (mobile.substring(0, 3).equals("171")) {
            if (mobile.substring(0, 4).equals("1718"))
                tag = 2;
            else if (mobile.substring(0, 4).equals("1719"))
                tag = 2;
        } else if (mobile.substring(0, 3).equals("134")
                || mobile.substring(0, 3).equals("135")
                || mobile.substring(0, 3).equals("136")
                || mobile.substring(0, 3).equals("137")
                || mobile.substring(0, 3).equals("138")
                || mobile.substring(0, 3).equals("139")
                || mobile.substring(0, 3).equals("147")
                || mobile.substring(0, 3).equals("150")
                || mobile.substring(0, 3).equals("151")
                || mobile.substring(0, 3).equals("152")
                || mobile.substring(0, 3).equals("157")
                || mobile.substring(0, 3).equals("158")
                || mobile.substring(0, 3).equals("159")
                || mobile.substring(0, 3).equals("178")
                || mobile.substring(0, 3).equals("182")
                || mobile.substring(0, 3).equals("183")
                || mobile.substring(0, 3).equals("184")
                || mobile.substring(0, 3).equals("187")
                || mobile.substring(0, 3).equals("188")) {
            tag = 1;    //中国移动
        } else if (mobile.substring(0, 3).equals("130")
                || mobile.substring(0, 3).equals("131")
                || mobile.substring(0, 3).equals("132")
                || mobile.substring(0, 3).equals("155")
                || mobile.substring(0, 3).equals("156")
                || mobile.substring(0, 3).equals("185")
                || mobile.substring(0, 3).equals("186")
                || mobile.substring(0, 3).equals("145")
                || mobile.substring(0, 3).equals("176")) {
            tag = 2;    //中国联通
        } else if (mobile.substring(0, 3).equals("133")
                || mobile.substring(0, 3).equals("153")
                || mobile.substring(0, 3).equals("173")
                || mobile.substring(0, 3).equals("177")
                || mobile.substring(0, 3).equals("180")
                || mobile.substring(0, 3).equals("181")
                || mobile.substring(0, 3).equals("189")
                || mobile.substring(0, 3).equals("149")) {
            tag = 3;    //中国电信
        }
        if (tag == 0) {
            System.out.println("---------------该号码无匹配号段：------------------------------" + mobile + "-----------------------------------------------------------");
        }
        return tag;
    }
}
