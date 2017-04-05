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

/**
 * Created by ohun on 2017/3/25.
 *
 * @author ohun@live.cn (夜色)
 */
public final class OpenUtils {

    public static String sign4js(String jsapiTicket, String urlWithQuery, long timestamp) {
        return null;
    }

    public static String sign4callback(String token, String data, long timestamp) {
        return null;
    }


    public static byte[] decryptCallbackEvent(String eventData) {
        if (eventData == null || eventData.isEmpty()) {
            return new byte[0];
        }
        //base64 decode
        //AES128 decrypt

        return new byte[0];
    }


    public static void silentClose(Closeable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (IOException e) {
            }
        }
    }

}
