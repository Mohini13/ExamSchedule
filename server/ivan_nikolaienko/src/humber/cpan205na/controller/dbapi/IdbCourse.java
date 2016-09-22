package humber.cpan205na.controller.dbapi;

import humber.cpan205na.controller.serverapi.Course;

import java.util.HashMap;

/**
 * Created by ivan on 12/11/15.
 */
public interface IdbCourse {

    Course createCourse(int _id, String _name); //throws DBException;
    Course setCourse(int _id, String _name);
    boolean deleteCourse(int _id);
    static Course getCourse(int _id) {
        return new Course();
    }

    static HashMap<Integer, Course> getCourses() { // <id_course, Course object itself>
        return new HashMap<Integer, Course>();
    }

}
