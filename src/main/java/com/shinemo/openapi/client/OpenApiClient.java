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

package com.shinemo.openapi.client;

import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.AccessTokenDTO;
import com.shinemo.openapi.client.dto.UserInfoDTO;
import com.shinemo.openapi.client.jssdk.JsapiSignature;

/**
 * Created by ohun on 2017/3/24.
 *
 * @author ohun@live.cn (夜色)
 */
public interface OpenApiClient extends OpenApiServiceFactory {

    /**
     * 获取accessToken
     *
     * @return AccessTokenDTO
     */
    OpenApiResult<AccessTokenDTO> getAccessToken();

    /**
     * 获取jsapi 要使用的签名
     *
     * @param url 要签名的url
     * @return JsapiSignature
     */
    JsapiSignature getJsapiSignature(String url);

    /**
     * 创建OpenApiClient的配置项
     *
     * @return OpenApiConfiguration
     */
    OpenApiConfiguration config();
}
