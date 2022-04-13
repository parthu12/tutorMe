/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author lillisnoddy
 */
public class Message {
    public String getDate(){
        DateFormat date = new SimpleDateFormat();
        Date now = Calendar.getInstance().getTime();
        String dateString = date.format(now);
        
        return (dateString);
    }
}
