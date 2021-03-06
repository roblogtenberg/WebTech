package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
public class Rating {

	private double rating;
	private Movie movie;

	public Rating() {

	}

	public Rating(double rating, Movie movie) {
		this.rating = rating;
		this.movie = movie;
	}

	@XmlAttribute
	public double getRating() {
		return rating;
	}

	@XmlTransient
	@JsonIgnore
	public Movie getSingleMovie() {
		return movie;
	}

	@XmlAttribute
	public Movie getMovie() {
		return movie;
	}

}
