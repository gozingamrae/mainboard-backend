package com.gozin.mainboard.product.service;

import com.gozin.mainboard.common.paging.SelectCriteria;
import com.gozin.mainboard.product.dao.ProductMapper;
import com.gozin.mainboard.product.dto.SearchProductDTO;
import com.gozin.mainboard.product.dto.ProductDTO;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    ProductMapper productMapper;

    public ProductService(ProductMapper productMapper){
        this.productMapper = productMapper;
    }

    public int selectProductTotal(){
        return productMapper.selectProductTotal();
    }

    public Object selectProductListWithPaging(SelectCriteria selectCriteria){
        return productMapper.selectProductListWithPaging(selectCriteria);
    }

    public Object selectProductListWithPagingByProductDTO(SelectCriteria selectCriteria, SearchProductDTO searchProductDTO){
        return productMapper.selectProductListWithPagingByProductDTO(selectCriteria, searchProductDTO);
    }

    public Object insertProduct(ProductDTO productDTO){
        return productDTO;
    }
    public Object selectCheckList(){
        return productMapper.selectCheckList();
    }

}
