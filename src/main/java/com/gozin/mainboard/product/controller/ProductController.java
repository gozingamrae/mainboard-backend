package com.gozin.mainboard.product.controller;

import com.gozin.mainboard.common.ResponseDTO;
import com.gozin.mainboard.common.paging.Pagenation;
import com.gozin.mainboard.common.paging.ResponseDtoWithPaging;
import com.gozin.mainboard.common.paging.SelectCriteria;
import com.gozin.mainboard.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    //상품 조회 (paging)
    @GetMapping
        public ResponseEntity<ResponseDTO> selectProductListWithPaging(@RequestParam(name="offset", defaultValue="1") String offset) {

            int totalCount = productService.selectProductTotal();
            int limit = 10;
            int buttonAmount = 5;
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(Integer.parseInt(offset), totalCount, limit, buttonAmount);;

        ResponseDtoWithPaging responseDtoWithPaging = new ResponseDtoWithPaging();
        responseDtoWithPaging.setPageInfo(selectCriteria);
        responseDtoWithPaging.setData(productService.selectProductListWithPaging(selectCriteria));

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", responseDtoWithPaging));
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseDTO> selectProductListWithPagingByProductDTO(@RequestParam(name="offset", defaultValue="1") String offset) {

        int totalCount = productService.selectProductTotal();
        int limit = 10;
        int buttonAmount = 5;
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(Integer.parseInt(offset), totalCount, limit, buttonAmount);;

        ResponseDtoWithPaging responseDtoWithPaging = new ResponseDtoWithPaging();
        responseDtoWithPaging.setPageInfo(selectCriteria);
        responseDtoWithPaging.setData(productService.selectProductListWithPaging(selectCriteria));

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", responseDtoWithPaging));
    }

    //상품 상세조회
    @GetMapping("/id")
    public String test2(){
        return "hello2";
    }
}
