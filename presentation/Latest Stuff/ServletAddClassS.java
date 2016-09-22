package servlettemplate;

//Imports
import java.io.PrintWriter;

public class ServletAddClassS extends ServletBase {

    public void doGet(HttpRequest req, HttpResponse res) {

        StringBuilder contents = new StringBuilder();
        contents.append("<!DOCTYPE html>");
        contents.append("<html>");
        contents.append("<head>");
        contents.append("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
        contents.append("<title> SeriousEditPage - Add Class</title>");
        contents.append("</head>");
        contents.append("<body>");
        contents.append("<button type=\"submit\" formaction=\"ServletAddUserS\">Add Class</button>");
        contents.append("<button type=\"submit\" formaction=\"ServletRemoveUserS\">Remove Class</button>");
        contents.append("<button type=\"submit\" formaction=\"ServletAddClassS\">Add Class</button>");
        contents.append("<button type=\"submit\" formaction=\"ServletRemoveClassS\">Remove Class</button>");
        contents.append("<button type=\"submit\" formaction=\"ServletLogout\">Logout</button>");
        contents.append("<br><br>");
        contents.append("<table border=\"1\" style=\"width:100%\">");
        contents.append("<tr>");
        contents.append("<th>Time Slot</th>");
        contents.append("<th>Monday</th>");
        contents.append("<th>Tuesday</th>");
        contents.append("<th>Wedesday</th>");
        contents.append("<th>Thursday</th>");
        contents.append("<th>Friday</th>");
        contents.append("<th>Saturday</th>");
        contents.append("<th>Sunday</th>");
        contents.append("</tr>");
        contents.append("<tr>");
        contents.append("<td>1</td>");
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
        contents.append("<p>Add a Class:</p>");
        contents.append("<form action=\"AddClassS\" method=\"POST\">");
        contents.append("<select name=\"Time\">");
        contents.append("<option> Time </option>");
        contents.append("<option value=\"time1\">1</option>");
        contents.append("<option value=\"time2\">2</option>");
        contents.append("<option value=\"time3\">3</option>");
        contents.append("<option value=\"time4\">4</option>");
        contents.append("<option value=\"time5\">5</option>");
        contents.append("<option value=\"time6\">6</option>");
        contents.append("<option value=\"time7\">7</option>");
        contents.append("<option value=\"time8\">8</option>");
        contents.append("<option value=\"time9\">9</option>");
        contents.append("<option value=\"time10\">10</option>");
        contents.append("</select>");
        contents.append("<select name=\"Day\">");
        contents.append("<option> Day </option>");
        contents.append("<option value=\"monday\">Monday</option>");
        contents.append("<option value=\"tuesday\">Tuesday</option>");
        contents.append("<option value=\"wedesday\">Wedesday</option>");
        contents.append("<option value=\"thursday\">Thursday</option>");
        contents.append("<option value=\"friday\">Friday</option>");
        contents.append("<option value=\"saturday\">Saturday</option>");
        contents.append("<option value=\"sunday\">Sunday</option>");
        contents.append("</select>");
        contents.append("<input type=\"text\" name=\"classCode\" value=\"Course Code\">");
        contents.append("<br><br>");
        contents.append("<input type=\"submit\">");
        contents.append("</form>");
        contents.append("</body>");
        contents.append("</html>");
        res.append(contents);
    }
}
