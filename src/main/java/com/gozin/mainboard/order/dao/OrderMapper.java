package com.gozin.mainboard.order.dao;

import com.gozin.mainboard.order.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <pre>
 * Class : OrderMapper
 * Comment: 주문 정보 매퍼
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
public interface OrderMapper {
    List<OrderDTO> selectOrderList();
}
