package com.gozin.mainboard.product.dto;

public class RequiredPartDTO {
    private int partsCode;
    private int boardgameTypeCode;
    private String partsName;
    private int partsCount;

    public RequiredPartDTO(){}

    public RequiredPartDTO(int partsCode, int boardgameTypeCode, String partsName, int partsCount) {
        this.partsCode = partsCode;
        this.boardgameTypeCode = boardgameTypeCode;
        this.partsName = partsName;
        this.partsCount = partsCount;
    }

    @Override
    public String toString() {
        return "RequiredPartDTO{" +
                "partsCode=" + partsCode +
                ", boardgameTypeCode=" + boardgameTypeCode +
                ", partsName='" + partsName + '\'' +
                ", partsCount=" + partsCount +
                '}';
    }

    public int getPartsCode() {
        return partsCode;
    }

    public void setPartsCode(int partsCode) {
        this.partsCode = partsCode;
    }

    public int getBoardgameTypeCode() {
        return boardgameTypeCode;
    }

    public void setBoardgameTypeCode(int boardgameTypeCode) {
        this.boardgameTypeCode = boardgameTypeCode;
    }

    public String getPartsName() {
        return partsName;
    }

    public void setPartsName(String partsName) {
        this.partsName = partsName;
    }

    public int getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }
}
