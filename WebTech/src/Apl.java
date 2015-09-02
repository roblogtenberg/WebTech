import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Apl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Apl() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.println("test");
	}
}


/*
public class HelloServlet extends HttpServlet {
	 ....
	 public HelloServlet() {
	 super();
	 // TODO Auto-generated constructor stub
	 }
	 protected void doGet(HttpServletRequest request,
	 HttpServletResponse response) throws ServletException, IOException {
	 PrintWriter out = response.getWriter();
	 out.println("<!doctype html\">\n"
	 + "<html>\n"
	 + "<head><title>Hello from Servlet</title></head>\n"
	 + "<body>\n"
	 + "Hello from a Servlet\n"
	 + "</body></html>");
	}
	}
	HttpSe*/