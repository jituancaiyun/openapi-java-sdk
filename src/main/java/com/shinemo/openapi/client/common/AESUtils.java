/*
 * (C) Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *   ohun@live.cn (夜色)
 */

package com.shinemo.openapi.client.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Created by ohun on 2015/12/25.
 *
 * @author ohun@live.cn
 */
public final class AESUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(AESUtils.class);
    private static final String RNG_ALGORITHM = "SHA1PRNG";
    private static final String KEY_ALGORITHM = "AES";
    private static final String KEY_ALGORITHM_PADDING = "AES/ECB/PKCS5Padding";//ECB 不需要IV, CBC需要
    //private static final byte[] IV = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};


    /**
     * 相同的seed生成相同的128位随机数
     *
     * @param seed 种子
     * @return 128位随机数
     */
    public static byte[] getSecretKey(byte[] seed) {
        KeyGenerator keyGenerator;
        SecureRandom secureRandom;
        try {
            //1.构造密钥生成器，指定为AES算法, 不区分大小写
            keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
            //2.初始化密钥生成器, 指定SHA1PRNG算法
            secureRandom = SecureRandom.getInstance(RNG_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new OpenApiException(e);
        }
        //设置种子
        secureRandom.setSeed(seed);
        //生成一个128位的随机源,根据传入的字节数组
        keyGenerator.init(128, secureRandom);
        //3.产生原始对称密钥
        SecretKey secretKey = keyGenerator.generateKey();
        //4.获得原始对称密钥的字节数组
        return secretKey.getEncoded();
    }

    public static byte[] encrypt(byte[] data, byte[] encryptKey) {
        SecretKeySpec key = new SecretKeySpec(encryptKey, KEY_ALGORITHM);
        return encrypt(data, key);
    }

    public static byte[] decrypt(byte[] data, byte[] decryptKey) {
        SecretKeySpec key = new SecretKeySpec(decryptKey, KEY_ALGORITHM);
        return decrypt(data, key);
    }

    public static byte[] encrypt(byte[] data, SecretKeySpec keySpec) {
        try {
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM_PADDING);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            return cipher.doFinal(data);
        } catch (Exception e) {
            LOGGER.error("AES encrypt ex, key={}", Arrays.toString(keySpec.getEncoded()), e);
            throw new OpenApiException("AES encrypt ex", e);
        }
    }

    public static byte[] decrypt(byte[] data, SecretKeySpec keySpec) {
        try {
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM_PADDING);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            return cipher.doFinal(data);
        } catch (Exception e) {
            LOGGER.error("AES decrypt ex, key={}", Arrays.toString(keySpec.getEncoded()), e);
            throw new OpenApiException("AES decrypt ex", e);
        }
    }
}
