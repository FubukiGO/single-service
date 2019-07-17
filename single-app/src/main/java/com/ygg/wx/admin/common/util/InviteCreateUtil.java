package com.ygg.wx.admin.common.util;

public class InviteCreateUtil {


    public static String CreateInviteCode() {
        String randomcode = "";
        // 用字符数组的方式随机
        String model = "0123456789";
        char[] m = model.toCharArray();
        for (int j = 0; j < 6; j++) {
            char c = m[(int) (Math.random() * 10)];
            // 保证六位随机数之间没有重复的
            if (randomcode.contains(String.valueOf(c))) {
                j--;
                continue;
            }
            randomcode = randomcode + c;
        }
        return randomcode;

    }
}