package server.dbapi;

import server.PermissionTable;
import server.SecurityProfile;
import server.exceptions.DatabaseException;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ivan on 02/12/15.
 */
public abstract class DbPermissionTableAdapter {

    // creates a new permission table
    public abstract PermissionTable createPermissionTable(HashMap<String, List<SecurityProfile>> _permissionTable);

    // this adds url-profile pair into the database
    // returns an updated permission table
    public static PermissionTable addUrlProfile(String _url, SecurityProfile _prof) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // this removes SecurityProfile from the given url
    // returns an updated PermissionTable
    public static PermissionTable delUrlProfile(String _url, SecurityProfile _prof) throws DatabaseException{
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // this deletes all url-profile pairs from database
    // returns a number of rows deleted
    public static int deletePermissionTable() throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // returns a HashMap: String url and list of SecurityProfile
    public static HashMap<String, List<SecurityProfile> > getPermissionTable() throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

}
