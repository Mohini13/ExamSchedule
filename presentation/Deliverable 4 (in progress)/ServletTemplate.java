package servlettemplate;

//Imports
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTemplate extends HttpServlet {

    public void processRequest(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
    {
        if("GET".equals(req.getMethod()))
	{
		doGet(req,res);
	}
	else if("POST".equals(req.getMethod()))
	{
		doPost(req,res);
	}
	else
	{
		//Error stuff here
	}
    }
    
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
      // Set response header content
      res.setContentType("text/html");
      
      //writes response into network socket
      PrintWriter out = res.getWriter();

      // Actual html stuff goes here
      try
      {
         out.println("<!DOCTYPE html>"); 
         out.println("<html><head>");
         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
         String title = "TestTest";
         out.println("<title>" + title + "</title></head>");
         out.println("<body>");
         String body = "Body Test";
         out.println("<h1>" + body + "</h1>"); 
         out.println("</body></html>");
          
      } finally
      {
          //close the writer
          out.close();
      }
    }
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)//throws ServletException, IOException
    {
      // TODO
      
    }
}
