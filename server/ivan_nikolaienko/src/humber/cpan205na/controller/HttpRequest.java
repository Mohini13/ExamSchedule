/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package humber.cpan205na.controller;
import java.util.*;
import java.io.*;

/**
 *
 * @author robson - thank you!
 */


public class HttpRequest { // implement an abstract class HttpMessage
    HashMap<String, String> headers = new HashMap();
    HashMap<String, String> parameters = new HashMap();
    String method = null;
    String url = null;
    String version = null;
    boolean parseFailed = false;
    
    public HttpRequest(InputStream is)
    {
        parseContent(is);
    }
    
    void parseContent(InputStream is)
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            
            String firstLine = br.readLine();
            if(firstLine != null)
            {
                String [] reqLine = firstLine.split(" ");
                if(reqLine.length == 3)
                {
                    method = reqLine[0];
                    url = reqLine[1];
                    version = reqLine[2];
                }
                else
                {
                    parseFailed = true;
                }
            }
            else
            {
                parseFailed = true;
            }
            
            if(parseFailed) return;
            
            line = br.readLine();
            while(line != null)
            {
                line = line.trim();
                if(line.length() > 0)
                {
                    int idx = line.indexOf(":");
                    if(idx > 0)
                    {
                        headers.put(line.substring(0, idx), line.substring(idx+1).trim());
                    }
                    line = br.readLine();
                }
                else
                {
                    line = null;
                }
            }
            
            if(method.equalsIgnoreCase("POST"))
            {
                int contentLen = -1;
                String lenStr = headers.get("Content-Length");
                if(lenStr != null)
                {
                    try {
                        contentLen = Integer.parseInt(lenStr);
                    }
                    catch(Exception e1)
                    {}
                }
                StringBuilder parmStr = new StringBuilder(128);
                int bytesRead = 0;
                while(bytesRead < contentLen)
                {
                    int ch = br.read();
                    if(ch < 0) break;
                    parmStr.append(ch);
                    bytesRead++;
                }
                String parmLines[] = parmStr.toString().split("&");
                for(int i = 0; i < parmLines.length; i++)
                {
                    String parm[] = parmLines[i].split("=");
                    if(parm.length == 2)
                    {
                        parameters.put(parm[0], parm[1].trim());
                    }
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       
    }
    
    public String toString()
    {
        StringBuilder result = new StringBuilder(256);
        result.append(method);
        result.append(" ");
        result.append(url);
        result.append(" ");
        result.append(version);
        result.append("\n");
        
        Set<String> keys = headers.keySet();
        for(String k:keys)
        {
            result.append(k);
            result.append(":");
            result.append(headers.get(k));
            result.append("\n");
        }
        result.append("\n");
        
        keys = parameters.keySet();
        for(String k:keys)
        {
            result.append(k);
            result.append("=");
            result.append(parameters.get(k));
            result.append("\n");
        }
        
        return result.toString();
    }

    public String getType(){
        return "post or get";
    }

    public String getUrl() {
        return url;
    }
}
