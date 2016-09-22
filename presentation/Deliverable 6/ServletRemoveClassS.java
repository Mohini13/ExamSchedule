package servlettemplate;

//Imports
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletRemoveClassS extends HttpServlet {

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
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<title> SeriousEditPage - Remove Class </title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<button type=\"submit\" formaction=\"ServletAddUserS\">Add Class</button>");
            out.println("<button type=\"submit\" formaction=\"ServletRemoveUserS\">Remove Class</button>");
            out.println("<button type=\"submit\" formaction=\"ServletAddClassS\">Add Class</button>");
            out.println("<button type=\"submit\" formaction=\"ServletRemoveClassS\">Remove Class</button>");
            out.println("<button type=\"submit\" formaction=\"ServletLogout\">Logout</button>");
            out.println("<br><br>");
            out.println("<table border=\"1\" style=\"width:100%\">");
            out.println("<tr>");
            out.println("<th>Time Slot</th>");
            out.println("<th>Monday</th>");
            out.println("<th>Tuesday</th>");
            out.println("<th>Wedesday</th>");
            out.println("<th>Thursday</th>");
            out.println("<th>Friday</th>");
            out.println("<th>Saturday</th>");
            out.println("<th>Sunday</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>1</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>2</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>3</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>4</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>5</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>6</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>7</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>8</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>9</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>10</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("<td>-</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<p>Add a Class:</p>");
            out.println("<form action=\"RemoveClassS\" method=\"POST\">");
            out.println("<select name=\"Time\">");
            out.println("<option> Time </option>");
            out.println("<option value=\"time1\">1</option>");
            out.println("<option value=\"time2\">2</option>");
            out.println("<option value=\"time3\">3</option>");
            out.println("<option value=\"time4\">4</option>");
            out.println("<option value=\"time5\">5</option>");
            out.println("<option value=\"time6\">6</option>");
            out.println("<option value=\"time7\">7</option>");
            out.println("<option value=\"time8\">8</option>");
            out.println("<option value=\"time9\">9</option>");
            out.println("<option value=\"time10\">10</option>");
            out.println("</select>");
            out.println("<select name=\"Day\">");
            out.println("<option> Day </option>");
            out.println("<option value=\"monday\">Monday</option>");
            out.println("<option value=\"tuesday\">Tuesday</option>");
            out.println("<option value=\"wedesday\">Wedesday</option>");
            out.println("<option value=\"thursday\">Thursday</option>");
            out.println("<option value=\"friday\">Friday</option>");
            out.println("<option value=\"saturday\">Saturday</option>");
            out.println("<option value=\"sunday\">Sunday</option>");
            out.println("</select>");
            //out.println("<input type=\"text\" name=\"classCode\" value=\"Course Code\">");
            out.println("<br><br>");
            out.println("<input type=\"submit\">");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");

        } finally {
            //close the writer
            out.close();
        }
    }
}
