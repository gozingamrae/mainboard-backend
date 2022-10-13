package com.gozin.mainboard.inventory.controller;

import com.gozin.mainboard.common.ResponseDTO;
import com.gozin.mainboard.common.paging.Pagenation;
import com.gozin.mainboard.common.paging.ResponseDtoWithPaging;
import com.gozin.mainboard.common.paging.SelectCriteria;
import com.gozin.mainboard.inventory.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class InventoryController {
    InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService){
        this.inventoryService = inventoryService;
    }
    //상품 조회 (paging)
    @GetMapping("/inventorys")
    public ResponseEntity<ResponseDTO> selectInventoryListWithPaging(@RequestParam(name="offset", defaultValue="1") String offset, @RequestParam(name="limit", defaultValue="10") String limit) {

        int totalCount = inventoryService.selectInventoryTotal();
        int buttonAmount = 5;
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(Integer.parseInt(offset), totalCount, Integer.parseInt(limit), buttonAmount);;

        ResponseDtoWithPaging responseDtoWithPaging = new ResponseDtoWithPaging();
        responseDtoWithPaging.setPageInfo(selectCriteria);
        responseDtoWithPaging.setData(inventoryService.selectInventoryListWithPaging(selectCriteria));

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", responseDtoWithPaging));
    }
}
