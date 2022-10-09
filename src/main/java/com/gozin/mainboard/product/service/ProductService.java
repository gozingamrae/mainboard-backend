package com.gozin.mainboard.product.service;

import com.gozin.mainboard.common.paging.SelectCriteria;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public int selectProductTotal(){
        return 30;
    }

    public Object selectProductListWithPaging(SelectCriteria selectCriteria){
        return null;
    }

}
