package com.gozin.mainboard.inventory.service;

import com.gozin.mainboard.common.paging.SelectCriteria;
import com.gozin.mainboard.inventory.dao.InventoryMapper;
import com.gozin.mainboard.product.dto.ProductDTO;
import org.springframework.stereotype.Service;

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
}
