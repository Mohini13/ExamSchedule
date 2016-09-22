/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.scheduleGenerator;

/**
 *
 * @author yalcinozdemir
 */
public class TimeStore {
    
    private int minute;
    private int hour;

    public TimeStore(int _hour, int _minute){
    
        this.hour = _hour;
        this.minute = _minute;
    
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
    public String getTime(){
    
        return hour+":"+minute;
    
    }
}
