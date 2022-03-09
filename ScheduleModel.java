/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Jia
 * time will use getTime() method to get the time from the system clock
 * place will be pre-registered
 */
public class ScheduleModel {
    private long time;
    private String place;
    private String University;
    private String meetingPlace;
    private String studySubject;
    
    ScheduleModel(String p, String U, String m, String s){
        //To convert time into readable time, use the following code
        /*
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(time);
        System.out.println(formatter.format(date));
        */
        time = System.currentTimeMillis();
        place = p;
        University = U;
        meetingPlace = m;
        studySubject = s;
    }

    /**
     * @return the time
     */
    public long getTime() {
        return time;
    }

    /**
     * @return the place
     */
    public String getPlace() {
        return place;
    }

    /**
     * @return the University
     */
    public String getUniversity() {
        return University;
    }

    /**
     * @return the meetingPlace
     */
    public String getMeetingPlace() {
        return meetingPlace;
    }

    /**
     * @return the studySubject
     */
    public String getStudySubject() {
        return studySubject;
    }
}
