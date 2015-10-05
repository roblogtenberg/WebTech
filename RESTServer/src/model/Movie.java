package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Movie {

	private int id;
	private String IMBDCode;
	private String title;
	private String date;
	private int length;
	private String director;
	private String description;
	
	public Movie() {
		
	}
	
	public Movie(int id, String IMBDCode, String title, String date, int length, String director, String description) {
		this.id = id;
		this.IMBDCode = IMBDCode;
		this.title = title;
		this.date = date;
		this.length = length;
		this.director = director;
		this.description = description;
	}
	
	@XmlTransient
	public int getId() {
		return id;
	}
	
	@XmlAttribute
	public String getIMBDCode() {
		return IMBDCode;
	}
	
	@XmlAttribute
	public String getTitle() {
		return title;
	}
	
	@XmlAttribute
	public String getDate() {
		return date;
	}
	
	@XmlAttribute
	public int getLength() {
		return length;
	}
	
	@XmlAttribute
	public String getDirector() {
		return director;
	}
	
	@XmlAttribute
	public String getDescription() {
		return description;
	}
}
