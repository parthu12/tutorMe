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
    private String results;
    private Resources resources;
    
    
    private void setAssignment(Assignment a){
        assignment = a;
    }
    
    private Assignment getAssignment(){
        return assignment;
    }
    
    private void setResults(String r){
        results = r;
    }
    
    private String getResults(){
        return results;
    }
    
    
}
