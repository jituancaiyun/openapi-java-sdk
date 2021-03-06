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

package com.shinemo.openapi.client.aes;

import com.shinemo.openapi.client.aes.domain.AesKeyEntity;
import com.shinemo.openapi.client.common.OpenApiResult;

import java.util.List;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
public interface AesKeyService {

    /**
     * sdk 内部使用, 不需要权限校验
     *
     * @param orgId 组织ID
     * @return 结果
     */
    AesKey getAesKeyBySDK(String orgId);

    /**
     * 给客户端调用, 需要检查参数和权限
     *
     * @param orgId     客户传入
     * @param uid       客户传入
     * @param token     客户传入
     * @param timestamp 客户传入
     * @param keyIds    客户传入
     * @return 结果
     */
    OpenApiResult<List<AesKeyEntity>> getAesKeyByClient(String orgId, String uid, String token, long timestamp, String keyIds);

}
