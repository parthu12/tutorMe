/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jia
 */
public class University {
    private String university;
    private String place;

    University(String u,String p){
        university = u;
        place = p;
    }

    /**
     * @return the place
     */
    public String getUniversity() {
        return university;
    }
    
    /**
     * @return the place
     */
    public String getPlace() {
        return place;
    }
    
}
