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
    private String path;
    
    //getInput file
    private File getFile(){
        return file;
    }
    
    //get File path
    private String getPath(){
        return path;
    }
    
    //set filepath
    private void setPath(String d) {
        path = d;
    }
    
}
