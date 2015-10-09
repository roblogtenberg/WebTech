package model;

public class Rating {

	private int rating;
	private Movie movie;

	public Rating(int rating, Movie movie) {
		this.rating = rating;
		this.movie = movie;
	}

	public int getRating() {
		return rating;
	}
	
	public Movie getMovie() {
		return movie;
	}
}
