/*
 * (C) Copyright 2015-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     ohun@live.cn (夜色)
 */

package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.OpenApiClient;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.MemberUser;
import com.shinemo.openapi.client.dto.TeamRemindInfo;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Created by ohun on 2017/4/11.
 *
 * @author ohun@live.cn (夜色)
 */
public class MatterNoticeApiServiceTest {

    private MatterNoticeApiService matterNoticeApiService;
    private OpenApiClient client;
    private String orgId = "84057";
    private String uid = "101010012129489";
    private String name = "yuanjian";
    private ApiContext context;

    public enum RemindType{
        APP_SEND(0,"app推送"), APPANDSMS_SEND(1,"APP+sms短信发送");

        private final int type;
        private final String desc;
        RemindType(int type,String desc){
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
        matterNoticeApiService = client.createApiService(MatterNoticeApiService.class);
    }

    @Test
    public void createMatterNotice() throws Exception {
        TeamRemindInfo teamRemindInfo = new TeamRemindInfo();
        TeamRemindInfo.TeamRemindDetail teamRemindDetail = teamRemindInfo.new TeamRemindDetail();
        teamRemindDetail.setContent("测试事项告知，"+new Date());
        teamRemindDetail.setRemindType(RemindType.APP_SEND.getType());
        teamRemindDetail.setRemindTime(new Date().getTime() + 1000*60*10);
        teamRemindDetail.setIsVoiceRemind(false);
        String[] receivers = {"101010012129489","101010011894152"};//
        ArrayList<MemberUser> list = new ArrayList<MemberUser>();
        for (int i=0;i<receivers.length;i++){
            MemberUser memberUser = new MemberUser();
            memberUser.setUid(receivers[i]);
            memberUser.setName("yuanjian"+i);
            list.add(memberUser);
        }
        teamRemindDetail.setMembers(list);

        OpenApiResult<Map<String, Long>> result = matterNoticeApiService.create(context,teamRemindDetail);
        System.out.println(result);
    }

    @Test
    public void updateMatterNotice() {
        TeamRemindInfo teamRemindInfo = new TeamRemindInfo();
        TeamRemindInfo.TeamRemindDetail teamRemindDetail = teamRemindInfo.new TeamRemindDetail();
        teamRemindDetail.setContent("====测试更新事项告知===，"+new Date());
        teamRemindDetail.setRemindType(RemindType.APP_SEND.getType());
        teamRemindDetail.setRemindTime(new Date().getTime() + 1000*60*10);
        teamRemindDetail.setIsVoiceRemind(false);
        String[] receivers = {"101010011894152"};//"101010012129489",
        ArrayList<MemberUser> list = new ArrayList<MemberUser>();
        for (int i=0;i<receivers.length;i++){
            MemberUser memberUser = new MemberUser();
            memberUser.setUid(receivers[i]);
            memberUser.setName("yuanjian"+i);
            list.add(memberUser);
        }
        teamRemindDetail.setMembers(list);
        long noticeId = 58292L;
        OpenApiResult<Long> result = matterNoticeApiService.update(context,noticeId,teamRemindDetail);
        System.out.println(result);
    }

    @Test
    public void getMatterNoticeDetail() {
        long personalRemindId = 58291L;
        OpenApiResult<TeamRemindInfo> result = matterNoticeApiService.detail(context,personalRemindId);
        System.out.println(result);
    }

    @Test
    public void cancelMatterNotice() {
        long personalRemindId = 58291L;
        OpenApiResult<Long> result = matterNoticeApiService.cancel(context,personalRemindId);
        System.out.println(result);
    }

    @Test
    public void deleteMatterNotice() {
        long personalRemindId = 58292L;
        OpenApiResult<Long> result = matterNoticeApiService.delete(context,personalRemindId);
        System.out.println(result);
    }

    @Test
    public void openMatterNotice() {
        long personalRemindId = 58291L;
        OpenApiResult<Long> result = matterNoticeApiService.open(context,personalRemindId);
        System.out.println(result);
    }

    @Test
    public void closeMatterNotice() {
        long personalRemindId = 58291L;
        OpenApiResult<Long> result = matterNoticeApiService.close(context,personalRemindId);
        System.out.println(result);
    }

    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = sdf.format(new Date());
//        System.out.println(time.split(" ")[1].replaceAll(":",""));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置开始提醒的时间
        System.out.println(sdf.parse("2016-05-03 16:23:32").getTime());
    }

}
