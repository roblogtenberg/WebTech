package nl.ein2vc.webtech.model;

import java.util.List;
import java.util.ArrayList;

public class Model {

	private List<User> users = new ArrayList<>();
	
	public void addUser(User user) {
		users.add(user);
	}
	
	public List<Room> getRooms() {
		for(User user : users) {
			if(user instanceof Leaser) {
				
			}
		}
	}
}
