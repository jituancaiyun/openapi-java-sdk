package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.OpenApiClient;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.Jsons;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.MemberUser;
import com.shinemo.openapi.client.dto.personalremind.RFrequency;
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
        */
        context.setUid("13588200631");
        teamRemindApiService = client.createApiService(TeamRemindApiService.class);
    }

    @Test
    public void createTeamRemind() {

        TeamRemindDetailDTO detail = new TeamRemindDetailDTO();
//        detail.setIsVoiceRemind(true);
        detail.setContent("测试通知type。");
        detail.setRemindTime(System.currentTimeMillis() + 10 * 1000);//
//        detail.setRemindTime(System.currentTimeMillis() + 100 * 60 * 1000);//
        detail.setRemindType(MeetingInviteServiceTest.RemindType.APP_SEND.getType());
        RFrequency rFrequency = new RFrequency();
        rFrequency.setType(1);
        rFrequency.setRemindTime("0-120000");
        detail.setRfrequency(rFrequency);
        String[] uids = {"13588200631", "13588200632"};
        String[] names = {"j2", "j3"};
        ArrayList<MemberUser> list = new ArrayList<MemberUser>();
        for (int i = 0; i < uids.length; i++) {
            MemberUser memberUser = new MemberUser();
            memberUser.setUid(uids[i]);
            memberUser.setName(names[i]);
            list.add(memberUser);
        }
        detail.setMembers(list);
        detail.setTimingSend(false);
        context.put("flags", "1");
        System.out.println(Jsons.toJson(detail));
        OpenApiResult<Map<String, Long>> result = teamRemindApiService.create(context, detail);
        System.out.println(result);
    }

    @Test
    public void updateTeamRemind() {

        TeamRemindDetailDTO detail = new TeamRemindDetailDTO();
        detail.setContent("团队提醒内容-更新。");
        detail.setRemindTime(new Date().getTime() +  10 * 1000);
//        detail.setRemindTime(new Date().getTime() + 2 * 60 * 1000);
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
        OpenApiResult<Void> result = teamRemindApiService.update(context, 60471L, detail);
        System.out.println(result);
    }

    @Test
    public void detail() { // status: 取消2，正常0
        context.put("flags", "1");
        OpenApiResult<TeamRemindInfoDTO> result = teamRemindApiService.detail(context, 61306L);
        System.out.println(result);
        System.out.println(result.getData().getCreator().getIsDelete());
        System.out.println(result.getData().getDetail().getMembers());
        System.out.println(result.getData().getDetail().getIsVoiceRemind());
    }

    @Test
    public void cancel() {
        context.put("flags", "1");
        OpenApiResult<Void> result = teamRemindApiService.cancel(context, 6130L);
        System.out.println(result);
        System.out.println(result.getData());
    }

    @Test
    public void revoke() {
        context.put("flags", "1");
        OpenApiResult<Void> result = teamRemindApiService.revoke(context, 61306L);
        System.out.println(result);
        System.out.println(result.getData());
    }

    /**
     * 某用户删除，不影响其他用户
     */
    @Test
    public void delete() {
        OpenApiResult<Void> result = teamRemindApiService.delete(context, 61297L);
        System.out.println(result);
        System.out.println(result.getData());
    }

}
