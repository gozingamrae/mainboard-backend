package com.gozin.mainboard.payment.dto;


import java.util.Date;

/**
 * <pre>
 * Class : PaymentDTO
 * Comment: 결제 정보 DTO
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
public class PaymentDTO {

    private String paymentKey;
    private String orderId;
    private int amount;
    private String paymentDate;

    public PaymentDTO() {};
    public PaymentDTO(String paymentKey, String orderId, int amount, String paymentDate) {
        this.paymentKey = paymentKey;
        this.orderId = orderId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "paymentKey='" + paymentKey + '\'' +
                ", orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                '}';
    }

    public String getpaymentKey() {
        return paymentKey;
    }

    public void setpaymentKey(String paymentKey) {
        this.paymentKey = paymentKey;
    }

    public String getorderId() {
        return orderId;
    }

    public void setorderId(String orderId) {
        this.orderId = orderId;
    }

    public int getamount() {
        return amount;
    }

    public void setamount(int amount) {
        this.amount = amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
}
