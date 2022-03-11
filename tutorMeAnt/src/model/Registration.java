/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author parth
 */
public class Registration {
    private Course course;
    private String time;
    private String location;
    private Tutor tutor;
    
    public Registration(Course c, String t, String l, Tutor tu){
        tutor = tu;
        course = c;
        time = t;
        location = l;       
    }
    
    
    
}
