/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import server.UserClass;
import server.dbapi.DbCourseAdapter;
import server.dbapi.Idb;
import server.exceptions.DatabaseException;
import server.serverapi.Course;
import server.unused.Professor;
import server.serverapi.Program;

/**
 *
 * @author Ivan
 */
public class DBCourse extends DbCourseAdapter
{
    PreparedStatement pstmt = null;
    private static ResultSet rs = null;

   // created and edited my mohini
    @Override
    public Course createCourse(String _name, UserClass _professor, Program _program, int _semester) throws DatabaseException {
        Course course = null;
        int course_id = 0;
         String sql = "{call insert_Course(:v_c_id, ? , ?, ?,?)}";
        
        // INSERT INTO course (c_name, prog_id, sems_id) VALUES ('c_name', 20, 1);
        String sql_ins_course = "INSERT INTO course (c_name, prog_id, sems_id) "
                + "VALUES('" + _name + "'," + _program.getProgramId() + ", "+ _semester + ")"; // add semester

        String sql_inserted_id = "SELECT Course_c_id_SEQ.CURRVAL AS inserted_id FROM dual";

        try {
            // insert course
            DBConnection.getStatement().executeUpdate(sql_ins_course);

            // get last inserted id which is a course id
            rs = DBConnection.getStatement().executeQuery(sql_inserted_id);

            if (rs != null) {
                rs.next();
                course_id = rs.getInt("inserted_id");

                // link professor and course
                String sql_ins_faculty_course = "INSERT INTO faculty_course (f_id, c_id) "
                        + "VALUES(" + _professor.getId() + ", " + course_id + ")";
                DBConnection.getStatement().executeUpdate(sql_ins_faculty_course);

                course = new Course(course_id, _name, _professor, _program, _semester);

            } else {
                throw new DatabaseException("inserted_id is null");
            }

        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return course;

    }

    // it would be great to pass NULL parameters for values that should not be updated
    // db team should implement this
    // returns an updated Course
    public static Course setCourse(int _id, String _section, Program _program, String _name, Professor _professor) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // returns a number of rows deleted
    // tested by Hani, Dec 5
    public static int deleteCourse(int _id) throws DatabaseException {
        int rowsDeleted = 0;
        String sql = "DELETE FROM course WHERE c_id = " + _id;
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

    public static Course getCourse(int _id) throws DatabaseException {
        Course r = null;
        int course_id, program_id, professor_id, semester_id;
        String course_name, section;

        String sql = "SELECT " +
                "  cour.c_id " +
                "  ,cour.c_name " +
                "  ,cour.sems_id " +
                "  ,fac_cour.f_id " +
                "  ,cour.prog_id " +
                "FROM course cour " +
                "JOIN faculty_course fac_cour  ON cour.c_id = fac_cour.c_id " +
                "WHERE cour.c_id = " + _id;

        try {
            rs = DBConnection.getStatement().executeQuery(sql);

            if (rs != null) {
                rs.next();

                course_id = rs.getInt("c_id");
                course_name = rs.getString("c_name");
                semester_id = rs.getInt("sems_id");
                professor_id = rs.getInt("f_id");
                program_id = rs.getInt("prog_id");

                Program prog = DBProgram.getProgram(program_id);
                UserClass prof = DBProfessor.getUser(professor_id);

                r = new Course(course_id, course_name, prof, prog, semester_id);

            } else {
                throw new DatabaseException("statement is null: " + sql);
            }
            //DBConnection.getStatement().close(); // ?
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return r;
    }

    // returns a HashMap  <id_course, Course object itself>
    public static HashMap<Integer, Course> getCourses() throws DatabaseException {
        HashMap<Integer, Course> result = new HashMap<>();
        Course r = null;
        int course_id, program_id, professor_id, semester_id;
        String course_name, section;

        String sql = "SELECT " +
                "  cour.c_id " +
                "  ,cour.c_name " +
                "  ,cour.sems_id" +
                "  ,fac_cour.f_id " +
                "  ,cour.prog_id " +
                "FROM course cour " +
                "JOIN faculty_course fac_cour  ON cour.c_id = fac_cour.c_id";
        try {
            rs = DBConnection.getStatement().executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    course_id = rs.getInt("c_id");
                    course_name = rs.getString("c_name");
                    semester_id = rs.getInt("sems_id");
                    professor_id = rs.getInt("f_id");
                    program_id = rs.getInt("prog_id");

                    Program prog = DBProgram.getProgram(program_id);
                    UserClass prof = DBProfessor.getUser(professor_id);

                    r = new Course(course_id, course_name, prof, prog, semester_id);

                    result.put(course_id, r);
                }
            } else {
                throw new DatabaseException("statement is null: " + sql);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }

        return result;
    }
    
}
