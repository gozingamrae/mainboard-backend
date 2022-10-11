package com.gozin.mainboard.delivery.model.dto;

public class DeliveryDTO {

    private int deliveryCode;
    private String orderCode;
    private int addressCode;
    private int trackingNumber;
    private String currentLocation;
    private String deliveryEstimatedEndDate;
    private String returningYn;
    private String deliveryStartDate;
    private String deliveryEndDate;
    private String explanation;
    private int deliveryProductCode;

    public DeliveryDTO() {
    }

    public DeliveryDTO(int deliveryCode, String orderCode, int addressCode, int trackingNumber, String currentLocation, String deliveryEstimatedEndDate, String returningYn, String deliveryStartDate, String deliveryEndDate, String explanation, int deliveryProductCode) {
        this.deliveryCode = deliveryCode;
        this.orderCode = orderCode;
        this.addressCode = addressCode;
        this.trackingNumber = trackingNumber;
        this.currentLocation = currentLocation;
        this.deliveryEstimatedEndDate = deliveryEstimatedEndDate;
        this.returningYn = returningYn;
        this.deliveryStartDate = deliveryStartDate;
        this.deliveryEndDate = deliveryEndDate;
        this.explanation = explanation;
        this.deliveryProductCode = deliveryProductCode;
    }

    public int getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(int deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(int addressCode) {
        this.addressCode = addressCode;
    }

    public int getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(int trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getDeliveryEstimatedEndDate() {
        return deliveryEstimatedEndDate;
    }

    public void setDeliveryEstimatedEndDate(String deliveryEstimatedEndDate) {
        this.deliveryEstimatedEndDate = deliveryEstimatedEndDate;
    }

    public String getReturningYn() {
        return returningYn;
    }

    public void setReturningYn(String returningYn) {
        this.returningYn = returningYn;
    }

    public String getDeliveryStartDate() {
        return deliveryStartDate;
    }

    public void setDeliveryStartDate(String deliveryStartDate) {
        this.deliveryStartDate = deliveryStartDate;
    }

    public String getDeliveryEndDate() {
        return deliveryEndDate;
    }

    public void setDeliveryEndDate(String deliveryEndDate) {
        this.deliveryEndDate = deliveryEndDate;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getDeliveryProductCode() {
        return deliveryProductCode;
    }

    public void setDeliveryProductCode(int deliveryProductCode) {
        this.deliveryProductCode = deliveryProductCode;
    }

    @Override
    public String toString() {
        return "DeliveryDTO{" +
                "deliveryCode=" + deliveryCode +
                ", orderCode='" + orderCode + '\'' +
                ", addressCode=" + addressCode +
                ", trackingNumber=" + trackingNumber +
                ", currentLocation='" + currentLocation + '\'' +
                ", deliveryEstimatedEndDate='" + deliveryEstimatedEndDate + '\'' +
                ", returningYn='" + returningYn + '\'' +
                ", deliveryStartDate='" + deliveryStartDate + '\'' +
                ", deliveryEndDate='" + deliveryEndDate + '\'' +
                ", explanation='" + explanation + '\'' +
                ", deliveryProductCode=" + deliveryProductCode +
                '}';
    }
}
