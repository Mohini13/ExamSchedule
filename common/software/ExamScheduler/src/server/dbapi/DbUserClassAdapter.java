package server.dbapi;

import server.SecurityProfile;
import server.UserClass;
import server.exceptions.DatabaseException;

import java.util.HashMap;

/**
 * Created by ivan on 02/12/15.
 * 
 * UserClass is equal to Faculty in the DB
 * 
 */
public abstract class DbUserClassAdapter {

    public abstract UserClass createUser(String _userName, String _passwd, String _firstName, String _lastName) throws DatabaseException;

    // if null parameter is passed data should not be updated in the db
    // returns an updated user (UserClass) which is a Professor (AdminUser or SuperUser)
    public static UserClass setUserPassword(int _userId, String _passwd) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }
    
    public static UserClass setUser(int _userId, String _firstName, String _lastName) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // this adds a new SecurityProfile to the user
    // returns a updated HashMap of <int id and SecurityProfile>
    public static HashMap<Integer, SecurityProfile> addSecurityProfile(int _profileId, SecurityProfile _prof) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // this removes a SecurityProfile from the user
    // returns a updated HashMap of <int id and SecurityProfile>
    public static HashMap<Integer, SecurityProfile> delSecurityProfile(int _profileId, SecurityProfile _prof) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // returns a number of rows deleted
    public static int deleteUser(int _userId) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    public static UserClass getUser(int _userId) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // returns a HashMap of all user's profiles <profile_id, SecurityProfile object itself>
    public static HashMap<Integer, SecurityProfile> getUserProfiles(int _userId) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }
    
    // returns a HashMap <id_user, UserClass object itself>
    public static HashMap<Integer, UserClass> getUsers() throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }
}
