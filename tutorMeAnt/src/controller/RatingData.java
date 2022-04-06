/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import model.Rating;


/**
 *
 * @author Peggy
 */
public class RatingData {
    
    public static int addRate(Rating rating,int StuID,int tutorID) throws ClassNotFoundException,SQLException, Exception{
        //Class.forName("com.mysql.jdbc.Driver");
        Connection connection;
        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tutormedb", "root", "root123");
        createTable();
        
        String query = "INSERT INTO `Ratings`(`reviewBy`, `reviewTo`, `review`, `rating`) VALUES ('"+
                StuID + "','"
                +tutorID + "','"
                +rating.getReview() + "','"
                + rating.getRate() + "')";
                
        
        Statement stm = connection.createStatement();
        
        int executeUpdate = stm.executeUpdate(query);
        
        
        return executeUpdate;
    }
    
    public static int UpdateRate(Rating rating,int StuID,int tutorID) throws ClassNotFoundException,SQLException, Exception{
        //Class.forName("com.mysql.jdbc.Driver");
        Connection connection;
        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tutormedb", "root", "");
        
        
        String query = "UPDATE Ratings SET review='" + rating.getReview()+ "', rating= '" +rating.getRate()+ "' WHERE reviewBy='" + StuID+ "' and reviewTo='" + tutorID+ "' ";
        
                
        
        Statement stm = connection.createStatement();
        
        int executeUpdate = stm.executeUpdate(query);
        
        
        return executeUpdate;
    }
    public static void createTable() throws Exception
    {
        try{            
        Connection connection;
        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tutormedb", "root", "");
        String createTable ="CREATE TABLE IF NOT EXISTS Ratings(id int NOT NULL AUTO_INCREMENT, reviewBy varchar(255) NOT NULL, reviewTo varchar(255) NOT NULL, review varchar(255) NOT NULL, rating int(20) NOT NULL, primary key(id))";
        Statement stm2 = connection.createStatement();
        stm2.executeUpdate(createTable);
        
        }catch(Exception e)
        {
            System.out.println("Table not Created...");
        }
    }
}
