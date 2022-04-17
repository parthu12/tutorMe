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
    /**
     * 
     * @param tutor_id
     * @return TableModel
     * @throws SQLException 
     */
    public TableModel tutorContacts(int tutor_id) throws SQLException{
        String query = "SELECT DISTINCT StuID, StuName, majorSubject FROM requests WHERE RequestStatus = 'Accept' AND TutorID ='"+ tutor_id +"'";
        
        // Labels for chat table information
        Vector<String> columns = new Vector<>();
        columns.add("Student ID");
        columns.add("Student Name");
        columns.add("Student Major");
        
        // Search for student whom the tutor has accepted
        Vector<Vector<String>> conInfo = new Vector<>();
        try(Connection conn = DBConnectionManager.getConnection())
	{
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            // Obtain student information and return in table format
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
    
    /**
     * 
     * @param student_id
     * @return TableModel
     * @throws SQLException 
     */
    public TableModel studentContacts(int student_id) throws SQLException{
        String query = "SELECT DISTINCT TutorID, TutorName, TutorMajor FROM requests WHERE RequestStatus = 'Accept' And StuID ='"+ student_id +"'";
        
        // Labels for chat table information
        Vector<String> columns = new Vector<>();
        columns.add("Tutor ID");
        columns.add("Tutor Name");
        columns.add("Tutor Major");
        
        // Search for tutors who have accepted the student
         Vector<Vector<String>> conInfo = new Vector<>();
        try(Connection conn = DBConnectionManager.getConnection())
	{
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            // Obtain tutor information and return in table format
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
    
    /**
     * 
     * @param Rid
     * @param name
     * @param major
     * @return int
     * @throws SQLException 
     */
    public int tutorInfo(int Rid, String name, String major) throws SQLException {
      Connection connection = DBConnectionManager.getConnection();
        
        String query = "UPDATE requests SET TutorName='" + name+ "', TutorMajor ='" + major+ "' WHERE Rid='" + Rid+ "' ";
        Statement stm = connection.createStatement();
        int executeUpdate = stm.executeUpdate(query);
        return executeUpdate;
    } 
    
    /**
     * 
     * @param id
     * @param userStatus 
     */
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
            
            // Check if the request table is empty, inform user
            
            Connection connection = DBConnectionManager.getConnection();
            if (userStatus.equals("Tutor")){
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
                String query = "SELECT COUNT(*) FROM `requests` WHERE `StuID` = '"+id+"' AND `RequestStatus` = 'Accept'";
                PreparedStatement checkRow = connection.prepareStatement(query);
                ResultSet rs = checkRow.executeQuery();
                rs.next();
                rowCount = rs.getString(1);
                rows = Integer.valueOf(rowCount);
                if(rows == 0){
                JOptionPane.showMessageDialog(null, "Your request must be accepted by a tutor to open chat rooms", "Empty Chat Room",1);
                }
            } 
        } catch (SQLException ex) {
            Logger.getLogger(GetContacts.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
                 
}