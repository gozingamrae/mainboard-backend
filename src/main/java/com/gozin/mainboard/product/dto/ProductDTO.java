package com.gozin.mainboard.product.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ProductDTO {
    private int boardgameTypeCode;
    private int boardgameType;
    private String boardgameName;
    private String soldOutYn;
    private int totalCount;
    private int defaultRentalFee;
    private String manufacturingCompany;
    private int boardgameCategoryCode;
    private String brand;
    private MultipartFile productImage;
    private String productImageUrl;

    private MultipartFile productDetailImage;
    private String productDetailImageUrl;
    private int categoryCode;
    private String categoryName;
    private int SRentalFee;
    private int ARentalFee;
    private int BRentalFee;
    private String SState;
    private String AState;
    private String BState;
    private String storage;

    @Override
    public String toString() {
        return "ProductDTO{" +
                "boardgameTypeCode=" + boardgameTypeCode +
                ", boardgameType=" + boardgameType +
                ", boardgameName='" + boardgameName + '\'' +
                ", soldOutYn='" + soldOutYn + '\'' +
                ", totalCount=" + totalCount +
                ", defaultRentalFee=" + defaultRentalFee +
                ", manufacturingCompany='" + manufacturingCompany + '\'' +
                ", boardgameCategoryCode=" + boardgameCategoryCode +
                ", brand='" + brand + '\'' +
                ", productImage=" + productImage +
                ", productImageUrl='" + productImageUrl + '\'' +
                ", productDetailImage=" + productDetailImage +
                ", productDetailImageUrl='" + productDetailImageUrl + '\'' +
                ", categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", SRentalFee=" + SRentalFee +
                ", ARentalFee=" + ARentalFee +
                ", BRentalFee=" + BRentalFee +
                ", SState='" + SState + '\'' +
                ", AState='" + AState + '\'' +
                ", BState='" + BState + '\'' +
                ", storage='" + storage + '\'' +
                ", detailInspectionCheckListDTOList=" + detailInspectionCheckListDTOList +
                ", requiredPartDTOList=" + requiredPartDTOList +
                '}';
    }

    public ProductDTO(int boardgameTypeCode, int boardgameType, String boardgameName, String soldOutYn, int totalCount, int defaultRentalFee, String manufacturingCompany, int boardgameCategoryCode, String brand, MultipartFile productImage, String productImageUrl, MultipartFile productDetailImage, String productDetailImageUrl, int categoryCode, String categoryName, int SRentalFee, int ARentalFee, int BRentalFee, String SState, String AState, String BState, String storage, List<DetailInspectionCheckListDTO> detailInspectionCheckListDTOList, List<RequiredPartDTO> requiredPartDTOList) {
        this.boardgameTypeCode = boardgameTypeCode;
        this.boardgameType = boardgameType;
        this.boardgameName = boardgameName;
        this.soldOutYn = soldOutYn;
        this.totalCount = totalCount;
        this.defaultRentalFee = defaultRentalFee;
        this.manufacturingCompany = manufacturingCompany;
        this.boardgameCategoryCode = boardgameCategoryCode;
        this.brand = brand;
        this.productImage = productImage;
        this.productImageUrl = productImageUrl;
        this.productDetailImage = productDetailImage;
        this.productDetailImageUrl = productDetailImageUrl;
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.SRentalFee = SRentalFee;
        this.ARentalFee = ARentalFee;
        this.BRentalFee = BRentalFee;
        this.SState = SState;
        this.AState = AState;
        this.BState = BState;
        this.storage = storage;
        this.detailInspectionCheckListDTOList = detailInspectionCheckListDTOList;
        this.requiredPartDTOList = requiredPartDTOList;
    }

    public MultipartFile getProductDetailImage() {
        return productDetailImage;
    }

    public void setProductDetailImage(MultipartFile productDetailImage) {
        this.productDetailImage = productDetailImage;
    }

    public String getProductDetailImageUrl() {
        return productDetailImageUrl;
    }

    public void setProductDetailImageUrl(String productDetailImageUrl) {
        this.productDetailImageUrl = productDetailImageUrl;
    }

    public int getBoardgameCategoryCode() {
        return boardgameCategoryCode;
    }

    public void setBoardgameCategoryCode(int boardgameCategoryCode) {
        this.boardgameCategoryCode = boardgameCategoryCode;
    }


    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public MultipartFile getProductImage() {
        return productImage;
    }

    public void setProductImage(MultipartFile productImage) {
        this.productImage = productImage;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    private List<DetailInspectionCheckListDTO> detailInspectionCheckListDTOList;
    private List<RequiredPartDTO> requiredPartDTOList;
    public ProductDTO(){}


    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public int getBoardgameTypeCode() {
        return boardgameTypeCode;
    }

    public void setBoardgameTypeCode(int boardgameTypeCode) {
        this.boardgameTypeCode = boardgameTypeCode;
    }

    public int getBoardgameType() {
        return boardgameType;
    }

    public void setBoardgameType(int boardgameType) {
        this.boardgameType = boardgameType;
    }

    public String getBoardgameName() {
        return boardgameName;
    }

    public void setBoardgameName(String boardgameName) {
        this.boardgameName = boardgameName;
    }

    public String getSoldOutYn() {
        return soldOutYn;
    }

    public void setSoldOutYn(String soldOutYn) {
        this.soldOutYn = soldOutYn;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getDefaultRentalFee() {
        return defaultRentalFee;
    }

    public void setDefaultRentalFee(int defaultRentalFee) {
        this.defaultRentalFee = defaultRentalFee;
    }

    public String getManufacturingCompany() {
        return manufacturingCompany;
    }

    public void setManufacturingCompany(String manufacturingCompany) {
        this.manufacturingCompany = manufacturingCompany;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getSRentalFee() {
        return SRentalFee;
    }

    public void setSRentalFee(int SRentalFee) {
        this.SRentalFee = SRentalFee;
    }

    public int getARentalFee() {
        return ARentalFee;
    }

    public void setARentalFee(int ARentalFee) {
        this.ARentalFee = ARentalFee;
    }

    public int getBRentalFee() {
        return BRentalFee;
    }

    public void setBRentalFee(int BRentalFee) {
        this.BRentalFee = BRentalFee;
    }

    public String getSState() {
        return SState;
    }

    public void setSState(String SState) {
        this.SState = SState;
    }

    public String getAState() {
        return AState;
    }

    public void setAState(String AState) {
        this.AState = AState;
    }

    public String getBState() {
        return BState;
    }

    public void setBState(String BState) {
        this.BState = BState;
    }

    public List<DetailInspectionCheckListDTO> getDetailInspectionCheckListDTOList() {
        return detailInspectionCheckListDTOList;
    }

    public void setDetailInspectionCheckListDTOList(List<DetailInspectionCheckListDTO> detailInspectionCheckListDTOList) {
        this.detailInspectionCheckListDTOList = detailInspectionCheckListDTOList;
    }

    public List<RequiredPartDTO> getRequiredPartDTOList() {
        return requiredPartDTOList;
    }

    public void setRequiredPartDTOList(List<RequiredPartDTO> requiredPartDTOList) {
        this.requiredPartDTOList = requiredPartDTOList;
    }
}

