package humber.cpan205na.controller.dbapi;

import humber.cpan205na.controller.serverapi.Room;

import java.util.HashMap;

/**
 * Created by ivan on 12/11/15.
 */
public interface IdbRoom {

    Room createRoom(int _id, String _name); //throws DBException;
    Room setRoom(int _id, String _name);
    boolean deleteRoom(int _id);

    static Room getRoom(int _id) {
        return new Room();
    }

    static HashMap<Integer, Room> getRooms() { // <id_Room, Room object itself>
        return new HashMap<Integer, Room>();
    }
    
}
