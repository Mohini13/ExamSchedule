package server.serverapi;

import server.AdminUser;
import server.UserClass;



/**
 * Created by jordan on 12/11/15.
 * change package for server dbapi, server exceptions, server serverapi
 */
public final class Course {

    private int id; // id from database pk
    private int code; 
    private String name; 
    private String section;
    private UserClass professor;
    private Program program;
    private int semester; // but what if student fail and taking the same course in another semester ?

    // this constructor is used by database team
    public Course (int _id, String _name, UserClass _professor, Program _program, int _semester) {
        id = _id;
        name = _name;
        professor = _professor;
        program = _program;
        semester = _semester;
    }

    // it does not used
                //201              A             Cpan             java               rob
    /*public Course(int _code, String _section, Program _program, String _name, UserClass _professor)
    {
        this.section=_section;
        this.name=_name;
        this.professor=_professor;
        this.section=_section;
        this.code=_code;
    }*/
    
    public int getid()
    {
        return id;
    }
    public void setid(int _id)
    {
        this.id=_id;
    }
    public String getname()
    {
        return name;
    }
    public void setname(String _name)
    {
        this.name=_name;
    }
    public String getsection()
    {
        return section;
    }
    public void setsection(String _section)
    {
        this.section=_section;
    }
    public UserClass getprofessor()
    {
        return professor;
    }
    public void setprofessor(AdminUser _professor)
    {
        this.professor=_professor;
    }
    public Program getprogram()
    {
        return program;
    }
    public void setprogram(Program _program)
    {
        this.program=_program;
    }
    
}
