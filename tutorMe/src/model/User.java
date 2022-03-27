/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Peggy
 */

public class User {
    String id;
    String userName;
    String password;    
    String Email;
    String phoneNo;
    String profileVisibility;

    public User(String userName, String Email, String phoneNo, String password, String profileVisibility) {
        
        this.userName = userName;
        this.password = password;
        
        this.Email = Email;
        this.phoneNo = phoneNo;
        this.profileVisibility = profileVisibility;
    }

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }
    
    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getProfileVisibility() {
        return profileVisibility;
    }
    
    
    
    
    
}
