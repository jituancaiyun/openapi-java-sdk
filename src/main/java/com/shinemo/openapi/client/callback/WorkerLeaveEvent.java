package com.shinemo.openapi.client.callback;


import java.util.List;

/**
 * @author yuanjian
 */
public class WorkerLeaveEvent implements CallbackEvent {

    /**
     * 发生变更的企业id
     */
    private String orgId;
    /**
     * 变更的人员id
     */
    private List<String> uids;


    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public List<String> getUids() {
        return uids;
    }

    public void setUids(List<String> uids) {
        this.uids = uids;
    }
}
