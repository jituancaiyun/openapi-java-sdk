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
import com.shinemo.openapi.client.dto.personalremind.PersonalRemindDTO;
import com.shinemo.openapi.client.dto.personalremind.PersonalRemindInfoDTO;
import com.shinemo.openapi.client.dto.personalremind.RFrequency;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by ohun on 2017/4/11.
 *
 * @author ohun@live.cn (夜色)
 */
public class PersonalRemindApiServiceTest {

    private PersonalRemindApiService personalRemindApiService;
    private OpenApiClient client;
    private String orgId = "84057";//"84057";
    private String uid = "101010012129489";//"101010011894152";//"101010012129489";
    private String name = "yuanjian";
    private ApiContext context;

    @Before
    public void setUp() throws Exception {
        Apis.setEnv(1);
        client = Apis.createClient();
        context = ApiContext.ctx(orgId, uid, name);
        personalRemindApiService = client.createApiService(PersonalRemindApiService.class);
    }

    @Test
    public void create() throws Exception {
        PersonalRemindDTO personalRemind = new PersonalRemindDTO();
        personalRemind.setContent("测试每天提醒***" + new Date());
        personalRemind.setRemindType(1);
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String remindTime = sdf.format(new Date(new Date().getTime() + 1000 * 60 * 2));*/

        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        long longDate = new Date().getTime() + 1000 * 60 * 30;
        personalRemind.setRemindTime(longDate);
        String remindTime = sdf.format(new Date(longDate));

        RFrequency rFrequency = new RFrequency();
        rFrequency.setType(1);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        rFrequency.setRemindTime("1-"+sdf.format(new Date(new Date().getTime() + 10 * 60 * 1000)));
        personalRemind.setRfrequency(rFrequency);
        personalRemind.setIsVoiceRemind(false);

        OpenApiResult<Map<String, Long>> result = personalRemindApiService.create(context, personalRemind);
        System.out.println(result);
    }

    @Test
    public void update() {
        PersonalRemindDTO personalRemind = new PersonalRemindDTO();
        personalRemind.setContent("已更新--测试" + new Date());
        personalRemind.setRemindType(1);
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String remindTime = sdf.format(new Date(new Date().getTime() + 1000 * 60 * 2));*/

        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        long longDate = new Date().getTime() + 1000 * 60 * 10;
        personalRemind.setRemindTime(longDate);
        String remindTime = sdf.format(new Date(longDate));

        RFrequency rFrequency = new RFrequency();
        rFrequency.setType(5);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        rFrequency.setRemindTime(sdf2.format(new Date(new Date().getTime() + 10 * 60 * 1000)));
        personalRemind.setRfrequency(rFrequency);
        personalRemind.setIsVoiceRemind(false);
        long personalRemindId = 17478L;
        OpenApiResult<Map<String, Long>> result = personalRemindApiService.update(context, personalRemindId, personalRemind);
        System.out.println(result);
    }

    @Test
    public void detail() {
        long personalRemindId = 17478;
        OpenApiResult<PersonalRemindInfoDTO> result = personalRemindApiService.detail(context, personalRemindId);
        System.out.println(result);
    }

    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = sdf.format(new Date());
//        System.out.println(time.split(" ")[1].replaceAll(":",""));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置开始提醒的时间
        System.out.println(sdf.parse("2017-05-22 16:23:32").getTime());
    }

    @Test
    public void deletePersonalRemind() {
        long personalRemindId = 17297L;
        OpenApiResult<?> result = personalRemindApiService.delete(context, personalRemindId);
        System.out.println(result);
    }

}
