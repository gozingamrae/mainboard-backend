package com.gozin.mainboard.delivery.model.dto;

public class DeliveryAddressDTO {
    private int addressCode;
    private int memberCode;
    private String addressName;
    private String addressLocation;
    private String addressPhone;
    private String deliveryRecipient;
    private String defaultAddressYn;
    private String commonEntranceAccessNumberYn;

    private String commonEntranceAccessNumber;
    private String deliveryLocation;

    public DeliveryAddressDTO() {
    }

    public DeliveryAddressDTO(int addressCode, int memberCode, String addressName, String addressLocation, String addressPhone, String deliveryRecipient, String defaultAddressYn, String commonEntranceAccessNumberYn, String commonEntranceAccessNumber, String deliveryLocation) {
        this.addressCode = addressCode;
        this.memberCode = memberCode;
        this.addressName = addressName;
        this.addressLocation = addressLocation;
        this.addressPhone = addressPhone;
        this.deliveryRecipient = deliveryRecipient;
        this.defaultAddressYn = defaultAddressYn;
        this.commonEntranceAccessNumberYn = commonEntranceAccessNumberYn;
        this.commonEntranceAccessNumber = commonEntranceAccessNumber;
        this.deliveryLocation = deliveryLocation;
    }

    public int getAddressCode() {
        return addressCode;
    }

    public void setAddressCode(int addressCode) {
        this.addressCode = addressCode;
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressLocation() {
        return addressLocation;
    }

    public void setAddressLocation(String addressLocation) {
        this.addressLocation = addressLocation;
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    public String getDeliveryRecipient() {
        return deliveryRecipient;
    }

    public void setDeliveryRecipient(String deliveryRecipient) {
        this.deliveryRecipient = deliveryRecipient;
    }

    public String getDefaultAddressYn() {
        return defaultAddressYn;
    }

    public void setDefaultAddressYn(String defaultAddressYn) {
        this.defaultAddressYn = defaultAddressYn;
    }

    public String getCommonEntranceAccessNumberYn() {
        return commonEntranceAccessNumberYn;
    }

    public void setCommonEntranceAccessNumberYn(String commonEntranceAccessNumberYn) {
        this.commonEntranceAccessNumberYn = commonEntranceAccessNumberYn;
    }

    public String getCommonEntranceAccessNumber() {
        return commonEntranceAccessNumber;
    }

    public void setCommonEntranceAccessNumber(String commonEntranceAccessNumber) {
        this.commonEntranceAccessNumber = commonEntranceAccessNumber;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    @Override
    public String toString() {
        return "DeliveryAddressDTO{" +
                "addressCode=" + addressCode +
                ", memberCode=" + memberCode +
                ", addressName='" + addressName + '\'' +
                ", addressLocation='" + addressLocation + '\'' +
                ", addressPhone='" + addressPhone + '\'' +
                ", deliveryRecipient='" + deliveryRecipient + '\'' +
                ", defaultAddressYn='" + defaultAddressYn + '\'' +
                ", commonEntranceAccessNumberYn='" + commonEntranceAccessNumberYn + '\'' +
                ", commonEntranceAccessNumber='" + commonEntranceAccessNumber + '\'' +
                ", deliveryLocation='" + deliveryLocation + '\'' +
                '}';
    }
}