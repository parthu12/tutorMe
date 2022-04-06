/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.mysql.cj.jdbc.DatabaseMetaData;
import controller.RatingData;
import controller.StudentData;
import database.DBConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Rating;

/**
 *
 * @author Peggy
 */
public class Review extends javax.swing.JFrame {
    String tutorName;
    int tutorID;
    int stuID;
    /**
     * Creates new form Review
     */
    public Review(int stuID,int tutorID,String tutorName) {
        this.stuID=stuID;
        this.tutorID=tutorID;
        this.tutorName=tutorName;
        initComponents();
        startFuc();
        outputField.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tutorLabel = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        inputField = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputField = new javax.swing.JTextArea();
        reviewScrollBar = new javax.swing.JScrollBar();
        rateSlider = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Review Panel");

        tutorLabel.setText("Tutor Name Here");

        submitButton.setText("Submit Review");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        inputField.setColumns(20);
        inputField.setRows(5);
        jScrollPane1.setViewportView(inputField);

        outputField.setColumns(20);
        outputField.setRows(5);
        jScrollPane2.setViewportView(outputField);

        rateSlider.setMajorTickSpacing(1);
        rateSlider.setMaximum(5);
        rateSlider.setMinimum(1);
        rateSlider.setMinorTickSpacing(1);
        rateSlider.setPaintLabels(true);
        rateSlider.setPaintTicks(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(rateSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(submitButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reviewScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(tutorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tutorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(reviewScrollBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitButton))
                .addGap(18, 18, 18)
                .addComponent(rateSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // TODO add your handling code here:
        
        outputField.append(inputField.getText() + "\n");
        
        String review=inputField.getText().trim();
        int rate=rateSlider.getValue();
        
        
        String query="select * from ratings where reviewBy = '"+stuID+"' and reviewTo = '"+tutorID+"'";
        
       
        
            try(Connection conn = DBConnectionManager.getConnection())
	{
            DatabaseMetaData dbm = (DatabaseMetaData) conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, "ratings", null);
            if (tables.next()) {
                // Table exists
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {          
                            
                   int P_rate = rs.getInt(5);
                   Rating rating1 = new Rating((rate+P_rate)/2,review);
                   
                    try {

                        int addStudent = RatingData.UpdateRate(rating1, stuID, tutorID);
                        if (addStudent > 0) {
                            JOptionPane.showMessageDialog(rootPane, "Successfully Review Submitted");
                            inputField.setText("");
                            this.dispose();
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (Exception ex) {
                        Logger.getLogger(Review.class.getName()).log(Level.SEVERE, null, ex);
                    }

                   

                } else {
                   

                }
            
            }
            else {
                // Table does not exist
                Rating rating2 = new Rating(rate, review);
                try {

                    int addStudent = RatingData.addRate(rating2, stuID, tutorID);
                    if (addStudent > 0) {
                        JOptionPane.showMessageDialog(rootPane, "Successfully Review Submitted");
                        inputField.setText("");
                        this.dispose();
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (Exception ex) {
                    Logger.getLogger(Review.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentData.class.getName()).log(Level.SEVERE, null, ex);
             
             }       
        
        
        
        
    }//GEN-LAST:event_submitButtonActionPerformed
    
    private void startFuc() {                                             
        // TODO add your handling code here:
         tutorLabel.setText("Tutor Name  "+tutorName);
    }  
    RatingData rating = new RatingData();
    /**
     * @param args the command line arguments
     */
    
    public void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Review.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Review.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Review.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Review.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Review(stuID,tutorID,tutorName).setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea inputField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea outputField;
    private javax.swing.JSlider rateSlider;
    private javax.swing.JScrollBar reviewScrollBar;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel tutorLabel;
    // End of variables declaration//GEN-END:variables
}