/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examscheduler;

import database.DBConnection;
import database.DBCourse;
import database.DBProfile;
import database.DBProgram;
import database.DBRoom;
import database.DBUrl;
import java.util.HashMap;
import server.AdminUser;
import server.UserClass;
import server.exceptions.DatabaseException;
import server.serverapi.Course;
import server.serverapi.Program;

/**
 *
 * @author hani
 */
public class MainHani {

    public static void main(String[] args) {

        DBConnection.getInstance();
        try {
            
           // AdminUser user = new DBProfessor().
            
           String ur= new DBUrl().createUrl("/hi/hello/how are u");
            System.out.println( ur);
            
           // Program p = new DBProgram().createProgram("Nursing1");
            //System.out.println(p.getProgramId() + p.getProgramName());
            
            /*
            HashMap<Integer,String> rmap = DBUrl.getUrls();
            for (HashMap.Entry<Integer,String> entry : rmap.entrySet()) {
                System.out.println("id: " + entry.getKey() + "url object itself: " + entry.getValue());
            }*/
         //String url = DBUrl.getUrl(1);
           // System.out.println("URL" + url);
            //DBUrl ur = new DBUrl();
            //ur.createUrl("hello");
            //DBUrl.setUrl(11, "hi");
            
           // int del_count = DBUrl.deleteUrl(11);
         //if(del_count == 0) System.out.println("Oops...");
          // System.out.println("total deleted: " + del_count);
            
        
            
            //DBProgram pro = new DBProgram();
            //pro.createProgram("open-source");//
            //int del = DBProgram.deleteProgram(10);
            //int del_count = DBProgram.deleteProgram(2187);
            //System.out.println(":)");

          //  int del_count = DBRoom.deleteRoom(20);
            //if (del_count == 0) {
            //   System.out.println("Oops...");
            //}
            //System.out.println("total deleted: " + del_count);
            
            /*
            HashMap<Integer, Program> rmap = DBProgram.getPrograms();
            for (HashMap.Entry<Integer, Program> entry : rmap.entrySet()) {
                System.out.println("id: " + entry.getKey() + " program object itself: " + entry.getValue().getProgramName());
            }*/
            
           // Program r = DBProgram.getProgram(9);
         //System.out.println("Program data: " + r.getProgramName());
            /*
             int del_count = DBCourse.deleteCourse(14);
            if (del_count == 0) {
               System.out.println("Oops...");
            }
            System.out.println("total deleted: " + del_count);
            */
            
           // Course  c= DBCourse.getCourse(1);
            //System.out.println("course" + c.getname());
            
            
        } catch (DatabaseException ex) {
            ex.printStackTrace();
        }

        /*
         DBConnection.getInstance(); // this is server job, though
         try {
         //////////////// test create (insert)
         //Room room = new DBRoom().createRoom("B102", 74, "Class");
         DBRoom dbr = new DBRoom();
         Room myRoom = dbr.createRoom("A192", 33, "Lab");
            
         //////////////// test set (update)
         DBRoom.setRoom(1, "G140","Class", 120);
            
            
         //////////////// test delete
         //int del_count = DBRoom.deleteRoom(8);
         //if(del_count == 0) System.out.println("Oops...");
         //  System.out.println("total deleted: " + del_count);
            
         //////////////// room test
         Room r = DBRoom.getRoom(1);
         System.out.println("room data: " + r.getRoomName() + ", " + r.getRoomType() + ", " + r.getCapacity());
            
         //////////////// map test
         HashMap<Integer, Room> rmap = DBRoom.getRooms();
         for(HashMap.Entry<Integer, Room> entry : rmap.entrySet()) {
         System.out.println("id: " + entry.getKey() + " room object itself: " + entry.getValue().getRoomName());
         }
            
         } catch (DatabaseException ex) {
         ex.printStackTrace();
         }*/
    }
    }
    
