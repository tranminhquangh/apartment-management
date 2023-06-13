/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pro
 * 
 */
public class DBUtils implements Serializable {

    public static Connection getConnection() throws SQLException{
        Connection conn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databasename=Appartment Mangement";
            conn = DriverManager.getConnection(url, "sa", "123456");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return conn;
    }
}
