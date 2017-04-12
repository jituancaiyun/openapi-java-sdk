package com.shinemo.openapi.client;

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
public class ContactApiTest {

    private ContactApiService contactApiService;

    @Before
    public void setUp() throws Exception {
        contactApiService = Apis.createApiService(ContactApiService.class);
    }

    @Test
    public void getDeptUsers() throws Exception {
        OpenApiResult<ContactDTO> result = contactApiService.listUsers("0", 1);
        System.out.println(result);
    }

    @Test
    public void createUser() throws Exception {
        ContactUserDTO userDTO = new ContactUserDTO();
        userDTO.setName("xxxxx");
        userDTO.setDeptId(1L);
        userDTO.setMobile("13600530623");

        OpenApiResult<UidDTO> result = contactApiService.createUser("0", userDTO);
        System.out.println(result);
    }
}