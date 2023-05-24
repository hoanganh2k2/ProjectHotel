/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
    Connection con = null;
    String serverName = "LAPTOP-1FA78907\\SQLEXPRESS:1433";
    String databaseName = "QL_Hotel";
    String username = "sa";
    String password = "123";

    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");      
            String url = "jdbc:sqlserver://" + serverName + ";databaseName=" + databaseName + ";encrypt=false";
            this.con = (Connection) DriverManager.getConnection(url, username, password);
            System.err.println("Successful Connection Data");
            return this.con;
        } catch (SQLException | ClassNotFoundException e) {
            e.getStackTrace();
            System.err.println("Connection Data Fail!");
            return null;
        } 
    }
}
