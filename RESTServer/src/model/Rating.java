package model;

public class Rating {

	private int rating;
	private Movie movie;
	private User user;

	public Rating(int rating) {
		this.rating = rating;
	}

	public void setRating(int rating) {
		if (rating >= 5 && rating <= 0.5) {
			this.rating = rating;
		} else {
			System.out.println("Rating is onjuist.");
		}
	}
}
