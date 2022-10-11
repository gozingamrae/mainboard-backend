package com.gozin.mainboard.delivery.model.dao;

import com.gozin.mainboard.delivery.model.dto.DeliveryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeliveryMapper {
    List<DeliveryDTO> selectDeliveryLogs();
}
