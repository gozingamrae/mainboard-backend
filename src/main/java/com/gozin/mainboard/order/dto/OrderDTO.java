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

    private String orderId;
    private int orderAmount;
    private int couponUsedRate;
    private int pointsUsedAmount;
    private String orderDate;
    private int selectedProduct;
    private String memberCode;
    private String paymentMethod;
    private int deliveryCharge;
    private String usedCouponCode;
    private char deliveryStartYn;
    private int finalOrderAmount;
    public OrderDTO() {
    }

    public OrderDTO(String orderId, int orderAmount, int couponUsedRate,
                    int pointsUsedAmount, String orderDate, int selectedProduct,
                    String memberCode, String paymentMethod, int deliveryCharge,
                    String usedCouponCode, char deliveryStartYn, int finalOrderAmount) {
        this.orderId = orderId;
        this.orderAmount = orderAmount;
        this.couponUsedRate = couponUsedRate;
        this.pointsUsedAmount = pointsUsedAmount;
        this.orderDate = orderDate;
        this.selectedProduct = selectedProduct;
        this.memberCode = memberCode;
        this.paymentMethod = paymentMethod;
        this.deliveryCharge = deliveryCharge;
        this.usedCouponCode = usedCouponCode;
        this.deliveryStartYn = deliveryStartYn;
        this.finalOrderAmount = finalOrderAmount;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", orderAmount=" + orderAmount +
                ", couponUsedRate=" + couponUsedRate +
                ", pointsUsedAmount=" + pointsUsedAmount +
                ", orderDate='" + orderDate + '\'' +
                ", selectedProduct=" + selectedProduct +
                ", memberCode='" + memberCode + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", deliveryCharge=" + deliveryCharge +
                ", usedCouponCode='" + usedCouponCode + '\'' +
                ", deliveryStartYn=" + deliveryStartYn +
                ", finalOrderAmount=" + finalOrderAmount +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public int getCouponUsedRate() {
        return couponUsedRate;
    }

    public void setCouponUsedRate(int couponUsedRate) {
        this.couponUsedRate = couponUsedRate;
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

    public int getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(int selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(int deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public String getUsedCouponCode() {
        return usedCouponCode;
    }

    public void setUsedCouponCode(String usedCouponCode) {
        this.usedCouponCode = usedCouponCode;
    }

    public char getDeliveryStartYn() {
        return deliveryStartYn;
    }

    public void setDeliveryStartYn(char deliveryStartYn) {
        this.deliveryStartYn = deliveryStartYn;
    }

    public int getFinalOrderAmount() {
        return finalOrderAmount;
    }

    public void setFinalOrderAmount(int finalOrderAmount) {
        this.finalOrderAmount = finalOrderAmount;
    }
}