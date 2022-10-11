package com.gozin.mainboard.product.dto;

import java.util.List;

public class DetailInspectionCheckListDTO {
    private int listCode;
    private int boardgameTypeCode;
    private String checkContent;
    public DetailInspectionCheckListDTO() {
    }

    public DetailInspectionCheckListDTO(int listCode, int boardgameTypeCode, String checkContent) {
        this.listCode = listCode;
        this.boardgameTypeCode = boardgameTypeCode;
        this.checkContent = checkContent;
    }

    @Override
    public String toString() {
        return "DetailInspectionCheckListDTO{" +
                "listCode=" + listCode +
                ", boardgameTypeCode=" + boardgameTypeCode +
                ", checkContent='" + checkContent + '\'' +
                '}';
    }

    public int getListCode() {
        return listCode;
    }

    public void setListCode(int listCode) {
        this.listCode = listCode;
    }

    public int getBoardgameTypeCode() {
        return boardgameTypeCode;
    }

    public void setBoardgameTypeCode(int boardgameTypeCode) {
        this.boardgameTypeCode = boardgameTypeCode;
    }

    public String getCheckContent() {
        return checkContent;
    }

    public void setCheckContent(String checkContent) {
        this.checkContent = checkContent;
    }
}
