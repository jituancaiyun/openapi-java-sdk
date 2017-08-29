package com.shinemo.openapi.client.service;

import com.google.gson.Gson;
import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.OpenApiClient;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.maillist.DeptInfoDTO;
import com.shinemo.openapi.client.dto.maillist.UserInfoDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by yuanjian on 6/5/17.
 */
public class DepartmentServiceTest {

    private DepartmentApiService departmentApiService;
    private OpenApiClient client;
    private String orgId = "AQDaAAAAAAAAAKlMAQAAAAAA";
    private String uid = "101010011894152";//"101010012129489";//
    private String name = "yuanjian";
    private ApiContext context;

    public enum RemindType {
        APP_SEND(0, "app推送"), APPANDSMS_SEND(1, "APP+sms短信发送");

        private final int type;
        private final String desc;

        RemindType(int type, String desc) {
            this.type = type;
            this.desc = desc;
        }

        public int getType() {
            return type;
        }

        public String getDesc() {
            return desc;
        }
    }

    @Before
    public void setUp() throws Exception {
        Apis.setEnv(1);
        client = Apis.createClient();
        context = ApiContext.ctx(orgId, uid, name);
        departmentApiService = client.createApiService(DepartmentApiService.class);
    }

    @Test
    public void createDept() {
        DeptInfoDTO infoDto = new DeptInfoDTO();
        infoDto.setName("不闷");
        infoDto.setParentId(0L);
        infoDto.setOrder(1);

        OpenApiResult<Map<String, Long>> result = departmentApiService.create(context, infoDto);
        System.out.println(result);
    }

    @Test
    public void delete() {
        OpenApiResult<Long> result = departmentApiService.delete(context, 16L);
        System.out.println(result);
        System.out.println(result.getData());
        Gson gson = new Gson();
        System.out.println(gson.toJson(result));
    }

    @Test
    public void updateDept() {
        DeptInfoDTO infoDto = new DeptInfoDTO();
        infoDto.setName("部门13-new");
//        infoDto.setDeptId(19L);
//        infoDto.setParentId(14L);
//        infoDto.setOrder(1);

        OpenApiResult<Long> result = departmentApiService.update(context, infoDto);
        System.out.println(result);
    }

    @Test
    public void deptList() {
        OpenApiResult<Map<String, List<DeptInfoDTO>>> result = departmentApiService.deptList(context, 0L);
        System.out.println(result);
        System.out.println(result.getData());
        Gson gson = new Gson();
        System.out.println(gson.toJson(result));
    }

    @Test
    public void detail() {
        OpenApiResult<Map<String, DeptInfoDTO>> result = departmentApiService.detail(context, 0L);
        System.out.println(result);
        System.out.println(result.getData());
        Gson gson = new Gson();
        System.out.println(gson.toJson(result));
    }

    @Test
    public void list() {
        OpenApiResult<Map<String, List<UserInfoDTO>>> result = departmentApiService.userList(context, 0L);
        System.out.println(result);
//        result.getData().get("users").get(0).getWorkPhone();
    }

    @Test
    public void listAll() {
        OpenApiResult<Map<String, List<UserInfoDTO>>> result = departmentApiService.userListAll(context, 1L);
        System.out.println(result);
        result.getData().get("users").get(0).getWorkPhone();
    }

}
