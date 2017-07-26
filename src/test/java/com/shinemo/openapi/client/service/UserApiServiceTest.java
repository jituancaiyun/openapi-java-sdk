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
    private String orgSecret = "AQAOAQAAAAAAAFlIAQAAAAAA";
    private String uid = "101010011894152";//"101010012129489";//
    private String name = "yuanjian";
    private ApiContext context;

    @Before
    public void setUp() throws Exception {
//        Apis.setEnv(4);
        context = ApiContext.ctx(orgSecret, uid, name);
        userApiService = Apis.createApiService(UserApiService.class);
    }

    @Test
    public void add() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("测试个人权限priiii好久好久好久环境");
//        userDTO.setTitle("测试");
        userDTO.setMobile("12600000028");
        userDTO.setSequence(1);
        userDTO.setDeptId(0L);
        userDTO.setTitle("部门名称");
//        System.out.println(userDTO.getTitle().length());
        /*if(userDTO.getTitle().length() < 40){

            return;
        }*/
        userDTO.setWorkPhone("0571-232323123");
//        userDTO.setPrivilege("mydeptonly");
        OpenApiResult<Map<String, String>> result = userApiService.add(context, userDTO);
        System.out.println(result);
        System.out.println(result.getData());
    }

    @Test
    public void delete() {
        System.out.println(userApiService.delete(context, "185010176", 0L));
    }

    @Test
    public void update() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("测试个人权限pri2");
//        userDTO.setTitle("测试");
//        userDTO.setMobile("13600000002");
//        userDTO.setDeptId(14L);
//        userDTO.setOldDeptId(13L);
//        userDTO.setSequence(-1);
        userDTO.setUid("185010176");
//        userDTO.setPrivilege("mydeptonly");
        OpenApiResult<Map<String, String>> result = userApiService.update(context, userDTO);
        System.out.println(result);
        System.out.println(result.getData());
    }

    @Test
    public void detail() {
        OpenApiResult<Map<String, UserInfoDTO>> result = userApiService.detail(context, "185010176", 0L);
        System.out.println(result);
        System.out.println(result.getData().get("user").getWorkPhone());
    }

    @Test
    public void list() {
        OpenApiResult<Map<String, List<UserInfoDTO>>> result = userApiService.list(context, 0L);
        System.out.println(result);
//        result.getData().get("users").get(0).getWorkPhone();
    }

    @Test
    public void listAll() {
        OpenApiResult<Map<String, List<UserInfoDTO>>> result = userApiService.listAll(context, 14L);
        System.out.println(result);
        result.getData().get("users").get(0).getWorkPhone();
    }
}
