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
import javax.ws.rs.core.Response;

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
			@QueryParam("lastname") String lastname, @QueryParam("nickname") String nickname) {
		Model model = (Model) context.getAttribute("model");
		if (surname != null && !surname.isEmpty()) {
			this.surname = surname;
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		if (prefix != null && !prefix.isEmpty()) {
			this.prefix = prefix;
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		if (lastname != null && !lastname.isEmpty()) {
			this.lastname = lastname;
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		if (nickname != null && !nickname.isEmpty()) {
			if (model.getUserByNickname(nickname) != null) {
				if (model.getUserByNickname(nickname).getNickname().equals(nickname)) {
					return Response.status(Response.Status.CONFLICT).build();
				} else {
					this.nickname = nickname;
				}
			}
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		User user = new User(surname, prefix, lastname, nickname);
		model.addUser(user);
		return Response.status(Response.Status.OK).build();

	}

	@Path("/get")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<User> getUsers(@QueryParam("getUsers") String getUsers) {
		Model model = (Model) context.getAttribute("model");
		List<User> usersList = model.getUsers();
		return usersList;
	}

	public String getRating(String rating) {
		return rating;
	}
}
