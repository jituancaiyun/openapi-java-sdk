/*
 * (C) Copyright 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     ohun@live.cn (夜色)
 */

package com.shinemo.openapi.client.common;


import org.springframework.util.NumberUtils;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.UUID;

import static com.shinemo.openapi.client.common.Const.ISO_8859_1;
import static com.shinemo.openapi.client.common.Const.UTF_8;

/**
 * Created by ohun on 2017/3/25.
 *
 * @author ohun@live.cn (夜色)
 */
public final class OpenApiUtils {

    public static String createNonce() {
        return UUID.randomUUID().toString();
    }

    public static long createTimestamp() {
        return System.currentTimeMillis() / 1000;
    }

    public static String genJsapiSignature(String ticket, String nonce, long timestamp, String url) {
        //注意这里参数名必须全部小写，且必须有序
        String str = "nonce=" + nonce + "&ticket=" + ticket + "&timestamp=" + timestamp + "&url=" + url;
        return sha1(str);
    }

    public static boolean validateJsapiSignature(String signature4check, String jsapiTicket, String nonce, long timestamp, String url) {
        if (signature4check == null
                || jsapiTicket == null
                || url == null
                || nonce == null
                || timestamp == 0) {
            throw new OpenApiException("参数错误");
        }
        String signature = genJsapiSignature(jsapiTicket, nonce, timestamp, url);
        return signature.equals(signature4check);
    }

    public static String genCallbackSignature(String token, String nonce, long timestamp, String encrypt) {
        //注意这里参数名必须全部小写，且必须有序
        String str = "encrypt=" + encrypt + "&nonce=" + nonce + "&timestamp=" + timestamp + "&token=" + token;
        return sha1(str);
    }

    public static boolean validateCallbackSignature(String signature4check, String token, String nonce, long timestamp, String encrypt) {
        if (signature4check == null
                || token == null
                || encrypt == null
                || nonce == null
                || timestamp == 0) {
            throw new OpenApiException("参数错误");
        }
        String signature = genCallbackSignature(token, nonce, timestamp, encrypt);
        return signature.equals(signature4check);
    }

    public static String encryptCallbackEvent(String key, String eventData) {
        byte[] data = AESUtils.encrypt(eventData.getBytes(UTF_8), Arrays.copyOf(key.getBytes(ISO_8859_1), 16));
        if (data != null && data.length > 0) {
            return new String(data, ISO_8859_1);
        }
        return null;
    }

    public static String decryptCallbackEvent(String key, String encryptData) {
        byte[] data = AESUtils.decrypt(encryptData.getBytes(ISO_8859_1), Arrays.copyOf(key.getBytes(ISO_8859_1), 16));
        if (data != null && data.length > 0) {
            return new String(data, UTF_8);
        }
        return null;
    }

    public static String sha1(String srcText) {
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(srcText.getBytes(UTF_8));
            return byteToHex(crypt.digest());
        } catch (Exception e) {
            throw new RuntimeException("signature error:", e);
        }
    }

    public static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }


    public static void silentClose(Closeable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (IOException e) {
            }
        }
    }

    public static void silentClose(Connection resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (SQLException e) {
            }
        }
    }

    /**
     * 生成一个秘钥并返回
     *
     * @return
     */
    public static String randomAesKey() {
        return Base64.getUrlEncoder().encodeToString(SecureRandom.getSeed(16));
    }


    public static boolean isDigit(CharSequence sequence) {
        if (sequence == null || sequence.length() == 0) {
            return false;
        }

        for (int i = 0, L = sequence.length(); i < L; i++) {
            if (!Character.isDigit(sequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String getOrgId(ApiContext apiContext) {
        if (apiContext.getOrgId() != null) {
            String orgId = apiContext.getOrgId();
            if (OpenApiUtils.isDigit(orgId)) {
                return orgId;
            }
            ByteBuffer buffer = ByteBuffer.wrap(Base64.getUrlDecoder().decode(orgId), 2, 8);
            return String.valueOf(buffer.getLong());
        }

        if (apiContext.getOrgSecret() != null) {
            ByteBuffer buffer = ByteBuffer.wrap(Base64.getUrlDecoder().decode(apiContext.getOrgSecret()), 10, 8);
            return String.valueOf(buffer.getLong());
        }
        return "0";
    }


    public static long getOrgId(String orgId) {
        if (orgId != null) {
            if (OpenApiUtils.isDigit(orgId)) {
                return Long.parseLong(orgId);
            }
            ByteBuffer buffer = ByteBuffer.wrap(Base64.getUrlDecoder().decode(orgId), 2, 8);
            return buffer.getLong();
        }
        return 0;
    }

}
