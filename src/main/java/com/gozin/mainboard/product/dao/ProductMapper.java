package com.gozin.mainboard.product.dao;

import com.gozin.mainboard.common.paging.SelectCriteria;
import com.gozin.mainboard.product.dto.DetailInspectionCheckListDTO;
import com.gozin.mainboard.product.dto.ProductDTO;
import com.gozin.mainboard.product.dto.SearchProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    public int selectProductTotal();
    public List<ProductDTO> selectProductListWithPaging(SelectCriteria selectCriteria);
    public List<ProductDTO> selectProductListWithPagingByProductDTO(SelectCriteria selectCriteria, SearchProductDTO searchProductDTO);

    public List<DetailInspectionCheckListDTO> selectCheckList();

}
