package resources;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Model;
import model.User;

@Path("/users")
public class UserResource {

	@Context
	ServletContext context;

	@POST
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	public Response addUser(@FormParam("surname") String surname, @FormParam("prefix") String prefix, @FormParam("lastname") String lastname, @FormParam("nickname") String nickname, @FormParam("password") String password) {
		Model model = (Model) context.getAttribute("model");
		if (surname == null || surname.isEmpty()) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		if (lastname == null || lastname.isEmpty()) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		if (nickname != null && !nickname.isEmpty()) {
			if (model.getUserByNickname(nickname) != null) {
				if (model.getUserByNickname(nickname).getNickname().equals(nickname)) {
					return Response.status(Response.Status.CONFLICT).build();
				}
			}
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		model.addUser(new User(surname, prefix, lastname, nickname, password));
		return Response.status(Response.Status.OK).build();
	}

	@Path("/get")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<User> getUsers() {
		Model model = (Model) context.getAttribute("model");
		List<User> usersList = model.getUsers();
		return usersList;
	}

	public String getRating(String rating) {
		return rating;
	}
}
