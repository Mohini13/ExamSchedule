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
public class ServletBase 
    implements Servlet {
    
    public void processRequest(HttpRequest req, HttpResponse res){
        if(req.getMethod().equals("GET")) doGet(req, res);
        else doPost(req,res);
    }
    
    public void doPost(HttpRequest req, HttpResponse res){
       
    }
    public void doGet(HttpRequest req, HttpResponse res){
        
    }
}
