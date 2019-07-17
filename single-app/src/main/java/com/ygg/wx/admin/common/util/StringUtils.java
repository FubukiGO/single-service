package com.ygg.wx.admin.common.util;

import org.apache.commons.lang.CharRange;
import org.apache.commons.lang.CharSet;
import org.w3c.dom.Document;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils extends org.apache.commons.lang3.StringUtils {

    /**
     * 许可的文件名
     */
    private static CharSet allowedFileName = CharSet.getInstance("!#$%&'()+,.;=@[]_`{}~ 0-9a-zA-Z-^");

    /**
     * 许可的mail地址
     */
    private static CharSet allowedMailAddress = CharSet.getInstance(".@_0-9a-zA-Z-");

    /**
     * 许可的密码
     */
    private static CharSet allowedPassword = CharSet.getInstance("`~!@#$%^&*()-_+=|\\{}\\[\\]'\":;,.<>/?0-9a-zA-Z-");

    /**
     * ASCII 文字（英数字）
     */
    private static CharSet alphaNumChar = CharSet.getInstance("0-9A-Za-z");


    /**
     * ASCII 文字（英）
     */
    private static CharSet englishChar = CharSet.getInstance("A-Za-z");


    /**
     * ASCII 文字（数字）
     */
    private static CharRange digit = new CharRange('\u0030', '\u0039');
    /**
     * 汉字
     */
    private static CharRange simplified = new CharRange('\u4e00', '\u9fa5');

    private StringUtils() {
    }

    /**
     * 字符串是数字的判定方法。
     *
     * @param str 字符串
     * @return 数字 0-9 true
     */
    public static boolean isDigit(String str) {
        boolean isdigit = false;
        if (StringUtils.isEmpty(str)) {
            return isdigit;
        }
        isdigit = true;
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (!digit.contains(cs[i])) {
                isdigit = false;
            }
        }
        return isdigit;
    }

    /**
     * 字符串是数值(含小数)的判定方法。
     *
     * @param str 字符串
     * @return 数值(含小数) true
     */
    public static boolean isNumeric(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        Pattern p = Pattern.compile("^\\d+(\\.\\d+)?$");
        Matcher m = p.matcher(str);
        return m.find();
    }

    /**
     * 字符串是正整数的判定方法。
     *
     * @param str 字符串
     * @return 数值(含小数) true
     */
    public static boolean isInteger(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        Pattern p = Pattern.compile("^[0-9]*[1-9][0-9]*$");
        Matcher m = p.matcher(str);
        return m.find();
    }

    /**
     * 字符串null或空文字判定方法。
     *
     * @param str 字符串
     * @return true: 字符串null或空文字, false: 字符串不是null也不是空文字
     */
    public static boolean isNull(String str) {
        return str == null || str.length() == 0;
    }

    /**
     * 字符串null或空文字或者全是空白判定方法。
     *
     * @param str 字符串
     * @return true: 字符串null或空文字, false: 字符串不是null也不是空文字
     */
    public static boolean isEmpty(String str) {
        return isNull(str) || trim(str).length() == 0;
    }

    /**
     * 字符串null或空文字或者全是空白判定方法。
     *
     * @param obj 字符串
     * @return true: 字符串null或空文字, false: 字符串不是null也不是空文字
     */
    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    /**
     * 字符串是中文(不包括中文符号)的判定方法。
     *
     * @param str 字符串
     * @return 中文(不包括中文符号) true
     */
    public static boolean isSimplified(String str) {
        boolean isSimplified = false;
        if (StringUtils.isEmpty(str)) {
            return isSimplified;
        }
        isSimplified = true;
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (!simplified.contains(cs[i])) {
                isSimplified = false;
            }
        }
        return isSimplified;
    }

    /**
     * 文件名是否许可的检查。
     *
     * @param fileName 文件名
     * @return 许可  true
     */
    public static boolean isAllowedFileName(String fileName) {
        if (StringUtils.isEmpty(fileName)) {
            return false;
        }
        boolean allowed = true;
        char[] cs = fileName.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (!allowedFileName.contains(cs[i])) {
                allowed = false;
                break;
            }
        }
        if (allowed && isVistaData(fileName)) {
            allowed = false;
        }
        return allowed;
    }

    /**
     * mail地址是否许可的检查。
     *
     * @param mailAddress mail地址
     * @return 许可  true
     */
    public static boolean isAllowedMailAddress(String mailAddress) {
        if (StringUtils.isEmpty(mailAddress)) {
            return false;
        }
        boolean allowed = true;
        char[] cs = mailAddress.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (!allowedMailAddress.contains(cs[i])) {
                allowed = false;
                break;
            }
        }
        return allowed;
    }

    /**
     * 字符串是英数字的判定方法。
     *
     * @param str 字符串
     * @return 英数字 true
     */
    public static boolean isAsciiAlphaNumCharOnly(String str) {
        boolean asciiOnly = true;
        if (StringUtils.isEmpty(str)) {
            return asciiOnly;
        }
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (!alphaNumChar.contains(cs[i])) {
                asciiOnly = false;
            }
        }
        return asciiOnly;
    }


    /**
     * 字符串是英的判定方法。
     *
     * @param str 字符串
     * @return 英 true
     */
    public static boolean isAsciiEnglishCharOnly(String str) {
        boolean asciiOnly = true;
        if (StringUtils.isEmpty(str)) {
            return asciiOnly;
        }
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (simplified.contains(cs[i]) || englishChar.contains(cs[i])) {
            } else {
                return false;
            }
        }
        return asciiOnly;


    }


    /**
     * 从Windows Vista被POST数据中含有的文字列是否存在的检查方法。
     *
     * @param str 文字列
     * @return 存在 true,不存在 false
     */
    public static boolean isVistaData(String str) {
        Pattern p = Pattern.compile(".*&#\\d+?;.*");
        Matcher m = p.matcher(str);
        return m.find();
    }

    /**
     * 字符串前后空格（全角，半角）的trim
     *
     * @param orgstr 文字列
     * @return trim后的文字列
     */
    public static String trim(String orgstr) {
        while (orgstr.startsWith(" ") || orgstr.startsWith("　")) {
            orgstr = orgstr.substring(1);
        }
        while (orgstr.endsWith(" ") || orgstr.endsWith("　")) {
            orgstr = orgstr.substring(0, orgstr.length() - 1);
        }
        return orgstr;
    }

    /**
     * 取得UUID。
     *
     * @return UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");

    }

    /**
     * 取得UUID。
     *
     * @return UUID
     */
    public static String getLUUID() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        sb.append(System.currentTimeMillis())
                .append(random.nextInt(10))
                .append(random.nextInt(10))
                .append(random.nextInt(10))
                .append(random.nextInt(10))
                .append(random.nextInt(10))
                .append(random.nextInt(10));
        return sb.toString();
    }

    /**
     * 密码是否许可的检查。
     *
     * @param password 密码
     * @return 许可  true
     */
    public static boolean isAllowedPassword(String password) {
        if (StringUtils.isEmpty(password)) {
            return false;
        }
        boolean allowed = true;
        char[] cs = password.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (!allowedPassword.contains(cs[i])) {
                allowed = false;
                break;
            }
        }
        return allowed;
    }

    public static boolean isLoginId(String str) {
        String regex = "^[a-zA-z][a-zA-Z0-9_]{3,15}$";
        return match(regex, str);
    }

    public static boolean isMobileNum(String str) {
        String regex = "^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|17[0-9]{9}$|18[0-9]{9}$";
        return match(regex, str);
    }

    public static boolean isPasswordStrength(String str) {
        String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)(?![`~!@#$%^&*()_+=\\\\|{}\\[\\]'\":;,.<>/?-]+$)[`~!@#$%^&*()_+=\\\\|{}\\[\\]'\":;,.<>/?0-9a-zA-Z-]{6,20}$";
        return match(regex, str);
    }

    public static boolean isTelNum(String str) {
        String regex = "\\d{3,5}-\\d{7,8}(-\\d{1,})?$";
        return match(regex, str);
    }

    public static boolean isUrl(String str) {
        String regex = "^(\\w+:\\/\\/)?\\w+(\\.\\w+)+.*$";
        return match(regex, str);
    }

    public static boolean isMoney(String str) {
        String regex = "^[0-9]+(\\.[0-9]{1,2})?$";
        return match(regex, str);
    }

    public static boolean isAnnualRate(String str) {
//		String regex = "^[1-9][0-9]?(\\.\\d)?$";
//		String regex = "^[1-9][0-9]?([.]{1}[0-9]{1,2}){0,1}$";
//		String regex = "^[1-9]?[0-9]{1}([.]{1}[0-9]{1,2}){0,1}$";
        String regex = "^([1-9]\\d{0,1})$|^(0|[1-9]\\d{0,1})\\.(\\d{1,2})$|^0$|^100$";
        return match(regex, str);
    }

    public static boolean isPermillage(String str) {
//		String regex = "^[1-9][0-9]?(\\.\\d)?$";
//		String regex = "^[1-9][0-9]?([.]{1}[0-9]{1,2}){0,1}$";
        String regex = "^([1-9]\\d{0,2})$|^(0|[1-9]\\d{0,2})\\.(\\d{1,2})$|^0$|^1000$";
        return match(regex, str);
    }

    public static boolean isSettingNum(String str) {
        String regex = "^([1-9]\\d*)$|^(0|[1-9]\\d*)\\.(\\d{1,2})$|^0$";
        return match(regex, str);
    }

    public static boolean isEmail(String str) {
        String regex = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        return match(regex, str);
    }

    /**
     * 检查充值金额是否正确的方法。<br />
     * 充值的金额，100的倍数，不大于10,000,000。
     *
     * @param str 要验证的字符串
     * @return 正确返回true，否则返回false
     */
    public static boolean isRechargeAmount(String str) {
        String regex = "^(\\d{1,5}|100000)0{2}$";
        return match(regex, str);
    }

    /**
     * 功能：判断字符串是否为日期格式
     *
     * @param strDate
     * @return
     */
    public static boolean isDate(String strDate) {
        Pattern pattern = Pattern
                .compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
        Matcher m = pattern.matcher(strDate);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param regex 正则表达式字符串
     * @param str   要匹配的字符串
     * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
     */
    public static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    /**
     * 生成随机登录密码（默认8位长度）
     *
     * @return 登录密码的字符串
     */
    public static String genUserPassword() {
        return genRandomNum(8);
    }

    /**
     * 生成随机支付密码（默认8位长度）
     *
     * @return 支付密码的字符串
     */
    public static String genPaymentPassword() {
        return genRandomNum(8);
    }

    /**
     * 生成随机密码
     *
     * @param pwdLen 生成的密码的总长度
     * @return 密码的字符串
     */
    public static String genRandomNum(int pwdLen) {
        //35是因为数组是从0开始的，26个字母+10个 数字
        final int maxNum = 36;
        int i;  //生成的随机数
        int count = 0; //生成的密码的长度
        char[] str = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
                'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        StringBuffer pwd = new StringBuffer("");
        Random r = new Random();
        while (count < pwdLen) {
            //生成随机数，取绝对值，防止 生成负数，
            i = Math.abs(r.nextInt(maxNum));  //生成的数最大为36-1
            if (i >= 0 && i < str.length) {
                if (i % 2 == 0) {
                    pwd.append(Character.toUpperCase(str[i]));
                } else {
                    pwd.append(str[i]);
                }
                count++;
            }
        }

        return pwd.toString();
    }

    /**
     * 功能：身份证的有效验证
     *
     * @param IDStr 身份证号
     * @return 有效：返回"" 无效：返回String信息
     * @throws ParseException
     */
    public static boolean isIdCard(String IDStr) {
        String[] ValCodeArr = {"1", "0", "x", "9", "8", "7", "6", "5", "4", "3", "2"};
        String[] Wi = {"7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5", "8", "4", "2"};
        String Ai = "";
        try {
            // ================ 号码的长度 15位或18位 ================
            if (IDStr.length() != 15 && IDStr.length() != 18) {
                return false;
            }
            // =======================(end)========================

            // ================ 数字 除最后以为都为数字 ================
            if (IDStr.length() == 18) {
                Ai = IDStr.substring(0, 17);
            } else if (IDStr.length() == 15) {
                Ai = IDStr.substring(0, 6) + "19" + IDStr.substring(6, 15);
            }
            // 身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字。
            if (isAsciiAlphaNumCharOnly(Ai) == false) {
                return false;
            }
            // =======================(end)========================

            // ================ 出生年月是否有效 ================
            String strYear = Ai.substring(6, 10);// 年份
            String strMonth = Ai.substring(10, 12);// 月份
            String strDay = Ai.substring(12, 14);// 月份
            if (isDate(strYear + "-" + strMonth + "-" + strDay) == false) {
                // 身份证生日无效
                return false;
            }
            GregorianCalendar gc = new GregorianCalendar();
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");

            if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
                    || (gc.getTime().getTime() - s.parse(strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
                // 身份证生日不在有效范围。
                return false;
            }

            if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
                // 身份证月份无效
                return false;
            }
            if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
                // 身份证日期无效2aa3ddg
                return false;
            }
            // =====================(end)=====================

            // ================ 地区码时候有效 ================
            Hashtable<String, String> h = getAreaCode();
            if (h.get(Ai.substring(0, 2)) == null) {
                // 身份证地区编码错误。
                return false;
            }
            // ==============================================

            // ================ 判断最后一位的值 ================
            int TotalmulAiWi = 0;
            for (int i = 0; i < 17; i++) {
                TotalmulAiWi = TotalmulAiWi + Integer.parseInt(String.valueOf(Ai.charAt(i))) * Integer.parseInt(Wi[i]);
            }
            int modValue = TotalmulAiWi % 11;
            String strVerifyCode = ValCodeArr[modValue];
            Ai = Ai + strVerifyCode;

            if (IDStr.length() == 18) {
                if (Ai.equals(IDStr.toLowerCase()) == false) {
                    // 身份证无效，不是合法的身份证号码
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            return false;
        } catch (ParseException e) {
            return false;
        }
        // =====================(end)=====================
        return true;
    }

    /**
     * 功能：设置地区编码
     *
     * @return Hashtable 对象
     */
    private static Hashtable<String, String> getAreaCode() {
        Hashtable<String, String> hashtable = new Hashtable<String, String>();
        hashtable.put("11", "北京");
        hashtable.put("12", "天津");
        hashtable.put("13", "河北");
        hashtable.put("14", "山西");
        hashtable.put("15", "内蒙古");
        hashtable.put("21", "辽宁");
        hashtable.put("22", "吉林");
        hashtable.put("23", "黑龙江");
        hashtable.put("31", "上海");
        hashtable.put("32", "江苏");
        hashtable.put("33", "浙江");
        hashtable.put("34", "安徽");
        hashtable.put("35", "福建");
        hashtable.put("36", "江西");
        hashtable.put("37", "山东");
        hashtable.put("41", "河南");
        hashtable.put("42", "湖北");
        hashtable.put("43", "湖南");
        hashtable.put("44", "广东");
        hashtable.put("45", "广西");
        hashtable.put("46", "海南");
        hashtable.put("50", "重庆");
        hashtable.put("51", "四川");
        hashtable.put("52", "贵州");
        hashtable.put("53", "云南");
        hashtable.put("54", "西藏");
        hashtable.put("61", "陕西");
        hashtable.put("62", "甘肃");
        hashtable.put("63", "青海");
        hashtable.put("64", "宁夏");
        hashtable.put("65", "新疆");
        hashtable.put("71", "台湾");
        hashtable.put("81", "香港");
        hashtable.put("82", "澳门");
        hashtable.put("91", "国外");
        return hashtable;
    }

    /**
     * 将Document内容 写入XML字符串并返回
     *
     * @param doc
     * @param encoding
     * @return
     */
    public static String callWriteXmlString(Document doc, String encoding) {

        try {
            Source source = new DOMSource(doc);
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            OutputStreamWriter write = new OutputStreamWriter(outStream);
            Result result = new StreamResult(write);

            Transformer xformer = TransformerFactory.newInstance()
                    .newTransformer();
            xformer.setOutputProperty(OutputKeys.ENCODING, encoding);

            xformer.transform(source, result);
            return outStream.toString();

        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
            return null;
        } catch (TransformerException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生产请求流水号的方法。
     *
     * @return 请求流水号
     */
    public static String createRequestNo() {
        String nano = String.valueOf(System.nanoTime());
        return DateUtils.getTimeStamp() + nano.substring(nano.length() - 7);
    }

    /**
     * 字符串截取固定Byte。
     *
     * @return 截取后字符串
     */
    public static String getSubString(String str, int length) {
        int count = 0;
        int offset = 0;
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] > 256) {
                offset = 2;
                count += 2;
            } else {
                offset = 1;
                count++;
            }
            if (count == length) {
                int countRemain = 0;
                for (int j = i + 1; j < c.length; j++) {
                    if (c[i] > 256) {
                        countRemain += 2;
                    } else {
                        countRemain++;
                    }
                }
                if (countRemain <= 3) {
                    return str;
                } else {
                    return str.substring(0, i + 1) + "...";
                }
            }
            if ((count == length + 1 && offset == 2)) {
                int countRemain = 0;
                for (int j = i + 1; j < c.length; j++) {
                    if (c[i] > 256) {
                        countRemain += 2;
                    } else {
                        countRemain++;
                    }
                }
                if (countRemain <= 3) {
                    return str;
                } else {
                    return str.substring(0, i) + "...";
                }
            }
        }
        return str;
    }

    /**
     * 字符串替换。
     *
     * @return 替换后字符串
     */
    public static String replaceStr(String strInput, String strBefore, String strAfter) {
        if (strInput == null || "".equals(strInput)) {
            return "";
        } else {
            return strInput.replace(strBefore, strAfter);
        }
    }

    /**
     * 手机号中间4位用*显示。
     *
     * @return 替换后手机号
     */
    public static String encryptMobile(String mobile) {
        if (mobile == null || "".equals(mobile)) {
            return "";
        } else {
            String ret = mobile.substring(0, 3);
            ret = ret + "****";
            ret = ret + mobile.substring(7, 11);
            return ret;
        }
    }

    public static String encryptEmail(String email) {
        if (email == null || "".equals(email)) {
            return "";
        } else {
            String ret = email.substring(0, 1);
            ret = ret + "****";
            ret = ret + email.substring(email.length() - 1);
            return ret;
        }
    }


    public static String digitToChinese(int str) {
        switch (str) {
            case 1:
                return "一";
            case 2:
                return "二";
            case 3:
                return "三";
            case 4:
                return "四";
            case 5:
                return "五";
            case 6:
                return "六";
            case 7:
                return "七";
            case 8:
                return "八";
            case 9:
                return "九";
            case 10:
                return "十";
        }
        return "";
    }

    public static String getPeriodDisplayValue(String periodType) {
        String str = "";
        if (StringUtils.isEmpty(periodType)) {
            return str;
        }
        switch (periodType) {
            case "1":
                str = "个月";
                break;
            case "2":
                str = "个季度";
                break;
            case "3":
                str = "天";
                break;
            default:
                str = "个月";
                break;
        }
        return str;
    }

    public static String strToConceal(String userId) {
        String subUserId = "";
        if ("".equals(userId)) {
            return subUserId;
        }
        char[] charArray = userId.toCharArray();
        int len = charArray.length;
        if (len < 4) {
            subUserId = String.valueOf(charArray[0]) + "***";
        } else if (len < 5) {
            subUserId = String.valueOf(charArray[0]) + String.valueOf(charArray[1]) + "***" + String.valueOf(charArray[len - 2])
                    + String.valueOf(charArray[len - 1]);
        } else {
            subUserId = String.valueOf(charArray[0]) + String.valueOf(charArray[1]) + String.valueOf(charArray[2]) + "***" + String.valueOf(charArray[len - 2])
                    + String.valueOf(charArray[len - 1]);
        }
        return subUserId;
    }

    public static BigDecimal digitalDisplay(BigDecimal digital) {
        BigDecimal digitalDisp = new BigDecimal("0");
        if (digital.compareTo(new BigDecimal("0")) == 0) {
            return digital;
        }

        // 大于亿的场合,以亿为单位;大于万的以万为单位;否则以元为单位
        if (digital.compareTo(new BigDecimal("100000000")) >= 0) {
            digitalDisp = MathUtils.divide(digital, new BigDecimal("100000000")).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        } else if (digital.compareTo(new BigDecimal("10000")) >= 0) {
            digitalDisp = MathUtils.divide(digital, new BigDecimal("10000")).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        } else {
            digitalDisp = digital;
        }

        return digitalDisp;
    }

    public static String digitalUnitDisplay(BigDecimal digital) {
        String digitalStyleDisp = "元";
        if (digital.compareTo(new BigDecimal("0")) == 0) {
            return digitalStyleDisp;
        }

        // 大于亿的场合,以亿为单位;大于万的以万为单位;否则以元为单位
        if (digital.compareTo(new BigDecimal("100000000")) >= 0) {
            digitalStyleDisp = "亿";
        } else if (digital.compareTo(new BigDecimal("10000")) >= 0) {
            digitalStyleDisp = "万";
        } else {
            digitalStyleDisp = "元";
        }

        return digitalStyleDisp;
    }

    public static boolean isInArray(String[] arr, String val) {
        return Arrays.asList(arr).contains(val);
    }


    public static String getLpadString(String lpadStr, String initialString, int stringLength) {
        String rtnString = initialString;
        if (rtnString.length() > stringLength) {

            return rtnString;
        }

        if (rtnString.length() + lpadStr.length() > stringLength) {

            return rtnString;
        }

        while (rtnString.length() < stringLength) {
            rtnString = lpadStr + rtnString;
        }

        return rtnString;
    }

    public static String toHexString(byte[] res) {
        StringBuffer sb = new StringBuffer(res.length << 1);
        for (int i = 0; i < res.length; i++) {
            String digit = Integer.toHexString(0xFF & res[i]);
            if (digit.length() == 1) {
                digit = '0' + digit;
            }
            sb.append(digit);
        }
        return sb.toString();
    }

    /**
     * url编码
     *
     * @param str
     * @param charsetName
     * @return
     */
    public static String urlencoder(String str, String charsetName) {
        if (str == null || str == "")
            return "";
        try {
            return URLEncoder.encode(str, charsetName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 得到md5值
     *
     * @param str
     * @return
     */
    public static String getMD5(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        StringBuffer hexString = new StringBuffer();

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] hash = md.digest();

            for (int i = 0; i < hash.length; i++) {
                if ((0xff & hash[i]) < 0x10) {
                    hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
            }
        } catch (NoSuchAlgorithmException e) {

        }
        return hexString.toString();
    }

    public static int toInt(String str, int defaultVal) {
        int ret = defaultVal;
        try {
            ret = Integer.parseInt(str);
        } catch (NumberFormatException e) {
        }
        return ret;
    }

    /**
     * 隐藏手机号中的四位
     *
     * @param mobile
     * @return
     */
    public static String getHiddenMobile(String mobile) {
        if (isEmpty(mobile) || !isMobileNum(mobile))
            return "";

        return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    public static String replaceNull(String str) {
        return null == str ? "" : str.trim();
    }

    public static Double replaceNull(Double dou) {
        return (null == dou) ? (0.0) : dou;
    }

    public static Short replaceNull(Short dou) {
        return (null == dou) ? (Short.MIN_VALUE) : dou;
    }

    public static Byte replaceNull(Byte dou) {
        return (null == dou) ? (Byte.MIN_VALUE) : dou;
    }

    public static String replaceNull(String str, String rp) {
        return null == str ? rp : str.trim();
    }

    public static Double replaceNull(Double dou, Double rp) {
        return (null == dou) ? (rp) : dou;
    }

    public static Short replaceNull(Short dou, Short rp) {
        return (null == dou) ? (rp) : dou;
    }

    public static Byte replaceNull(Byte dou, Byte rp) {
        return (null == dou) ? (rp) : dou;
    }

    public static Integer replaceNull(Integer dou, Integer rp) {
        return (null == dou) ? (rp) : dou;
    }

    public static Object replaceNull(Object dou, String rp) {
        return (null == dou) ? (rp) : dou;
    }

    public static Object replaceNull(Object dou, Object rp) {
        return (null == dou) ? (rp) : dou;
    }

    public static boolean matchesUserName(String userName) {
        String regex = "[\\u4e00-\\u9fa5]{2,8}";
        return userName.matches(regex);
    }

    public static boolean matchesIdcard(String idcard) {
        String regex = "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}[0-9Xx]$)";
        return idcard.matches(regex);
    }

    public static boolean matchesPhone(String phone) {
        String regex = "^\\d{11}$";
        return phone.matches(regex);
    }

    public static String getBankNum(String num) {
        if (StringUtils.isEmpty(num)) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(num.substring(0, 5))
                .append("*******")
                .append(num.substring(num.length() - 4));
        return stringBuffer.toString();
    }

    public static String getPhoneNum(String phoneNum) {
        if (StringUtils.isEmpty(phoneNum)) {
            return "";
        }

        return phoneNum.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }

    public static String getIdCard(String idCard) {
        if (StringUtils.isEmpty(idCard)) {
            return "";
        }
        return idCard.replaceAll("(\\d{4})\\d{10}(\\w{4})", "$1*****$2");
    }

    public static String getName(String name) {
        if (StringUtils.isEmpty(name)) {
            return "";
        }
        return name.replaceAll("([\\d\\D]{1})(.*)", "$1**");
    }

    public static String getEmail(String mail) {
        if (StringUtils.isEmpty(mail)) {
            return "";
        }
        return mail.replaceAll("(\\w?)(\\w+)(\\w)(@\\w+\\.[a-z]+(\\.[a-z]+)?)", "$1****$3$4");
    }

    public static String getImgUrl(String url) {
        if (url == null) {
            return null;
        }
        if (url.startsWith("http")) {
            return url;
        }
        return "https://ygg168.oss-cn-shanghai.aliyuncs.com/debt/" + url;
    }

    public static String addHttp(String url) {
        if (url == null) {
            return null;
        }
        if (url.startsWith("http")) {
            return url;
        }
        return "http://" + url;
    }

    public static String delHTMLTag(String htmlStr) {
        if (StringUtils.isBlank(htmlStr)) {
            return "";
        }
        String script = "<script[^>]*?>[\\s\\S]*?<\\/script>";
        String style = "<style[^>]*?>[\\s\\S]*?<\\/style>";
        String html = "<[^>]+>";
        String space = "(\r?\n(\\s*\r?\n)+)";
        String white = "&nbsp;";
        Pattern pScript = Pattern.compile(script, 2);
        Matcher mScript = pScript.matcher(htmlStr);
        htmlStr = mScript.replaceAll("");
        Pattern pStyle = Pattern.compile(style, 2);
        Matcher mStyle = pStyle.matcher(htmlStr);
        htmlStr = mStyle.replaceAll("");
        Pattern pHtml = Pattern.compile(html, 2);
        Matcher mHtml = pHtml.matcher(htmlStr);
        htmlStr = mHtml.replaceAll("");
        Pattern pSpace = Pattern.compile(space, 2);
        Matcher mSpace = pSpace.matcher(htmlStr);
        htmlStr = mSpace.replaceAll("");
        htmlStr = htmlStr.replaceAll(white, "");
        return delIncompleteHtml(htmlStr.trim());

    }

    public static String delIncompleteHtml(String str) {
        if (!str.contains("<")) {
            return str;
        }
        return str.substring(0, str.indexOf("<"));
    }

}
