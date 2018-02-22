package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.*;
import com.shinemo.openapi.client.dto.contact.Dept;
import com.shinemo.openapi.client.dto.contact.Org;
import com.shinemo.openapi.client.dto.contact.User;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ohun on 2017/3/23.
 *
 * @author ohun@live.cn (夜色)
 */
public class ContactApiServiceTest {

    private ContactApiService contactApiService;

    private String orgSecret = "AQDWGAEAAAAAABD_AgAAAAAA";

    private ApiContext context;

    @Before
    public void setUp() throws Exception {
        Apis.setEnv(3);
        contactApiService = Apis.createApiService(ContactApiService.class);
        context = ApiContext.ctx(orgSecret);
    }

    @Test
    public void getDeptUsers() throws Exception {
        OpenApiResult<ContactDTO> result = contactApiService.listUsers(context, 0);
        System.out.println(result);
        System.out.println(result.getData().getUsers().size());
    }

    @Test
    public void getDeptUsersAll() throws Exception {
        OpenApiResult<ContactDTO> result = contactApiService.listUsersAll(context, 0);
        System.out.println(result);
//        System.out.println(result);
    }

    @Test
    public void createUser() throws Exception {
        ContactUserDTO userDTO = new ContactUserDTO();
        userDTO.setName("xxxxx");
        userDTO.setDeptId(1L);
        userDTO.setMobile("13600530626");
        userDTO.setSequence(1);

        OpenApiResult<UidDTO> result = contactApiService.createUser(context, userDTO);
        System.out.println(result);

        OpenApiResult<ContactDTO> list = contactApiService.listUsers(context, 0L);
        System.out.println(list);
    }

    @Test
    public void deleteUser() {
        ContactUserDTO userDTO = new ContactUserDTO();
        userDTO.setDeptId(1L);
        userDTO.setId(101010012129369L);
        OpenApiResult<Long> result = contactApiService.deleteUser(context, userDTO);
        System.out.println(result);
    }

    @Test
    public void updateUser() throws Exception {
        ContactUserDTO userDTO = new ContactUserDTO();
        userDTO.setName("xxxxx--update");
        userDTO.setDeptId(14L);
        userDTO.setMobile("13234789870");
        userDTO.setSequence(1);
        userDTO.setId(101010012671665L);
        OpenApiResult<UidDTO> result = contactApiService.updateUser(context, userDTO);
        System.out.println(result);

    }

    @Test
    public void detail() throws Exception {
        OpenApiResult<ContactUserDTO> result = contactApiService.detail(context, 101010012051017L, 0);
        System.out.println(result);
    }

    @Test
    public void listDepts() {
        OpenApiResult<ContactDTO> result = contactApiService.listDepts(context, 1L);
//        System.out.println(result);
    }

    @Test
    public void listUsers() throws Exception {
        OpenApiResult result = contactApiService.listUsers(context, 0L);
        System.out.println(result);
    }

    @Test
    public void listUsersAll() throws Exception {
        OpenApiResult result = contactApiService.listUsersAll(context, 0L);
        System.out.println(result);
    }

    @Test
    public void createDept() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ContactDeptDTO deptDTO = new ContactDeptDTO();
        deptDTO.setName("新部门-" + format.format(new Date()));
        deptDTO.setParentid(0L);
        OpenApiResult<DeptIdDTO> result = contactApiService.createDept(context, deptDTO);
        System.out.println(result);
    }

    @Test
    public void updateDept() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ContactDeptDTO deptDTO = new ContactDeptDTO();
        deptDTO.setName("update新部门-" + format.format(new Date()));
        deptDTO.setParentid(1L);
        deptDTO.setId(14L);
        OpenApiResult<DeptIdDTO> result = contactApiService.updateDept(context, deptDTO);
        System.out.println(result);
    }

    @Test
    public void deleteDept() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ContactDeptDTO deptDTO = new ContactDeptDTO();
        deptDTO.setName("update新部门-" + format.format(new Date()));
        deptDTO.setParentid(1L);
        deptDTO.setId(14L);
        OpenApiResult<Long> result = contactApiService.deleteDept(context, deptDTO);
        System.out.println(result);
    }

    @Test
    public void contactImport() throws Exception {
        Org org = new Org();
        List<Dept> deptList = new ArrayList<>();
        Dept dept = new Dept();
        dept.setDeptId("d1");
        dept.setName("新部门");
        deptList.add(dept);
        User user = new User();
        user.setDeptId("d1");
        user.setMobile("13588200631");
        user.setName("刘远剑");
        user.setSequence(1);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        org.setDeptList(deptList);
        org.setUserList(userList);
        System.out.println(contactApiService.contactImport(context, org));
    }

    @Test
    public void contactExport() throws Exception {
        System.out.println(contactApiService.contactExport(context));
    }

}