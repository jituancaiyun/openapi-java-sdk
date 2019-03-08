package com.shinemo.openapi.client.dto.approve;

import java.util.List;

/**
 * Created by yuanjian on 3/8/19
 *
 * @author liuyj@shinemo.com
 */
public class ApprovePageDTO {
    private List<ApproveOutByOut> approveList;
    private int totalCount;

    public List<ApproveOutByOut> getApproveList() {
        return approveList;
    }

    public void setApproveList(List<ApproveOutByOut> approveList) {
        this.approveList = approveList;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"approveList\":")
                .append(approveList);
        sb.append(",\"totalCount\":")
                .append(totalCount);
        sb.append('}');
        return sb.toString();
    }
}
