package server.dbapi;


import server.exceptions.DatabaseException;
import web.Servlet;
import web.ServletTable;

import java.util.HashMap;

/**
 * Created by ivan on 02/12/15.
 */
public abstract class DbServletTableAdapter {

    // this adds a url-servlet pair into the database
    // returns an updated servlet table
    public static ServletTable addUrlServlet(String _url, Servlet _servlet) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // this removes a url-servlet pair
    // returns an updated ServletTable
    public static ServletTable delUrlServlet(String _url, Servlet _servlet) throws DatabaseException{
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // this deletes all url-servlet pairs from database
    // returns a number of rows deleted
    public static int deleteServletTable() throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // returns a HashMap: url and Servlet
    public static HashMap<String, Servlet > getServletTable() throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }
}
