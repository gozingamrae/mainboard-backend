package com.gozin.mainboard.coupon.dto;

import java.util.Date;

public class SearchCouponDTO {
    private String couponName;
    private String target;
    private java.util.Date startDate;
    private java.util.Date endDate;

    public SearchCouponDTO(){};

    public SearchCouponDTO(String couponName, String target, Date startDate, Date endDate) {
        this.couponName = couponName;
        this.target = target;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "SearchCouponDTO{" +
                "couponName='" + couponName + '\'' +
                ", target='" + target + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
