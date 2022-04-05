/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Peggy
 */
public class Rating {
    private int rate;
    private String review;
    public Rating (int rate,String review){
        
        this.rate= rate;
        this.review= review;
        
    }

    public int getRate() {
        return rate;
    }

    public String getReview() {
        return review;
    }
    
    
}
