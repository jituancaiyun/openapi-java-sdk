package com.shinemo.openapi.client.dto.approve;

import java.util.List;

/**
 * 企业审批模板
 * Created by yuanjian on 3/8/19
 *
 * @author liuyj@shinemo.com
 */
public class ApproveTemplateDTO {
    private List<ApproveTemplateInfo> otbInfos;

    public List<ApproveTemplateInfo> getOtbInfos() {
        return otbInfos;
    }

    public void setOtbInfos(List<ApproveTemplateInfo> otbInfos) {
        this.otbInfos = otbInfos;
    }
}
