package server.serverapi;

import java.util.HashMap;

/**
 * Created by jordan nov 16
 * 
 * This class does not used (Ivan, Dec 7)
 * 
 */
public final class Location {
	private int locationId;
	private String locationName;
	private HashMap <Integer,Room> rooms;
	
	public Location(int _locationid, String _locationname){
		rooms = new HashMap <>();
		this.locationId = _locationid;
		this.locationName = _locationname;
	}

    public Location() {
        throw new UnsupportedOperationException("Use constructor with parameters"); //To change body of generated methods, choose Tools | Templates.
    }
	
	public int getlocationId(){
		return locationId;
	}
	public void setLocationId(int _locationid){
		this.locationId=_locationid;
	}

        public String getLocationName() {
            return locationName;
        }

        public void setLocationName(String locationName) {
            this.locationName = locationName;
        }
        
        
	public void addRoom(Room r){
		rooms.put(r.getRoomId(), r);
	}
}
