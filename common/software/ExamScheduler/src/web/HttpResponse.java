/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;


/**
 *
 * @author Web team
 */
public class HttpResponse extends HttpMessage
    {
    String statusCode;
    String description;
    String contentType;
    String contentLength;
    OutputStream os;
    PrintWriter writer;
    HttpRequest request;
    boolean parseFailed = false;
    static StringBuilder result;    
    
    HashMap<String, String> headers = new HashMap();
    HashMap<String, String> parameters = new HashMap();
    
    public HttpResponse(OutputStream os){
        this.os = os;
        statusCode = "200";
        description = "OK";
        contentType = "text/html";
        result = new StringBuilder();
    }
    
    public void setRequest(HttpRequest req){
        this.request = req;
    }
    
    void printError(Exception e){
        String errMsg = e.toString();
        result.append("\n" + errMsg);
    }
    
    void serialize() throws IOException{
        OutputStreamWriter writer = new OutputStreamWriter(os);
                                        
        //contentLength = headers.get("Content-Length");
        //result.append(contentType);
        
        headers.put("Content-Length", String.valueOf(result.length()));        
        headers.put("Content-Type", contentType);
        headers.put("Date", getServerTime());
                
        writer.append("HTTP/1.1 " + statusCode + " " + description + "\r\nServer: Web Server\r\n");
        
        Set<String> keys = headers.keySet();
        for(String k:keys)
        {
            writer.append(k);
            writer.append(":");
            writer.append(headers.get(k));
            writer.append("\r\n");
        }
        writer.append("\r\n");
        
        writer.append(result.toString());
        writer.flush();
        
    }
    
    void append(String str){
        result.append(str);
    }
    
    void append(StringBuilder sb){
        result.append(sb);
    }
    
    String getServerTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
            "EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(calendar.getTime());
    }


}
