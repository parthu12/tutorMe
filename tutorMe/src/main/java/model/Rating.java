/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lillisnoddy
 */
public class Rating {
    private double existingRatings;
    
    private double getRatings(){
        /*
            When a tutor has already been rated, push it to a file (?) 
            and then obtain the existing Rating values from there
        */
        return 0;
    }
    
    private int numRatings(){
        /*
        run through file to obtain the number of ratings tutor already has (?)
        */
        return 1;
    }
    
    /*
    Average the rate values to get the tutor's overall rating
    */
    public double calculateRating(double num){
        int count = numRatings();
        double average = (existingRatings + num)/count;
        return average;
    }
    
    
}
