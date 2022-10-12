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
        return productMapper.selectProductListWithPaging(selectCriteria);
    }

    public Object selectProductListWithPagingByProductDTO(SelectCriteria selectCriteria, SearchProductDTO searchProductDTO){
        return productMapper.selectProductListWithPagingByProductDTO(selectCriteria, searchProductDTO);
    }


    public Object selectDetailProductByProductCode(String productCode){
        System.out.println("call selectDatailProductByProductCode Service 1");
        ProductDTO productDTO = productMapper.selectDetailProductByProductCode(productCode);

        System.out.println("call selectDatailProductByProductCode Service 2");
        productDTO.setRequiredPartDTOList(productMapper.selectRequiredPartListByProductId());
        return productDTO;
    }


    @Transactional
    public String insertProduct(ProductDTO productDto) {
//        log.info("[ProductService] insertProduct Start ===================================");
//        log.info("[ProductService] productDto : " + productDto);
        String imageName = UUID.randomUUID().toString().replace("-", "");
        String replaceFileName = null;
        int result = 0;

        try {
            System.out.println("test0");
            replaceFileName = FileUploadUtils.saveFile(IMAGE_DIR, imageName, productDto.getProductImage());
            System.out.println("test1");
            productDto.setProductImageUrl(replaceFileName);
            System.out.println("test2");
//            log.info("[ProductService] insert Image Name : ", replaceFileName);

            result = productMapper.insertProduct(productDto);
            System.out.println("test3");
        } catch (IOException e) {
            FileUploadUtils.deleteFile(IMAGE_DIR, replaceFileName);
            throw new RuntimeException(e);
        }

        return (result > 0) ? "상품 입력 성공" : "상품 입력 실패";
    }


}
