/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
//import model.Message;

/**
 *
 * @author lillisnoddy
 */
public class SaveMessage {
    
    public void SaveConvo(int sender, int recipient, String s_name, String message, String r_name) throws ClassNotFoundException,SQLException,Exception{
       System.out.println("I'm in the SaveConvo function");
       Connection connection;
       connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tutormedb", "root", "");
       
        String query = "INSERT INTO `messages`(`sender(ID)`, `recipient(ID)`, `sender`, `recipient`, `messagetxt`,`date`) VALUES ('"+
                sender + "','" + recipient + "','"+ s_name + "','"+r_name+"','"+message+"','"+getDate()+"')";
       PreparedStatement saveStmt = connection.prepareStatement(query);
       saveStmt.execute();
       
    }

    public static void createMessageTable() throws Exception
    {
      System.out.println("Testing the table");
        try{            
        Connection connection;
        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tutormedb", "root", "");
        System.out.println("Making table");
        String query ="CREATE TABLE IF NOT EXISTS `messages`(`sender` varchar(255) NOT NULL,`recipient` varchar(255) DEFAULT NULL,"+
                        "`date` varchar(45) NOT NULL,`chat_id` int NOT NULL AUTO_INCREMENT,`sender(ID)` int NOT NULL,`recipient(ID)` int DEFAULT NULL,`messagetxt` text NOT NULL,PRIMARY KEY (chat_id));"; 
        Statement createTable = connection.createStatement();
        createTable.executeUpdate(query);
        
        }catch(Exception e)
        {
            System.out.println("Did not make message table in database");
        }
    }
    
     public String getDate(){
        DateFormat date = new SimpleDateFormat();
        Date now = Calendar.getInstance().getTime();
        String dateString = date.format(now);
        
        return (dateString);
    }
     
    public static ResultSet findChats(int sender, int recipient) throws ClassNotFoundException,SQLException,Exception{
            createMessageTable();
            Connection connection;
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tutormedb", "root", "");
            String query = "SELECT `messagetxt`,`sender`,`date` FROM `messages` WHERE (`sender(ID)` = '"+sender+"' AND `recipient(ID)` = +'"+recipient+"') OR"
                    + "(`sender(ID)` = '"+recipient+"' AND `recipient(ID)` = +'"+sender+"')";
            PreparedStatement findConvo = connection.prepareStatement(query);
            ResultSet messages = findConvo.executeQuery();
        
            return messages;
    }
}
