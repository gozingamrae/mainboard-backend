package com.gozin.mainboard.delivery.model.service;

import com.gozin.mainboard.delivery.model.dao.DeliveryMapper;
import com.gozin.mainboard.delivery.model.dto.DeliveryDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {

    private final DeliveryMapper deliveryMapper;

    public DeliveryService(DeliveryMapper deliveryMapper) {
        this.deliveryMapper = deliveryMapper;
    }

    public List<DeliveryDTO> selectDeliveryLogs() {

        return deliveryMapper.selectDeliveryLogs();
    }
}
