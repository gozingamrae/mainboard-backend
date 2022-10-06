package com.gozin.mainboard.delivery.model.dao;

import com.gozin.mainboard.delivery.model.dto.DeliveryAddressDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeliveryAddressMapper {
    List<DeliveryAddressDTO> selectAddressesByMemberCode(int memberCode);
}
