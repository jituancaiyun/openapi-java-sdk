package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.OpenApiClient;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.Jsons;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.MemberUser;
import com.shinemo.openapi.client.dto.schedule.ScheduleDetail;
import com.shinemo.openapi.client.dto.schedule.ScheduleShareInfo;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ScheduleApiServiceTest {

    private ScheduleApiService service;
    private OpenApiClient client;
    private String orgSecret = "AQB3AQAAAAAAAKlMAQAAAAAA";
    private String uid = "13588200631";//"101010011894152";//
    private String name = "yuanjian";
    private ApiContext context;

    @Before
    public void setUp() throws Exception {
        Apis.setEnv(1);
        client = Apis.createClient();
        context = ApiContext.ctx(orgSecret, uid, new String(name.getBytes(), "ISO8859-1"));
        service = client.createApiService(ScheduleApiService.class);
    }

    @Test
    public void add() {
        long now = System.currentTimeMillis();
        ScheduleDetail detail = new ScheduleDetail();
        detail.setBegintime(now + 3 * 60 * 60 * 1000);
        detail.setEndtime(detail.getBegintime() + 1 * 60 * 60 * 1000);
        detail.setContent("测试日程");
        ArrayList<Long> warnTimes = new ArrayList<Long>();
        warnTimes.add(detail.getBegintime() - 1 * 60 * 60 * 1000);
        detail.setWarntime(warnTimes);
        detail.setMembers(new ArrayList<MemberUser>());
        detail.setStraddr("地点");
        detail.setStrdescrip("日程描述");
        System.out.println(Jsons.toJson(detail));
        OpenApiResult<Long> result = service.add(context, detail);
        System.out.println(result);
    }

    @Test
    public void update() {
        long scheduleId = 11648L;
        long now = System.currentTimeMillis();
        ScheduleDetail detail = new ScheduleDetail();
        detail.setBegintime(now + 3 * 60 * 60 * 1000);
        detail.setEndtime(detail.getBegintime() + 1 * 60 * 60 * 1000);
        detail.setContent("测试日程-更新");
        ArrayList<Long> warnTimes = new ArrayList<Long>();
        warnTimes.add(detail.getBegintime() - 1 * 60 * 60 * 1000);
        detail.setWarntime(warnTimes);
        detail.setStrdescrip("日程描述-更新");
        OpenApiResult<Void> result = service.update(context, scheduleId, detail);
        System.out.println(result);
    }

    @Test
    public void delete() {
        long scheduleId = 11648L;
        OpenApiResult<Void> result = service.delete(context, scheduleId);
        System.out.println(result);
    }

    @Test
    public void detail() {
//        11648
        OpenApiResult<ScheduleShareInfo> result = service.detail(context, 11649);
        System.out.println(result);
    }
}