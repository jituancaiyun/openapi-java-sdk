package com.shinemo.openapi.client.dto.schedule;

import com.shinemo.openapi.client.dto.personalremind.RFrequency;

/**
 * Created by yuanjian on 12/5/18
 *
 * @author liuyj@shinemo.com
 */
public class WorkReportDetail {
    private Integer warntime;
    private RFrequency rfrequency;
    private Integer submitcycle;
    private String strspecifiedtime;
    private String submitbegtime;
    private String submitendtime;
    private Long wrrId;
    private Integer wrtype;
    private String warncontent;

    public Integer getWarntime() {
        return warntime;
    }

    public void setWarntime(Integer warntime) {
        this.warntime = warntime;
    }

    public RFrequency getRfrequency() {
        return rfrequency;
    }

    public void setRfrequency(RFrequency rfrequency) {
        this.rfrequency = rfrequency;
    }

    public Integer getSubmitcycle() {
        return submitcycle;
    }

    public void setSubmitcycle(Integer submitcycle) {
        this.submitcycle = submitcycle;
    }

    public String getStrspecifiedtime() {
        return strspecifiedtime;
    }

    public void setStrspecifiedtime(String strspecifiedtime) {
        this.strspecifiedtime = strspecifiedtime;
    }

    public String getSubmitbegtime() {
        return submitbegtime;
    }

    public void setSubmitbegtime(String submitbegtime) {
        this.submitbegtime = submitbegtime;
    }

    public String getSubmitendtime() {
        return submitendtime;
    }

    public void setSubmitendtime(String submitendtime) {
        this.submitendtime = submitendtime;
    }

    public Long getWrrId() {
        return wrrId;
    }

    public void setWrrId(Long wrrId) {
        this.wrrId = wrrId;
    }

    public Integer getWrtype() {
        return wrtype;
    }

    public void setWrtype(Integer wrtype) {
        this.wrtype = wrtype;
    }

    public String getWarncontent() {
        return warncontent;
    }

    public void setWarncontent(String warncontent) {
        this.warncontent = warncontent;
    }
}
