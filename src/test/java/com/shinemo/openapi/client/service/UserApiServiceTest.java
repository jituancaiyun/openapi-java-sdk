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
        Apis.setEnv(0);
        context = ApiContext.ctx(orgId, uid, name);
        userApiService = Apis.createApiService(UserApiService.class);
    }

    @Test
    public void add() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("测试个人权限priiii");
//        userDTO.setTitle("测试");
        userDTO.setMobile("12300000005");
        userDTO.setDeptId(12L);
        userDTO.setPrivilege("mydeptonly");
        OpenApiResult<Map<String, String>> result = userApiService.add(context, userDTO);
        System.out.println(result);
        System.out.println(result.getData());
    }

    @Test
    public void delete() {
        System.out.println(userApiService.delete(context, "101010012671673", 14L));
    }

    @Test
    public void update() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("测试个人权限pri2");
        userDTO.setTitle("测试");
        userDTO.setMobile("13600000002");
        userDTO.setDeptId(14L);
//        userDTO.setOldDeptId(13L);
//        userDTO.setSequence(-1);
        userDTO.setUid("101010012310960");
        userDTO.setPrivilege("mydeptonly");
        OpenApiResult<Map<String, String>> result = userApiService.update(context, userDTO);
        System.out.println(result);
        System.out.println(result.getData());
    }

    @Test
    public void detail() {
        System.out.println(userApiService.detail(context, "101010012310960", 14L));
    }

    @Test
    public void list() {
        System.out.println(userApiService.list(context, 14L));
    }

    @Test
    public void listAll() {
        System.out.println(userApiService.listAll(context, 13L));
    }
}
