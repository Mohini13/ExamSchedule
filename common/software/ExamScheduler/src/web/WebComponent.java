package web;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Web team
 */
public class WebComponent {
    static WebComponent theInstance = null;
    SessionTable sessionTable = SessionTable.getInstance();
    
    public static WebComponent getInstance(){
        if(theInstance==null){
            theInstance = new WebComponent();
        }
        return theInstance;
    }
    
    private WebComponent(){        
    }
    
    void connect(int port){
        SessionTable sessionTable = SessionTable.getInstance();        
        
        ServerSocket server = null;
        boolean isGet = true;
        try{
            server = new ServerSocket(port);
            System.out.println("Listening on port " + port + "...");
            
            while(Server.listening){
                Socket client = server.accept();  
                InputStream is = client.getInputStream();
                OutputStream os = client.getOutputStream();                                               
                System.out.println("Connected ...");                                                                
         
                // create Request object and build               
                System.out.println("building request ...");
                HttpRequest req = new HttpRequest(is);                                                                              
                
                // Decided to use UserAgent instead of port number                
                InetAddress address = client.getInetAddress();
                String agent = req.getAgent();
                int sessionID = sessionTable.getSessionID(address, agent);
                req.sessionID = sessionID;
                
                if(req.parseFailed){
                    System.out.println("Parse failed");                    
                }else{
                    System.out.println(req.toString());                                        
                }
                                   
                // create Response object
                HttpResponse res = new HttpResponse(os);
                res.setRequest(req);                

                // get Servlet
                ServletTable st = ServletTable.getInstance();
                Servlet servlet = st.getServlet(req);
                
                //serialize HttpResponse and print
                if(servlet!=null){   
                    try{
                        servlet.processRequest(req, res);
                        res.serialize();
                    }catch(Exception e){
                        e.printStackTrace();
                        servlet=st.getServlet("/Servlet500");
                        servlet.processRequest(req,res);                        
                        res.printError(e);
                        res.serialize();
                    }               
                }else{
                    servlet = st.getServlet("/Servlet404");
                    servlet.processRequest(req, res);
                    res.serialize();
                }                
                client.close();                
            }
        }catch(Exception e1){
            e1.printStackTrace();
        }finally{
            try{
                if(server != null) server.close();
            }catch(Exception e){}
        }
         
    }  
    
}
