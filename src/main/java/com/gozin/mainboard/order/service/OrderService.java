package com.gozin.mainboard.order.service;

import com.gozin.mainboard.order.dao.OrderMapper;
import com.gozin.mainboard.order.dto.OrderDTO;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 * Class : OrderService
 * Comment: 주문 정보 서비스
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
@Service
public class OrderService {

    int p = 0;
    char q ='a';
    String todayCondition="XX";
    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public List<OrderDTO> selectOrderList() {

        List<OrderDTO> selectOrderList = orderMapper.selectOrderList();

        return selectOrderList;
    }

    public Object selectOrderInfo() {

        Date today = new Date();
        SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyyMMdd-HHmm");

        if(!todayCondition.equals(yyyyMMdd.format(today))){
            p = 0;
            q = 'a';
        }

        String orderId="Order-"+ yyyyMMdd.format(today) + "-" + q + "-"+ p;
        if(p<1000){
            p = p+ 1;
        } else if(p>=1000){
            q = (char) (q + 1);
            p =0;
        }
        todayCondition = yyyyMMdd.format(today);
        System.out.println(orderId);
        return orderId;
    }
}
