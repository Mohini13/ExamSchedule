/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;



/**
 *
 * @author Web team
 */
public interface Servlet {
    void processRequest(HttpRequest req, HttpResponse res);
    void doGet(HttpRequest req, HttpResponse res);
    void doPost(HttpRequest eq, HttpResponse res);
    
   
}
