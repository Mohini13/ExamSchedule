/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;
import server.dbapi.DbRoomAdapter;
import server.exceptions.DatabaseException;
import server.serverapi.Room;

/**
 *
 * @author hani
 * 
 * Tested by hani dec 5
 * 
 * Edited by kamalpreet dec 7
 */

//public class DBRoom implements IdbRoom
public class DBRoom extends DbRoomAdapter {

    PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    @Override
    
    // Edited by kamalpreet
    public Room createRoom(String _name, int _capacity, String _type) throws DatabaseException {

        Room r = null;
        int room_id;
                
        String sql = "{call insert_room(:v_room_id,?,?,?)}";
        // insert into room(room_num, capacity,type)
        try{
            CallableStatement cs = DBConnection.con.prepareCall(sql);
            cs.setString(2, _name);
            cs.setInt(3, _capacity);
            cs.setString(4, _type);
            cs.registerOutParameter(1, OracleTypes.INTEGER);
            cs.execute();
            
            room_id = cs.getInt(1);
            r = new Room(room_id, _name, _capacity, _type);
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return r;
    }

    public static Room setRoom(int _id, String _name) throws DatabaseException {
        Room r = null;
        String sql = "UPDATE room SET room_num = '" + _name + "' WHERE loc_id = " + _id;
        try {
            DBConnection.getStatement().executeUpdate(sql);
            r = getRoom(_id);
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return r;
    }
    
    public static Room setRoom(int _id, String _name, String _type, int _capacity) throws DatabaseException{
        Room r = null;
        String sql = "UPDATE room SET "
                + "room_num = '" + _name + "', "
                + "type = '" + _type + "', "
                + "capacity = " + _capacity
                + " WHERE loc_id = " + _id;
        try {
            DBConnection.getStatement().executeUpdate(sql);
            r = getRoom(_id);
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return r;
    }

    public static int deleteRoom(int _id) throws DatabaseException {
        int rowsDeleted = 0;
        String sql = "DELETE FROM ROOM WHERE loc_id = " + _id;
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

    public static Room getRoom(int _id) throws DatabaseException {
        Room r = null;
        String sql = "SELECT * FROM ROOM WHERE loc_id = " + _id;
        try {
            rs = DBConnection.getStatement().executeQuery(sql);

            if (rs != null) {
                rs.next();
                
                // edited by kamalpreet
                r = new Room(rs.getInt("loc_id"), rs.getString("room_num"), rs.getInt("capacity"), rs.getString("type"));
              // r = new Room(0, rs.getInt("room_num"), rs.getString("type"), rs.getInt("capacity"));
            } else {
                throw new DatabaseException("statement is null: " + sql);
            }
            //DBConnection.getStatement().close(); // ?
        } catch (SQLException ex) {
            throw new DatabaseException(ex);
        }
        return r;
    }

    // <id_Room, Room object itself>
    public static HashMap<Integer, Room> getRooms() throws DatabaseException {
        HashMap<Integer, Room> result = new HashMap<>();
        int id = 0;
        Room r = null;
        String sql = "SELECT * FROM room";
        try {
            rs = DBConnection.getStatement().executeQuery(sql);

            if (rs != null) {
                while (rs.next()) {
                    id = rs.getInt("loc_id");
                    
               // Edited by kamalpreet     
                r = new Room(rs.getInt("loc_id"), rs.getString("room_num"), rs.getInt("capacity"), rs.getString("type"));
                 //   r = new Room(0, rs.getString("room_num"), rs.getString("type"), rs.getInt("capacity"));
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
