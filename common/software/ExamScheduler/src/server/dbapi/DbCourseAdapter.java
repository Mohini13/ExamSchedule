package server.dbapi;

import server.AdminUser;
import server.UserClass;
import server.exceptions.DatabaseException;
import server.serverapi.Course;
import server.serverapi.Program;

import java.util.HashMap;

/**
 * Created by ivan on 02/12/15.
 *
 * this class equals to course in the db
 *
 */
public abstract class DbCourseAdapter {


    public abstract Course createCourse(String _name, UserClass _professor, Program _program, int _semester) throws DatabaseException;

    // it would be great to pass NULL parameters for values that should not be updated
    // db team should implement this
    // returns an updated Course
    public static Course setCourse(int _id, String _name, String _section, UserClass _professor, Program _program) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // returns a number of rows deleted
    public static int deleteCourse(int _id) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }


    public static Course getCourse(int _id) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // returns a HashMap  <id_course, Course object itself>
    public static HashMap<Integer, Course> getCourses() throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // the following query can be used to create a Course object
    // alternatively, getProfessor() and getProgram() can be called to simplify the query
    /*

SELECT
  cour.c_id
  ,cour.c_name
  ,cour_sec.section_name
  ,cour.sems_id
  ,fac.f_id
  ,fac.username
  ,fac.password
  ,fac.first_name
  ,fac.last_name
  ,prog.prog_id
  ,prog.prog_name
FROM course cour
JOIN faculty_course fac_cour  ON cour.c_id = fac_cour.c_id
JOIN course_sec cour_sec      ON fac_cour.fc_id = cour_sec.fc_id
JOIN faculty fac              ON fac_cour.f_id = fac.f_id
JOIN program prog             ON cour.prog_id = prog.prog_id;

*/

}
