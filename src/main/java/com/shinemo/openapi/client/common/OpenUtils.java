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


import java.io.Closeable;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Formatter;
import java.util.UUID;

/**
 * Created by ohun on 2017/3/25.
 *
 * @author ohun@live.cn (夜色)
 */
public final class OpenUtils {

    public static String createNonceStr() {
        return UUID.randomUUID().toString();
    }

    public static String createTimestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    public static boolean validate(String sign4check, String jsapiTicket, String url, String nonceStr, String timestamp) {
        if (sign4check == null
                || jsapiTicket == null
                || url == null
                || nonceStr == null
                || timestamp == null) {
            throw new OpenApiException("参数错误");
        }
        String signature = sign(jsapiTicket, url, nonceStr, timestamp);
        return signature.equals(sign4check);
    }

    public static String sign(String jsapiTicket, String url, String nonceStr, String timestamp) {
        //注意这里参数名必须全部小写，且必须有序
        String str = jsapiTicket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url=" + url;
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(str.getBytes("UTF-8"));
            return byteToHex(crypt.digest());
        } catch (Exception e) {
            throw new RuntimeException("sign error:", e);
        }
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }


    public static String decryptCallbackEvent(String key, String eventData) {
        if (eventData == null || eventData.isEmpty()) {
            return "";
        }
        byte[] data = AES128Util.decrypt(Base64.getUrlDecoder().decode(eventData), key);
        if (data != null && data.length > 0) {
            return new String(data, Const.UTF_8);
        }
        return "";
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

}
