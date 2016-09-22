package humber.cpan205na.controller;

import java.net.*;
import java.io.*;
import java.util.*;
import java.text.*;

/**
 *
 * @author robson - thank you!
 */
public class SimpleServer {
    boolean keepRunning = true;
    
    public SimpleServer(int port)
    {
        ServerSocket server = null;
        boolean isGet = true;
        try {
            server = new ServerSocket(port);
            System.out.println("Listening on port " + port);
            while(keepRunning)
            {
                Socket client = server.accept();
                System.out.println("Connected ...");
                InputStream is = client.getInputStream();
                
                System.out.println("building request ...");
                HttpRequest req = new HttpRequest(is);
                if(req.parseFailed)
                {
                    System.out.println("Parse failed");
                }
                else
                {
                    System.out.println(req);
                    
                     OutputStream os = client.getOutputStream();
                    OutputStreamWriter writer = new OutputStreamWriter(os);
                    String result = "HTTP/1.1 200 OK\r\nServer: SimpleServer\r\nDate: ";
                    result += getServerTime() + "\r\n\r\n";
                    result += "<html><head></head><body>Hello World</body></html>";
                    writer.write(result);
                    writer.flush();
                }
                             
                client.close();
                
            }
            
        
        }
        catch(Exception e1)
        {
            e1.printStackTrace();
        }
        finally
        {
            try{
                if(server != null)server.close();
            }
            catch(Exception e){}
        }
    }
    
    String getServerTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(
            "EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(calendar.getTime());
    }

    /**
     * @param args the command line arguments
     */
    /*public static void main(String[] args) {
        SimpleServer ss = new SimpleServer(8080);
    }*/
    
}
