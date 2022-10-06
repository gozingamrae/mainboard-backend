package com.gozin.mainboard.delivery.model.service;

import com.gozin.mainboard.delivery.model.dao.DeliveryAddressMapper;
import com.gozin.mainboard.delivery.model.dto.DeliveryAddressDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryAddressService {

    private final DeliveryAddressMapper deliveryAddressMapper;

    public DeliveryAddressService(DeliveryAddressMapper deliveryAddressMapper) {
        this.deliveryAddressMapper = deliveryAddressMapper;
    }

    public List<DeliveryAddressDTO> selectAddressesByMemberCode(int memberCode) {


        return deliveryAddressMapper.selectAddressesByMemberCode(memberCode);
    }

    public boolean deleteDeliveryAddressByAddressCode() {

        return true;
    }
}
