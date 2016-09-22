/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.net.InetAddress;
import java.sql.Timestamp;

/**
 *
 * @author Web team
 */
public class UserID {
    InetAddress ipAddress;
    String agent;
    int port;
    long timeStamp;
    
    public UserID(){
        ipAddress = null;
        agent = null;
        port = 0;
    }
    
    public UserID(InetAddress adres, String a){
        this.ipAddress = adres;
        this.agent = a;
    }
    
    public UserID(InetAddress adres, int p){
        this.ipAddress = adres;
        this.port = p;
    }
    
    public void setIpAddress(InetAddress adres){
        this.ipAddress = adres;
    }
    
    public void setPort(int p){
        this.port = p;
    }    
    
    public void setTimestamp(long time){
        this.timeStamp = time;
    }
    
    public InetAddress getIpAddress(){
        return this.ipAddress;
    }
    
    public int getPort(){
        return this.port;
    }
    
    public int hashCode()
    {
        return ipAddress.hashCode() ;
    }
    
    public boolean equals(Object obj)
    {
        boolean result = false;
        if(obj instanceof UserID)
        {
            UserID uid = (UserID)obj;
            result = ipAddress == uid.ipAddress ;
        }
        return result;
    }
    
}
