package servlettemplate;

//Imports
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletFirstPage extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Set response header content
        res.setContentType("text/html");

        //writes response into network socket
        PrintWriter out = res.getWriter();

        // Actual html stuff goes here
        try {
            out.println(" <!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<title> View Timetable Page </title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<button type=\"submit\" formaction=\"ServletLogin\">Login</button>");
            out.println("<br><br>");
            out.println("<table border=\"1\" style=\"width:100%\">");
            out.println("<caption>Please select course at the bottom</caption>");
            out.println("<tr>");
            out.println("<th>Time Slot</th>");
            out.println("<th>Monday</th>");
            out.println("<th>Tuesday</th>");
            out.println("<th>Wedesday</th>");
            out.println("<th>Thursday</th>");
            out.println("<th>Friday</th>");
            out.println("<th>Saturday</th>");
            out.println("<th>Sunday</th>");
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
            out.println("<br><br>");
            out.println("<p>Please Select a course to view timetable.</p>");
            out.println("<form action=\"ServletCheckCourse\">");
            out.println("<select name=\"course\">");
            out.println("<option value=\"class1\">Class 1</option>");
            out.println("<option value=\"class2\">Class 2</option>");
            out.println("<option value=\"class3\">Class 3</option>");
            out.println("<option value=\"class4\">Class 4</option>");
            out.println("</select>");
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
