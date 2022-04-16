/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

//import static controller.StudentData.status;
import database.DBConnectionManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author lillisnoddy
 */
public class GetContacts {
    public TableModel tutorContacts() throws SQLException{
        String query = "SELECT DISTINCT StuID, StuName, majorSubject FROM requests WHERE RequestStatus = 'Accept'";
        Vector<String> columns = new Vector<>();
        columns.add("Student ID");
        columns.add("Student Name");
        columns.add("Major");
        
        Vector<Vector<String>> conInfo = new Vector<>();
        try(Connection conn = DBConnectionManager.getConnection())
	{
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs != null && rs.next())
            {
                Vector<String> row = new Vector<>();
                row.add(String.valueOf(rs.getInt(1)));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                conInfo.add(row);
            }
        } 
        catch (SQLException e) {
		e.printStackTrace();
        } 
        
        return new DefaultTableModel(conInfo,columns);
    }
    
    public TableModel studentContacts(int student_id) throws SQLException{
        String query = "SELECT DISTINCT TutorID, TutorName, TutorMajor FROM requests WHERE RequestStatus = 'Accept' And StuID ='"+ student_id +"'";
        Vector<String> columns = new Vector<>();
        columns.add("Student ID");
        columns.add("Student Name");
        columns.add("Major");
        
         Vector<Vector<String>> conInfo = new Vector<>();
        try(Connection conn = DBConnectionManager.getConnection())
	{
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs != null && rs.next())
            {
                Vector<String> row = new Vector<>();
                row.add(String.valueOf(rs.getInt(1)));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                conInfo.add(row);
            }
        } 
        catch (SQLException e) {
		e.printStackTrace();
        } 
        
        return new DefaultTableModel(conInfo,columns);
    
    } 
    
    public int tutorInfo(int Rid, String name, String major) throws SQLException {
      Connection connection = DBConnectionManager.getConnection();
        String query = "UPDATE requests SET TutorName='" + name+ "', TutorMajor ='" + major+ "' WHERE Rid='" + Rid+ "' ";
        Statement stm = connection.createStatement();
        int executeUpdate = stm.executeUpdate(query);
        return executeUpdate;
    } 
    
    public static void checkRTable(int id,String userStatus){
        try {
            
            String rowCount; int rows;
            // Ensure that the request table exists
            StudentData data = new StudentData();
            try {
                data.createRTable();
            } catch (Exception ex) {
                Logger.getLogger(GetContacts.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Check if the request table is empty
            Connection connection;
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tutormedb", "root", "t3llN0L135");
            if (userStatus.equals("Tutor")){
                System.out.println("In the the tutor");
                String query = "SELECT COUNT(*) FROM `requests` WHERE `TutorID` = '"+id+"' AND `RequestStatus` = 'Accept'";
                PreparedStatement checkRow = connection.prepareStatement(query);
                ResultSet rs = checkRow.executeQuery();
                rs.next();
                rowCount = rs.getString(1);
                rows = Integer.valueOf(rowCount);
                if(rows == 0){
                    JOptionPane.showMessageDialog(null, "You must accept student requests to open chat rooms", "Empty Chat Room",1);
                }
            } 
            
            if (userStatus.equals("Student")){
                System.out.println("In the the studnet");
                System.out.println("I'm in the checktable");
                String query = "SELECT COUNT(*) FROM `requests` WHERE `StuID` = '"+id+"' AND `RequestStatus` = 'Accept'";
                PreparedStatement checkRow = connection.prepareStatement(query);
                ResultSet rs = checkRow.executeQuery();
                rs.next();
                rowCount = rs.getString(1);
                rows = Integer.valueOf(rowCount);
                if(rows == 0){
                JOptionPane.showMessageDialog(null, "You must be accepted by a tutor to open chat rooms", "Empty Chat Room",1);
                }
            } 
        } catch (SQLException ex) {
            Logger.getLogger(GetContacts.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
                 
}