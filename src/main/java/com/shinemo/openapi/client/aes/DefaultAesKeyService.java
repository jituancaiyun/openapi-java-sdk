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

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.shinemo.openapi.client.OpenApiClient;
import com.shinemo.openapi.client.aes.cache.AesKeyCache;
import com.shinemo.openapi.client.aes.cache.GuavaAesKeyCache;
import com.shinemo.openapi.client.aes.common.Const;
import com.shinemo.openapi.client.aes.db.AesKeyDao;
import com.shinemo.openapi.client.aes.domain.AesKeyDTO;
import com.shinemo.openapi.client.aes.domain.AesKeyEntity;
import com.shinemo.openapi.client.aes.domain.ResultMsg;
import com.shinemo.openapi.client.aes.util.AesKeyProduce;
import com.shinemo.openapi.client.common.OpenApiException;
import com.shinemo.openapi.client.service.AuthApiService;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
public final class DefaultAesKeyService implements AesKeyService {

    private OpenApiClient openApiClient;

    private AuthApiService authApiService;

    private AesKeyDao aesKeyDao;

    private AesKeyCache<String, AesKeyDTO> aesKeyCacheId;

    private AesKeyCache<Long, Map<String, String>> aesKeyCacheOrgId;

    private Integer cacheDays;

    public void init() {
        /*if (dataSource == null) {
            throw new OpenApiException("dataSource can not be null.");
        }*/

        if (openApiClient == null) {
            throw new OpenApiException("openApiClient can not be null.");
        }


        if (authApiService == null) {
            throw new OpenApiException("authApiService can not be null.");
        }

        if (aesKeyDao == null) {
            /*MysqlAesKeyDao mysqlAesKeyDao = new MysqlAesKeyDao();
            mysqlAesKeyDao.setDataSource(dataSource);
            mysqlAesKeyDao.init();
            aesKeyDao = mysqlAesKeyDao;*/
            throw new OpenApiException("aesKeyDao can not be null.");
        }

        if (cacheDays == null) {
            cacheDays = 10;
        }

        if (aesKeyCacheId == null) {
//            HashMapAesKeyCache hashMapAesKeyCache = new HashMapAesKeyCache();
//            hashMapAesKeyCache.setAesKeyDao(aesKeyDao);
//            hashMapAesKeyCache.init();
            LoadingCache<String, AesKeyDTO> idCache = CacheBuilder.newBuilder()
                    .build(new CacheLoader<String, AesKeyDTO>() {
                        /** 当本地缓存命没有中时(get取不到数据或者过期)，调用load方法获取结果并将结果缓存 **/
                        @Override
                        public AesKeyDTO load(String appKey) throws Exception {
                            List<Integer> idList = new ArrayList<Integer>();
                            long orgId = Long.parseLong(appKey.split(Const.ID_CACHE_SPACE)[0]);
                            idList.add(Integer.parseInt(appKey.split(Const.ID_CACHE_SPACE)[1]));
                            Map<String, AesKeyDTO> map = aesKeyDao.selectKeyByKeyIds(idList,orgId);
                            return map.get(appKey);
                        }

                        /**
                         * 一次获取多个缓存值不存在时调用
                         * @param keys 取不到值得keys
                         * @return 返回数据库中取出的数据
                         * @throws Exception 异常
                         */
                        @Override
                        public Map<String, AesKeyDTO> loadAll(Iterable<? extends String> keys) throws Exception {
                            Map<String, AesKeyDTO> map = null;
                            List<Integer> idList = new ArrayList<Integer>();
                            int index = 0;
                            long orgId = 0L;
                            for (String key:keys){
                                if(index == 0){
                                    orgId = Long.parseLong(key.split(Const.ID_CACHE_SPACE)[0]);
                                    index++;
                                }
                                idList.add(Integer.parseInt(key.split(Const.ID_CACHE_SPACE)[1]));
                            }
                            return aesKeyDao.selectKeyByKeyIds(idList,orgId);
                        }
                    });
            this.aesKeyCacheId = new GuavaAesKeyCache<String, AesKeyDTO>(idCache);
        }

        if (aesKeyCacheOrgId == null) {
            LoadingCache<Long, Map<String, String>> orgIdCache = CacheBuilder.newBuilder()
                    .expireAfterWrite(10, TimeUnit.DAYS)// 给定时间内没有被写访问，则回收。
                    .build(new CacheLoader<Long, Map<String, String>>() {
                        /** 当本地缓存命没有中时(get取不到数据或者过期)，调用load方法获取结果并将结果缓存 **/
                        @Override
                        public Map<String, String> load(Long appKey) throws Exception {
                            return null;
                        }

                        @Override
                        public Map<Long, Map<String, String>> loadAll(Iterable<? extends Long> keys) throws Exception {
                            return super.loadAll(keys);
                        }
                    });
            this.aesKeyCacheOrgId = new GuavaAesKeyCache<Long, Map<String, String>>(orgIdCache);
        }
        cacheInit();
    }

