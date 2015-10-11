package model;

import java.util.ArrayList;
import java.util.List;

public class Model {

	private List<Movie> movies = new ArrayList<>();
	private List<User> users = new ArrayList<>();
	private List<Rating> test = new ArrayList<>();
	
	public Model() {
		movies.add(new Movie(1, "2", "Maze runner", "5-10-2015", 120, "Michael Bay", "description"));
		users.add(new User("Jan", "van", "Maat", "aids", "dema"));
		users.add(new User("Klaas", "Grote", "herpes", "dema"));
		test.add(new Rating(2,new Movie(1, "2", "Maze runner", "5-10-2015", 120, "Michael Bay", "description")));
	}

	public void addUser(User user) {
		users.add(user);
		System.out.println(user.getName());
		System.out.println("User added");
	}

	public List<User> getUsers() {
		return users;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public Movie getMovieById(String imdb_id) {
		for (Movie movie : movies) {
			if (movie.getIMBDCode().equals(imdb_id)) {
				return movie;
			}
		}
		return null;
	}

	public Movie getMovieByTitle(String title) {
		for (Movie movie : movies) {
			if (movie.getTitle().equals(title)) {
				return movie;
			}
		}
		return null;
	}

	public User getUserByNickname(String nickname) {
		for (User user : users) {
			if (user.getNickname().equals(nickname)) {
				return user;
			}
		}
		return null;
	}

	public List<Rating> getRatings() {
//		List<Rating> ratings = new ArrayList<>();
//		for (User user : users) {
//			ratings.addAll(user.getRatings());
//		}
//		return ratings;
		return test;
	}

	public boolean checkToken(String token) {
		for (User user : users) {
			if (user.getToken() != null) {
				if (user.getToken().equals(token)) {
					return true;
				}
			}
		}
		return false;
	}

	public User getUserFromToken(String token) {
		for (User user : users) {
			if (user.getToken() != null) {
				if (user.getToken().equals(token)) {
					return user;
				}
			}
		}
		return null;
	}

}
