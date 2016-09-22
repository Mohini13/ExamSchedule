package servlettemplate;

//Imports
import java.io.PrintWriter;

public class ServletAddUserS extends ServletBase {

    public void doGet(HttpRequest req, HttpResponse res) {// Set response header content
        StringBuilder contents = new StringBuilder();
           contents.append("<!DOCTYPE html>");
           contents.append("<html>");
           contents.append("<head>");
           contents.append("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
           contents.append("<title> EditUserPage - Add </title>");
           contents.append("</head>");
           contents.append("<body>");
           contents.append("<h2>Add a User:</h2>");
           contents.append("<form action=\"AddUser\" method=\"POST\">");
           contents.append("Login:<br>");
           contents.append("<input type=\"text\" name=\"username\">");
           contents.append("<br>");
           contents.append("Password:<br>");
           contents.append("<input type=\"text\" name=\"password\">");
           contents.append("<br><br>");
           contents.append("<input type=\"submit\" value=\"Submit\">");
           contents.append("</form>");
           contents.append("</body>");
           contents.append("</html>");
        
           res.append(contents);
    }
}
