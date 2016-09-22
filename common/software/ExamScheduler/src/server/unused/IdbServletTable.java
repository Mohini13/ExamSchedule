package server.unused;

import server.exceptions.DatabaseException;
import web.Servlet;

import java.util.HashMap;

/**
 * Created by ivan on 25/11/15.
 */
public interface IdbServletTable {

    static HashMap<String, Servlet> getServletTable() throws DatabaseException {
        return new HashMap<>();
    }

}
