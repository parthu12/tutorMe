/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import database.DBConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Admin;

/**
 *
 * @author Peggy
 */
public class AdminDAO {
    
    public boolean isValidAdmin(Admin admin)
    {
        String sql = "select userName, Password from users where userName = ? and Password = ?";
        
        try(Connection conn = DBConnectionManager.getConnection())
	{
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, admin.getUserName());
            ps.setString(2, admin.getPassword());
            ResultSet rs = ps.executeQuery();
            while(rs != null && rs.next())
            {
                if(rs.getString(1).equals(admin.getUserName()) && rs.getString(2).equals(admin.getPassword()))
                {
                    return true;
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
