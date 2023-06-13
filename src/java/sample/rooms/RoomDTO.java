/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.rooms;


/**
 *
 * @author KN
 */
public class RoomDTO {
    private String contractID;
    private String roomTitle;
    private String roomNumber;
    private String roomType;
    private float roomPrice;
    private String roomSize;
    private String roomImg;
    private String buildingID;
    private Boolean roomStatus;
    private String roomDescription;
    private String roomSellStatus;

    public RoomDTO() {
    }
    
    public RoomDTO(String contractID, String roomTitle, String roomNumber, String roomType, float roomPrice, String roomSize, String roomImg, String buildingID, Boolean roomStatus, String roomDescription, String roomSellStatus) {
        this.contractID = contractID;
        this.roomTitle = roomTitle;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.roomSize = roomSize;
        this.roomImg = roomImg;
        this.buildingID = buildingID;
        this.roomStatus = roomStatus;
        this.roomDescription = roomDescription;
        this.roomSellStatus = roomSellStatus;
    }

    public String getContractID() {
        return contractID;
    }

    public void setContractID(String contractID) {
        this.contractID = contractID;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public float getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(float roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(String roomSize) {
        this.roomSize = roomSize;
    }

    public String getRoomImg() {
        return roomImg;
    }

    public void setRoomImg(String roomImg) {
        this.roomImg = roomImg;
    }

    public String getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(String buildingID) {
        this.buildingID = buildingID;
    }

    public Boolean getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Boolean roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public String getRoomSellStatus() {
        return roomSellStatus;
    }

    public void setRoomSellStatus(String roomSellStatus) {
        this.roomSellStatus = roomSellStatus;
    }

    
    

    

   
  
}
