package humber.cpan205na;

import humber.cpan205na.controller.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ivan on 11/11/15.
 */
public class Main {

    List<UserClass> users;
    PermissionTable permTab;

    public static void main(String[] args) {

        // registerServlets
        // registerPermissions
        // listen for connection
        //SimpleServer ss = new SimpleServer(8080);

        // for test only
        Main m = new Main();

    }

    Main() {
        users = new ArrayList<>();
        setUsers();
        testUserProfiles();

        permTab = new PermissionTable();
        permTab.displayAllPermissions();

        testProfileUrl();


        System.out.println("\nlogin() and password digest tests:");
        UserClass bob = users.get(0);
        System.out.println(bob.getUserName() +" login " + (bob.login("") ? "successful" : "failed" ) + ", password hash is (" + bob.getPasswd() +")");

        UserClass john = users.get(3);
        System.out.println(john.getUserName() +" login " + (john.login("pass123") ? "successful" : "failed" ) + ", password hash is (" + john.getPasswd() +")");

        UserClass rob = users.get(5);
        System.out.println(rob.getUserName() +" login " + (rob.login("pass2") ? "successful" : "failed" ) + ", password hash is (" + rob.getPasswd() +")");

        //System.out.println(DataGenerator.getWord(7));
    }

    void setUsers(){
        users.add( new PublicUser("Bob") );
        users.add( new PublicUser("Anna") );
        users.add( new PublicUser("Tom") );
        users.add( new AdminUser("John", "pass0") );
        users.add( new AdminUser("Bill", "pass1") );
        users.add( new SuperUser("Rob", "pass2") );
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
