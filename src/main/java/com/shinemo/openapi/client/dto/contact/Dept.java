package com.shinemo.openapi.client.dto.contact;

/**
 * 导入通讯录-部门
 *
 * @author yuanjian
 * date 1/22/18
 * email liuyj@shinemo.com
 */
public class Dept {

    private String name;
    private String parentId;
    private String deptId;
    private int sequence;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                ", deptId='" + deptId + '\'' +
                ", sequence=" + sequence +
                '}';
    }
}
