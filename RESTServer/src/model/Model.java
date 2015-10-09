package model;

import java.util.ArrayList;
import java.util.List;

public class Model {

	private List<Movie> movies = new ArrayList<>();
	private List<User> users = new ArrayList<>();

	public Model() {
		movies.add(new Movie(1, "2", "Maze runner", "5-10-2015", 120, "Michael Bay", "description"));
	}

	public void addUser(User user) {
		users.add(user);
		System.out.println("User added");
	}

	public List<User> getUsers() {
		return users;
	}

	public List<Movie> getMovies() {
		return movies;
	}
}
