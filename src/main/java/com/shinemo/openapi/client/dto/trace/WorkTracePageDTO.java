package com.shinemo.openapi.client.dto.trace;

import java.util.List;

/**
 * @author yuanjian
 * date 2/1/18
 * email liuyj@shinemo.com
 */
public class WorkTracePageDTO {
    private int pageIndex;
    private int pageSize;
    private int totalCount;
    private List<WorkTraceInfo> contrailInfos;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<WorkTraceInfo> getContrailInfos() {
        return contrailInfos;
    }

    public void setContrailInfos(List<WorkTraceInfo> contrailInfos) {
        this.contrailInfos = contrailInfos;
    }

    @Override
    public String toString() {
        return "WorkTracePageDTO{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", contrailInfos=" + contrailInfos +
                '}';
    }
}
