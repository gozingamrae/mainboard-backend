package com.gozin.mainboard.payment.dao;

import com.gozin.mainboard.payment.dto.PaymentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <pre>
 * Class : PaymentMapper
 * Comment: 결제 정보 매퍼
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
@Mapper
public interface PaymentMapper {
    public List<PaymentDTO> selectPaymentList();
    int insertPaymentList(PaymentDTO paymentDTO);
}
