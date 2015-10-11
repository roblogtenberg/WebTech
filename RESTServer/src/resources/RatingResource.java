package resources;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Model;
import model.Movie;
import model.Rating;
import model.User;

@Path("/ratings")
public class RatingResource {

	@Context
	ServletContext context;

	@DELETE
	public Response removeRating(@QueryParam("token") String token, @QueryParam("imdbId") String imdbId) {
		Model model = (Model) context.getAttribute("model");
		User user;

		if (token == null || token.isEmpty()) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}

		if (model.checkToken(token)) {
			user = model.getUserFromToken(token);
		} else {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}

		if (!user.removeRating(imdbId)) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		return Response.status(Response.Status.OK).build();
	}

	@PUT
	public Response changeRating(@QueryParam("token") String token, @QueryParam("imdbId") String imdbId,
			@QueryParam("rating") String rating) {
		Model model = (Model) context.getAttribute("model");
		User user;

		if (token == null || token.isEmpty()) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}

		if (model.checkToken(token)) {
			user = model.getUserFromToken(token);
		} else {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}

		if (!user.changeRating(imdbId, Integer.valueOf(rating))) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		return Response.status(Response.Status.OK).build();
	}

	@POST
	public Response setRating(@QueryParam("rating") String rating, @QueryParam("imdbId") String imdbId,
			@QueryParam("token") String token) {
		Model model = (Model) context.getAttribute("model");
		User user;

		if (token == null || token.isEmpty()) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}

		if (model.checkToken(token)) {
			user = model.getUserFromToken(token);
		} else {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}

		Movie movie = model.getMovieById(imdbId);
		if (movie == null) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		if (Integer.valueOf(rating) < 0.5 || Integer.valueOf(rating) > 5) {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

		user.addRating(new Rating(Integer.valueOf(rating), movie));
		return Response.status(Response.Status.OK).build();
	}

	@Path("/get")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Rating> getRating() {
		Model model = (Model) context.getAttribute("model");
		List<Rating> ratings = model.getRatings();
		return ratings;
	}
}
