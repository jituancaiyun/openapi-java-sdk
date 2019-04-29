package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.OpenApiClient;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.Jsons;
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
    private String orgSecret = "AQB3AQAAAAAAAKlMAQAAAAAA";
    private String uid = "101010011894152";//"101010011894152";//
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
        context = ApiContext.ctx(orgSecret, uid, new String(name.getBytes(),"ISO8859-1"));
        meetingApiService = client.createApiService(MeetingApiService.class);
    }

    @Test
    public void createMeeting() {
        context.setUid("13588200632");
        context.put("flags", "1");
        MeetingInviteDetailDTO detail = new MeetingInviteDetailDTO();
        detail.setAddress("...");
        detail.setBeginTime(new Date().getTime() + 30 * 60 * 1000);
        detail.setEndTime(new Date().getTime() + 30 * 60 * 1000 + 30 * 60 * 1000);
        detail.setRemindMin(29);
        detail.setContent("测试会议type...");
//        detail.setRoomAddrId(1);
//        detail.setRemindType(RemindType.APPANDSMS_SEND.getType());
        String[] uids = {"13588200631", "13588200632"};
        String[] names = {"y1", "j2"};
        ArrayList<MemberUser> list = new ArrayList<MemberUser>();
        for (int i = 0; i < uids.length; i++) {
            MemberUser memberUser = new MemberUser();
            memberUser.setUid(uids[i]);
            memberUser.setName(names[i]);
            list.add(memberUser);
        }
        detail.setMembers(list);
        System.out.println(Jsons.toJson(detail));
        OpenApiResult<Map<String, Long>> result = meetingApiService.create(context, detail);
//        System.out.println(result);
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
        OpenApiResult<Void> result = meetingApiService.update(context,12836L, detail);
        System.out.println(result);
    }

    @Test
    public void detail() {
        context.setUid("13588200631");
        context.put("flags", "1");
        OpenApiResult<MeetingInviteInfoDTO> result = meetingApiService.detail(context, 18955L);
        System.out.println(result);
        System.out.println(result.getData().getCreator().getUid());
        System.out.println(result.getData().getDetail().getMembers());
        System.out.println(result.getData());
    }

    //{"status":0,"data":{"creator":{"uid":"101010012129489","name":"yuanjian","isRemind":true,"isDelete":false,"isBindingMail":false},"status":0,"detail":{"content":"测试会议删除...","voiceLength":0,"address":"...","beginTime":1543458721462,"remindMin":29,"endTime":1543460521462,"createTime":1543456866923,"remindType":0,"members":[{"uid":"101010012129489","name":"y1","status":0,"isRemind":true,"reply":"","gmtReply":"","isDelete":false,"isBindingMail":false},{"uid":"101010012254689","name":"j2","status":0,"isRemind":true,"reply":"","gmtReply":"","isDelete":false,"isBindingMail":false}],"isPushMail":false,"comments":0,"signs":0,"isVoiceRemind":false,"meetingRoomId":0,"roomOrgId":0,"roomAddrId":0,"meetRoomApproveStatus":-1,"bmeetneed":false,"bleaveopen":false,"orgId":85161,"isPermitOtherSign":0},"signModel":0,"isSign":false,"remindAgainTime":0}}

    @Test
    public void cancel() {
        OpenApiResult<Void> result = meetingApiService.cancel(context, 12925L);
        System.out.println(result);
        System.out.println(result.getData());
    }

    /**
     * 某用户删除，不影响其他用户
     */
    @Test
    public void delete() {
        context.setUid("13588200631");
        context.put("flags", "1");
//        MeetingInviteDTO meetingInviteDTO = new MeetingInviteDTO();
//        meetingInviteDTO.setMeetingInviteId(18952L);
//        meetingInviteDTO.setRequesterUid("101010012129489");
//        OpenApiResult<Long> result = meetingApiService.deleteMeeting(context,meetingInviteDTO);
        OpenApiResult<Void> result = meetingApiService.delete(context, 18956L);
        System.out.println(result);
//        System.out.println(result.getData());
    }

}
