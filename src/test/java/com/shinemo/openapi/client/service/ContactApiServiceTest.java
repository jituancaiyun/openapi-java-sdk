package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.ContactDTO;
import com.shinemo.openapi.client.dto.ContactUserDTO;
import com.shinemo.openapi.client.dto.UidDTO;
import com.shinemo.openapi.client.service.ContactApiService;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ohun on 2017/3/23.
 *
 * @author ohun@live.cn (夜色)
 */
public class ContactApiServiceTest {

    private ContactApiService contactApiService;

    @Before
    public void setUp() throws Exception {
        System.out.println("==============");
        contactApiService = Apis.createApiService(ContactApiService.class);
    }

    @Test
    public void getDeptUsers() throws Exception {
        OpenApiResult<ContactDTO> result = contactApiService.listUsers(ApiContext.ctx("57171554250"), 440402);
        System.out.println(result);
    }

    @Test
    public void createUser() throws Exception {
        ContactUserDTO userDTO = new ContactUserDTO();
        userDTO.setName("xxxxx");
        userDTO.setDeptId(1L);
        userDTO.setMobile("13600530623");

        OpenApiResult<UidDTO> result = contactApiService.createUser(ApiContext.ctx("57171554250"), userDTO);
        System.out.println(result);
    }
}