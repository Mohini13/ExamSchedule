/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.Iterator;
import server.UserClass;

/**
 *
 * @author Suhn
 */
public class ServletLoginCheck extends ServletBase {

    String[] IDs;
    String ID;
    String[] PWs;
    String PW;
    Boolean IDFlag = false;
    Boolean PWFlag = false;

    @Override
    public void doGet(HttpRequest req, HttpResponse res) {
        //looks through parameter names and gets value
        Iterator<String> parameterNames = req.getParameterNames();

        while (parameterNames.hasNext()) {
            String paramName = parameterNames.next();
            //USERNAME
            if (paramName.equals("username")) {
                ID = req.getParameterValues(paramName);
            }
            //PASSWORD
            if (paramName.equals("password")) {
                PW = req.getParameterValues(paramName);
            }
        }
        String[][] serverResponse = {{"Hi", "Bye"},
        {"Moop", "Boop"},
        {"Clyde", "Bobbert"}};
        int t = 0;
       //Ask Server for list of Usernames & passwords
        //USERNAME
        for (int i = 0; i < serverResponse.length; i++) {
            if (serverResponse[i].equals(ID)) {
                IDFlag = true;
                t = i;
            }
        }
        //Password
        if (serverResponse[t].equals(PW)) {
            PWFlag = true;
        }

        if (IDFlag && PWFlag) {
            //run the logged in servlet         
        }

        /*
         //Ask Server for list of Usernames & passwords
         //USERNAME
         UserClass uc = new UserClass();
         String[] Usernames;
         String[] Passwords;

         //Usernames = uc.getUserName();
         //Passwords = uc.getPasswd();
        Usernames = {"hi","Moop","Clyde");
        Passwords = {"Bye","Bloop", "Bobbert");
        
         for (String username : Usernames) {
         if (ID.equals(username)) {
         IDFlag = true;
         }
         }
         for (String password : Passwords) {
         if (PW.equals(password)) {
         PWFlag = true;
         }
         }
         if(IDFlag && PWFlag){
         //logs in
         }
         */
    }
}
