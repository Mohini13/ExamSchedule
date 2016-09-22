package servlettemplate;

//Imports
import java.io.PrintWriter;
import java.util.Enumeration;
import server.serverapi;

public class ServletCheckCourses extends ServletBase {

    public void doGet(HttpRequest req, HttpResponse res) {// Set response header content
        String[] p;

        //gets info from server
        Enumeration<String> parameterNames = req.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (paramName.equals("course")) {
                p = req.getParameterValues(paramName);
            }
        }
        /*
         Exam[] e;
         for (int i = 0; i > examTable.length; i++) {
         if (p[0].equals(examTable.course)) {
         e[i]=examTable.exam;
         }
         }
         */
        // Actual html stuff goes here
        StringBuilder contents = new StringBuilder();
        contents.append(" <!DOCTYPE html>");
        contents.append("<html>");
        contents.append("<head>");
        contents.append("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
        contents.append("<title> View Timetable Page </title>");
        contents.append("</head>");
        contents.append("<body>");
        contents.append("<button type=\"submit\" formaction=\"ServletLogin\">Login</button>");
        contents.append("<br><br>");
        contents.append("<table border=\"1\" style=\"width:100%\">");
        contents.append("<caption>Please select course at the bottom</caption>");
        contents.append("<tr>");
        contents.append("<td>1</td>");
        //contents.append("<td>" + e[0].room + "/n" + e[0].startDateTime + "/n" + e[0].endDateTime + "</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("</tr>");
        contents.append("<tr>");
        contents.append("<td>2</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("</tr>");
        contents.append("<tr>");
        contents.append("<td>3</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("</tr>");
        contents.append("<tr>");
        contents.append("<td>4</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("</tr>");
        contents.append("<tr>");
        contents.append("<td>5</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("</tr>");
        contents.append("<tr>");
        contents.append("<td>6</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("</tr>");
        contents.append("<tr>");
        contents.append("<td>7</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("</tr>");
        contents.append("<tr>");
        contents.append("<td>8</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("</tr>");
        contents.append("<tr>");
        contents.append("<td>9</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("</tr>");
        contents.append("<tr>");
        contents.append("<td>10</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("<td>-</td>");
        contents.append("</tr>");
        contents.append("</table>");
        contents.append("<br><br>");
        contents.append("<p>Please Select a course to view timetable.</p>");
        contents.append("<form action=\"ServletCheckCourse\">");
        contents.append("<select name=\"course\">");
        contents.append("<option value=\"class1\">Class 1</option>");
        contents.append("<option value=\"class2\">Class 2</option>");
        contents.append("<option value=\"class3\">Class 3</option>");
        contents.append("<option value=\"class4\">Class 4</option>");
        contents.append("</select>");
        contents.append("<br><br>");
        contents.append("<input type=\"submit\">");
        contents.append("</form>");
        contents.append("</body>");
        contents.append("</html>");

        res.append(contents);
    }
}
