package com.gozin.mainboard.product.service;

import com.gozin.mainboard.common.paging.SelectCriteria;
import com.gozin.mainboard.product.dao.ProductMapper;
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

}
