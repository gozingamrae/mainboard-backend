package com.gozin.mainboard.product.dto;

public class ProductDTO {
    private int boardgameType;
    private String boardgameName;
    private String soldOutYn;
    private int totalCount;
    private int deffaultrentalFee;
    private String manufacturingCompany;
    private String brand;
    private String categoryName;
    public ProductDTO(){}
    public ProductDTO(int boardgameType, String boardgameName, String soldOutYn, int totalCount, int deffaultrentalFee, String manufacturingCompany,
                      String brand, String categoryName) {
        this.boardgameType = boardgameType;
        this.boardgameName = boardgameName;
        this.soldOutYn = soldOutYn;
        this.totalCount = totalCount;
        this.deffaultrentalFee = deffaultrentalFee;
        this.manufacturingCompany = manufacturingCompany;
        this.brand = brand;
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "boardgameType=" + boardgameType +
                ", boardgameName='" + boardgameName + '\'' +
                ", soldOutYn='" + soldOutYn + '\'' +
                ", totalCount=" + totalCount +
                ", deffaultrentalFee=" + deffaultrentalFee +
                ", manufacturingCompany='" + manufacturingCompany + '\'' +
                ", brand='" + brand + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
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

    public int getDeffaultrentalFee() {
        return deffaultrentalFee;
    }

    public void setDeffaultrentalFee(int deffaultrentalFee) {
        this.deffaultrentalFee = deffaultrentalFee;
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
}
