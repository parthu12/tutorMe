/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jia
 */
public class Time {
     private long time;
    Time(long t){
        time = t;
    }
    public void displayTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(time);
        System.out.println(formatter.format(date));
    }
    
}
