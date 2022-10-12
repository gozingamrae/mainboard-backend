package com.gozin.mainboard.order.controller;

import com.gozin.mainboard.common.ResponseDTO;
import com.gozin.mainboard.common.ResponseDTO2;
import com.gozin.mainboard.order.dto.OrderPrinceRequestDTO;
import com.gozin.mainboard.order.service.OrderService;
import com.gozin.mainboard.payment.service.PaymentService;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigInteger;
import java.util.stream.Collectors;

/**
 * <pre>
 * Class : OrderController
 * Comment: 주문 정보 컨트롤러
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
@RestController
//requestbody를 자동으로 설정해줌
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //결제 내역 조회
    @GetMapping("/list")
    public ResponseEntity<ResponseDTO> paymetList(){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "주문 내역 조회 성공", orderService.selectOrderList()));
    }



    @PostMapping("/info")
    //HttpServletRequest request : 요청과 함께 담겨온 정보를 받음
    public ResponseEntity<ResponseDTO2> orderInfo(@RequestBody OrderPrinceRequestDTO orderPrinceRequestDTO) {

        System.out.println(orderPrinceRequestDTO);
        //받은 정보를 가공함.
        int orderPrice = orderPrinceRequestDTO.getOrderPrice();

        return ResponseEntity.ok().body(new ResponseDTO2(HttpStatus.OK, "주문정보입니다",
                orderService.selectOrderInfo(), orderPrice));
    }

    //주문을 통해 결제를 하게 되는데, 결제에는 주문 정보가 들어가게 된다. 이 때 주문 상픔에 따라 주문 코드를 부여해야함.
    //아래의 정보를 모두 할당해줘야 함.
    //ex) amount: 15000,
    //    orderId: '76rak6lsv-x-MttZpaunR',
    //    orderName: '토스 티셔츠 외 2건',
    //    customerName: '박토스',

}
