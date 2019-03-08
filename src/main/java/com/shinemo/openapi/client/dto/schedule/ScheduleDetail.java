package com.shinemo.openapi.client.dto.schedule;

import com.shinemo.openapi.client.dto.MemberUser;

import java.util.ArrayList;

/**
 * Created by yuanjian on 12/5/18
 *
 * @author liuyj@shinemo.com
 */
public class ScheduleDetail {
    protected String content;
    protected Long createtime;
    protected Long begintime;
    protected Long endtime;
    protected Boolean iswarn;
    protected ArrayList<Long> warntime;
    protected Integer remindtype;
    protected String straddr;
    protected ArrayList<MemberUser> members;
    protected String strdescrip;
    protected Integer fromsource;
    protected Boolean iswholeday;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public Long getBegintime() {
        return begintime;
    }

    public void setBegintime(Long begintime) {
        this.begintime = begintime;
    }

    public Long getEndtime() {
        return endtime;
    }

    public void setEndtime(Long endtime) {
        this.endtime = endtime;
    }

    public Boolean getIswarn() {
        return iswarn;
    }

    public void setIswarn(Boolean iswarn) {
        this.iswarn = iswarn;
    }

    public ArrayList<Long> getWarntime() {
        return warntime;
    }

    public void setWarntime(ArrayList<Long> warntime) {
        this.warntime = warntime;
    }

    public Integer getRemindtype() {
        return remindtype;
    }

    public void setRemindtype(Integer remindtype) {
        this.remindtype = remindtype;
    }

    public String getStraddr() {
        return straddr;
    }

    public void setStraddr(String straddr) {
        this.straddr = straddr;
    }

    public ArrayList<MemberUser> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<MemberUser> members) {
        this.members = members;
    }

    public String getStrdescrip() {
        return strdescrip;
    }

    public void setStrdescrip(String strdescrip) {
        this.strdescrip = strdescrip;
    }

    public Integer getFromsource() {
        return fromsource;
    }

    public void setFromsource(Integer fromsource) {
        this.fromsource = fromsource;
    }

    public Boolean getIswholeday() {
        return iswholeday;
    }

    public void setIswholeday(Boolean iswholeday) {
        this.iswholeday = iswholeday;
    }
}
