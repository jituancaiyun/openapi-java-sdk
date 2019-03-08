package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.Constants;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.Jsons;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.ContactDeptDTO;
import com.shinemo.openapi.client.dto.ContactUserDTO;
import com.shinemo.openapi.client.dto.DeptIdDTO;
import com.shinemo.openapi.client.dto.UidDTO;
import com.shinemo.openapi.client.dto.contact.ContactDTO;
import com.shinemo.openapi.client.dto.contact.Dept;
import com.shinemo.openapi.client.dto.contact.User;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by ohun on 2017/3/23.
 *
 * @author ohun@live.cn (夜色)
 */
public class ContactApiServiceTest {

    private ContactApiService contactApiService;

    private String orgSecret = Constants.OrgSecret.ONLINE_SECRET.orgSecret;

    private ApiContext context;

    @Before
    public void setUp() throws Exception {
        Apis.setEnv(5);
        contactApiService = Apis.createApiService(ContactApiService.class);
        context = ApiContext.ctx(orgSecret);
    }

    @Test
    public void getDeptUsers() throws Exception {
        OpenApiResult<com.shinemo.openapi.client.dto.ContactDTO> result = contactApiService.listUsers(context, 0);
        System.out.println(result);
        System.out.println(result.getData().getUsers().size());
    }

    @Test
    public void getDeptUsersAll() throws Exception {
        OpenApiResult<com.shinemo.openapi.client.dto.ContactDTO> result = contactApiService.listUsersAll(context, 0);
        System.out.println(result);
//        System.out.println(result);
    }

    @Test
    public void createUser() throws Exception {
        ContactUserDTO userDTO = new ContactUserDTO();
        userDTO.setName("xxxxx");
        userDTO.setDeptId(0L);
        userDTO.setMobile("13600530626");
        userDTO.setSequence(1);

        OpenApiResult<UidDTO> result = contactApiService.createUser(context, userDTO);
        System.out.println(result);

        OpenApiResult<com.shinemo.openapi.client.dto.ContactDTO> list = contactApiService.listUsers(context, 0L);
        System.out.println(list);
    }

    @Test
    public void deleteUser() {
        ContactUserDTO userDTO = new ContactUserDTO();
        userDTO.setDeptId(1L);
        userDTO.setId(101010012129369L);
        OpenApiResult<Void> result = contactApiService.deleteUser(context, userDTO);
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
        OpenApiResult<ContactUserDTO> result = contactApiService.detail(context, 101010012671649L, 0);
        System.out.println(result);
    }

    @Test
    public void listDepts() {
        OpenApiResult<com.shinemo.openapi.client.dto.ContactDTO> result = contactApiService.listDepts(context, 0L);
        System.out.println(result);
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
        OpenApiResult<Void> result = contactApiService.deleteDept(context, deptDTO);
        System.out.println(result);
    }

    @Test
    public void contactImport() throws Exception {
        /*ContactDTO org = new ContactDTO();
        List<Dept> deptList = new ArrayList<Dept>();
        context.put("flags", "12");
        Dept dept = new Dept();
        dept.setParentId("0");
        dept.setDeptId("d1");
        dept.setName("新部门");
        deptList.add(dept);
        User user = new User();
        user.setUserId("11111");
        user.setDeptId("d1");
        user.setMobile("13588200631");
        user.setName("刘远剑");
        user.setSequence(1);
        List<User> userList = new ArrayList<User>();
        userList.add(user);
        org.setDeptList(deptList);
        org.setUserList(userList);*/
        FileReader fileReader = new FileReader("/Users/apple/Desktop/json.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        String line = reader.readLine();
        ContactDTO org = Jsons.fromJson(line, ContactDTO.class);
        /*for (User user : org.getUserList()) {
            if(user.getName() == null){
                System.out.println(Jsons.toJson(user));
            }
            if(user.getMobile() == null || "".equals(user.getMobile())){
                System.out.println(Jsons.toJson(user));
            }
        }*/
        Map<String, Dept> deptMap = new HashMap<String, Dept>();
        for (Dept dept : org.getDeptList()) {
            deptMap.put(dept.getDeptId(), dept);
        }
        for (String s : deptMap.keySet()) {
            if ("0".equals(s)) {
                System.out.println(Jsons.toJson(deptMap.get(s)));
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(s).append('-');
            Dept dept1 = deptMap.get(s);
            while (deptMap.containsKey(s)) {
                s = dept1.getParentId();
                Dept dept = deptMap.get(s);
                if (dept == null) {
                    break;
                }
                if (sb.toString().contains(dept.getDeptId())) {
                    System.out.println(Jsons.toJson(dept));
                    break;
                } else {
                    s = dept.getDeptId();
                    dept1 = deptMap.get(s);
                    sb.append(s).append('-');
                }
            }
        }
        System.out.println(contactApiService.contactImport(context, org));


    }

    @Test
    public void contactImportV2() throws Exception {
        ContactDTO org = new ContactDTO();
        List<Dept> deptList = new ArrayList<Dept>();
        Dept dept = new Dept();
        dept.setDeptId("d1");
        dept.setName("新部门");
        dept.setStatus(0);
        dept.setParentId("0");
        deptList.add(dept);
        User user = new User();
        user.setDeptId("d1");
        user.setMobile("13588200631");
        user.setLoginId("13588200631");
        user.setName("刘远剑");
        user.setSequence(8);
        List<User> userList = new ArrayList<User>();
        userList.add(user);
        org.setDeptList(deptList);
        org.setUserList(userList);
        System.out.println(contactApiService.contactImportV2(context, 8, org));
    }

    @Test
    public void contactExport() throws Exception {
        System.out.println(contactApiService.contactExport(context));
        //{"status":0,"data":{"deptList":[{"name":"部门全量1-0312","parentId":"0","deptId":"33","sequence":1},{"name":"部门增量1-0312","parentId":"0","deptId":"34","sequence":2},{"name":"部门增量2-0312","parentId":"0","deptId":"35","sequence":3},{"name":"部门全量2-0312","parentId":"0","deptId":"36","sequence":4}],"userList":[{"name":"刘远剑-全量0312","mobile":"13588200631","email":"bjjtest@126.com","deptId":"33","userId":"101010012129489","sequence":1},{"name":"6665-全量0312","mobile":"14000006665","email":"bjjtest@126.com","deptId":"33","userId":"101010012129953","sequence":2}]}}
    }


}