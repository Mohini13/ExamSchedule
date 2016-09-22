package server.unused;

import server.SecurityProfile;
import server.exceptions.DatabaseException;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ivan on 25/11/15.
 */
public interface IdbPermissionTable {

    static HashMap<String, List<SecurityProfile> > getPermissionTable() throws DatabaseException {
        return new HashMap<>();
    }

}
