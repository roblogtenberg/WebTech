package resources;

import java.util.UUID;

import javax.servlet.ServletContext;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Model;
import model.User;

@Path("/authentication")
public class Authentication {

	@Context
	ServletContext context;

	@POST
	@Produces({MediaType.TEXT_PLAIN})
	public Response authentication(@QueryParam("nickname") String nickname, @QueryParam("password") String password) {
		try {
			// Authenticate the user using the credentials provided
			authenticate(nickname, password);

			// Issue a token for the user
			String token = issueToken(nickname);

			// Return the token on the response
			return Response.ok(token).build();

		} catch (Exception e) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}

	private void authenticate(String nickname, String password) throws Exception {
		Model model = (Model) context.getAttribute("model");
		User user = model.getUserByNickname(nickname);
		if(user != null) {
			if(!(user.getPassword()).equals(password)) {
				throw new Exception();
			}
		} else {
			throw new Exception();
		}
	}

	private String issueToken(String nickname) {
		Model model = (Model) context.getAttribute("model");
		String token = UUID.randomUUID().toString();
		model.getUserByNickname(nickname).setToken(token);

		return token;
	}

}
