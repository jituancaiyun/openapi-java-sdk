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

package com.shinemo.openapi.client.internal;

import com.shinemo.openapi.client.common.OpenApiResult;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

/**
 * Created by ohun on 2017/4/11.
 *
 * @author ohun@live.cn (夜色)
 */
public final class ErrorResultCall<T> implements Call<OpenApiResult<T>> {

    private final OpenApiResult<T> result;

    public ErrorResultCall(OpenApiResult<T> result) {
        this.result = result;
    }

    @Override
    public Response<OpenApiResult<T>> execute() throws IOException {
        return Response.success(result);
    }

    @Override
    public void enqueue(Callback callback) {

    }

    @Override
    public boolean isExecuted() {
        return true;
    }

    @Override
    public void cancel() {

    }

    @Override
    public boolean isCanceled() {
        return false;
    }

    @Override
    public Call<OpenApiResult<T>> clone() {
        return this;
    }

    @Override
    public Request request() {
        return null;
    }
}
