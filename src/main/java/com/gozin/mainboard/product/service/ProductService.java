package com.gozin.mainboard.product.service;

import com.gozin.mainboard.common.paging.SelectCriteria;
import com.gozin.mainboard.product.dao.ProductMapper;
import com.gozin.mainboard.product.dto.SearchProductDTO;
import com.gozin.mainboard.product.dto.ProductDTO;
import com.gozin.mainboard.util.FileUploadUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    ProductMapper productMapper;

    @Value("${image.image-dir}")
    private String IMAGE_DIR;
    @Value("${image.image-url}")
    private String IMAGE_URL;
    public ProductService(ProductMapper productMapper){
        this.productMapper = productMapper;
    }

    public int selectProductTotal(){
        return productMapper.selectProductTotal();
    }

    public Object selectProductListWithPaging(SelectCriteria selectCriteria){
        List<ProductDTO> productList = productMapper.selectProductListWithPaging(selectCriteria);

        for(int i = 0 ; i < productList.size() ; i++) {
            productList.get(i).setProductImageUrl(IMAGE_URL + productList.get(i).getProductImageUrl());
        }
        for(int i = 0 ; i < productList.size() ; i++) {
            productList.get(i).setProductDetailImageUrl(IMAGE_URL + productList.get(i).getProductDetailImageUrl());
        }
//        log.info("[ProductService] selectProductListWithPaging End ===================================");
        return productList;
    }

    public Object selectProductListWithPagingByProductDTO(SelectCriteria selectCriteria, SearchProductDTO searchProductDTO){
        return productMapper.selectProductListWithPagingByProductDTO(selectCriteria, searchProductDTO);
    }


    public Object selectDetailProductByProductCode(String productCode){
        ProductDTO productDTO = productMapper.selectDetailProductByProductCode(productCode);
        System.out.println(productDTO);
        productDTO.setProductImageUrl(IMAGE_URL + productDTO.getProductImageUrl());
        productDTO.setProductDetailImageUrl(IMAGE_URL + productDTO.getProductDetailImageUrl());
        return productDTO;
    }


    @Transactional
    public String insertProduct(ProductDTO productDto) {
        String imageName = UUID.randomUUID().toString().replace("-", "");
        String replaceFileName = null;

        String detailImageName = UUID.randomUUID().toString().replace("-", "");
        String replaceDetailFileName = null;

        int result = 0;

        try {
//          썸네일 이미지 처리
            replaceFileName = FileUploadUtils.saveFile(IMAGE_DIR, imageName, productDto.getProductImage());
            productDto.setProductImageUrl(replaceFileName);
//
//          상세 정보 이미지 처리
            replaceDetailFileName = FileUploadUtils.saveFile(IMAGE_DIR, detailImageName, productDto.getProductDetailImage());
            System.out.println("상세 정보 이미지 : " + replaceDetailFileName);
            productDto.setProductDetailImageUrl(replaceDetailFileName);
            
            result = productMapper.insertProduct(productDto);
        } catch (IOException e) {
            FileUploadUtils.deleteFile(IMAGE_DIR, replaceFileName);
            FileUploadUtils.deleteFile(IMAGE_DIR, replaceDetailFileName);
            throw new RuntimeException(e);
        }

        return (result > 0) ? "상품 입력 성공" : "상품 입력 실패";
    }


}
