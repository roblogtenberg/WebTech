package nl.ein2vc.webtech.model;

import java.util.ArrayList;
import java.util.List;

public class Model {

	private List<User> users = new ArrayList<>();

	public void addUser(User user) {
		users.add(user);
	}

	public List<Room> getRooms() {
		List<Room> rooms = new ArrayList<>();

		for (User user : users) {
			if (user instanceof Leaser) {
				rooms.addAll(((Leaser) user).getRooms());
			}
		}
		return rooms;
	}

	public List<User> getUsers() {
		return users;
	}
	
	public User getUser(String name) {
		for (User user : users) {
			if (name.equals(user.getName())) {
				return user;
			}
		}
		return null;
	}

	public boolean isUser(String name) {
		for (User user : users) {
			if (name.equals(user.getName())) {
				return true;
			}
		}
		return false;
	}
}
