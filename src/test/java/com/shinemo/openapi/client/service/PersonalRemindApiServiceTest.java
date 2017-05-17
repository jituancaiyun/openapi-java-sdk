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
import com.shinemo.openapi.client.dto.PersonalRemindDTO;
import com.shinemo.openapi.client.dto.PushMessageDTO;
import com.shinemo.openapi.client.dto.message.IMessage;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by ohun on 2017/4/11.
 *
 * @author ohun@live.cn (夜色)
 */
public class PersonalRemindApiServiceTest {

    private PersonalRemindApiService personalRemindApiService;
    private OpenApiClient client;
    private String orgId = "85161";
    private String uid = "101010012129489";
    private String name = "yuanjian";
    private ApiContext context;

    @Before
    public void setUp() throws Exception {
        client = Apis.createClient();
        context = ApiContext.ctx(orgId, uid, name);
        personalRemindApiService = client.createApiService(PersonalRemindApiService.class);
    }

    @Test
    public void createPersonalRemind() throws Exception {
        PersonalRemindDTO personalRemindDTO = new PersonalRemindDTO();
        PersonalRemindDTO.PersonalRemind personalRemind = personalRemindDTO.new PersonalRemind();
        personalRemind.setContent("测试每天提醒=====2"+new Date());
        personalRemind.setRemindType(1);
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String remindTime = sdf.format(new Date(new Date().getTime() + 1000 * 60 * 2));*/

        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        long longDate = new Date().getTime() + 1000 * 60 * 10;
//        personalRemind.setRemindTime(longDate);
        String remindTime = sdf.format(new Date(longDate));

        PersonalRemindDTO.RFrequency rFrequency = personalRemindDTO.new RFrequency();
        rFrequency.setType(2);
        rFrequency.setRemindTime("1-"+remindTime);
        personalRemind.setRfrequency(rFrequency);
        personalRemind.setIsVoiceRemind(false);

        OpenApiResult<?> result = personalRemindApiService.create(context, personalRemind);
        System.out.println(result);
    }

    @Test
    public void updatePersonalRemind() {
        PersonalRemindDTO personalRemindDTO = new PersonalRemindDTO();
        PersonalRemindDTO.PersonalRemind personalRemind = personalRemindDTO.new PersonalRemind();
        personalRemind.setContent("测试更新个人提醒-content-提醒已更新=========");
        personalRemind.setRemindType(1);
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long longDate = new Date().getTime() + 1000 * 60 * 2;
        personalRemind.setRemindTime(longDate);
        String remindTime = sdf.format(new Date(longDate));*/

        /*SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        long longDate = new Date().getTime() + 1000 * 60 * 2;
        personalRemind.setRemindTime(longDate);
        String remindTime = sdf.format(new Date(longDate));*/
        String remindTime = "";
        PersonalRemindDTO.RFrequency rFrequency = personalRemindDTO.new RFrequency();
        rFrequency.setType(1);
        rFrequency.setRemindTime(remindTime);
        personalRemind.setRfrequency(rFrequency);
        personalRemind.setIsVoiceRemind(false);
        long personalRemindId = 17288;
        OpenApiResult<?> result = personalRemindApiService.update(context, personalRemindId, personalRemind);
        System.out.println(result);
    }

    @Test
    public void getPersonalRemindDetail() {
        long personalRemindId = 17303L;
        OpenApiResult<PersonalRemindDTO> result = personalRemindApiService.detail(context, personalRemindId);
        System.out.println(result.getData().getPersonalRemind().getRfrequency());
        System.out.println(result.getData().getPersonalRemind());
    }

    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = sdf.format(new Date());
//        System.out.println(time.split(" ")[1].replaceAll(":",""));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置开始提醒的时间
        System.out.println(sdf.parse("2016-05-03 16:23:32").getTime());
    }

    @Test
    public void deletePersonalRemind() {
        long personalRemindId = 17297L;
        OpenApiResult<?> result = personalRemindApiService.delete(context, personalRemindId);
        System.out.println(result);
    }

}
