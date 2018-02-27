package com.shinemo.openapi.client.service;

import com.shinemo.openapi.client.Apis;
import com.shinemo.openapi.client.Constants;
import com.shinemo.openapi.client.common.ApiContext;
import com.shinemo.openapi.client.common.OpenApiResult;
import com.shinemo.openapi.client.dto.attendance.ImportSignInfoDTO;
import com.shinemo.openapi.client.dto.attendance.SignDeviceDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ohun on 2017/4/16.
 *
 * @author ohun@live.cn (夜色)
 */
public class AttendanceApiServiceTest {

    private AttendanceApiService attendanceApiService;
    private String orgSecret = Constants.OrgSecret.DAILY_SECRET.orgSecret;
    private String uid = "101010011894152";//"101010012129489";//
    private String name = "yuanjian";
    private ApiContext context;

    @Before
    public void setUp() throws Exception {
        Apis.setEnv(1);
        context = ApiContext.ctx(orgSecret, uid, name);
        attendanceApiService = Apis.createApiService(AttendanceApiService.class);
    }

    @Test
    public void add() {
        ImportSignInfoDTO signInfoDTO = new ImportSignInfoDTO();
        signInfoDTO.setUid("1111111111");
        signInfoDTO.setSignTime("2018-01-05 09:00:00");
        signInfoDTO.setSignType(2);
        SignDeviceDTO deviceDTO = new SignDeviceDTO();
        deviceDTO.setDeviceId("123321");
        deviceDTO.setDeviceName("设备名称");
        signInfoDTO.setDev(deviceDTO);
        OpenApiResult result = attendanceApiService.add(context, signInfoDTO);
        System.out.println(result);
    }

    @Test
    public void importBatch() {
        List<ImportSignInfoDTO> list = new ArrayList<ImportSignInfoDTO>();
        for (int i = 0; i < 10; i++) {
            ImportSignInfoDTO signInfoDTO = new ImportSignInfoDTO();
            signInfoDTO.setUid("1111111111");
            signInfoDTO.setSignTime("2018-01-11 09:00:00");
            signInfoDTO.setSignType(2);
            SignDeviceDTO deviceDTO = new SignDeviceDTO();
            deviceDTO.setDeviceId("123321");
            deviceDTO.setDeviceName("设备名称");
            signInfoDTO.setDev(deviceDTO);
            list.add(signInfoDTO);
        }
        OpenApiResult result = attendanceApiService.importBatch(context, list);
        System.out.println(result);
    }

    @Test
    public void query() {

        OpenApiResult result = attendanceApiService.query(context, "2018-01-01", "2018-03-09");
        System.out.println(result);

    }

}
