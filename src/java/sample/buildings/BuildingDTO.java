/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.buildings;

/**
 *
 * @author KN
 */
public class BuildingDTO {
      private String buildingID;
      private String buildingName;
      private String discription;

    public BuildingDTO(String buildingID, String buildingName, String discription) {
        this.buildingID = buildingID;
        this.buildingName = buildingName;
        this.discription = discription;
    }

    public BuildingDTO() {
    }

    public String getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(String buildingID) {
        this.buildingID = buildingID;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
   
}
