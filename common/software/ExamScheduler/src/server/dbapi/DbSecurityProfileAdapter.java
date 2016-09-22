/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dbapi;

import java.util.HashMap;
import server.SecurityProfile;
import server.exceptions.DatabaseException;
import server.serverapi.Room;

/**
 *
 * @author ivan
 * 
 * SecurityProfile is equal to PROFILES in database
 * 
 */
public abstract class DbSecurityProfileAdapter {
    
    public abstract SecurityProfile createProfile(int _profileId, String _name) throws DatabaseException;

    // returns an updated Profile
    public static SecurityProfile setProfile(int _id, String _name) throws DatabaseException{
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }
    
    // returns a number of rows deleted
    public static int deleteProfile(int _id) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    public static SecurityProfile getProfile(int _id) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // returns a HashMap <id_profile, Profile object itself>
    public static HashMap<Integer, SecurityProfile> getProfiles() throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }
}
