package com.shinemo.openapi.client.dto.approve;

/**
 * Created by yuanjian on 3/8/19
 *
 * @author liuyj@shinemo.com
 */
public class ApproveUsersByOut {
    protected String uid;
    protected String name;
    protected Integer operType;
    protected Long operTime;
    protected String comment;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOperType() {
        return operType;
    }

    public void setOperType(Integer operType) {
        this.operType = operType;
    }

    public Long getOperTime() {
        return operTime;
    }

    public void setOperTime(Long operTime) {
        this.operTime = operTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"uid\":\"")
                .append(uid).append('\"');
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"operType\":")
                .append(operType);
        sb.append(",\"operTime\":")
                .append(operTime);
        sb.append(",\"comment\":\"")
                .append(comment).append('\"');
        sb.append('}');
        return sb.toString();
    }
}
