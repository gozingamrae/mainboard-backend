package com.gozin.mainboard.delivery.controller;

import com.gozin.mainboard.common.ResponseDTO;
import com.gozin.mainboard.delivery.model.dto.DeliveryAddressDTO;
import com.gozin.mainboard.delivery.model.service.DeliveryAddressService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryAddressController {

    private final DeliveryAddressService deliveryAddressService;

    public DeliveryAddressController(DeliveryAddressService deliveryAddressService) {
        this.deliveryAddressService = deliveryAddressService;
    }

    // 토큰이 있으면 회원 조회, 없으면 전체 조회
    @GetMapping("/addresses")
    public ResponseEntity<ResponseDTO> selectAddressesByMemberCode() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        int memberCode = 1;

        List<DeliveryAddressDTO> deliveryAddressList = deliveryAddressService.selectAddressesByMemberCode(memberCode);

        System.out.println(deliveryAddressList);

        return (ResponseEntity<ResponseDTO>) ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseDTO(HttpStatus.OK, "success", (List<DeliveryAddressDTO>)deliveryAddressList));
    }


    @PostMapping("/addresses")
    public ResponseEntity<?> insertAddress(@ModelAttribute DeliveryAddressDTO deliveryAddress) {


        System.out.println("요청 왔습니다.");

        return ResponseEntity
                .created(URI.create("/deliveries/addresses"))
                .build();
    }

    @PutMapping("/addresses")
    public ResponseEntity<?> updateAddress(DeliveryAddressDTO deliveryAddress) {

        DeliveryAddressDTO deliveryAddressList;

        return ResponseEntity
                .created(URI.create("/deliveries/addresses"))
                .build();
    }

    @DeleteMapping("/addresses")
    public ResponseEntity<?> deleteDeliveryAddressByAddressCode(int addressCode) {

        deliveryAddressService.deleteDeliveryAddressByAddressCode();

        return ResponseEntity
                .noContent()
                .build();
    }
}
