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

import com.shinemo.openapi.client.aes.AesKey;
import com.shinemo.openapi.client.aes.cache.AesKeyCache;
import com.shinemo.openapi.client.aes.domain.AesKeyDTO;
import com.shinemo.openapi.client.aes.domain.AesKeyEntity;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
public interface AesKeyDao {

//    boolean insert(AesKeyEntity key, String orgId);

//    List<AesKeyEntity> selectList(String orgId, int start, int limit);

//    List<AesKeyEntity> selectListByKeyIds(String orgId, List<Integer> ids);

//    AesKeyEntity getById(String orgId, int id);

//    List<AesKeyEntity> selectListByOrgId(String orgId, int start, int limit);

    /**
     * 生成企业的秘钥，并缓存
     *
     * @param key
     * @return
     */
    boolean insert(AesKeyEntity key) throws Exception;

    /**
     * 根据企业id获取今日秘钥
     *
     * @param aesKeyEntity
     * @return
     */
    AesKeyDTO selectKeyOfTodayByOrgId(AesKeyEntity aesKeyEntity) throws Exception;

//    List<AesKeyEntity> selectList(long orgId, int limit) throws Exception;

    /**
     * 获取最近10天的数据，根据orgId分组存入map
     *
     * @return
     * @throws Exception
     */
    Map<Long, Map<String, String>> selectKeyByOrgIdLimit(int days) throws Exception;

//    List<AesKeyEntity> selectListByKeyIds(String orgId, List<Integer> ids);

    /**
     * 根据秘钥AesKeyServiceImpl.AESKEYID_SPACER + id 组合的 ids串获取
     *
     * @param ids
     * @return
     */
    Map<String, AesKeyDTO> selectKeyByKeyIds(List<Integer> ids,Long orgId) throws Exception;

    /**
     * 获取最新的300条aseKey记录
     *
     * @return
     * @throws Exception
     */
    Map<String, AesKeyDTO> getLatestThreeHundredAesKey() throws Exception;

    void setDataSource(DataSource dataSource);

//    void setAesKeyCache(AesKeyCache aesKeyCache);
}
