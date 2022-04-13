/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.util.ArrayList;

/**
 *
 * @author parth
 * collect announcements 
 */
public class Announcements {
    public ArrayList <String> announcements;
    
    //get list of announcements
    public ArrayList <String> getAnnouncements(){
        return announcements;
    }
   
    //set announcments to an array list
    private void setAnnouncements(ArrayList <String> a){
        announcements =a ;
    }
    
}
