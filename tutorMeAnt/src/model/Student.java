package model;

/**
 *
 * @author Peggy
 */

public class Student {
	
    
    private int age;
    private String course;
    private String location;
    private String description;
    private String status;
    private double gpa;
    
    public Student (int age,String location,double gpa,String course, String description,String status){
        
        this.age = age;
        this.location = location;
        this.gpa=gpa;
        this.course = course;        
        this.description = description;
        this.status=status;
        
    }

    public int getAge() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    

    public String getCourse() {
        return course;
    }

    public String getStatus() {
        return status;
    }

    public double getGpa() {
        return gpa;
    }
    

	
	
	
	
	

}
