package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.Constants;
import com.shinemo.openapi.client.common.ApiContext;
import org.junit.Before;
import org.junit.Test;

public class WorkTraceApiServiceTest {
    private WorkTraceApiService workTraceApiService;
    private String orgSecret = Constants.OrgSecret.DAILY_SECRET.orgSecret;//"AQB3AQAAAAAAAKlMAQAAAAAA";
//    private String orgSecret = "AQB3AQAAAAAAAKlMAQAAAAAA";//"AQB3AQAAAAAAAKlMAQAAAAAA";
    private ApiContext context;

    @Before
    public void setUp() throws Exception {
//        Apis.setEnv(1);
        Apis.setEnv(1);
        context = ApiContext.ctx(orgSecret);
        // context = ApiContext.ctx(orgSecret, uid, name);
        workTraceApiService = Apis.createApiService(WorkTraceApiService.class);
    }

    @Test
    public void trackList() throws Exception {
        System.out.println(workTraceApiService.trackList(context, System.currentTimeMillis() - 24 * 60 * 60 * 1000, System.currentTimeMillis(), 1, 2));
    }

    @Test
    public void queryByUid() throws Exception {
        System.out.println(workTraceApiService.queryByMobile(context, "13588200631", System.currentTimeMillis() - 30L * 24 * 60 * 60 * 1000, System.currentTimeMillis(), 1, 1));
    }

    @Test
    public void queryIngByUid() throws Exception {
        System.out.println(workTraceApiService.queryIngByMobile(context, "13588200631"));
    }

}