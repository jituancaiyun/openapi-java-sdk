package com.shinemo.openapi.client.callback;

import com.shinemo.openapi.client.callback.CallbackEvent;

import java.util.Map;

/**
 * @author yuanjian
 * date 1/24/18
 * email liuyj@shinemo.com
 */
public class ContactUserChangeEvent implements CallbackEvent {

    /**
     * 变更类型，1新增，2修改，3删除
     */
    private int changeType;
    /**
     * 发生变更的企业id
     */
    private String orgId;

    /**
     * 变更的人员id和部门id的对应
     */
    private Map<String, Long> uids;

    public int getChangeType() {
        return changeType;
    }

    public void setChangeType(int changeType) {
        this.changeType = changeType;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Map<String, Long> getUids() {
        return uids;
    }

    public void setUids(Map<String, Long> uids) {
        this.uids = uids;
    }
}
