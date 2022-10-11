package com.gozin.mainboard.order.dto;

/**
 * <pre>
 * Class : OrderPrinceRequestDTO
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-10-06       홍길동           최초 생성
 * </pre>
 *
 * @author 홍길동(최초 작성자)
 * @version 1(클래스 버전)
 * @see (참고할 class 또는 외부 url)
 */
public class OrderPrinceRequestDTO {
    private int orderPrice;

    public OrderPrinceRequestDTO() {
    }

    public OrderPrinceRequestDTO(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    @Override
    public String toString() {
        return "OrderPrinceRequestDTO{" +
                "orderPrice='" + orderPrice + '\'' +
                '}';
    }
}
