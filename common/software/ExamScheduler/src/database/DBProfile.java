/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import server.SecurityProfile;
import server.dbapi.DbSecurityProfileAdapter;
import server.exceptions.DatabaseException;


/**
 *
 * @author Mohini
 */
public class DBProfile extends DbSecurityProfileAdapter{

    PreparedStatement pstmt = null;
    private static ResultSet rs = null;
    
    //tested by mohini Dec 6
    @Override
    public SecurityProfile createProfile(int _profileId, String _name) throws DatabaseException {
        SecurityProfile r = null;
        String sql = "INSERT INTO profiles (profile_id, name) "
                + "VALUES(" + _profileId + ", '" + _name + "')";
        try {
            DBConnection.getStatement().executeUpdate(sql);
            r = new SecurityProfile(_profileId, _name);
        } catch (SQLException ex) {
            throw new DatabaseException(ex.toString());
        }

        return r;    
    }
    
    
    // returns an updated Profile
    //tested by mohini Dec 6
    public static SecurityProfile setProfile(int _id, String _name) throws DatabaseException{
        SecurityProfile r = null;
        String sql = "UPDATE profiles SET name = '" + _name + "' WHERE profile_id = " + _id;
        try {
            DBConnection.getStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return r;
       
    }
    
    // returns a number of rows deleted
    //tested by mohini Dec 6
    public static int deleteProfile(int _id) throws DatabaseException {
        int rowsDeleted = 0;
        String sql = "DELETE FROM profiles WHERE profile_id = " + _id;
        try {
            rowsDeleted = DBConnection.getStatement().executeUpdate(sql);
            if (rowsDeleted == 0) {
                throw new DatabaseException("Nothing has been deleted: " + sql);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return rowsDeleted;
    }

      //tested by mohini Dec 6
    public static SecurityProfile getProfile(int _id) throws DatabaseException {
      SecurityProfile r = null;
        String sql = "SELECT * FROM profiles WHERE profile_id = " + _id;
        try {
            rs = DBConnection.getStatement().executeQuery(sql);

            if (rs != null) {
                rs.next();
                
                r = new SecurityProfile(rs.getInt("profile_id"), rs.getString("name"));
            } else {
                throw new DatabaseException("statement is null: " + sql);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return r;
    }

    // returns a HashMap <id_profile, Profile object itself>
      //tested by mohini Dec 6
    public static HashMap<Integer, SecurityProfile> getProfiles() throws DatabaseException {
        HashMap<Integer, SecurityProfile> result = new HashMap<>();
        int id = 0;
        SecurityProfile r = null;
        String sql = "SELECT * FROM profiles";
        try {
            rs = DBConnection.getStatement().executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    id = rs.getInt("profile_id");
                    r = new SecurityProfile(rs.getInt("profile_id"), rs.getString("name"));
                    result.put(id, r);
                }
            } else {
                throw new DatabaseException("statement is null: " + sql);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }

        return result;
    }
    
}