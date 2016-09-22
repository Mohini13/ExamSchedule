package humber.cpan205na.model;

import humber.cpan205na.controller.dbapi.IdbCourse;
import humber.cpan205na.controller.serverapi.Course;

/**
 * Created by ivan on 12/11/15.
 */
public class DBCourse implements IdbCourse {
    @Override
    public Course createCourse(int _id, String _name) {
        return null;
    }

    @Override
    public Course setCourse(int _id, String _name) {
        return null;
    }

    @Override
    public boolean deleteCourse(int _id) {
        return false;
    }
}
