package nl.ein2vc.webtech.model;

import java.util.ArrayList;

public class Renter extends User {

	private ArrayList<Room> rooms = new ArrayList<>();
	
	public Renter(String name, String password) {
		super(name, password);
	}

	public void addRoom(int squareMeters, double price, String place) {
		rooms.add(new Room(squareMeters, price, place));
	}
}
