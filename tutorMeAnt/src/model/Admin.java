/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Peggy
 */
public class Admin {
    
    String userName;
    String password;
    
    public Admin(String userName, String password)
    {
        
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }
    
    
    public String getPassword() {
	return password;
    }
    
}
