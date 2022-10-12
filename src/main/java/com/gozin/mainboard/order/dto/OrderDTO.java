package com.gozin.mainboard.order.dto;

/**
 * <pre>
 * Class : OrderDTO
 * Comment: 주문 정보 DTO
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-10-04       차용준           최초 생성
 * </pre>
 *
 * @author 차용준
 * @version 1.0.0
 * @see
 */
public class OrderDTO {

    private String orderCode;
    private int orderAmount;
    private int couponUsedAmount;
    private int pointsUsedAmount;
    private String orderDate;
    private String whetherPay;

    public OrderDTO() {}

    public OrderDTO(String orderCode, int orderAmount, int couponUsedAmount,
                    int pointsUsedAmount, String orderDate, String whetherPay) {
        this.orderCode = orderCode;
        this.orderAmount = orderAmount;
        this.couponUsedAmount = couponUsedAmount;
        this.pointsUsedAmount = pointsUsedAmount;
        this.orderDate = orderDate;
        this.whetherPay = whetherPay;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderCode='" + orderCode + '\'' +
                ", orderAmount=" + orderAmount +
                ", couponUsedAmount=" + couponUsedAmount +
                ", pointsUsedAmount=" + pointsUsedAmount +
                ", orderDate='" + orderDate + '\'' +
                ", whetherPay='" + whetherPay + '\'' +
                '}';
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public int getCouponUsedAmount() {
        return couponUsedAmount;
    }

    public void setCouponUsedAmount(int couponUsedAmount) {
        this.couponUsedAmount = couponUsedAmount;
    }

    public int getPointsUsedAmount() {
        return pointsUsedAmount;
    }

    public void setPointsUsedAmount(int pointsUsedAmount) {
        this.pointsUsedAmount = pointsUsedAmount;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getWhetherPay() {
        return whetherPay;
    }

    public void setWhetherPay(String whetherPay) {
        this.whetherPay = whetherPay;
    }
}



