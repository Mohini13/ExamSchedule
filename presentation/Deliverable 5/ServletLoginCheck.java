package servlettemplate;

//Imports
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLoginCheck extends HttpServlet {
    String[] IDs;
    String ID;
    String[] PWs;
    String PW;
    Boolean IDFlag = false;
    Boolean PWFlag = false;
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        
      // Set response header content
      res.setContentType("text/html");
      
      //writes response into network socket
      PrintWriter out = res.getWriter();
      
      //looks through parameter names and gets value
      Enumeration<String> parameterNames = req.getParameterNames();
      
       while (parameterNames.hasMoreElements()) 
       {
           String paramName = parameterNames.nextElement();
           //USERNAME
           if(paramName.equals("username"))
           {
              IDs = req.getParameterValues(paramName);
              for (int i = 0; i < IDs.length; i++) 
              {
                  ID= IDs[i];
              }              
           }
           //PASSWORD
           if(paramName.equals("password"))
           {
              PWs = req.getParameterValues(paramName);
              for (int i = 0; i < PWs.length; i++) 
              {
                  PW= PWs[i];
              }              
           }
       }
       String[][] serverResponse ={{"Hi","Bye"},
                                   {"Moop","Boop"},
                                   {"Clyde","Bobbert"}};
       int t=0;
       //Ask Server for list of Usernames & passwords
       //USERNAME
       for(int i = 0; i < serverResponse.length;i++)
       {
           if(serverResponse[i].equals(ID))
           {
               IDFlag=true;
               t=i;
           }
       }
       //Password
       if(serverResponse[t].equals(PW))
       {
           PWFlag=true;
       }
       
       if(IDFlag && PWFlag)
       {
           //run the logged in servlet
       }
    }
}
