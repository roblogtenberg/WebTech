package model;

import java.util.ArrayList;
import java.util.List;

public class Model {

	private List<Movie> movies = new ArrayList<>();
	private List<User> users = new ArrayList<>();
	private List<Rating> ratings = new ArrayList<>();

	public Model() {
		Movie maze = new Movie(1, "tt1790864", "Maze Runner", "25-9-2014", 113, "Wes Ball", "Thomas is deposited in a community of boys after his memory is erased, soon learning they're all trapped in a maze that will require him to join forces with fellow 'runners' for a shot at escape.");
		Movie klaas = new Movie(2, "tt1840309", "Divergent", "3-4-2014", 139, "Neil Burger", "In a world divided by factions based on virtues, Tris learns she's Divergent and won't fit in. When she discovers a plot to destroy Divergents, Tris and the mysterious Four must find out what makes Divergents dangerous before it's too late.");
		movies.add(maze);
		movies.add(klaas);
		users.add(new User("Jan", "van", "Maat", "janmaat32", "ewrt1"));
		users.add(new User("Klaas", "Grote", "klagrot", "appel44"));
		ratings.add(new Rating(4, maze));
		ratings.add(new Rating(2, klaas));
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

	public List<Rating> getRatings() {
		return ratings;
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
