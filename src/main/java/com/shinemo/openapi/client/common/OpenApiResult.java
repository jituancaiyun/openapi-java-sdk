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
 * Created by ohun on 2017/3/22.
 *
 * @author ohun@live.cn (夜色)
 */
public final class OpenApiResult<T> {
    private static final OpenApiResult<Void> FAIL = new OpenApiResult<Void>(400, "请求错误");

    private int status;

    private String message;

    private T data;

    public OpenApiResult() {
    }

    public OpenApiResult(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return status == 0;
    }

    @SuppressWarnings("unchecked")
    public static <T> OpenApiResult<T> failure() {
        return (OpenApiResult<T>) FAIL;
    }

    public static <T> OpenApiResult<T> failure(String errorMsg) {
        return new OpenApiResult<T>(400, errorMsg);
    }

    public static <T> OpenApiResult<T> failure(int errorCode, String errorMsg) {
        return new OpenApiResult<T>(errorCode, errorMsg);
    }

    public static <T> OpenApiResult<T> success(T data) {
        OpenApiResult<T> result = new OpenApiResult<T>();
        result.data = data;
        result.status = 0;
        return result;
    }

    @Override
    public String toString() {
        return "OpenApiResult{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
