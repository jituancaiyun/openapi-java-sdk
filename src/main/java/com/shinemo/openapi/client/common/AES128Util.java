package com.shinemo.openapi.client.common;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class AES128Util {

    public static byte[] encrypt(byte[] targetContent, String key) {
        try {
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.ENCRYPT_MODE, genKey(key));// 初始化
            return cipher.doFinal(targetContent);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解密
     *
     * @param targetContent 待解密内容
     * @return
     */
    public static byte[] decrypt(byte[] targetContent, String key) {

        try {
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, genKey(key));// 初始化
            return cipher.doFinal(targetContent);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据密钥获得 SecretKeySpec
     *
     * @return
     */
    private static SecretKeySpec genKey(String strKey) {
        byte[] enCodeFormat;
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(strKey.getBytes());
            kgen.init(128, secureRandom);
            SecretKey secretKey = kgen.generateKey();
            enCodeFormat = secretKey.getEncoded();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new SecretKeySpec(enCodeFormat, "AES");
    }
}
