package examscheduler;

import server.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import server.serverapi.*;
import server.unused.Professor;


/**
 * Created by ivan on 11/11/15.
 */
public class MainJordan {

    List<UserClass> users;
    List<Course> courses;
    List<Program> programs;
    List<Professor> professors;
    List<Room> rooms;
    List<Exam> exams;
    List<Location> location;
    PermissionTable permTab;

    public static void main(String[] args) {

        // registerServlets
        // registerPermissions
        // listen for connection
        //SimpleServer ss = new SimpleServer(8080);

        // for test only
        MainJordan jordan = new MainJordan();

    }

    MainJordan() {
        users = new ArrayList<>();
        courses = new ArrayList<>();
        programs = new ArrayList<>();
        professors = new ArrayList<>();
        rooms = new ArrayList<>();
        exams = new ArrayList<>();
        location = new ArrayList<>();
        setUsers();
        setProgram();
        setProfessor();
        setCourses();
        setLocations();
        setRooms();
        setExams();
        testUserProfiles();

        permTab = new PermissionTable();
        permTab.displayAllPermissions();

        testProfileUrl();


        System.out.println("\nlogin() and password digest tests:");
        UserClass bob = users.get(0);
        System.out.println(bob.getUserName() +" login " + (bob.login("") ? "successful" : "failed" ) + ", password hash is (" + bob.getPasswd() +")");

        UserClass john = users.get(3);
        System.out.println(john.getUserName() +" login " + (john.login("pass1") ? "successful" : "failed" ) + ", password hash is (" + john.getPasswd() +")");

        UserClass rob = users.get(5);
        System.out.println(rob.getUserName() +" login " + (rob.login("pass2") ? "successful" : "failed" ) + ", password hash is (" + rob.getPasswd() +")");

        //System.out.println(DataGenerator.getWord(7));
    }

    void setUsers(){
        users.add( new PublicUser(1,"Bob") );
        users.add( new PublicUser(2,"Anna") );
        users.add( new PublicUser(3,"Tom") );
        users.add( new AdminUser(4,"John", "pass0") );
        users.add( new AdminUser(5,"Bill", "pass1") );
        users.add( new SuperUser(6,"Rob", "pass2") );
    }
    void setProgram(){
        programs.add(new Program(1,"CPAN"));
        programs.add(new Program(2,"MATH"));
        programs.add(new Program(3,"PHIL"));
        programs.add(new Program(4,"SOCI"));
        
        
    }
    void setProfessor(){
        //professors.add(new Professor("Rob","password"));
        
        //professors.add(new Professor((AdminUser)users.get(3)));
        //professors.add(new Professor((AdminUser)users.get(4)));
        
    }
    void setCourses()
    {
        /*
        HashMap<Integer, Course> coursesMap = new HashMap<>();
        int id = 0;
        coursesMap.put(id++, new Course(1, 200,"A",programs.get(0), "Java",users.get(3)));
        
//String _section, Program _program, String _name, AdminUser _professor
        
        coursesMap.put(id++, new Course(2, 200,"A",programs.get(0), "Java", (AdminUser)users.get(3)));
        courses.add(new Course(3, 200,"B",programs.get(0), "Java", (AdminUser)users.get(3))); //SAME ID/TEACHER DIFF SECTION
        courses.add(new Course(4, 201,"A",programs.get(0), "SQL", (AdminUser)users.get(3))); 
        courses.add(new Course(5, 202,"A",programs.get(0), "XML", (AdminUser)users.get(3))); //SAME TEACHER/PROGRAM/SECTION DIFF ID
        courses.add(new Course(202,"B",programs.get(0), "XML", (AdminUser)users.get(4))); //SAME ID/PROGRAM DIFF SECTION/TEACHER
        courses.add(new Course(203,"A",programs.get(0), "PHP", (AdminUser)users.get(3))); //SAME PROFESSOR/SECTION DIFF ID
        courses.add(new Course(201,"A",programs.get(1), "ALGEBRA", (AdminUser)users.get(3))); //SAME ID/SECTION/TEACHER DIFF PROGRAM
        HashMap<Integer, Course> courseMap = new HashMap<Integer, Course>();
        
        for(int i=0;i<courses.size();i++){
            courseMap.put(i,courses.get(i));
        }
                */
        
    }
    void setLocations(){
        location.add(new Location(130,"J"));
        location.add(new Location(129,"J"));
        location.add(new Location(128,"J"));
        location.add(new Location(127,"J"));
        location.add(new Location(130,"M"));
        
        
    }
    void setRooms(){
        // public Room(int _roomId, String _roomName, String _roomType, int _capacity){
        rooms.add(new Room(1,"J130","Lab",30));
        rooms.add(new Room(2,"J131","Lab",30));
        rooms.add(new Room(3,"J132","Lab",30));
        rooms.add(new Room(4,"J133","Lab",30));
    }
    void setExams(){
        //int examid, Course course, Location location, Room room, Time stime, Time etime
        
        
    }

    void testUserProfiles() {
        System.out.println("\nTest Users' Profiles:");
        for(UserClass u : users) {
            System.out.println(u.toString());
        }
        System.out.println();
    }

    void testProfileUrl() {
        boolean result;
        System.out.println("\nTest Profile-Url pairs:");
        for(UserClass u : users) {
            String randUrl = permTab.getRandomUrl();
            result = u.validatePermission(permTab, randUrl);
            System.out.println(u.toString() + " is " + (result ? "allowed" : "not allowed") + " to go to " + randUrl );
        }
    }

}
