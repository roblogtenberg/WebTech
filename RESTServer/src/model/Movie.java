package model;

public class Movie {

	private int id;
	private String IMBDCode;
	private String title;
	private String date;
	private int length;
	private String director;
	private String description;
	
	public Movie(int id, String IMBDCode, String title, String date, int length, String director, String description) {
		this.id = id;
		this.IMBDCode = IMBDCode;
		this.title = title;
		this.date = date;
		this.length = length;
		this.director = director;
		this.description = description;
	}
	
	public int getId() {
		return id;
	}
	
	public String getIMBDCode() {
		return IMBDCode;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDate() {
		return date;
	}
	
	public int getLength() {
		return length;
	}
	
	public String getDirector() {
		return director;
	}
	
	public String getDescription() {
		return description;
	}
}
