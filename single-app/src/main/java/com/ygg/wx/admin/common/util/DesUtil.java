package com.ygg.wx.admin.common.util;


import com.ygg.debt.common.exception.BusinessException;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.util.Base64;

/**
 * 加密工具类
 */
public class DesUtil {
    // 密钥  md5(recovery)
    private final static String defaultSecretKey = "6ccf929934691710135f3f0df7cc43c5";
    // 向量  
    private final static String defaultIv = "kfjdsfha";
    // 加解密统一使用的编码方式  
    private final static String encoding = "utf-8";

    /**
     * 3DES加密
     *
     * @param content 普通文本
     */
    public static String encode(String content) {
        return encode(defaultSecretKey, defaultIv, content);
    }

    /**
     * 3DES解密
     *
     * @param content 加密文本
     */
    public static String decode(String content) {
        return decode(defaultSecretKey, defaultIv, content);
    }

    /**
     * 3DES加密
     *
     * @param content 普通文本
     */
    public static String encode(String key, String iv, String content) {
        try {
            DESedeKeySpec spec = new DESedeKeySpec(key.getBytes());
            Key desKey = SecretKeyFactory.getInstance("desede").generateSecret(spec);

            Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
            IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, desKey, ips);

            byte[] encryptData = cipher.doFinal(content.getBytes(encoding));
            return new String(Base64.getEncoder().encode(encryptData));
        } catch (Exception e) {
            throw new BusinessException("DES加密错误");
        }

    }

    /**
     * 3DES解密
     *
     * @param content 加密文本
     */
    public static String decode(String key, String iv, String content) {
        try {
            DESedeKeySpec spec = new DESedeKeySpec(key.getBytes());
            Key desKey = SecretKeyFactory.getInstance("desede").generateSecret(spec);

            Cipher cipher = Cipher.getInstance("desede/CBC/PKCS5Padding");
            IvParameterSpec ips = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, desKey, ips);

            byte[] decryptData = cipher.doFinal(Base64.getDecoder().decode(content));
            return new String(decryptData, encoding);
        } catch (Exception e) {
            throw new BusinessException("DES解密错误");
        }
    }


}