package com.shinemo.openapi.client.dto.approve;

/**
 * 企业审批模板
 * Created by yuanjian on 3/8/19
 *
 * @author liuyj@shinemo.com
 */
public class ApproveTemplateInfo {
    private Long templateId;
    private String templateName;
    private Integer businessType;
    private String description;
    private String logo;
    private Integer status;
    private Long createTime;
    private Long source;
    private boolean isAllSee;
    private Integer replaceType;
    private Integer templateLabel;

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

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getSource() {
        return source;
    }

    public void setSource(Long source) {
        this.source = source;
    }

    public boolean isAllSee() {
        return isAllSee;
    }

    public void setAllSee(boolean allSee) {
        isAllSee = allSee;
    }

    public Integer getReplaceType() {
        return replaceType;
    }

    public void setReplaceType(Integer replaceType) {
        this.replaceType = replaceType;
    }

    public Integer getTemplateLabel() {
        return templateLabel;
    }

    public void setTemplateLabel(Integer templateLabel) {
        this.templateLabel = templateLabel;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"templateId\":")
                .append(templateId);
        sb.append(",\"templateName\":\"")
                .append(templateName).append('\"');
        sb.append(",\"businessType\":")
                .append(businessType);
        sb.append(",\"description\":\"")
                .append(description).append('\"');
        sb.append(",\"logo\":\"")
                .append(logo).append('\"');
        sb.append(",\"status\":")
                .append(status);
        sb.append(",\"createTime\":")
                .append(createTime);
        sb.append(",\"source\":")
                .append(source);
        sb.append(",\"isAllSee\":")
                .append(isAllSee);
        sb.append(",\"replaceType\":")
                .append(replaceType);
        sb.append(",\"templateLabel\":")
                .append(templateLabel);
        sb.append('}');
        return sb.toString();
    }
}
