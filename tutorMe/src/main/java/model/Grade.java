/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import view.GradePanel;
import javax.swing.JFrame;



/**
 *
 * @author lillisnoddy
 */
public class Grade {
    
    /*
    hello
    */
    
    public static void main(String args[]) {
        JFrame frame = new JFrame();
        frame.add(new GradePanel());
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
     
}
