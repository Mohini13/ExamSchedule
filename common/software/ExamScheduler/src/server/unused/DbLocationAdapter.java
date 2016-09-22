package server.unused;

import server.dbapi.Idb;
import server.exceptions.DatabaseException;
import server.serverapi.Location;

import java.util.HashMap;

/**
 * Created by ivan on 02/12/15.
 */
public abstract class DbLocationAdapter {

    public abstract Location createLocation(String _name) throws DatabaseException;

    // returns an updated Location
    public static Location setLocation(int _id, String _name) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // returns a number of rows deleted
    public static int deleteLocation(int _id) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    public static Location getLocation(int _id) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // returns a HashMap <id_location, Location object itself>
    public static HashMap<Integer, Location> getLocations() throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }
}
