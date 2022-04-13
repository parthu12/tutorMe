/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author parth
 */
public class Course {
    private Assignment assignment;
    private String course;
    private String time;
    private String tutor;
    private String location;
    
    
    
    //set assignment
    private void setAssignment(Assignment a){
        assignment = a;
    }
    
    //get assignment
    private Assignment getAssignment(){
        return assignment;
    }
    
    //set course
    private void setCourse(String r){
        course = r;
    }
    
    //get Course
    private String getCourse(){
        return course;
    }
    
    //set location
    private void setlocation(String r){
        location = r;
    }
    
    //get Course
    private String getlocation(){
        return location;
    }
    
    //set tutor
    private void setTutor(String r){
        tutor = r;
    }
    
    //get tutor
    private String getTutor(){
        return tutor;
    }
    
    //set time
    private void setTime(String r){
        time = r;
    }
    
    //get time
    private String getTime(){
        return time;
    }
    
    
}
