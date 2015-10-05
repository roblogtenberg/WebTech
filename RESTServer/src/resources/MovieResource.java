package resources;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import model.Movie;

@Path("/movies")
public class MovieResource {

	@Context ServletContext context;
	
	@GET
	@Produces({MediaType.APPLICATION_XML})
	public Object getParameter(@QueryParam("title") String title, @QueryParam("imbd_id") String imbd_id) {
		if(imbd_id != null) {
			return getMovieById(imbd_id);
		} 
		if(title != null) {
			return getTitle(title);
		}
		
		return "not found";
	}
	
	public Movie getMovieById(String id) {
//		Model model = (Model) context.getAttribute("model");
		Movie movie = new Movie(1, "2", "Maze runner", "5-10-2015", 120, "Michael Bay", "description");
		return movie;
	}
	
	public String getTitle(String title) {
		return title;
	}
}
