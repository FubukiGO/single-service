package com.ygg.wx.admin.common.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {

    private static final Logger logger = LoggerFactory.getLogger(EncryptUtil.class);

    /**
     * Encrypt byte array.
     */
    public static byte[] encrypt(byte[] source, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        md.reset();
        md.update(source);
        return md.digest();
    }

    /**
     * Encrypt string
     */
    public static String encrypt(String source, String algorithm) throws NoSuchAlgorithmException {
        byte[] resByteArray = encrypt(source.getBytes(), algorithm);
        return StringUtils.toHexString(resByteArray);
    }


    /**
     * 可配置字符串加密方式
     *
     * @param source 加密前字符串
     * @return 加密后字符串（根据配置文件中password.encryption.mode值确定加密方式）
     */
    public static String encryptStr(String source) {
        // 加密后字符串
        String result = "";
        if (source == null) {
            source = "";
        }

//        if (FWConfig.getInstance().chkKeyExists(FWConfigKey.PASSWORD_ENCRYPTION_MODE)) {
//        	String sPwdEncryptMod = FWConfig.getInstance().getString(FWConfigKey.PASSWORD_ENCRYPTION_MODE);
//    		if ("SHA512".equals(sPwdEncryptMod)) {
//            	result = encryptSHA512(source);
//    		} else if ("MD5".equals(sPwdEncryptMod)){
//    			result = encryptMD5(source);
//    		} else {
//    			result = encryptMD5(source);
//    		}
//        } else {
//        	result = encryptMD5(source);
//        }
        return result;
    }

    /**
     * Encrypt string using MD5 algorithm
     */
    public static String encryptMD5(String source) {
        if (source == null) {
            source = "";
        }

        String result = "";
        try {
            result = encrypt(source, "MD5");
        } catch (NoSuchAlgorithmException ex) {
            logger.debug(ExceptionUtil.getMessage(ex));
        }
        return result;
    }

    /**
     * Encrypt string using SHA algorithm
     */
    public static String encryptSHA(String source) {
        if (source == null) {
            source = "";
        }

        String result = "";
        try {
            result = encrypt(source, "SHA");
        } catch (NoSuchAlgorithmException ex) {
            logger.debug(ExceptionUtil.getMessage(ex));
        }
        return result;
    }

    public static String encryptSHA512(String source) {

        String result = "";
        if (source == null) {
            source = "";
        }

        result = DigestUtils.sha512Hex(source);
        return result;
    }


}