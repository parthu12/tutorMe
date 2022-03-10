/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Jia
 * constructor gets the time but in milliseconds
 * displayTime takes no param and simply reformats the time into
 * a readable format
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
