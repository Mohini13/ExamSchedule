package examscheduler;

import database.DBConnection;
import database.DBCourse;
import database.DBProfessor;
import database.DBProgram;
import server.*;
import server.exceptions.DatabaseException;
import server.serverapi.Course;
import server.serverapi.Program;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by ivan on 11/11/15.
 */
public class MainIvan {

    List<UserClass> users;
    PermissionTable permTab;

    public static void main(String[] args) {

        // registerServlets
        // registerPermissions
        // listen for connection
        //SimpleServer ss = new SimpleServer(8080);

        // for test only
        MainIvan m = new MainIvan();

    }

    MainIvan() {

        // initialize db connection
        DBConnection db = DBConnection.getInstance();

        testProgram();
        testCourse();

        // this should throw an UnsupportedOperationException
        /*try {
            System.out.println("This is expected exception");
            RoomTest.getRoom(1); // this works!
        } catch (Exception e)
        {
            e.printStackTrace();
        }*/

        users = new ArrayList<>();
        setUsers();
        testUserProfiles();

        permTab = new PermissionTable();
        permTab.displayAllPermissions();

        testProfileUrl();


        System.out.println("\nlogin() and password digest tests:");
        UserClass bob = users.get(0);
        System.out.println(bob.getUserName() +" login " + (bob.login("it is always successful for public user") ? "successful" : "failed" ) + ", password hash is (" + bob.getPasswd() +")");

        UserClass john = users.get(3);
        System.out.println(john.getUserName() +" login " + (john.login("pass1") ? "successful" : "failed" ) + ", password hash is (" + john.getPasswd() +")");

        UserClass rob = users.get(5);
        System.out.println(rob.getUserName() +" login " + (rob.login("pass2") ? "successful" : "failed" ) + ", password hash is (" + rob.getPasswd() +")");

        //System.out.println(DataGenerator.getWord(7));

        // destroy db connection
        db.destroy();
    }

    void setUsers(){
        users.add( new PublicUser(1,"Bob") );
        users.add( new PublicUser(2,"Anna") );
        users.add( new PublicUser(3,"Tom") );
        users.add( new AdminUser(4,"John", "pass0") );
        users.add( new AdminUser(5,"Bill", "pass1") );
        users.add( new SuperUser(6,"Rob", "pass2") );
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

    void testCourse() {
        System.out.println("Test Course DB methods");
        try {
            Course c = DBCourse.getCourse(2);
            System.out.println("course name: " + c.getname() + ", professor: " + c.getprofessor());

            UserClass scott = DBProfessor.getUser(6);
            Program cpan = DBProgram.getProgram(20);

            //Course java = new DBCourse().createCourse("cpan-133-os", scott, cpan, 1); // 1 is the first semester

            /*
            // this is not going to work because there is inconsistency in DB
            HashMap<Integer, Course> rmap = DBCourse.getCourses();
            for (HashMap.Entry<Integer, Course> entry : rmap.entrySet()) {
                System.out.println("id: " + entry.getKey() + " program object itself: " + entry.getValue());
            }*/

        } catch (DatabaseException ex) {
            ex.printStackTrace();
        }
    }

    void testProgram() {
        System.out.println("Test Program DB methods");
        try {

            Program animation3d = new DBProgram().createProgram("Animation 3D");
            System.out.println("program_id is: " + animation3d.getProgramId() + " program name is: " + animation3d.getProgramName());

            Program cpan = DBProgram.getProgram(20);


            /*
            // this is not going to work because there is inconsistency in DB
            HashMap<Integer, Course> rmap = DBCourse.getCourses();
            for (HashMap.Entry<Integer, Course> entry : rmap.entrySet()) {
                System.out.println("id: " + entry.getKey() + " program object itself: " + entry.getValue());
            }*/

        } catch (DatabaseException ex) {
            ex.printStackTrace();
        }
    }

}
