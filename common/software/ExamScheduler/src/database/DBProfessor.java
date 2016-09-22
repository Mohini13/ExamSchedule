/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import oracle.jdbc.OracleTypes;
import server.AdminUser;
import server.SecurityProfile;
import server.UserClass;
import server.dbapi.*;
import server.exceptions.DatabaseException;

/**
 *
 * @author hani
 */
public class DBProfessor extends DbUserClassAdapter {

    PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    // _userName is equal to faculty.username in the db
    @Override //Tested by Hani Dec 7
    public UserClass createUser(String _userName, String _passwd, String _firstName, String _lastName) throws DatabaseException {

        UserClass user = null;
        int user_id = 0;
        // insert into faculty (first_name, last_name, password, username) 
        String sql = "{call insert_faculty(:v_f_id, ?,?,?,?)}";

        try {
            CallableStatement cs = DBConnection.con.prepareCall(sql);
            cs.setString(2, _firstName);
            cs.setString(3, _lastName);
            cs.setString(4, _passwd);
            cs.setString(5, _userName);

            cs.registerOutParameter(1, OracleTypes.INTEGER);
            cs.execute();

            user_id = cs.getInt(1); // 1 is the first OUT parameter
            //error
            user = new AdminUser(user_id, _userName, _passwd, _firstName, _lastName);
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return user;

    }

    //Tested by mohini Dec 5
    public static UserClass setUserPassword(int _userId, String _passwd) throws DatabaseException {
        UserClass r = null;
        String sql = "UPDATE faculty SET password = '" + _passwd + "' WHERE f_id = " + _userId;
        try {
            DBConnection.getStatement().executeUpdate(sql);
            r = getUser(_userId);
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return r;
    }

    //Created by mohini and tested by mohini 
    public static int deleteUser(int _userId) throws DatabaseException {
        int rowsDeleted = 0;
        String sql = "DELETE FROM faculty WHERE f_id = " + _userId;
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

    // select faculty from db
    // Tested by mohini DEC 5
    public static UserClass getUser(int _userId) throws DatabaseException {
        UserClass r = null;
        String sql = "SELECT * FROM faculty WHERE f_id = " + _userId;
        try {
            rs = DBConnection.getStatement().executeQuery(sql);
            if (rs != null) {
                rs.next();
                // what about SuperUser and PublicUser
                r = new AdminUser(_userId, rs.getString("first_name"), rs.getString("last_name"), rs.getString("password"), rs.getString("username"));
            } else {
                throw new DatabaseException("statement is null: " + sql);
            }
            //DBConnection.getStatement().close(); // ?
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return r;
    }

    //Tested by mohini Dec 5
    public static UserClass setUser(int _userId, String _firstName, String _lastName) throws DatabaseException {
        UserClass r = null;
        String sql = "UPDATE faculty SET "
                + "first_name = '" + _firstName + "', "
                + "last_name = '" + _lastName + "' "
                + "where f_id=" + _userId;
        try {
            DBConnection.getStatement().executeUpdate(sql);
            r = getUser(_userId);
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return r;
    }

    // returns a HashMap of all user's profiles <profile_id, SecurityProfile object itself>

    public static HashMap<Integer, SecurityProfile> getUserProfiles(int _userId) throws DatabaseException {
        int id = 0;
        SecurityProfile profile = null;
        HashMap<Integer, SecurityProfile> profiles = new HashMap<>();
        String sql = "SELECT * "
                + "FROM faculty_profiles fp "
                + "JOIN profiles p ON fp.profile_id = p.PROFILE_ID "
                + "WHERE fp.f_id = " + _userId;
        try {
            rs = DBConnection.getStatement().executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    id = rs.getInt("profile_id");
                    profile = new SecurityProfile(id, rs.getString("name"));
                    profiles.put(id, profile);
                }
            } else {
                throw new DatabaseException("statement is null: " + sql);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return profiles;
    }

    // this adds a new SecurityProfile to the user
    // returns a updated HashMap of <int id and SecurityProfile>

    public static HashMap<Integer, SecurityProfile> addSecurityProfile(int _userId, SecurityProfile _prof) throws DatabaseException {
        int profile_id = _prof.getProfileId();
        HashMap<Integer, SecurityProfile> profiles = new HashMap<>();

        // e.g. -- 4 is rob id, 0 is PUBLIC profile
        String sql = "INSERT INTO faculty_profiles "
                + "VALUES(" + _userId + ", " + profile_id + ")";
        try {
            DBConnection.getStatement().executeUpdate(sql);
            profiles.put(profile_id, _prof);
        } catch (SQLException ex) {
            throw new DatabaseException(ex.toString());
        }

        return profiles;
    }

    // this removes a SecurityProfile from the user
    // returns a updated HashMap of <int id and SecurityProfile>

    public static HashMap<Integer, SecurityProfile> delSecurityProfile(int _userId, SecurityProfile _prof) throws DatabaseException {
        int profile_id = _prof.getProfileId();
        HashMap<Integer, SecurityProfile> profiles = new HashMap<>();

        String sql = "DELETE FROM faculty_profiles WHERE F_ID =  " + _userId + " AND profile_id = " + profile_id;
        try {
            DBConnection.getStatement().executeUpdate(sql);
            profiles = getUserProfiles(_userId);
        } catch (SQLException ex) {
            throw new DatabaseException(ex.toString());
        }
        return profiles;
    }
}