    @Override
    public AesKey getAesKeyOfTodayBySDK(long orgId) throws Exception {
        AesKeyDTO aesKeyDTO;
        Map<String, String> mapId = this.aesKeyCacheOrgId.get(orgId);

        String dateToday = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        if (mapId == null) {
            mapId = new HashMap<String, String>();
        }
        // 今天的id不为null，则查找今天的key；否则，查找数据库
        if (mapId.get(dateToday) != null) {
            //查询今天的key，为null则查找数据库
            aesKeyDTO = this.aesKeyCacheId.get(mapId.get(dateToday));
            if (aesKeyDTO != null) {
                return aesKeyDTO;
            }
        }
        //数据库中读取今天的aesKey
        AesKeyEntity aesKeyEntity = new AesKeyEntity();
        aesKeyEntity.setOrgId(orgId);
        aesKeyEntity.setGmtCreate(new java.sql.Date(new Date().getTime()));
        aesKeyDTO = aesKeyDao.selectKeyOfTodayByOrgId(aesKeyEntity);
        //当数据库中读取aesKey不为null时，缓存并返回， 为null时生成aesKey，并缓存
        if (aesKeyDTO == null) {
            //设置缓存
            aesKeyDTO = new AesKeyDTO();
            aesKeyEntity.setKey(AesKeyProduce.aeskeyProduce());
            if (!aesKeyDao.insert(aesKeyEntity)) {
                throw new OpenApiException("producing a new key error.");
            }
            aesKeyDTO.setId(aesKeyEntity.getId()).setKey(aesKeyEntity.getKey());
        }
        this.aesKeyCacheId.put(AesKeyProduce.idKeyProduce(orgId, aesKeyEntity.getId()), aesKeyDTO);
        mapId.put(dateToday, AesKeyProduce.idKeyProduce(orgId, aesKeyDTO.getId()));
        cacheOrgId(orgId, mapId);
        return aesKeyDTO;
    }

    @Override
    public ResultMsg<Map<String,List<AesKeyDTO>>> getAesKeyByClient(String token, String uid, long timestamp, long orgId, String keyIds) throws Exception {
        /*OpenApiResult<Void> result = authApiService.checkHttpToken(token, timestamp, uid, orgId);
        if (!result.isSuccess()) {
            return OpenApiResult.failure(403, "权限校验失败");
        }*/

        if (keyIds == null || "".equals(keyIds)) {
            return getAesKeyByOrgIdLimit10(orgId);
        }else {
            if (!keyIds.matches("\\d+(,\\d+)*")) {
                throw new OpenApiException("keyIds格式错误，多个id请用半角符号隔开（英文逗号）。");
            }
            return getAesKeyByIds(keyIds, orgId);
        }
    }

    /**
     * 根据orgId获取最近十天的aesKey,检查是否存在当天aeskey，存在返回，不存在创建，保证每天创建一个aeskey需要考虑并发问题
     *
     * @return
     * @throws Exception
     */
    private ResultMsg<Map<String, List<AesKeyDTO>>> getAesKeyByOrgIdLimit10(long orgId) throws Exception {
        //返回的map数据
        Map<String, List<AesKeyDTO>> mapList = new HashMap<String, List<AesKeyDTO>>();

        Map<String, String> mapId = this.aesKeyCacheOrgId.get(orgId);

        String dateToday = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Map<String, AesKeyDTO> mapKey = new HashMap<String, AesKeyDTO>();

        if (mapId == null) {
            mapId = new HashMap<String, String>();
        } else {
            mapKey.putAll(this.aesKeyCacheId.getAll(new ArrayList<String>(mapId.values())));
        }
        // 今天的id不为null，则查找今天的key；否则，查找数据库
        if (mapId.get(dateToday) != null) {
            //查询今天的key，为null则查找数据库
            if (mapKey.get(mapId.get(dateToday)) != null) {
                List<AesKeyDTO> listKey = new ArrayList<AesKeyDTO>(mapKey.values());
                Collections.sort(listKey);
                mapList.put("keys", listKey);
                return ResultMsg.success(mapList);
            }
        }
        //数据库中读取今天的aesKey
        AesKeyEntity aesKeyEntity = new AesKeyEntity();
        aesKeyEntity.setOrgId(orgId);
        aesKeyEntity.setGmtCreate(new java.sql.Date(new Date().getTime()));
        AesKeyDTO aesKeyDTO = aesKeyDao.selectKeyOfTodayByOrgId(aesKeyEntity);
        //当数据库中读取aesKey为null时生成aesKey，并缓存,不为null时，缓存并返回，
        if(aesKeyDTO == null){
            aesKeyEntity.setKey(AesKeyProduce.aeskeyProduce());
            if (!aesKeyDao.insert(aesKeyEntity)) {
                throw new OpenApiException("producing a new key error.");
            }
            aesKeyDTO = new AesKeyDTO();
            aesKeyDTO.setId(aesKeyEntity.getId()).setKey(aesKeyEntity.getKey());
        }
        this.aesKeyCacheId.put(AesKeyProduce.idKeyProduce(orgId, aesKeyEntity.getId()), aesKeyDTO);
        mapId.put(dateToday, AesKeyProduce.idKeyProduce(orgId, aesKeyDTO.getId()));
        cacheOrgId(orgId, mapId);
        mapKey.put(AesKeyProduce.idKeyProduce(orgId, aesKeyDTO.getId()), aesKeyDTO);
        List<AesKeyDTO> listKey = new ArrayList<AesKeyDTO>(mapKey.values());
        Collections.sort(listKey);
        mapList.put("keys", listKey);
        return ResultMsg.success(mapList);
    }

