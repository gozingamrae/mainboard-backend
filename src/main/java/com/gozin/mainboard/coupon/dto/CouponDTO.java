package com.gozin.mainboard.coupon.dto;

import java.util.Date;

public class CouponDTO {
    private Long couponCode;
    private String couponName;
    private String explanation;
    private java.util.Date expirationPeriod;
    private Long minOrderPrice;
    private Long discountRate;
    private String target;


    public CouponDTO(){}

    public CouponDTO(Long couponCode, String couponName, String explanation, Date expirationPeriod, Long minOrderPrice, Long discountRate, String target) {
        this.couponCode = couponCode;
        this.couponName = couponName;
        this.explanation = explanation;
        this.expirationPeriod = expirationPeriod;
        this.minOrderPrice = minOrderPrice;
        this.discountRate = discountRate;
        this.target = target;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
    public Long getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(Long couponCode) {
        this.couponCode = couponCode;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public Long getMinOrderPrice() {
        return minOrderPrice;
    }

    public void setMinOrderPrice(Long minOrderPrice) {
        this.minOrderPrice = minOrderPrice;
    }

    public Long getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Long discountRate) {
        this.discountRate = discountRate;
    }

    public Date getExpirationPeriod() {
        return expirationPeriod;
    }

    public void setExpirationPeriod(Date expirationPeriod) {
        this.expirationPeriod = expirationPeriod;
    }

    @Override
    public String toString() {
        return "CouponDTO{" +
                "couponCode=" + couponCode +
                ", couponName='" + couponName + '\'' +
                ", explanation='" + explanation + '\'' +
                ", expirationPeriod=" + expirationPeriod +
                ", minOrderPrice=" + minOrderPrice +
                ", discountRate=" + discountRate +
                ", target='" + target + '\'' +
                '}';
    }
}
