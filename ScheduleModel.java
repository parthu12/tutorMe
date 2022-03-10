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
 * place, university, meetingPlace, and studeSubject will be passed in as parameter
 */
public class ScheduleModel {
    private Time time;
    private Subject subject;
    private Place place;
    private University university;
    ScheduleModel(long t, String s, String p, String u){
        time = new Time(t);
        subject = new Subject(s);
        place = new Place(p);
        university = new University(u);
    }

    /**
     * @return the time
     */
    public Time getTime() {
        return time;
    }

    /**
     * @return the place
     */
    public Place getPlace() {
        return place;
    }

    /**
     * @return the University
     */
    public University getUniversity() {
        return university;
    }

    /**
     * @return the studySubject
     */
    public Subject getStudySubject() {
        return subject;
    }
}
