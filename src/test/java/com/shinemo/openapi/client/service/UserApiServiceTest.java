package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.maillist.UserDTO;
import com.shinemo.openapi.client.dto.maillist.UserInfoDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by ohun on 2017/4/16.
 *
 * @author ohun@live.cn (夜色)
 */
public class UserApiServiceTest {

    private UserApiService userApiService;
    private String orgId = "84057";
    private String uid = "101010011894152";//"101010012129489";//
    private String name = "yuanjian";
    private ApiContext context;

    @Before
    public void setUp() throws Exception {
        context = ApiContext.ctx(orgId, uid, name);
        userApiService = Apis.createApiService(UserApiService.class);
    }

    @Test
    public void addUser() throws Exception {
        UserDTO user = new UserDTO();
        user.setDeptId(0L);
        user.setMobile("13467820879");
        user.setTitle("技术人员");
        user.setUserName("小新");
        OpenApiResult<Map<String, String>> result = userApiService.add(context, user);
        System.out.println(result);
    }

    @Test
    public void delete() {
        OpenApiResult<Long> result = userApiService.delete(context, "");
        System.out.println(result);
    }

    @Test
    public void update() throws Exception {
        UserDTO user = new UserDTO();
        user.setDeptId(0L);
        user.setMobile("13588200631");
        user.setTitle("技术人员");
        user.setUserName("小新-update");
        user.setUid("101010012671641");
        OpenApiResult<Map<String, String>> result = userApiService.update(context, user);
        System.out.println(result);
    }

    @Test
    public void detail() {
        OpenApiResult<UserInfoDTO> result = userApiService.detail(context, "101010012129489", 0L);
        System.out.println(result);
    }

    @Test
    public void userList() {
        OpenApiResult<List<UserInfoDTO>> result = userApiService.list(context, 0L);
        System.out.println(result);
    }

    @Test
    public void userListAll() {
        OpenApiResult<List<UserInfoDTO>> result = userApiService.listAll(context, 0L);
        System.out.println(result);
    }

}