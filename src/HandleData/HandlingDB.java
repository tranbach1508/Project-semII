/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HandleData;

import entities.Account;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class HandlingDB {
    Connection con;

    public HandlingDB() {
        try {
            con = new ConnectionDB().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HandlingDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HandlingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Account> login(){
        List<Account> acc = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from account");
            while(rs.next()){
                acc.add(new Account(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HandlingDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acc;
    }
}
