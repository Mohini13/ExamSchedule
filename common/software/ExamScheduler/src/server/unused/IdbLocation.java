package server.unused;

import server.serverapi.Location;

import java.util.HashMap;
import server.exceptions.DatabaseException;

/**
 * Created by ivan on 12/11/15.
 */
public interface IdbLocation {

    Location createLocation(String _name) throws DatabaseException;

    Location setLocation(int _id, String _name) throws DatabaseException;

    boolean deleteLocation(int _id) throws DatabaseException;

    static Location getLocation(int _id) throws DatabaseException {
        return new Location();
    }

    // <id_location, Location object itself>
    static HashMap<Integer, Location> getLocations() throws DatabaseException
    {
        return new HashMap<>();
    }
    
}
