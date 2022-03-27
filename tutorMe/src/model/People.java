/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author parth
 */
public class People {
     private String name;
    private int age;
    private String course;
    private String location;
    private String description;
    
    public void People (String name,int age,String location,String course, String description){
        this.name = name;
        this.age = age;
        this.course = course;
        this.location = location;
        this.description = description;
    }
    
    public String getName(){
        return this.name;
    }
    
    //set name
    public void setName(String name){
         this.name = name;
    }
    public String getCourse(){
        return this.course;
    }
    public void setCourse(String course){
         this.course = course;
    }
    public int getAge(){
        return this.age;
    }
    
    public void setage(int age){
         this.age = age;
    }
    public String getLocation(){
        return this.location;
    }
    
    public void setLocation(String location){
         this.location = location;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getDescription(){
        return this.description;
    }
}
