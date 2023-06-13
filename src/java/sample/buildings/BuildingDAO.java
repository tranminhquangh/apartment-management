/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.buildings;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sample.utils.DBUtils;

/**
 *
 * @author KN
 */
public class BuildingDAO {
    Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
    List<BuildingDTO> listBuilding;

    public List<BuildingDTO> getListCategory() {
        return listBuilding;
    }

    public List<BuildingDTO> getAllCategory()  throws NamingException, SQLException {
             List<BuildingDTO> list = new ArrayList<>();
           
      
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select BuildingID, BuildingName,BuildingDetail From tblBuildings";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String buildingID = rs.getString("BuildingID");
                    String buildingName = rs.getString("BuildingName");
                    String discription = rs.getString("BuildingDetail");
                    if (this.listBuilding == null) {
                        this.listBuilding = new ArrayList<>();
                    }
                    this.listBuilding.add(new BuildingDTO(buildingID, buildingName, discription));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        
    
}return list;
    }
    public List<BuildingDTO> getBuilding() {
        List<BuildingDTO> list = new ArrayList<>();
        String query = "select * from tblBuildings";
        try {
             con = DBUtils.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new BuildingDTO(rs.getString(1),
                        rs.getString(2),
                rs.getString(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
