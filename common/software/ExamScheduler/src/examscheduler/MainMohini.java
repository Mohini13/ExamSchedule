/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examscheduler;

import database.DBConnection;
import database.DBProfessor;
import database.DBProfile;
import java.util.HashMap;
import server.SecurityProfile;
import server.exceptions.DatabaseException;

/**
 *
 * @author Mohini
 */
public class MainMohini {
    
    public static void main(String[] args) {

        
        DBConnection.getInstance();
        try{
            
             //////////////// test create (insert)
            
            /*DBProfessor dbr = new DBProfessor();
           
            dbr.createUser("Amrit", "pass","Amrit" , "kaur");*/
            
            //////////////// test set (update)
         // DBProfessor.setUserPassword(15,"oracle"); 
            
            
            
             ///////// test delete (delete)
          /*  int del_row=DBProfessor.deleteUser(19);
            if(del_row==0) System.out.println("ohhhhh");
            System.out.println("total delete: " + del_row);*/
            
           
          
            
            
            //test set for first name and last name
          // DBProfessor.setUser(13,"Alireza","kaur"); 
         // DBProfessor.setUser(12, "alireza","m"); 
           
          
            //Test get
            /* UserClass r = DBProfessor.getUser(15);
            System.out.println("Faculty data: " + r.getUserName() +  ", " + r.getPasswd());*/
           
        
            //////////////////////////////////////////////////////////////////////////
          // Checking profile class 
           
           //Testing the create (Insert) 
          /* DBProfile db = new DBProfile();
            db.createProfile(4,"mohini");*/
           
           
          // Test deletetion (delete)
         /*  int del_row=DBProfile.deleteProfile(4);
            if(del_row==0) System.out.println("ohhhhh");
            System.out.println("total delete: " + del_row);*/
            
           
            //Test set (update)
         // DBProfile.setProfile(1, "Admin");
            
            
               // Test get
          /* SecurityProfile  r = DBProfile.getProfile(1);
            System.out.println("Profile data: " + r.getProfileName());*/
            
            
             //////////////// map test
            HashMap<Integer, SecurityProfile> rmap = DBProfile.getProfiles();
            for(HashMap.Entry<Integer, SecurityProfile> entry : rmap.entrySet()) {
                System.out.println("id: " + entry.getKey() + " room object itself: " + entry.getValue().getProfileName());
            }
           
           
           
        }catch(DatabaseException ex){
            ex.printStackTrace();
        }
 
     
         
           
          
            
            
        } 

    }


