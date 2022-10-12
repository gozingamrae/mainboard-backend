package com.gozin.mainboard.payment.service;

import com.gozin.mainboard.payment.dao.PaymentMapper;
import com.gozin.mainboard.payment.dto.PaymentDTO;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * <pre>
 * Class : PaymentService
 * Comment: 결제 정보 서비스
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-10-04       차용준           최초 생성
 * </pre>
 *
 * @author 차용준
 * @version 1.0.0
 * @see (참고할 class 또는 외부 url)
 */
@Service
public class PaymentService {

    private final PaymentMapper paymentMapper;

    public PaymentService(PaymentMapper paymentMapper) {
        this.paymentMapper = paymentMapper;
    }

    public List<PaymentDTO> selectPaymentList() {

        List<PaymentDTO> selectPaymentList = paymentMapper.selectPaymentList();

        return selectPaymentList;
    }

    public Object insertPaymentList(PaymentDTO paymentDTO) {

        int result = paymentMapper.insertPaymentList(paymentDTO);

        return (result>0) ? "입력 성공":"입력실패";

    }
}
