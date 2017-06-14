package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.OpenApiClient;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.maillist.PrivilegeGroup;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by yuanjian on 6/14/17.
 */
public class PrivilegeGroupApiServiceTest {

    private PrivilegeGroupApiService privilegeGroupApiService;
    private OpenApiClient client;
    private String orgId = "84057";
    private String uid = "101010012129489";
    private String name = "yuanjian";
    private ApiContext context;

    @Before
    public void setUp() throws Exception {
        client = Apis.createClient();
        context = ApiContext.ctx(orgId, uid, name);
        privilegeGroupApiService = client.createApiService(PrivilegeGroupApiService.class);
    }

    @Test
    public void add() {
        PrivilegeGroup group = new PrivilegeGroup();
        group.setName("群组测试3");
        ArrayList<Long> list = new ArrayList<Long>();
        list.add(123123L);
        list.add(123123L);
        group.setDeptList(list);
        OpenApiResult<Map<String, Long>> result = privilegeGroupApiService.create(context, group);
        System.out.println(result);
    }

    @Test
    public void delete() {//25723
        OpenApiResult<Long> result = privilegeGroupApiService.delete(context, 25724L);
        System.out.println(result);
    }

}
