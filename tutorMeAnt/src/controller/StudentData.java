/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import database.DBConnectionManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Student;

/**
 *
 * @author Peggy
 */
public class StudentData {
    static String status="Tutor";
    static String RequestStatus="Pending";
    
    public DefaultTableModel getByName(String title)
	{
		String sql = "select id, userName, Email, Location, majorSubject from users where userStatus='"+status+ "' and userName like ? ";
		Vector<String> colNames = new Vector<>();
		colNames.add("ID");
		colNames.add("Name");
                colNames.add("Email");
                colNames.add("Location");
                colNames.add("majorSubject");
                
                
                Vector<Vector<String>> data = new Vector<>();
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + title.toLowerCase() + "%");
			
			ResultSet rs = ps.executeQuery();
			while(rs != null && rs.next())
			{
				Vector<String> row = new Vector<>();
				row.add(String.valueOf(rs.getInt(1)));
				row.add(rs.getString(2));
                                row.add(rs.getString(3));
                                row.add(rs.getString(4));
                                row.add(rs.getString(5));
				data.add(row);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return new DefaultTableModel(data, colNames);
	}

    public TableModel getByLocation(String txt) {
        String sql = "select id, userName, Email, Location, majorSubject from users where userStatus='"+status+ "' and Location like ? ";
		Vector<String> colNames = new Vector<>();
		colNames.add("ID");
		colNames.add("Name");
                colNames.add("Email");
                colNames.add("Location");
                colNames.add("majorSubject");
                
                Vector<Vector<String>> data = new Vector<>();
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + txt.toLowerCase() + "%");
			
			ResultSet rs = ps.executeQuery();
			while(rs != null && rs.next())
			{
				Vector<String> row = new Vector<>();
				row.add(String.valueOf(rs.getInt(1)));
				row.add(rs.getString(2));
                                row.add(rs.getString(3));
                                row.add(rs.getString(4));
                                row.add(rs.getString(5));
				data.add(row);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return new DefaultTableModel(data, colNames);
    }

    public TableModel getByMajor(String txt) {
        String sql = "select id, userName, Email, Location, majorSubject from users where userStatus='"+status+ "' and majorSubject like ? ";
		Vector<String> colNames = new Vector<>();
		colNames.add("ID");
		colNames.add("Name");
                colNames.add("Email");
                colNames.add("Location");
                colNames.add("majorSubject");
                
                Vector<Vector<String>> data = new Vector<>();
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + txt.toLowerCase() + "%");
			
			ResultSet rs = ps.executeQuery();
			while(rs != null && rs.next())
			{
				Vector<String> row = new Vector<>();
				row.add(String.valueOf(rs.getInt(1)));
				row.add(rs.getString(2));
                                row.add(rs.getString(3));
                                row.add(rs.getString(4));
                                row.add(rs.getString(5));
				data.add(row);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return new DefaultTableModel(data, colNames);
    }
    
    
    public static int UpdatePassword(int id,String pass) throws ClassNotFoundException,SQLException{
        //Class.forName("com.mysql.jdbc.Driver");
        
        Connection conn = DBConnectionManager.getConnection();
        String query = "UPDATE users SET Password='" + pass+ "' WHERE id='" + id+ "' ";
        
       
        Statement stm = conn.createStatement();
        
        int executeUpdate = stm.executeUpdate(query);
        
        
        return executeUpdate;
        
    }
    public static int RequestCreated(int stuid,int tutorID,String stuName,String stuEmail,String stuPhone,String majorSubject,String stuLocation) throws ClassNotFoundException,SQLException, Exception{
        //Class.forName("com.mysql.jdbc.Driver");
        createRTable();
        Connection conn = DBConnectionManager.getConnection();
        
        
        String query = "INSERT INTO `Requests`(`StuID`, `TutorID`, `StuName`, `StuEmail`, `StuPhoneNo`, `majorSubject`, `StuLocation`, `RequestStatus`) VALUES ('"+
                stuid + "','" 
                + tutorID + "','"
                + stuName + "','"
                + stuEmail+ "','"
                + stuPhone+"','"
                + majorSubject+"','"
                + stuLocation+"','"                
                + RequestStatus+"')";              
        
        
        Statement stm = conn.createStatement();
        
        int executeUpdate = stm.executeUpdate(query);
        
        
        return executeUpdate;
        
    }
    public static void createRTable() throws Exception
    {
        try{    
        Connection connection;
        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tutormedb", "root", "");
        String createTable ="CREATE TABLE IF NOT EXISTS Requests(Rid int NOT NULL AUTO_INCREMENT, StuID int(20) NOT NULL, TutorID int(20) NOT NULL, StuName varchar(255) NOT NULL, StuEmail varchar(255) NOT NULL, StuPhoneNo varchar(255) NOT NULL, majorSubject varchar(255) NOT NULL, StuLocation varchar(30) NOT NULL, RequestStatus varchar(255) NOT NULL, TutorName varchar(255) DEFAULT NULL," +
                                "TutorMajor varchar(255) DEFAULT NULL, primary key(Rid))";
        Statement stm2 = connection.createStatement();
        stm2.executeUpdate(createTable);
        
        }catch(Exception e)
        {
            System.out.println("Table not Created...");
        }
    }
    public static int acceptORrejected(int Rid, String RStatus) throws Exception{
                
        Connection connection;
        connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tutormedb", "root", "");
            
        String query = "UPDATE requests SET RequestStatus='" + RStatus+ "' WHERE Rid='" + Rid+ "' ";
        Statement stm = connection.createStatement();
        int executeUpdate = stm.executeUpdate(query);
        return executeUpdate;
        
    }
    
}
