package com.gozin.mainboard.common;

import org.springframework.http.HttpStatus;

public class ResponseDTO2 {

    private int status;
    private String message;
    private Object data;
    private int price;
    public ResponseDTO2(HttpStatus status, String message, Object data, int price) {
        this.status = status.value();
        this.message = message;
        this.data = data;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ResponseDTO2{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", price=" + price +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}