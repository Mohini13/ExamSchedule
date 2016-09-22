package server.dbapi;

import java.sql.Timestamp;
import server.exceptions.DatabaseException;
import server.serverapi.Course;
import server.serverapi.Exam;
import server.serverapi.Location;
import server.serverapi.Room;

import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by ivan on 02/12/15.
 */
public abstract class DbExamAdapter {
	
	//edited by kamalpreet

    public abstract Exam createExam(Course _course, Room _room, Timestamp _startDateTime, Timestamp _endDateTime) throws DatabaseException;

    // returns an updated Exam
    public static Exam setExam(int _examid, Course _course, Room _room, Timestamp _startDateTime, Timestamp _endDateTime) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // returns a number of rows deleted
    public static int deleteExam(int _id) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    public static Exam getExam(int _id) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // returns a HashMap <id_Exam, Exam object itself>
    public static HashMap<Integer, Exam> getExams()throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }
}
