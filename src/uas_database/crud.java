/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lenovo
 */
public class crud {
    private Connection CRUDconnection;

    private PreparedStatement CRUDpsmt;

    private Statement CRUDstat;

    private ResultSet result;

    private String CRUDquery;
    
    private String id;
    
    public crud() {
        mariadbConnection connection = new mariadbConnection();
        CRUDconnection = connection.getConnection();
    }
    
    public void setID(String id) {
        this.id = id;
    }
    
    public String getID(){
        return id;
    }
    
    public void saveData(String id) {
        CRUDquery = "INSERT INTO coba(id) VALUES (?)";
        try {
            CRUDpsmt = CRUDconnection.prepareStatement(CRUDquery);
            CRUDpsmt.setString(1, id);
            CRUDpsmt.executeUpdate();
            CRUDpsmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
