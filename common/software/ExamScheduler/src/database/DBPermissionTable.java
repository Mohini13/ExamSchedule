/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import server.PermissionTable;
import server.SecurityProfile;
import server.dbapi.DbPermissionTableAdapter;
import server.dbapi.Idb;
import server.exceptions.DatabaseException;

/**
 *
 * @author hani
 */
public class DBPermissionTable extends DbPermissionTableAdapter {

    PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    @Override
    public PermissionTable createPermissionTable(HashMap<String, List<SecurityProfile>> _permissionTable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // this adds url-profile pair into the database
    // returns an updated permission table
    public static PermissionTable addUrlProfile(String _url, SecurityProfile _prof) throws DatabaseException {
        int profile_id = _prof.getProfileId();

        PermissionTable permTab = null;
        HashMap<String, List<SecurityProfile>> urlPermissions = new HashMap<>();

        // -- 0 is a PUBLIC profile can only view_exam_schedule 9
        //insert into profileurl (profile_id, url_id) values (0,9);
        String sql = "INSERT INTO profileurl (profile_id, url_id) "
                + "VALUES(" + _url + ", " + profile_id + ")";
        try {
            DBConnection.getStatement().executeUpdate(sql);
            // this is not finished!!!!!
        } catch (SQLException ex) {
            throw new DatabaseException(ex.toString());
        }

        return permTab;
    }

    // this removes SecurityProfile from the given url
    // returns an updated PermissionTable
    public static PermissionTable delUrlProfile(String _url, SecurityProfile _prof) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // this deletes all url-profile pairs from database
    // returns a number of rows deleted
    public static int deletePermissionTable() throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // returns a HashMap: String url and list of SecurityProfile
    public static HashMap<String, List<SecurityProfile>> getPermissionTable() throws DatabaseException {
        HashMap<String, List<SecurityProfile>> urlPermissions = new HashMap<>();
        String url = "", prev_url = "";
        List<SecurityProfile> profiles = new ArrayList<>();
        SecurityProfile prof = null;
        int profile_id = 0;
        String profile_name = "";
        
        /* SELECT *
         FROM profileurl pu
         JOIN profiles p ON  pu.profile_id = p.profile_id
         JOIN urls u ON pu.url_id = u.url_id; */
        String sql = "SELECT url, pu.PROFILE_ID, p.NAME "
                + "FROM profileurl pu "
                + "JOIN profiles p ON  pu.profile_id = p.profile_id "
                + "JOIN urls u ON pu.url_id = u.url_id ";
        try {
            rs = DBConnection.getStatement().executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    // change query or use if here
                    url = rs.getString("url");
                    profile_id = rs.getInt("profile_id");
                    profile_name = rs.getString("name");
                    prof = new SecurityProfile(profile_id, profile_name);
                    profiles.add(prof);
                }
                
                
            } else {
                throw new DatabaseException("statement is null: " + sql);
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex.getMessage());
        }

        return urlPermissions;
    }

}
