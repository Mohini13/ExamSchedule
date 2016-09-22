package server.serverapi;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import server.UserClass;
import server.scheduleGenerator.TimeStore;


/**
 * Created by jordan nov 16.
 *
 * Edited by Ivan Dec 5.
 * 
 * Edited by kamalpreet dec 7
 */

public final class Exam {
    private int examId;
    private Course course; //course contains professor, section, code, name, program
    private Room room;
    private Calendar startDateTime; // date and start time for the Exam
    private Calendar endDateTime; // end time for the Exam
    private Location location;
    private Calendar date;
    private TimeStore startTime; // Can use java,sql.Time class
    private TimeStore endTime;
    // to get Professor: course.getProfessor()
    private Timestamp StartDateTime; //kamalpreet
    private Timestamp EndDateTime; //kamalpreet
   
    // this information should be enough for Exam
    // edited by kamalpreet
     public Exam (int _exam_id, Course _course, Room _room, Timestamp _startDateTime, Timestamp _endDateTime) {
        examId = _exam_id;
        course = _course;
        room = _room;
        StartDateTime = _startDateTime;
        EndDateTime = _endDateTime;
    }
       //edited by kamalpreet
    public Exam(int exam_id, Course cou, UserClass prof, Room roo, Timestamp Start_Date_Time, Timestamp End_Date_Time) {
        this.examId = exam_id;
        this.course = cou;
        this.room = roo;
        this.StartDateTime = Start_Date_Time;
        this.EndDateTime = End_Date_Time;
    }
    //not working for database
    
   /*public Exam(Course _course, Location _location, Room _room, Calendar _startDate, TimeStore _startTime, TimeStore _endTime){
            
           //this.examId=_examid;
            this.course=_course;
            this.location=_location;
            this.room=_room;
            this.date = _startDate;
            this.startTime =  _startTime;
            this.endTime= _endTime;


    }*/
        
    public int getExamId()
    {
        return examId;
    }
    public void setExamId(int _examId)
    {
        this.examId=_examId;
    }
    public Course getCourse()
    {
        return course;
    }
    public void setCourse(Course _course)
    {
        this.course=_course;
    }
    public Location getLocation()
    {
        return location;
    }
    public void setLocation(Location _location)
    {
        this.location=_location;
    }
    public Room getRoom()
    {
        return room;
    }
    public void setRoom(Room _room)
    {
        this.room=_room;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public TimeStore getEndTime() {
        return endTime;
    }

    public void setEndTime(TimeStore endTime) {
        this.endTime = endTime;
    }

    public TimeStore getStartTime() {
        return startTime;
    }

    public void setStartTime(TimeStore startTime) {
        this.startTime = startTime;
    }

    public Calendar getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Calendar startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Calendar getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Calendar endDateTime) {
        this.endDateTime = endDateTime;
    }

}
