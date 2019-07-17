package com.ygg.debt.common.util;

import java.util.Calendar;


/**
 * 字段   最大值            所需bit数
 * ------------------------------
 * 年份    2048    2^11=2048   11    byte[0], byte[1](0,1,2)
 * 月份     12     2^4=16       4    byte[1](3,4,5,6)
 * 日期     31     2^5=32       5    byte[1](7),byte[2](0,1,2,3)
 * 小时     24     2^5=32       5    byte[2](4,5,6,7),byte[3](0)
 * 分钟     60     2^6=64       6    byte[3](1,2,3,4,5,6)
 * 秒钟     60     2^6=64       6    byte[3](7),byte[4](0,1,2,3,4)
 * 主机    100     2^7=128      7    byte[4](5,6,7),byte[5](0,1,2,3)
 * 流水号  1000    2^10=1024    10   byte[5](4,5,6,7),byte[6](0,1,2,3,4,5)
 * 手机数  1000    2^10=1024    10   byte[6](6,7),byte[7](0,1,2,3,4,5,6,7)
 * --------------------------------
 * 64 = 8 * 8
 * 此算法可支持100个主机每台每秒提交 1000 个短信包，每个包1000个手机号
 * 在公元2048年之前，msgId不会重复
 *
 * @author chensheng
 */
public class MsgIdUtil {

    private static short host = 0;

    private static int index;

    private static Object lock = new Object();

    public static void setHost(String strHost) {
        try {
            host = Short.parseShort(strHost);
        } catch (Exception e) {
            host = 0;
        }
    }

    private static long encodeMsgId(int index) {
        byte[] bytes = new byte[8];
        Calendar cal = Calendar.getInstance();
        short year = (short) cal.get(Calendar.YEAR);
        byte month = (byte) (cal.get(Calendar.MONTH) + 1);
        byte day = (byte) (cal.get(Calendar.DATE));
        byte hour = (byte) (cal.get(Calendar.HOUR_OF_DAY));
        byte min = (byte) (cal.get(Calendar.MINUTE));
        byte second = (byte) (cal.get(Calendar.SECOND));
        bytes[0] = (byte) (year >> 3);
        System.out.println(bytes[0]);
        bytes[1] = (byte) ((year << 5) | (month << 1) | (day >> 4));
        System.out.println(bytes[1]);
        bytes[2] = (byte) ((day << 4) | (hour >> 1));
        System.out.println(bytes[2]);
        bytes[3] = (byte) ((hour << 7) | (min << 1) | (second >> 5));
        System.out.println(bytes[3]);
        bytes[4] = (byte) ((second << 3) | (host >> 4));
        System.out.println(bytes[4]);
        bytes[5] = (byte) ((host << 4) | (index >> 6));
        System.out.println(bytes[5]);
        bytes[6] = (byte) (index << 2);
        System.out.println(bytes[6]);
        bytes[7] = 0;
        return byte2long(bytes);

    }

    public static String decodeMsgId(long msgId) {
        StringBuffer buffer = new StringBuffer();
        byte[] bytes = long2byte(msgId);
        int year = ((bytes[0] << 3) & 0x07ff) | ((bytes[1] >> 5) & 0x07);
        buffer.append(year);

        int month = (bytes[1] >> 1) & 0x0f;
        if (month < 10)
            buffer.append("0");
        buffer.append(month);

        int day = ((bytes[1] << 5) & 0x1f) | ((bytes[2] >> 4) & 0x0f);
        if (day < 10)
            buffer.append("0");
        buffer.append(day);

        int hour = ((bytes[2] << 1) & 0x1f) | ((bytes[3] >> 7) & 0x01);
        if (hour < 10)
            buffer.append("0");
        buffer.append(hour);

        int min = (bytes[3] >> 1) & 0x3f;
        if (min < 10)
            buffer.append("0");
        buffer.append(min);

        int second = ((bytes[3] << 5) & 0x2f) | ((bytes[4] >> 3) & 0x1f);
        if (second < 10)
            buffer.append("0");
        buffer.append(second);

        int host = ((bytes[4] << 4) & 0x7f) | (bytes[5] >> 4);
        if (host < 10)
            buffer.append("0");
        buffer.append(host);

        int index = ((bytes[5] << 6) & 0x07c0) | ((bytes[6] >> 2) & 0x7f);
        String tmp = index + "";
        while (tmp.length() < 4)
            tmp = "0" + tmp;
        buffer.append(tmp);

        int mobileIndex = ((bytes[6] << 8) & 0x0300) | bytes[7];
        tmp = mobileIndex + "";
        while (tmp.length() < 4)
            tmp = "0" + tmp;
        buffer.append(tmp);
        return buffer.toString();
    }

    private static long byte2long(byte b[]) {
        return (long) b[7] & (long) 255 | ((long) b[6] & (long) 255) << 8 | ((long) b[5] & (long) 255) << 16
                | ((long) b[4] & (long) 255) << 24 | ((long) b[3] & (long) 255) << 32
                | ((long) b[2] & (long) 255) << 40 | ((long) b[1] & (long) 255) << 48 | (long) b[0] << 56;
    }

    private static byte[] long2byte(long n) {
        byte b[] = new byte[8];
        b[0] = (byte) (int) (n >> 56);
        b[1] = (byte) (int) (n >> 48);
        b[2] = (byte) (int) (n >> 40);
        b[3] = (byte) (int) (n >> 32);
        b[4] = (byte) (int) (n >> 24);
        b[5] = (byte) (int) (n >> 16);
        b[6] = (byte) (int) (n >> 8);
        b[7] = (byte) (int) n;
        return b;
    }

    public static long generateMsgId() {
        synchronized (lock) {
            index = (++index) % 1024;
        }
        return Math.abs(encodeMsgId(index));
    }


    public static void main(String[] args) {
//        while (true)

        System.out.println(generateMsgId());
    }
}
