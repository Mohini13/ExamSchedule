/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dbapi;

import java.util.HashMap;
import server.exceptions.DatabaseException;

/**
 *
 * @author ivan
 * 
 * This class equals to the URLS table in the database
 * 
 */


public abstract class DbUrlAdapter {
    
    public abstract String createUrl(String _url) throws DatabaseException;

    // returns an updated url (String)
    public static String setUrl(int _urlId, String _url) throws DatabaseException{
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }
    
    // returns a number of rows deleted
    public static int deleteUrl(int _urlId) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    public static String getUrl(int _urlId) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // returns a HashMap <url_id, url String itself>
    public static HashMap<Integer, String> getUrls() throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }
}
