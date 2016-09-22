package server.serverapi;


/**
 * Created by jordan nov 16
 */
public final class Room {
	private int roomId;
	private String roomName;
	private String roomType;
	private int capacity;
	
        public Room(int _room_id, String _roomName, String _roomType, int _capacity){
            this.roomId = _room_id;
            this.roomName = _roomName;
            this.roomType = _roomType;
            this.capacity = _capacity;
        
        }

    public Room(int room_id, String _name, int _capacity, String _type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        public String getRoomName() {
            return roomName;
        }

        public void setRoomName(String roomName) {
            this.roomName = roomName;
        }

        public String getRoomType() {
            return roomType;
        }

        public void setRoomType(String roomType) {
            this.roomType = roomType;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }
        
        
	public int getRoomId(){
		return this.roomId;
	}
}
