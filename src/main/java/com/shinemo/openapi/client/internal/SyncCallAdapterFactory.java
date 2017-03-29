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
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Created by ohun on 2017/3/26.
 *
 * @author ohun@live.cn (夜色)
 */
public final class SyncCallAdapterFactory extends CallAdapter.Factory {

    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        if (getRawType(returnType) == OpenApiResult.class) {
            return new CallAdapter<OpenApiResult<?>, Object>() {
                @Override
                public Type responseType() {
                    return OpenApiResult.class;
                }

                @Override
                public OpenApiResult<?> adapt(Call<OpenApiResult<?>> call) {
                    try {
                        Response<OpenApiResult<?>> response = call.execute();
                        return response.body();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return OpenApiResult.failure();
                }
            };
        }
        return null;
    }

}
