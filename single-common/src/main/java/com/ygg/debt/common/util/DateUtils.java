package com.ygg.debt.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期相关的共通方法的提供类。
 *
 * @author 2015/02/14 yingcankeji
 */
public final class DateUtils {

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    public static final String YYYYMMDD = "yyyyMMdd";

    /**
     * 构造函数。
     */
    private DateUtils() {
    }

    /**
     * 取得AP系统时间。
     *
     * @return AP系统时间
     */
    public static Date getSystemDate() {
        return new Date();
    }

    /**
     * 根据日期获得星期
     *
     * @param date
     * @return
     */
    public static String getWeekOfDate(Date date) {
        // String[] weekDaysName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        String[] weekDaysCode = {"0", "1", "2", "3", "4", "5", "6"};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDaysCode[intWeek];
    }

    /**
     * 根据日期获得所在周的指定星期
     *
     * @param date
     * @return
     */
    public static Date getWeekDate(Date date, String weekDaysCode) {
        // String[] weekDaysName = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        switch (weekDaysCode) {
            case "0":
                // 星期日
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
                break;
            case "1":
                // 星期一
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
                break;
            case "2":
                // 星期二
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
                break;
            case "3":
                // 星期三
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
                break;
            case "4":
                // 星期四
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
                break;
            case "5":
                // 星期五
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
                break;
            case "6":
                // 星期六
                calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
                break;
        }

