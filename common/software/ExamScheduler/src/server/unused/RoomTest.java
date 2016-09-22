package server.unused;

import server.dbapi.DbRoomAdapter;
import server.exceptions.DatabaseException;
import server.serverapi.Room;

import java.util.HashMap;

/**
 * Created by ivan on 01/12/15.
 */
public class RoomTest extends DbRoomAdapter {


    @Override
    public Room createRoom(String _name, int _capacity, String _type) throws DatabaseException {
        return null;
    }

    public static Room setRoom(int _id, String _name) throws DatabaseException {
        return null;
    }

    public static int deleteRoom(int _id) throws DatabaseException {
        return 0;
    }

    /*
    public static Room getRoom(int _id) throws DatabaseException {
        //throw new IllegalStateException(":)");
        throw new UnsupportedOperationException(Idb.impelemt_method_msg);
    }

    public static HashMap<Integer, Room> getRooms() throws DatabaseException
    {
        throw new IllegalStateException("map :)");
    }*/


}
