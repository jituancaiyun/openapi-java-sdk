package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.Jsons;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.maillist.DeptInfoDTO;
import com.shinemo.openapi.client.dto.maillist.UserDTO;
import com.shinemo.openapi.client.dto.maillist.UserInfoDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ohun on 2017/4/16.
 *
 * @author ohun@live.cn (夜色)
 */
public class UserApiServiceTest {

    private UserApiService userApiService;
    private String orgSecret = "AQB3AQAAAAAAAKlMAQAAAAAA";
    private ApiContext context;

    @Before
    public void setUp() throws Exception {
        Apis.setEnv(1);
        context = ApiContext.ctx(orgSecret);
        // context = ApiContext.ctx(orgSecret, uid, name);
        userApiService = Apis.createApiService(UserApiService.class);
    }

    @Test
    public void add() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("测试个人权限priiii好久好久好久环境");
//        userDTO.setTitle("测试");
        userDTO.setMobile("13588200632");
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
        userDTO.setUid("101010012254689");
//        userDTO.setPrivilege("mydeptonly");
        OpenApiResult<Map<String, String>> result = userApiService.update(context, userDTO);
        System.out.println(result);
        System.out.println(result.getData());
    }

    @Test
    public void detail() {
        OpenApiResult<Map<String, UserInfoDTO>> result = userApiService.detail(context, "101010012254689", 0L);
        System.out.println(result);
        System.out.println(result.getData().get("user").getWorkPhone());
    }

    @Test
    public void getUserInfo() throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("userId", "userId1");
        OpenApiResult<UserDTO> result = userApiService.getUserInfo(context, map);
        System.out.println(result);
    }

    @Test
    public void getUserInfoByMobile(){
        OpenApiResult result = userApiService.getUserInfoByMobile(context, "13588200631");
        System.out.println(result);
    }

    @Test
    public void getUserInfoByUid() {
        OpenApiResult result = userApiService.getUserInfoByUid(context, "101010012129489");
        System.out.println(result);
    }

    @Test
    public void getUidByMobile(){
        OpenApiResult result = userApiService.getUidByMobile(context, "13588200631");
        System.out.println(result);
    }

    @Test
    public void deptList(){
        ApiContext context = ApiContext.ctx(orgSecret);
        // context = ApiContext.ctx(orgSecret, uid, name);
        OpenApiResult result = userApiService.deptList(context, "126468488");
        System.out.println(result);
    }

}
