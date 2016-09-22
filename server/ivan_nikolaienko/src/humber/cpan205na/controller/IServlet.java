package humber.cpan205na.controller;

import com.sun.deploy.net.HttpResponse; // use WEB team implementation

/**
 * Created by ivan on 16/11/15.
 */
public interface IServlet {
    void precessRequest(HttpRequest req, HttpResponse res);
    void doGet(HttpRequest req, HttpResponse res);
    void doPost(HttpRequest req, HttpResponse res);
    void registerServlet(String _name, ServletBase _servlet);

    //
    // from ServletTable servlTab.name_forClass("humber.cpan205na.controller.serverapi.Course");
}
