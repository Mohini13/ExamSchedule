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
public class Servlet404 extends ServletBase {
    String contents = "<HTML><HEAD><TITLE>HelloServlet</TITLE></HEAD><BODY>Page Not Found! (This is 404 servlet)</BODY></HTML>";
    
    public void doGet(HttpRequest req, HttpResponse res){
        res.append(contents);
    }
}
