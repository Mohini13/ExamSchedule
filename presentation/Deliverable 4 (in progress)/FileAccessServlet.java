package servlettemplate;

//Imports
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileAccessServlet extends ServletTemplate {
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
     String fName = getFullURL(req);
     PrintWriter out = res.getWriter();
     FileInputStream fis = null;
     BufferedInputStream bis = null;
     	try{
            fis = new FileInputStream(fName);
            bis = new BufferedInputStream (fis);
            while(bis.available()>0)
            {
                String line = "";
                line = line+(char)bis.read();             
                while(line!=null)
                {
                    out.print(line);
                }
            }  
        }finally{
            out.close();            
            if(fis!=null)
                fis.close();
            if(bis!=null)
                bis.close();
        }               
    }
    
  public static String getFullURL(HttpServletRequest req) {
    StringBuffer reqURL = req.getRequestURL();
    String queryString = req.getQueryString();

    if (queryString == null) {
        return reqURL.toString();
    } else {
        return reqURL.append('?').append(queryString).toString();
    }
  }  
}
