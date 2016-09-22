package server.dbapi;

import server.exceptions.DatabaseException;
import server.serverapi.Room;

import java.util.HashMap;

/**
 * Created by ivan on 01/12/15.
 */

// this class should be implemented by DBProgram class
public abstract class DbRoomAdapter {

    public abstract Room createRoom(String _name, int _capacity, String _type) throws DatabaseException;

    // returns an updated Room
    public static Room setRoom(int _id, String _name) throws DatabaseException{
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }
    
    public static Room setRoom(int _id, String _name, String _type, int _capacity) throws DatabaseException{
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // returns a number of rows deleted
    public static int deleteRoom(int _id) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    public static Room getRoom(int _id) throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    // returns a HashMap <id_Room, Room object itself>
    public static HashMap<Integer, Room> getRooms() throws DatabaseException {
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

}
