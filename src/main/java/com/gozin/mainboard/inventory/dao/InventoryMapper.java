package com.gozin.mainboard.inventory.dao;

import com.gozin.mainboard.common.paging.SelectCriteria;
import com.gozin.mainboard.inventory.dto.BoardgameStockDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InventoryMapper {

    public int selectInventoryTotal();

    public List<BoardgameStockDTO> selectInventoryListWithPaging(SelectCriteria selectCriteria);

    public int insertInventory(BoardgameStockDTO boardgameStockDTO);
}
