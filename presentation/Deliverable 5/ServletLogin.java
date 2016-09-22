package servlettemplate;

//Imports
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLogin extends HttpServlet {
    
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
         String title = "LoginTest";
         out.println("<title>" + title + "</title></head>");
         out.println("<body >");
         String body = "Login Test";
         out.println("<h1>" + body + "</h1>");
         out.println("<form>First name:<br>\n <input type=\"text\" name=\"firstname\">\n  <br>\n  Last name:<br>\n  <input type=\"text\" name=\"lastname\">\n <br><br>\n <input type=\"submit\" value=\"Submit\"></form>");
         out.println("</body></html>");
          
      } finally
      {
          //close the writer
          out.close();
      }
    }
}
