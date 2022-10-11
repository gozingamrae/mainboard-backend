package com.gozin.mainboard.product.controller;

import com.gozin.mainboard.common.ResponseDTO;
import com.gozin.mainboard.common.paging.Pagenation;
import com.gozin.mainboard.common.paging.ResponseDtoWithPaging;
import com.gozin.mainboard.common.paging.SelectCriteria;
import com.gozin.mainboard.product.dto.SearchProductDTO;
import com.gozin.mainboard.product.dto.ProductDTO;
import com.gozin.mainboard.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    //상품 조회 (paging)
    @GetMapping("/products")
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

    //상품 상세조회(Paging)
    @GetMapping("/products/{productCode}")
    public ResponseEntity<ResponseDTO> selectDetailProductByProductCode(@PathVariable String productCode){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "상품 조회 성공",  productService.selectDetailProductByProductCode(productCode)));
    }
    
    //상품 검색
    @PostMapping("/products/search")
    public ResponseEntity<ResponseDTO> selectProductListWithPagingByProductDTO(@RequestParam String offset, @RequestBody SearchProductDTO searchProductDTO) {

        int totalCount = productService.selectProductTotal();
        int limit = 10;
        int buttonAmount = 5;
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(Integer.parseInt(offset), totalCount, limit, buttonAmount);;

        ResponseDtoWithPaging responseDtoWithPaging = new ResponseDtoWithPaging();
        responseDtoWithPaging.setPageInfo(selectCriteria);
        responseDtoWithPaging.setData(productService.selectProductListWithPagingByProductDTO(selectCriteria, searchProductDTO));

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", responseDtoWithPaging));
    }

    //상품 등록
    @PostMapping("/products")
    public ResponseEntity<ResponseDTO> insertProduct(@RequestBody ProductDTO productDTO) {
        System.out.println(productDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "상품 등록 성공",  productService.insertProduct(productDTO)));
    }

    //상품 수정
    @PutMapping("/products/{productCode}")
    public ResponseEntity<ResponseDTO> updateProduct(@PathVariable String productCode, @RequestBody ProductDTO productDTO) {
        System.out.println(productDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "상품 수정 성공",  productService.insertProduct(productDTO)));
    }
}
