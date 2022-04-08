/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.io.File;

/**
 *
 * @author parth
 */
public class Resources extends Course {
    private ArrayList <File> resources;
    private ArrayList <File> getResources(){
        return resources;
    }
    
    private void setResources(ArrayList <File> r){
        resources = r;
    }
}
