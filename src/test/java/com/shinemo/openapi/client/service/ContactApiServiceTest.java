package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.*;
import com.shinemo.openapi.client.service.ContactApiService;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ohun on 2017/3/23.
 *
 * @author ohun@live.cn (夜色)
 */
public class ContactApiServiceTest {

    private ContactApiService contactApiService;

    @Before
    public void setUp() throws Exception {
        Apis.setEnv(1);
        contactApiService = Apis.createApiService(ContactApiService.class);
    }

    @Test
    public void getDeptUsers() throws Exception {
        OpenApiResult<ContactDTO> result = contactApiService.listUsers(ApiContext.ctx("84057"), 1);
        System.out.println(result.getData().getUsers().size());
        System.out.println(result);
    }

    @Test
    public void getDeptUsersAll() throws Exception {
        OpenApiResult<ContactDTO> result = contactApiService.listUsersAll(ApiContext.ctx("83040"), 0);
        System.out.println(result);
//        System.out.println(result);
    }

    @Test
    public void detail() throws Exception {
        OpenApiResult<ContactUserDTO> result = contactApiService.detail(ApiContext.ctx("84057"), 101010012051017L,0);
        System.out.println(result);
    }

    @Test
    public void createUser() throws Exception {
        ContactUserDTO userDTO = new ContactUserDTO();
        userDTO.setName("xxxxx");
        userDTO.setDeptId(0L);
        userDTO.setMobile("13600530626");
        userDTO.setSequence(1);

        OpenApiResult<UidDTO> result = contactApiService.createUser(ApiContext.ctx("84057"), userDTO);
        System.out.println(result);

        OpenApiResult<ContactDTO> list = contactApiService.listUsers(ApiContext.ctx("84057"),0L);
        System.out.println(list);
    }

    @Test
    public void updateUser() throws Exception {
        ContactUserDTO userDTO = new ContactUserDTO();
        userDTO.setName("xxxxx--update");
        userDTO.setDeptId(14L);
        userDTO.setMobile("13234789870");
        userDTO.setSequence(1);
        userDTO.setId(101010012671665L);
        OpenApiResult<UidDTO> result = contactApiService.updateUser(ApiContext.ctx("84057"),userDTO);
        System.out.println(result);

    }

    @Test
    public void delete(){
        ContactUserDTO userDTO = new ContactUserDTO();
        userDTO.setDeptId(1L);
        userDTO.setId(101010012129369L);
        OpenApiResult<Long> result = contactApiService.deleteUser(ApiContext.ctx("84057"),userDTO);
        System.out.println(result);
    }

    @Test
    public void listDepts(){
        OpenApiResult<ContactDTO> result = contactApiService.listDepts(ApiContext.ctx("84057"),1L);
//        System.out.println(result);
    }

    @Test
    public void createDept(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ContactDeptDTO deptDTO = new ContactDeptDTO();
        deptDTO.setName("新部门-"+format.format(new Date()));
        deptDTO.setParentid(1L);
        OpenApiResult<DeptIdDTO> result = contactApiService.createDept(ApiContext.ctx("84057"),deptDTO);
        System.out.println(result);
    }

    @Test
    public void updateDept(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ContactDeptDTO deptDTO = new ContactDeptDTO();
        deptDTO.setName("update新部门-"+format.format(new Date()));
        deptDTO.setParentid(1L);
        deptDTO.setId(14L);
        OpenApiResult<DeptIdDTO> result = contactApiService.updateDept(ApiContext.ctx("84057"),deptDTO);
        System.out.println(result);
    }
    @Test
    public void deleteDept(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ContactDeptDTO deptDTO = new ContactDeptDTO();
        deptDTO.setName("update新部门-"+format.format(new Date()));
        deptDTO.setParentid(1L);
        deptDTO.setId(14L);
        OpenApiResult<Long> result = contactApiService.deleteDept(ApiContext.ctx("84057"),deptDTO);
        System.out.println(result);
    }
}