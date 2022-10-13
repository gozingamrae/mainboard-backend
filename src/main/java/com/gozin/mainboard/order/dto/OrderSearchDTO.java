package com.gozin.mainboard.order.dto;

/**
 * <pre>
 * Class : OrderSearchDTO
 * Comment: 클래스에 대한 간단 설명
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-10-12       홍길동           최초 생성
 * </pre>
 *
 * @author 홍길동(최초 작성자)
 * @version 1(클래스 버전)
 * @see (참고할 class 또는 외부 url)
 */
public class OrderSearchDTO {
    private String text;
    public OrderSearchDTO() {};

    public OrderSearchDTO(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "OrderSearchDTO{" +
                "text='" + text + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
