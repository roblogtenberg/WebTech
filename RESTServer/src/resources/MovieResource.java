package resources;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import model.Model;
import model.Movie;

@Path("/movies")
public class MovieResource {

	@Context
	private ServletContext context;

	private Model model;
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Movie getParameter(@QueryParam("title") String title, @QueryParam("imdb_id") String imdb_id) {
		model = (Model) context.getAttribute("model");

		if (imdb_id != null) {
			return model.getMovieById(imdb_id);
		}
		if (title != null) {
			return model.getMovieByTitle(title);
		}

		return null;
	}
}
