package servlettemplate;

//Imports
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletErrorTemplate extends HttpServlet {
    
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
         String title = "ErrorTest";
         out.println("<title>" + title + "</title></head>");
         out.println("<body >");
         String bodyTitle = "Error Page";
         out.println("<h1>" + bodyTitle + "</h1>"); 
         String bodyDesc = "Insert error message here";
         out.println("<p>" + bodyDesc + "</p>"); 
         out.println("<br><br>");
         out.println("<button onclick=\"goBack()\">Go Back</button>");
         out.println("<script>");
         out.println("function goBack(){ window.history.back();}");
         out.println("</script>");
         out.println("</body></html>");
         
      } finally
      {
          //close the writer
          out.close();
      }
    }
    
   
}
