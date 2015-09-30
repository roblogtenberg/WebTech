package resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/movies")
public class MovieResource {

	@GET
	public Object getParameter(@QueryParam("name") String name, @QueryParam("title") String title) {
		if(name != null) {
			return getName(name);
		} 
		if(title != null) {
			return getTitle(title);
		}
		
		return "not found";
	}
	public String getName(String name) {
		return name;
	}
	
	public String getTitle(String title) {
		return title;
	}
}
