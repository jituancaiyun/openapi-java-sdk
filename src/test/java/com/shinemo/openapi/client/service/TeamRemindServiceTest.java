package com.shinemo.openapi.client.service;

import com.google.gson.Gson;
import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.OpenApiClient;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.MemberUser;
import com.shinemo.openapi.client.dto.meeting.MeetingInviteDetailDTO;
import com.shinemo.openapi.client.dto.meeting.MeetingInviteInfoDTO;
import com.shinemo.openapi.client.dto.teamremind.TeamRemindDetailDTO;
import com.shinemo.openapi.client.dto.teamremind.TeamRemindInfoDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Created by yuanjian on 6/5/17.
 */
public class TeamRemindServiceTest {

    private TeamRemindApiService teamRemindApiService;
    private OpenApiClient client;
    private String orgSecret = "AQB3AQAAAAAAAKlMAQAAAAAA";
    private String uid = "101010012129489";//"101010011768832";//
    private String name = "刘远剑";
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
        context = ApiContext.ctx(orgSecret, uid, name);
        /*context = new ApiContext();
        context.setName(name);
        context.setUid(uid);*/
        teamRemindApiService = client.createApiService(TeamRemindApiService.class);
    }

    @Test
    public void createTeamRemind() {

        TeamRemindDetailDTO detail = new TeamRemindDetailDTO();
//        detail.setIsVoiceRemind(true);
        detail.setContent("团队提醒内容。");
//        detail.setRemindTime(System.currentTimeMillis() + 100 * 60 * 1000);
        detail.setRemindType(MeetingInviteServiceTest.RemindType.APPANDSMS_SEND.getType());
        String[] uids = {"101010012129489","271000"};
        String[] names = {"j2","j3"};
        ArrayList<MemberUser> list = new ArrayList<MemberUser>();
        for (int i = 0; i < uids.length; i++) {
            MemberUser memberUser = new MemberUser();
            memberUser.setUid(uids[i]);
            memberUser.setName(names[i]);
            list.add(memberUser);
        }
        detail.setMembers(list);
        detail.setTimingSend(false);
        OpenApiResult<Map<String, Long>> result = teamRemindApiService.create(context, detail);
        System.out.println(result);
    }

    @Test
    public void updateTeamRemind() {

        TeamRemindDetailDTO detail = new TeamRemindDetailDTO();
        detail.setContent("团队提醒内容-更新。");
        detail.setRemindTime(new Date().getTime() + 2 * 60 * 1000);
        detail.setRemindType(MeetingInviteServiceTest.RemindType.APPANDSMS_SEND.getType());
        String[] uids = {"101010011894152", "101010011768832"};
        String[] names = {"j2", "y3", "y4"};
        ArrayList<MemberUser> list = new ArrayList<MemberUser>();
        for (int i = 0; i < uids.length; i++) {
            MemberUser memberUser = new MemberUser();
            memberUser.setUid(uids[i]);
            memberUser.setName(names[i]);
            list.add(memberUser);
        }
        detail.setMembers(list);
        OpenApiResult<Long> result = teamRemindApiService.update(context, 58397L, detail);
        System.out.println(result);
    }

    @Test
    public void detail() {
        OpenApiResult<TeamRemindInfoDTO> result = teamRemindApiService.detail(context, 60468L);
        System.out.println(result);
        System.out.println(result.getData().getCreator().getIsDelete());
        System.out.println(result.getData().getDetail().getMembers());
        System.out.println(result.getData().getDetail().getIsVoiceRemind());
    }

    @Test
    public void cancel() {
        OpenApiResult<Long> result = teamRemindApiService.cancel(context, 58409L);
        System.out.println(result);
        System.out.println(result.getData());
    }

    /**
     * 某用户删除，不影响其他用户
     */
    @Test
    public void delete() {
        OpenApiResult<Long> result = teamRemindApiService.delete(context, 58403L);
        System.out.println(result);
        System.out.println(result.getData());
    }

}
