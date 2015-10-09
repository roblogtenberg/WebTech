package resources;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import model.Model;
import model.Movie;
import model.User;

@Path("/users")
public class UserResource {

	private String surname;
	private String prefix;
	private String lastname;
	private String nickname;

	@Context
	ServletContext context;
	Model model = new Model();

	@POST
	// @Produces({ MediaType.APPLICATION_XML })
	public Object getParameter(@QueryParam("surname") String surname, @QueryParam("prefix") String prefix,
			@QueryParam("lastname") String lastname, @QueryParam("nickname") String nickname) {
		if (surname != null) {
			this.surname = surname;
		}

		if (prefix != null) {
			this.prefix = prefix;
		}

		if (lastname != null) {
			this.lastname = lastname;
		}

		if (nickname != null) {
			this.nickname = nickname;
		}
		User user = new User(surname, prefix, lastname, nickname);
		model.addUser(user);
		return showAccount();
	}

	@Path("/get")
	@GET
	// @Produces({ MediaType.APPLICATION_XML })
	public ArrayList<User> getParameter(@QueryParam("getUsers") String getUsers) {
		return (ArrayList<User>) model.getUsers();
	}

	public String showAccount() {
		String account = this.surname + " " + this.prefix + " " + this.lastname + " " + this.nickname;
		return account;
	}

	public String getRating(String rating) {
		return rating;
	}
}
