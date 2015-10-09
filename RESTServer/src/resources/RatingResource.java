package resources;

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

@Path("/ratings")
public class RatingResource {

	@Context
	ServletContext context;

	@POST
	public void setRating(@QueryParam("rating") String rating, @QueryParam("imdb_id") String imdb_id, @QueryParam("user") String user) {
		Model model = (Model) context.getAttribute("model");
		Movie movie = model.getMovieById(imdb_id);
		User user = model.getUserByName(user);
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Object getParameter(@QueryParam("imdb_id") String imbd_id, @QueryParam("rating") String rating) {
		if (imbd_id != null) {
		}
		if (!rating.equals(34936)) {
			return getRating(rating);
		}

		return "not found";
	}

	public String getRating(String rating) {
		return rating;
	}
}
