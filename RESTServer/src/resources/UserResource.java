package resources;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import model.Model;
import model.User;

@Path("/users")
public class UserResource {

	private String surname;
	private String prefix;
	private String lastname;
	private String nickname;

	@Context
	ServletContext context;

	@POST
	// @Produces({ MediaType.APPLICATION_XML })
	public Object getParameter(@QueryParam("surname") String surname, @QueryParam("prefix") String prefix,
			@QueryParam("lastname") String lastname, @QueryParam("nickname") String nickname, @QueryParam("password") String password) {
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
		User user = new User(surname, prefix, lastname, nickname, password);
		Model model = (Model) context.getAttribute("model");
		model.addUser(user);
		return showAccount();
	}

	@Path("/get")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<User> getUsers(@QueryParam("getUsers") String getUsers) {
		Model model = (Model) context.getAttribute("model");
		List<User> iets = model.getUsers();
		System.out.println(iets.toString());
		return iets;
	}

	public String showAccount() {
		String account = this.surname + " " + this.prefix + " " + this.lastname + " " + this.nickname;
		return account;
	}

	public String getRating(String rating) {
		return rating;
	}
}
