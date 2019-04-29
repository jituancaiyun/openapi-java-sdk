package com.shinemo.openapi.client.dto.approve;

import java.util.List;

/**
 * Created by yuanjian on 3/8/19
 *
 * @author liuyj@shinemo.com
 */
public class ApproveOutByOut {
    protected String approveId;
    protected Long templateId;
    protected String templateName;
    protected String createUid;
    protected String createName;
    protected List<ApproveFieldByOut> fields;
    protected List<ApproveUsersByOut> users;
    protected Integer status;

    public String getApproveId() {
        return approveId;
    }

    public void setApproveId(String approveId) {
        this.approveId = approveId;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getCreateUid() {
        return createUid;
    }

    public void setCreateUid(String createUid) {
        this.createUid = createUid;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public List<ApproveFieldByOut> getFields() {
        return fields;
    }

    public void setFields(List<ApproveFieldByOut> fields) {
        this.fields = fields;
    }

    public List<ApproveUsersByOut> getUsers() {
        return users;
    }

    public void setUsers(List<ApproveUsersByOut> users) {
        this.users = users;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"approveId\":\"")
                .append(approveId).append('\"');
        sb.append(",\"templateId\":")
                .append(templateId);
        sb.append(",\"templateName\":\"")
                .append(templateName).append('\"');
        sb.append(",\"createUid\":\"")
                .append(createUid).append('\"');
        sb.append(",\"createName\":\"")
                .append(createName).append('\"');
        sb.append(",\"fields\":")
                .append(fields);
        sb.append(",\"users\":")
                .append(users);
        sb.append(",\"status\":")
                .append(status);
        sb.append('}');
        return sb.toString();
    }
}
