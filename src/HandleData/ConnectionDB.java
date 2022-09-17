/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HandleData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class ConnectionDB {
    private String url = "jdbc:sqlserver://localhost:1433;databaseName=qlvpp";
    private String user = "sa";
    private String password = "1234$";
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(url,user,password);
        return con;
    }
}
