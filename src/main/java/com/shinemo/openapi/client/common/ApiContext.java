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

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
public class ApiContext {
    private String accessToken;
    private String orgId;
    private String uid;
    private String name;

    public ApiContext() {
    }

    public ApiContext(String orgId) {
        this.orgId = orgId;
    }

    public ApiContext(String orgId, String uid) {
        this.orgId = orgId;
        this.uid = uid;
    }

    public ApiContext(String orgId, String uid, String name) {
        this.orgId = orgId;
        this.uid = uid;
        this.name = name;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public ApiContext setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getOrgId() {
        return orgId;
    }

    public ApiContext setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getUid() {
        return uid;
    }

    public ApiContext setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public String getName() {
        return name;
    }

    public ApiContext setName(String name) {
        this.name = name;
        return this;
    }
}
