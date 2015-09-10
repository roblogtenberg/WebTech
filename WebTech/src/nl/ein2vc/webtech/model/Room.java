package nl.ein2vc.webtech.model;

public class Room {

	private int squareMeters;
	private double price;
	private String place;
	
	public Room(int squareMeters, double price, String place) {
		this.squareMeters = squareMeters;
		this.price = price;
		this.place = place;
	}
	
	public int getSquareMeters() {
		return squareMeters;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getPlace() {
		return place;
	}

	@Override
	public String toString() {
		return "Room [squareMeters=" + squareMeters + ", price=" + price + ", place=" + place + "]";
	}
}
