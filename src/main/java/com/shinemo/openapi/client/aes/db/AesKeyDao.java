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

package com.shinemo.openapi.client.aes.db;

import com.shinemo.openapi.client.aes.domain.AesKeyEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
public interface AesKeyDao {

    /**
     * 通过Id查询密钥
     *
     * @param id
     * @return
     * @
     */
    AesKeyEntity getById(int id);

    /**
     * 插入新密钥
     *
     * @param entity
     * @return
     * @
     */
    boolean insert(AesKeyEntity entity);

    /**
     * 查询某个企业下的limit条密钥
     *
     * @param orgId 企业Id
     * @param limit 条数
     * @return
     * @
     */
    List<AesKeyEntity> selectListByOrgId(String orgId, int limit);

    /**
     * 指定Id查询
     *
     * @param ids
     * @return
     * @
     */
    List<AesKeyEntity> selectListByKeyIds(List<Integer> ids);

}
