package com.gozin.mainboard.product.dao;

import com.gozin.mainboard.common.paging.SelectCriteria;
import com.gozin.mainboard.product.dto.DetailInspectionCheckListDTO;
import com.gozin.mainboard.product.dto.ProductDTO;
import com.gozin.mainboard.product.dto.RequiredPartDTO;
import com.gozin.mainboard.product.dto.SearchProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    public int selectProductTotal();
    public List<ProductDTO> selectProductListWithPaging(SelectCriteria selectCriteria);
    public List<ProductDTO> selectProductListWithPagingByProductDTO(SelectCriteria selectCriteria, SearchProductDTO searchProductDTO);

    public ProductDTO selectDetailProductByProductCode(String productCode);
    public List<RequiredPartDTO>selectRequiredPartListByProductId();

    //상품 이름으로 상품 리스트 조회
    public List<ProductDTO> selectProductListByProductName(String productName);

    //상품 입력
    public int insertProduct(ProductDTO productDTO);

    //상품별 검수 목록 입력
    public int insertCheckList(int productCode);
    //상품별 필수 부품 입력
    public int insertPartsList(int productCode);
}
