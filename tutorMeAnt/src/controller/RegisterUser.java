/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import static database.DBConnectionManager.getConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import model.User;

/**
 *
 * @author Peggy
 */
public class RegisterUser {
    static int age=0;
    static String location="";
    static double gpa=0.0;
    static String majorSubject="";
    static String Description="";    
    static String userStatus="";
    public static int addStudent(User student) throws ClassNotFoundException,SQLException, Exception{
        //Class.forName("com.mysql.jdbc.Driver");
        Connection connection;
        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tutormedb", "root", "");
        createTable();
        
        String query = "INSERT INTO `users`(`userName`, `Password`, `Email`, `phoneNo`, `profileVisiblity`,`Age`, `Location`, `gpa`, `majorSubject`, `Description`, `userStatus`) VALUES ('"+
                student.getUserName() + "','" 
                + student.getPassword() + "','"
                +student.getEmail() + "','"
                +student.getPhoneNo()+"','"
                +student.getProfileVisibility()+"','"
                +age+"','"
                +location+"','"
                +gpa+"','"
                +majorSubject+"','"
                +Description+"','"
                +userStatus+"')";
        
        
        Statement stm = connection.createStatement();
        
        int executeUpdate = stm.executeUpdate(query);
        
        
        return executeUpdate;
    }
    public static void createTable() throws Exception
    {
        try{            
        Connection connection;
        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tutormedb", "root", "");
        String createTable ="CREATE TABLE IF NOT EXISTS users(id int NOT NULL AUTO_INCREMENT, userName varchar(255) NOT NULL, Password varchar(255) NOT NULL, Email varchar(255) NOT NULL, phoneNo varchar(255) NOT NULL, profileVisiblity varchar(255) NOT NULL, Age int(20) NOT NULL, Location varchar(255) NOT NULL, gpa double NOT NULL, majorSubject varchar(255) NOT NULL, Description varchar(255) NOT NULL, userStatus varchar(255) NOT NULL, primary key(id))";
        Statement stm2 = connection.createStatement();
        stm2.executeUpdate(createTable);
        
        }catch(Exception e)
        {
            System.out.println("Table not Created...");
        }
    }
    
    
    
}
