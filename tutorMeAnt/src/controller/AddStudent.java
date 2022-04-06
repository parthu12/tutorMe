/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import model.Student;

/**
 *
 * @author Peggy
 */
public class AddStudent {
    
    public static int addStudent(Student student,int id) throws ClassNotFoundException,SQLException{
        //Class.forName("com.mysql.jdbc.Driver");
        Connection connection;
        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tutormedb", "root", "root123");
        
        String query = "UPDATE users SET Age='" + student.getAge()+ "', Location= '" + student.getLocation()+ "', gpa= '" + student.getGpa()+ "',  majorSubject= '" + student.getCourse()+ "', Description= '" + student.getDescription()+ "', userStatus= '" + student.getStatus()+ "' WHERE id='" + id+ "' ";
        
        
        Statement stm = connection.createStatement();
        
        int executeUpdate = stm.executeUpdate(query);
        
        
        return executeUpdate;
    }
    
}
