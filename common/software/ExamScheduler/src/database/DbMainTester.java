/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.exceptions.DatabaseException;
import server.serverapi.Program;
import server.serverapi.Room;

/**
 *
 * @author hani
 */
public class DbMainTester {

    public static void main(String[] args) {

             // TODO code application logic here
//    DBConnection dbConn = DBConnection.getInstance();
//         
//    DBProgram p = new DBProgram();
//    
//    try {
//        p.createProgram("Network Technician");
//    }
//    catch (Exception e) {
//        e.printStackTrace();
//    }
//         
//    }
        // dbroom.createRoom("J130", 10, "Lab");
        // dbroom.createRoom("J140", 5, "Lab");
        // dbroom.createRoom("J132", 15, "Lab");
        // dbroom.createRoom("J129", 20, "Lab");
        // dbroom.deleteRoom(16);
        // dbroom.deleteRoom(17);
        // dbroom.deleteRoom(18);
        // dbroom.deleteRoom(19);
//        DBRoom.getRoom(2);
//        DBRoom.getRoom(4);
//        DBRoom.getRoom(3);
//        DBRoom.getRoom(1);
//
//    
//        /*DBProgram.createProgram("F");
//         DBProgram.createProgram("D");
//         DBProgram.createProgram("C");
//         DBProgram.createProgram("A");
//         DBProgram.createProgram("B");
//         DBProgram.createProgram("C");*/
//        // DBProgram.deleteProgram(1);
//        // DBProgram.updateProgram(2, "Game Programming");
//             DBProgram.getProgram(1);
//             DBProgram.getProgram(2);
//             DBProgram.getProgram(3);
//             DBProgram.getProgram(4);
//             
//             //DBCourse c = new DBCourse();
//             //   DBCourse.getCourse(1);
//         } catch (DatabaseException ex)
//         {
//             Logger.getLogger(DbMainTester.class.getName()).log(Level.SEVERE, null, ex);
//         }
        
        DBConnection.getInstance();
        try{
            DBProgram pro = new DBProgram();
            pro.createProgram("Accounting");//
             //int del = DBProgram.deleteProgram(10);
         
            
        }catch(DatabaseException ex){
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
