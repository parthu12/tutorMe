/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.util.Date;

/**
 *
 * @author parth
 */
public class Assignment extends Course{
    private File file;
    private Date due;
    
    private File getFile(){
        return file;
    }
    
    private Date getDueDate(){
        return due;
    }
    
    private void setDueDate(Date d) {
        due = d;
    }
    
}
