/*
 * Sample seed codes to be used in CS321 at
 * The University of Alabama in Huntsville.
 * These codes may contain errors, poor implementations, or
 * incorrect implementations. The user of these codes should
 * try to correct or improve them. The codes are for instructional
 * purposes. dmr CS 321 Fall 2016
 */
package view.announcement;

/**
 * This is the POJO (Plain Old Java Object) to hold the student data. Uses
 * standard 'get'-'set' bean convention. Overrides <tt>toString</tt>.
 *
 * @author drochowi for CS 321 Fall 2015, 2016, 2017
 */
public class Announcement {

    private String course;
    private String announcement;
    private String due;
    private String contact;

    public Announcement() {
        course = " ";
        announcement = " ";
        due = " ";
        contact = " ";
    }

    /**
     * Get course 
     *
     * @return first name as a <tt>String</tt>
     */
    public String getCourse() {
        return course;
    }

    /**
     * Set the course
     *
     * @param course as a <tt>String</tt>
     */
    public void setCourse(String firstname) {
        this.course = firstname;
    }

    /**
     * Get announcement
     *
     * @return announcement as a <tt>String</tt>
     */
    public String getAnnouncement() {
        return announcement;
    }

    /**
     * Set the announcement
     *
     * @param announcement as a <tt>String</tt>
     */
    public void setAnnouncement(String lastname) {
        this.announcement = lastname;
    }

    /**
     * Get the duedate
     *
     * @return due date as a <tt>String</tt>
     */
    public String getDueDate() {
        return due;
    }

    /**
     * Set the due date. 
     *
     * @param duedate as a <tt>String</tt>
     */
    public void setDueDate(String email) {
        this.due = email;
    }

    /**
     * Get the contact info
     *
     * @return contact info as <tt>String</tt>
     */
    public String getContactInfo() {
        return contact;
    }

    /**
     * Set the contact info
     *
     * @param contact info as a <tt>String</tt>
     */
    public void setContactInfo(String phone) {
        this.contact = phone;
    }

    /**
     * Make a String of the state values of the announcements
     *
     * @return the state as a <tt>String</tt>.
     */
    @Override
    public String toString() {
        return "Announcement:: Course = " + this.course + " Announcement = " + this.announcement
                + " Due = " + this.due + " Contact= " + this.contact;
    }

}
