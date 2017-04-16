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

import com.shinemo.openapi.client.aes.cache.AesKeyCache;
import com.shinemo.openapi.client.aes.domain.AesKeyDTO;
import com.shinemo.openapi.client.aes.domain.AesKeyEntity;
import com.shinemo.openapi.client.aes.util.AesKeyProduce;
import com.shinemo.openapi.client.common.OpenApiException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
public final class MysqlAesKeyDao implements AesKeyDao {

    private PreparedStatement pstm = null;
    private Connection conn = null;
    private ResultSet rs = null;

    private DataSource dataSource;

//    private AesKeyCache aesKeyCache;

    public void init() {
        if (dataSource == null) {
            throw new OpenApiException("dataSource不能为空，请先设置dataSource");
        }
    }

    @Override
    public boolean insert(AesKeyEntity aesKey) throws Exception {
        if (dataSource == null) {
            throw new OpenApiException("dataSource不能为空，请先设置dataSource");
        }
        String sql = "INSERT INTO t_openapi_aeskey (org_id,aes_key,gmt_create,gmt_modified) VALUES (?,?,?,?)";
        conn = dataSource.getConnection();
        pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pstm.setLong(1, aesKey.getOrgId());
        pstm.setString(2, aesKey.getKey());
        pstm.setDate(3, aesKey.getGmtCreate());
        pstm.setDate(4, aesKey.getGmtCreate());
        if (pstm.executeUpdate() > 0) {
            rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                aesKey.setId(rs.getInt(1));
                return true;
            } else {
                throw new OpenApiException("无法获取主键。");
            }
        } else {
            throw new OpenApiException("数据存储出错。");
        }
    }

    @Override
    public AesKeyDTO selectKeyOfTodayByOrgId(AesKeyEntity aesKeyEntity) throws Exception {
        if (dataSource == null) {
            throw new OpenApiException("dataSource不能为空，请先设置dataSource");
        }
        AesKeyDTO aesKeyDTO = new AesKeyDTO();
        String sql = "SELECT id,aes_key FROM t_openapi_aeskey WHERE org_id=? AND gmt_create=? limit 1";
        conn = dataSource.getConnection();
        pstm = conn.prepareStatement(sql);
        pstm.setLong(1, aesKeyEntity.getOrgId());
        pstm.setDate(2, aesKeyEntity.getGmtCreate());
        rs = pstm.executeQuery();
        if (rs.next()) {
            aesKeyDTO.setId(rs.getInt("id"));
            aesKeyDTO.setKey(rs.getString("aes_key"));
            return aesKeyDTO;
        }
        return null;
    }

    @Override
    public Map<Long, Map<String, String>> selectKeyByOrgIdLimit(int days) throws Exception {
        if(dataSource == null){
            throw new OpenApiException("dataSource不能为空，请先设置dataSource");
        }
        Map<Long,Map<String,String>> map = new HashMap<Long,Map<String,String>>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,-days);
        String sql = "SELECT org_id,id,gmt_create FROM t_openapi_aeskey WHERE gmt_create > ? ORDER BY gmt_create DESC";
        conn = dataSource.getConnection();
        pstm = conn.prepareStatement(sql);
        pstm.setDate(1,new java.sql.Date(calendar.getTime().getTime()));
        rs = pstm.executeQuery();
        while (rs.next()) {
            Map<String, String> mapTemp = map.get(rs.getLong("org_id"));
            if(mapTemp == null){
                mapTemp = new HashMap<String, String>();
                mapTemp.put(rs.getDate("gmt_create").toString(),AesKeyProduce.idKeyProduce(rs.getLong("org_id"),rs.getInt("id")));
                map.put(rs.getLong("org_id"),mapTemp);
            }else{
                mapTemp.put(rs.getDate("gmt_create").toString(),AesKeyProduce.idKeyProduce(rs.getLong("org_id"),rs.getInt("id")));
                map.put(rs.getLong("org_id"),mapTemp);
            }
        }
        return map;
    }

    @Override
    public Map<String, AesKeyDTO> selectKeyByKeyIds(List<Integer> ids, Long orgId) throws Exception {
        if(dataSource == null){
            throw new OpenApiException("dataSource不能为空，请先设置dataSource。");
        }/*
        if(orgId == null){
            throw new OpenApiException("orgId不能为空，请设置orgId。");
        }*/
        Map<String, AesKeyDTO> map = new HashMap<String, AesKeyDTO>();
        StringBuffer sqlBuf = new StringBuffer("select id,aes_key,gmt_create,org_id from t_openapi_aeskey where org_id=? and id in (");
        for (int i=0;i<ids.size();i++) {
            sqlBuf.append("?,");
        }
        String sql = sqlBuf.substring(0, sqlBuf.length() - 1);
        sql = sql + ") limit " + ids.size();
        conn = dataSource.getConnection();
        pstm = conn.prepareStatement(sql);
        pstm.setLong(1,orgId);
        for (int i = 0; i < ids.size(); i++) {
            pstm.setInt(i + 2, ids.get(i));
        }
        rs = pstm.executeQuery();
        while (rs.next()) {
            AesKeyDTO aesKeyDTO = new AesKeyDTO();
            aesKeyDTO.setId(rs.getInt("id"));
            aesKeyDTO.setKey(rs.getString("aes_key"));
            map.put(AesKeyProduce.idKeyProduce(rs.getLong("org_id"),aesKeyDTO.getId()), aesKeyDTO);
        }
        return map;
    }

    @Override
    public Map<String, AesKeyDTO> getLatestThreeHundredAesKey() throws Exception {
        if (dataSource == null) {
            throw new OpenApiException("dataSource不能为空，请先设置dataSource");
        }
        Map<String, AesKeyDTO> map = new HashMap<String, AesKeyDTO>();
        String sql = "select id,aes_key,org_id from t_openapi_aeskey order by id desc limit 300";
        conn = dataSource.getConnection();
        pstm = conn.prepareStatement(sql);
        rs = pstm.executeQuery();
        while (rs.next()) {
            AesKeyDTO aesKeyDTO = new AesKeyDTO();
            aesKeyDTO.setId(rs.getInt("id"));
            aesKeyDTO.setKey(rs.getString("aes_key"));
            map.put(AesKeyProduce.idKeyProduce(rs.getLong("org_id"), aesKeyDTO.getId()), aesKeyDTO);
        }
        return map;
    }

//    @Override
//    public AesKeyEntity getById(String orgId, int id) {
//        return null;
//    }

    @Override
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

//    @Override
//    public void setAesKeyCache(AesKeyCache aesKeyCache) {
//        this.aesKeyCache = aesKeyCache;
//    }
}
