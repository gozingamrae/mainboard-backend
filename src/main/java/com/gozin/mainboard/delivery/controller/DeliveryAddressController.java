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

        return ResponseEntity
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

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseDTO(HttpStatus.OK, "success", deliveryAddress));
    }


    @PostMapping("/addresses")
    public ResponseEntity<?> insertAddress(@RequestBody Map<String, Object> request) {

        System.out.println(request);

        int memberCode = 1;

        if((String) request.get("defaultAddressYn") == "Y") {
            DeliveryAddressDTO defaultAddress = deliveryAddressService.selectDefaultAddressByMemberCode(memberCode);
            if(defaultAddress == null || defaultAddress.getDefaultAddressYn() == "Y") {
                deliveryAddressService.cancelDefaultAddressByAddressCode(defaultAddress.getAddressCode());
            }
        }

        DeliveryAddressDTO deliveryAddress = new DeliveryAddressDTO();
        deliveryAddress.setAddressName((String) request.get("addressName"));
        deliveryAddress.setAddressPhone((String) request.get("addressPhone"));
        deliveryAddress.setDeliveryLocation((String) request.get("deliveryLocationTemp"));
        deliveryAddress.setDeliveryRecipient((String) request.get("deliveryRecipient"));
        deliveryAddress.setDefaultAddressYn((String) request.get("defaultAddressYn"));
        deliveryAddress.setCommonEntranceAccessNumberYn((String) request.get("commonEntranceAccessNumberYnTemp"));
        deliveryAddress.setCommonEntranceAccessNumber((String) request.get("commonEntranceAccessNumberTemp"));
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
    public ResponseEntity<?> updateAddress(@RequestBody List<Object> request) {

        System.out.println(((request.get(0))));
        System.out.println(request.get(1));
        int memberCode = 1;

        if("a" == "Y") {
            DeliveryAddressDTO defaultAddress = deliveryAddressService.selectDefaultAddressByMemberCode(memberCode);
            System.out.println("asasasas");
            System.out.println("aaaaaa" + defaultAddress);
            if(defaultAddress == null || defaultAddress.getDefaultAddressYn() == "Y") {
                deliveryAddressService.cancelDefaultAddressByAddressCode(defaultAddress.getAddressCode());
                System.out.println("bbb" + defaultAddress.getDefaultAddressYn());
            }
        }

        DeliveryAddressDTO deliveryAddress = new DeliveryAddressDTO();
        deliveryAddress.setAddressCode((Integer) request.get(1));
        deliveryAddress.setAddressName((String) ((Map<String, Object>)(request.get(0))).get("addressName")==""?
                (String) ((Map<String, Object>)((Map<String, Object>)request.get(0)).get("addressList")).get("addressName"):
                (String) ((Map<String, Object>)request.get(0)).get("addressName"));
        deliveryAddress.setAddressPhone((String) ((Map<String, Object>)(request.get(0))).get("addressPhone")==""?
                (String) ((Map<String, Object>)((Map<String, Object>)request.get(0)).get("addressList")).get("addressPhone"):
                (String) ((Map<String, Object>)(request.get(0))).get("addressPhone"));
        deliveryAddress.setDeliveryLocation((String) ((Map<String, Object>)(request.get(0))).get("deliveryLocation")==""?
                (String) ((Map<String, Object>)((Map<String, Object>)request.get(0)).get("addressList")).get("deliveryLocation"):
                (String) ((Map<String, Object>)(request.get(0))).get("deliveryLocation"));
        deliveryAddress.setDeliveryRecipient((String) ((Map<String, Object>)(request.get(0))).get("deliveryRecipient")==""?
                (String) ((Map<String, Object>)((Map<String, Object>)request.get(0)).get("addressList")).get("deliveryRecipient"):
                (String) ((Map<String, Object>)request.get(0)).get("deliveryRecipient"));
        deliveryAddress.setDefaultAddressYn((String) ((Map<String, Object>)((Map<String, Object>)request.get(0)).get("addressList")).get("defaultAddressYn")!=
                        (String) ((Map<String, Object>)(request.get(0))).get("defaultAddressYn")?
                        (String) ((Map<String, Object>)request.get(0)).get("defaultAddressYn"):
                        (String) ((Map<String, Object>)((Map<String, Object>)request.get(0)).get("addressList")).get("defaultAddressYn")
                );
        deliveryAddress.setCommonEntranceAccessNumberYn((String) ((Map<String, Object>)((Map<String, Object>)request.get(0)).get("addressList")).get("commonEntranceAccessNumberYn")!=
                        (String) ((Map<String, Object>)(request.get(0))).get("commonEntranceAccessNumberYn")?
                        (String) ((Map<String, Object>)(request.get(0))).get("commonEntranceAccessNumberYn"):
                        (String) ((Map<String, Object>)((Map<String, Object>)request.get(0)).get("addressList")).get("commonEntranceAccessNumberYn")
                );
        deliveryAddress.setCommonEntranceAccessNumber((String) ((Map<String, Object>)(request.get(0))).get("commonEntranceAccessNumber")==""?
                (String) ((Map<String, Object>)((Map<String, Object>)request.get(0)).get("addressList")).get("commonEntranceAccessNumber"):
                (String) ((Map<String, Object>)(request.get(0))).get("commonEntranceAccessNumber"));
        deliveryAddress.
                setAddressLocation(
                        (String)((Map<String, Object>)(request.get(0))).get("addressZipCode")==""?

                        (String)((Map<String, Object>)((Map<String, Object>)request.get(0)).get("addressList")).get("addressLocation") + "%" +
                                (String)((Map<String, Object>)((Map<String, Object>)request.get(0)).get("addressList")).get("addressDetailLocation") + "%" +
                                (String)((Map<String, Object>)((Map<String, Object>)request.get(0)).get("addressList")).get("addressZipCode"):
                                (String)((Map<String, Object>)(request.get(0))).get("addressLocation") + "%" +
                                        (String)((Map<String, Object>)(request.get(0))).get("addressDetailLocation") + "%" +
                                        (String)((Map<String, Object>)(request.get(0))).get("addressZipCode")
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
