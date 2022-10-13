package com.gozin.mainboard.order.controller;

import com.gozin.mainboard.common.ResponseDTO;
import com.gozin.mainboard.common.ResponseDTO2;
import com.gozin.mainboard.order.dto.OrderDTO;
import com.gozin.mainboard.order.dto.OrderPrinceRequestDTO;
import com.gozin.mainboard.order.dto.OrderSearchDTO;
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
import java.util.List;
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
    @PostMapping("/list/by-orderid")
    public ResponseEntity<ResponseDTO> selectOrderByOrderId(@RequestBody OrderSearchDTO orderSearchDTO){
        System.out.println(orderSearchDTO);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "검색 결과 조회 성공",
                orderService.selectOrderByOrderId(orderSearchDTO)));
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

    @PostMapping("/final")
    public ResponseEntity<ResponseDTO> insertOrderInfo (@RequestBody OrderDTO orderDTO ){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "주문 정보 입력 성공",
                 orderService.insertOrderInfo(orderDTO)));
    }

}
