/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.net.InetAddress;
import java.sql.Timestamp;
import java.util.HashMap;
import java.text.SimpleDateFormat;

/**
 *
 * @author Web team
 */
public class SessionTable {
    static SessionTable theInstance = null;
    
    int sessionID;    
    UserID user;
    
    static int lastSessionID = 0;
    boolean isExpired = false;
    long timeStamp;
        
    HashMap<String, SessionInfo> sessionTable;
    
    public static SessionTable getInstance(){
        if(theInstance==null){
            theInstance = new SessionTable();
        }
        return theInstance;
    }
    
    private SessionTable(){
        sessionTable = new HashMap<String, SessionInfo>();
    }
    
    
    void addSession(String s){
        sessionID = lastSessionID++;
        sessionTable.put(s, new SessionInfo());
    }
    
    int getSessionID(InetAddress adres, String a){
        System.out.println("*** I AM IN SESSION TABLE addr=" + adres + " User-Agent=" + a + " ***");
        user = new UserID(adres, a);
        int thisSession = 0;
        
        String userKey = adres.toString() + a;
        
        if(!sessionTable.containsKey(userKey)){
            addSession(userKey);
            SessionInfo sessInfo = sessionTable.get(userKey);
            thisSession = sessInfo.getSessionID();
            System.out.println("Creating a new session");
        }else{
            isExpired = checkForExpiredSession(userKey);
            if(!isExpired){
                SessionInfo sessInfo = sessionTable.get(userKey);
                thisSession = sessInfo.getSessionID();
                sessInfo.touch();
                System.out.println("Return existing session ID. Timestamp is renewed");
            }else{
                removeSession(userKey);
                System.out.println("This session is expired. Need to inform the server");
            }
        }
        
        return thisSession;
    }
        
    void removeSession(String u){
        sessionTable.remove(u);
    }
    
    //time limit 10min (=600000 mil sec)
    boolean checkForExpiredSession(String u){
        boolean temp = false; 
        SessionInfo sessInfo = sessionTable.get(u);
        temp = (sessInfo.olderThan(60));
                  
        return temp;
    }
    
  
}