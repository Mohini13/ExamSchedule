package humber.cpan205na.controller.dbapi;

import humber.cpan205na.controller.serverapi.Location;

import java.util.HashMap;

/**
 * Created by ivan on 12/11/15.
 */
public interface IdbLocation {

    Location createLocation(int _id, String _name); //throws DBException;
    Location setLocation(int _id, String _name);
    boolean deleteLocation(int _id);

    static Location getLocation(int _id) {
        return new Location();
    }

    static HashMap<Integer, Location> getLocations() { // <id_Location, Location object itself>
        return new HashMap<Integer, Location>();
    }
    
}
