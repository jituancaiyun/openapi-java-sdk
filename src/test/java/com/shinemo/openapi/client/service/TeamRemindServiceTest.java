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
    private String orgId = "84057";
    private String uid = "101010011768832";//"101010012129489";//
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
        /*context = new ApiContext();
        context.setName(name);
        context.setUid(uid);*/
        teamRemindApiService = client.createApiService(TeamRemindApiService.class);
    }

    @Test
    public void createTeamRemind() {

        TeamRemindDetailDTO detail = new TeamRemindDetailDTO();
        detail.setContent("团队提醒内容。");
        detail.setRemindTime(new Date().getTime() + 1 * 60 * 1000);
        detail.setRemindType(MeetingInviteServiceTest.RemindType.APPANDSMS_SEND.getType());
        String[] uids = {"101010011894152","101010011768832"};
        String[] names = {"j2","y3"};
        ArrayList<MemberUser> list = new ArrayList<MemberUser>();
        for (int i = 0; i < uids.length; i++) {
            MemberUser memberUser = new MemberUser();
            memberUser.setUid(uids[i]);
            memberUser.setName(names[i]);
            list.add(memberUser);
        }
        detail.setMembers(list);
        OpenApiResult<Map<String, Long>> result = teamRemindApiService.create(context, detail);
        System.out.println(result);
    }

    @Test
    public void detail() {
        OpenApiResult<TeamRemindInfoDTO> result = teamRemindApiService.detail(context, 58393L);
        System.out.println(result);
        System.out.println(result.getData().getDetail().getMembers());
    }

}
