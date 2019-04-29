package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.Constants;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.notice.NoticeDTO;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NoticeApiServiceTest {

    private NoticeApiService noticeApiService;
    private String orgSecret = Constants.OrgSecret.DAILY_SECRET.orgSecret;
    private String uid = "13588200631";//"101010012129489";//
    private String name = "yuanjian";
    private ApiContext context;

    @Before
    public void setUp() throws Exception {
        Apis.setEnv(1);
        context = ApiContext.ctx(orgSecret, uid, name);
        noticeApiService = Apis.createApiService(NoticeApiService.class);
    }

    @Test
    public void publish() throws Exception {
        NoticeDTO noticeDTO = new NoticeDTO();
        noticeDTO.setContent("公告内容。");
        noticeDTO.setAllSend(true);
        noticeDTO.setTitle("公告标题");
        noticeDTO.setImgUrl("https://public-file-qn.jituancaiyun.com/409aaa8f-ef90-42fd-aa40-6c3eff532177");
        OpenApiResult result = noticeApiService.publish(context, noticeDTO);
        System.out.println(result);
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void list() throws Exception {
        String time = "2017-12-31 21:12:12";
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
        OpenApiResult result = noticeApiService.list(context, date.getTime());
        System.out.println(result);
    }

}