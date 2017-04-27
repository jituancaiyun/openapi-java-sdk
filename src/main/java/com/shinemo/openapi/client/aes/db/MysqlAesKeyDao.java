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
import com.shinemo.openapi.client.common.OpenApiException;
import com.shinemo.openapi.client.common.OpenApiUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.shinemo.openapi.client.common.Const.LOG;

/**
 * Created by ohun on 2017/4/14.
 *
 * @author ohun@live.cn (夜色)
 */
public final class MysqlAesKeyDao implements AesKeyDao {

    private DataSource dataSource;

    public void init() {
        if (dataSource == null) {
            throw new OpenApiException("dataSource不能为空，请先设置dataSource");
        }
    }

    @Override
    public boolean insert(AesKeyEntity aesKey) {
        String sql = "INSERT INTO t_openapi_aeskey (org_id, aes_key, gmt_create, gmt_modified) VALUES (?,?,?,?)";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, aesKey.getOrgId());
            pstm.setString(2, aesKey.getKey());
            pstm.setTimestamp(3, new Timestamp(aesKey.getGmtCreate()));
            pstm.setTimestamp(4, new Timestamp(aesKey.getGmtCreate()));
            if (pstm.executeUpdate() > 0) {
                ResultSet rs = pstm.getGeneratedKeys();
                if (rs.next()) {
                    aesKey.setId(rs.getInt(1));
                    return true;
                } else {
                    throw new OpenApiException("无法获取主键。");
                }
            } else {
                throw new OpenApiException("数据存储出错。");
            }
        } catch (SQLException e) {
            LOG.error("MysqlAesKeyDao.insert error, entity={}, sql={}", aesKey, sql);
            throw new OpenApiException("MysqlAesKeyDao.insert error", e);
        } finally {
            OpenApiUtils.silentClose(connection);
        }
    }


    @Override
    public AesKeyEntity getById(int id) {
        String sql = "SELECT id, aes_key, gmt_create FROM t_openapi_aeskey WHERE id=?";
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                AesKeyEntity aesKeyEntity = new AesKeyEntity();
                aesKeyEntity.setId(resultSet.getInt("id"));
                aesKeyEntity.setKey(resultSet.getString("aes_key"));
                aesKeyEntity.setGmtCreate(resultSet.getTimestamp("gmt_create").getTime());
                return aesKeyEntity;
            }
        } catch (SQLException e) {
            LOG.error("MysqlAesKeyDao.getById error, id={}, sql={}", id, sql);
            throw new OpenApiException("MysqlAesKeyDao.getById error", e);
        } finally {
            OpenApiUtils.silentClose(connection);
        }
        return null;
    }

    @Override
    public List<AesKeyEntity> selectListByOrgId(String orgId, int limit) {
        String sql = "SELECT id, aes_key, gmt_create FROM t_openapi_aeskey WHERE org_id=? ORDER BY gmt_create DESC LIMIT ?";

        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, orgId);
            preparedStatement.setInt(2, limit);

            ResultSet resultSet = preparedStatement.executeQuery();
            List<AesKeyEntity> list = new ArrayList<AesKeyEntity>();
            while (resultSet.next()) {
                AesKeyEntity aesKeyEntity = new AesKeyEntity();
                aesKeyEntity.setId(resultSet.getInt("id"));
                aesKeyEntity.setKey(resultSet.getString("aes_key"));
                aesKeyEntity.setGmtCreate(resultSet.getTimestamp("gmt_create").getTime());
                list.add(aesKeyEntity);
            }
            return list;
        } catch (SQLException e) {
            LOG.error("MysqlAesKeyDao.selectListByOrgId error, orgId={}, sql={}", orgId, sql);
            throw new OpenApiException("MysqlAesKeyDao.selectListByOrgId error", e);
        } finally {
            OpenApiUtils.silentClose(connection);
        }
    }

    @Override
    public List<AesKeyEntity> selectListByKeyIds(List<Integer> ids) {
        StringBuilder sqlBuf = new StringBuilder("SELECT id, aes_key, gmt_create, org_id FROM t_openapi_aeskey WHERE id in (");

        int L = ids.size();
        for (int i = 0; i < L; i++) {
            if (i != 0) {
                sqlBuf.append(',');
            }
            sqlBuf.append('?');
        }
        sqlBuf.append(')');
        String sql = sqlBuf.toString();

        Connection connection = null;
        try {
            connection = dataSource.getConnection();

            PreparedStatement statement = connection.prepareStatement(sql);

            for (int i = 0; i < L; i++) {
                statement.setInt(i + 1, ids.get(i));
            }

            ResultSet resultSet = statement.executeQuery();
            List<AesKeyEntity> list = new ArrayList<AesKeyEntity>();
            while (resultSet.next()) {
                AesKeyEntity aesKeyEntity = new AesKeyEntity();
                aesKeyEntity.setId(resultSet.getInt("id"));
                aesKeyEntity.setKey(resultSet.getString("aes_key"));
                list.add(aesKeyEntity);
            }
            return list;
        } catch (SQLException e) {
            LOG.error("MysqlAesKeyDao.selectListByKeyIds error, ids={}, sql={}", ids, sql);
            throw new OpenApiException("MysqlAesKeyDao.selectListByKeyIds error", e);
        } finally {
            OpenApiUtils.silentClose(connection);
        }
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}
