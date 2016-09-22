/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;


import java.util.HashMap;


/**
 *
 * @author Web team
 */
public class ServletTable {
    static ServletTable theInstance;
    HashMap<String, Servlet> urlServletMap;
    
  
            
    public static ServletTable getInstance(){
        if(theInstance==null){
            theInstance = new ServletTable();
        }
        return theInstance;
    }
    
    public ServletTable(){
        urlServletMap = new HashMap<String,Servlet>();
    }    
    
     // database can return the ServletTable using this constructor
    public ServletTable(HashMap<String,Servlet> hmap){
        urlServletMap = hmap;
    }
    
    Servlet getServlet(HttpRequest req){
        Servlet ser = null;
        String url = req.getUrl();        
        System.out.println("Look up servlet: " + url);
        ser = urlServletMap.get(url);
        if(ser == null) System.out.println("could not find srvlet " + url);
        return ser;
    }
    
    Servlet getServlet(String s){
        Servlet ser = null;                       
        ser = urlServletMap.get(s);
        return ser;
    }

      
    
  
    public void registerServlets(String str, Servlet ser){
        urlServletMap.put(str, ser);
    } 

    
}
