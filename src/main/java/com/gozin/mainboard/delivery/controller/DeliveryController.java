package com.gozin.mainboard.delivery.controller;

import com.gozin.mainboard.common.ResponseDTO;
import com.gozin.mainboard.delivery.model.dto.DeliveryDTO;
import com.gozin.mainboard.delivery.model.service.DeliveryService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/logs")
    public ResponseEntity<ResponseDTO> selectDeliveryLogs() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        List<DeliveryDTO> deliveryLogs = deliveryService.selectDeliveryLogs();

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new ResponseDTO(HttpStatus.OK, "success", deliveryLogs));

    }
}
