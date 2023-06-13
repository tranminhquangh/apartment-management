/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.rooms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sample.utils.DBUtils;

/**
 *
 * @author KN
 */
public class RoomDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    List<RoomDTO> list;
    //for customer    

    private static final String SEARCH = "SELECT ContractID,RoomTitle,RoomNumber,RoomType,RoomPrice,RoomSize,RoomImg,BuildingID,RoomStatus FROM tblRooms WHERE (RoomNumber like ? OR RoomTitle like ?) AND RoomSellStatus = 'Being sold'";
    
    private static final String FILTER_BY_BUILDING= "SELECT ContractID,RoomTitle,RoomNumber,RoomType,RoomPrice,RoomSize,RoomImg,BuildingID,RoomStatus FROM tblRooms WHERE BuildingID=? ";
    
    private static final String FILTER_BY_PRICE = "SELECT ContractID,RoomTitle,RoomNumber,RoomType,RoomPrice,RoomSize,RoomImg,BuildingID,RoomStatus FROM tblRooms WHERE RoomPrice BETWEEN ? AND ? ";
    
    private static final String FILTER_BY_TYPE = "SELECT ContractID,RoomTitle,RoomNumber,RoomType,RoomPrice,RoomSize,RoomImg,BuildingID,RoomStatus FROM tblRooms WHERE RoomType=?";

    //for Admin   
    private static final String SEARCH_ADMIN = "SELECT ContractID,RoomNumber,RoomType,RoomPrice,RoomSize,RoomImg,BuildingID,RoomStatus FROM tblRooms WHERE RoomNumber like ?";
    
    private static final String SEARCH_BY_STATUS = "SELECT ContractID,RoomNumber,RoomType,RoomPrice,RoomSize,RoomImg,BuildingID,RoomStatus FROM tblRooms WHERE RoomStatus = ?";
   
    private static final String INSERT_ROOM = "UPDATE tblRooms SET RoomStatus=?  WHERE RoomNumber=?";
    
    private static final String UPDATE_EMPTY_ROOM = "UPDATE tblRooms SET RoomStatus=0  WHERE RoomNumber=?";

    //for Seller
    private static final String SEARCH_EMPTY_ROOM = "SELECT A.ContractID,RoomTitle,RoomNumber,RoomType,RoomPrice,RoomSize,RoomImg,BuildingID,RoomStatus,RoomSellStatus \n" +
                                                    "FROM tblRooms A, tblContracts B\n" +
                                                    "WHERE  (RoomTitle like ? OR RoomNumber like ?) AND B.Username = ? AND A.ContractID = B.ContractID";
    
    private static final String SELLER_FILTER_BY_BUILDING= "SELECT A.ContractID,RoomTitle,RoomNumber,RoomType,RoomPrice,RoomSize,RoomImg,BuildingID,RoomStatus,RoomSellStatus \n" +
                                                    "FROM tblRooms A, tblContracts B\n" +
                                                    "WHERE B.Username = ? AND A.BuidlingID=? AND A.ContractID = B.ContractID  ";
    
    private static final String SELLER_FILTER_BY_PRICE = "SELECT A.ContractID,RoomTitle,RoomNumber,RoomType,RoomPrice,RoomSize,RoomImg,BuildingID,RoomStatus,RoomSellStatus \n" +
                                                    "FROM tblRooms A, tblContracts B\n" +
                                                    "WHERE B.Username = ? AND (RoomPrice BETWEEN ? AND ?) AND A.ContractID = B.ContractID ";
    
    private static final String SELLER_FILTER_BY_TYPE = "SELECT A.ContractID,RoomTitle,RoomNumber,RoomType,RoomPrice,RoomSize,RoomImg,BuildingID,RoomStatus,RoomSellStatus \n" +
                                                    "FROM tblRooms A, tblContracts B\n" +
                                                    "WHERE B.Username = ? AND A.RoomType=? AND A.ContractID = B.ContractID ";
    
    private static final String GET_EMPTY_ROOM = "SELECT RoomTitle,RoomNumber,RoomType,RoomPrice,RoomSize,RoomImg,BuildingID,RoomStatus,RoomDescription,RoomSellStatus FROM tblRooms WHERE ContractID = ?";
    
    private static final String EDIT_EMPTY_ROOM = "UPDATE tblRooms SET RoomTitle=?,RoomPrice=?,RoomDescription=? WHERE ContractID = ?";
    
    private static final String UPDATE_ROOM_SELL_STATUS = "UPDATE tblRooms SET RoomSellStatus = 'Being sold' WHERE ContractID = ?";

    //for Buyer
    private static final String GET_ROOM = "SELECT RoomTitle,RoomNumber,RoomType,RoomPrice,RoomSize,RoomImg,BuildingID,RoomStatus,RoomDescription FROM tblRooms WHERE ContractID = ?";

    //when buyer buys room 
    private static final String UPDATE_ROOM_STATUS = "UPDATE tblRooms SET RoomStatus=1 WHERE ContractID=?";
    
    private static final String UPDATE_ROOM_CONTRACT_ID = "UPDATE tblRooms SET ContractID=? WHERE RoomNumber=?";

    
    public List<RoomDTO> getListBook() {
        return list;
    }

    public List<RoomDTO> getRoomByBID(String bid) {
        List<RoomDTO> list = new ArrayList<>();
        String query = "select * from tblRooms\n"
                + "where ContractID = ?";
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, bid);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("ContractID");
                String rNum = rs.getString("RoomNumber");
                String rType = rs.getString("RoomType");
                float rPrice = rs.getFloat("RoomPrice");
                String rSize = rs.getString("RoomSize");
                String rImg = rs.getString("RoomImg");
                String bID = rs.getString("BuildingID");
                boolean rStatus = rs.getBoolean("RoomStatus");

                RoomDTO dto = new RoomDTO(id, "", rNum, rType, rPrice, rSize, rImg, bID, rStatus, "", "");
                list.add(dto);
            }
        } catch (Exception e) {
        }
        return list;

    }

    public RoomDTO getByID(String id)
            throws SQLException, NamingException, ParseException {

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "Select * "
                        + "From tblRooms Where ContractID = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {

                    String rNum = rs.getString("RoomNumber");
                    String rType = rs.getString("RoomType");
                    float rPrice = rs.getFloat("RoomPrice");
                    String rSize = rs.getString("RoomSize");
                    String rImg = rs.getString("RoomImg");
                    String bID = rs.getString("BuildingID");
                    boolean rStatus = rs.getBoolean("RoomStatus");

                    RoomDTO dto = new RoomDTO(id, "", rNum, rType, rPrice, rSize, rImg, bID, rStatus, "", "");
                    return dto;
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
        }
        return null;
    }

    //for customer at home page
    public List<RoomDTO> getSearchListRoom(String search) throws SQLException { //return user list
        List<RoomDTO> list = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                //String sql = "Select RoomNumber,RoomType,RoomPrice,RoomSize,RoomImg,BuildingID,RoomStatus From tblRooms Where RoomNumber = ?";
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%" + search + "%");
                ptm.setString(2, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String contractID = rs.getString("ContractID");
                    String roomTitle = rs.getString("RoomTitle");
                    String roomNumber = rs.getString("RoomNumber");
                    String roomType = rs.getString("RoomType");
                    float roomPrice = rs.getFloat("RoomPrice");
                    String roomSize = rs.getString("RoomSize");
                    String roomImg = rs.getString("RoomImg");
                    String BuildingID = rs.getString("BuildingID");
                    boolean status;
                    int roomStatus = rs.getInt("RoomStatus");
                    if (roomStatus == 1) {
                        status = true;
                    } else {
                        status = false;
                    }

                    list.add(new RoomDTO(contractID, roomTitle, roomNumber, roomType, roomPrice, roomSize, roomImg, BuildingID, status, "", ""));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
   
public boolean updateRoomContractID(String contractID,String roomNumber) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_ROOM_CONTRACT_ID);
                ptm.setString(1, contractID);
                ptm.setString(2, roomNumber);

                check = ptm.executeUpdate() > 0 ? true : false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return check;
    }



    public List<RoomDTO> filterListRoomByBuilding(String buildingID) throws SQLException { //return user list
        List<RoomDTO> list = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                //String sql = "Select RoomNumber,RoomType,RoomPrice,RoomSize,RoomImg,BuildingID,RoomStatus From tblRooms Where RoomNumber = ?";
                ptm = conn.prepareStatement(FILTER_BY_BUILDING);
                ptm.setString(1,buildingID);

                rs = ptm.executeQuery();
                while (rs.next()) {
                    String contractID = rs.getString("ContractID");
                    String roomTitle = rs.getString("RoomTitle");
                    String roomNumber = rs.getString("RoomNumber");
                    String roomType = rs.getString("RoomType");
                    float roomPrice = rs.getFloat("RoomPrice");
                    String roomSize = rs.getString("RoomSize");
                    String roomImg = rs.getString("RoomImg");
                    String BuildingID = rs.getString("BuildingID");
                    boolean status;
                    int roomStatus = rs.getInt("RoomStatus");
                    if (roomStatus == 1) {
                        status = true;
                    } else {
                        status = false;
                    }

                    list.add(new RoomDTO(contractID, roomTitle, roomNumber, roomType, roomPrice, roomSize, roomImg, BuildingID, status, "", ""));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    
    public List<RoomDTO> filterListRoomByPrice(float min, float max) throws SQLException { //return user list
        List<RoomDTO> list = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                //String sql = "Select RoomNumber,RoomType,RoomPrice,RoomSize,RoomImg,BuildingID,RoomStatus From tblRooms Where RoomNumber = ?";
                ptm = conn.prepareStatement(FILTER_BY_PRICE);
                ptm.setFloat(1,min);
                ptm.setFloat(2,max);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String contractID = rs.getString("ContractID");
                    String roomTitle = rs.getString("RoomTitle");
                    String roomNumber = rs.getString("RoomNumber");
                    String roomType = rs.getString("RoomType");
                    float roomPrice = rs.getFloat("RoomPrice");
                    String roomSize = rs.getString("RoomSize");
                    String roomImg = rs.getString("RoomImg");
                    String BuildingID = rs.getString("BuildingID");
                    boolean status;
                    int roomStatus = rs.getInt("RoomStatus");
                    if (roomStatus == 1) {
                        status = true;
                    } else {
                        status = false;
                    }

                    list.add(new RoomDTO(contractID, roomTitle, roomNumber, roomType, roomPrice, roomSize, roomImg, BuildingID, status, "", ""));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    
    public List<RoomDTO> filterListRoomByType(String type) throws SQLException { //return user list
        List<RoomDTO> list = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                //String sql = "Select RoomNumber,RoomType,RoomPrice,RoomSize,RoomImg,BuildingID,RoomStatus From tblRooms Where RoomNumber = ?";
                ptm = conn.prepareStatement(FILTER_BY_TYPE);
                ptm.setString(1,type);

                rs = ptm.executeQuery();
                while (rs.next()) {
                    String contractID = rs.getString("ContractID");
                    String roomTitle = rs.getString("RoomTitle");
                    String roomNumber = rs.getString("RoomNumber");
                    String roomType = rs.getString("RoomType");
                    float roomPrice = rs.getFloat("RoomPrice");
                    String roomSize = rs.getString("RoomSize");
                    String roomImg = rs.getString("RoomImg");
                    String BuildingID = rs.getString("BuildingID");
                    boolean status;
                    int roomStatus = rs.getInt("RoomStatus");
                    if (roomStatus == 1) {
                        status = true;
                    } else {
                        status = false;
                    }

                    list.add(new RoomDTO(contractID, roomTitle, roomNumber, roomType, roomPrice, roomSize, roomImg, BuildingID, status, "", ""));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    
    //seller
    public List<RoomDTO> getEmptySearchListRoom(String search, String userName) throws SQLException { //return user list
        List<RoomDTO> list = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                //String sql = "Select RoomNumber,RoomType,RoomPrice,RoomSize,RoomImg,BuildingID,RoomStatus From tblRooms Where RoomNumber = ?";
                ptm = conn.prepareStatement(SEARCH_EMPTY_ROOM);
                ptm.setString(1, "%" + search + "%");
                ptm.setString(2, "%" + search + "%");
                ptm.setString(3, userName);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String contractID = rs.getString("ContractID");
                    String roomTitle = rs.getString("RoomTitle");
                    String roomNumber = rs.getString("RoomNumber");
                    String roomType = rs.getString("RoomType");
                    float roomPrice = rs.getFloat("RoomPrice");
                    String roomSize = rs.getString("RoomSize");
                    String roomImg = rs.getString("RoomImg");
                    String BuildingID = rs.getString("BuildingID");
                    boolean status;
                    int roomStatus = rs.getInt("RoomStatus");
                    if (roomStatus == 1) {
                        status = true;
                    } else {
                        status = false;
                    }
                    String sellStatus = rs.getString("RoomSellStatus");
                    list.add(new RoomDTO(contractID, roomTitle, roomNumber, roomType, roomPrice, roomSize, roomImg, BuildingID, status, "", sellStatus));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    
    public List<RoomDTO> filterListEmptyRoomByBuilding(String buildingID, String userName) throws SQLException { //return user list
        List<RoomDTO> list = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                //String sql = "Select RoomNumber,RoomType,RoomPrice,RoomSize,RoomImg,BuildingID,RoomStatus From tblRooms Where RoomNumber = ?";
                ptm = conn.prepareStatement(SELLER_FILTER_BY_BUILDING);
                ptm.setString(1, userName);
                ptm.setString(2, buildingID);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String contractID = rs.getString("ContractID");
                    String roomTitle = rs.getString("RoomTitle");
                    String roomNumber = rs.getString("RoomNumber");
                    String roomType = rs.getString("RoomType");
                    float roomPrice = rs.getFloat("RoomPrice");
                    String roomSize = rs.getString("RoomSize");
                    String roomImg = rs.getString("RoomImg");
                    String BuildingID = rs.getString("BuildingID");
                    boolean status;
                    int roomStatus = rs.getInt("RoomStatus");
                    if (roomStatus == 1) {
                        status = true;
                    } else {
                        status = false;
                    }
                    String sellStatus = rs.getString("RoomSellStatus");
                    list.add(new RoomDTO(contractID, roomTitle, roomNumber, roomType, roomPrice, roomSize, roomImg, BuildingID, status, "", sellStatus));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    public List<RoomDTO> filterListEmptyRoomByPrice(float min,float max, String userName) throws SQLException { //return user list
        List<RoomDTO> list = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                //String sql = "Select RoomNumber,RoomType,RoomPrice,RoomSize,RoomImg,BuildingID,RoomStatus From tblRooms Where RoomNumber = ?";
                ptm = conn.prepareStatement(SELLER_FILTER_BY_PRICE);
                ptm.setString(1, userName);
                ptm.setFloat(2, min);
                ptm.setFloat(3, max);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String contractID = rs.getString("ContractID");
                    String roomTitle = rs.getString("RoomTitle");
                    String roomNumber = rs.getString("RoomNumber");
                    String roomType = rs.getString("RoomType");
                    float roomPrice = rs.getFloat("RoomPrice");
                    String roomSize = rs.getString("RoomSize");
                    String roomImg = rs.getString("RoomImg");
                    String BuildingID = rs.getString("BuildingID");
                    boolean status;
                    int roomStatus = rs.getInt("RoomStatus");
                    if (roomStatus == 1) {
                        status = true;
                    } else {
                        status = false;
                    }
                    String sellStatus = rs.getString("RoomSellStatus");
                    list.add(new RoomDTO(contractID, roomTitle, roomNumber, roomType, roomPrice, roomSize, roomImg, BuildingID, status, "", sellStatus));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    public List<RoomDTO> filterListEmptyRoomByType(String type, String userName) throws SQLException { //return user list
        List<RoomDTO> list = new ArrayList<>();

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                //String sql = "Select RoomNumber,RoomType,RoomPrice,RoomSize,RoomImg,BuildingID,RoomStatus From tblRooms Where RoomNumber = ?";
                ptm = conn.prepareStatement(SELLER_FILTER_BY_TYPE);
                ptm.setString(1, userName);
                ptm.setString(2, type);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String contractID = rs.getString("ContractID");
                    String roomTitle = rs.getString("RoomTitle");
                    String roomNumber = rs.getString("RoomNumber");
                    String roomType = rs.getString("RoomType");
                    float roomPrice = rs.getFloat("RoomPrice");
                    String roomSize = rs.getString("RoomSize");
                    String roomImg = rs.getString("RoomImg");
                    String BuildingID = rs.getString("BuildingID");
                    boolean status;
                    int roomStatus = rs.getInt("RoomStatus");
                    if (roomStatus == 1) {
                        status = true;
                    } else {
                        status = false;
                    }
                    String sellStatus = rs.getString("RoomSellStatus");
                    list.add(new RoomDTO(contractID, roomTitle, roomNumber, roomType, roomPrice, roomSize, roomImg, BuildingID, status, "", sellStatus));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    
    public RoomDTO getEmptyRoomDetail(String contractID) throws SQLException { //return user list
        RoomDTO room = new RoomDTO();

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                //String sql = "Select RoomNumber,RoomType,RoomPrice,RoomSize,RoomImg,BuildingID,RoomStatus From tblRooms Where RoomNumber = ?";
                ptm = conn.prepareStatement(GET_EMPTY_ROOM);
                ptm.setString(1, contractID);
                rs = ptm.executeQuery();
                while (rs.next()) {

                    String roomTitle = rs.getString("RoomTitle");
                    String roomNumber = rs.getString("RoomNumber");
                    String roomType = rs.getString("RoomType");
                    float roomPrice = rs.getFloat("RoomPrice");
                    String roomSize = rs.getString("RoomSize");
                    String roomImg = rs.getString("RoomImg");
                    String buildingID = rs.getString("BuildingID");
                    boolean status;
                    int roomStatus = rs.getInt("RoomStatus");
                    if (roomStatus == 1) {
                        status = true;
                    } else {
                        status = false;
                    }
                    String roomDescription = rs.getString("RoomDescription");
                    String sellStatus = rs.getString("RoomSellStatus");
                    room = new RoomDTO(contractID, roomTitle, roomNumber, roomType, roomPrice, roomSize, roomImg, buildingID, status, roomDescription, sellStatus);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return room;
    }

    public boolean editEmptyRoom(RoomDTO room) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(EDIT_EMPTY_ROOM);

                ptm.setString(1, room.getRoomTitle());
                ptm.setFloat(2, room.getRoomPrice());
                ptm.setString(3, room.getRoomDescription());
                ptm.setString(4, room.getContractID());

                check = ptm.executeUpdate() > 0 ? true : false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return check;
    }

    //buyer
    public RoomDTO getRoomDetail(String contractID) throws SQLException { //return user list
        RoomDTO room = new RoomDTO();

        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                //String sql = "Select RoomNumber,RoomType,RoomPrice,RoomSize,RoomImg,BuildingID,RoomStatus From tblRooms Where RoomNumber = ?";
                ptm = conn.prepareStatement(GET_ROOM);
                ptm.setString(1, contractID);
                rs = ptm.executeQuery();
                while (rs.next()) {

                    String roomTitle = rs.getString("RoomTitle");
                    String roomNumber = rs.getString("RoomNumber");
                    String roomType = rs.getString("RoomType");
                    float roomPrice = rs.getFloat("RoomPrice");
                    String roomSize = rs.getString("RoomSize");
                    String roomImg = rs.getString("RoomImg");
                    String buildingID = rs.getString("BuildingID");
                    boolean status;
                    int roomStatus = rs.getInt("RoomStatus");
                    if (roomStatus == 1) {
                        status = true;
                    } else {
                        status = false;
                    }
                    String roomDescription = rs.getString("RoomDescription");
                    room = new RoomDTO(contractID, roomTitle, roomNumber, roomType, roomPrice, roomSize, roomImg, buildingID, status, roomDescription, "");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return room;
    }

    public boolean updateRoomStatus(String contractID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_ROOM_STATUS);

                ptm.setString(1, contractID);

                check = ptm.executeUpdate() > 0 ? true : false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return check;
    }
    
    public boolean updateRoomContractID(String roomNumber) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_ROOM_CONTRACT_ID);

                ptm.setString(1, roomNumber);

                check = ptm.executeUpdate() > 0 ? true : false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return check;
    }

    public boolean updateRoomSellStatus(String contractID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE_ROOM_SELL_STATUS);

                ptm.setString(1, contractID);

                check = ptm.executeUpdate() > 0 ? true : false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return check;
    }

}
