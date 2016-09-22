/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


/**
 *
 * @author Web team
 */
public class SampleServlet extends ServletBase{    
    String contents = "<HTML><HEAD><TITLE>HelloServlet</TITLE></HEAD><BODY>This is Sample Servlet</BODY></HTML>";
    
    public void doGet(HttpRequest req, HttpResponse res){
        // Below is to test Server error
//        int tempInt = 10/0;
//        String temp = Integer.toString(tempInt);
        res.append(contents);
    }
    
    
    
}
