/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author jia
 */
public class ScheduleModel {
    private Time time;
    private Subject subject;
    private University university;
    private University place;
    ScheduleModel(long t, String s, String p, String u){
        time = new Time(t);
        subject = new Subject(s);
        university = new University(u, p);
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
    public University getPlace() {
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
