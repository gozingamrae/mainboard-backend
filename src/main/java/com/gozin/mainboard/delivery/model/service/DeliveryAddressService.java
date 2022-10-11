package com.gozin.mainboard.delivery.model.service;

import com.gozin.mainboard.delivery.model.dao.DeliveryAddressMapper;
import com.gozin.mainboard.delivery.model.dto.DeliveryAddressDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class DeliveryAddressService {

    private final DeliveryAddressMapper deliveryAddressMapper;

    public DeliveryAddressService(DeliveryAddressMapper deliveryAddressMapper) {
        this.deliveryAddressMapper = deliveryAddressMapper;
    }

    public List<DeliveryAddressDTO> selectAddressesByMemberCode(int memberCode) {


        return deliveryAddressMapper.selectAddressesByMemberCode(memberCode);
    }

    public DeliveryAddressDTO selectAddressesByMemberCodeAndAddressCode(Map<String, Integer> addressInfo) {

        return deliveryAddressMapper.selectAddressesByMemberCodeAndAddressCode(addressInfo);
    }

    public DeliveryAddressDTO selectDefaultAddressByMemberCode(int memberCode) {

        return deliveryAddressMapper.selectDefaultAddressByMemberCode(memberCode);
    }

    @Transactional
    public boolean deleteDeliveryAddressByAddressCode(int addressCode) {

        int result = deliveryAddressMapper.deleteDeliveryAddressByAddressCode(addressCode);
        System.out.println(result);

        if(result == 0) {
            return false;
        }

        return true;
    }

    @Transactional
    public boolean insertAddress(DeliveryAddressDTO deliveryAddress) {

        int result = deliveryAddressMapper.insertAddress(deliveryAddress);
        System.out.println(result);

        if(result == 0) {
            return false;
        }

        return true;
    }

    @Transactional
    public boolean updateAddress(DeliveryAddressDTO deliveryAddress) {

        int result = deliveryAddressMapper.updateAddress(deliveryAddress);
        System.out.println(result);

        if(result == 0) {
            return false;
        }

        return true;
    }

    @Transactional
    public boolean cancelDefaultAddressByAddressCode(int addressCode) {

        int result = deliveryAddressMapper.cancelDefaultAddressByAddressCode(addressCode);
        System.out.println(result);

        if(result == 0) {
            return false;
        }

        return true;
    }
}
