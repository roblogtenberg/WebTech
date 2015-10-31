package model;

import java.util.ArrayList;
import java.util.List;

public class Model {

	private List<Movie> movies = new ArrayList<>();
	private List<User> users = new ArrayList<>();
	private List<Rating> ratings = new ArrayList<>();

	public Model() {
		Movie maze = new Movie(1, "tt1790864", "Maze Runner", "25-9-2014", 113, "Wes Ball", "Thomas is deposited in a community of boys after his memory is erased, soon learning they're all trapped in a maze that will require him to join forces with fellow 'runners' for a shot at escape.");
		Movie divergent = new Movie(2, "tt1840309", "Divergent", "3-4-2014", 139, "Neil Burger", "In a world divided by factions based on virtues, Tris learns she's Divergent and won't fit in. When she discovers a plot to destroy Divergents, Tris and the mysterious Four must find out what makes Divergents dangerous before it's too late.");
		Movie dope = new Movie(3, "tt3850214", "Dope", "6-8-2015", 103, "Rick Famuyiwa", "Life changes for Malcolm, a geek who's surviving life in a tough neighborhood, after a chance invitation to an underground party leads him and his friends into a Los Angeles adventure.");
		Movie nfs = new Movie(4, "tt2369135", "Need for Speed", "13-3-2015", 132, "Scott Waugh", "Fresh from prison, a street racer who was framed by a wealthy business associate joins a cross country race with revenge in mind. His ex-partner, learning of the plan, places a massive bounty on his head as the race begins..");
		Movie ted2 = new Movie(5, "tt2637276", "Ted 2", "13-8-2015", 115, "Seth MacFarlane", "Newlywed couple Ted and Tami-Lynn want to have a baby, but in order to qualify to be a parent, Ted will have to prove he's a person in a court of law.");
		Movie madMax = new Movie(6, "tt1392190", "Mad Max: Fury Road", "14-5-2015", 120, "George Miller", "A woman rebels against a tyrannical ruler in post apocalyptic Australia in search for her homeland with the help of a group of female prisoners, a psychotic worshiper, and a drifter named Max.");
		
		movies.add(maze);
		movies.add(divergent);
		movies.add(dope);
		movies.add(nfs);
		movies.add(ted2);
		movies.add(madMax);
		users.add(new User("Jan", "van", "Maat", "janmaat32", "ewrt1"));
		users.add(new User("Klaas", "Grote", "klagrot", "appel44"));
		ratings.add(new Rating(4, maze));
		ratings.add(new Rating(2, divergent));
		ratings.add(new Rating(5, dope));
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
