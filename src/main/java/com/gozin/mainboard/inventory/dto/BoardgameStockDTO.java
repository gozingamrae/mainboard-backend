package com.gozin.mainboard.inventory.dto;

public class BoardgameStockDTO {
    private int serialCode;
    private int boardgameTypeCode;
    private String storageLocation;
    private String rentalCycle;
    private int ratingCode;

    private String boardgameName;

    public String getBoardgameName() {
        return boardgameName;
    }

    public void setBoardgameName(String boardgameName) {
        this.boardgameName = boardgameName;
    }

    public BoardgameStockDTO(){}

    public BoardgameStockDTO(int serialCode, int boardgameTypeCode, String storageLocation, String rentalCycle, int ratingCode) {
        this.serialCode = serialCode;
        this.boardgameTypeCode = boardgameTypeCode;
        this.storageLocation = storageLocation;
        this.rentalCycle = rentalCycle;
        this.ratingCode = ratingCode;
    }

    @Override
    public String toString() {
        return "BoardgameStockDTO{" +
                "serialCode=" + serialCode +
                ", boardgameTypeCode=" + boardgameTypeCode +
                ", storageLocation='" + storageLocation + '\'' +
                ", rentalCycle='" + rentalCycle + '\'' +
                ", ratingCode=" + ratingCode +
                '}';
    }

    public int getSerialCode() {
        return serialCode;
    }

    public void setSerialCode(int serialCode) {
        this.serialCode = serialCode;
    }

    public int getBoardgameTypeCode() {
        return boardgameTypeCode;
    }

    public void setBoardgameTypeCode(int boardgameTypeCode) {
        this.boardgameTypeCode = boardgameTypeCode;
    }

    public String getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(String storageLocation) {
        this.storageLocation = storageLocation;
    }

    public String getRentalCycle() {
        return rentalCycle;
    }

    public void setRentalCycle(String rentalCycle) {
        this.rentalCycle = rentalCycle;
    }

    public int getRatingCode() {
        return ratingCode;
    }

    public void setRatingCode(int ratingCode) {
        this.ratingCode = ratingCode;
    }
}
