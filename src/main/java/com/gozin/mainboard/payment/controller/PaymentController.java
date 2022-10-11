package com.gozin.mainboard.payment.controller;

/**
 * <pre>
 * Class : PaymentController
 * Comment: 결제 정보 컨트롤러
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
import com.gozin.mainboard.common.ResponseDTO;
import com.gozin.mainboard.payment.dto.PaymentDTO;
import com.gozin.mainboard.payment.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    //결제 내역 조회
    @GetMapping("/payment/list")
    public ResponseEntity<ResponseDTO> paymetList(){

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "결제 내역 조회 성공", paymentService.selectPaymentList()));
    }

    @PostMapping("/payment-completed")
    public ResponseEntity<ResponseDTO> insertPaymentList(@ModelAttribute PaymentDTO paymentDTO){

        Date time = new Date();
        SimpleDateFormat FormatTime = new SimpleDateFormat("yyyy.MM.dd/HH:mm");
        paymentDTO.setPaymentDate(FormatTime.format(time));


        System.out.println("paymentController!! : " + paymentDTO);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "결제내역 입력 성공", paymentService.insertPaymentList(paymentDTO)));
    }

    //결제정보를 데이터베이스에 저장해야함.

    //주문을 통해 결제를 하게 되는데, 결제에는 주문 정보가 들어가게 된다. 이 때 주문 상픔에 따라 주문 코드를 부여해야함.
    //아래의 정보를 모두 할당해줘야 함.
    //ex) amount: 15000,
    //    orderId: '76rak6lsv-x-MttZpaunR',
    //    orderName: '토스 티셔츠 외 2건',
    //    customerName: '박토스'

    // +++ 결제 취소를 진행해야함..
}
