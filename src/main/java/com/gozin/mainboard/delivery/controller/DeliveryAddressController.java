package com.gozin.mainboard.delivery.controller;

import com.gozin.mainboard.common.ResponseDTO;
import com.gozin.mainboard.delivery.model.dto.DeliveryAddressDTO;
import com.gozin.mainboard.delivery.model.service.DeliveryAddressService;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        // memberCode 정보 헤더에서 받아오기
        int memberCode = 1;

        List<DeliveryAddressDTO> deliveryAddressList = deliveryAddressService.selectAddressesByMemberCode(memberCode);

        System.out.println(deliveryAddressList);

        return (ResponseEntity<ResponseDTO>) ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseDTO(HttpStatus.OK, "success", deliveryAddressList));
    }

    @GetMapping("/addresses/{addressCode}")
    public ResponseEntity<ResponseDTO> selectAddressesByMemberCodeAndAddressCode(@PathVariable int addressCode) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        // memberCode 정보 헤더에서 받아오기
        int memberCode = 1;

        Map<String, Integer> addressInfo = new HashMap<>();
        addressInfo.put("memberCode", memberCode);
        addressInfo.put("addressCode",  addressCode);

        System.out.println(addressInfo);

        DeliveryAddressDTO deliveryAddress = deliveryAddressService.selectAddressesByMemberCodeAndAddressCode(addressInfo);

        System.out.println(deliveryAddress);

        return (ResponseEntity<ResponseDTO>) ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseDTO(HttpStatus.OK, "success", deliveryAddress));
    }


    @PostMapping("/addresses")
    public ResponseEntity<?> insertAddress(@RequestBody Map<String, Object> request) {

        System.out.println(request);

        // 기본 배송지 회원 별로 1개만 되도록 바꿔야 한다.
        DeliveryAddressDTO deliveryAddress = new DeliveryAddressDTO();
        deliveryAddress.setAddressName((String) request.get("addressName"));
        deliveryAddress.setAddressPhone((String) request.get("addressPhone"));
        deliveryAddress.setDeliveryLocation((String) request.get("deliveryLocation"));
        deliveryAddress.setDeliveryRecipient((String) request.get("deliveryRecipient"));
        deliveryAddress.setDefaultAddressYn((String) request.get("defaultAddressYn"));
        deliveryAddress.setCommonEntranceAccessNumberYn((String) request.get("commonEntranceAccessNumberYn"));
        deliveryAddress.setCommonEntranceAccessNumber((String) request.get("commonEntranceAccessNumber"));
        deliveryAddress.
                setAddressLocation(
                        (String)request.get("addressLocation") + "%" +
                        (String)request.get("addressDetailLocation") + "%" +
                        (String)request.get("addressZipCode")
                );

        System.out.println(deliveryAddress);
        boolean isSucceed = deliveryAddressService.insertAddress(deliveryAddress);

        if (isSucceed) {
            return ResponseEntity
                    .created(URI.create("/deliveries/addresses"))
                    .body(new ResponseDTO(HttpStatus.CREATED, "success", true));

        } else {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseDTO(HttpStatus.BAD_REQUEST, "fail", false));
        }
    }

    @PutMapping("/addresses")
    public ResponseEntity<?> updateAddress(@RequestBody Map<String, Object> request) {


        System.out.println(request);

        // 기본 배송지 회원 별로 1개만 되도록 바꿔야 한다.
        DeliveryAddressDTO deliveryAddress = new DeliveryAddressDTO();
        deliveryAddress.setAddressCode((Integer) request.get("addressCode"));
        deliveryAddress.setAddressName((String) request.get("addressName"));
        deliveryAddress.setAddressPhone((String) request.get("addressPhone"));
        deliveryAddress.setDeliveryLocation((String) request.get("deliveryLocation"));
        deliveryAddress.setDeliveryRecipient((String) request.get("deliveryRecipient"));
        deliveryAddress.setDefaultAddressYn((String) request.get("defaultAddressYn"));
        deliveryAddress.setCommonEntranceAccessNumberYn((String) request.get("commonEntranceAccessNumberYn"));
        deliveryAddress.setCommonEntranceAccessNumber((String) request.get("commonEntranceAccessNumber"));
        deliveryAddress.
                setAddressLocation(
                        (String)request.get("addressLocation") + "%" +
                                (String)request.get("addressDetailLocation") + "%" +
                                (String)request.get("addressZipCode")
                );

        System.out.println(deliveryAddress);
        boolean isSucceed = deliveryAddressService.updateAddress(deliveryAddress);

        if (isSucceed) {
            return ResponseEntity
                    .created(URI.create("/deliveries/addresses"))
                    .body(new ResponseDTO(HttpStatus.CREATED, "success", true));

        } else {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseDTO(HttpStatus.BAD_REQUEST, "fail", false));
        }
    }

    @DeleteMapping("/addresses")
    public ResponseEntity<?> deleteDeliveryAddressByAddressCode(@RequestBody String data) {

        int addressCode = Integer.parseInt(data);
        System.out.println("제거 요청" + addressCode);

        boolean isSucceed = deliveryAddressService.deleteDeliveryAddressByAddressCode(addressCode);

        if (isSucceed) {
            return ResponseEntity
                    .noContent()
                    .build();

        } else {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseDTO(HttpStatus.BAD_REQUEST, "fail", false));
        }

    }
}
