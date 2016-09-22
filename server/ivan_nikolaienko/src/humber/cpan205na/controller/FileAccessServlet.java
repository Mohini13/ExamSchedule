package humber.cpan205na.controller;

import com.sun.deploy.net.HttpResponse;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * Created by ivan on 16/11/15.
 */
public class FileAccessServlet extends ServletBase {
    public void doGet(HttpRequest req, HttpResponse res) {
        String fname = req.getUrl();

        try{
            FileInputStream fis = new FileInputStream(fname);
            BufferedInputStream bis = new BufferedInputStream(fis);
            String line = "";//bis.getLine();
            while(line != null) {
                //res.append(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
