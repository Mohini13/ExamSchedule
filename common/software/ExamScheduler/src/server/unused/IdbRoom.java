package server.unused;


import java.util.HashMap;
import server.exceptions.DatabaseException;
import server.serverapi.Room;

/**
 * Created by ivan on 12/11/15.
 */
public interface IdbRoom {

    Room createRoom(int _id, String _name, int _capacity) throws DatabaseException;

    Room setRoom(int _id, String _name) throws DatabaseException;

    boolean deleteRoom(int _id) throws DatabaseException;

    static Room getRoom(int _id) throws DatabaseException {
        //return new Room();
        throw new IllegalStateException("implement this first!");
    }

    // <id_Room, Room object itself>
    static HashMap<Integer, Room> getRooms() throws DatabaseException {
        return new HashMap<>();
    }
    
}