    /**
     * 根据id串获取aeskey，多个id时中间用,隔开
     *
     * @param ids   id串
     * @param orgId 组织id
     * @return 返回ResultMsg
     */
    private ResultMsg<Map<String, List<AesKeyDTO>>> getAesKeyByIds(String ids, long orgId) {
        Map<String, List<AesKeyDTO>> mapKey = new HashMap<String, List<AesKeyDTO>>();

        String[] idArr = ids.split(",");
        List<String> list = new ArrayList<String>();
        //数组转list
        for (String id:idArr) {
            list.add(AesKeyProduce.idKeyProduce(orgId,Integer.parseInt(id)));
        }
        //从缓存中读取aesKey
        //this.AESKEYID_SPACER + ids
        Map<String, AesKeyDTO> map = this.aesKeyCacheId.getAll(list);
        //map转list
        List<AesKeyDTO> listKey = new ArrayList<AesKeyDTO>(map.values());
        mapKey.put("keys", listKey);
        return ResultMsg.success(mapKey);
    }

    private void cacheInit() {
        try {
            //根据id设置缓存
            Map<String, AesKeyDTO> map = aesKeyDao.getLatestThreeHundredAesKey();
            this.aesKeyCacheId.putAll(map);
            Map<Long, Map<String, String>> map2 = aesKeyDao.selectKeyByOrgIdLimit(cacheDays);
            this.aesKeyCacheOrgId.putAll(map2);
        } catch (Exception e) {
            throw new OpenApiException("缓存设置出错，错误信息：" + e.getMessage());
        }
    }

    /**
     * 根据orgId缓存数据，保证每个orgId缓存的数据不超过10个
     *
     * @param orgId 组织id
     * @param idMap  aesKey的id的Map集合
     */
    private void cacheOrgId(Long orgId, Map<String, String> idMap) {
        if (idMap.size() < this.cacheDays) {
            this.aesKeyCacheOrgId.put(orgId, idMap);
        } else {
            List<String> list = new ArrayList<String>(idMap.keySet());
            Collections.sort(list);
            for (int i = list.size() - 1; i > this.cacheDays-1; i--) {
                idMap.remove(list.get(i));
            }
            this.aesKeyCacheOrgId.put(orgId, idMap);
        }
    }


//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
    @Override
    public void setOpenApiClient(OpenApiClient openApiClient) {
        this.openApiClient = openApiClient;
    }
    @Override
    public void setAuthApiService(AuthApiService authApiService) {
        this.authApiService = authApiService;
    }
    @Override
    public void setAesKeyDao(AesKeyDao aesKeyDao) {
        this.aesKeyDao = aesKeyDao;
    }

    @Override
    public void setAesKeyCacheId(AesKeyCache<String,AesKeyDTO> aesKeyCacheId) {
        this.aesKeyCacheId = aesKeyCacheId;
    }

    @Override
    public void setAesKeyCacheOrgId(AesKeyCache<Long,Map<String,String>> aesKeyCacheOrgId) {
        this.aesKeyCacheOrgId = aesKeyCacheOrgId;
    }

    @Override
    public void setCacheDays(Integer cacheDays) {
        this.cacheDays = cacheDays;
    }
}
