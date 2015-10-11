import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import model.Model;

@Path("/authentication")
public class Authentication {
	
	private Model model;

	@POST
	@Produces("application/json")
	@Consumes("application/x-www-form-urlencoded")
	public Response authentication(@QueryParam("username") String username, @QueryParam("password") String password) {

		try {

			// Authenticate the user using the credentials provided
			authenticate(username, password);

			// Issue a token for the user
			String token = issueToken(username);

			// Return the token on the response
			return Response.ok(token).build();

		} catch (Exception e) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}

	private void authenticate(String username, String password) throws Exception {
		// Authenticate against a database, LDAP, file or whatever
		// Throw an Exception if the credentials are invalid
	}

	private String issueToken(String username) {
		model = new Model();
		String token = UUID.randomUUID().toString();
		model.getUserByName(username).setToken(token);
		
		// Issue a token (can be a random String persisted to a database or a
		// JWT token)
		// The issued token must be associated to a user
		// Return the issued token
		return token;
	}

}
