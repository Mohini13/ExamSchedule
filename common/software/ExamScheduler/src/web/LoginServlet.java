/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.PrintWriter;

/**
 *
 * @author Suhn
 */

public class LoginServlet extends ServletBase{
        
    public void doGet(HttpRequest req, HttpResponse res) 
    {
      // Used String builder instead of PrintWriter      
      // Actual html stuff goes here
        
        StringBuilder contents = new StringBuilder();
        contents.append("<!DOCTYPE html>");
        contents.append("<html><head>");
        contents.append("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
        contents.append("LoginTest");
        contents.append("<title>" + "Login" + "</title></head>");
        contents.append("<body >");
        contents.append("Login Test");
        contents.append("<h1>" + "Login Page" + "</h1>");
        contents.append("<form>First name:<br>\n <input type=\"text\" name=\"firstname\">\n  <br>\n  Last name:<br>\n  <input type=\"text\" name=\"lastname\">\n <br><br>\n <input type=\"submit\" value=\"Submit\"></form>");
        contents.append("</body></html>");
        
        res.append(contents);            
    }
    
}
