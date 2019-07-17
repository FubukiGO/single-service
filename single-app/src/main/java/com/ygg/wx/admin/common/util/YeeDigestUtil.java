package com.ygg.wx.admin.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


public class YeeDigestUtil {

    private static String encodingCharset = "UTF-8";

    private static String SECRET_KEY = "708L99pQ74076mN5QNrBq6TK3B5ryBKh2uQ8fQrbS9wk4Tj5dNX143A5V5xn";

    /**
     * @param aValue
     * @param aKey
     * @return
     */
    public static String hmacSign(String aValue, String aKey) {
        byte k_ipad[] = new byte[64];
        byte k_opad[] = new byte[64];
        byte keyb[];
        byte value[];
        try {
            keyb = aKey.getBytes(encodingCharset);
            value = aValue.getBytes(encodingCharset);
        } catch (UnsupportedEncodingException e) {
            keyb = aKey.getBytes();
            value = aValue.getBytes();
        }

        Arrays.fill(k_ipad, keyb.length, 64, (byte) 54);
        Arrays.fill(k_opad, keyb.length, 64, (byte) 92);
        for (int i = 0; i < keyb.length; i++) {
            k_ipad[i] = (byte) (keyb[i] ^ 0x36);
            k_opad[i] = (byte) (keyb[i] ^ 0x5c);
        }

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {

            return null;
        }
        md.update(k_ipad);
        md.update(value);
        byte dg[] = md.digest();
        md.reset();
        md.update(k_opad);
        md.update(dg, 0, 16);
        dg = md.digest();
        return toHex(dg);
    }

    public static String toHex(byte input[]) {
        if (input == null)
            return null;
        StringBuffer output = new StringBuffer(input.length * 2);
        for (int i = 0; i < input.length; i++) {
            int current = input[i] & 0xff;
            if (current < 16)
                output.append("0");
            output.append(Integer.toString(current, 16));
        }

        return output.toString();
    }

    /**
     * @param args
     * @param key
     * @return
     */
    public static String getHmac(String[] args, String key) {
        if (args == null || args.length == 0) {
            return (null);
        }
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < args.length; i++) {
            str.append(args[i]);
        }
        return (hmacSign(str.toString(), key));
    }

    /**
     * ����hmac_safe
     *
     * @param args
     * @param key
     * @return
     */
    public static String getHmac_safe(String[] args, String key) {
        if (args == null || args.length == 0) {
            return (null);
        }
        StringBuffer hmac_safe = new StringBuffer();
        for (int i = 0; i < args.length; i++) {
            if (args[i].length() != 0 && !args[i].equals("")) {
                hmac_safe.append(args[i]).append("#");
            }

        }

        hmac_safe = hmac_safe.deleteCharAt(hmac_safe.length() - 1);
        System.out.println("hmac_safe��: " + hmac_safe.toString());

        return (hmacSign(hmac_safe.toString(), key));
    }

    /**
     * @param aValue
     * @return
     */
    public static String digest(String aValue) {
        aValue = aValue.trim();
        byte value[];
        try {
            value = aValue.getBytes(encodingCharset);
        } catch (UnsupportedEncodingException e) {
            value = aValue.getBytes();
        }
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
        return toHex(md.digest(value));

    }

    public static boolean verifyCallbackHmac(String[] stringValue, String hmacFromYeepay) throws UnsupportedEncodingException {

        System.out.println("##### verifyCallbackHmac() #####");

        String keyValue = SECRET_KEY;

        StringBuffer sourceData = new StringBuffer();
        for (int i = 0; i < stringValue.length; i++) {

//			stringValue[i] = URLDecoder.decode(stringValue[i],"GBK");
//			stringValue[i] = new String(stringValue[i].getBytes("8859_1"),"GB2312");
            sourceData.append(stringValue[i]);
            System.out.println("stringValue ��������: " + stringValue[i]);

        }
        System.out.println("sourceData ��������: " + sourceData);

        String localHmac = getHmac(stringValue, keyValue);

        StringBuffer hmacSource = new StringBuffer();
        for (int i = 0; i < stringValue.length; i++) {
            hmacSource.append(stringValue[i]);
        }

        return (localHmac.equals(hmacFromYeepay) ? true : false);
    }

    public static boolean verifyCallbackHmac_safe(String[] stringValue, String hmac_safeFromYeepay) throws UnsupportedEncodingException {

        System.out.println("##### verifyCallbackHmac_safe() #####");

        String keyValue = SECRET_KEY;

        StringBuffer sourceData = new StringBuffer();
        for (int i = 0; i < stringValue.length; i++) {
            if (!"".equals(stringValue[i])) {
                sourceData.append(stringValue[i] + "#");
            }

            System.out.println("stringValue ��������: " + stringValue[i]);
        }

        sourceData = sourceData.deleteCharAt(sourceData.length() - 1);
        System.out.println("sourceData ��������: " + sourceData.toString());

        String localHmac_safe = hmacSign(sourceData.toString(), keyValue);
        System.out.println("localHmac_safe:" + localHmac_safe);
        StringBuffer hmacSource = new StringBuffer();
        for (int i = 0; i < stringValue.length; i++) {
            hmacSource.append(stringValue[i]);
        }

        return (localHmac_safe.equals(hmac_safeFromYeepay) ? true : false);
    }

}
