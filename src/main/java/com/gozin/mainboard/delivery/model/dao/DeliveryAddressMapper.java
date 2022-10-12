package com.gozin.mainboard.delivery.model.dao;

import com.gozin.mainboard.delivery.model.dto.DeliveryAddressDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeliveryAddressMapper {
    List<DeliveryAddressDTO> selectAddressesByMemberCode(int memberCode);

    DeliveryAddressDTO selectAddressesByMemberCodeAndAddressCode(Map<String, Integer> addressInfo);

    DeliveryAddressDTO selectDefaultAddressByMemberCode(int memberCode);

    int insertAddress(DeliveryAddressDTO deliveryAddress);

    int deleteDeliveryAddressByAddressCode(int addressCode);

    int updateAddress(DeliveryAddressDTO deliveryAddress);

    int cancelDefaultAddressByAddressCode(int addressCode);
}
