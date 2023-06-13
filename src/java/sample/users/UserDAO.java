/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sample.utils.DBUtils;

/**
 *
 * @author tranp
 */
public class UserDAO {
    private static final String GET_USER = "SELECT Username,FullName, Phone, Gender, Birthday, Address, UserImg, UserStatus,UserEmail FROM tblUsers WHERE Username=?";
    
    private static final String UPDATE_USER ="UPDATE tblUsers SET FullName=?,Phone=?,Gender=?,Birthday=?,Address=?,UserImg=?,UserEmail=?"
                                                + " WHERE Username=?";
    
    public UserDTO getUserInfo(String userName) throws SQLException{
       

        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try{
            conn =  DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(GET_USER);
                ptm.setString(1, userName);

                rs = ptm.executeQuery();
                if(rs.next()){
                    String fullName = rs.getString("Fullname");
                    String phone = rs.getString("Phone");
                    String gender = rs.getString("Gender");
                    String birthday = rs.getString("Birthday");
                    String address = rs.getString("Address");
                    String userImg = rs.getString("UserImg");
                    String usrStatus;
                    int userStatus = rs.getInt("UserStatus");
                    if(userStatus==1){
                        usrStatus="Living in apartment";
                    }else{
                        usrStatus="No longer live in apartment";
                    }
                    String userEmail = rs.getString("UserEmail");
                    
                    user = new UserDTO(userName,fullName,phone,address,gender,birthday,userImg,usrStatus,userEmail); 
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            if(rs!=null) rs.close();
            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        
        }
        return user;
    }
    
    public boolean updateUser(UserDTO user) throws SQLException{
        boolean check=false;
        Connection conn=null;
        PreparedStatement ptm=null;
        try{
            conn =  DBUtils.getConnection();
            if(conn!=null){
                ptm = conn.prepareStatement(UPDATE_USER);
                
                ptm.setString(1, user.getFullName());
                ptm.setString(2, user.getPhone());
                ptm.setString(3, user.getGender());
                ptm.setString(4, user.getBirthday());
                ptm.setString(5, user.getAddress());
                ptm.setString(6, user.getUserImg());
                ptm.setString(7, user.getUserEmail());
 
                ptm.setString(8, user.getUserName());
                
                check=ptm.executeUpdate()>0?true:false;            
            }
          
        } catch(Exception e){
            e.printStackTrace();
        } finally{

            if(ptm!=null) ptm.close();
            if(conn!=null) conn.close();
        
        }
        return check;
    }
}
