/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.accounts;

import sample.users.UserDTO;
import sample.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author KN
 */
public class AccountDAO {

    private static final String LOGIN1 = "SELECT Acc.Username,Password,RoleID, FullName, Phone, Gender, Birthday, Address, UserImg, UserStatus "
            + "FROM tblAccount Acc, tblUsers Usr  WHERE Acc.Username=? AND Urs.Username=?  AND Acc.Password=?";

    private static final String LOGIN = "SELECT Username,Password,RoleID FROM tblAccount WHERE Username=?  AND Password=?";

    public AccountDTO checkLogin(String userName, String password) throws SQLException {

        AccountDTO account = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(LOGIN);
                ptm.setString(1, userName);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String roleID = rs.getString("RoleID");

                    account = new AccountDTO(userName, password, roleID, true);
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
        return account;
    }
   
     public boolean singup(AccountDTO dto  ) {
         boolean check = false;
         Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "insert into tblAccount\n"
                + "values(?,?,?,1)";
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, dto.getUsername());
            ps.setString(2, dto.getPassword());
            ps.setString(3, dto.getRoleID());
            check = ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return check;
    }

    public boolean singup2(AccountDTO dto, UserDTO dto2) {
        boolean check = false;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = 
                 "INSERT INTO tblAccount(Username, Password, RoleID, AccountStatus)\n"
                + "  VALUES(?, ?,?,1);\n"
                + "INSERT INTO tblUsers(Username, FullName) \n"
                + "  VALUES(?,?);\n"
                ;
        try {
            con = DBUtils.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, dto.getUsername());
            ps.setString(2, dto.getPassword());
            ps.setString(3, dto.getRoleID());
            ps.setString(4, dto2.getUserName());
            ps.setString(5, dto2.getFullName());
            check = ps.executeUpdate() > 0;
        } catch (Exception e) {
        }
        return check;
    }
}
