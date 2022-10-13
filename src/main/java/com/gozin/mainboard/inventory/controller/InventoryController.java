package com.gozin.mainboard.inventory.controller;

import com.gozin.mainboard.common.ResponseDTO;
import com.gozin.mainboard.common.paging.Pagenation;
import com.gozin.mainboard.common.paging.ResponseDtoWithPaging;
import com.gozin.mainboard.common.paging.SelectCriteria;
import com.gozin.mainboard.inventory.dto.BoardgameStockDTO;
import com.gozin.mainboard.inventory.service.InventoryService;
import com.gozin.mainboard.product.dto.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/inventorys")
    public ResponseEntity<ResponseDTO> insertInventory(@ModelAttribute BoardgameStockDTO boardgameStockDTO) {
        System.out.println(boardgameStockDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "상품 등록 성공",  inventoryService.insertInventory(boardgameStockDTO)));
    }
}
