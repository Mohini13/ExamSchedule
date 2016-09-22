/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

/**
 *
 * @author Suhn
 */
public class SessionInfo {
    static int lastSessionID = 0;
    
    int sessionID;
    long timeStamp;
    
    public SessionInfo()
    {
        sessionID = lastSessionID++;
        timeStamp = System.currentTimeMillis();
    }
    
    public int getSessionID()
    {
        return sessionID;
    }
    
    public long getTimeStamp()
    {
        return timeStamp;
    }
    
    public void touch()
    {
        timeStamp = System.currentTimeMillis();
    }
    
    public boolean olderThan(int minutes)
    {
        long mins = minutes * 1000 * 60;
        long diff = System.currentTimeMillis() - timeStamp;
        return diff > mins;
    }
}
