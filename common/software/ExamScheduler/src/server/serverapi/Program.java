package server.serverapi;

import java.util.HashMap;

/**
 * Created by jordan nov 16
 * Edited by ivan dec 2
 */
public final class Program {

    private int programId;
    private String programName;
	private HashMap<Integer, Course> courses; // courses related to the program


    public Program(int _progId, String _programName) {
        courses = new HashMap<>();
        programId = _progId;
        programName = _programName;
    }

    public void addCourse(Course _course) {
        courses.put(_course.getid(), _course);
    }

    public void delCourse(Course _course) {
        if(courses.containsKey(_course.getid())) {
            courses.remove(_course.getid());
        }
    }

    public int getProgramId() {
        return programId;
    }

    public String getProgramName() {
        return programName;
    }

    public HashMap<Integer, Course> getCourses() {
        return courses;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public void setCourses(HashMap<Integer, Course> courses) {
        this.courses = courses;
    }
}
