package com.shinemo.openapi.client.service;

import com.google.gson.Gson;
import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.OpenApiClient;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.MeetingInviteDTO;
import com.shinemo.openapi.client.dto.MemberUser;
import com.shinemo.openapi.client.dto.meeting.MeetingInviteDetailDTO;
import com.shinemo.openapi.client.dto.meeting.MeetingInviteInfoDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Created by yuanjian on 6/5/17.
 */
public class MeetingInviteServiceTest {

    private MeetingApiService meetingApiService;
    private OpenApiClient client;
    private String orgId = "84057";
    private String uid = "101010012129489";//"101010011894152";//
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
        Apis.setEnv(0);
        client = Apis.createClient();
        context = ApiContext.ctx(orgId, uid, new String(name.getBytes(),"ISO8859-1"));
        meetingApiService = client.createApiService(MeetingApiService.class);
    }

    @Test
    public void createMeeting() {
        MeetingInviteDetailDTO detail = new MeetingInviteDetailDTO();
        detail.setAddress("小会议室");
        detail.setBeginTime(new Date().getTime() + 30 * 60 * 1000);
        detail.setEndTime(new Date().getTime() + 30 * 60 * 1000 + 30 * 60 * 1000);
        detail.setRemindMin(29);
        detail.setContent("会议内容");
//        detail.setRemindType(RemindType.APPANDSMS_SEND.getType());
        String[] uids = {"101010012129489", "101010011894152"};
        String[] names = {"y1", "j2"};
        ArrayList<MemberUser> list = new ArrayList<MemberUser>();
        for (int i = 0; i < uids.length; i++) {
            MemberUser memberUser = new MemberUser();
            memberUser.setUid(uids[i]);
            memberUser.setName(names[i]);
            list.add(memberUser);
        }
        detail.setMembers(list);
        OpenApiResult<Map<String, Long>> result = meetingApiService.create(context, detail);
        System.out.println(result);
    }

    @Test
    public void updateMeeting() {
        MeetingInviteDetailDTO detail = new MeetingInviteDetailDTO();
        detail.setAddress("小会议室");
        detail.setBeginTime(new Date().getTime() + 30 * 60 * 1000);
        detail.setEndTime(new Date().getTime() + 30 * 60 * 1000 + 30 * 60 * 1000);
        detail.setRemindMin(29);
        detail.setContent("会议内容-已更新2");
        detail.setRemindType(RemindType.APPANDSMS_SEND.getType());
        String[] uids = {"101010012129489", "101010011894152"};
        String[] names = {"y1", "j2"};
        ArrayList<MemberUser> list = new ArrayList<MemberUser>();
        for (int i = 0; i < uids.length; i++) {
            MemberUser memberUser = new MemberUser();
            memberUser.setUid(uids[i]);
            memberUser.setName(names[i]);
            list.add(memberUser);
        }
        detail.setMembers(list);
        OpenApiResult<Long> result = meetingApiService.update(context,12836L, detail);
        System.out.println(result);
    }

    @Test
    public void detail() {
        OpenApiResult<MeetingInviteInfoDTO> result = meetingApiService.detail(context, 12925L);
        System.out.println(result);
        System.out.println(result.getData());
    }

    @Test
    public void cancel() {
        OpenApiResult<Long> result = meetingApiService.cancel(context, 12925L);
        System.out.println(result);
        System.out.println(result.getData());
    }

    /**
     * 某用户删除，不影响其他用户
     */
    @Test
    public void delete() {
        MeetingInviteDTO meetingInviteDTO = new MeetingInviteDTO();
        meetingInviteDTO.setMeetingInviteId(12925L);
        meetingInviteDTO.setRequesterUid("101010012129489");
//        OpenApiResult<Long> result = meetingApiService.deleteMeeting(context,meetingInviteDTO);
        OpenApiResult<Long> result = meetingApiService.delete(context, 12839L);
        System.out.println(result);
//        System.out.println(result.getData());
    }

}
