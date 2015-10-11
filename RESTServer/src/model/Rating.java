package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Rating {

	private int rating;
	private Movie movie;

	public Rating() {
		
	}
	
	public Rating(int rating, Movie movie) {
		this.rating = rating;
		this.movie = movie;
	}

	@XmlAttribute
	public int getRating() {
		return rating;
	}
	
	@XmlAttribute
	public Movie getMovie() {
		return movie;
	}
}
