package nl.ein2vc.webtech.model;

import java.util.ArrayList;
import java.util.List;

public class Leaser extends User{

	private List<Room> rooms = new ArrayList<>();
	
	public Leaser(String name, String password) {
		super(name, password);
	}
	
	public void addRoom(int squareMeters, double price, String place) {
		rooms.add(new Room(squareMeters, price, place));
	}

	public List<Room> getRooms() {
		return rooms;
	}
}
