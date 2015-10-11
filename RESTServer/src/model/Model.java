package model;

import java.util.ArrayList;
import java.util.List;

public class Model {

	private List<Movie> movies = new ArrayList<>();
	private List<User> users = new ArrayList<>();

	public Model() {
		movies.add(new Movie(1, "2", "Maze runner", "5-10-2015", 120, "Michael Bay", "description"));
		users.add(new User("Jan", "van", "Maat", "aids", "dema"));
		users.add(new User("Klaas", "Grote", "herpes", "dema"));
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
}
