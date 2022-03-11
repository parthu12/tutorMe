/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Login_Model;

/**
 *
 * @author parth
 */
public class LoginController {
    private Connection conn;

    public LoginController(Connection connection) {
        this.conn=connection;
        
    }
    public boolean login(Login_Model modelLogin)
    {
        String  query= "SELECT * FROM tbLogin WHERE username=? AND password=?";
        try {
            PreparedStatement pst=ConnectDB.getConnection().prepareStatement(query);
            pst.setString(1, modelLogin.getUname());
            pst.setString(2, modelLogin.getPass());
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                return true;
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
}
