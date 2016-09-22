package servlettemplate;

//Imports
import java.util.Enumeration;
import server.serverapi.exam;

public class AddClassC extends ServletBase  {

    public void doPost(HttpRequest req, HttpResponse res) {
        String[] time;
        String[] day;
        String[] course;

        //gets info from request
        Enumeration<String> parameterNames = req.getParameterNames();

        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (paramName.equalsIgnoreCase("time")) {
                time = req.getParameterValues(paramName);
            }
            if (paramName.equalsIgnoreCase("day")) {
                day = req.getParameterValues(paramName);
            }
            if (paramName.equalsIgnoreCase("course")) {
                course = req.getParameterValues(paramName);
            }
        }

        //append it to database
        //examTable.add(time,day,course);
    }
}
