/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author parth
 */
public class People {
     private String name;
    private int age;
    private String course;
    private String location;
    
    public void People (String name,int age,String location,String course){
        this.name = name;
        this.age = age;
        this.course = course;
        this.location = location;
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
    
}
