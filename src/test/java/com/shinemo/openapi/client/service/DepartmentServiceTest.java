package com.shinemo.openapi.client.service;

import com.google.gson.Gson;
import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.OpenApiClient;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.maillist.DeptInfoDTO;
import com.shinemo.openapi.client.dto.maillist.DeptInfoDTO;
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
    private String orgId = "84057";
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
        client = Apis.createClient();
        context = ApiContext.ctx(orgId, uid, name);
        departmentApiService = client.createApiService(DepartmentApiService.class);
    }

    @Test
    public void createDept() {
        DeptInfoDTO infoDto = new DeptInfoDTO();
        infoDto.setName("部门12-child");
        infoDto.setParentId(12L);

        OpenApiResult<Map<String, Long>> result = departmentApiService.create(context, infoDto);
        System.out.println(result);
    }

    @Test
    public void updateDept() {
        DeptInfoDTO infoDto = new DeptInfoDTO();
        infoDto.setName("部门12-child-new");
        infoDto.setDeptId(13L);
        infoDto.setParentId(12L);

        OpenApiResult<Long> result = departmentApiService.update(context, infoDto);
        System.out.println(result);
    }

    @Test
    public void detail() {
        OpenApiResult<DeptInfoDTO> result = departmentApiService.detail(context, 1L);
        System.out.println(result);
        System.out.println(result.getData());
        Gson gson = new Gson();
        System.out.println(gson.toJson(result));
    }

    @Test
    public void deptList() {
        OpenApiResult<List<DeptInfoDTO>> result = departmentApiService.deptList(context, 0L);
        System.out.println(result);
        System.out.println(result.getData());
        Gson gson = new Gson();
        System.out.println(gson.toJson(result));
    }

    @Test
    public void delete() {
        OpenApiResult<Long> result = departmentApiService.delete(context, 13L);
        System.out.println(result);
        System.out.println(result.getData());
        Gson gson = new Gson();
        System.out.println(gson.toJson(result));
    }

}