        return calendar.getTime();
    }

    /**
     * 取得AP系统时间，不包括时分秒。
     *
     * @return AP系统时间
     */
    public static Date getDate() {
        Calendar calendar = getSystemCalendar();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);
        return DateUtils.convertString2Date(DateUtils.convertDate2String(calendar.getTime(), "yyyyMMdd"), "yyyyMMdd");
    }

    /**
     * 取得AP系统时间。
     *
     * @return AP系统时间
     */
    public static Date getDateTime() {
        return getSystemDate();
    }

    /**
     * 取得AP系统时间。
     *
     * @return AP系统时间
     */
    public static Calendar getSystemCalendar() {
        return Calendar.getInstance();
    }

    /**
     * 系统日期的年月日时分秒毫秒的文字列，取得方法。
     *
     * @return 年月日时分秒毫秒的文字列
     */
    public static String getTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return sdf.format(getSystemDate());
    }

    /**
     * 参数的字符串使用指定的格式转换日期型的方法。
     *
     * @param str     转换的对象
     * @param pattern 日期时间格式的模式
     * @return 参数null的时候返回null，字符串时按照指定的日期时间格式实行Date型转换
     */
    public static Date convertString2Date(String str, String pattern) {
        if (str == null || "".equals(str)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(sdf.parse(str.trim()));
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
        return calendar.getTime();
    }

    /**
     * 参数的日期型使用指定的格式转换字符串的方法。
     *
     * @param date    转换的对象
     * @param pattern 日期时间格式的模式
     * @return 参数null的时候返回null，字符串时按照指定的日期时间格式实行String型转换
     */
    public static String convertDate2String(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 取得参数日期的年
     *
     * @param date 日期
     * @return 指定的年
     */
    public static int getYear(Date date) {
        if (date == null) {
            return 0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 取得参数日期的月
     *
     * @param date 日期
     * @return 指定的月
     */
    public static int getMonth(Date date) {
        if (date == null) {
            return 0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 取得参数日期的日
     *
     * @param date 日期
     * @return 指定的日
     */
    public static int getDay(Date date) {
        if (date == null) {
            return 0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);

    }

    /**
     * 取得参数日期的时
     *
     * @param date 日期
     * @return 指定的时
     */
    public static int getHour(Date date) {
        if (date == null) {
            return 0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 取得参数日期的分
     *
     * @param date 日期
     * @return 指定的分
     */
    public static int getMinute(Date date) {
        if (date == null) {
            return 0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 取得参数日期的秒
     *
     * @param date 日期
     * @return 指定的秒
     */
    public static int getSecond(Date date) {
        if (date == null) {
            return 0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 参数的日期被指定的年加算的方法。
     *
     * @param date 日期
     * @param year 加算的年
     * @return 加算后的日期
     */
    public static Date addYear(Date date, int year) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, year);
        return calendar.getTime();
    }

    /**
     * 参数的日期被指定的月加算的方法。
     *
     * @param date  日期
     * @param month 加算的月
     * @return 加算后的日期
     */
    public static Date addMonth(Date date, int month) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    /**
     * 参数的日期被指定的日加算的方法。
     *
     * @param date 日期
     * @param day  加算的日
     * @return 加算后的日期
     */
    public static Date addDay(Date date, int day) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }

    /**
     * 参数的日期被指定的时加算的方法。
     *
     * @param date 日期
     * @param hour 加算的时
     * @return 加算后的日期
     */
    public static Date addHour(Date date, int hour) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hour);
        return calendar.getTime();
    }

    /**
     * 参数的日期被指定的分加算的方法。
     *
     * @param date 日期
     * @param min  加算的分
     * @return 加算后的日期
     */
    public static Date addMinute(Date date, int min) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, min);
        return calendar.getTime();
    }

    /**
     * 参数的日期被指定的秒加算的方法。
     *
     * @param date   日期
     * @param second 加算的秒
     * @return 加算后的日期
     */
    public static Date addSecond(Date date, int second) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, second);
        return calendar.getTime();
    }

    /**
     * 参数的日期取得当月的首日
     *
     * @param date 日付
     * @return 当月的首日
     */
    public static Date getFirstDay(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 参数的日期取得当月的末日
     *
     * @param date 日付
     * @return 当月的末日
     */
    public static Date getLastDay(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, 1);
        calendar.roll(Calendar.DATE, -1);

        return calendar.getTime();
    }

    /**
     * 字符串是否是正确日期格式的判定
     *
     * @param date    日期字符串
     * @param pattern 日期时间格式的模式
     * @return 字符是正确的日期格式  true
     */
    public static boolean isValidDate(String date, String pattern) {
        if (date == null) {
            return false;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            sdf.setLenient(false);
            sdf.parse(String.valueOf(date));
        } catch (ParseException ex) {
            return false;
        }
        return true;
    }

    /**
     * 获取前后时间的日差的方法。
     *
     * @param stateDate 开始时间
     * @param endDate   结束时间
     * @return 前后时间的日差
     */
    public static int dateDiff(Date stateDate, Date endDate) {
        return (int) ((endDate.getTime() - stateDate.getTime()) / (1000 * 60 * 60 * 24));
    }

    /**
     * @Autor:ccd
     * @description
     * @Date;2018/7/23 20:45
     * @param: * @param null   相差日
     */
    public static int dayDiff(Date stateDate, Date endDate) {
        stateDate = DateUtils.convertString2Date(DateUtils.convertDate2String(stateDate, DateUtils.YYYY_MM_DD), DateUtils.YYYY_MM_DD);
        endDate = DateUtils.convertString2Date(DateUtils.convertDate2String(endDate, DateUtils.YYYY_MM_DD), DateUtils.YYYY_MM_DD);
        return (int) ((endDate.getTime() - stateDate.getTime()) / (1000 * 60 * 60 * 24));
    }

    /**
     * 判断是否是闰年的方法。
     *
     * @param year 年份
     * @return 闰年返回true, 否则false
     */
    public static boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * @Autor:
     * @description
     * @Date;2018/7/18 16:22
     * @param: * @param 获取两个日期 中的 月份
     */
    public static List<String> getMonthBetweenMonth(Date beginDate, Date endDate, String forMate) {
        if (beginDate.getTime() == endDate.getTime()) {
            return null;
        }
        List<String> lDate = new ArrayList();
        lDate.add(convertDate2String(beginDate, forMate));//把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        //使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(beginDate);
        boolean bContinue = true;
        while (bContinue) {
            //根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.MONTH, 1);
            // 测试此日期是否在指定日期之后
            if (endDate.after(cal.getTime())) {
                lDate.add(convertDate2String(cal.getTime(), forMate));
            } else {
                break;
            }
        }
        lDate.add(convertDate2String(endDate, forMate));//把结束时间加入集合
        return lDate;
    }

    /**
     * @Autor:
     * @description
     * @Date;2018/7/18 16:22
     * @param: * @param 获取两个日期 中的 月份
     */
    public static List<String> getMonthBetweenDay(Date beginDate, Date endDate, String forMate) {
        if (beginDate.getTime() == endDate.getTime()) {
            return null;
        }
        List<String> lDate = new ArrayList();
        lDate.add(convertDate2String(beginDate, forMate));//把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        //使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(beginDate);
        boolean bContinue = true;
        while (bContinue) {
            //根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.DAY_OF_YEAR, 1);
            // 测试此日期是否在指定日期之后
            if (endDate.after(cal.getTime())) {
                lDate.add(convertDate2String(cal.getTime(), forMate));
            } else {
                break;
            }
        }
        return lDate;
    }


}
