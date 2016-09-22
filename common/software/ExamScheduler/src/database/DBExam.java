/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import oracle.jdbc.OracleTypes;
import server.UserClass;
import server.dbapi.DbExamAdapter;
import server.exceptions.DatabaseException;
import server.serverapi.Course;
import server.serverapi.Exam;
import server.serverapi.Room;

/**
 *
 * @author kamalpreet
 */

public class DBExam extends DbExamAdapter{
       PreparedStatement pstmt = null;
       private static ResultSet rs = null;
   
    public Exam createExam(Course _course, Room _room, Timestamp _startDateTime, Timestamp _endDateTime) throws DatabaseException {
            //Insert into Exam(FACULTY_ID,COURSE_ID,ROOM_ID,START_DATE_TIME,END_DATE_TIME)
            //VALUES(4,4,10,'17-12-16 8:00:00.000000000','17-12-16 9:45:00.000000000');
        Exam exam = null;
        int exam_id;
         int faculty_id = _course.getprofessor().getId();
         int room_id = _room.getRoomId();
         int course_id = _course.getid();

        // insert_program
        // ? is a name of course, :v_prog_id is an OUT parameter    
        String sql = "{call insert_Exam(:v_prog_id, ?,?,?,?,?)}";

        try {
            CallableStatement cs = DBConnection.con.prepareCall(sql);
            cs.setInt(2, faculty_id);
            cs.setInt(3, course_id);
            cs.setInt(4, room_id);
            cs.setTimestamp(5, _startDateTime);
            cs.setTimestamp(6, _endDateTime);
            
            cs.registerOutParameter(1, OracleTypes.INTEGER);
            cs.execute();

            exam_id = cs.getInt(1); // 1 is the first OUT parameter
            exam = new Exam(exam_id, _course, _room, _startDateTime, _endDateTime);
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return exam;
     }
    
        public static Exam setExam(int _examid, Course _course, Room _room, Timestamp _startDateTime, Timestamp _endDateTime) throws DatabaseException {
            Exam exam = null;
            String sql_up_exam = "Update Exam SET START_DATE_TIME = '" + _startDateTime 
                    + ", END_DATE_TIME" + _endDateTime + "' where Exam_id = " + _examid;
          
          try
          {
              DBConnection.getStatement().executeUpdate(sql_up_exam);
              exam = getExam(_examid);
          }
          catch (SQLException ex) {
              throw new DatabaseException(ex);
          }
          return exam;
        }

    // returns a number of rows deleted
    public static int deleteExam(int _id) throws DatabaseException {
        int rowsDeleted = 0;
        String sql = "DELETE FROM Exam WHERE Exam_id = " + _id;
        try {
            rowsDeleted = DBConnection.getStatement().executeUpdate(sql);
            if (rowsDeleted == 0) {
                throw new DatabaseException("Nothing has been deleted: " + sql);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return rowsDeleted;
    }

    public static Exam getExam(int _id) throws DatabaseException {
        Exam exam = null;
        int exam_id, Course_id, Faculty_id, Room_id;        
        Timestamp Start_Date_Time, End_Date_Time;
        
        String sql = "Select Exam_id, C_id, F_id, Loc_id, Start_Date_Time, End_Date_Time From " +
                    "Exam e Join Course c ON e.Course_id = c.C_ID Join Faculty f ON e.FACULTY_ID = " +
                    " f.F_ID Join Room r ON e.ROOM_ID = r.LOC_ID";
       try {
            rs = DBConnection.getStatement().executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    // change query or use if here
                    exam_id = rs.getInt("Exam_id");
                    Course_id = rs.getInt("Course_id");
                    Faculty_id = rs.getInt("Faculty_id");
                    Room_id = rs.getInt("Room_id");
                    Start_Date_Time = rs.getTimestamp("Start_Date_Time");
                    End_Date_Time = rs.getTimestamp("End_Date_Time");
                    
                    Course cou = DBCourse.getCourse(Course_id);
                    UserClass prof = DBProfessor.getUser(Faculty_id);
                    Room roo = DBRoom.getRoom(Room_id);              
                    
                    exam = new Exam(exam_id, cou, prof, roo, Start_Date_Time, End_Date_Time);
                   
                }               
                
            } else {
                throw new DatabaseException("statement is null: " + sql);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex.getMessage());
        }

        return exam;
    }
    
    // returns a HashMap <id_Exam, Exam object itself>
    public static HashMap<Integer, Exam> getExams()throws DatabaseException {
        HashMap<Integer, Exam> result = new HashMap<>();
        Exam exam = null;
        int exam_id, Course_id, Faculty_id, Room_id;        
        Timestamp Start_Date_Time, End_Date_Time;
        
       String sql = "Select Exam_id, C_id, F_id, Loc_id, Start_Date_Time, End_Date_Time From " +
                    "Exam e Join Course c ON e.Course_id = c.C_ID Join Faculty f ON e.FACULTY_ID = " +
                    " f.F_ID Join Room r ON e.ROOM_ID = r.LOC_ID";
        try {
            rs = DBConnection.getStatement().executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    // change query or use if here
                    exam_id = rs.getInt("Exam_id");
                    Course_id = rs.getInt("Course_id");
                    Faculty_id = rs.getInt("Faculty_id");
                    Room_id = rs.getInt("Room_id");
                    Start_Date_Time = rs.getTimestamp("Start_Date_Time");
                    End_Date_Time = rs.getTimestamp("End_Date_Time");
                    
                    Course cou = DBCourse.getCourse(Course_id);
                    UserClass prof = DBProfessor.getUser(Faculty_id);
                    Room roo = DBRoom.getRoom(Room_id);              
                    
                    exam = new Exam(exam_id, cou, prof, roo, Start_Date_Time, End_Date_Time);
                    result.put(exam_id, exam);
                  }               
                
            } else {
                throw new DatabaseException("statement is null: " + sql);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex.getMessage());
        }

        return result;
    }

 }
