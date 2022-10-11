package com.gozin.mainboard.product.dto;

public class SearchProductDTO {
    private int boardgameTypeCode;
    private String boardgameName;
    private String categoryName;
    private String brand;
    private int minFee;
    private int maxFee;

    public SearchProductDTO(){}

    public SearchProductDTO(int boardgameTypeCode, String boardgameName, String categoryName, String brand, int minFee, int maxFee) {
        this.boardgameTypeCode = boardgameTypeCode;
        this.boardgameName = boardgameName;
        this.categoryName = categoryName;
        this.brand = brand;
        this.minFee = minFee;
        this.maxFee = maxFee;
    }

    @Override
    public String toString() {
        return "SearchProductDTO{" +
                "boardgameTypeCode=" + boardgameTypeCode +
                ", boardgameName='" + boardgameName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", brand='" + brand + '\'' +
                ", minFee=" + minFee +
                ", maxFee=" + maxFee +
                '}';
    }

    public int getBoardgameTypeCode() {
        return boardgameTypeCode;
    }

    public void setBoardgameTypeCode(int boardgameTypeCode) {
        this.boardgameTypeCode = boardgameTypeCode;
    }

    public String getBoardgameName() {
        return boardgameName;
    }

    public void setBoardgameName(String boardgameName) {
        this.boardgameName = boardgameName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMinFee() {
        return minFee;
    }

    public void setMinFee(int minFee) {
        this.minFee = minFee;
    }

    public int getmaxFee() {
        return maxFee;
    }

    public void setmaxFee(int maxFee) {
        this.maxFee = maxFee;
    }
}
