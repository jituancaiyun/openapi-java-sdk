package com.shinemo.openapi.client.dto.approve;

import java.util.List;

/**
 * 企业审批模板
 * Created by yuanjian on 3/8/19
 *
 * @author liuyj@shinemo.com
 */
public class OrgTemplateInfos {
    private List<OrgTemplateInfo> otbInfos;

    public List<OrgTemplateInfo> getOtbInfos() {
        return otbInfos;
    }

    public void setOtbInfos(List<OrgTemplateInfo> otbInfos) {
        this.otbInfos = otbInfos;
    }
}
