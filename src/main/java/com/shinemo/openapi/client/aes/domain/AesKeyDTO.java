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

package com.shinemo.openapi.client.aes.domain;

import com.shinemo.openapi.client.aes.AesKey;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
public final class AesKeyDTO implements AesKey,Comparable<AesKeyDTO> {
    private Integer id;

    private String key;

    public AesKeyDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public AesKeyDTO setKey(String key) {
        this.key = key;
        return this;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public int compareTo(AesKeyDTO o) {
        if(o == null){
            return -1;
        }
        if(o.getId() == null){
            return -1;
        }
        if(this.getId() > o.getId()){
            return -1;
        }else if(this.getId() < o.getId()){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return "AesKeyDTO{" +
                "id=" + id +
                ", key='" + key + '\'' +
                '}';
    }
}
