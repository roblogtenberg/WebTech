package model;

import java.util.ArrayList;
import java.util.List;

public class Model {

	private List<Movie> movies = new ArrayList<>();
	private List<User> users = new ArrayList<>();
	
	public Model() {
		movies.add(new Movie(1, "2", "Maze runner", "5-10-2015", 120, "Michael Bay", "description"));
	}
	
	public List<Movie> getMovies() {
		return movies;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public Movie getMovieById(String imdb_id) {
		for(Movie movie : movies) {
			if(movie.getIMBDCode().equals(imdb_id)) {
				return movie;
			}
		}
		return null;
	}

	public User getUserByName(String name) {
		for(User user : users) {
			if(user.getNickname().equals(name)){
				return user;
			}
		}
		return null;
	}
}
