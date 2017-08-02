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

import java.util.HashMap;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
public class ApiContext extends HashMap<String, String> {

    public ApiContext() {
    }

    public ApiContext(String orgSecret) {
        this.setOrgSecret(orgSecret);
    }

    public ApiContext(String orgSecret, String uid) {
        this.setOrgSecret(orgSecret);
        this.setUid(uid);
    }

    public ApiContext(String orgSecret, String uid, String name) {
        this.setOrgSecret(orgSecret);
        this.setUid(uid);
        this.setName(name);
    }

    public ApiContext setAccessToken(String accessToken) {
        this.put("accessToken", accessToken);
        return this;
    }

    public ApiContext setOrgSecret(String orgSecret) {
        this.put("orgSecret", orgSecret);
        return this;
    }

    public ApiContext setUid(String uid) {
        this.put("uid", uid);
        return this;
    }

    public ApiContext setName(String name) {
        this.put("name", name);
        return this;
    }

    public ApiContext addHeader(String name, String value) {
        this.put(name, value);
        return this;
    }

    public ApiContext setOrgId(String orgId) {
        this.put("orgId", orgId);
        return this;
    }

    public String getOrgId() {
        return get("orgId");
    }

    public String getOrgSecret() {
        return get("orgSecret");
    }

    public static ApiContext ctx() {
        return new ApiContext();
    }

    public static ApiContext ctx(String orgSecret) {
        return new ApiContext(orgSecret);
    }

    public static ApiContext ctx(String orgSecret, String uid) {
        return new ApiContext(orgSecret, uid);
    }

    public static ApiContext ctx(String orgSecret, String uid, String name) {
        return new ApiContext(orgSecret, uid, name);
    }
}
