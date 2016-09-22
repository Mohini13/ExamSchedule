package humber.cpan205na.controller;

import com.sun.deploy.net.HttpResponse;


/**
 * Created by ivan on 16/11/15.
 */
public class ServletBase implements IServlet {


    @Override
    public void precessRequest(HttpRequest req, HttpResponse res) {
        if(req.getType().equalsIgnoreCase("post")) {
            doPost(req, res);
        } else if (req.getType().equalsIgnoreCase("get")) { // getMethod = getType
            doGet(req, res);
        } //else throw new Exception("Invalid request type: post or get only");
    }

    @Override
    public void doGet(HttpRequest req, HttpResponse res) {

    }

    @Override
    public void doPost(HttpRequest req, HttpResponse res) {

    }

    // something
    /*
        Servlet sv = ServletTable.servletsMap.get(req.getUrl() );
        if(sv == null) sv = Servlet("404");
        try {
            if(req.getMethod().equalsIgnoreCase("post")) {
                doPost();
            } else if (req.getMethod().equalsIgnoreCase("get")) {
                doGet();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        */


    @Override
    public void registerServlet(String _name, ServletBase _servlet) {

    }
}
