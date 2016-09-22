/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
//import javax.servlet.Servlet;

/**
 *
 * @author Web team
 */
public class Server {
    static boolean listening = false;        
    static WebComponent wc;
    
    public static void main(String[] args){
        wc = WebComponent.getInstance();
        ServletTable servletTable = ServletTable.getInstance();        
        servletTable.registerServlets("/SampleServlet", new SampleServlet());
        servletTable.registerServlets("/Servlet404", new Servlet404());
        servletTable.registerServlets("/Servlet500", new Servlet500());
        servletTable.registerServlets("/LoginServlet", new LoginServlet());
        servletTable.registerServlets("/ServletLoginCheck", new ServletLoginCheck());
        listenForConnection(8080);
    }
    
    private static void listenForConnection(int p){
        listening = true;
        wc.connect(p);
    }
    
    
        
}
