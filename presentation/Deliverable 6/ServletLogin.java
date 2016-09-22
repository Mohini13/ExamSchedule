package servlettemplate;

//Imports
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLogin extends HttpServlet {

    String sName = "ServletLoginCheck";
    String sMethod = "POST";

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Set response header content
        res.setContentType("text/html");

        //writes response into network socket
        PrintWriter out = res.getWriter();

        // Actual html stuff goes here
        try {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println(" <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println(" <title> Login Page </title>");
            out.println(" </head>");
            out.println(" <body>");
            out.println(" <h1> Login Page </h1>");
            out.println(" <form action=\"" + sName + "\" method=\"" + sMethod + "\">");
            out.println(" Login:<br>");
            out.println("<input type=\"text\" name=\"username\">");
            out.println("<br>");
            out.println("Password:<br>");
            out.println(" <input type=\"text\" name=\"password\">");
            out.println(" <br><br>");
            out.println("<input type=\"submit\" value=\"Submit\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            //close the writer
            out.close();
        }
    }
}
