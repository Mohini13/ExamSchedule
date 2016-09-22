/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.scheduleGenerator;
import java.util.Calendar;
import server.AdminUser;
import server.serverapi.*;
import server.DataGenerator;
import server.unused.Professor;

/**
 *
 * @author yalcinozdemir
 */
public class generator {
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Program program = new Program(1,"Computer Prog.");
        Location loc = new Location(1,"North");
        Room room = new Room(1, "217","Lab",5);
        AdminUser professor =  Professor.getNewProfessor(0, DataGenerator.getWord(5),
               DataGenerator.getWord(8));
        
       /*Course course = new Course(
               1,
               "A",
               program,
               "Java Programming",
               professor      
       );*/
       
       
      Calendar date = Calendar.getInstance();
        date.set(2015, Calendar.JANUARY, 1);
        
        
        TimeStore startTime = new TimeStore(13,15);
        TimeStore endTime = new TimeStore(15,15);
      
      
      
      //Exam exam = new Exam(course,loc,room,date,startTime,endTime);
       
      //System.out.println(getExamInfo(exam));
       

        
        
        
    }
    public static String getExamInfo(Exam exam){
    
        
        return "Exam ID:" + exam.getExamId() +
                "\nCourse: " + exam.getCourse().getname() +
                "\nLocation: " + exam.getLocation().getLocationName() + 
                "\nRoom: " + exam.getRoom().getRoomName() + 
                "\nRoom Type: " + exam.getRoom().getRoomType() + 
                "\nDate: " + exam.getDate().getTime() +
                "\nStart Time: " + exam.getStartTime().getTime() +
                "\nEnd Time: " + exam.getEndTime().getTime();

    
    
    }
    
}
