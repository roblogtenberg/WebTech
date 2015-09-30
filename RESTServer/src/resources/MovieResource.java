package resources;

import javax.ws.rs.Path;

@Path("movies")
public class MovieResource {

	private int id;
	private String IMBDcode;
	private String title;
	private String date;
	private int length;
	private String director;
	private String description;
}
