package com.gozin.mainboard.inventory.service;

import com.gozin.mainboard.common.paging.SelectCriteria;
import com.gozin.mainboard.inventory.dao.InventoryMapper;
import com.gozin.mainboard.inventory.dto.BoardgameStockDTO;
import com.gozin.mainboard.product.dto.ProductDTO;
import com.gozin.mainboard.util.FileUploadUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.UUID;

@Service
public class InventoryService {
    InventoryMapper inventoryMapper;
    public InventoryService(InventoryMapper inventoryMapper){
        this.inventoryMapper = inventoryMapper;
    }

    public int selectInventoryTotal(){
        return inventoryMapper.selectInventoryTotal();
    }

    public Object selectInventoryListWithPaging(SelectCriteria selectCriteria){
        return inventoryMapper.selectInventoryListWithPaging(selectCriteria);
    }
    @Transactional
    public String insertInventory(BoardgameStockDTO boardgameStockDTO) {
        int result = 0;

        result = inventoryMapper.insertInventory(boardgameStockDTO);

        return (result > 0) ? "상품 입력 성공" : "상품 입력 실패";
    }


}
